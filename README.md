# Projeto 3 - Let's Code

## Autores

Projeto de banco de dados realizado por:

- Carlos Masao Mito
- Caroline Fernanda Bezerra de Oliveira
- João Vitor de Paula Pereira
- Marcos Roberto Franciosi
- Natália Satie Odashima
- Pedro Otávio Freiman Blaudt

**Tema do projeto:** Aplicativo de simulados.

## Especificações

Desenvolva um projeto em grupo (tema livre) que aplique todo o conteúdo deste módulo.

- Banco de Dados (defina um modelo de dados consistente com sua aplicação)
- Scripts de inicialização dos dados: defina um arquivo `data.sql` para realizar os *inserts* iniciais da aplicação.
- Crie um arquivo `README.md` explicando o escopo do seu projeto e adicione os diagramas que vier a criar.
- Aplicação Spring usando JPA para comunicar com o banco de dados.
- Seu banco de dados deve definir mais de uma tabela, relacionamentos e *constraints*.
- Defina pelo menos um CRUD (create-read-update-delete).

- - -

# SUMÁRIO

1. [Apresentação do projeto](#apresentação-do-projeto)
2. [Diagramas e relações de entidades](#diagramas-e-relações-de-entidades)
3. [Como clonar e iniciar o projeto](#como-clonar-e-iniciar-o-projeto)
4. [Desenvolvedores] [Como endereçar uma issue e criar uma branch](#como-endereçar-uma-issue-e-criar-uma-branch)
5. [Demonstração] [#demonstração)


# Apresentação do projeto

O objetivo do projeto proposto é auxiliar os professores na aplicação de provas para seus alunos. Os estudantes irão se inscrever em diferentes disciplinas, essas por sua vez serão ministradas por um único docente. Vale ressaltar que um professor pode gerenciar mais de uma matéria.

O professor de cada disciplina será responsável por inserir as questões relacionadas no banco de dados. Cada simulado terá 5 questões escolhidas aleatoriamente de uma única matéria. Além disso, será mantido um histórico dos simulados realizados pelos alunos referentes às disciplinas inscritas.

# Diagramas e relações de entidades

Abaixo estão alguns diagramas representando o banco de dados modelado.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/12-apresentação-da-aplicação-no-readmemd/img/diagram1.png)
![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/12-apresentação-da-aplicação-no-readmemd/img/diagram2.png)

### Entidades

- **Aluno:** entidade que representa um aluno no sistema;
- **Professor:** entidade que representa um professor no sistema;
- **Disciplina:** tabela contendo as disciplinas cadastradas no sistema. Cada disciplina terá um professor responsável;
- **Questão:** tabela contendo as questões cadastradas pelo professor. As questões deverão estar relacionadas a somente 1 disciplina;
- **Alternativa:** entidade responsável por armazenar as alternativas de uma questão. A alternativa possui o atributo `eh_resposta` que irá indicar se a mesma é uma alternativa correta ou não;
- **Histórico:** entidade que irá guardar o desempenho do aluno em determinada disciplina. A coluna `percentual_acerto` armazenará a quantidade de acerto em porcentagem.

# Como clonar e iniciar o projeto

## Passo 1: Docker

Seguindo o tutorial do Docker do curso Let's Code, primeiro precisamos puxar a imagem oficial do Postgres, e em seguida, subir o seu *container*. Para isso, basta rodar os comandos abaixo:

```
docker pull postgres
docker run --name letscode-docker -e POSTGRES_PASSWORD=docker -d -p 5416:5432 postgres
```

**Observação 1:** [Nat] Tenho problemas regulares de alguma aplicação do meu docker competir com a porta 5432, por isso eu troco para a porta 5416 para ter certeza que não está tendo competição.

Certifique-se que o docker está ativo na aplicação com `docker ps`.


## Passo 2: Fazer a conexão com o DBeaver

Lembre-se que o usuário padrão é `postgres` e a senha foi definida logo acima.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/dbeaver_oyovI9pG5u.png)

**Observação 2:** [Nat] Fiz algumas operações no DBeaver e não atualizou que criei as tabelas... 😢 Usem o botão refresh regularmente.🔄🔄🔄🔄

## Passo 3: Rodar a aplicação pelo IntelliJ

Em `src\main\resources\application.properties` já deve estar configurado para rodar o projeto conectado ao banco de dados.

No IntelliJ será necessário substituir o `run` da aplicação em configurações usando `spring-boot::run`. A imagem abaixo é reciclagem de um dos tutoriais que eu fiz.

![](https://raw.githubusercontent.com/NatSatie/StudyNotes/main/letsCode/setupMavenRun.png)











# Como endereçar uma issue e criar uma branch

Faça login no Github e acesse [esse link](https://github.com/NatSatie/letscode-projeto2/projects/1). Temos 5 colunas no projeto:

- **A desenvolver:** backlog de atividades a serem desenvolvidas;
- **Em desenvolvimento:** tarefas que estão em desenvolvimento;
- **Auditoria:** serve para testar o código e revisar as alterações;
- **Pronto:** pilha com as atividades finalizadas;
- **Tutorial / Observações:** amostras de cards de projeto para usar de referência.

Veja se sua tarefa está associada a um dos cards. Caso não esteja, use o botão `+` para adicionar um card novo e escreva as especificações de sua tarefa.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo1.gif)

Lembre-se de associar ao projeto principal `letscode-project2`.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo2.gif)

Ao clicar na issue feita, podemos criar uma issue no projeto, ao observar no popup lateral direito. Nele podemos colocar pessoas responsáveis, tags ou rótulos e designar issues no projeto.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo3.gif)

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo4.gif)

Uma vez criado a issue associada ao projeto, podemos criar uma branch para resolvê-la.

### Após o desenvolvimento

Vamos commitar todas nossas alterações e dar push no Github, certifique-se que fez na branch da issue!

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo5.gif)

### Crie o PR

Finalmente tudo comitado e feito podemos fazer o nosso PR. como podemos ver no Github Desktop e no Github, já temos uma notificação de soltar um PR.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo6.png)

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo7.png)

# Demonstração

Nesse projeto, ao executá-lo é esperado que ele comece e termine como segue as configurações do `application.properties`.

Espera-se que além das mensagens de debug do Spring tenham os seguintes `println`

```
Lista de alunos depois da insercao de John Doe:
Aluno Carlos Miller; id: 1; matricula: 20220406
nascido em 1976-04-17

Aluno Humayra Coombes; id: 2; matricula: 20220405
nascido em 1976-04-17

Aluno Heidi Gonzalez; id: 3; matricula: 20220407
nascido em 1999-12-22

Aluno Zoe Mueller; id: 4; matricula: 20220408
nascido em 1976-11-27

Aluno Hadiqa Richards; id: 5; matricula: 20220409
nascido em 1996-04-15

Aluno Livia Christensen; id: 6; matricula: 20220410
nascido em 1995-01-28

Aluno Alastair Spencer; id: 7; matricula: 20220411
nascido em 1974-09-05

Aluno John Doe Cardoso; id: 8; matricula: 20010020
nascido em 1968-05-05

Lista de alunos depois do delete de John Doe:
Aluno Carlos Miller; id: 1; matricula: 20220406
nascido em 1976-04-17

Aluno Humayra Coombes; id: 2; matricula: 20220405
nascido em 1976-04-17

Aluno Heidi Gonzalez; id: 3; matricula: 20220407
nascido em 1999-12-22

Aluno Zoe Mueller; id: 4; matricula: 20220408
nascido em 1976-11-27

Aluno Hadiqa Richards; id: 5; matricula: 20220409
nascido em 1996-04-15

Aluno Livia Christensen; id: 6; matricula: 20220410
nascido em 1995-01-28

Aluno Alastair Spencer; id: 7; matricula: 20220411
nascido em 1974-09-05

-------------------------------
Lista de professores antes da insercao de Eugênio De Souza:
Professor(id=1, nome=Jessé)
Professor(id=2, nome=Justine Mcdowell)
Professor(id=3, nome=Ahmed Moreno)
Professor(id=4, nome=Charity Matthams)
Professor(id=5, nome=Eugênio De Souza)
Lista de professores depois da insercao de Eugênio De Souza:
Professor(id=1, nome=Jessé)
Professor(id=2, nome=Justine Mcdowell)
Professor(id=3, nome=Ahmed Moreno)
Professor(id=4, nome=Charity Matthams)
Professor(id=5, nome=Eugênio De Souza)
-------------------------------
Lista de disciplinas:
Disciplina Banco de Dados; id: 1
Professor responsavel Jessé

Disciplina Programação Web Spring; id: 2
Professor responsavel Eugênio De Souza

-------------------------------
Lista de questoes:
Questao 1 da disciplina Banco de Dados
Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:

Questao 2 da disciplina Banco de Dados
Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.

Questao 3 da disciplina Banco de Dados
Não pode ter valor nulo em uma tabela do banco de dados um campo: 

Questao 4 da disciplina Banco de Dados
Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma que só será aceito um valor no campo chave estrangeira se esse valor existir no campo chave primária. Tal restrição é conhecida como

Questao 5 da disciplina Banco de Dados
Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.

Questao 6 da disciplina Banco de Dados
Um banco de dados baseado em tabelas, entidades e atributos é do tipo:

Questao 7 da disciplina Programação Web Spring
Uma questão super legal :D

-------------------------------
Lista de alternativas da questao - Uma questão super legal :D
[Alternativa(id=29, descricao=Hmmn, essa alternativa é falsa :/, ehResposta=false, questao=Questao 7 da disciplina Programação Web Spring
Uma questão super legal :D
), Alternativa(id=30, descricao=Essa também!, ehResposta=false, questao=Questao 7 da disciplina Programação Web Spring
Uma questão super legal :D
), Alternativa(id=32, descricao=Tá errado!, ehResposta=false, questao=Questao 7 da disciplina Programação Web Spring
Uma questão super legal :D
), Alternativa(id=31, descricao=Tenho certeza que essa é a certa! :), ehResposta=true, questao=Questao 7 da disciplina Programação Web Spring
Uma questão super legal :D
)]
Lista de alternativas da questao depois de deletar - Uma questão super legal :D
-------------------------------
Lista de alternativas:
Alternativa(id=1, descricao=SELECT Tipo, Quantidade-Média FROM Item HAVING Quantidade-Média > 500;, ehResposta=false, questao=Questao 1 da disciplina Banco de Dados
Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:
)
Alternativa(id=2, descricao=SELECT Tipo, LIMIT (Quantidade) > 500 FROM Item GROUP BY Tipo, ehResposta=false, questao=Questao 1 da disciplina Banco de Dados
Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:
)
Alternativa(id=3, descricao=SELECT Tipo, AVG (Quantidade) FROM Item GROUP BY Tipo HAVING AVG (Quantidade) > 500;, ehResposta=true, questao=Questao 1 da disciplina Banco de Dados
Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:
)
Alternativa(id=4, descricao=SELECT Tipo, MED (Quantidade) FROM Item GROUP BY Tipo WHERE MED (Quantidade) > 500;, ehResposta=false, questao=Questao 1 da disciplina Banco de Dados
Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:
)
Alternativa(id=5, descricao=SELECT Tipo, MAX - MIN (Quantidade) FROM Item GROUP BY Tipo FOR MAX – MIN (Quantidade) > 500;, ehResposta=false, questao=Questao 1 da disciplina Banco de Dados
Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:
)
Alternativa(id=6, descricao=Uma coluna contendo uma chave estrangeira não pode ter valores nulos., ehResposta=false, questao=Questao 2 da disciplina Banco de Dados
Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.
)
Alternativa(id=7, descricao=Uma tabela não pode ter mais de uma chave estrangeira para outra tabela (mesma tabela de referência)., ehResposta=false, questao=Questao 2 da disciplina Banco de Dados
Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.
)
Alternativa(id=8, descricao=Um índice é criado por padrão para cada chave estrangeira., ehResposta=false, questao=Questao 2 da disciplina Banco de Dados
Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.
)
Alternativa(id=9, descricao=Uma coluna contendo uma chave estrangeira guarda o endereço de memória da coluna correspondente na tabela referenciada., ehResposta=false, questao=Questao 2 da disciplina Banco de Dados
Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.
)
Alternativa(id=10, descricao=Uma chave estrangeira pode ser composta por várias colunas., ehResposta=true, questao=Questao 2 da disciplina Banco de Dados
Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.
)
Alternativa(id=11, descricao=Uma coluna contendo uma chave estrangeira não pode ter valores nulos., ehResposta=false, questao=Questao 3 da disciplina Banco de Dados
Não pode ter valor nulo em uma tabela do banco de dados um campo: 
)
Alternativa(id=12, descricao=Uma tabela não pode ter mais de uma chave estrangeira para outra tabela (mesma tabela de referência)., ehResposta=false, questao=Questao 3 da disciplina Banco de Dados
Não pode ter valor nulo em uma tabela do banco de dados um campo: 
)
Alternativa(id=13, descricao=Um índice é criado por padrão para cada chave estrangeira., ehResposta=false, questao=Questao 3 da disciplina Banco de Dados
Não pode ter valor nulo em uma tabela do banco de dados um campo: 
)
Alternativa(id=14, descricao=Uma coluna contendo uma chave estrangeira guarda o endereço de memória da coluna correspondente na tabela referenciada., ehResposta=false, questao=Questao 3 da disciplina Banco de Dados
Não pode ter valor nulo em uma tabela do banco de dados um campo: 
)
Alternativa(id=15, descricao=Uma chave estrangeira pode ser composta por várias colunas., ehResposta=true, questao=Questao 3 da disciplina Banco de Dados
Não pode ter valor nulo em uma tabela do banco de dados um campo: 
)
Alternativa(id=16, descricao=integridade da coluna., ehResposta=false, questao=Questao 4 da disciplina Banco de Dados
Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma que só será aceito um valor no campo chave estrangeira se esse valor existir no campo chave primária. Tal restrição é conhecida como
)
Alternativa(id=17, descricao=integridade referencial., ehResposta=true, questao=Questao 4 da disciplina Banco de Dados
Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma que só será aceito um valor no campo chave estrangeira se esse valor existir no campo chave primária. Tal restrição é conhecida como
)
Alternativa(id=18, descricao=integridade de herança., ehResposta=false, questao=Questao 4 da disciplina Banco de Dados
Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma que só será aceito um valor no campo chave estrangeira se esse valor existir no campo chave primária. Tal restrição é conhecida como
)
Alternativa(id=19, descricao=restrição de chave., ehResposta=false, questao=Questao 4 da disciplina Banco de Dados
Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma que só será aceito um valor no campo chave estrangeira se esse valor existir no campo chave primária. Tal restrição é conhecida como
)
Alternativa(id=20, descricao=1:2, ehResposta=true, questao=Questao 5 da disciplina Banco de Dados
Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.
)
Alternativa(id=21, descricao=N:N, ehResposta=false, questao=Questao 5 da disciplina Banco de Dados
Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.
)
Alternativa(id=22, descricao=1:N, ehResposta=false, questao=Questao 5 da disciplina Banco de Dados
Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.
)
Alternativa(id=23, descricao=1:1, ehResposta=false, questao=Questao 5 da disciplina Banco de Dados
Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.
)
Alternativa(id=24, descricao=Cúbico., ehResposta=false, questao=Questao 6 da disciplina Banco de Dados
Um banco de dados baseado em tabelas, entidades e atributos é do tipo:
)
Alternativa(id=25, descricao=Hierárquico., ehResposta=false, questao=Questao 6 da disciplina Banco de Dados
Um banco de dados baseado em tabelas, entidades e atributos é do tipo:
)
Alternativa(id=26, descricao=Randômico., ehResposta=false, questao=Questao 6 da disciplina Banco de Dados
Um banco de dados baseado em tabelas, entidades e atributos é do tipo:
)
Alternativa(id=27, descricao=NoSql., ehResposta=false, questao=Questao 6 da disciplina Banco de Dados
Um banco de dados baseado em tabelas, entidades e atributos é do tipo:
)
Alternativa(id=28, descricao=Relacional., ehResposta=true, questao=Questao 6 da disciplina Banco de Dados
Um banco de dados baseado em tabelas, entidades e atributos é do tipo:
)
```

Esse resultado vem da função `run` do `LetscodeApplication`, no qual tem alguns testes que fazem a instância do objeto e fazem modificação e delete dos objetos no repositório.
