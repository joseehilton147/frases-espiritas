package com.jh.frasesespiritas.service;

import com.jh.frasesespiritas.exception.FraseDuplicadaException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jh.frasesespiritas.exception.FraseNaoEncontradaException;
import com.jh.frasesespiritas.model.Frase;
import com.jh.frasesespiritas.model.enums.StatusFrase;
import com.jh.frasesespiritas.repository.FraseRepository;

@Service
public class FraseService {
    private final Random random = new Random();
    private final FraseRepository fraseRepository;

    public FraseService(FraseRepository fraseRepository) {
        this.fraseRepository = fraseRepository;
    }

    public List<Frase> salvarFrases(List<Frase> frases) {
        List<Frase> frasesParaSalvar = new ArrayList<>();

        for (Frase frase : frases) {
            if (!fraseRepository.existsByConteudo(frase.getConteudo())) {
                frase.setStatus(StatusFrase.PENDENTE);
                frase.setDataCriacao(LocalDateTime.now());
                frasesParaSalvar.add(frase);
            }
        }

        return fraseRepository.saveAll(frasesParaSalvar);
    }

    public List<Frase> buscarPorStatus(StatusFrase status) {
        return fraseRepository.findByStatus(status);
    }

    public Frase aprovarFrase(Long id) {
        Frase frase = fraseRepository.findById(id).orElseThrow(() -> new RuntimeException("Frase não encontrada"));
        frase.setStatus(StatusFrase.APROVADA);
        frase.setDataAtualizacao(LocalDateTime.now());

        return fraseRepository.save(frase);
    }

    public Frase reprovarFrase(Long id) {
        Frase frase = fraseRepository.findById(id).orElseThrow(() -> new RuntimeException("Frase não encontrada"));
        frase.setStatus(StatusFrase.REPROVADA);
        frase.setDataAtualizacao(LocalDateTime.now());

        return fraseRepository.save(frase);
    }

    public Frase buscarFraseAleatoria() {
        List<Frase> frasesAprovadas = fraseRepository.findByStatus(StatusFrase.APROVADA);
        if (frasesAprovadas.isEmpty()) {
            throw new FraseNaoEncontradaException("Nenhuma frase aprovada encontrada.");
        }

        int index = random.nextInt(frasesAprovadas.size());
        return frasesAprovadas.get(index);
    }
}