package com.example.fleetapp.services;

import com.example.fleetapp.models.Employee;
import com.example.fleetapp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    //return list of employees

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
    public void save(Employee employee){
        employeeRepository.save(employee);
    }
    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }
    public void delete(Integer id){
        employeeRepository.deleteById(id);
    }
}
