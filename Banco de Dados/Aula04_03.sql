/* Quais são os jogadores(codigo) que possuem contratos entre R$80k e 120k */
SELECT * 
FROM jogadores, contratos;
WHERE jogadores.codigo = contatos.cod_jogador;

SELECT cod_jogador
FROM contratos 
WHERE salario BETWEEN 80000.00 AND 120000.00;

SELECT jogadores.nome, contratos.salario
FROM contratos, jogadores
WHERE jogadores.codigo = contratos.cod_jogador AND
salario BETWEEN 80000.00 AND 120000.00;



/* Quais são os jogadores que não possuem contrato acabando em 2024 */
SELECT *
FROM contratos
WHERE data_final NOT BETWEEN '2024-01-01' AND '2024-12-31';

/* Quais são os jogadores que possuem dois nomes */

SELECT nome
FROM jogadores
WHERE nome LIKE '% %';

/* Quais jogadores possuem menos de 30 anos? Mostre o nome do jogador e sua idade */
SELECT nome,data_nasc,(CURRENT_DATE - data_nasc)/365 AS "idade" 
FROM jogadores
WHERE (CURRENT_DATE - data_nasc)/365 > 30;

/* Quais jogadores possuem contrato em vigor atualmente */
SELECT *
FROM contratos
WHERE CURRENT_DATE < data_final;

/*Quais são os jogadores e de que clubes que possuem contratos netre R$80k e 120k */
SELECT jogadores.nome, contratos.salario, clubes.nome
FROM contratos, jogadores, clubes
WHERE jogadores.codigo = contratos.cod_jogador AND
	contratos.cod_clube = clubes.codigo AND
	salario BETWEEN 80000.00 AND 120000.00;

SELECT J.nome, ct.salario, cl.nome
FROM contratos AS ct, jogadores AS J, clubes as cl
WHERE J.codigo = ct.cod_jogador AND
	ct.cod_clube = cl.codigo AND
	salario BETWEEN 80000.00 AND 120000.00;

/* Obtenha o nome de cada jogador cadastrado bem como o clube que o mesmo está jogando atualmente */
SELECT J.nome AS "Jogador", cl.nome AS "Clube"
FROM jogadores AS J, clubes AS cl, contratos AS ct 
WHERE j.codigo = ct.cod_jogador AND
	ct.cod_clube = cl.codigo AND
	ct.data_final > CURRENT_DATE;

/* O palmeiras é um clube muito rico, faça um consulata que projete um aumento de salario de 17,5% nos salarios dos jogadores deste clube. A consulta deve retornar o nome do jogaro, o salario atual e a projeção salarial */
SELECT j.nome, cl.nome, ct.salario, ROUND(ct.salario*1.175,2) AS "Projeção"
FROM jogadores AS j, clubes AS cl, contratos AS ct
WHERE j.codigo = ct.cod_jogador AND
	ct.cod_clube = cl.codigo AND
	cl.nome = 'Palmeiras';

/* Quais são os patrocinadores de cada clube? */
SELECT C.nome AS "Clube", P.nome AS "Patrocinadores"
FROM patrocinadores P, patrocinios PA, clubes C
WHERE C.codigo = PA.cod_clube AND
	p.codigo = PA.cod_patrocinador
ORDER BY 1;


/* Quais clubes são patrocinado pela 'cola-cola' */
SELECT C.nome AS "Clube", P.nome AS "Patrocinadores"
FROM patrocinadores P, patrocinios PA, clubes C
WHERE C.codigo = PA.cod_clube AND
	p.codigo = PA.cod_patrocinador AND
	p.nome = 'Coca-Cola';

/* Consultas aninhadas */
SELECT nome
FROM clubes
WHERE codigo IN
	(SELECT cod_clube
	FROM patrocinios
	WHERE cod_patrocinador IN 
		(SELECT codigo
		FROM patrocinadores
		WHERE nome = 'Coca-Cola'))

