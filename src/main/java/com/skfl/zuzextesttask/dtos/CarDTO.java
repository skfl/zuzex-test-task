package com.skfl.zuzextesttask.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarDTO {
    private String brand;
    private String modelName;
    private String licensePlateNumber;
}
