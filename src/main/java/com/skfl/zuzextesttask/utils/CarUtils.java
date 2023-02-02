package com.skfl.zuzextesttask.utils;

import lombok.experimental.UtilityClass;
import net.moznion.random.string.RandomStringGenerator;

@UtilityClass
public class CarUtils {
    public static String generateLicensePlateNumber() {
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator();
        return randomStringGenerator.generateByRegex("[A-Z]{2}[0-9]{3}[A-Z]{2}");
    }
}
