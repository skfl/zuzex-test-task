package com.skfl.zuzextesttask.repositories;

import com.skfl.zuzextesttask.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findById(Long carId);

    Optional<Car> findByLicensePlateNumber(String licensePlateNumber);
}
