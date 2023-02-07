package com.skfl.zuzextesttask.services;

import com.skfl.zuzextesttask.dtos.HouseDTO;

public interface HouseService {
    HouseDTO createHouse(HouseDTO houseDTO);

    HouseDTO readHouseById(Long id);

    HouseDTO updateHouse(HouseDTO houseDTO, Long id);

    void deleteHouseById(Long id);

}
