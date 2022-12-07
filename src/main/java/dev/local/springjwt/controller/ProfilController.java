package dev.local.springjwt.controller;

import dev.local.springjwt.domain.ProfilDto;
import dev.local.springjwt.services.ProfilService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profils")
@AllArgsConstructor
public class ProfilController {
    ProfilService profilService;

    @GetMapping
    public List<ProfilDto> getProfils() {
        return profilService.getProfils();
    }

    @GetMapping("/{id}")
    public ProfilDto getProfil(@PathVariable("id") Long id) {
        return profilService.getProfil(id);
    }

    @PostMapping
    public ProfilDto createProfil(@RequestBody ProfilDto profil) {
        return profilService.createProfil(profil);
    }

    @PutMapping("/{id}")
    public ProfilDto updateProfil(@PathVariable("id") Long id, @RequestBody ProfilDto profil) {
        return profilService.updateProfil(id, profil);
    }

    @DeleteMapping("/{id}")
    public void deleteProfil(@PathVariable("id") Long id) {
        profilService.deleteProfil(id);
    }
}
