package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface VisitRepository extends CrudRepository<Visit, Long> {

    @Override
    List<Visit> findAll();

    @Override
    Optional<Visit> findById(Long visitId);

    @Override
    Visit save(Visit visit);

    @Override
    void deleteById(Long visitId);
}
