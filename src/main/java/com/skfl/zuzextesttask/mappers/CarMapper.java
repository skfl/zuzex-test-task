package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.entities.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(target = "citizenId", source = "car.citizen.id")
    CarDTO toDTO(Car car);

    Car toEntity(CarDTO dto);
}
