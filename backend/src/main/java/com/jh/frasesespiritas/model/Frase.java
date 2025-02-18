package com.jh.frasesespiritas.model;

import lombok.Data;               // Gera automaticamente getters, setters, equals, hashCode e toString para todos os campos.
import lombok.NoArgsConstructor;  // Gera um construtor sem argumentos, necessário para frameworks como o JPA.
import lombok.AllArgsConstructor; // Gera um construtor com argumentos para todos os campos, facilitando a criação de instâncias.

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.jh.frasesespiritas.model.enums.StatusFrase;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "frases")
public class Frase {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;

    @Column(nullable = false)
    private String conteudo;

    @Enumerated(EnumType.STRING)
    private StatusFrase status;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

}