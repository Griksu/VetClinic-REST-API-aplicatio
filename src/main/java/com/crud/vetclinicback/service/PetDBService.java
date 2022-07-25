package com.crud.vetclinicback.service;

import com.crud.vetclinicback.model.entity.Pet;
import com.crud.vetclinicback.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetDBService {

    private final PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
}
