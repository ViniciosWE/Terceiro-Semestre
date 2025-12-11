/*Selecione o nome dos clubes que tenham patrocinador com a area de atuação 'Serviços Finaneiros'*/
SELECT distinct C.nome
FROM patrocinios PA
	INNER JOIN patrocinadores P ON p.codigo = PA.cod_patrocinador
		AND P.area_atuacao = 'Serviços Financeiros'
	INNER JOIN clubes C ON c.codigo = PA.cod_clube; 


/*Selecione o nome dos cluubes que tenham patrocinador com a area de atuação Financeira, caso algum clube não tenha este tipo de patrocinador, seu nome também devará ser exibido */
SELECT distinct C.nome, 
FROM patrocinios PA
	INNER JOIN patrocinadores P ON p.codigo = PA.cod_patrocinador
		AND P.area_atuacao = 'Serviços Financeiros'
	RIGHT OUTER JOIN clubes C ON c.codigo = PA.cod_clube;

