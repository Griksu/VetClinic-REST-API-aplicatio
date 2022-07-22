package com.crud.vetclinicback.model.dto;

import com.crud.vetclinicback.model.entity.Pet;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetTypeDto {
    private Long id;
    private String typeName;
    private List<Pet> pets;
}
