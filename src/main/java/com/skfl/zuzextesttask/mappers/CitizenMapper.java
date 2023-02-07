package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.entities.Citizen;
import com.skfl.zuzextesttask.mappers.custom.CitizenCustomMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CitizenMapper {
    CitizenCustomMapper INSTANCE = Mappers.getMapper(CitizenCustomMapper.class);

    CitizenDTO toDTO(Citizen citizen);

    Citizen toEntity(CitizenDTO dto);
}
