package com.crud.vetclinicback.model.dto;

import com.crud.vetclinicback.model.entity.Owner;
import com.crud.vetclinicback.model.entity.PetType;
import com.crud.vetclinicback.model.entity.Visit;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetDto {
    private Long id;
    private String petName;
    private LocalDate birthDate;
    private Owner owner;
    private PetType petType;
    private List<Visit> visits;
}
