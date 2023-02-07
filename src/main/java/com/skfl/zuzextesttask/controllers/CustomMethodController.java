package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.dtos.PassportDTO;
import com.skfl.zuzextesttask.services.CustomMethodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custom")
@Validated
@AllArgsConstructor
public class CustomMethodController {

    private final CustomMethodService customMethodService;

    @Operation(
            summary = "Find cars by owner id",
            description = "Retrieves citizen id and return all his cars",
            tags = "Custom",
            parameters = {@Parameter(name = "citizenId", description = "Citizen id to find cars")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of citizen cars", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CarDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "No Citizen with such id was found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid citizen id", content = @Content)})
    @GetMapping("/car/{citizen-id}")
    public List<CarDTO> getCarsByCitizen(@PathVariable("citizen-id") @Min(0) Long citizenId) {
        return customMethodService.findCarByCitizenId(citizenId);
    }

    @Operation(
            summary = "Find owners of houses by street name",
            description = "Retrieves street name and return all owners on this street",
            tags = "Custom",
            parameters = {@Parameter(name = "streetName", description = "Street name to find owners")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of owners", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CitizenDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "No House with such street name was found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid street name", content = @Content)})
    @GetMapping("/house")
    public List<CitizenDTO> getOwnersByStreetName(@RequestParam String streetName) {
        return customMethodService.findOwnersByHouseStreetName(streetName);
    }

    @Operation(
            summary = "Find passport data for all male citizens with second name that starts with some letter",
            description = "Retrieves letter and return passport data",
            tags = "Custom",
            parameters = {@Parameter(name = "secondNameFirstLetter", description = "Second name first Letter to find passport data")}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of passport data", content = {
                    @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CitizenDTO.class)))}),
            @ApiResponse(responseCode = "404", description = "No Citizen with such second name was found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid first letter", content = @Content)})
    @GetMapping("/passport")
    public List<PassportDTO> getPassportDataByCitizenSecondNameFirstLetter(@RequestParam @Size(min = 1) @Size(max = 1)
                                                                           String secondNameFirstLetter) {
        return customMethodService.findPassportDataForMaleWithSecondNameStartsWithLetter(secondNameFirstLetter);
    }
}
