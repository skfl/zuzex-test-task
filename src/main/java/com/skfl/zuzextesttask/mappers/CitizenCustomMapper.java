package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.entities.Citizen;
import org.mapstruct.AfterMapping;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(uses = {CitizenMapper.class}, componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class CitizenCustomMapper {
    @AfterMapping
    protected void updateResult(@MappingTarget CitizenDTO.CitizenDTOBuilder citizenDTO) {
        Set<CarDTO> cars = citizenDTO.build().getCars();
        for (CarDTO car : cars) {
            car.setCitizenId(citizenDTO.build().getId());
        }
        citizenDTO.cars(cars);
    }

    public abstract CitizenDTO toDTO(Citizen citizen);
    public abstract Citizen toEntity(CitizenDTO citizenDTO);
}

