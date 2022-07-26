package com.crud.vetclinicback.service;

import com.crud.vetclinicback.exception.SpecialisationNotFoundException;
import com.crud.vetclinicback.model.entity.Specialisation;
import com.crud.vetclinicback.repository.SpecialisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialisationDBService {

    private final SpecialisationRepository specialisationRepository;

    public List<Specialisation> getSpecialisations() {
        return specialisationRepository.findAll();
    }

    public Specialisation getSpecialisation(final Long specialisationId) throws SpecialisationNotFoundException {
        return specialisationRepository.findById(specialisationId).orElseThrow(SpecialisationNotFoundException::new);
    }

    public Specialisation saveSpecialisation(final Specialisation specialisation) {
        return specialisationRepository.save(specialisation);
    }

    public void deleteSpecialisation(final Long specialisationId) {
        specialisationRepository.deleteById(specialisationId);
    }
}
