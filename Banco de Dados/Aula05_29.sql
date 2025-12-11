/*qual clube possuio maior número de patrocinadores*/
SELECT C.nome,COUNT(*)
FROM clubes C, patrocinios PA
WHERE C.codigo = PA.cod_clube
GROUP BY 1
ORDER BY 2 DESC
LIMIT 1;

SELECT C.nome,COUNT(*)
FROM clubes C, patrocinios PA
WHERE C.codigo = PA.cod_clube
GROUP BY 1
HAVING COUNT(*) >= ALL
	(SELECT COUNT(*)
	 FROM patrocinios
	 GROUP BY cod_clube);

	 
/* Quais clubes são patrocinado pela 'cola-cola' */
SELECT C.nome AS "Clube", P.nome AS "Patrocinadores"
FROM patrocinadores P, patrocinios PA, clubes C
WHERE C.codigo = PA.cod_clube AND
	p.codigo = PA.cod_patrocinador AND
	p.nome = 'Coca-Cola';

/* usando JOIN*/
SELECT DISTINCT C.nome AS "Clube", P.nome AS "Patrocinadores"
FROM clubes c
INNER JOIN patrocinios PA ON C.codigo = PA.cod_clube
INNER JOIN patrocinadores P ON p.codigo = PA.cod_patrocinador
WHERE p.nome = 'Coca-Cola';

--USANDO JOI QUENTUCHO
SELECT DISTINCT C.nome AS "Clube", P.nome AS "Patrocinadores"
FROM patrocinios pa
INNER JOIN patrocinadores P ON p.codigo = PA.cod_patrocinador
		AND p.nome = 'Coca-Cola'
INNER JOIN clubes c ON C.codigo = PA.cod_clube;