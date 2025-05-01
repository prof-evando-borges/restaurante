-- Remove as tabelas em ordem reversa (filhas antes das pais)
DROP TABLE veiculo CASCADE CONSTRAINTS;
DROP TABLE estacionamento CASCADE CONSTRAINTS;

-- Cria as tabelas
CREATE TABLE estacionamento (
    id NUMBER PRIMARY KEY,
    total_vagas NUMBER NOT NULL,
    funcionario_id NUMBER,
    vagas_ocupadas NUMBER DEFAULT 0,
    preco_por_hora NUMBER NOT NULL
    CONSTRAINT fk_est_func FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);

CREATE TABLE veiculo (
    placa VARCHAR2(10) PRIMARY KEY,
    cliente_id NUMBER,
    modelo VARCHAR2(50) NOT NULL,
    horas_estacionado NUMBER NOT NULL,
    CONSTRAINT fk_vei_est FOREIGN KEY (estacionamento_id) REFERENCES estacionamento(id),
    CONSTRAINT fk_vei_cli FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);