CREATE TABLE Usuario(
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(60) NOT NULL,
    caixa BOOLEAN  NOT NULL,
    administrador BOOLEAN NOT NULL,
    senha VARCHAR(25) NOT NULL 
);
--PK
ALTER TABLE Usuario 
		ADD CONSTRAINT usuario_pk PRIMARY KEY (cpf);
      
CREATE TABLE Unidade_Medida(
     codigo VARCHAR(2) NOT NULL,
     descricao VARCHAR(20) NOT NULL
);
 --PK
ALTER TABLE Unidade_Medida
		ADD CONSTRAINT unidade_medida_pk PRIMARY KEY (codigo);
        
CREATE TABLE Produto(
    codigo_de_barras NUMERIC(20) NOT NULL,
    descricao VARCHAR(60) NOT NULL,
    preco_venda FLOAT NOT NULL,
    quantidade FLOAT NOT NULL,
    codigo_um VARCHAR(2) NOT NULL
);
--PK
ALTER TABLE Produto
		ADD CONSTRAINT produto_pk PRIMARY KEY(codigo_de_barras);
--FK
ALTER TABLE Produto
		ADD CONSTRAINT produto_unidade_medida_fk 
        	FOREIGN KEY(codigo_um) REFERENCES Unidade_Medida (codigo);
			
CREATE TABLE Cabecalho_Venda(
	numero_cupom NUMERIC(6) NOT NULL,
	serie_cupom VARCHAR(3) NOT NULL,
	data_emissao DATE NOT NULL,
	valor_mercadoria FLOAT NOT NULL,
	forma_pagamento VARCHAR(3) NOT NULL,
	valor_desconto FLOAT NOT NULL,
	valor_total FLOAT NOT NULL,
	cpf_usuario VARCHAR(11) NOT NULL
);
--PK
ALTER TABLE Cabecalho_Venda
		ADD CONSTRAINT cabecalho_venda_pk PRIMARY KEY(numero_cupom,serie_cupom);
--FK
ALTER TABLE Cabecalho_Venda
		ADD CONSTRAINT cabecalho_venda_usuario_fk
			FOREIGN KEY(cpf_usuario) REFERENCES Usuario(cpf);
			
CREATE TABLE Itens_Venda(
	numero_cupom NUMERIC(6) NOT NULL,
	serie_cupom VARCHAR(3) NOT NULL,
	item NUMERIC(3) NOT NULL,
	codigo_de_barras NUMERIC(20),
	quantidade FLOAT NOT NULL,
	valor_unitario FLOAT NOT NULL,
	valor_venda FLOAT NOT NULL,
	codigo_um VARCHAR(2) NOT NULL
);
--PK
ALTER TABLE Itens_Venda
	  ADD CONSTRAINT itens_venda_pk PRIMARY KEY(numero_cupom,serie_cupom,item);
--FK
ALTER TABLE Itens_Venda
	  ADD CONSTRAINT itens_venda_fk 
	  FOREIGN KEY(numero_cupom, serie_cupom) REFERENCES Cabecalho_Venda(numero_cupom,serie_cupom);