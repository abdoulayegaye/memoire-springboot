package dev.local.springjwt.domain;

import dev.local.springjwt.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilDto {
    private Long id;
    @NotNull
    private String role;
    @NotNull
    Collection<Users> users;
}
