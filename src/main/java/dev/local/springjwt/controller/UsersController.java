package dev.local.springjwt.controller;

import dev.local.springjwt.domain.UsersDto;
import dev.local.springjwt.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    UsersService usersService;

    @GetMapping
    public List<UsersDto> getUsers() {
        return usersService.getUsers();
    }

    @GetMapping("/{username}")
    public UsersDto getUser(@PathVariable("username") String username) {
        return usersService.getUser(username);
    }

    @PostMapping
    public UsersDto createUser(@RequestBody UsersDto user) {
        return usersService.createUser(user);
    }

    @PutMapping("/{username}")
    public UsersDto updateUser(@PathVariable("username") String username, @RequestBody UsersDto user) {
        return usersService.updateUser(username, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable("id") Long id) {
        usersService.deleteUser(id);
    }
}
