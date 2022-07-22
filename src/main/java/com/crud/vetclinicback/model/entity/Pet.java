package com.crud.vetclinicback.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PETS")
public class Pet {

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "PET_NAME")
    private String petName;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private PetType petType;

    //@OneToMany()
    //private List<Visit> visits;
}
