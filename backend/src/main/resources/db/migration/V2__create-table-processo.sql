CREATE TABLE IF NOT EXISTS processo(
    id INTEGER PRIMARY KEY NOT NULL UNIQUE,
    numero_processo VARCHAR(255) NOT NULL,
    valor_divida VARCHAR(255) NOT NULL,
    juiz VARCHAR(255) NOT NULL,
    vara VARCHAR(255) NOT NULL,
    executado VARCHAR(255) NOT NULL,
    data_distribuicao DATE NOT NULL,
    data_prescricao DATE NOT NULL,
    status_prescricao VARCHAR(255) NOT NULL,
    tipo_assunto VARCHAR(255) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
);