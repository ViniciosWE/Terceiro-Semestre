--1. O salário do piloto mais bem pago da Varig.
SELECT MAX(salario)
FROM piloto p, companhia c
WHERE c.nomec = 'Varig'


--2. O menor, maior, e média dos salários dos pilotos de companhias brasileiras.
SELECT MIN(p.salario), MAX(p.salario), AVG(p.salario)
FROM piloto p, companhia c
WHERE p.codc = c.codc AND
	c.pais = 'Brasil'
	
--3. O total da folha de pagamento da Varig.
SELECT SUM(p.salario)
FROM companhia c, piloto p
WHERE p.codc = c.codc AND
	c.nomec = 'Varig';

--4. O número de escalas previstas para o vôo VG230.
SELECT COUNT(*)
FROM escala e, voo v
WHERE v.codv = e.codv
	AND v.codv = 'VG230';

--5. O número de pessoas envolvidas em escalas do vôo VG230.
SELECT count(*)
FROM piloto p, escala e
WHERE p.codp = e.codp AND
	e.codv = 'VG230';

--6. O número de aeroportos no Brasil.
SELECT count(*)
FROM aeroporto
WHERE pais = 'Brasil';

--7. O número de países e de cidades diferentes para as quais se destinam os vôos partindo de GRU.
SELECT COUNT(DISTINCT dest.pais), COUNT(DISTINCT dest.cidade)
FROM voo v, aeroporto ori, aeroporto dest
WHERE ori.coda = v.origem AND
	dest.coda = v.dest and
	v.origem = 'GRU';	
	
--8. O número de aeroportos diferentes de onde os pilotos da Varig partem.
SELECT COUNT(DISTINCT a.*)
FROM companhia c, piloto p, escala e, voo v, aeroporto a
WHERE c.codc = p.codc AND p.codp = e.codp AND e.codv = v.codv  AND v.origem = a.coda and
	c.nomec = 'Varig';

--9. O número de diferentes vôos que a TAM oferece para São Paulo.
SELECT 
FROM companhia c, piloto p, escala e, voo v, aeroporto a
WHERE c.codc = p.codc AND p.codp = e.codp AND e.codv = v.codv  AND v.origem = a.coda AND
	c.nomec = 'TAM' AND v.dest = 'São Paulo';

--10. O número de aeroportos diferentes que os pilotos da varig usam (para chegada ou partida).
SELECT COUNT(DISTINCT a.*) + COUNT(DISTINCT ad.*)
FROM companhia c, piloto p, escala e, voo v, aeroporto a, aeroporto ad
WHERE c.codc = p.codc AND p.codp = e.codp AND e.codv = v.codv  AND v.origem = a.coda AND v.dest = ad.coda AND
	c.nomec = 'Varig';
	

--11. Para cada companhia, o menor, maior salário, bem como a média.
SELECT c.nomec, MIN(p.salario), MAX(p.salario), AVG(p.salario)
FROM companhia c, piloto p
WHERE c.codc = p.codc
GROUP BY c.nomec;

--12. Para cada cidade do Brasil, o número de aeroportos que possui.
SELECT cidade, COUNT(*)
FROM aeroporto
WHERE pais = 'Brasil'
GROUP BY cidade;

--13. Para cada piloto, o número de escalas programadas para o dia 15/04/2008.
SELECT p.nomep, COUNT(*)
FROM piloto p, escala e
WHERE p.codp = e.codp AND e.data = '2008-04-15'
GROUP BY p.nomep;

--14. Para cada dia e hora, o número de vôos que partem pela manhã.
SELECT data, hora, COUNT(*)
FROM voo
WHERE hora < '12:00:00'
GROUP BY data, hora;

--15. Para cada piloto de companhia estrangeira, o número de vôos que ele faz de ou para o Brasil.
SELECT p.nomep, COUNT(a.*)
FROM companhia c, piloto p, escala e, voo v, aeroporto a
WHERE c.codc = p.codc AND p.codp = e.codp AND e.codv = v.codv  AND 
	c.pais != 'Brasil' AND a.pais = 'Brasil' AND (v.origem = a.coda OR v.dest = a.coda)
GROUP BY 1;

--16. As companhias que pagam como salário mais alto a seus pilotos menos que 12000.
SELECT c.nomec
FROM companhia c, piloto p
WHERE c.codc = p.codc
GROUP BY c.nomec
HAVING MAX(p.salario) < 12000;

--17. As companhias brasileiras que pagam como salário mais alto a seus pilotos menos que 12000.
SELECT c.nomec
FROM companhia c, piloto p
WHERE c.codc = p.codc AND c.pais = 'Brasil'
GROUP BY c.nomec
HAVING MAX(p.salario) < 12000;

--18. As companhias estrangeiras que possuem pelo menos 2 pilotos.
SELECT c.nomec
FROM companhia c, piloto p
WHERE c.codc = p.codc AND c.pais <> 'Brasil'
GROUP BY c.nomec
HAVING COUNT(DISTINCT p.codp) >= 2;

--19. O número de escalas previstas em MD11 para cada piloto da Varig que possui pelo menos 2 escalas neste tipo de avião.
SELECT p.nomep, COUNT(*) AS num_escalas
FROM companhia c, piloto p, escala e
WHERE c.codc = p.codc AND p.codp = e.codp AND c.nomec = 'Varig' AND e.aviao = 'MD11'
GROUP BY p.nomep
HAVING COUNT(*) >= 2;
--20. As companhias que só usam um tipo de avião. 
SELECT c.nomec
FROM companhia c, piloto p, escala e
WHERE c.codc = p.codc AND p.codp = e.codp
GROUP BY c.nomec
HAVING COUNT(DISTINCT e.aviao) = 1;