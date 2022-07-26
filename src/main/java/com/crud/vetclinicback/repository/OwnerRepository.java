package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    @Override
    List<Owner> findAll();

    @Override
    Optional<Owner> findById(Long ownerId);

    @Override
    Owner save(Owner owner);

    @Override
    void deleteById(Long ownerId);
}
