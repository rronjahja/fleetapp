package com.example.fleetapp.services;

import com.example.fleetapp.models.VehicleType;
import com.example.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    //return list of countries
    public List<VehicleType> getVehicleTypes(){
        return vehicleTypeRepository.findAll();
    }

    //save new vehicleType
    public void save(VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }
    //get by id
    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }
}
