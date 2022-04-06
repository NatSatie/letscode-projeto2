create table aluno (
	id int not null generated always as identity,
	nome varchar(50) not null,
	matricula varchar(10) not null,
	data_nascimento date not null,
	constraint aluno_pk primary key (id)
);

create table professor (
	id int not null generated always as identity,
	nome varchar(50) not null,
	constraint professor_pk primary key (id)
);

create table disciplina (
	id int not null generated always as identity,
	nome varchar(50) not null,
	professor_id int not null,
	constraint professor_fk foreign key (professor_id) references professor(id),
	constraint disciplina_pk primary key (id)
);


create table questao (
	id int not null generated always as identity,
	enunciado text not null,
	disciplina_id int not null,
	constraint disciplina_fk foreign key (disciplina_id) references disciplina(id),
	constraint questao_pk primary key (id)
);

create table alternativa (
	id int not null generated always as identity,
	descricao varchar(50) not null,
	eh_resposta boolean not null,
	questao_id int not null,
	constraint questao_fk foreign key (questao_id) references questao(id),
	constraint altenativa_pk primary key (id)
);

create table historico (
	id int not null generated always as identity,
	percentual_acerto decimal(2) not null,
	disciplina_id int not null,
	aluno_id int not null,
	constraint disciplina_fk foreign key (disciplina_id) references disciplina(id),
	constraint aluno_fk foreign key (aluno_id) references aluno(id),
	constraint historico_pk primary key (id)
);


