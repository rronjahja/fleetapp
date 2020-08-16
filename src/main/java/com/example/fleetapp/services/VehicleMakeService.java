package com.example.fleetapp.services;

import com.example.fleetapp.models.VehicleMake;
import com.example.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;
    //return list of countries
    public List<VehicleMake> getVehicleMakes(){
        return vehicleMakeRepository.findAll();
    }

    //save new vehicleMake
    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }
    //get by id
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
