package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.dtos.PassportDTO;
import com.skfl.zuzextesttask.services.CustomMethodService;
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

    @GetMapping("/car/{citizen-id}")
    public List<CarDTO> getCarsByCitizen(@PathVariable("citizen-id") @Min(0) Long citizenId) {
        return customMethodService.findCarByCitizenId(citizenId);
    }

    @GetMapping("/house")
    public List<CitizenDTO> getOwnersByStreetName(@RequestParam String streetName) {
        return customMethodService.findOwnersByHouseStreetName(streetName);
    }

    @GetMapping("/passport")
    public List<PassportDTO> getPassportDataByCitizenSecondNameFirstLetter(@RequestParam @Size(min = 1) @Size(max = 1)
                                                                           String secondNameFirstLetter) {
        return customMethodService.findPassportDataForMaleWithSecondNameStartsWithLetter(secondNameFirstLetter);
    }
}
