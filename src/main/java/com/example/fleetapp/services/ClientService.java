package com.example.fleetapp.services;

import com.example.fleetapp.models.Client;
import com.example.fleetapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    //return list of clients

    public List<Client> getClients(){
        return clientRepository.findAll();
    }
    public void save(Client client){
        clientRepository.save(client);
    }
    public Optional<Client> findById(int id){
        return clientRepository.findById(id);
    }
    public void delete(Integer id){
        clientRepository.deleteById(id);
    }
}
