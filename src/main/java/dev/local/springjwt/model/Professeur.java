package dev.local.springjwt.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("PROF")
public class Professeur extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String matriculePF;
    @Column(nullable = false)
    private String domaine;
    @Column(nullable = false)
    private String grade;
    @Column(nullable = false, columnDefinition = "int(1) default '1'")
    protected int etat;
}
