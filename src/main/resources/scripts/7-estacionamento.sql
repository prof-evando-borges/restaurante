CREATE TABLE estacionamento (
    id NUMBER PRIMARY KEY,
    total_vagas NUMBER NOT NULL,
    vagas_ocupadas NUMBER DEFAULT 0,
    preco_por_hora NUMBER NOT NULL
);


CREATE TABLE veiculo (
    placa VARCHAR2(10) PRIMARY KEY,
    modelo VARCHAR2(50) NOT NULL,
    horas_estacionado NUMBER NOT NULL,
    estacionamento_id NUMBER REFERENCES estacionamento(id)
);