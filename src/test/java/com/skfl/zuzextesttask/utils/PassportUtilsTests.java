package com.skfl.zuzextesttask.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.assertFalse;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "PassportUtils is working")
public class PassportUtilsTests {
    @Test
    public void generate_serial_number_valid_pattern() {
        assertThat(PassportUtils.generatePassportSerialNumber(), matchesPattern("[A-Za-z0-9]{6}"));
    }

    @Test
    public void generate_serial_number_invalid_pattern() {
        assertFalse(CarUtils.generateLicensePlateNumber().matches("[A-Za-z0-9]{3}"));
    }
}
