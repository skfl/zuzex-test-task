package com.skfl.zuzextesttask.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@NamedQuery(name="findCarsByCitizen",
query = "from Car where citizen.id =: citizenId")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Car brand couldn't be blank")
    private String brand;
    @NotBlank(message = "Car model name couldn't be blank")
    private String modelName;
    private String licensePlateNumber;

    @ManyToOne
    @JoinColumn(name = "citizen_id", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude

    private Citizen citizen;
}
