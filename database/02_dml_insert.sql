INSERT INTO usuario (nome, tipo, limite_itens) VALUES
('Sofia Tads', 'aluno', 3),
('Peter Parker', 'aluno', 3),
('Jaques Antunes', 'professor', 5),
('Dr. Connor', 'professor', 5);

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
(101, 'As Crônicas de Nárnia', 'livro', 'C.S. Lewis', '1ª Edição', FALSE),
(102, 'O Senhor dos Anéis', 'livro', 'J.R.R. Tolkien', 'Edição Especial', TRUE),
(201, 'Super Interessante', 'revista', 'Editora Abril', 'Ed. 420', FALSE),
(202, 'Ciência Hoje', 'revista', 'SBPC', 'Ed. 350', TRUE);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
(1, 4, '2026-10-15', '2026-10-29', NULL, 0.00),
(3, 2, '2026-10-10', '2026-10-17','2026-10-21', 4.00);