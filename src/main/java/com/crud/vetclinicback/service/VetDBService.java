package com.crud.vetclinicback.service;

import com.crud.vetclinicback.exception.VetNotFoundException;
import com.crud.vetclinicback.model.entity.Vet;
import com.crud.vetclinicback.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VetDBService {

    private final VetRepository vetRepository;

    public List<Vet> getVets() {
        return vetRepository.findAll();
    }

    public Vet getVet(final Long vetId) throws VetNotFoundException {
        return vetRepository.findById(vetId).orElseThrow(VetNotFoundException::new);
    }

    public Vet saveVet(final Vet vet) {
        return vetRepository.save(vet);
    }

    public void deleteVet(final Long vetId) {
        vetRepository.deleteById(vetId);
    }
}
