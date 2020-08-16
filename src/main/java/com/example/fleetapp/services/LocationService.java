package com.example.fleetapp.services;

import com.example.fleetapp.models.Location;
import com.example.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;
    //return list of countries
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    //save new location
    public void save(Location location){
        locationRepository.save(location);
    }
    //get by id
    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }
}
