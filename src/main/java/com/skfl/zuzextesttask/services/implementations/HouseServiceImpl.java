package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.entities.House;
import com.skfl.zuzextesttask.exceptions.custom.HouseNotFoundException;
import com.skfl.zuzextesttask.mappers.HouseMapper;
import com.skfl.zuzextesttask.repositories.HouseRepository;
import com.skfl.zuzextesttask.services.HouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    @Override
    @Transactional
    public HouseDTO createHouse(HouseDTO houseDTO) {
        House house = House.builder()
                .houseNumber(houseDTO.getHouseNumber())
                .streetName(houseDTO.getStreetName())
                .build();
        return HouseMapper.INSTANCE.toDTO(houseRepository.save(house));
    }

    @Override
    @Transactional
    public HouseDTO readHouseById(Long id) {
        return HouseMapper.INSTANCE.toDTO(houseRepository.findById(id).orElseThrow(() -> {
            throw new HouseNotFoundException("No house with such id");
        }));
    }

    @Override
    @Transactional
    public HouseDTO updateHouse(HouseDTO houseDTO, Long id) {
        Optional<House> houseToUpdate = houseRepository.findById(id);

        if (houseToUpdate.isEmpty()) {
            throw new HouseNotFoundException("No house with such id");
        }

        House houseTemplate = houseToUpdate.get();
        houseTemplate.setHouseNumber(houseDTO.getHouseNumber());
        houseTemplate.setStreetName(houseDTO.getStreetName());

        return null;
    }

    @Override
    @Transactional
    public void deleteHouseById(Long id) {
        houseRepository.deleteById(id);
    }
}
