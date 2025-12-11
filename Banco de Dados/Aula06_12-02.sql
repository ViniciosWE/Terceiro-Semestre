GRANT lista_de_permissoes 
ON lista_de_objetos
TO lista_de_usuarios

GRANT SELECT 
ON jogadores
to ads20;

select * from jogadores; --com ads20 consegue acessar todo mundo

-- não deixa fazer nd a mais que o select pq esta autorizado apenas SELECT
insert into jogadores values(99, 'Jocemar', '200-06-12', '777', 'XXX');

-- toda a tabela criada o usuario teu o poder sobre ela 

create table t1(
codigo serial primary key,
nome varchar(11)
);

insert into t1 values(1, 'Alarico');


-- ads20 define retrições sobre a t1 que foi ela que criou para ads19

GRANT SELECT
ON t1
to ads19;

-- ads19 não tem permissao para inserir, apenas SELECT
insert into t1 values(2, 'Zulmira');


-- agora ads19 tem acesso a inserir 
GRANT SELECT, Insert
ON t1
to ads19;

-- agora funciona inserir como usuario ads19
insert into t1 values(2, 'Zulmira');


--remove todas as permições da ads19
revoke all
on t1
from ads19


--criando visão

CREATE VIEW contratos_full AS
(Select c.nome as "clube", j.nome AS jogador,
	CO.data_inicial, co.data_final, co.posicao
from clubes c
INNER JOIN contratos CO ON c.codigo = co.cod_clube
Inner JOIN jogadores j on j.codigo = co.cod_jogador)


select * from contratos_full;
select *
from contratos_full
where clube = 'Flamengo' AND posicao = 'Atacante'


