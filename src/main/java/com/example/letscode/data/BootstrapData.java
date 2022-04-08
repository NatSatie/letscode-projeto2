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
                        )
                )
        );
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
                new Professor("Jessé"));
    }
    public static List<Aluno> buildAluno() {
        return List.of(
                new Aluno("Carlos Miller", "20220406", LocalDate.of(1976, 04, 17))
        );
    }
}









