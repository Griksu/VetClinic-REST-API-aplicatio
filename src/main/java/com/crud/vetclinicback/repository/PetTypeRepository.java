package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

    @Override
    List<PetType> findAll();

    @Override
    Optional<PetType> findById(Long petTypeId);

    @Override
    PetType save(PetType petType);

    @Override
    void deleteById(Long petTypeId);
}
