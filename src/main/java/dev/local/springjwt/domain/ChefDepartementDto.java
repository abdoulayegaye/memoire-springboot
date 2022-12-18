package dev.local.springjwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChefDepartementDto {
    private Long id;
    @NotNull
    private String matriculeCD;
    @NotNull
    private String departement;
    @NotNull
    private int etat;
}
