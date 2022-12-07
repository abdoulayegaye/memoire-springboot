package dev.local.springjwt.controller;

import dev.local.springjwt.domain.SujetDto;
import dev.local.springjwt.services.SujetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sujets")
@AllArgsConstructor
public class SujetController {
    SujetService sujetService;

    @GetMapping
    public List<SujetDto> getSujets() {
        return sujetService.getSujets();
    }

    @GetMapping("/{id}")
    public SujetDto getSujet(@PathVariable("id") Long id) {
        return sujetService.getSujet(id);
    }

    @PostMapping
    public SujetDto createSujet(@RequestBody SujetDto sujet) {
        return sujetService.createSujet(sujet);
    }

    @PutMapping("/{id}")
    public SujetDto updateSujet(@PathVariable("id") Long id, @RequestBody SujetDto sujet) {
        return sujetService.updateSujet(id, sujet);
    }

    @DeleteMapping("/{id}")
    public void deleteSujet(@PathVariable("id") Long id) {
        sujetService.deleteSujet(id);
    }
}
