package com.skfl.zuzextesttask.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "citizen_id", referencedColumnName = "id")
    private Citizen citizen;

}
