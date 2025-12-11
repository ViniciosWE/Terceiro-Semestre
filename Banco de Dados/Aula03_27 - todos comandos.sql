-- DML --
-- comando INSERT

-- INSERT INTO nome_tabela VALUES (valor1, valor2,..., valorN);

-- INSERT INTO nome_tabela (coluna1, coluna2, ..., colunaN) VALUES (valor1, valor2,..., valorN);

-- comando DELETE

-- DELETE  FROM tabela (OPCIONAL, MAS DEVE SER USADO -> [WHER CONDIÇÃO]);

-- comando UPDATE

-- UPDATE tabela SET coluna1 = novo_valor1, coluna2 = novo_valor2,... (OPCIONAL MAS DEVE SER USADO->[WHERE condição]);

﻿CREATE TABLE departamento(
cod_departamento serial PRIMARY KEY,
nome varchar(20)
);


CREATE TABLE FUNCIONARIOS(
matricula char(10) NOT NULL,
nome varchar(40) NOT NULL,
CPF char(11) NOT NULL,
data_nasc date NULL,
sexo char(1) NOT NULL,
salario numeric(7,2) DEFAULT (800.00) NULL,
cod_depto int not null,

CONSTRAINT pk_matricula PRIMARY KEY(matricula),
CONSTRAINT cpf_unico UNIQUE(CPF),
CONSTRAINT ck_sexo CHECK (sexo in('M', 'F', 'm', 'f')),
CONSTRAINT fk_cod_depto FOREIGN KEY(cod_depto) references departamento(cod_departamento)
);

drop table departamento;
drop table funcionarios;

ALTER TABLE funcionarios ADD COLUMN NroDependentes numeric(2) not null;

CREATE INDEX index1 ON funcionarios(nome);

ALTER TABLE funcionarios ADD CONSTRAINT ck_salario CHECK(salario>=0);

--insert departamento --
INSERT INTO departamento (cod_departamento, nome) VALUES (DEFAULT , 'TI'); 

INSERT INTO departamento (cod_departamento, nome) VALUES (DEFAULT , 'RH'); 

INSERT INTO departamento (cod_departamento, nome) VALUES (DEFAULT , 'Financeiro'); 

INSERT INTO departamento (cod_departamento, nome) VALUES (DEFAULT , 'Comercial'); 
-----

--insert funcionarios--
INSERT INTO funcionarios (matricula, nome,CPF, data_nasc,sexo,salario,cod_depto,NroDependentes) VALUES ('2023008946', 'VANDERLEI', '04879806030', '2025-03-20', 'M', 1200.00 , 4, 2);

INSERT INTO funcionarios (matricula, nome,CPF, data_nasc,sexo,salario,cod_depto,NroDependentes) VALUES ('111','alarico', '1111', '2005-03-20', 'M',4321.99, 1, 3);

INSERT INTO funcionarios (matricula, nome,CPF, data_nasc,sexo,salario,cod_depto,NroDependentes) VALUES ('112','gabriela', '2222', '2005-03-20', 'F',4321.99, 1, 3);

INSERT INTO funcionarios (matricula, nome,CPF, data_nasc,sexo,salario,cod_depto,NroDependentes) VALUES ('777','marcelo', '7777', '2020-03-20', 'M', DEFAULT , 2, 1);

INSERT INTO funcionarios (matricula, nome,CPF, data_nasc,sexo,salario,cod_depto,NroDependentes) VALUES ('888','zacarias', '8888', '2020-03-20', 'M', DEFAULT , 2, 1);

INSERT INTO funcionarios (matricula, nome,CPF, data_nasc,sexo,salario,cod_depto,NroDependentes) VALUES ('999','zuleica', '9999', '2020-03-20', 'F', DEFAULT , 3, 4);
----


--delete--
DELETE FROM funcionarios; -- exclui toda a tabela como o drop table--
DELETE FROM departamento; -- não funciona pois a tabela funcionario depende de funcionarios--

--Exclua os funcionarios do dpt1
DELETE FROM funcionarios 
WHERE cod_depto = 1;

--exclua os funcionarios que são do sexo feminino e que possuem slario maior que 1200 reais--
DELETE FROM funcionarios 
WHERE sexo = 'F' AND salario > 1200;
--

--update
--ATUALIZE OS SALARIOS DE TODAS AS MULHERES EM 14,25%--
UPDATE funcionarios 
SET salario = (salario + (salario * 0.1425)) 
WHERE sexo = 'F'; 

UPDATE funcionarios 
SET salario = salario * 1.1425 
WHERE sexo = 'F';  -- os dois são iguais--
-- comando UPDATE para atualizar os dados de um CLIENTE
UPDATE cliente
SET nome = 'Alex', end = 'Rua ABC', nascimento = '1976/02/15', telefone = '77777777', email = 'alex@jjj' 
WHERE codigo = 777;

--quais são os funcionários cadastrados na base de dados
SELECT nome, data_nasc -- ordem importa na exibição
FROM funcionarios;

SELECT * -- mostra todas as coluna(s)--
FROM funcionarios;


--CONHECIMENTO--
--EXCLUIR RESTRIÇÃO DA fk
ALTER TABLE funcionarios DROP CONSTRAINT fk_depto; -- exclui a restrição

--ADICIONANDO A RESTRIÇÃO DE FK "DO MAL"
ALTER TABLE funcionarios ADD CONSTRAINT fk_depto FOREIGN KEY (cod_depto) REFERENCES departamento ON DELETE CASCADE;

-- BOM --
ALTER TABLE funcionarios ADD CONSTRAINT fk_depto FOREIGN KEY (cod_depto) REFERENCES departamento ON UPDATE CASCADE;

-- ALTERAR O NOT NULL DA COLUNA 'COD_DEPTO'
ALTER TABLE funcionarios ALTER COLUMN cod_depto DROP NOT NULL;
ALTER TABLE funcionarios ADD CONSTRAINT fk_depto FOREIGN KEY (cod_depto) REFERENCES departamento ON DELETE SET NULL;


