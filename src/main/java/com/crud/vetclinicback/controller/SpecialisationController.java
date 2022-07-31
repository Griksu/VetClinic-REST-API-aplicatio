package com.crud.vetclinicback.controller;

import com.crud.vetclinicback.exception.SpecialisationNotFoundException;
import com.crud.vetclinicback.exception.VetNotFoundException;
import com.crud.vetclinicback.mapper.SpecialisationMapper;
import com.crud.vetclinicback.model.dto.SpecialisationDto;
import com.crud.vetclinicback.model.entity.Specialisation;
import com.crud.vetclinicback.service.SpecialisationDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/specialisations")
@RequiredArgsConstructor
public class SpecialisationController {
    private final SpecialisationDBService specialisationDBService;
    private final SpecialisationMapper specialisationMapper;

    @GetMapping
    public ResponseEntity<List<SpecialisationDto>> getSpecialisations() {
        List<Specialisation> specialisations = specialisationDBService.getSpecialisations();
        return ResponseEntity.ok(specialisationMapper.mapToSpecialisationDtoList(specialisations));
    }

    @GetMapping(value = "{specialisationId}")
    public ResponseEntity<SpecialisationDto> getSpecialisation(@PathVariable Long specialisationId) throws
            SpecialisationNotFoundException, VetNotFoundException {
        return ResponseEntity.ok(specialisationMapper.mapToSpecialisationDto(
                specialisationDBService.getSpecialisation(specialisationId)));
    }

    @DeleteMapping(value = "{specialisationId}")
    public ResponseEntity<Void> deleteSpecialisation(@PathVariable Long specialisationId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<SpecialisationDto> updateSpecialisation(@RequestBody SpecialisationDto specialisationDto) throws
            VetNotFoundException {
        Specialisation specialisation = specialisationMapper.mapToSpecialisation(specialisationDto);
        Specialisation savedSpecialisation = specialisationDBService.saveSpecialisation(specialisation);
        return ResponseEntity.ok(specialisationMapper.mapToSpecialisationDto(savedSpecialisation));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createSpecialisation(@RequestBody SpecialisationDto specialisationDto) throws
            VetNotFoundException {
        Specialisation specialisation = specialisationMapper.mapToSpecialisation(specialisationDto);
        specialisationDBService.saveSpecialisation(specialisation);
        return ResponseEntity.ok().build();
    }
}
