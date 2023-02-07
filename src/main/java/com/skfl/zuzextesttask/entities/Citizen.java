package com.skfl.zuzextesttask.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Citizen's first name shouldn't be blank")
    private String firstName;
    @NotBlank(message = "Citizen's second name shouldn't be blank")
    private String secondName;
    @Min(value = 0, message = "Age couldn't be less than 0")
    @Max(value = 130, message = "Incorrect age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    private CitizenSex sex;

    @OneToOne(mappedBy = "citizen")
    private Passport passport;


//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.MERGE,org.hibernate.annotations.CascadeType.PERSIST})
    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "citizen_house",
            joinColumns = {@JoinColumn(name = "citizen_id")},
            inverseJoinColumns = {@JoinColumn(name = "house_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<House> houses = new HashSet<>();

    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Car> cars;
}
