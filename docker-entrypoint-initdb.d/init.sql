CREATE DATABASE frases_espiritas;

\c frases_espiritas;

CREATE TABLE frases (
    id SERIAL PRIMARY KEY,
    conteudo TEXT NOT NULL,
    autor VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO frases (conteudo, autor, status, data_criacao, data_atualizacao) VALUES
    ('A felicidade não está fora de nós, mas em nós.', 'Allan Kardec', 'APROVADA', now(), now()),
    ('Fé inabalável é somente aquela que pode encarar a razão, face a face, em todas as épocas da humanidade.', 'Allan Kardec', 'APROVADA', now(), now()),
    ('O amor é o laço divino que une as almas.', 'Chico Xavier', 'APROVADA', now(), now()),
    ('Cada dia é uma nova oportunidade para recomeçar.', 'Emmanuel', 'APROVADA', now(), now());
