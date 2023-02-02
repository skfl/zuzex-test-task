package com.skfl.zuzextesttask.repositories;

import com.skfl.zuzextesttask.entities.Passport;
import com.skfl.zuzextesttask.services.PassportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
    void deleteByCitizenId(Long citizenId);
}
