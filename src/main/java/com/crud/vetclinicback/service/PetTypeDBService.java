package com.crud.vetclinicback.service;

import com.crud.vetclinicback.model.entity.PetType;
import com.crud.vetclinicback.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetTypeDBService {

    private final PetTypeRepository petTypeRepository;

    public List<PetType> getAllPetTypes() {
        return petTypeRepository.findAll();
    }
}
