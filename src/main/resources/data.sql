INSERT INTO aluno (nome, matricula, data_nascimento) VALUES ('Carlos Miller', '20220406', '1976-04-17');
INSERT INTO aluno (nome, matricula, data_nascimento) VALUES ('Humayra Coombes', '20220405', '1976-04-17');
INSERT INTO aluno (nome, matricula, data_nascimento) VALUES ('Heidi Gonzalez', '20220407', '1999-12-22');
INSERT INTO aluno (nome, matricula, data_nascimento) VALUES ('Zoe Mueller', '20220408', '1976-11-27');
INSERT INTO aluno (nome, matricula, data_nascimento) VALUES ('Hadiqa Richards', '20220409', '1996-04-15');
INSERT INTO aluno (nome, matricula, data_nascimento) VALUES ('Livia Christensen', '20220410', '1995-01-28');
INSERT INTO aluno (nome, matricula, data_nascimento) VALUES ('Alastair Spencer', '20220411', '1974-09-05');

INSERT INTO professor (nome) VALUES ('Jessé');
INSERT INTO professor (nome) VALUES ('Justine Mcdowell');
INSERT INTO professor (nome) VALUES ('Ahmed Moreno');
INSERT INTO professor (nome) VALUES ('Charity Matthams');

INSERT INTO disciplina (nome, professor_id)
VALUES ('Banco de Dados', 1);

INSERT INTO questao (enunciado, disciplina_id)
VALUES ('Considere a seguinte tabela de um banco de dados relacional: Item (Código, Tipo, Nome, Quantidade) O comando SQL para obter o tipo e o valor médio da quantidade, por tipo de itens, apenas para valores médios superiores a 500, é:',
        1),
       ('Considerando um banco de dados relacional, sobre o conceito de Chave estrangeira, assinale a alternativa correta.',
        1),
       ('Não pode ter valor nulo em uma tabela do banco de dados um campo: ', 1),
       ('Em um banco de dados, uma das principais restrições é a que define que, em uma relação entre duas tabelas, a chave estrangeira que aparece em uma delas deve existir como chave primária na outra, de forma que só será aceito um valor no campo chave estrangeira se esse valor existir no campo chave primária. Tal restrição é conhecida como',
        1),
       ('Em modelagem de dados a cardinalidade é um dos princípios fundamentais sobre relacionamento de um banco de dados relacional. No modelo relacional, podemos ter os seguintes níveis clássicos de relacionamento. Sobre eles, assinale a alternativa incorreta.',
        1),
       ('Um banco de dados baseado em tabelas, entidades e atributos é do tipo:', 1);

INSERT INTO alternativa (descricao, eh_resposta, questao_id)
VALUES ('SELECT Tipo, Quantidade-Média FROM Item HAVING Quantidade-Média > 500;', false, 1),
       ('SELECT Tipo, LIMIT (Quantidade) > 500 FROM Item GROUP BY Tipo', false, 1),
       ('SELECT Tipo, AVG (Quantidade) FROM Item GROUP BY Tipo HAVING AVG (Quantidade) > 500;', true, 1),
       ('SELECT Tipo, MED (Quantidade) FROM Item GROUP BY Tipo WHERE MED (Quantidade) > 500;', false, 1),
       ('SELECT Tipo, MAX - MIN (Quantidade) FROM Item GROUP BY Tipo FOR MAX – MIN (Quantidade) > 500;', false, 1),
       ('Uma coluna contendo uma chave estrangeira não pode ter valores nulos.', false, 2),
       ('Uma tabela não pode ter mais de uma chave estrangeira para outra tabela (mesma tabela de referência).', false,
        2),
       ('Um índice é criado por padrão para cada chave estrangeira.', false, 2),
       ('Uma coluna contendo uma chave estrangeira guarda o endereço de memória da coluna correspondente na tabela referenciada.',
        false, 2),
       ('Uma chave estrangeira pode ser composta por várias colunas.', true, 2);
INSERT INTO alternativa (descricao, eh_resposta, questao_id)
VALUES ('Uma coluna contendo uma chave estrangeira não pode ter valores nulos.', false, 3),
       ('Uma tabela não pode ter mais de uma chave estrangeira para outra tabela (mesma tabela de referência).', false,
        3),
       ('Um índice é criado por padrão para cada chave estrangeira.', false, 3),
       ('Uma coluna contendo uma chave estrangeira guarda o endereço de memória da coluna correspondente na tabela referenciada.',
        false, 3),
       ('Uma chave estrangeira pode ser composta por várias colunas.', true, 3),
       ('integridade da coluna.', false, 4),
       ('integridade referencial.', true, 4),
       ('integridade de herança.', false, 4),
       ('restrição de chave.', false, 4),
       ('1:2', true, 5);
INSERT INTO alternativa (descricao, eh_resposta, questao_id)
VALUES ('N:N', false, 5),
       ('1:N', false, 5),
       ('1:1', false, 5),
       ('Cúbico.', false, 6),
       ('Hierárquico.', false, 6),
       ('Randômico.', false, 6),
       ('NoSql.', false, 6),
       ('Relacional.', true, 6);