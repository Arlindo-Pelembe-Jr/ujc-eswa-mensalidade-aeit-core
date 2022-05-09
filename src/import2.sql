use mensalidade_db;

INSERT
INTO departamento (nome_departamento)
VALUES ('FCT'); 

INSERT 
INTO curso (nome_curso)
VALUES ('ETSI');

INSERT 
INTO curso (nome_curso)
VALUES ('AP'),('RI');

INSERT 
INTO estudante (nome,cod_estudante,curso_curso_codigo) 
VALUES('Edwina',100,1),('Teofilo',101,1),('Israel',102,1);
-- UPDATE 
-- curso 
-- SET id_departamento = 1


insert into funcionario (data_ingresso_funcionario) values('2020-04-02');

insert into disciplina (disc_credito,disc_nome,estatuto) values (4,'SAG',' ');

insert into inscricao (cod_inscricao,estudante_id,disciplina_id) values(1,1,1);


insert into disciplina(id_disciplina, disc_credito, disc_nome, estatuto, ano)
values(801, 3, "introducao a informatica", "nuclear", 1),
(802, 4, "Fundamentos de informatica", "nuclear", 1),
(803, 4, "redes de computadores", "nuclear", 2),
(804, 4, "analise matematica I", "complementar", 1 ),
(805, 3, "gestao de empresas", "complementar", 1),
(806, 4, "Engenharia de software", "nuclear", 3),
(807, 4, "Sistemas distribuidos", "nuclear", 3),
(808,4, "analise e desenho orientado a objectos", "nuclear", 3),
(809,4, "Gestao de sistemas de informacao","nuclear", 3 ),
(810, 4, "programacao web", "nuclear", 2);
select *from disciplina;

select *from curso;

insert into curso_disciplinas(curso_curso_codigo, disciplinas_id_disciplina)
values(1, 801),
(1,802),
(1, 803),
(1, 804),
(1, 805),
(1, 806),
(1, 807),
(1, 808),
(1, 809),
(1, 810);
select disciplina.disc_nome, disciplina.ano, curso.nome_curso from disciplina join curso_disciplinas on id_disciplina=disciplinas_id_disciplina join curso on 
curso_codigo= curso_curso_codigo;





