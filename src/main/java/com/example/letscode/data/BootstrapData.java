package com.example.letscode.data;

import com.example.letscode.alternativa.Alternativa;
import com.example.letscode.aluno.Aluno;
import com.example.letscode.disciplina.Disciplina;
import com.example.letscode.disciplina.DisciplinaRepository;
import com.example.letscode.professor.Professor;
import com.example.letscode.professor.ProfessorRepository;
import com.example.letscode.questao.Questao;
import com.example.letscode.questao.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class BootstrapData {

    @Autowired
    static ProfessorRepository professorRepository;
    @Autowired
    static DisciplinaRepository disciplinaRepository;
    @Autowired
    static QuestaoRepository questaoRepository;

    public static List<Disciplina> buildDisciplina() {
        return List.of(
                new Disciplina("Banco de Dados", professorRepository.findProfessorById(1)));
    }
    public static List<Questao> buildQuestao() {
        return List.of(
                new Questao("Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:", disciplinaRepository.findDisciplinaById(1)),
                new Questao("Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.", disciplinaRepository.findDisciplinaById(1)),
                new Questao("Não pode ter valor nulo em uma tabela do banco de dados um campo: ", disciplinaRepository.findDisciplinaById(1)),
                new Questao("Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma que só será aceito um valor no campo chave estrangeira se esse valor existir no campo chave primária. Tal restrição é conhecida como", disciplinaRepository.findDisciplinaById(1)),
                new Questao("Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.", disciplinaRepository.findDisciplinaById(1)),
                new Questao("Um banco de dados baseado em tabelas, entidades e atributos é do tipo:", disciplinaRepository.findDisciplinaById(1)));
    }
    public static List<Alternativa> buildAlternativa() {
        return List.of(
                new Alternativa("SELECT Tipo, Quantidade-Média FROM Item HAVING Quantidade-Média > 500;", false, questaoRepository.findQuestaoById(1)),
                new Alternativa("SELECT Tipo, LIMIT (Quantidade) > 500 FROM Item GROUP BY Tipo", false, questaoRepository.findQuestaoById(1)),
                new Alternativa("SELECT Tipo, AVG (Quantidade) FROM Item GROUP BY Tipo HAVING AVG (Quantidade) > 500;", true, questaoRepository.findQuestaoById(1)),
                new Alternativa("SELECT Tipo, MED (Quantidade) FROM Item GROUP BY Tipo WHERE MED (Quantidade) > 500;", false, questaoRepository.findQuestaoById(1)),
                new Alternativa("SELECT Tipo, MAX - MIN (Quantidade) FROM Item GROUP BY Tipo FOR MAX – MIN (Quantidade) > 500;", false, questaoRepository.findQuestaoById(1)),
                new Alternativa("Uma coluna contendo uma chave estrangeira não pode ter valores nulos.", false, questaoRepository.findQuestaoById(2)),
                new Alternativa("Uma tabela não pode ter mais de uma chave estrangeira para outra tabela (mesma tabela de referência).", false, questaoRepository.findQuestaoById(2)),
                new Alternativa("Um índice é criado por padrão para cada chave estrangeira.", false, questaoRepository.findQuestaoById(2)),
                new Alternativa("Uma coluna contendo uma chave estrangeira guarda o endereço de memória da coluna correspondente na tabela referenciada.", false, questaoRepository.findQuestaoById(2)),
                new Alternativa("Uma chave estrangeira pode ser composta por várias colunas.", true, questaoRepository.findQuestaoById(2)),
                new Alternativa("que seja chave estrangeira.", false, questaoRepository.findQuestaoById(3)),
                new Alternativa("que tenha sido utilizado em um índice.", false, questaoRepository.findQuestaoById(3)),
                new Alternativa("que seja chave primária.", true, questaoRepository.findQuestaoById(3)),
                new Alternativa("que represente uma data de nascimento.", false, questaoRepository.findQuestaoById(3)),
                new Alternativa("integridade da coluna.", false, questaoRepository.findQuestaoById(4)),
                new Alternativa("integridade referencial.", true, questaoRepository.findQuestaoById(4)),
                new Alternativa("integridade de herança.", false, questaoRepository.findQuestaoById(4)),
                new Alternativa("restrição de chave.", false, questaoRepository.findQuestaoById(4)),
                new Alternativa("1:2", true, questaoRepository.findQuestaoById(5)),
                new Alternativa("N:N", false, questaoRepository.findQuestaoById(5)),
                new Alternativa("1:N", false, questaoRepository.findQuestaoById(5)),
                new Alternativa("1:1", false, questaoRepository.findQuestaoById(5)),
                new Alternativa("Cúbico.", false, questaoRepository.findQuestaoById(6)),
                new Alternativa("Hierárquico.", false, questaoRepository.findQuestaoById(6)),
                new Alternativa("Randômico.", false, questaoRepository.findQuestaoById(6)),
                new Alternativa("NoSql.", false, questaoRepository.findQuestaoById(6)),
                new Alternativa("Relacional.", true, questaoRepository.findQuestaoById(6)));
    }
    public static List<Professor> buildProfessor() {
        return List.of(
                new Professor("Jessé"));
    }
    public static List<Aluno> buildAluno() {
        return List.of(
                new Aluno("Carlos Miller", "20220406", LocalDate.of(1976, 04, 17))
        );
    }
}









