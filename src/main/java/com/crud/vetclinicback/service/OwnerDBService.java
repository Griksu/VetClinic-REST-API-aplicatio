package com.crud.vetclinicback.service;

import com.crud.vetclinicback.exception.OwnerNotFoundException;
import com.crud.vetclinicback.model.entity.Owner;
import com.crud.vetclinicback.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerDBService {

    private final OwnerRepository ownerRepository;

    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwner(final Long ownerId) throws OwnerNotFoundException {
        return ownerRepository.findById(ownerId).orElseThrow(OwnerNotFoundException::new);
    }

    public Owner saveOwner(final Owner owner) {
        return ownerRepository.save(owner);
    }

    public void deleteOwner(final Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }
}
