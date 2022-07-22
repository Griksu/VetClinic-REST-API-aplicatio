package com.crud.vetclinicback.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PET_TYPES")
public class PetType {

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @OneToMany(
            targetEntity = Pet.class,
            mappedBy = "petType",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Pet> pets = new ArrayList<>();

    public PetType(String typeName) {
        this.typeName = typeName;
    }
}
