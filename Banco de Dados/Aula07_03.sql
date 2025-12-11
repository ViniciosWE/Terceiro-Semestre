create table produtos (
codP serial not null primary key,
descricao varchar(30),
valor_unitario numeric(8,2),
qtde_estoque integer default 0
);

create table vendas (
codV serial not null primary key,
data_venda date,
valor_total_venda numeric(8,2) default 0
);

create table item_venda (
codV integer not null,
codP integer not null,
qtde integer default 1,
primary key (codV, codP),
foreign key (codV) references vendas,
foreign key (codP) references produtos
);

create table compras (
codC serial not null primary key,
data_venda date,
valor_total_compra numeric(8,2) default 0
);

create table compras_produtos (
codC integer not null,
codP integer not null,
qtde integer default 1,
primary key (codP, codC),
foreign key (codC) references compras,
foreign key (codP) references produtos
);
drop table item_venda;

INSERT INTO produtos (codP, descricao, valor_unitario, qtde_estoque) VALUES (1, 'CERVEJA', 6.00, 90);
INSERT INTO produtos (codP, descricao, valor_unitario, qtde_estoque) VALUES (2, 'CAFÉ', 29.50, 50);
INSERT INTO produtos (codP, descricao, valor_unitario, qtde_estoque) VALUES (3, 'CHOCOLATE', 6.50, 30);
INSERT INTO produtos (codP, descricao, valor_unitario, qtde_estoque) VALUES (4, 'MERENCIDNHA', 3.50, 100);
INSERT INTO produtos (codP, descricao, valor_unitario, qtde_estoque) VALUES (5, 'MIOJO', 3.50, 60);
INSERT INTO produtos (codP, descricao, valor_unitario, qtde_estoque) VALUES (6, 'VINHO', 25.00, 20);

/*GATILHO INSERIR INTEM_VENDA*/
CREATE TRIGGER insere_item_venda
AFTER INSERT ON item_venda
FOR EACH ROW
EXECUTE PROCEDURE insere_item_venda();


/*PROCEDURE INSERE_ITEM_VENDA*/
CREATE OR REPLACE FUNCTION insere_item_venda()
RETURNS TRIGGER AS $insere_item_venda$
DECLARE 
	total REAL; --Não precisa é um exemplo
BEGIN
	IF((SELECT qtde_estoque
	   FROM produtos WHERE codp = NEW.codp) >= NEW.qtde) THEN 

	   UPDATE produtos 
	   SET qtde_estoque = qtde_estoque - NEW.qtde
	   WHERE codp = NEW.codP;
	   RAISE NOTICE 'ESTOQUE ATUALIZADO!!';
	   
	   UPDATE vendas SET valor_total_venda = valor_total_venda + 
	   (NEW.qtde * (SELECT valor_unitario 
			FROM produtos
			WHERE codp = NEW.codp))

	   WHERE codv = NEW.codv;
	   total := (SELECT valor_total_venda
		    FROM vendas WHERE codv = NEW.codv);
	   RAISE NOTICE 'VALOR ATUAL DA VENDA: %', total;

	ELSE
	     RAISE EXCEPTION 'NÃO PODE LEVAR MAIS QUE O ESTOQUE!!!';
	
	END IF;
	RETURN NEW;
END;
$insere_item_venda$ LANGUAGE plpgsql;

SELECT * FROM vendas;
SELECT * FROM produtos;
SELECT * FROM item_venda;

INSERT INTO vendas VALUES (1, '2025-07-03', 0);
INSERT INTO vendas VALUES (3, '2025-07-03', 0);

INSERT INTO item_venda VALUES (1, 6, 15);
INSERT INTO item_venda VALUES (1, 5, 10);
INSERT INTO item_venda VALUES (1, 4, 20);



/*GATILHO REMOVER_INTEM_VENDA*/
CREATE TRIGGER remove_item_venda
AFTER DELETE ON item_venda
FOR EACH ROW
EXECUTE PROCEDURE remove_item_venda();


/*PROCEDURE REMOVER_ITEM_VENDA*/
CREATE OR REPLACE FUNCTION remove_item_venda()
RETURNS TRIGGER AS $remove_item_venda$
BEGIN
	IF(true) THEN 

	   UPDATE produtos 
	   SET qtde_estoque = qtde_estoque + OLD.qtde
	   WHERE codp = OLD.codP;
	   RAISE NOTICE 'ESTOQUE ATUALIZADO!!';
	   
	   UPDATE vendas SET valor_total_venda = valor_total_venda - 
	   (OLD.qtde * (SELECT valor_unitario 
			FROM produtos
			WHERE codp = OLD.codp))

	   WHERE codv = OLD.codv;
	END IF;
	RETURN OLD;
END;
$remove_item_venda$ LANGUAGE plpgsql;

DELETE FROM item_venda WHERE codv = 2;



/*GATILHO UPDATE_INTEM_VENDA*/
CREATE TRIGGER update_item_venda
AFTER UPDATE OF qtde ON item_venda
FOR EACH ROW
EXECUTE PROCEDURE update_item_venda();


/*PROCEDURE UPDATE_ITEM_VENDA*/
CREATE OR REPLACE FUNCTION update_item_venda()
RETURNS TRIGGER AS $update_item_venda$
BEGIN
	IF(true) THEN 

	   UPDATE produtos 
	   SET qtde_estoque = qtde_estoque + (OLD.qtde - NEW.qtde)
	   WHERE codp = NEW.codP;
	   RAISE NOTICE 'ESTOQUE ATUALIZADO!!';
	   
	   UPDATE vendas SET valor_total_venda = valor_total_venda  
	   -((OLD.qtde - NEW.qtde) * (SELECT valor_unitario 
			FROM produtos
			WHERE codp = NEW.codp))
	   WHERE codv = NEW.codv;
	END IF;
	RETURN NEW;
END;
$update_item_venda$ LANGUAGE plpgsql;

DELETE FROM vendas WHERE codv = 2;

UPDATE item_venda SET qtde = qtde - 5;















