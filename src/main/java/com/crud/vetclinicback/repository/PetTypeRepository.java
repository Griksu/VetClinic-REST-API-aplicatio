package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

    List<PetType> findAll();

}
