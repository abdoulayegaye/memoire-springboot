package dev.local.springjwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidateurDto {
    private Long id;
    @NotNull
    private String matriculeV;
    @NotNull
    private int etat;
}
