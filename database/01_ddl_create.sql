CREATE TABLE item (
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	codigo INT NOT NULL UNIQUE,
	titulo VARCHAR(255) NOT NULL,
	tipo VARCHAR(50) NOT NULL,
	autor VARCHAR(255) NULL,
	edicao VARCHAR(100) NULL,
	disponivel BOOLEAN NOT NULL DEFAULT TRUE,
	CONSTRAINT chk_tipo_item CHECK (tipo IN('livro', 'revista'))
);

CREATE TABLE usuario (
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	tipo VARCHAR(50) NOT NULL,
	limite_itens INT NOT NULL,
	CONSTRAINT chk_tipo_usuario CHECK (tipo IN('aluno', 'professor'))
);

CREATE TABLE emprestimo (
	id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	item_id INT NOT NULL,
	usuario_id INT NOT NULL,
	data_retirada DATE NOT NULL DEFAULT CURRENT_DATE,
	data_devolucao_prevista DATE NOT NULL,
	data_devolucao DATE NULL, 
	valor_multa NUMERIC(10,2) DEFAULT 0.00,

	CONSTRAINT fk_emprestimo_item FOREIGN KEY (item_id) REFERENCES item(id) ON DELETE CASCADE,
	CONSTRAINT fk_emprestimo_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);