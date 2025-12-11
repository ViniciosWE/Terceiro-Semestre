CREATE TABLE historia_revista(
codTitulo int NOT NULL,
numero int NOT NULL,
codHistoria int NOT NULL,
CONSTRAINT pk_hr PRIMARY KEY(codTitulo,numero,codHistoria),
CONSTRAINT fk_revista01 FOREIGN KEY (codTitulo,numero) REFERENCES revista, -- cuida chaves primarias compostas
CONSTRAINT fk_historia FOREIGN KEY(codHistoria) REFERENCES historia
);

CREATE TABLE personagem_historia(
codPersonagem int NOT NULL,
codHistoria int NOT NULL,
primary key (codPersonagem,codHistoria),
FOREIGN KEY(codPersonagem) REFERENCES personagem,
FOREIGN KEY (codHistoria) REFERENCES historia
);