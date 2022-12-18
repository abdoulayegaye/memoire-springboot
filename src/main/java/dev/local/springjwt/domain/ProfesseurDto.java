package dev.local.springjwt.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesseurDto {
    private Long id;
    @NotNull
    private String matriculePF;
    @NotNull
    private String domaine;
    @NotNull
    private String grade;
    @NotNull
    private int etat;
}
