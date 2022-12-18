package dev.local.springjwt.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("CHEFDEPARTEMENT")
public class ChefDepartement extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String matriculeCD;
    @Column(nullable = false)
    private String departement;
    @Column(nullable = false, columnDefinition = "int(1) default '1'")
    protected int etat;
}
