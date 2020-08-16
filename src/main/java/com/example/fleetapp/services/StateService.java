package com.example.fleetapp.services;

import com.example.fleetapp.models.State;
import com.example.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;
    //return list of countries
    public List<State> getStates(){
        return stateRepository.findAll();
    }

    //save new state
    public void save(State state){
        stateRepository.save(state);
    }
    //get by id
    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
