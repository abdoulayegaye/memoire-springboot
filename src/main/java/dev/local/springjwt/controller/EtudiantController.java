package dev.local.springjwt.controller;

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
    public List<Etudiant> getEtudiants() {
        return etudiantService.getEtudiants();
    }

    @GetMapping("{matricule}")
    public Etudiant getEtudiant(@PathVariable("matricule") String matricule) {
        return etudiantService.getEtudiant(matricule);
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.createEtudiant(etudiant);
    }

    @PutMapping("{matricule}")
    public Etudiant updateEtudiant(@PathVariable("matricule") String matricule, @RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(matricule, etudiant);
    }

    @DeleteMapping("{id}")
    public void deleteEtudiant(@PathVariable("id") Long id) {
        etudiantService.deleteEtudiant(id);
    }
}
