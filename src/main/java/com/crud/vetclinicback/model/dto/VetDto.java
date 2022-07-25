package com.crud.vetclinicback.model.dto;

import com.crud.vetclinicback.model.entity.Specialisation;
import com.crud.vetclinicback.model.entity.Visit;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VetDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Specialisation specialisation;
    private List<Visit> visits;
}
