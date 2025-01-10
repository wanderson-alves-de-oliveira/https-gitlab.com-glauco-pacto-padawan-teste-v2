package com.padwan.test.repository;

import com.padwan.test.dto.Padawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface PadawanRepository extends JpaRepository<Padawan, Long> {
    Padawan findByName(String name);
      
    @Query(value = "SELECT * FROM padawan p WHERE p.mentor IS NOT NULL", nativeQuery = true)
    List<Padawan> listarMestresEAprendizes();

    @Query(value = "SELECT * FROM Padawan WHERE midichlorians > 9000", nativeQuery = true)
    List<Padawan> listarJedisComMidichloriansAcimaDe9000();

    @Query(value = "SELECT status, COUNT(*) AS quantidade FROM padawan GROUP BY status", nativeQuery = true)
    List<Object[]> contarJedisPorCategoria();
}
