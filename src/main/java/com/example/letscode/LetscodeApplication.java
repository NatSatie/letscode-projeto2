package com.example.letscode;

import com.example.letscode.alternativa.Alternativa;
import com.example.letscode.alternativa.AlternativaRepository;
import com.example.letscode.aluno.Aluno;
import com.example.letscode.aluno.AlunoRepository;
import com.example.letscode.data.BootstrapDataCrud;
import com.example.letscode.disciplina.Disciplina;
import com.example.letscode.disciplina.DisciplinaRepository;
import com.example.letscode.professor.Professor;
import com.example.letscode.professor.ProfessorRepository;
import com.example.letscode.questao.Questao;
import com.example.letscode.questao.QuestaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class LetscodeApplication implements CommandLineRunner {

	private ProfessorRepository professorRepository;
	private DisciplinaRepository disciplinaRepository;
	private QuestaoRepository questaoRepository;
	private AlunoRepository alunoRepository;
	private AlternativaRepository alternativaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LetscodeApplication.class, args);
	}

	@Override
	public void run(String... args)  {

		alunoRepository.save(BootstrapDataCrud.buildAluno());
		List<Aluno> listaAluno = alunoRepository.findByNomeEquals("John Doe");
		Aluno aluno = listaAluno.get(0);
		aluno.setNome("John Doe Cardoso");
		alunoRepository.save(aluno);
		alunoRepository.delete(aluno);

		professorRepository.save(BootstrapDataCrud.buildProfessor());
		List<Professor> listaProfessores = professorRepository.findByNomeEquals("Eugênio");
		Professor professor = listaProfessores.get(0);
		professor.setNome("Eugênio De Souza");
		professorRepository.save(professor);


		disciplinaRepository.save(BootstrapDataCrud.buildDisciplina(professor));
		List<Disciplina> listaDisciplinas = disciplinaRepository.findByNomeEquals("Programação Web");
		Disciplina disciplina = listaDisciplinas.get(0);
		disciplina.setNome("Programação Web Spring");
		disciplinaRepository.save(disciplina);

		questaoRepository.save(BootstrapDataCrud.buildQuestao(disciplina));
		List<Questao>  listaQuestoes = questaoRepository.findQuestaoByEnunciadoEquals("Uma questão muito legal :)");
		Questao questao = listaQuestoes.get(0);
		questao.setEnunciado("Uma questão super legal :D");
		questaoRepository.save(questao);

		alternativaRepository.saveAll(BootstrapDataCrud.buildAlternativas(questao));
		List<Alternativa> listaAlternativas = alternativaRepository.findByDescricaoEquals("Essa é a certa! ^^");
		Alternativa alternativa = listaAlternativas.get(0);
		alternativa.setDescricao("Tenho certeza que essa é a certa! :)");
		alternativaRepository.save(alternativa);
		alternativaRepository.deleteAll(alternativaRepository.findAlternativaByQuestao(questao));
		questaoRepository.delete(questao);
		disciplinaRepository.delete(disciplina);
		professorRepository.delete(professor);








	}
}

