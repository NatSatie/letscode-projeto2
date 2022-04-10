package com.example.letscode.data;

import com.example.letscode.alternativa.Alternativa;
import com.example.letscode.aluno.Aluno;
import com.example.letscode.disciplina.Disciplina;
import com.example.letscode.professor.Professor;
import com.example.letscode.questao.Questao;

import java.time.LocalDate;
import java.util.List;

public class BootstrapDataCrud {
    public static Professor buildProfessor(){
        return new Professor("Eugênio");
    }

    public static Aluno buildAluno(){
        return new Aluno("John Doe", "20010020", LocalDate.of(1968, 5, 5));
    }

    public static Disciplina buildDisciplina(Professor professorResponsavel){
        return new Disciplina("Programação Web", professorResponsavel);
    }

    public static Questao buildQuestao(Disciplina disciplina){
        return new Questao("Uma questão muito legal :)", disciplina);
    }

    public static List<Alternativa> buildAlternativas(Questao questao){
        return List.of(
                new Alternativa("Hmmn, essa alternativa é falsa :/",false, questao),
                new Alternativa("Essa também!",false, questao),
                new Alternativa("Essa é a certa! ^^",true, questao),
                new Alternativa("Tá errado!",false, questao)
        );
    }

}
