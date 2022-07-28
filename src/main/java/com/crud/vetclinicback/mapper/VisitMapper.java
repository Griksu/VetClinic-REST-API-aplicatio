package com.crud.vetclinicback.mapper;

import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.exception.VetNotFoundException;
import com.crud.vetclinicback.model.dto.VisitDto;
import com.crud.vetclinicback.model.entity.Visit;
import com.crud.vetclinicback.service.PetDBService;
import com.crud.vetclinicback.service.VetDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitMapper {
    private final PetDBService petDBService;
    private final VetDBService vetDBService;

    public Visit mapToVisit(final VisitDto visitDto) throws PetNotFoundException, VetNotFoundException {
        return new Visit(
                visitDto.getId(),
                visitDto.getVisitDescription(),
                visitDto.getVisitDate(),
                petDBService.getPet(visitDto.getPetId()),
                vetDBService.getVet(visitDto.getVetId())
        );
    }

    public VisitDto mapToVisitDto(final Visit visit) throws PetNotFoundException, VetNotFoundException {
        return new VisitDto(
                visit.getId(),
                visit.getVisitDescription(),
                visit.getVisitDate(),
                visit.getPet().getId(),
                visit.getVet().getId()
        );
    }

    public List<Visit> mapToVisitList(final List<VisitDto> visitDtoList) {
        List<Visit> collect = new ArrayList<>();
        for (VisitDto visitDto : visitDtoList) {
            Visit visit = null;
            try {
                visit = mapToVisit(visitDto);
            } catch (PetNotFoundException | VetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(visit);
        }
        return collect;
    }

    public List<VisitDto> mapToVisitDtoList(final List<Visit> visitList) {
        List<VisitDto> collect = new ArrayList<>();
        for (Visit visit : visitList) {
            VisitDto visitDto = null;
            try {
                visitDto = mapToVisitDto(visit);
            } catch (PetNotFoundException | VetNotFoundException e) {
                e.printStackTrace();
            }
            collect.add(visitDto);
        }
        return collect;
    }
}
