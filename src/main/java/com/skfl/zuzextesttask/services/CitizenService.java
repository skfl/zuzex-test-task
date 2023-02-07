package com.skfl.zuzextesttask.services;

import com.skfl.zuzextesttask.dtos.CitizenDTO;

public interface CitizenService {
    CitizenDTO createCitizenWithPassport(CitizenDTO citizenDTO);

    CitizenDTO readCitizenById(Long id);

    CitizenDTO updateCitizen(CitizenDTO citizenDTO, Long id);

    void deleteCitizenById(Long id);

    CitizenDTO getIfExist(CitizenDTO citizenDTO);
}
