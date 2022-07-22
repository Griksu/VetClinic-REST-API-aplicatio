package com.crud.vetclinicback.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VETS")
public class Vet {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "SPEC_ID")
    private Specialisation specialisation;

    @OneToMany(
            targetEntity = Visit.class,
            mappedBy = "vet",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Visit> visits;
}
