package com.crud.vetclinicback.service;

import com.crud.vetclinicback.exception.PetNotFoundException;
import com.crud.vetclinicback.model.entity.Pet;
import com.crud.vetclinicback.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetDBService {

    private final PetRepository petRepository;

    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    public Pet getPet(final Long petId) throws PetNotFoundException {
        return petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
    }

    public Pet savePet(final Pet pet) {
        return petRepository.save(pet);
    }

    public void deletePet(final Long petId) {
        petRepository.deleteById(petId);
    }
}
