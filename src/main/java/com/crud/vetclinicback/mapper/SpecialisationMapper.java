package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.model.dto.SpecialisationDto;
import com.crud.vetclinicback.model.entity.Specialisation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialisationMapper {
    private final VetMapper vetMapper;

    public Specialisation mapToSpecialisation(final SpecialisationDto specialisationDto) {
        return new Specialisation(
                specialisationDto.getId(),
                specialisationDto.getSpecName(),
                vetMapper.mapToVetList(specialisationDto.getVets())
        );
    }

    public SpecialisationDto mapToSpecialisationDto(final Specialisation specialisation) {
        return new SpecialisationDto(
                specialisation.getId(),
                specialisation.getSpecName(),
                vetMapper.mapToVetDtoList(specialisation.getVets())
        );
    }
}
