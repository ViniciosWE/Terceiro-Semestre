create table clubes(
codigo serial,
nome varchar(45),
site varchar(45),
telefone char(11),
constraint pk_cod_clubes primary key(codigo)
);
alter table clubes alter column nome set not null;


create table jogadores(
codigo serial,
nome varchar(45),
data_nasc date,
constraint pk_cod_jogadores primary key (codigo)
);
alter table jogadores alter column nome set not null;


create table patrocinadores (
codigo serial,
nome varchar(45),
area_atuacao varchar(45),
constraint pk_cod_patrocinadores primary key(codigo)
);


create table contratos(
cod_clube int not null,
cod_jogador int not null,
data_inicial date,
data_final date,
posicao varchar(45),
salario decimal(8,2),
constraint pk_contratos primary key(cod_clube, cod_jogador, data_inicial),
constraint fk_cod_clube foreign key(cod_clube) references clubes(codigo),
constraint fk_cod_jogador foreign key(cod_jogador) references jogadores(codigo)
);


create table confrontos(
cod_clube_casa int not null,
cod_clube_visita int not null,
data_confronto date not null,
gols_clube_casa smallint,
gols_clube_visita smallint,
constraint pk_confrontos primary key(cod_clube_casa, cod_clube_visita, data_confronto),
constraint fk_cod_clube_casa foreign key(cod_clube_casa) references clubes(codigo),
constraint fk_cod_clube_visita foreign key(cod_clube_visita) references clubes(codigo)
);


create table patrocinios(
cod_clube int not null,
cod_patrocinador int not null,
constraint fk_cod_clubes foreign key(cod_clube) references clubes(codigo),
constraint fk_cod_patrocinadores foreign key(cod_patrocinador) references patrocinadores(codigo),
primary key (cod_clube, cod_patrocinador)
);


-- 3
create index idx_jogadores on jogadores(nome);


-- 4 
alter table jogadores add column cpf char(11) not null unique;

-- 5
alter table jogadores add column nome_fantasia varchar(20);

-- 6
alter table patrocinadores add constraint un_nome unique (nome);

-- 7
alter table contratos alter column salario set default 1200;

-- 8
alter table confrontos add constraint ck_gols_clube_casa 
check (gols_clube_casa>=0);

alter table confrontos add constraint ck_gols_clube_visita 
check(gols_clube_visita>=0);





--DML--

--chat GPT Clubes--
INSERT INTO clubes VALUES (1, 'São Paulo', 'www.saopaulofc.com.br', '11976543210');
INSERT INTO clubes VALUES (2, 'Flamengo', 'www.flamengo.com.br', '21987654321');
INSERT INTO clubes VALUES (3, 'Palmeiras', 'www.palmeiras.com.br', '11987654321');
INSERT INTO clubes VALUES (4, 'Corinthians', 'www.corinthians.com.br', '11998765432');
INSERT INTO clubes VALUES (5, 'Grêmio', 'www.gremio.net', '51987654321');
INSERT INTO clubes VALUES (6, 'Internacional', 'www.internacional.com.br', '51976543210');
INSERT INTO clubes VALUES (7, 'Santos', 'www.santosfc.com.br', '13987654321');
INSERT INTO clubes VALUES (8, 'Athletico-PR', 'www.athletico.com.br', '4134567890');
INSERT INTO clubes VALUES (9, 'Cruzeiro', 'www.cruzeiro.com.br', '31987654321');
INSERT INTO clubes VALUES (10, 'Atlético-MG', 'www.atletico.com.br', '31987654321');
INSERT INTO clubes VALUES (11, 'Botafogo', 'www.botafogo.com.br', '21987654321');
INSERT INTO clubes VALUES (12, 'Fluminense', 'www.fluminense.com.br', '21976543210');
INSERT INTO clubes VALUES (13, 'Fortaleza', 'www.fortalezaec.net', '85987654321');
INSERT INTO clubes VALUES (14, 'Vasco', 'www.vasco.com', '55987654321');

--Chat GPT jogadores--
insert into jogadores values (1, 'Lucas Paquetá', '27-08-1997', '11122233345', 'Lucas Paquetá');
insert into jogadores values (2, 'Rodrigo Caio', '17-08-1993', '22233344456', 'Rodrigo Caio');
insert into jogadores values (3, 'Gabriel Menino', '13-08-2000', '33344455666', 'Gabriel Menino');
insert into jogadores values (4, 'Raphael Claus', '08-01-1978', '44455566667', 'Raphael Claus');
insert into jogadores values (5, 'Luan', '27-03-1993', '55566677798', 'Luan');
insert into jogadores values (6, 'Jean Pyerre', '13-02-1998', '66477788899', 'Jean Pyerre');
insert into jogadores values (7, 'Gustavo Scarpa', '05-01-1994', '75788899900', 'Gustavo Scarpa');
insert into jogadores values (8, 'Matheus Henrique', '19-06-1997', '58899900011', 'Matheus Henrique');
insert into jogadores values (9, 'João Paulo', '13-04-1991', '99900081122', 'João Paulo');
insert into jogadores values (10, 'Tiago Volpi', '16-05-1991', '00011622233', 'Tiago Volpi');
insert into jogadores values (11, 'Vina', '12-05-1997', '11122233354', 'Vina');
insert into jogadores values (12, 'Reinier', '19-01-2002', '22233374455', 'Reinier');
insert into jogadores values (13, 'Lucas Veríssimo', '23-08-1995', '35344455566', 'Lucas Veríssimo');
insert into jogadores values (14, 'Calegari', '11-06-2001', '44455566977', 'Calegari');
insert into jogadores values (15, 'Breno Lopes', '08-08-1994', '55566877788', 'Breno Lopes');
insert into jogadores values (16, 'Talles Magno', '26-06-2002', '66678788899', 'Talles Magno');
insert into jogadores values (17, 'Pedro Geromel', '21-09-1985', '77738899900', 'Pedro Geromel');
insert into jogadores values (18, 'Thiago Galhardo', '16-03-1989', '81899900011', 'Thiago Galhardo');
insert into jogadores values (19, 'Douglas Luiz', '09-05-1998', '99908011122', 'Douglas Luiz');
insert into jogadores values (20, 'Keno', '10-09-1989', '00011122253', 'Keno');
insert into jogadores values (21, 'Geromel', '19-04-2004', '01666298042','Geromel');
insert into jogadores values (22, 'Gabriel Barbosa', '19-04-2004','44444444444','Gabigol');

--chat GPT adiantar patrocinadores--
insert into patrocinadores values (1, 'Coca-Cola','Alimentício');
INSERT INTO patrocinadores VALUES (2, 'Vale', 'Mineração');
INSERT INTO patrocinadores VALUES (3, 'Ambev', 'Bebidas');
INSERT INTO patrocinadores VALUES (4, 'Banco do Brasil', 'Serviços Financeiros');
INSERT INTO patrocinadores VALUES (5, 'Itaú', 'Serviços Financeiros');
INSERT INTO patrocinadores VALUES (6, 'Natura', 'Cosméticos');
INSERT INTO patrocinadores VALUES (7, 'Banco Bradesco', 'Serviços Financeiros');
INSERT INTO patrocinadores VALUES (8, 'Petrobras', 'Petróleo e Gás');
INSERT INTO patrocinadores VALUES (9, 'Vivo', 'Telecomunicações');
INSERT INTO patrocinadores VALUES (10, 'Magazine Luiza', 'Varejo');
INSERT INTO patrocinadores VALUES (11, 'Santander', 'Serviços Financeiros');
INSERT INTO patrocinadores VALUES (12, 'América Móvil', 'Telecomunicações');
INSERT INTO patrocinadores VALUES (13, 'Globo', 'Mídia');
INSERT INTO patrocinadores VALUES (14, 'Banco Safra', 'Serviços Financeiros');
INSERT INTO patrocinadores VALUES (15, 'Votorantim', 'Conglomerado Industrial');
INSERT INTO patrocinadores VALUES (16, 'Carrefour', 'Varejo');
INSERT INTO patrocinadores VALUES (17, 'Renault', 'Automotivo');
INSERT INTO patrocinadores VALUES (18, 'HSBC', 'Serviços Financeiros');
INSERT INTO patrocinadores VALUES (19, 'JBS', 'Alimentos');
INSERT INTO patrocinadores VALUES (20, 'Bunge', 'Agroindústria');


--chatGPT Contratos--
insert into contratos values (1, 1, '19-04-2004', '02-03-2023', 'Atacante', 100000.00);
INSERT INTO contratos VALUES (8, 2, '12-07-2012', '11-07-2023', 'Lateral Direito', 420000.00);
INSERT INTO contratos VALUES (4, 3, '05-09-2006', '30-06-2024', 'Volante', 200000.00);
INSERT INTO contratos VALUES (7, 4, '14-03-2018', '13-03-2023', 'Meia', 130000.00);
INSERT INTO contratos VALUES (12, 5, '23-11-2016', '30-06-2023', 'Atacante', 370000.00);
INSERT INTO contratos VALUES (6, 6, '07-08-2015', '06-08-2022', 'Goleiro', 130000.00);
INSERT INTO CONTRATOS values (3, 7, '28-06-2010', '30-06-2023', 'Lateral Esquerdo', 110000.00);
INSERT INTO contratos VALUES (9, 8, '20-01-2014', '19-01-2024', 'Volante', 80000.00);
INSERT INTO contratos VALUES (1, 9, '04-03-2005', '30-06-2024', 'Atacante', 500000.00);
INSERT INTO contratos VALUES (11, 10, '15-09-2017', '14-09-2022', 'Meia', 190000.00);
INSERT INTO contratos VALUES (5, 11, '18-02-2013', '30-06-2023', 'Zagueiro', 160000.00);
INSERT INTO contratos VALUES (10, 12, '02-04-2016', '01-04-2023', 'Atacante', 420000.00);
INSERT INTO contratos VALUES (12, 13, '09-01-2019', '08-01-2024', 'Goleiro', 220000.00);
INSERT INTO contratos VALUES (2, 14, '22-06-2007', '30-06-2022', 'Lateral Direito', 190000.00);
INSERT INTO contratos VALUES (7, 15, '01-03-2011', '28-02-2022', 'Meia', 180000.00);
INSERT INTO contratos VALUES (3, 16, '14-12-2014', '31-12-2024', 'Lateral Esquerdo', 300000.00);
INSERT INTO contratos VALUES (1, 17, '12-05-2017', '11-05-2023', 'Atacante', 400000.00);
INSERT INTO contratos VALUES (11, 18, '06-09-2012', '30-06-2022', 'Meia', 260000.00);
INSERT INTO contratos VALUES (4, 19, '11-08-2013', '31-07-2023', 'Volante', 130000.00);
INSERT INTO contratos VALUES (9, 20, '27-10-2015', '26-10-2022', 'Volante', 100000.00);
INSERT INTO contratos VALUES (2, 22, '2019-01-01', '2024-12-31', 'Atacante', 800000.00);
INSERT INTO contratos VALUES (5, 5, '2015-01-01', '2016-11-24', 'Meia', 100000.00);
INSERT INTO contratos VALUES (7, 22, '2014-01-01', '2017-12-31', 'Atacante', 200000.00);

--Chat GPT confrontos--
insert into confrontos values (1,2, '19-04-2004', 1, 1);
INSERT INTO confrontos VALUES (5, 9, '2022-10-01', 2, 7);
INSERT INTO confrontos VALUES (3, 6, '2023-03-15', 4, 3);
INSERT INTO confrontos VALUES (1, 11, '2022-06-23', 6, 10);
INSERT INTO confrontos VALUES (2, 10, '2023-01-20', 9, 0);
INSERT INTO confrontos VALUES (8, 7, '2022-09-05', 3, 6);
INSERT INTO confrontos VALUES (12, 3, '2023-07-12', 0, 9);
INSERT INTO confrontos VALUES (4, 1, '2022-12-17', 7, 4);
INSERT INTO confrontos VALUES (11, 2, '2023-04-30', 5, 2);
INSERT INTO confrontos VALUES (10, 5, '2022-08-25', 8, 8);
INSERT INTO confrontos VALUES (9, 4, '2023-06-05', 1, 5);
INSERT INTO confrontos VALUES (6, 12, '2022-11-10', 2, 1);
INSERT INTO confrontos VALUES (7, 8, '2023-02-22', 3, 3);
INSERT INTO confrontos VALUES (1, 10, '2022-05-07', 4, 9);
INSERT INTO confrontos VALUES (11, 6, '2023-03-27', 0, 4);
INSERT INTO confrontos VALUES (2, 4, '2022-12-08', 8, 1);
INSERT INTO confrontos VALUES (12, 9, '2023-07-24', 5, 6);
INSERT INTO confrontos VALUES (3, 5, '2022-08-13', 7, 2);
INSERT INTO confrontos VALUES (6, 7, '2023-01-05', 1, 0);
INSERT INTO confrontos VALUES (8, 11, '2022-10-20', 4, 5);
INSERT INTO confrontos VALUES (10, 1, '2023-04-13', 6, 7);
INSERT INTO confrontos VALUES (3, 4, '27-07-2010', 3, 0);
INSERT INTO confrontos VALUES (7, 2, '11-05-2014', 0, 2);
INSERT INTO confrontos VALUES (9, 6, '08-12-2017', 1, 1);
INSERT INTO confrontos VALUES (5, 12, '20-09-2012', 2, 2);
INSERT INTO confrontos VALUES (11, 3, '15-02-2019', 0, 1);
INSERT INTO confrontos VALUES (10, 1, '24-11-2018', 1, 1);
INSERT INTO confrontos VALUES (8, 5, '06-09-2016', 2, 1);
INSERT INTO confrontos VALUES (4, 11, '03-06-2011', 1, 0);
INSERT INTO confrontos VALUES (6, 9, '18-04-2013', 2, 3);
INSERT INTO confrontos VALUES (12, 8, '29-12-2019', 0, 0);

--Chat GPT patrocinios--
insert into patrocinios values (1,1);
INSERT INTO patrocinios VALUES (1, 5);
INSERT INTO patrocinios VALUES (8, 12);
INSERT INTO patrocinios VALUES (3, 7);
INSERT INTO patrocinios VALUES (10, 18);
INSERT INTO patrocinios VALUES (6, 2);
INSERT INTO patrocinios VALUES (2, 9);
INSERT INTO patrocinios VALUES (11, 16);
INSERT INTO patrocinios VALUES (4, 1);
INSERT INTO patrocinios VALUES (7, 15);
INSERT INTO patrocinios VALUES (12, 13);
INSERT INTO patrocinios VALUES (9, 4);
INSERT INTO patrocinios VALUES (1, 19);
INSERT INTO patrocinios VALUES (5, 11);
INSERT INTO patrocinios VALUES (2, 17);
INSERT INTO patrocinios VALUES (8, 6);
INSERT INTO patrocinios VALUES (10, 3);
INSERT INTO patrocinios VALUES (11, 1);
INSERT INTO patrocinios VALUES (4, 8);
INSERT INTO patrocinios VALUES (7, 14);
INSERT INTO patrocinios VALUES (12, 10);
INSERT INTO patrocinios VALUES (3, 8);
INSERT INTO patrocinios VALUES (9, 13);
INSERT INTO patrocinios VALUES (6, 17);
INSERT INTO patrocinios VALUES (2, 5);
INSERT INTO patrocinios VALUES (11, 10);
INSERT INTO patrocinios VALUES (7, 18);
INSERT INTO patrocinios VALUES (1, 19);
INSERT INTO patrocinios VALUES (12, 3);
INSERT INTO patrocinios VALUES (8, 14);
INSERT INTO patrocinios VALUES (4, 7);
INSERT INTO patrocinios VALUES (10, 2);
INSERT INTO patrocinios VALUES (5, 16);
INSERT INTO patrocinios VALUES (11, 1);
INSERT INTO patrocinios VALUES (6, 6);
INSERT INTO patrocinios VALUES (9, 12);
INSERT INTO patrocinios VALUES (3, 15);
INSERT INTO patrocinios VALUES (2, 4);
INSERT INTO patrocinios VALUES (7, 11);
INSERT INTO patrocinios VALUES (1, 10);
INSERT INTO patrocinios VALUES (12, 19);
