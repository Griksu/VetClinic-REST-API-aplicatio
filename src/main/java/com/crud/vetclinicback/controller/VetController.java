package com.crud.vetclinicback.controller;

import com.crud.vetclinicback.exception.SpecialisationNotFoundException;
import com.crud.vetclinicback.exception.VetNotFoundException;
import com.crud.vetclinicback.mapper.VetMapper;
import com.crud.vetclinicback.model.dto.VetDto;
import com.crud.vetclinicback.model.entity.Vet;
import com.crud.vetclinicback.service.VetDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/vets")
@RequiredArgsConstructor
public class VetController {
    private final VetDBService vetDBService;
    private final VetMapper vetMapper;

    @GetMapping
    public ResponseEntity<List<VetDto>> getVets() {
        List<Vet> vets = vetDBService.getVets();
        return ResponseEntity.ok(vetMapper.mapToVetDtoList(vets));
    }

    @GetMapping(value = "{vetId}")
    public ResponseEntity<VetDto> getVet(@PathVariable Long vetId) throws
            VetNotFoundException, SpecialisationNotFoundException {
        return ResponseEntity.ok(vetMapper.mapToVetDto(vetDBService.getVet(vetId)));
    }

    @DeleteMapping(value = "{vetId}")
    public ResponseEntity<Void> deleteVet(@PathVariable Long vetId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<VetDto> updateVet(@RequestBody VetDto vetDto) throws
            SpecialisationNotFoundException {
        Vet vet = vetMapper.mapToVet(vetDto);
        Vet savedVet = vetDBService.saveVet(vet);
        return ResponseEntity.ok(vetMapper.mapToVetDto(savedVet));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createVet(@RequestBody VetDto vetDto) throws
            SpecialisationNotFoundException {
        Vet vet = vetMapper.mapToVet(vetDto);
        vetDBService.saveVet(vet);
        return ResponseEntity.ok().build();
    }
}
