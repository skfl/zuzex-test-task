package com.skfl.zuzextesttask.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private CitizenSex sex;

    @OneToOne(mappedBy = "citizen")
    private Passport passport;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "citizen_house",
            joinColumns = {@JoinColumn(name = "citizen_id")},
            inverseJoinColumns = {@JoinColumn(name = "house_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<House> houses = new HashSet<>();

    @OneToMany(mappedBy = "citizen")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Car> cars;
}
