package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.HouseDTO;
import com.skfl.zuzextesttask.entities.House;
import com.skfl.zuzextesttask.mappers.custom.HouseCustomMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HouseMapper {
    HouseCustomMapper INSTANCE = Mappers.getMapper(HouseCustomMapper.class);

    HouseDTO toDTO(House house);

    House toEntity(HouseDTO dto);
}
