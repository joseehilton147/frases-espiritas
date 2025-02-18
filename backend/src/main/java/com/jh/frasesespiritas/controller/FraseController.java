package com.jh.frasesespiritas.controller;

import com.jh.frasesespiritas.model.enums.StatusFrase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.jh.frasesespiritas.model.Frase;
import com.jh.frasesespiritas.service.FraseService;

@RestController
@RequestMapping("/frases")
public class FraseController {

    private final FraseService fraseService;

    public FraseController(FraseService fraseService) {
        this.fraseService = fraseService;
    }

    @PostMapping
    public ResponseEntity<List<Frase>> criarFrases(@RequestBody List<Frase> frase) {
        List<Frase> fraseSalvas = fraseService.salvarFrases(frase);

        return ResponseEntity.ok(fraseSalvas);
    }

    @GetMapping("/aleatoria")
    public ResponseEntity<Frase> buscarFraseAleatoria() {
        Frase frase = fraseService.buscarFraseAleatoria();

        return ResponseEntity.ok(frase);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Frase>> buscarFrasesPendentes() {
        List<Frase> pendentes = fraseService.buscarPorStatus(StatusFrase.PENDENTE);

        return ResponseEntity.ok(pendentes);
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<Frase> aprovarFrase(@PathVariable Long id) {
        Frase fraseAprovada = fraseService.aprovarFrase(id);

        return ResponseEntity.ok(fraseAprovada);
    }

    @PutMapping("/{id}/reprovar")
    public ResponseEntity<Frase> reprovarFrase(@PathVariable Long id) {
        Frase fraseReprovada = fraseService.reprovarFrase(id);

        return ResponseEntity.ok(fraseReprovada);
    }
}