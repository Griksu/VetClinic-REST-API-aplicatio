package com.crud.vetclinicback.service;

import com.crud.vetclinicback.exception.VisitNotFoundException;
import com.crud.vetclinicback.model.entity.Visit;
import com.crud.vetclinicback.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitDBService {

    private final VisitRepository visitRepository;

    public List<Visit> getVisits() {
        return visitRepository.findAll();
    }

    public Visit getVisit(final Long visitId) throws VisitNotFoundException {
        return visitRepository.findById(visitId).orElseThrow(VisitNotFoundException::new);
    }

    public Visit saveVisit(final Visit visit) {
        return visitRepository.save(visit);
    }

    public void deleteVisit(final Long visitId) {
        visitRepository.deleteById(visitId);
    }
}
