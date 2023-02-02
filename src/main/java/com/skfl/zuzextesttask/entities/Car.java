package com.skfl.zuzextesttask.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String modelName;
    private String licensePlateNumber;

    @ManyToOne
    @JoinColumn(name = "citizen_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Citizen citizen;
}
