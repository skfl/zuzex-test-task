package com.skfl.zuzextesttask.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarDTO {
    private Long id;
    private String brand;
    private String modelName;
    private String licensePlateNumber;
    private Long citizenId;
}
