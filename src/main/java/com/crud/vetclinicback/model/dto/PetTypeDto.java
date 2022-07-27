package com.crud.vetclinicback.model.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetTypeDto {
    private Long id;
    private String typeName;
    private List<PetDto> pets;
}
