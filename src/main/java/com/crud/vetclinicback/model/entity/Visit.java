package com.crud.vetclinicback.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VISITS")
public class Visit {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "VISIT_DESCRIPT")
    private String visitDescription;

    @Column(name = "VISIT_DATE")
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "VET_ID")
    private Vet vet;
}
