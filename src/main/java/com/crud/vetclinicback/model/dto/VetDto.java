package com.crud.vetclinicback.model.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VetDto {
    private Long id;
    private String firstname;
    private String lastname;
    private Long specialisationId;
    private List<VisitDto> visits;
}
