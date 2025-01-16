package com.padwan.test.repository;

import com.padwan.test.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Integer> {

    @Query(value = "SELECT j.name, j.status, j.mentor, j.midichlorians FROM jedi j", nativeQuery = true)
    List<Object[]> listJedi();

    @Query(value = "SELECT j.name, j.status, j.mentor, j.midichlorians FROM jedi j WHERE j.midichlorians > 9000", nativeQuery = true)
    public List<Object[]> listJediByPower();

    @Query(value = "SELECT j.status, COUNT(*) FROM jedi j GROUP BY j.status", nativeQuery = true)
    public List<Object[]> countJediByStatus();

}
