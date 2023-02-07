package com.skfl.zuzextesttask.services.implementations;

import com.skfl.zuzextesttask.dtos.CarDTO;
import com.skfl.zuzextesttask.dtos.CitizenDTO;
import com.skfl.zuzextesttask.dtos.PassportDTO;
import com.skfl.zuzextesttask.entities.Car;
import com.skfl.zuzextesttask.entities.Citizen;
import com.skfl.zuzextesttask.entities.Passport;
import com.skfl.zuzextesttask.mappers.CarMapper;
import com.skfl.zuzextesttask.mappers.CitizenMapper;
import com.skfl.zuzextesttask.mappers.PassportMapper;
import com.skfl.zuzextesttask.repositories.CitizenRepository;
import com.skfl.zuzextesttask.repositories.HouseRepository;
import com.skfl.zuzextesttask.repositories.PassportRepository;
import com.skfl.zuzextesttask.services.CustomMethodService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomMethodServiceImpl implements CustomMethodService {

    private final HouseRepository houseRepository;
    private final CitizenRepository citizenRepository;
    private final PassportRepository passportRepository;
    private final EntityManager entityManager;

    @Override
    @Transactional
    public List<CarDTO> findCarByCitizenId(Long citizenId) {
        Session session = entityManager.unwrap(Session.class);
        Query<Car> query = session.createNamedQuery("findCarsByCitizen", Car.class);
        query.setParameter("citizenId", citizenId);
        List<Car> resultEntities = query.getResultList();
        if (resultEntities.isEmpty()) {
            return null;
        }
        List<CarDTO> result = new ArrayList<>();
        for (Car car : resultEntities) {
            result.add(CarMapper.INSTANCE.toDTO(car));
        }
        return result;
    }

    @Override
    public List<CitizenDTO> findOwnersByHouseStreetName(String streetName) {
        List<Citizen> resultEntities = houseRepository.findOwnersByHouseStreetName(streetName);
        if (resultEntities.isEmpty()) {
            return null;
        }
        List<CitizenDTO> result = new ArrayList<>();
        for (Citizen citizen : resultEntities) {
            result.add(CitizenMapper.INSTANCE.toDTO(citizen));
        }
        return result;
    }

    @Override
    public List<PassportDTO> findPassportDataForMaleWithSecondNameStartsWithLetter(String secondNameStartLetter) {
        List<Passport> resultEntities =
                passportRepository.findPassportDataForMaleWithSecondNameStartsWithLetter(secondNameStartLetter);
        if (resultEntities.isEmpty()) {
            return null;
        }
        List<PassportDTO> result = new ArrayList<>();
        for (Passport passport : resultEntities) {
            result.add(PassportMapper.INSTANCE.toDTO(passport));
        }
        return result;
    }
}
