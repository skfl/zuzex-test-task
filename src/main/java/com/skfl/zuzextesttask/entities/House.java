package com.skfl.zuzextesttask.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetName;
    private String houseNumber;

    @ManyToMany(mappedBy = "houses")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Citizen> citizens = new HashSet<>();
}
