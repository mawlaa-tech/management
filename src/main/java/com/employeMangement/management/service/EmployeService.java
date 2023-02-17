package com.employeMangement.management.service;

import com.employeMangement.management.exception.UserNotFoundException;
import com.employeMangement.management.model.Employe;
import com.employeMangement.management.repo.EmployeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeService {
    private final EmployeRepo employeRepo;


    @Autowired
    public EmployeService( EmployeRepo employeRepo){
        this.employeRepo = employeRepo;
    }
    public Employe addEmploye( Employe employe){
        employe.setEmployeCode(UUID.randomUUID().toString());
        return employeRepo .save(employe);
    }
    public List<Employe>  findAllEmployees(){
        return employeRepo.findAll();
    }
    public  Employe updateEmployees(Employe employe){
        return  employeRepo.save(employe);
    }
    public Employe findEmployeeById(Long id){
        return employeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException( "User by " +id+ " was not found"));
    }
    public void deleteEmployee(Long id){
        employeRepo.deleteEmployeeById(id);
    }
}
