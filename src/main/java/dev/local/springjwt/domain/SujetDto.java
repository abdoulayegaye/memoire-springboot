package dev.local.springjwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.local.springjwt.model.Etudiant;
import dev.local.springjwt.model.Professeur;
import dev.local.springjwt.model.Validateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SujetDto {
    private Long id;
    @NotNull
    private String libelle;
    @NotNull
    private String contexte;
    @NotNull
    private String problematique;
    @NotNull
    private String motivation;
    @NotNull
    private String interet;

    @NotNull
    private Professeur professeur;

    @NotNull
    private Etudiant etudiant;

    @NotNull
    private Validateur validateur;
}
