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
public class Technologie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "domaine_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Domaine domaine;

    @ManyToMany(mappedBy = "technologies",fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Collection<Sujet> sujets;
}
