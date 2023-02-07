package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.dtos.response.DeleteResponse;
import com.skfl.zuzextesttask.services.HouseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
@AllArgsConstructor
@Validated
public class HouseController {

    private final HouseService houseService;

    @GetMapping("{id}")
    public HouseDTO getHouseById(@PathVariable("id") @Min(0) Long id) {
        return houseService.readHouseById(id);
    }

    @PostMapping
    public HouseDTO addHouse(@Valid @RequestBody HouseDTO houseDTO) {
        return houseService.createHouse(houseDTO);
    }

    @PutMapping("{id}")
    public HouseDTO updateHouse(@Valid @RequestBody HouseDTO houseDTO, @PathVariable("id") @Min(0) Long id) {
        return houseService.updateHouse(houseDTO, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteHouse(@PathVariable("id") @Min(0) Long id) {
        houseService.deleteHouseById(id);
        return ResponseEntity.ok()
                .body(DeleteResponse.builder().message("House successfully deleted").build());
    }
}
