use mensalidade_db;

INSERT
INTO departamento (nome_departamento)
VALUES ('FCT'); 

INSERT 
INTO curso (nome_curso,id_departamento)
VALUES ('ETSI',1);

INSERT 
INTO curso (nome_curso,id_departamento)
VALUES ('AP',1),('RI',1);

INSERT 
INTO estudante (nome,curso_id_fk) 
VALUES('Edwina',1),('Teofilo',1),('Israel',1);
-- UPDATE 
-- curso 
-- SET id_departamento = 1


insert into funcionario (data_ingresso_funcionario) values('2020-04-02');

insert into disciplina (disc_credito,disc_nome,estatuto) values (4,'SAG',' ');

insert into inscricao (id,cod_inscricao,estudante_id,id_disciplina) values(1,100,1,1);