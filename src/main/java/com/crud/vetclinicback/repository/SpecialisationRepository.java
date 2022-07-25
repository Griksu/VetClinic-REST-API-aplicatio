package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.Specialisation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SpecialisationRepository extends CrudRepository<Specialisation, Long> {

    List<Specialisation> findAll();

}
