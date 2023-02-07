package com.skfl.zuzextesttask.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PassportDTO {
    private Long id;
    private String serialNumber;
    private Long citizenId;
}
