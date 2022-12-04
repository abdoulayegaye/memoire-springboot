package dev.local.springjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sujet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private String contexte;
    @Column(nullable = false)
    private String problematique;
    @Column(nullable = false)
    private String motivation;
    @Column(nullable = false)
    private String interet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professeur_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Professeur professeur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etudiant_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "validateur_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Validateur validateur;

}
