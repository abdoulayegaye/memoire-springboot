package dev.local.springjwt.controller;

import dev.local.springjwt.domain.ProfesseurDto;
import dev.local.springjwt.services.ProfesseurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professeurs")
@AllArgsConstructor
public class ProfesseurController {

    ProfesseurService professeurService;

    @GetMapping
    public List<ProfesseurDto> getProfesseurs() {
        return professeurService.getProfesseurs();
    }

    @GetMapping("/{id}")
    public ProfesseurDto getProfesseur(@PathVariable("id") Long id) {
        return professeurService.getProfesseur(id);
    }

    @PostMapping
    public ProfesseurDto createProfesseur(@RequestBody ProfesseurDto professeur) {
        return professeurService.createProfesseur(professeur);
    }

    @PutMapping("/{id}")
    public ProfesseurDto updateProfesseur(@PathVariable("id") Long id, @RequestBody ProfesseurDto professeur) {
        return professeurService.updateProfesseur(id, professeur);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesseur(@PathVariable("id") Long id) {
        professeurService.deleteProfesseur(id);
    }
}
