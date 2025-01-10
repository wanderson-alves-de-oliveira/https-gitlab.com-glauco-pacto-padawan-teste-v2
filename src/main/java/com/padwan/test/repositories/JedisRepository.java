package com.padwan.test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.padwan.test.entity.Jedi;
import com.padwan.test.entity.Mentor;


@Repository
public interface JedisRepository extends JpaRepository<Jedi, Long> {

    @Query(value = "SELECT * FROM Jedi", nativeQuery = true)
    List<Jedi> findAllJedis();


}