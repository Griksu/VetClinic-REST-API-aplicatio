package com.crud.vetclinicback.model.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialisationDto {
    private Long id;
    private String specName;
    private List<VetDto> vets;
}
