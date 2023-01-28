package com.skfl.zuzextesttask.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;
    private String sex;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Citizen_House",
            joinColumns = {@JoinColumn(name = "citizen_id")},
            inverseJoinColumns = {@JoinColumn(name = "house_id")})
    private Set<House> houses = new HashSet<>();

    @OneToMany(mappedBy = "citizen")
    private Set<Car> cars;
}
