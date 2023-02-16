package com.skfl.zuzextesttask.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.assertFalse;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "CarUtils is working")
public class CarUtilTests {
    @Test
    public void generate_plate_number_valid_pattern() {
        assertThat(CarUtils.generateLicensePlateNumber(), matchesPattern("[A-Z]{2}[0-9]{3}[A-Z]{2}"));
    }

    @Test
    public void generate_plate_number_invalid_pattern() {
        assertFalse(CarUtils.generateLicensePlateNumber().matches("[A-Z]{2}[0-9]{1}[A-Z]{1}"));
    }
}
