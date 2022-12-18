package dev.local.springjwt.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("VALIDATEUR")
public class Validateur extends Users{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String matriculeV;
    @Column(nullable = false, columnDefinition = "int(1) default '1'")
    protected int etat;
}
