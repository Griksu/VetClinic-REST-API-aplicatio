package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PetRepository extends CrudRepository<Pet, Long> {

    @Override
    List<Pet> findAll();

    @Override
    Optional<Pet> findById(Long petId);

    @Override
    Pet save(Pet pet);

    @Override
    void deleteById(Long petId);
}
