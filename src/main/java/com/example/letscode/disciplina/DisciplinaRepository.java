package com.example.letscode.disciplina;

import com.example.letscode.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
    Disciplina findDisciplinaById(Integer id);

    @Query("SELECT d.id FROM Disciplina d WHERE d.nome LIKE %:nome%")
    List<Integer> findIdByNome(@Param("nome") String nome);

    @Query("SELECT d.nome, d.professor.nome FROM Disciplina d WHERE d.professor.id = :id")
    List<String> findDisciplinasByProfessorId(@Param("id") Integer id);
}
