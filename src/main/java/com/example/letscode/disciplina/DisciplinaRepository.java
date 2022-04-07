package com.example.letscode.disciplina;

import com.example.letscode.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
    Disciplina findDisciplinaById(Integer id);
}
