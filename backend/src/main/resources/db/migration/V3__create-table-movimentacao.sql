CREATE TABLE IF NOT EXISTS movimentacao(
   m_id INTEGER PRIMARY KEY NOT NULL UNIQUE,
   tipo VARCHAR(255) NOT NULL,
   descricao VARCHAR(500),
   data_movimentacao DATE NOT NULL,
   FOREIGN KEY fk_numero_processo REFERENCES processo(numero_processo) ON DELETE CASCADE
);
