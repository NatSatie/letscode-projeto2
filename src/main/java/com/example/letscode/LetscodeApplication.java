package com.example.letscode;

import com.example.letscode.alternativa.AlternativaRepository;
import com.example.letscode.aluno.Aluno;
import com.example.letscode.aluno.AlunoRepository;
import com.example.letscode.data.BootstrapData;
import com.example.letscode.data.QuestaoAlternativaTupla;
import com.example.letscode.disciplina.Disciplina;
import com.example.letscode.disciplina.DisciplinaRepository;
import com.example.letscode.professor.Professor;
import com.example.letscode.professor.ProfessorRepository;
import com.example.letscode.questao.QuestaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class LetscodeApplication implements CommandLineRunner {

	private  ProfessorRepository professorRepository;
	private  DisciplinaRepository disciplinaRepository;
	private  QuestaoRepository questaoRepository;
	private  AlunoRepository alunoRepository;
	private  AlternativaRepository alternativaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LetscodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Aluno> listaAluno = BootstrapData.buildAluno();
		System.out.println(listaAluno);
		alunoRepository.saveAll(listaAluno);
		List<Professor> listaProfessor = BootstrapData.buildProfessor();
		professorRepository.saveAll(listaProfessor);
		List<Disciplina> listaDisciplina = BootstrapData.buildDisciplina(professorRepository.findProfessorById(1));
		disciplinaRepository.saveAll(listaDisciplina);
		QuestaoAlternativaTupla tupla = BootstrapData.buildQuestaoAlternativaBancoDeDados(disciplinaRepository.findDisciplinaById(1));
		questaoRepository.saveAll(tupla.getListaQuestao());
		alternativaRepository.saveAll(tupla.getListaAlternativa());
	}
}

