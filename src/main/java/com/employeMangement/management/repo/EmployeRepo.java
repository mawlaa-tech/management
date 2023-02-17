package com.employeMangement.management.repo;

import com.employeMangement.management.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepo extends JpaRepository<Employe, Long> {
    void deleteEmployeeById(Long id);
    Optional<Employe> findEmployeeById(Long id);
}
