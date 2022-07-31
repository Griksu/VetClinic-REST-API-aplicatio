package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.exception.VetNotFoundException;
import com.crud.vetclinicback.model.dto.SpecialisationDto;
import com.crud.vetclinicback.model.entity.Specialisation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialisationMapper {
    private final VetMapper vetMapper;

    public Specialisation mapToSpecialisation(final SpecialisationDto specialisationDto) throws
            VetNotFoundException{
        return new Specialisation(
                specialisationDto.getId(),
                specialisationDto.getSpecName(),
                vetMapper.mapToVetList(specialisationDto.getVets())
        );
    }

    public SpecialisationDto mapToSpecialisationDto(final Specialisation specialisation) throws
            VetNotFoundException {
        return new SpecialisationDto(
                specialisation.getId(),
                specialisation.getSpecName(),
                vetMapper.mapToVetDtoList(specialisation.getVets())
        );
    }

    public List<Specialisation> mapToSpecialisationList(final List<SpecialisationDto> specialisationDtoList) {
        List<Specialisation> collect = new ArrayList<>();
        for (SpecialisationDto specialisationDto : specialisationDtoList) {
            Specialisation specialisation = null;
            try {
                specialisation = mapToSpecialisation(specialisationDto);
            } catch (VetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(specialisation);
        }
        return collect;
    }

    public List<SpecialisationDto> mapToSpecialisationDtoList(final List<Specialisation> specialisationList) {
        List<SpecialisationDto> collect = new ArrayList<>();
        for (Specialisation specialisation : specialisationList) {
            SpecialisationDto specialisationDto = null;
            try {
                specialisationDto = mapToSpecialisationDto(specialisation);
            } catch (VetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(specialisationDto);
        }
        return collect;
    }
}
