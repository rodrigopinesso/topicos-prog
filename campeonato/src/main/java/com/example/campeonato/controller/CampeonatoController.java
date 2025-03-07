package com.example.campeonato.controller;

import com.example.campeonato.model.Time;
import com.example.campeonato.model.Campeonato;
import com.example.campeonato.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping
    public List<Campeonato> listarCampeonatos() {
        return campeonatoService.listarCampeonatos();
    }

    @PostMapping
    public Campeonato criarCampeonato(@RequestBody Campeonato campeonato) {
        return campeonatoService.criarCampeonato(campeonato);
    }

    @PostMapping("/{id}/times")
    public ResponseEntity<String> adicionarTime(@PathVariable Long id, @RequestBody Time time) {
        campeonatoService.adicionarTimeAoCampeonato(id, time);
        return ResponseEntity.ok("{\"message\": \"Time adicionado ao campeonato com sucesso!\"}");
    }
}