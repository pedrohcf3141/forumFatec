INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@fatec.sp.gov.br', '123');

INSERT INTO MATERIA(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO MATERIA(nome, categoria) VALUES('TO DO VERBS', 'Linguas');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, materia_id) VALUES('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, materia_id) VALUES('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, materia_id) VALUES('Dúvida 3', 'Configurar o pom.xml', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1,1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, materia_id) VALUES('Dúvida 4', 'Conjugar o verbo to be no passado', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1,2);