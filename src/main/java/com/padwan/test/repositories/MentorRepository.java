package com.padwan.test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.padwan.test.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

    @Query(value = "SELECT * FROM Mentor", nativeQuery = true)
    List<Mentor> findAllMentores();



    @Query(value = "Select * FROM mentor WHERE nome = :nome", nativeQuery = true)
    Mentor findByNomeMentor(@Param("nome") String nome);


}
