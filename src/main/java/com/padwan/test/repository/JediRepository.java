package com.padwan.test.repository;

import com.padwan.test.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JediRepository extends JpaRepository<Jedi, Long> {

    @Query(value = "SELECT m.nome AS mestreNome, a.nome AS aprendizNome FROM jedi a JOIN jedi m ON a.mentor_id = m.id WHERE m.status = 'Mestre Jedi'", nativeQuery = true)
    List<Object[]> findAllMestresJedisAndApprentices();

    @Query(value = "SELECT * FROM jedi WHERE midichlorians > 9000", nativeQuery = true)
    List<Jedi> findJediWithMidichloriansAbove9000();

    @Query(value = "SELECT status, COUNT(*) AS totalJedis FROM jedi GROUP BY status", nativeQuery = true)
    List<Object[]> countJedisByCategory();
}
