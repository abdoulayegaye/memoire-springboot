package dev.local.springjwt.domain;

import dev.local.springjwt.model.Profil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Long id;
    @NotNull(message = "Nom is not null")
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String adresse;
    @NotNull
    private Date dateNaissance;
    @NotNull
    private String lieuNaissance;
    @NotNull
    private char sexe;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String telephone;
    @NotNull
    private String email;
    @NotNull
    private Date dateCreation;
    @NotNull
    Collection<Profil> profils ;
    @NotNull
    private int etat;
}
