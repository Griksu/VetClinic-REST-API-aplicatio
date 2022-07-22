package com.crud.vetclinicback.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OWNERS")
public class Owner {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PHONE")
    private String phone;

    @OneToMany(
            targetEntity = Pet.class,
            mappedBy = "owner",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Pet> pets = new ArrayList<>();

    public Owner(String firstname, String lastname, String address,
                 String city, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }
}
