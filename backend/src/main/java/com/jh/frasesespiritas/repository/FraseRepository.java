package com.jh.frasesespiritas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.frasesespiritas.model.Frase;
import com.jh.frasesespiritas.model.enums.StatusFrase;

import java.util.List;

// @Repository: Anotação que indica que essa interface é um componente de acesso a dados.
// Ela permite que o Spring detecte e gerencie o repositório automaticamente.
@Repository
public interface FraseRepository extends JpaRepository<Frase, Long> {

    List<Frase> findByStatus(StatusFrase status);

    boolean existsByConteudo(String conteudo);
}