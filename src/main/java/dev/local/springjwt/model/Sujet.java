package dev.local.springjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;

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
    @Column
    private String contexte;
    @Column
    private String problematique;
    @Column
    private String motivation;
    @Column
    private String interet;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professeur_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Professeur professeur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etudiant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Etudiant etudiant;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "directeuretudes_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private DirecteurEtudes directeurEtudes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chefdepartement_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private ChefDepartement chefDepartement;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
    },fetch=FetchType.EAGER)
    @JoinTable(name = "sujet_technologie",
            joinColumns = @JoinColumn(name = "sujet_id"),
            inverseJoinColumns = @JoinColumn(name = "technologie_id")
    )
    private Collection<Technologie> technologies;
}
