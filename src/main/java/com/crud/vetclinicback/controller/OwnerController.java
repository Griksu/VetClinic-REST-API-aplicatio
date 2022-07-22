package com.crud.vetclinicback.controller;

import com.crud.vetclinicback.model.dto.OwnerDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/owners")
public class OwnerController {

    @GetMapping
    public List<OwnerDto> getOwners() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{ownerId}")
    public OwnerDto getOwner(@PathVariable Long ownerId) {
        return new OwnerDto(1L, "John", "Smith",
                "39 Main Street","New York", "001058779900",
                new ArrayList<>());
    }

    @DeleteMapping
    public void deleteOwner(Long ownerId) {

    }

    @PutMapping
    public OwnerDto updateOwner(OwnerDto ownerDto) {
        return new OwnerDto(1L, "John", "Kowalski",
                "39 Main Street", "New York", "001058779900",
                new ArrayList<>());
    }

    @PostMapping
    public void createOwner(OwnerDto ownerDto) {

    }
}
