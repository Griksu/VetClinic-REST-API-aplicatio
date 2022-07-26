package com.crud.vetclinicback.service;

import com.crud.vetclinicback.exception.PetTypeNotFoundException;
import com.crud.vetclinicback.model.entity.PetType;
import com.crud.vetclinicback.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetTypeDBService {

    private final PetTypeRepository petTypeRepository;

    public List<PetType> getPetTypes() {
        return petTypeRepository.findAll();
    }

    public PetType getPetType(final Long petTypeId) throws PetTypeNotFoundException {
        return petTypeRepository.findById(petTypeId).orElseThrow(PetTypeNotFoundException::new);
    }

    public PetType savePetType(final PetType petType) {
        return petTypeRepository.save(petType);
    }

    public void deletePetType(final Long petTypeId) {
        petTypeRepository.deleteById(petTypeId);
    }
}
