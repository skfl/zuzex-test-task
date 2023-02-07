package com.skfl.zuzextesttask.mappers;

import com.skfl.zuzextesttask.dtos.PassportDTO;
import com.skfl.zuzextesttask.entities.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassportMapper {
    PassportMapper INSTANCE = Mappers.getMapper(PassportMapper.class);

    @Mapping(target = "citizenId", source = "passport.citizen.id")
    PassportDTO toDTO(Passport passport);

    Passport toEntity(PassportDTO dto);
}
