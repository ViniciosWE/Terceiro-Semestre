CREATE TABLE departamento(
cod_departamento serial PRIMARY KEY
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
