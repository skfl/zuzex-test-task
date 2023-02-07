package com.skfl.zuzextesttask.repositories;

import com.skfl.zuzextesttask.entities.Citizen;
import com.skfl.zuzextesttask.entities.CitizenSex;
import com.skfl.zuzextesttask.entities.House;
import com.skfl.zuzextesttask.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    @Transactional
    @Modifying
    @Query("update Citizen c set c.houses = ?1 where c.id = ?2")
    void updateHousesByCitizenId(Set<House> houses, Long citizenId);

    Optional<Citizen> findByFirstNameAndSecondNameAndAgeAndSex(String firstName, String secondName,
                                                               Integer age, CitizenSex sex);

    Optional<Citizen> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long citizenId);
    //p.id,p.serial_number,p.citizen
    @Query(value = "select p.* from citizen c join passport p on c.id = p.citizen_id where c.second_name like CONCAT(?1,'%')",
            nativeQuery = true)
    List<Passport> findPassportDataForMaleWithSecondNameStartsWithLetter(String secondNameStartLetter);
}
