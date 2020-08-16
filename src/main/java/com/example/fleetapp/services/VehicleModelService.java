package com.example.fleetapp.services;

import com.example.fleetapp.models.VehicleModel;
import com.example.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;
    //return list of countries
    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    }

    //save new vehicleModel
    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }
    //get by id
    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }
}
