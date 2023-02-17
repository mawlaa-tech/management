package com.employeMangement.management.resource;

import com.employeMangement.management.model.Employe;
import com.employeMangement.management.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeResource {
    private EmployeService employeService;

    public  EmployeeResource(EmployeService employeService){
        this.employeService = employeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employe>> getAllEMployees(){
        List<Employe> employees = employeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employe> getEMployeeById(@PathVariable("id") Long id){
        Employe employee = employeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public  ResponseEntity<Employe> addEmployee(@RequestBody Employe employe){
        Employe newEmployee =  employeService.addEmploye(employe);
         return  new ResponseEntity<>(employe, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public  ResponseEntity<Employe> updateEmployee(@RequestBody Employe employe){
        Employe updateEmployee =  employeService.updateEmployees(employe);
        return  new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
         employeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
