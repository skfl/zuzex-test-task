package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.entities.House;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HouseMapper {
    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);

    HouseDTO toDTO(House house);

    House toEntity(HouseDTO dto);
}
