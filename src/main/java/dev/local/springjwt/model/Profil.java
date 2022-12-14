package dev.local.springjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profil {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false, columnDefinition = "int(1) default '1'")
    protected int etat;

    @ManyToMany(mappedBy = "profils",fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    Collection<Users> users;
}
