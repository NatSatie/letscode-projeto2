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
		SpringApplication.run(LetscodeApplication.class, args).close();
	}

	@Override
	public void run(String... args)  {
		alunoRepository.save(BootstrapDataCrud.buildAluno());
		List<Aluno> listaAluno = alunoRepository.findByNomeEquals("John Doe");
		Aluno aluno = listaAluno.get(0);
		aluno.setNome("John Doe Cardoso");
		alunoRepository.save(aluno);
		System.out.println("Lista de alunos depois da insercao de John Doe:");
		for (Aluno i : alunoRepository.findAll()){
			System.out.println(i.toString());
		}

		alunoRepository.delete(aluno);
		System.out.println("Lista de alunos depois do delete de John Doe:");
		for (Aluno i : alunoRepository.findAll()){
			System.out.println(i.toString());
		}

		System.out.println("-------------------------------");
		System.out.println("Lista de professores antes da insercao de Eug??nio De Souza:");
		for (Professor i : professorRepository.findAll()){
			System.out.println(i.toString());
		}

		professorRepository.save(BootstrapDataCrud.buildProfessor());
		List<Professor> listaProfessores = professorRepository.findByNomeEquals("Eug??nio");
		Professor professor = listaProfessores.get(0);
		professor.setNome("Eug??nio De Souza");
		professorRepository.save(professor);

		System.out.println("Lista de professores depois da insercao de Eug??nio De Souza:");
		for (Professor i : professorRepository.findAll()){
			System.out.println(i.toString());
		}

		disciplinaRepository.save(BootstrapDataCrud.buildDisciplina(professor));
		List<Disciplina> listaDisciplinas = disciplinaRepository.findByNomeEquals("Programa????o Web");
		Disciplina disciplina = listaDisciplinas.get(0);
		disciplina.setNome("Programa????o Web Spring");
		disciplinaRepository.save(disciplina);

		System.out.println("-------------------------------");
		System.out.println("Lista de disciplinas:");
		for (Disciplina i : disciplinaRepository.findAll()){
			System.out.println(i.toString());
		}

		questaoRepository.save(BootstrapDataCrud.buildQuestao(disciplina));
		List<Questao>  listaQuestoes = questaoRepository.findQuestaoByEnunciadoEquals("Uma quest??o muito legal :)");
		Questao questao = listaQuestoes.get(0);
		questao.setEnunciado("Uma quest??o super legal :D");
		questaoRepository.save(questao);

		System.out.println("-------------------------------");
		System.out.println("Lista de questoes:");
		for (Questao i : questaoRepository.findAll()){
			System.out.println(i.toString());
		}

		alternativaRepository.saveAll(BootstrapDataCrud.buildAlternativas(questao));
		List<Alternativa> listaAlternativas = alternativaRepository.findByDescricaoEquals("Essa ?? a certa! ^^");
		Alternativa alternativa = listaAlternativas.get(0);
		alternativa.setDescricao("Tenho certeza que essa ?? a certa! :)");
		alternativaRepository.save(alternativa);
		System.out.println("-------------------------------");
		System.out.println("Lista de alternativas da questao - Uma quest??o super legal :D");
		System.out.println(alternativaRepository.findAlternativaByQuestao(questao).toString());

		alternativaRepository.deleteAll(alternativaRepository.findAlternativaByQuestao(questao));
		System.out.println("Lista de alternativas da questao depois de deletar - Uma quest??o super legal :D");
		questaoRepository.delete(questao);
		disciplinaRepository.delete(disciplina);
		professorRepository.delete(professor);

		System.out.println("-------------------------------");
		System.out.println("Lista de alternativas:");
		for (Alternativa i : alternativaRepository.findAll()){
			System.out.println(i.toString());
		}
	}
}

