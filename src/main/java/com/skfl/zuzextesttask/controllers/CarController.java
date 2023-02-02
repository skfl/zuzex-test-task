package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("{id}")
    public CarDTO getCarById(@PathVariable("id") Long carId) {
        return carService.readCarById(carId);
    }

    @PostMapping
    public CarDTO addCar(@RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @PutMapping("{id}")
    public CarDTO updateCar(@RequestBody CarDTO carDTO, @PathVariable("id") Long id) {
        return carService.updateCarById(carDTO, id);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.deleteCarById(id);
    }
}
