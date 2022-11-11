package dev.local.springjwt.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String adresse;
    @Column(nullable = false)
    private Date dateNaissance;
    @Column(nullable = false)
    private String lieuNaissance;
    @Column(nullable = false)
    private char sexe;
    @Column(nullable = false,unique = true)
    String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String telephone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Date dateCreation;


    @ManyToMany(cascade = {
            CascadeType.MERGE,
    },fetch=FetchType.EAGER)
    @JoinTable(name = "user_profil",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profil_id")
    )
    Collection<Profil> profils ;
}
