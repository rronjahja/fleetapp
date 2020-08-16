package com.example.fleetapp.services;

import com.example.fleetapp.models.VehicleHire;
import com.example.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {
    @Autowired
    private VehicleHireRepository vehicleHireRepository;
    //return list of countries
    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    //save new vehicleHire
    public void save(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }
    //get by id
    public Optional<VehicleHire> findById(int id){
        return vehicleHireRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
