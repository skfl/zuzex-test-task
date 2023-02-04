package com.skfl.zuzextesttask.dtos;

import com.skfl.zuzextesttask.entities.CitizenSex;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CitizenDTO {
    private Long id;
    @NotBlank(message = "Citizen's first name shouldn't be blank")
    private String firstName;
    @NotBlank(message = "Citizen's second name shouldn't be blank")
    private String secondName;
    @Min(value = 0, message = "Age couldn't be less than 0")
    @Max(value = 130, message = "Incorrect age")
    private Integer age;
    private CitizenSex sex;
    private Set<CarDTO> cars;
    private Set<HouseDTO> houses;
    private PassportDTO passport;
}
