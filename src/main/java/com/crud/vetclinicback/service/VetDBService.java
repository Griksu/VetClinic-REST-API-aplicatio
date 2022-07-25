package com.crud.vetclinicback.service;

import com.crud.vetclinicback.model.entity.Vet;
import com.crud.vetclinicback.repository.VetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VetDBService {

    private final VetRepository vetRepository;

    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }
}
