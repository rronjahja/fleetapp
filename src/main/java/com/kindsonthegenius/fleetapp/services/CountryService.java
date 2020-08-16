package com.kindsonthegenius.fleetapp.services;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //getting data from repositories
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    //return list of countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    //save new country
    public void save(Country country){
        countryRepository.save(country);
    }
    //get by id
    public Optional<Country> findById(int id){
        return countryRepository.findById(id);
    }

    public void delete(Integer id) {
      countryRepository.deleteById(id);
    }
}
