/* quais os clubes que possuem o patrocinio da 'Coca-Cola' ou da 'Ambev' */
SELECT DISTINCT C.nome, P.nome
FROM clubes C, patrocinios PA, patrocinadores P 
WHERE C.codigo = PA.cod_clube AND
	P.codigo = PA.cod_patrocinador AND
	(P.nome = 'Coca-Cola' OR p.nome = 'Ambev');

SELECT nome
FROM clubes
WHERE codigo IN
	(SELECT cod_clube
	FROM patrocinios
	WHERE cod_patrocinador IN
		(SELECT codigo
		FROM patrocinadores
		WHERE nome = 'Coca-Cola' OR nome = 'Ambev'));

/* Mostre o nome dos clubes e o resultado de cada confronto realizado no ano de 2023 */

SELECT C.nome AS "MANDANTE",CF.gols_clube_casa "GOLS MANDANTE",'X' AS "VS",v.nome AS "VISITANTES", CF.gols_clube_visita AS "GOLS VISITANTES"
FROM clubes C,confrontos CF, clubes V 
WHERE C.codigo = CF.cod_clube_casa AND
	V.codigo = CF.cod_clube_visita AND
	CF.data_confronto BETWEEN '2023-01-01' AND '2023-12-31';


/*Mostre a data da partida e o nome do clube vencedor, para os confrontos em que o time visitante foi o vencedor*/
SELECT CF.data_confronto, V.nome
FROM confrontos CF, clubes V
WHERE V.codigo = CF.cod_clube_visita AND
	CF.gols_clube_visita > CF.gols_clube_casa;

/*Quais clubes não possuem patrocinadores --------QUESTÃO DE PROVA--------- */
SELECT nome
FROM clubes
WHERE codigo NOT IN
	(SELECT cod_clube
	 FROM patrocinios);

/* Mostre o nome dos jogadores e o nome dos clubes para aqueles clubes que não possuem patrocinios */

SELECT J.nome,C.nome
FROM clubes C, contratos CC, jogadores J
WHERE C.codigo = CC.cod_clube AND
	CC.cod_jogador = J.codigo AND
	C.codigo  NOT IN(SELECT cod_clube FROM patrocinios);
	