SELECT * FROM jogadores;

-- COUNT numero de linahs da tabela
SELECT COUNT(*) FROM jogadores;

-- MAX maior valor dentro do conjunto
SELECT MAX(nome) FROM jogadores;

-- MIN menor valor dentro do conjunto
SELECT MIN(nome) FROM jogadores;

-- SUM somente para valores numéricos 
-- Obtenha o total gasto com salario para o clube de nome 'São Paulo'

SELECT SUM(co.salario)
FROM contratos co, clubes cl
WHERE cl.codigo = co.cod_clube AND
	cl.nome = 'São Paulo';

-- AVG faz a média 
--Obtenha menor salario, maior salario, a média dos salários, o total com salarios e a quantidade de jogadores para o clube de nome 'São Paulo'
SELECT SUM(co.salario) AS "total salario", 
	MIN(co.salario)  AS "menor salario", 
	MAX(co.salario) AS "maior salario", 
	AVG(co.salario) AS "media salario", 
	COUNT(*) AS "quantidade de jogadores"
FROM contratos co, clubes cl
WHERE cl.codigo = co.cod_clube AND
	cl.nome = 'São Paulo';

-- Qual a quantidade de jogadores *em cada* clube, APARECEU USA AGRUPAMENTO
SELECT cl.nome, COUNT(co.cod_jogador)
FROM contratos co, clubes cl
WHERE cl.codigo = co.cod_clube
GROUP BY 1 -- pode ser o nome da tabela
ORDER BY 2 DESC;


-- Quanto cada clube gasta com salario
SELECT cl.nome, SUM(co.salario)
FROM contratos co, clubes cl
WHERE cl.codigo = co.cod_clube
GROUP BY 1 
ORDER BY 2 DESC;

-- Qual os times que ganham entre 500 e 300
SELECT cl.nome, SUM(co.salario)
FROM contratos co, clubes cl
WHERE cl.codigo = co.cod_clube 	
GROUP BY 1 
HAVING SUM(co.salario) BETWEEN 300000.00 AND 500000.00 -- Mesma coisa
--HAVING SUM(co.salario) > 300000.00 AND SUM(co.salario) < 500000.00 --tipo where só que do GROUP BY 
ORDER BY 2 DESC;








