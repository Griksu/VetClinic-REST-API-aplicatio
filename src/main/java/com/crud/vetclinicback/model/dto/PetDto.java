package com.crud.vetclinicback.model.dto;

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
    private Long ownerId;
    private Long petTypeId;
    private List<VisitDto> visits;
}
