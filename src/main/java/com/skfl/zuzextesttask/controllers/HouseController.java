package com.skfl.zuzextesttask.controllers;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.services.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
@AllArgsConstructor
public class HouseController {

    private final HouseService houseService;

    @GetMapping("{id}")
    public HouseDTO getHouseById(@PathVariable("id") Long id) {
        return houseService.readHouseById(id);
    }

    @PostMapping
    public HouseDTO addHouse(@RequestBody HouseDTO houseDTO) {
        return houseService.createHouse(houseDTO);
    }

    @PutMapping("{id}")
    public HouseDTO updateHouse(@RequestBody HouseDTO houseDTO, @PathVariable("id") Long id) {
        return houseService.updateHouse(houseDTO, id);
    }

    @DeleteMapping("{id}")
    public void deleteHouse(@PathVariable("id") Long id) {
        houseService.deleteHouseById(id);
    }
}
