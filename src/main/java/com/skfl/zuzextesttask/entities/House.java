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
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetName;
    private String houseNumber;
    private Integer apartmentsNumber;

    @ManyToMany(mappedBy = "houses")
    private Set<Citizen> citizens = new HashSet<>();
}
