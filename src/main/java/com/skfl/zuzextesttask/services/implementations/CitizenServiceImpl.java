package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.entities.Citizen;
import com.skfl.zuzextesttask.exceptions.custom.CitizenNotFoundException;
import com.skfl.zuzextesttask.mappers.CitizenMapper;
import com.skfl.zuzextesttask.repositories.CitizenRepository;
import com.skfl.zuzextesttask.services.CitizenService;
import com.skfl.zuzextesttask.services.PassportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CitizenServiceImpl implements CitizenService {
    private final CitizenRepository citizenRepository;
    private final PassportService passportService;

    @Override
    @Transactional
    public CitizenDTO createCitizenWithPassport(CitizenDTO citizenDTO) {
        CitizenDTO foundCitizen = getIfExist(citizenDTO);
        if (foundCitizen != null) {
            return foundCitizen;
        }
        Citizen citizenToAdd = Citizen.builder()
                .age(citizenDTO.getAge())
                .firstName(citizenDTO.getFirstName())
                .secondName(citizenDTO.getSecondName())
                .sex(citizenDTO.getSex())
                .build();
        CitizenDTO citizen = CitizenMapper.INSTANCE.toDTO(citizenRepository.save(citizenToAdd));
        passportService.createPassport(citizen);
        return citizen;
    }

    @Override
    @Transactional
    public CitizenDTO readCitizenById(Long id) {
        return CitizenMapper.INSTANCE.toDTO(citizenRepository.findById(id).orElseThrow(() -> {
            throw new CitizenNotFoundException("There is no citizen with such id");
        }));
    }

    @Override
    @Transactional
    public CitizenDTO updateCitizen(CitizenDTO citizenDTO, Long citizenId) {
        Optional<Citizen> citizenToUpdate = citizenRepository.findById(citizenId);

        if (citizenToUpdate.isEmpty()) {
            throw new CitizenNotFoundException("There is no citizen with such id");
        }
        Citizen citizenTemplate = citizenToUpdate.get();

        citizenTemplate.setAge(citizenDTO.getAge());
        citizenTemplate.setSex(citizenDTO.getSex());
        citizenTemplate.setFirstName(citizenDTO.getFirstName());
        citizenTemplate.setSecondName(citizenDTO.getSecondName());

        return CitizenMapper.INSTANCE.toDTO(citizenRepository.save(citizenToUpdate.get()));
    }

    @Override
    @Transactional
    public void deleteCitizenById(Long citizenId) {
        passportService.deletePassportByCitizenId(citizenId);
        citizenRepository.deleteById(citizenId);
    }

    @Override
    public CitizenDTO getIfExist(CitizenDTO citizenDTO) {
        Optional<Citizen> foundCitizen = citizenRepository.findByFirstNameAndSecondNameAndAgeAndSex(citizenDTO.getFirstName(), citizenDTO.getSecondName(),
                citizenDTO.getAge(), citizenDTO.getSex());
        return foundCitizen.map(CitizenMapper.INSTANCE::toDTO).orElse(null);
    }
}
