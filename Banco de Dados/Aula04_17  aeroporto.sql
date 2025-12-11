create table companhia (
codc 	integer not null,
nomec 	varchar(30) not null,
pais 	varchar(15),
primary key (codc));

create table piloto (
codp 	integer not null,
nomep 	varchar(30) not null,
salario 	real not null,
gratificacoes 	real,
anoingresso 	integer,
pais 	varchar(15),
codc 	integer not null,
primary key (codp),
foreign key (codc) references companhia);

create table aeroporto (
coda 	varchar(3) not null,
nomea 	varchar(30) not null,
cidade 	varchar(20),
pais 	varchar(15),
primary key (coda));

create table voo (
codv 	varchar(6) not null,
origem 	varchar(3) not null,
dest 	varchar(3) not null,
hora 	time,
primary key (codv),
foreign key (origem) references aeroporto,
foreign key (dest) references aeroporto);

create table escala (
codv 	varchar(6) not null,
data 	date not null,
codp 	integer not null,
aviao 	varchar(15),
primary key (codv, data),
foreign key (codv) references voo,
foreign key (codp) references piloto);

insert into companhia values (1, 'TAM', 'Brasil');
insert into companhia values (2, 'Varig', 'Brasil');
insert into companhia values (3, 'GOL', 'Brasil');
insert into companhia values (4, 'American Airlines', 'Estados Unidos');
insert into companhia values (5, 'Air France', 'França');
insert into companhia values (6, 'Lufthansa', 'Alemanha');
insert into companhia values (7, 'TAP', 'Portugal');

insert into piloto values (1, 'Pedro', 12000, 2000, 1990, 'Brasil', 2);
insert into piloto values (2, 'Franz', 15000, 1000, 2000, 'Alemanha', 6);
insert into piloto values (3, 'Alex', 8000, 0, 2007, 'Brasil', 3);
insert into piloto values (4, 'Jean', 12450, 500, 2005, 'França', 5);
insert into piloto values (5, 'Eric', 9000, 0, 2005, 'Brasil', 3);
insert into piloto values (6, 'Daniel', 7000, 0, 2008, 'Brasil', 2);
insert into piloto values (7, 'Manuel', 13250, 1500, 1995, 'Portugal', 7);
insert into piloto values (8, 'Tom', 18000, 3000, 1995, 'Estados Unidos', 4);
insert into piloto values (9, 'Osama', 11000, 1200, 2001, 'Iraque', 1);
insert into piloto values (10, 'Yuri', 10000, 950, 2002, 'Rússia', 5);

insert into aeroporto values ('TXL', 'Tegel', 'Berlim', 'Alemanha');
insert into aeroporto values ('EZE', 'Ezeiza', 'Buenos Aires', 'Argentina');
insert into aeroporto values ('JFK', 'Kennedy International', 'Nova Iorque', 'Estados Unidos');
insert into aeroporto values ('FCO', 'Leonardo da Vinci', 'Roma', 'Itália');
insert into aeroporto values ('MVD', 'Aeroporto Carrasco', 'Montevidéo', 'Uruguai');
insert into aeroporto values ('POA', 'Salgado Filho', 'Porto Alegre', 'Brasil');
insert into aeroporto values ('GIG', 'Tom Jobim', 'Rio de Janeiro', 'Brasil');
insert into aeroporto values ('GRU', 'Guarulhos', 'São Paulo', 'Brasil');
insert into aeroporto values ('BSB', 'Brasília', 'Brasília', 'Brasil');
insert into aeroporto values ('SDU', 'Santos Dumont', 'Rio de Janeiro', 'Brasil');
insert into aeroporto values ('CGH', 'Congonhas', 'São Paulo', 'Brasil');

insert into voo values ('VG001', 'BSB', 'POA', '13:00');
insert into voo values ('TM123', 'GRU', 'EZE', '08:00');
insert into voo values ('GL456', 'SDU', 'CGH', '15:00');
insert into voo values ('AF441', 'GIG', 'FCO', '22:00');
insert into voo values ('TP678', 'FCO', 'GRU', '06:00');
insert into voo values ('LF098', 'TXL', 'EZE', '06:00');
insert into voo values ('AA765', 'MVD', 'JFK', '17:00');
insert into voo values ('TM432', 'CGH', 'GIG', '02:00');
insert into voo values ('GL111', 'EZE', 'POA', '12:00');
insert into voo values ('VG230', 'EZE', 'POA', '08:00');
insert into voo values ('VG333', 'POA', 'MVD', '10:00');
insert into voo values ('AF777', 'JFK', 'FCO', '09:00');
insert into voo values ('TM999', 'GRU', 'TXL', '20:00');

insert into escala values ('VG001', '2008-04-13', 1, 'Boeing 737');
insert into escala values ('TM123', '2008-04-14', 9, 'Airbus A320');
insert into escala values ('GL456', '2008-04-13', 3, 'Boeing 737');
insert into escala values ('AF441', '2008-04-15', 4, 'Boeing 747');
insert into escala values ('TP678', '2008-04-15', 7, 'Airbus A330');
insert into escala values ('LF098', '2008-04-14', 2, 'Airbus A330');
insert into escala values ('AA765', '2008-04-16', 8, 'MD11');
insert into escala values ('TM432', '2008-04-16', 9, 'Fokker 100');
insert into escala values ('GL111', '2008-04-15', 3, 'Boeing 737');
insert into escala values ('VG230', '2008-04-15', 1, 'MD11');
insert into escala values ('VG333', '2008-04-13', 6, 'MD11');
insert into escala values ('AF777', '2008-04-13', 10, 'Boeing 747');
insert into escala values ('TM999', '2008-04-17', 9, 'Airbus A320');
insert into escala values ('VG001', '2008-04-20', 6, 'MD11');
insert into escala values ('TM123', '2008-04-19', 9, 'Boeing 737');
insert into escala values ('GL456', '2008-04-18', 5, 'Boeing 737');
insert into escala values ('AF441', '2008-04-20', 10, 'Airbus A330');
insert into escala values ('TP678', '2008-04-18', 7, 'Boeing 747');
insert into escala values ('LF098', '2008-04-17', 2, 'Boeing 747');
insert into escala values ('AA765', '2008-04-20', 8, 'Boeing 787');
insert into escala values ('TM432', '2008-04-17', 9, 'Fokker 100');
insert into escala values ('GL111', '2008-04-18', 5, 'Fokker 100');
insert into escala values ('VG230', '2008-04-19', 6, 'Boeing 707');
insert into escala values ('VG333', '2008-04-19', 6, 'Boeing 737');
insert into escala values ('AF777', '2008-04-16', 4, 'Airbus A340');
insert into escala values ('TM999', '2008-04-16', 9, 'Airbus A320');

--A - Os dados de todos os pilotos de companhias brasileiras. 
SELECT *
FROM piloto
WHERE codc IN
	(SELECT codc
	 FROM companhia		
	 WHERE pais = 'Brasil');

--B - O nome de todos os pilotos da Varig. 
SELECT nomep
FROM piloto
WHERE codc IN
	(SELECT codc
	 FROM companhia
	 WHERE nomec = 'Varig');

--C - O nome de todos os pilotos, junto com seu salário e gratificação. 
SELECT nomep, salario,gratificacoes
FROM piloto;

--D - O nome de todos os pilotos, junto com o total de seus vencimentos, para todos os pilotos que voam há pelo menos 17 anos. 
SELECT nomep, (salario + gratificacoes) AS "vencimentos"
FROM piloto
WHERE (EXTRACT(year from current_date) - anoingresso) > 17;

--E - O nome da cidade e país de destino do voo VG230. 
SELECT A.cidade, A.pais
FROM aeroporto A,voo V
WHERE A.coda = V.dest AND
	V.codv = 'VG230';
	
--F - As companhias dos vôos escalados para 13/04/2008 
SELECT *
FROM companhia
WHERE codc IN
	(SELECT codc 
	 FROM piloto
	 WHERE codp IN
		(SELECT codp
		FROM escala
		WHERE data = '2008-04-13'));
		
--G - O código de todos os vôos que iniciam por VG ou TM, junto com a respectiva companhia. 
SELECT DISTINCT E.codv, C.nomec
FROM companhia C,piloto P, escala E
WHERE C.codc = P.codc AND
	E.codp = P.codp AND
	(E.codv LIKE 'VG%' OR
	E.codv LIKE 'TM%');
	
--soluçao equivalente

SELECT E.codv, C.nomec
FROM companhia C,piloto P, escala E
WHERE C.codc = P.codc AND
	E.codp = P.codp AND
	E.codv LIKE 'VG%'
	UNION
SELECT E.codv, C.nomec
FROM companhia C,piloto P, escala E
WHERE C.codc = P.codc AND
	E.codp = P.codp AND
	E.codv LIKE 'TM%';

--H - O código de todos os vôos, nome dos pilotos escalados para os mesmos, e respectivos tipo de avião e companhia. 
SELECT E.codv, P.nomep,E.aviao, C.nomec
FROM escala e, piloto P, companhia C
WHERE C.codc = P.codc AND
	E.codp = P.codp;

--I - O código de todos os vôos e hora de saída, junto com o nome dos pilotos escalados para os mesmos, e respectivos tipo de avião e companhia, para todos os vôos de companhias estrangeiras. 
SELECT V.codv, V.hora, P.nomep, E.aviao, C.nomec
FROM voo V, escala E, piloto P, companhia C
WHERE V.codv = E.codv AND
      E.codp = P.codp AND
      P.codc = C.codc AND
      C.codc NOT IN (
          SELECT codc
          FROM companhia
          WHERE pais = 'Brasil');

--J - O código de todos os vôos para a Alemanha ou Itália, com as respectivas data e hora de saída. 
SELECT v.codv, v.hora, e.data
FROM voo v, escala e, aeroporto a
WHERE a.coda = v.dest AND v.codv = e.codv AND
	(a.pais = 'Alemanha' OR a.pais = 'Itália');

--K - A companhia dos pilotos que voam para o Brasil.
SELECT DISTINCT C.nomec
FROM companhia C, piloto P, escala E, voo V, aeroporto A
WHERE C.codc = P.codc AND
      P.codp = E.codp AND
      E.codv = V.codv AND
      V.dest = A.coda AND
      A.pais = 'Brasil';

--L - O destino (nome do aeroporto, cidade e país) de todos os vôos da Varig. 
SELECT A.nomea, A.cidade, A.pais
FROM companhia C, piloto P, escala E, voo V, aeroporto A
WHERE C.codc = P.codc AND
	E.codp = P.codP AND
	E.codv = V.codv AND
	V.dest = A.coda AND
	nomec = 'Varig';

--M - O nome dos aeroportos de origem e de destino de todos os vôos marcados para o dia 15/04/2008 
SELECT AO.nomea AS origem, AD.nomea AS destino
FROM escala E
JOIN voo V ON E.codv = V.codv
JOIN aeroporto AO ON V.origem = AO.coda
JOIN aeroporto AD ON V.dest = AD.coda
WHERE E.data = '2008-04-15';

--N - Os aeroportos de destino (nome, cidade) para todos os vôos da Varig em MD11
SELECT DISTINCT A.nomea, A.cidade
FROM companhia C, piloto P, escala E, voo V, aeroporto A
WHERE C.codc = P.codc AND
      P.codp = E.codp AND
      E.codv = V.codv AND
      V.dest = A.coda AND
      C.nomec = 'Varig' AND
      E.aviao = 'MD11';

--O - O código e horario dos vôos internos de todos os países. 
SELECT V.codv, V.hora
FROM voo V
JOIN aeroporto AO ON V.origem = AO.coda
JOIN aeroporto AD ON V.dest = AD.coda
WHERE AO.pais = AD.pais;

--P - O código de todos os vôos internacionais da varig.Dica: Todas as companhias só podem operar a partir de seu próprio país, ou retornar a este. 
SELECT DISTINCT V.codv
FROM companhia C, piloto P, escala E, voo V, aeroporto AO, aeroporto AD
WHERE C.nomec = 'Varig' AND
      C.codc = P.codc AND
      P.codp = E.codp AND
      E.codv = V.codv AND
      V.origem = AO.coda AND
      V.dest = AD.coda AND
      (AO.pais <> C.pais OR AD.pais <> C.pais);

--Q - O nome de todos os aeroportos onde a varig opera. 
SELECT DISTINCT A.nomea
FROM companhia C, piloto P, escala E, voo V, aeroporto A
WHERE C.nomec = 'Varig' AND
      C.codc = P.codc AND
      P.codp = E.codp AND
      E.codv = V.codv AND
      (V.origem = A.coda OR V.dest = A.coda);

--R - O código de todos os vôos internacionais que as companhias fazem a partir de aeroportos em seus próprios países. 
SELECT DISTINCT codv
FROM voo
WHERE origem IN (
    SELECT coda
    FROM aeroporto
    WHERE pais IN (
        SELECT pais
        FROM companhia
    )
)
AND dest IN (
    SELECT coda
    FROM aeroporto
    WHERE pais NOT IN (
        SELECT pais
        FROM companhia
    )
);

--S - O nome dos pilotos que voam de MD11 para o seu próprio país.
SELECT P.nomep
FROM piloto P, escala E, voo V, aeroporto A
WHERE E.codp = P.codP AND
	E.codv = V.codv AND
	V.dest = A.coda AND
	E.aviao = 'MD11' AND
	P.pais = A.pais;