select * from jogadores;
select * from clubes;
select * from contratos;


/* obtenha o nome, data de nascimento e nome
fantasia dos jogadores que nasceram antes do
ano de 1990 */
SELECT nome, data_nasc, nome_fantasia
FROM jogadores
WHERE data_nasc < '1990-01-01';

/* obtenha o nome, data de nascimento e nome
fantasia dos jogadores que nasceram depois do
ano de 1990 e antes de 2000 */
SELECT nome, data_nasc, nome_fantasia
FROM jogadores
WHERE data_nasc >= '1991-01-01'
      AND data_nasc < '2000-01-01';

SELECT nome, data_nasc, nome_fantasia
FROM jogadores
WHERE data_nasc BETWEEN '1991-01-01' AND '1999-12-31';

/* quais são os jogadores (codigo) que possuem 
contratos entre R$80k e 120k */
SELECT cod_jogador, salario
FROM contratos
WHERE salario BETWEEN 80000 AND 120000; 


/* Quais são os jogadores que não possuem contrato 
acabando em 2024 */
SELECT cod_jogador, data_final
FROM contratos
WHERE data_final 
	NOT BETWEEN '2024-01-01' AND '2024-12-31';

     

/* o operador LIKE */
/* Quais são os jogadores que tem seus nomes
iniciando com a letra 'J' */
SELECT nome
FROM jogadores
WHERE nome LIKE 'G%';

/* Quais são os jogadores que tem seus nomes
terminando com a letra 'a' */
SELECT nome
FROM jogadores
WHERE nome LIKE '%a' OR nome LIKE '%á';

/* Quais são os jogadores que possuem apenas
4 letras em seu nome */
SELECT nome
FROM jogadores
WHERE nome LIKE '____';

/* Quais jogadores possuem a letra 'a'
na segunda posição do seu nome */
SELECT nome
FROM jogadores
WHERE nome LIKE '_a%';

/* Quais são os jogadores que tem seu segundo
nome iniciando com a letra 'G' */
SELECT nome
FROM jogadores
WHERE nome LIKE '% G%';

SELECT nome
FROM jogadores
WHERE nome LIKE '_%G%';


/* faça uma simulação dos salários dos jogadores
que possuem contrato em vigor, estimando um
acrescimo de 17,75% */
SELECT cod_jogador AS "Jogador", 
       posicao AS "Joga Aonde", 
       salario AS "Soldo", 
       salario * 1.1775 AS "Simulação"
FROM contratos
WHERE data_final >= current_date;

/* para cada contrato, mostre a quantidade de dias
que o mesmo esteve válido (ou está válido)  */
SELECT cod_jogador, posicao, data_inicial, data_final,
       (data_final - data_inicial) AS "Qtde Dias",
       (data_final - data_inicial)/365 AS "Qtde Anos"
FROM contratos;


