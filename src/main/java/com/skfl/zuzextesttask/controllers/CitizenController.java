package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.services.CitizenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citizen")
@AllArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @GetMapping("{citizen-id}")
    public CitizenDTO getCitizenById(@PathVariable("citizen-id") Long citizenId) {
        return citizenService.readCitizenById(citizenId);
    }

    @PostMapping
    public ResponseEntity<CitizenDTO> addCitizen(@RequestBody CitizenDTO citizenDTO) {
        ResponseEntity<CitizenDTO> createdCitizen = new ResponseEntity<>(citizenService.createCitizenWithPassport(citizenDTO)
                , HttpStatus.CREATED);
        return createdCitizen;
    }

    @PutMapping("{citizen-id}")
    public CitizenDTO updateCitizen(@RequestBody CitizenDTO citizenDTO, @PathVariable("citizen-id") Long citizenId) {
        return citizenService.updateCitizen(citizenDTO, citizenId);
    }


    @DeleteMapping("{citizen-id}")
    public void deleteCitizen(@PathVariable("citizen-id") Long citizenId) {
        citizenService.deleteCitizenById(citizenId);
    }
}
