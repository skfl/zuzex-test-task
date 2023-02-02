package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.repositories.CarRepository;
import com.skfl.zuzextesttask.utils.CarUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CarLicensePlateService {
    private final CarRepository carRepository;

    @Transactional
    public String getUniquePlateNumber() {
        String carPlateNumber = CarUtils.generateLicensePlateNumber();
        while (carRepository.findByLicensePlateNumber(carPlateNumber).isPresent()) {
            carPlateNumber = CarUtils.generateLicensePlateNumber();
        }
        return carPlateNumber;
    }
}
