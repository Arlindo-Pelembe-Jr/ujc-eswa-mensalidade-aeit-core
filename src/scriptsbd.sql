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

select *from inscricao;
insert into departamento(cod_departamento, nome_departamento )
values(7, 'Faculdade de letras'),
(6, 'Faculdade de relacoes internacionais' ),
(5, 'Faculdade de estudos Nauticos'),
(3, 'Faculdade de ciencias sociais' ),
(2, 'Faculdade de engenharia'),
(4, 'Faculdade de contabilidade');
select *from disciplina;


insert into inscricao(cod_inscricao, faltas, data_inscricao, nota1, nota2, estudante_id, disciplina_id)
values(1, 3, '2020-09-02',12,13, 1, 801),
(2, 2, '2019-03-02',11,15, 3, 805),
(3, 1, '2021-01-12',15,10, 2, 802),
(4, 2, '2019-10-12',12,14, 4, 803),
(5, 2, '2018-11-12',10,11, 1, 802);


select *from inscricao;
select *from cargo;

alter table inscricao
drop column media;
alter table professor
drop column tipo_professor;


insert into cargo(id_cargo, nome_cargo)
values(131, "docente"),
(132, "director"),
(133, "prof_assistente"),
(134, "funcionario");

select estudante.nome, disciplina.disc_nome,nota1, nota2, (nota1+nota2)/2 as media
from estudante join inscricao on estudante.id=inscricao.estudante_id join disciplina on disciplina.id_disciplina=inscricao.disciplina_id; 