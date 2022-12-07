package dev.local.springjwt.controller;

import dev.local.springjwt.domain.EtudiantDto;
import dev.local.springjwt.model.Etudiant;
import dev.local.springjwt.services.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@AllArgsConstructor
public class EtudiantController {

    EtudiantService etudiantService;

    @GetMapping
    public List<EtudiantDto> getEtudiants() {
        return etudiantService.getEtudiants();
    }

    @GetMapping("/{id}")
    public EtudiantDto getEtudiant(@PathVariable("id") Long id) {
        return etudiantService.getEtudiant(id);
    }

    @PostMapping
    public EtudiantDto createEtudiant(@RequestBody EtudiantDto etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    @PutMapping("/{id}")
    public EtudiantDto updateEtudiant(@PathVariable("id") Long id, @RequestBody EtudiantDto etudiant) {
        return etudiantService.updateEtudiant(id, etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable("id") Long id) {
        etudiantService.deleteEtudiant(id);
    }
}
