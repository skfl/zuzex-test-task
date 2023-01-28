package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.entities.Citizen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CitizenMapper {
    CitizenMapper INSTANCE = Mappers.getMapper(CitizenMapper.class);

    CitizenDTO toDTO(Citizen citizen);

    Citizen toEntity(CitizenDTO dto);
}
