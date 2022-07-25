package com.crud.vetclinicback.service;

import com.crud.vetclinicback.model.entity.Specialisation;
import com.crud.vetclinicback.repository.SpecialisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialisationDBService {

    private final SpecialisationRepository specialisationRepository;

    public List<Specialisation> getAllSpecialisations() {
        return specialisationRepository.findAll();
    }
}
