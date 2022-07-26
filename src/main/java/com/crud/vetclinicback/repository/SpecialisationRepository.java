package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.Specialisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface SpecialisationRepository extends CrudRepository<Specialisation, Long> {

    @Override
    List<Specialisation> findAll();

    @Override
    Optional<Specialisation> findById(Long specialisationId);

    @Override
    Specialisation save(Specialisation specialisation);

    @Override
    void deleteById(Long specialisationId);
}
