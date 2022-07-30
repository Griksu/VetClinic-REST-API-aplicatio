package com.crud.vetclinicback.controller;

import com.crud.vetclinicback.exception.OwnerNotFoundException;
import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.exception.PetTypeNotFoundException;
import com.crud.vetclinicback.mapper.PetMapper;
import com.crud.vetclinicback.model.dto.PetDto;
import com.crud.vetclinicback.model.entity.Pet;
import com.crud.vetclinicback.service.PetDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pets")
@RequiredArgsConstructor
public class PetController {
    private final PetDBService petDBService;
    private final PetMapper petMapper;

    @GetMapping
    public ResponseEntity<List<PetDto>> getPets() {
        List<Pet> pets = petDBService.getPets();
        return ResponseEntity.ok(petMapper.mapToPetDtoList(pets));
    }

    @GetMapping(value = "{petId}")
    public ResponseEntity<PetDto> getPet(@PathVariable Long petId) throws
            PetNotFoundException, PetTypeNotFoundException, OwnerNotFoundException {
        return ResponseEntity.ok(petMapper.mapToPetDto(petDBService.getPet(petId)));
    }

    @DeleteMapping(value = "{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable Long petId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<PetDto> updatePet(@RequestBody PetDto petDto) throws
            PetTypeNotFoundException, OwnerNotFoundException {
        Pet pet = petMapper.mapToPet(petDto);
        Pet savedPet = petDBService.savePet(pet);
        return ResponseEntity.ok(petMapper.mapToPetDto(savedPet));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPet(@RequestBody PetDto petDto) throws
            PetTypeNotFoundException, OwnerNotFoundException {
        Pet pet = petMapper.mapToPet(petDto);
        petDBService.savePet(pet);
        return ResponseEntity.ok().build();
    }
}
