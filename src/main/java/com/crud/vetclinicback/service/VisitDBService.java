package com.crud.vetclinicback.service;

import com.crud.vetclinicback.model.entity.Visit;
import com.crud.vetclinicback.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitDBService {

    private final VisitRepository visitRepository;

    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }
}
