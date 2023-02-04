package com.skfl.zuzextesttask.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarDTO {
    private Long id;
    @NotBlank(message = "Car brand couldn't be blank")
    private String brand;
    @NotBlank(message = "Car model name couldn't be blank")
    private String modelName;
    private String licensePlateNumber;
    //    @JsonInclude(JsonInclude.Include.NON_NULL) todo:Include.CUSTOM with content filter
    private Long citizenId;
}
