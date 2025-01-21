package com.padwan.test.repository;

import com.padwan.test.dto.LadoLuzDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LadoLuzRepository extends JpaRepository<LadoLuzDTO,Integer>{

    @Query(value =  "SELECT * FROM lado_luzdto  where midichlorians > :midichlorians", nativeQuery = true)
    List<LadoLuzDTO> findByMidichlorians(@Param("midichlorians") Integer midichlorians);


    List<LadoLuzDTO> findByStatus(@Param("status") String status);

}
