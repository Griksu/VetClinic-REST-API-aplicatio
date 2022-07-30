package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.model.dto.OwnerDto;
import com.crud.vetclinicback.model.entity.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerMapper {
    private final PetMapper petMapper;

    public Owner mapToOwner(final OwnerDto ownerDto) throws PetNotFoundException {
        return new Owner(
                ownerDto.getId(),
                ownerDto.getFirstname(),
                ownerDto.getLastname(),
                ownerDto.getAddress(),
                ownerDto.getCity(),
                ownerDto.getPhone(),
                petMapper.mapToPetList(ownerDto.getPets())
        );
    }

    public OwnerDto mapToOwnerDto(final Owner owner) throws PetNotFoundException {
        return new OwnerDto(
                owner.getId(),
                owner.getFirstname(),
                owner.getLastname(),
                owner.getAddress(),
                owner.getCity(),
                owner.getPhone(),
                petMapper.mapToPetDtoList(owner.getPets())
        );
    }

    public List<Owner> mapToOwnerList(final List<OwnerDto> ownerDtoList) {
        List<Owner> collect = new ArrayList<>();
        for (OwnerDto ownerDto : ownerDtoList) {
            Owner owner = null;
            try {
                owner = mapToOwner(ownerDto);
            } catch (PetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(owner);
        }
        return collect;
    }

    public List<OwnerDto> mapToOwnerDtoList(final List<Owner> ownerList) {
        List<OwnerDto> collect = new ArrayList<>();
        for (Owner owner : ownerList) {
            OwnerDto ownerDto = null;
            try {
                ownerDto = mapToOwnerDto(owner);
            } catch (PetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(ownerDto);
        }
        return collect;
    }
}
