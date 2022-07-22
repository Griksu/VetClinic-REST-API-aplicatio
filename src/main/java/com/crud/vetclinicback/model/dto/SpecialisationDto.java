package com.crud.vetclinicback.model.dto;

import com.crud.vetclinicback.model.entity.Vet;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialisationDto {
    private Long id;
    private String specName;
    private List<Vet> vets;
}
