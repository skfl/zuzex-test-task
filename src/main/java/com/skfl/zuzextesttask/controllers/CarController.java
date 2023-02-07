package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.dtos.response.DeleteResponse;
import com.skfl.zuzextesttask.services.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {
    private final CarService carService;

    @Operation(
            summary = "Find the car by its id",
            description = "Retrieves car id and return car with such id from db",
            tags = "Car",
            parameters = {@Parameter(name = "id", description = "Car id to find")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found car", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CarDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "No Сar with such id was found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid car id", content = @Content)})
    @GetMapping("{id}")
    public CarDTO getCarById(@PathVariable("id") @Min(0) Long carId) {
        return carService.readCarById(carId);
    }

    @Operation(
            summary = "Add the car to db",
            description = "Retrieves car data and put this data to db",
            tags = "Car",
            parameters = {@Parameter(name = "carDTO", description = "Car data to add")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added car", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CarDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid car data", content = @Content)})
    @PostMapping
    public CarDTO addCar(@Valid @RequestBody CarDTO carDTO) {
        return carService.createCar(carDTO);
    }

    @Operation(
            summary = "Update the car by its id",
            description = "Retrieves car id and updates car with such id from db by set values from input",
            tags = "Car",
            parameters = {@Parameter(name = "id", description = "Car id to update"), @Parameter(name = "carDTO", description = "Car data to update")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated car data", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = HouseDTO.class)))}),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "404", description = "No Сar with such id was found", content = @Content)})

    @PutMapping("{id}")
    public CarDTO updateCar(@Valid @RequestBody CarDTO carDTO, @PathVariable("id") @Min(0) Long id) {
        return carService.updateCar(carDTO, id);
    }

    @Operation(
            summary = "Delete the car by its id",
            description = "Retrieves car id and delete car with such id from db",
            tags = "Car",
            parameters = {@Parameter(name = "id", description = "Car id to delete")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful delete message", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DeleteResponse.class)))}),
            @ApiResponse(responseCode = "404", description = "No Сar with such id was found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid car id", content = @Content)})
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") @Min(0) Long id) {
        carService.deleteCarById(id);
        return ResponseEntity.ok()
                .body(DeleteResponse.builder().message("Car successfully deleted").build());
    }
}
