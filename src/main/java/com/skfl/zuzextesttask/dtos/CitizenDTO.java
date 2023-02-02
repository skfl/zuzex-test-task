package com.skfl.zuzextesttask.dtos;

import com.skfl.zuzextesttask.entities.CitizenSex;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CitizenDTO {
    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;
    private CitizenSex sex;
}
