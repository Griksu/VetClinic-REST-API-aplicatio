package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.exception.SpecialisationNotFoundException;
import com.crud.vetclinicback.model.dto.VetDto;
import com.crud.vetclinicback.model.entity.Vet;
import com.crud.vetclinicback.service.SpecialisationDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VetMapper {
    private final SpecialisationDBService specialisationDBService;
    private final VisitMapper visitMapper;

    public Vet mapToVet(final VetDto vetDto) throws SpecialisationNotFoundException {
        return new Vet(
                vetDto.getId(),
                vetDto.getFirstname(),
                vetDto.getLastname(),
                specialisationDBService.getSpecialisation(vetDto.getSpecialisationId()),
                visitMapper.mapToVisitList(vetDto.getVisits())
        );
    }

    public VetDto mapToVetDto(final Vet vet) throws SpecialisationNotFoundException {
        return new VetDto(
                vet.getId(),
                vet.getFirstname(),
                vet.getLastname(),
                vet.getSpecialisation().getId(),
                visitMapper.mapToVisitDtoList(vet.getVisits())
        );
    }

    public List<Vet> mapToVetList(final List<VetDto> vetDtoList) {
        List<Vet> collect = new ArrayList<>();
        for (VetDto vetDto : vetDtoList) {
            Vet vet = null;
            try {
                vet = mapToVet(vetDto);
            } catch (SpecialisationNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(vet);
        }
        return collect;
    }

    public List<VetDto> mapToVetDtoList(final List<Vet> vetList) {
        List<VetDto> collect = new ArrayList<>();
        for (Vet vet : vetList) {
            VetDto vetDto = null;
            try {
                vetDto = mapToVetDto(vet);
            } catch (SpecialisationNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(vetDto);
        }
        return collect;
    }
}
