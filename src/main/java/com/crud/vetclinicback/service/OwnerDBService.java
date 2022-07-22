package com.crud.vetclinicback.service;

import com.crud.vetclinicback.model.entity.Owner;
import com.crud.vetclinicback.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerDBService {

    private final OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
}
