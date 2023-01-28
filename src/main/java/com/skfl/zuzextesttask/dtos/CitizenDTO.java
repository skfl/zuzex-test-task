package com.skfl.zuzextesttask.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CitizenDTO {
    private String firstName;
    private String secondName;
    private Integer age;
    private String sex;
}
