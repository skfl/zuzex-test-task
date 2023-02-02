package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.services.CitizenService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizen")
@AllArgsConstructor
@Validated
public class CitizenController {

    private final CitizenService citizenService;

    @GetMapping("{citizen-id}")
    public CitizenDTO getCitizenById(@PathVariable("citizen-id") @Min(0) Long citizenId) {
        return citizenService.readCitizenById(citizenId);
    }

    @PostMapping
    public ResponseEntity<CitizenDTO> addCitizen(@Valid @RequestBody CitizenDTO citizenDTO) {
        ResponseEntity<CitizenDTO> createdCitizen = new ResponseEntity<>(citizenService.createCitizenWithPassport(citizenDTO)
                , HttpStatus.CREATED);
        return createdCitizen;
    }

    @PutMapping("{citizen-id}")
    public CitizenDTO updateCitizen(@Valid @RequestBody CitizenDTO citizenDTO, @PathVariable("citizen-id") @Min(0) Long citizenId) {
        return citizenService.updateCitizen(citizenDTO, citizenId);
    }


    @DeleteMapping("{citizen-id}")
    public void deleteCitizen(@PathVariable("citizen-id") @Min(0) Long citizenId) {
        citizenService.deleteCitizenById(citizenId);
    }
}
