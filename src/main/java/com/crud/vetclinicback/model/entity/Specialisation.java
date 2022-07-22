package com.crud.vetclinicback.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SPECIALISATIONS")
public class Specialisation {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "SPEC_NAME")
    private String specName;

    @OneToMany(
            targetEntity = Vet.class,
            mappedBy = "specialisation",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Vet> vets = new ArrayList<>();

    private Specialisation(String specName) {
        this.specName = specName;
    }
}
