package com.example.fleetapp.services;

import com.example.fleetapp.models.Employee;
import com.example.fleetapp.models.User;
import com.example.fleetapp.repositories.EmployeeRepository;
import com.example.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    //return list of employees

    @Autowired
    private UserRepository userRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }

    public void assignUsername(int id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(employee.getFirstname(), employee.getLastname());
        System.out.println(user.getFirstname() + "AAAAAAAAAAAAAAAAAAAAA");
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }
}
