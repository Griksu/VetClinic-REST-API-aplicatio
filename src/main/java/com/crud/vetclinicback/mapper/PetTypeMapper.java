package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.model.dto.PetTypeDto;
import com.crud.vetclinicback.model.entity.PetType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetTypeMapper {
    private final PetMapper petMapper;

    public PetType mapToPetType(final PetTypeDto petTypeDto) {
        return new PetType(
                petTypeDto.getId(),
                petTypeDto.getTypeName(),
                petMapper.mapToPetList(petTypeDto.getPets())
        );
    }

    public PetTypeDto mapToPetTypeDto(final PetType petType) {
        return new PetTypeDto(
                petType.getId(),
                petType.getTypeName(),
                petMapper.mapToPetDtoList(petType.getPets())
        );
    }
}
