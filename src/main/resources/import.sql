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