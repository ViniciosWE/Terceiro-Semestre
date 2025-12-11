-- Tabela Cliente
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    telefone VARCHAR(20)
);

-- Tabela Veiculo
CREATE TABLE Veiculo (
    id SERIAL PRIMARY KEY,
    placa VARCHAR(10),
    modelo VARCHAR(50),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
);

-- Tabela Mecanico
CREATE TABLE Mecanico (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100)
);

-- Tabela Servico
CREATE TABLE Servico (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
	descricao VARCHAR(200),
    preco DECIMAL(10,2)
);

-- Tabela OrdemServico
CREATE TABLE OrdemServico (
    id SERIAL PRIMARY KEY,
    id_veiculo INT NOT NULL,
    id_mecanico INT NOT NULL,
    data VARCHAR(20) NOT NULL,
    descricao TEXT,
    valor_total DECIMAL(10,2),
    FOREIGN KEY (id_veiculo) REFERENCES Veiculo(id),
    FOREIGN KEY (id_mecanico) REFERENCES Mecanico(id)
);

-- Table servicoRealizado
CREATE TABLE ServicoRealizado (
    id SERIAL PRIMARY KEY,
    id_ordemServico INT,
    id_servico INT,
    quantidade INT,
    preco_unitario DECIMAL(10,2),
    FOREIGN KEY (id_ordemServico) REFERENCES OrdemServico(id),
    FOREIGN KEY (id_servico) REFERENCES Servico(id)
);
