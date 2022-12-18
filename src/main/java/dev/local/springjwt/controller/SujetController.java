package dev.local.springjwt.controller;

import dev.local.springjwt.domain.SujetDto;
import dev.local.springjwt.model.Sujet;
import dev.local.springjwt.services.SujetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/sujets")
@CrossOrigin("*")
@AllArgsConstructor
public class SujetController {
    SujetService sujetService;

    @GetMapping
    public List<Sujet> getSujets() {
        return sujetService.getSujets2();
    }

    @GetMapping("/{id}")
    public Sujet getSujet(@PathVariable("id") Long id) {
        return sujetService.getSujet(id);
    }

    @GetMapping("/choisirSujet/{id}")
    public Sujet choisirSujet(@PathVariable("id") Long id, HttpServletRequest req) {
        return sujetService.choisirSujet(id, req);
    }

    @PostMapping
    public Sujet createSujet(@RequestBody Sujet sujet, HttpServletRequest req) {
        return sujetService.createSujet(sujet, req);
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
