package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.model.dto.PetTypeDto;
import com.crud.vetclinicback.model.entity.PetType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetTypeMapper {
    private final PetMapper petMapper;

    public PetType mapToPetType(final PetTypeDto petTypeDto) throws
            PetNotFoundException{
        return new PetType(
                petTypeDto.getId(),
                petTypeDto.getTypeName(),
                petMapper.mapToPetList(petTypeDto.getPets())
        );
    }

    public PetTypeDto mapToPetTypeDto(final PetType petType) throws
            PetNotFoundException {
        return new PetTypeDto(
                petType.getId(),
                petType.getTypeName(),
                petMapper.mapToPetDtoList(petType.getPets())
        );
    }

    public List<PetType> mapToPetTypeList(final List<PetTypeDto> petTypeDtoList) {
        List<PetType> collect = new ArrayList<>();
        for (PetTypeDto petTypeDto : petTypeDtoList) {
            PetType petType = null;
            try {
                petType = mapToPetType(petTypeDto);
            } catch (PetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(petType);
        }
        return collect;
    }

    public List<PetTypeDto> mapToPetTypeDtoList(final List<PetType> petTypeList) {
        List<PetTypeDto> collect = new ArrayList<>();
        for (PetType petType : petTypeList) {
            PetTypeDto petTypeDto = null;
            try {
                petTypeDto = mapToPetTypeDto(petType);
            } catch (PetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(petTypeDto);
        }
        return collect;
    }
}
