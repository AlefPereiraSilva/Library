ALTER TABLE item DROP CONSTRAINT chk_tipo_item;

ALTER TABLE item ADD CONSTRAINT chk_tipo_item CHECK (tipo IN('livro', 'revista', 'dvd'));