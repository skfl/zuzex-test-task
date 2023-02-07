package com.skfl.zuzextesttask.mappers.custom;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.entities.Citizen;
import com.skfl.zuzextesttask.mappers.CitizenMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.HashSet;
import java.util.Set;

@Mapper(uses = {CitizenMapper.class}, componentModel = "spring")
public abstract class CitizenCustomMapper {
    @AfterMapping
    protected void updateResult(@MappingTarget CitizenDTO.CitizenDTOBuilder citizenDTO) {
        if (citizenDTO.build().getCars() == null) {
            citizenDTO.build().setCars(new HashSet<>());
            return;
        }
        Set<CarDTO> cars = citizenDTO.build().getCars();
        for (CarDTO car : cars) {
            car.setCitizenId(citizenDTO.build().getId());
        }
        citizenDTO.cars(cars);
    }

    public abstract CitizenDTO toDTO(Citizen citizen);

    public abstract Citizen toEntity(CitizenDTO citizenDTO);
}

