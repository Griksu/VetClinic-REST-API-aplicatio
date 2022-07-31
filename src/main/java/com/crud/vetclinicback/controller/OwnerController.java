package com.crud.vetclinicback.controller;

import com.crud.vetclinicback.exception.OwnerNotFoundException;
import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.mapper.OwnerMapper;
import com.crud.vetclinicback.model.dto.OwnerDto;
import com.crud.vetclinicback.model.entity.Owner;
import com.crud.vetclinicback.service.OwnerDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/owners")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerDBService ownerDBService;
    private final OwnerMapper ownerMapper;

    @GetMapping
    public ResponseEntity<List<OwnerDto>> getOwners() {
        List<Owner> owners = ownerDBService.getOwners();
        return ResponseEntity.ok(ownerMapper.mapToOwnerDtoList(owners));
    }

    @GetMapping(value = "{ownerId}")
    public ResponseEntity<OwnerDto> getOwner(@PathVariable Long ownerId) throws
            OwnerNotFoundException, PetNotFoundException {
        return ResponseEntity.ok(ownerMapper.mapToOwnerDto(ownerDBService.getOwner(ownerId)));
    }

    @DeleteMapping(value = "{ownerId}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<OwnerDto> updateOwner(@RequestBody OwnerDto ownerDto) throws
            PetNotFoundException {
        Owner owner = ownerMapper.mapToOwner(ownerDto);
        Owner savedOwner = ownerDBService.saveOwner(owner);
        return ResponseEntity.ok(ownerMapper.mapToOwnerDto(savedOwner));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createOwner(@RequestBody OwnerDto ownerDto) throws
            PetNotFoundException {
        Owner owner = ownerMapper.mapToOwner(ownerDto);
        ownerDBService.saveOwner(owner);
        return ResponseEntity.ok().build();
    }
}
