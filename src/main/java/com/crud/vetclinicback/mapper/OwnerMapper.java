package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.model.dto.OwnerDto;
import com.crud.vetclinicback.model.entity.Owner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerMapper {
    private final PetMapper petMapper;

    public Owner mapToOwner(final OwnerDto ownerDto) {
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

    public OwnerDto mapToOwnerDto(final Owner owner) {
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
}
