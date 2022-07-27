package com.crud.vetclinicback.model.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String phone;
    private List<PetDto> pets;
}
