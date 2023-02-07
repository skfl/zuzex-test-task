package com.skfl.zuzextesttask.repositories;

import com.skfl.zuzextesttask.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
    void deleteByCitizenId(Long citizenId);

    Optional<Passport> findBySerialNumber(String serialNumber);

    @Query(value = "select p.* from citizen c join passport p on c.id = p.citizen_id where c.second_name like CONCAT(?1,'%')",
            nativeQuery = true)
    List<Passport> findPassportDataForMaleWithSecondNameStartsWithLetter(String secondNameStartLetter);
}
