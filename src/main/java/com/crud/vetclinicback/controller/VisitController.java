package com.crud.vetclinicback.controller;

import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.exception.VetNotFoundException;
import com.crud.vetclinicback.exception.VisitNotFoundException;
import com.crud.vetclinicback.mapper.VisitMapper;
import com.crud.vetclinicback.model.dto.VisitDto;
import com.crud.vetclinicback.model.entity.Visit;
import com.crud.vetclinicback.service.VisitDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/visits")
@RequiredArgsConstructor
public class VisitController {
    private final VisitDBService visitDBService;
    private final VisitMapper visitMapper;

    @GetMapping
    public ResponseEntity<List<VisitDto>> getVisits() {
        List<Visit> visits = visitDBService.getVisits();
        return ResponseEntity.ok(visitMapper.mapToVisitDtoList(visits));
    }

    @GetMapping(value = "{visitId}")
    public ResponseEntity<VisitDto> getVisit(@PathVariable Long visitId) throws
            VisitNotFoundException, VetNotFoundException, PetNotFoundException {
        return ResponseEntity.ok(visitMapper.mapToVisitDto(visitDBService.getVisit(visitId)));
    }

    @DeleteMapping(value = "{visitId}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long visitId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<VisitDto> updateVisit(@RequestBody VisitDto visitDto) throws
            VetNotFoundException, PetNotFoundException {
        Visit visit = visitMapper.mapToVisit(visitDto);
        Visit savedVisit = visitDBService.saveVisit(visit);
        return ResponseEntity.ok(visitMapper.mapToVisitDto(savedVisit));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVisit(@RequestBody VisitDto visitDto) throws
            VetNotFoundException, PetNotFoundException {
        Visit visit = visitMapper.mapToVisit(visitDto);
        visitDBService.saveVisit(visit);
        return ResponseEntity.ok().build();
    }
}
