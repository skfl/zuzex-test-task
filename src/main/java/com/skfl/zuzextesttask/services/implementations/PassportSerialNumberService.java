package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.repositories.PassportRepository;
import com.skfl.zuzextesttask.utils.PassportUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PassportSerialNumberService {

    private final PassportRepository passportRepository;

    @Transactional
    public String getUniquePassportSerialNumber() {
        String passportSerialNumber = PassportUtils.generatePassportSerialNumber();
        while (passportRepository.findBySerialNumber(passportSerialNumber).isPresent()) {
            passportSerialNumber = PassportUtils.generatePassportSerialNumber();
        }
        return passportSerialNumber;
    }
}
