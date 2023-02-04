package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.services.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("{id}")
    public CarDTO getCarById(@PathVariable("id") @Min(0) Long carId) {
        return carService.readCarById(carId);
    }

    @PostMapping
    public CarDTO addCar(@Valid @RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @PutMapping("{id}")
    public CarDTO updateCar(@Valid @RequestBody CarDTO carDTO, @PathVariable("id") @Min(0) Long id) {
        return carService.updateCar(carDTO, id);
    }

    @DeleteMapping("{id}")
    public void deleteCar(@PathVariable("id") @Min(0) Long id) {
        carService.deleteCarById(id);
    }
}
