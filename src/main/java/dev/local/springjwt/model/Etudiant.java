package dev.local.springjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("ETUDIANT")
public class Etudiant extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String matriculeET;
    @Column(nullable = false)
    private String classe;
    @Column(nullable = false, columnDefinition = "int(1) default '1'")
    protected int etat;

    @ManyToMany(mappedBy = "etudiants",fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    List<Sujet> sujets;
}
