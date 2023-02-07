package com.skfl.zuzextesttask.repositories;

import com.skfl.zuzextesttask.entities.Citizen;
import com.skfl.zuzextesttask.entities.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
    Optional<House> findById(Long id);

    @Query("select h.citizens from House h where h.streetName = ?1")
    List<Citizen> findOwnersByHouseStreetName(String streetName);
}
