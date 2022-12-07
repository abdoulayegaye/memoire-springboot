package dev.local.springjwt.controller;

import dev.local.springjwt.domain.ValidateurDto;
import dev.local.springjwt.services.ValidateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/validateurs")
@AllArgsConstructor
public class ValidateurController {
    ValidateurService validateurService;

    @GetMapping
    public List<ValidateurDto> getValidateurs() {
        return validateurService.getValidateurs();
    }

    @GetMapping("/{id}")
    public ValidateurDto getValidateur(@PathVariable("id") Long id) {
        return validateurService.getValidateur(id);
    }

    @PostMapping
    public ValidateurDto createValidateur(@RequestBody ValidateurDto validateur) {
        return validateurService.createValidateur(validateur);
    }

    @PutMapping("/{id}")
    public ValidateurDto updateValidateur(@PathVariable("id") Long id, @RequestBody ValidateurDto validateur) {
        return validateurService.updateValidateur(id, validateur);
    }

    @DeleteMapping("/{id}")
    public void deleteValidateur(@PathVariable("id") Long id) {
        validateurService.deleteValidateur(id);
    }
}
