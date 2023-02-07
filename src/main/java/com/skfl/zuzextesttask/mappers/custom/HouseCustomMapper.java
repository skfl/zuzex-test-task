package com.skfl.zuzextesttask.mappers.custom;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.entities.Citizen;
import com.skfl.zuzextesttask.entities.House;
import com.skfl.zuzextesttask.mappers.HouseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.HashSet;
import java.util.Set;

@Mapper(uses = {HouseMapper.class}, componentModel = "spring")
public abstract class HouseCustomMapper {
    @AfterMapping
    public void updateResult(@MappingTarget HouseDTO.HouseDTOBuilder houseDTO, House house) {
        Set<Long> citizenIds = new HashSet<>();
        for (Citizen citizen : house.getCitizens()) {
            citizenIds.add(citizen.getId());
        }
        houseDTO.citizenIds(citizenIds);
    }

    public abstract HouseDTO toDTO(House house);

    public abstract House toEntity(HouseDTO houseDTO);
}
