package com.example.letscode.data;

import com.example.letscode.alternativa.AlternativaResposta;
import com.example.letscode.alternativa.Alternativa;
import com.example.letscode.alternativa.QuestaoAlternativaResposta;
import com.example.letscode.aluno.Aluno;
import com.example.letscode.disciplina.Disciplina;
import com.example.letscode.professor.Professor;
import com.example.letscode.questao.Questao;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class BootstrapData {
    public static List<Disciplina> buildDisciplina(Professor professorResponsavel) {
        return List.of(
                new Disciplina("Banco de Dados", professorResponsavel)
        );
    }

    public static QuestaoAlternativaTupla buildQuestaoAlternativaBancoDeDados(Disciplina disciplina) {
        List<QuestaoAlternativaResposta> _alternativas = Arrays.asList(
                new QuestaoAlternativaResposta(
                        "Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:",
                        Arrays.asList(
                                new AlternativaResposta("SELECT Tipo, Quantidade-Média FROM Item HAVING Quantidade-Média > 500;", false),
                                new AlternativaResposta("SELECT Tipo, LIMIT (Quantidade) > 500 FROM Item GROUP BY Tipo", false),
                                new AlternativaResposta("SELECT Tipo, AVG (Quantidade) FROM Item GROUP BY Tipo HAVING AVG (Quantidade) > 500;", true),
                                new AlternativaResposta("SELECT Tipo, MED (Quantidade) FROM Item GROUP BY Tipo WHERE MED (Quantidade) > 500;", false),
                                new AlternativaResposta("SELECT Tipo, MAX - MIN (Quantidade) FROM Item GROUP BY Tipo FOR MAX – MIN (Quantidade) > 500;", false)
                        )),
                new QuestaoAlternativaResposta(
                "Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.",
                        Arrays.asList(
                        new AlternativaResposta("Uma coluna contendo uma chave estrangeira não pode ter valores nulos.", false),
                        new AlternativaResposta("Uma tabela não pode ter mais de uma chave estrangeira para outra tabela (mesma tabela de referência).", false),
                        new AlternativaResposta("Um índice é criado por padrão para cada chave estrangeira.", false),
                        new AlternativaResposta("Uma coluna contendo uma chave estrangeira guarda o endereço de memória da coluna correspondente na tabela referenciada.", false),
                        new AlternativaResposta("Uma chave estrangeira pode ser composta por várias colunas.", true)
                )),
                new QuestaoAlternativaResposta(
                "Não pode ter valor nulo em uma tabela do banco de dados um campo: ",
                        Arrays.asList(
                        new AlternativaResposta("Uma coluna contendo uma chave estrangeira não pode ter valores nulos.", false),
                        new AlternativaResposta("Uma tabela não pode ter mais de uma chave estrangeira para outra tabela (mesma tabela de referência).", false),
                        new AlternativaResposta("Um índice é criado por padrão para cada chave estrangeira.", false),
                        new AlternativaResposta("Uma coluna contendo uma chave estrangeira guarda o endereço de memória da coluna correspondente na tabela referenciada.", false),
                        new AlternativaResposta("Uma chave estrangeira pode ser composta por várias colunas.", true)
                )),
                new QuestaoAlternativaResposta(
                        "Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma q",
                        Arrays.asList(
                        new AlternativaResposta("integridade da coluna.",  false),
                        new AlternativaResposta("integridade referencial.", true),
                        new AlternativaResposta("integridade de herança.", false),
                        new AlternativaResposta("restrição de chave.", false)
                )),
                 new QuestaoAlternativaResposta(
                         "Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.",
                         Arrays.asList(
                        new AlternativaResposta("1:2", true),
                        new AlternativaResposta("N:N", false),
                        new AlternativaResposta("1:N", false),
                        new AlternativaResposta("1:1", false)
                         )),
                 new QuestaoAlternativaResposta(
                         "Um banco de dados baseado em tabelas, entidades e atributos é do tipo:",
                        Arrays.asList(
                        new AlternativaResposta("Cúbico.", false),
                        new AlternativaResposta("Hierárquico.", false),
                        new AlternativaResposta("Randômico.", false),
                        new AlternativaResposta("NoSql.", false),
                                new AlternativaResposta("Relacional.", true)
                        )
        ));
        QuestaoAlternativaTupla _res = BootstrapData.buildListQuestaoAlternativa(_alternativas, disciplina);
        return _res;
    }

    private static QuestaoAlternativaTupla buildListQuestaoAlternativa(
            List<QuestaoAlternativaResposta> questaoAlternativaResposta,
            Disciplina disciplina
        ) {

        List<Questao> listaDeQuestoes = new ArrayList<>();
        List<Alternativa> listaDeAlternativas = new ArrayList<>();

        for(int i=0; i<questaoAlternativaResposta.size(); i++){
            String questaoDescricao = questaoAlternativaResposta.get(i).getQuestao();
            Questao _q = new Questao(questaoDescricao, disciplina);
            listaDeQuestoes.add(_q);

            List<AlternativaResposta> listaAlternativaResposta = questaoAlternativaResposta.get(i).getAlternativas();

            for(int j=0; j < listaAlternativaResposta.size(); j++){
                String altDescricao = listaAlternativaResposta.get(j).getDescricao();
                boolean altResposta = listaAlternativaResposta.get(j).isResposta();
                Alternativa _a = new Alternativa(altDescricao, altResposta, _q);
                listaDeAlternativas.add(_a);
            }

        }

        return new QuestaoAlternativaTupla(listaDeQuestoes, listaDeAlternativas);
    }
    public static List<Professor> buildProfessor() {
        return List.of(
                new Professor("Justine Mcdowell"),
                new Professor("Ahmed Moreno"),
                new Professor("Charity Matthams")
        );
    }
    public static List<Aluno> buildAluno() {
        return List.of(
                new Aluno("Humayra Coombes", "20220405", LocalDate.of(1976, 4, 17)),
                new Aluno("Heidi Gonzalez", "20220407", LocalDate.of(1999, 12, 22)),
                new Aluno("Zoe Mueller", "20220408", LocalDate.of(1976, 11, 27)),
                new Aluno("Hadiqa Richards", "20220409", LocalDate.of(1996, 4, 15)),
                new Aluno("Livia Christensen", "20220410", LocalDate.of(1995, 1, 28)),
                new Aluno("Alastair Spencer", "20220411", LocalDate.of(1974, 9, 5))
        );
    }
}









