package com.skfl.zuzextesttask.services;

import com.skfl.zuzextesttask.dtos.CarDTO;

public interface CarService {
    CarDTO createCar(CarDTO carDTO);

    CarDTO readCarById(Long carId);

    CarDTO updateCarById(CarDTO carDTO, Long carId);

    void deleteCarById(Long carId);
}
