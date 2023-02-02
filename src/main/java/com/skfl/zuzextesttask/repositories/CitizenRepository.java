package com.skfl.zuzextesttask.repositories;

import com.skfl.zuzextesttask.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Optional<Citizen> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long citizenId);

}
