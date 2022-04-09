package com.example.letscode.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    Aluno findAlunoById(Integer id);

    @Query("SELECT a.id FROM Aluno a WHERE a.nome LIKE %:nome%")
    List<Integer> findIdByNome(@Param("nome") String nome);

    @Query("SELECT a.nome FROM Aluno a WHERE a.id = :id")
    String findNomeById(@Param("id") Integer id);
}
