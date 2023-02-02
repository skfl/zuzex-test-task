package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.dtos.PassportDTO;
import com.skfl.zuzextesttask.entities.Passport;
import com.skfl.zuzextesttask.mappers.CitizenMapper;
import com.skfl.zuzextesttask.mappers.PassportMapper;
import com.skfl.zuzextesttask.repositories.PassportRepository;
import com.skfl.zuzextesttask.services.PassportService;
import com.skfl.zuzextesttask.utils.PassportUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Override
    public PassportDTO createPassport(CitizenDTO citizenDTO) {
        Passport newPassport = Passport.builder()
                .serialNumber(PassportUtils.generatePassportSerialNumber())
                .citizen(CitizenMapper.INSTANCE.toEntity(citizenDTO))
                .build();
        Passport addedPassport = passportRepository.save(newPassport);
        return PassportMapper.INSTANCE.toDto(addedPassport);
    }

    @Override
    @Transactional
    public void deletePassportByCitizenId(Long citizenId) {
        passportRepository.deleteByCitizenId(citizenId);
    }
}
