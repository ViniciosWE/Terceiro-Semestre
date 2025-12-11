
CREATE TABLE categoria (
CodCategoria int PRIMARY KEY,
Descricao varchar(40) NOT NULL
);

/* INSERT */
INSERT INTO tabela VALUES (valor1, valor2, ...);
INSERT INTO categoria VALUES (0, 'Doces');
INSERT INTO categoria VALUES (-777, 'Salgados');
INSERT INTO categoria VALUES (10, 'Tortas');

INSERT INTO tabela (col1, col2, ...) VALUES(valor1, valor2, ...);
INSERT INTO categoria (descricao, CodCategoria) VALUES('Bombom', 777);

SELECT * FROM categoria;


CREATE TABLE cozinheiros(
CodCozinheiro int PRIMARY KEY,
Nome varchar(40),
RG numeric(10) UNIQUE,
DataNasc date NOT NULL,
Salario decimal(9,2) NOT NULL
);

INSERT INTO cozinheiros VALUES (0, 'Marcos', 0195898678, '2000-05-05', 150000.00);
SELECT * FROM cozinheiros;

CREATE TABLE livros(
CodLivro int PRIMARY KEY,
titulo varchar(40) NOT NULL,
editora varchar(40) NOT NULL
);

INSERT INTO livros VALUES (0, 'cozinhe em casa', 'de casa');
SELECT * FROM livros;

CREATE TABLE receita(
CodReceita int PRIMARY KEY,
descricao varchar(40),
CodCozinheiro int NOT NULL,
CodCategoria int NOT NULL,
codLivro int NOT NULL,
DataCriacao date NOT NULL,
FOREIGN KEY (CodCozinheiro) REFERENCES cozinheiros,
FOREIGN KEY (CodCategoria) REFERENCES categoria,
FOREIGN KEY (CodLivro) REFERENCES livros
);

INSERT INTO receita VALUES (0, 'torta de morango', 0, 10, 0, '2022-03-04');
SELECT * FROM receitas;


CREATE TABLE ingredientes(
CodIngredientes int PRIMARY KEY,
Descricao varchar(20) NOT NULL
);

INSERT INTO ingredientes VALUES (0, 'farinha');
SELECT * FROM ingredientes;

CREATE TABLE IngredienteReceita(
CodReceita int NOT NULL,
CodIngredientes int NOT NULL,
quantidade int NOT NULL,
medida VARCHAR(20) NOT NULL, 
PRIMARY KEY(CodReceita, CodIngredientes),
FOREIGN KEY (CodReceita) REFERENCES receita,
FOREIGN KEY (CodIngredientes) REFERENCES ingredientes
);

INSERT INTO IngredienteReceita VALUES (0,0,0,'150ml');
SELECT * FROM IngredienteReceita;



