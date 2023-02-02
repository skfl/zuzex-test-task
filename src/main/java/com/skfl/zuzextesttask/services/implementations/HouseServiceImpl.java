package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.entities.House;
import com.skfl.zuzextesttask.repositories.HouseRepository;
import com.skfl.zuzextesttask.services.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    public HouseDTO createHouse(HouseDTO houseDTO) {
        House house = House.builder()
                .houseNumber(houseDTO.getHouseNumber())
                .streetName(houseDTO.getStreetName())
                .build();

        return null;
    }

    @Override
    public HouseDTO readHouseById(Long id) {
        return null;
    }

    @Override
    public HouseDTO updateHouse(HouseDTO houseDTO, Long id) {
        return null;
    }

    @Override
    public void deleteHouseById(Long id) {

    }
}
