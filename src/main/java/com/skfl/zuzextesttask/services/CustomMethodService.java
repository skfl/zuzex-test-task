package com.skfl.zuzextesttask.services;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.dtos.PassportDTO;

import java.util.List;

public interface CustomMethodService {
    List<CarDTO> findCarByCitizenId(Long citizenId);

    List<CitizenDTO> findOwnersByHouseStreetName(String streetName);

    List<PassportDTO> findPassportDataForMaleWithSecondNameStartsWithLetter(String secondNameStartLetter);
}
