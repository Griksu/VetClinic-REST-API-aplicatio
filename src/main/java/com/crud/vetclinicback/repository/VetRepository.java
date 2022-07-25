package com.crud.vetclinicback.repository;

import com.crud.vetclinicback.model.entity.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface VetRepository extends CrudRepository<Vet, Long> {

    List<Vet> findAll();

}
