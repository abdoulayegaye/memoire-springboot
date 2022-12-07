package dev.local.springjwt.controller;

import dev.local.springjwt.domain.ChefDepartementDto;
import dev.local.springjwt.services.ChefDepartementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chefDepartements")
@AllArgsConstructor
public class ChefDepartementController {
    ChefDepartementService chefDepartementService;

    @GetMapping
    public List<ChefDepartementDto> getEtudiants() {
        return chefDepartementService.getChefDepartements();
    }

    @GetMapping("/{id}")
    public ChefDepartementDto getChefDepartements(@PathVariable("id") Long id) {
        return chefDepartementService.getChefDepartement(id);
    }

    @PostMapping
    public ChefDepartementDto createChefDepartement(@RequestBody ChefDepartementDto chefDepartement) {
        return chefDepartementService.createChefDepartement(chefDepartement);
    }

    @PutMapping("/{id}")
    public ChefDepartementDto updateChefDepartement(@PathVariable("id") Long id, @RequestBody ChefDepartementDto chefDepartement) {
        return chefDepartementService.updateChefDepartement(id, chefDepartement);
    }

    @DeleteMapping("/{id}")
    public void deleteChefDepartement(@PathVariable("id") Long id) {
        chefDepartementService.deleteChefDepartement(id);
    }
}
