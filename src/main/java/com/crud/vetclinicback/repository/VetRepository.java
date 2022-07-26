package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface VetRepository extends CrudRepository<Vet, Long> {

    @Override
    List<Vet> findAll();

    @Override
    Optional<Vet> findById(Long vetId);

    @Override
    Vet save(Vet vet);

    @Override
    void deleteById(Long vetId);
}
