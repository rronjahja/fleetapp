package com.example.fleetapp.services;

import com.example.fleetapp.models.Vehicle;
import com.example.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    //return list of countries
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

    //save new vehicle
    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
    //get by id
    public Optional<Vehicle> findById(int id){
        return vehicleRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
