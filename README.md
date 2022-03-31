# Projeto 2 Let's Code

Projeto de banco de dados realizado por:

// adicionar nomes

Tema do projeto: Aplicativo de simulados
Especificações:

Desenvolva um projeto em grupo (tema livre) que aplique todo o conteúdo deste módulo.

- Banco de Dados (defina um modelo de dados consistente com sua aplicação)
- Scripts de inicialização dos dados: defina um arquivo data.sql para realizar os inserts iniciais da aplicação.
- Crie um arquivo README.md explicando o escopo do seu projeto e adicione os diagramas que vier a criar.
- Aplicação Spring usando JPA para comunicar com o banco de dados.
- Seu banco de dados deve definir mais de uma tabela, relacionamentos e constraints.
- Defina pelo menos um CRUD (create-read-update-delete).

# SUMÁRIO

- Como clonar e iniciar o projeto
- [Desenvolvedores] Como endereçar uma issue e criar uma branch
- // TODO Apresentação do Projeto
- // TODO Diagramas e Relações de entidades
- // 

# Como clonar e iniciar o projeto

## Passo 1: Docker

Seguindo o tutorial do Docker do curso Lets code vamos puxar a imagem do container Postgres

```
docker pull postgres
docker run --name letscode-docker -e POSTGRES_PASSWORD=docker -d -p 5416:5432 postgres
```

**Observação 1:** [Nat] Tenho problemas regulares de alguma aplicação do meu docker competir com a porta 5432, por isso eu troco para a porta 5416 para ter certeza que não está tendo competição.

Certifique-se que o docker está ativo na aplicação com `docker ps -a`.

Fazer a conexão com o DBeaver. Lembre-se que o usuário padrão é `postgres` e a senha foi definida logo acima.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/dbeaver_oyovI9pG5u.png)

**Observação 2:** fiz algumas oprações no DBeaver e não atualizou que criei as tabelas... 😢 Usem o botão refresh regularmente.🔄🔄🔄🔄

Em `src\main\resources\application.properties` já deve estar configurado para rodar o projeto conectado ao banco de dados.

No IntelliJ será necessário substituir o `run` da aplicação em configurações usando `spring-boot::run`. A imagem abaixo é reciclagem de um dos tutoriais que eu fiz.

![]https://raw.githubusercontent.com/NatSatie/StudyNotes/main/letsCode/setupMavenRun.png()
 
# [Desenvolvedores] Como endereçar uma issue e criar uma branch

Faça login no Github e ver o [esse link](https://github.com/NatSatie/letscode-projeto2/projects/1). Temos 5 colunas no projeto

- A desenvolver
- em desenvolvimento
- auditoria: serve para testar o código e revisar
- pronto
- tutorial: amostras de cards de projeto para usar de referência

Veja se sua tarefa está associada a um dos cards. Caso não esteja, use o botão + para adicionar um card novo e e escreva as especificações de sua tarefa.

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

Finalmente tudo comitado e feito podemos fazer o nosso PR. como podemos ver no Github Desktop e no Github, jé temos uma notificação de soltar um PR.

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo6.png)

![](https://raw.githubusercontent.com/NatSatie/letscode-projeto2/main/img/passo7.png)


// Terminar tutorial
