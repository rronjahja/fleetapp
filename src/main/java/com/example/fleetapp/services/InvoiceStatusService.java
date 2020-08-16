package com.example.fleetapp.services;

import com.example.fleetapp.models.InvoiceStatus;
import com.example.fleetapp.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;
    //return list of countries
    public List<InvoiceStatus> getInvoiceStatuses(){
        return invoiceStatusRepository.findAll();
    }

    //save new invoiceStatus
    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }
    //get by id
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
