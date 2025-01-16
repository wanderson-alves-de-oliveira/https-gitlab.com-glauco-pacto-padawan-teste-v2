package com.padwan.test.repository;

import com.padwan.test.entity.JediEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends JpaRepository<JediEntity, Long> {
	
	
	@Query(value = "SELECT m.name AS mentor, p.name AS apprentice" +
            "FROM jedis AS m " +
            "JOIN jedis AS p " +
            "ON m.name = p.mentor " +
            "WHERE m.status = 'mestre jedi' " +
            "ORDER BY m.name", 
    nativeQuery = true)
	List<Object[]> findMastersAndApprentices();
    
    @Query(value = "SELECT * FROM jedis WHERE midichlorians > 9000", nativeQuery = true)
    List<JediEntity> findJedisAboveMidichlorians();

    @Query(value = "SELECT status, COUNT(*) AS total FROM jedis GROUP BY status", nativeQuery = true)
    List<Object[]> countJedisByCategory();
}
