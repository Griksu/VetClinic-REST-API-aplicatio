package com.crud.vetclinicback.model.dto;

import com.crud.vetclinicback.model.entity.Pet;
import com.crud.vetclinicback.model.entity.Vet;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDto {
    private Long id;
    private String visitDescription;
    private LocalDate visitDate;
    private Long petId;
    private Long vetId;

}
