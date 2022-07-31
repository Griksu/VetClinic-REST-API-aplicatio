package com.crud.vetclinicback.controller;

import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.exception.PetTypeNotFoundException;
import com.crud.vetclinicback.mapper.PetTypeMapper;
import com.crud.vetclinicback.model.dto.PetTypeDto;
import com.crud.vetclinicback.model.entity.PetType;
import com.crud.vetclinicback.service.PetTypeDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/petTypes")
@RequiredArgsConstructor
public class PetTypeController {
    private final PetTypeDBService petTypeDBService;
    private final PetTypeMapper petTypeMapper;

    @GetMapping
    public ResponseEntity<List<PetTypeDto>> getPetTypes() {
        List<PetType> petTypes = petTypeDBService.getPetTypes();
        return ResponseEntity.ok(petTypeMapper.mapToPetTypeDtoList(petTypes));
    }

    @GetMapping(value = "{petTypeId}")
    public ResponseEntity<PetTypeDto> getPetType(@PathVariable Long petTypeId) throws
            PetTypeNotFoundException, PetNotFoundException {
        return ResponseEntity.ok(petTypeMapper.mapToPetTypeDto(petTypeDBService.getPetType(petTypeId)));
    }

    @DeleteMapping(value = "{petTypeId}")
    public ResponseEntity<Void> deletePetType(@PathVariable Long petTypeId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<PetTypeDto> updatePetType(@RequestBody PetTypeDto petTypeDto) throws
            PetNotFoundException {
        PetType petType = petTypeMapper.mapToPetType(petTypeDto);
        PetType savedPetType = petTypeDBService.savePetType(petType);
        return ResponseEntity.ok(petTypeMapper.mapToPetTypeDto(savedPetType));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPetType(@RequestBody PetTypeDto petTypeDto) throws
            PetNotFoundException {
        PetType petType = petTypeMapper.mapToPetType(petTypeDto);
        petTypeDBService.savePetType(petType);
        return ResponseEntity.ok().build();
    }
}
