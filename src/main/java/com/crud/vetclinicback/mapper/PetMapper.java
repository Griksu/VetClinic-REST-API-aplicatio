package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.exception.OwnerNotFoundException;
import com.crud.vetclinicback.exception.PetTypeNotFoundException;
import com.crud.vetclinicback.model.dto.PetDto;
import com.crud.vetclinicback.model.entity.Pet;
import com.crud.vetclinicback.service.OwnerDBService;
import com.crud.vetclinicback.service.PetTypeDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetMapper {
    private final OwnerDBService ownerDBService;
    private final PetTypeDBService petTypeDBService;
    private final VisitMapper visitMapper;

    public Pet mapToPet(final PetDto petDto) throws OwnerNotFoundException, PetTypeNotFoundException {
        return new Pet(
                petDto.getId(),
                petDto.getPetName(),
                petDto.getBirthDate(),
                ownerDBService.getOwner(petDto.getOwnerId()),
                petTypeDBService.getPetType(petDto.getPetTypeId()),
                visitMapper.mapToVisitList(petDto.getVisits())
        );
    }

    public PetDto mapToPetDto(final Pet pet) throws OwnerNotFoundException, PetTypeNotFoundException {
        return new PetDto(
                pet.getId(),
                pet.getPetName(),
                pet.getBirthDate(),
                pet.getOwner().getId(),
                pet.getPetType().getId(),
                visitMapper.mapToVisitDtoList(pet.getVisits())
        );
    }

    public List<PetDto> mapToPetDtoList(final List<Pet> petList) {
        List<PetDto> collect = new ArrayList<>();
        for (Pet pet : petList) {
            PetDto petDto = null;
            try {
                petDto = mapToPetDto(pet);
            } catch (OwnerNotFoundException | PetTypeNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(petDto);
        }
        return collect;
    }

    public List<Pet> mapToPetList(final List<PetDto> petDtoList) {
        List<Pet> collect = new ArrayList<>();
        for (PetDto petDto : petDtoList) {
            Pet pet = null;
            try {
                pet = mapToPet(petDto);
            } catch (OwnerNotFoundException | PetTypeNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(pet);
        }
        return collect;
    }
}
