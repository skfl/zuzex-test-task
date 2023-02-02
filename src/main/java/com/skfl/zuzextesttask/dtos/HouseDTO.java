package com.skfl.zuzextesttask.dtos;

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
public class HouseDTO {
    @NotBlank(message = "House street name shouldn't be blank")
    private Integer houseNumber;
    @Min(value = 1, message = "House number couldn't be zero")
    private String streetName;
    private Set<Long> citizensId;
}
