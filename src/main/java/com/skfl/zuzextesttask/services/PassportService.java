package com.skfl.zuzextesttask.services;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.dtos.PassportDTO;

public interface PassportService {
    PassportDTO createPassport(CitizenDTO citizenDTO);

    void deletePassportByCitizenId(Long citizenId);
}
