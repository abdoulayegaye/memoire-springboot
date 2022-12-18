package dev.local.springjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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
    @Lob
    @Column(nullable = false)
    private String libelle;
    @Lob
    @Column(nullable = false)
    private String contexte;
    @Lob
    @Column(nullable = false)
    private String problematique;
    @Lob
    @Column(nullable = false)
    private String motivation;
    @Lob
    @Column(nullable = false)
    private String technologie;
    @Column(nullable = false, columnDefinition = "int(1) default '1'")
    private int etat;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "professeur_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Professeur professeur;

    @ManyToMany(fetch=FetchType.LAZY)
    /*@JoinTable(name = "sujet_etudiant",
            joinColumns = @JoinColumn(name = "sujet_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )*/
    @JsonIgnore
    List<Etudiant> etudiants ;
}
