package com.example.letscode.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    Professor findProfessorById(Integer id);

    @Query("SELECT p.id FROM Professor p WHERE p.nome LIKE %:nome%")
    List<Integer> findIdByNome(@Param("nome") String nome);
}
