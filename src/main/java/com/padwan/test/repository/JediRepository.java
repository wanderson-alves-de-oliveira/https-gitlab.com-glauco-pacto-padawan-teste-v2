package com.padwan.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.padwan.test.domain.Jedi;
import com.padwan.test.interfaces.IJediStatusCount;

public interface JediRepository extends JpaRepository<Jedi, Long> {

	@Query(value = "SELECT * FROM JEDI WHERE STATUS = 'MESTRE' OR STATUS = 'PADAWAN'", nativeQuery = true)
    List<Jedi> listJediMastersAndApprentices();
	
	@Query(value = "SELECT * FROM JEDI WHERE MIDICHLORIANS > 9.000 AND STATUS <> 'PADAWAN'", nativeQuery = true)
    List<Jedi> listJedisMidichloriansOver9000();
	
	@Query(value = "SELECT STATUS, COUNT(*) FROM JEDI GROUP BY STATUS", nativeQuery = true)
    List<IJediStatusCount> listJediStatusCount();
	

}
