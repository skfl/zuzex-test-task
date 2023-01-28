package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.PassportDTO;
import com.skfl.zuzextesttask.entities.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassportMapper {
    PassportMapper INSTANCE = Mappers.getMapper(PassportMapper.class);

    PassportDTO toDto(Passport passport);

    Passport toEntity(PassportDTO dto);
}
