package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.entities.Car;
import com.skfl.zuzextesttask.exceptions.custom.CarNotFoundException;
import com.skfl.zuzextesttask.mappers.CarMapper;
import com.skfl.zuzextesttask.mappers.CitizenMapper;
import com.skfl.zuzextesttask.repositories.CarRepository;
import com.skfl.zuzextesttask.services.CarService;
import com.skfl.zuzextesttask.services.CitizenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CitizenService citizenService;
    private final CarLicensePlateService licensePlateService;

    @Override
    @Transactional
    public CarDTO createCar(CarDTO carDTO) {
        CitizenDTO citizen = citizenService.readCitizenById(carDTO.getCitizenId());
        Car carToCreate = Car.builder()
                .brand(carDTO.getBrand())
                .modelName(carDTO.getModelName())
                .citizen(CitizenMapper.INSTANCE.toEntity(citizen))
                .build();
        String carPlateNumber = licensePlateService.getUniquePlateNumber();
        carToCreate.setLicensePlateNumber(carPlateNumber);
        return CarMapper.INSTANCE.toDTO(carRepository.save(carToCreate));
    }

    @Override
    @Transactional
    public CarDTO readCarById(Long id) {
        return CarMapper.INSTANCE.toDTO(carRepository.findById(id).orElseThrow(() -> {
            throw new CarNotFoundException("There is no car with such id");
        }));
    }

    @Override
    @Transactional
    public CarDTO updateCar(CarDTO carDTO, Long id) {
        Optional<Car> carToUpdate = carRepository.findById(id);

        if (carToUpdate.isEmpty()) {
            throw new CarNotFoundException("There is no car with such id");
        }


        Car carTemplate = carToUpdate.get();

        carTemplate.setBrand(carDTO.getBrand());
        carTemplate.setModelName(carDTO.getModelName());
        carTemplate.setLicensePlateNumber(carToUpdate.get().getLicensePlateNumber());
        carTemplate.setCitizen(CitizenMapper.INSTANCE.toEntity(citizenService.readCitizenById(carDTO.getCitizenId())));

        return CarMapper.INSTANCE.toDTO(carRepository.save(carTemplate));
    }

    @Override
    @Transactional
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}
