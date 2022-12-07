package dev.local.springjwt.controller;

import dev.local.springjwt.domain.DirecteurEtudesDto;
import dev.local.springjwt.services.DirecteurEtudesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directeurEtudes")
@AllArgsConstructor
public class DirecteurEtudesController {
    DirecteurEtudesService directeurEtudesService;

    @GetMapping
    public List<DirecteurEtudesDto> getAllDirecteurEtudes() {
        return directeurEtudesService.getAllDirecteurEtudes();
    }

    @GetMapping("/{id}")
    public DirecteurEtudesDto getDirecteurEtudes(@PathVariable("id") Long id) {
        return directeurEtudesService.getDirecteurEtudes(id);
    }

    @PostMapping
    public DirecteurEtudesDto createDirecteurEtudes(@RequestBody DirecteurEtudesDto directeurEtudes) {
        return directeurEtudesService.createDirecteurEtudes(directeurEtudes);
    }

    @PutMapping("/{id}")
    public DirecteurEtudesDto updateDirecteurEtudes(@PathVariable("id") Long id, @RequestBody DirecteurEtudesDto directeurEtudes) {
        return directeurEtudesService.updateDirecteurEtudes(id, directeurEtudes);
    }

    @DeleteMapping("/{id}")
    public void deleteDirecteurEtudes(@PathVariable("id") Long id) {
        directeurEtudesService.deleteDirecteurEtudes(id);
    }
}
