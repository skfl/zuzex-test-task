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
    private Long id;
    @NotBlank(message = "House street name shouldn't be blank")
    private String streetName;
    @Min(value = 1, message = "House number couldn't be zero")
    private Integer houseNumber;

    private Set<Long> citizenIds;
}
