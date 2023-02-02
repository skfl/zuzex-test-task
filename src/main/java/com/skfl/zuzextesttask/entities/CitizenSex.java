package com.skfl.zuzextesttask.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CitizenSex {
    MALE("male"),
    FEMALE("female");
    private final String sex;
}
