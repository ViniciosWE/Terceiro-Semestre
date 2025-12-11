-- quais são os jogadores que nasceram antes de 2000--
SELECT *
FROM jogadores
WHERE data_nasc < '2000/01/01';

--quais jogadores nasceram na década de 90--
SELECT *
FROM jogadores
WHERE data_nasc >= '1990/01/01' AND data_nasc <= '1999/12/31';

--igual o de cima 
SELECT *
FROM jogadores
WHERE data_nasc BETWEEN '1990/01/01' AND '1999/12/31'; -- BETWEEN pega o intervalo

--faça os jogadores que, considerando a data atual teria mais de 40 anos

SELECT nome,data_nasc ,(CURRENT_DATE-data_nasc) / 365 AS "Idade em anos"
FROM jogadores
WHERE  ((CURRENT_DATE - data_nasc)/365) > 40;

SELECT nome, data_nasc
FROM jogadores
WHERE (CURRENT_DATE - data_nasc) > 40 * 365 

--faça uma consulta que retorna o nome de cada jogador e a sua idade (em anos) atual
SELECT nome, (CURRENT_DATE-data_nasc) / 365 AS "Idade em anos" -- AS da nome na tabela 
FROM jogadores; 

SELECT nome, data_nasc, (CURRENT_DATE-data_nasc) / 365 AS "Idade em anos" -- AS da nome na tabela 
FROM jogadores
ORDER BY data_nasc; 

SELECT nome, data_nasc, (CURRENT_DATE-data_nasc) / 365 AS "Idade em anos" -- AS da nome na tabela 
FROM jogadores
ORDER BY data_nasc DESC; -- decrescente 


SELECT nome, (CURRENT_DATE-data_nasc) / 365 AS "Idade em anos" -- AS da nome na tabela 
FROM jogadores
ORDER BY 2; -- pega a segunda coluna;


SELECT nome, (CURRENT_DATE-data_nasc) / 365 AS "Idade em anos" -- AS da nome na tabela 
FROM jogadores
ORDER BY 2 ASC , 1 DESC; -- pode usar segundro criterio, ASC crescente

-- o operador LIKE comparar trechos de String 
-- ajudantes do LIKE: 
-- % = respresenta um,nenhum ou muitos char
-- _ = represenya EXATAMENTE UM char

--quais jogadores tem seus nomes iniciando com a 'C'

SELECT nome
FROM jogadores
WHERE nome LIKE '%o';


--quais jogadores tem seus nomes terminado com a 'O'

SELECT nome
FROM jogadores
WHERE nome LIKE '%o';


--quais jogadores tem em seus nomes a segunda letra 'A' e possuem nomes compostos


SELECT nome
FROM jogadores
WHERE nome LIKE '_a% %'; -- _ pega a primeira posição % pega o que não intereça espaço e %pega o restante 