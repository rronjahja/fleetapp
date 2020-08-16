package com.kindsonthegenius.fleetapp.services;

import com.kindsonthegenius.fleetapp.models.EmployeeType;
import com.kindsonthegenius.fleetapp.repositories.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    //return list of countries
    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    }

    //save new employeeType
    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }
    //get by id
    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
