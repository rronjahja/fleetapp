package com.kindsonthegenius.fleetapp.services;

import com.kindsonthegenius.fleetapp.models.Invoice;
import com.kindsonthegenius.fleetapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    //return list of countries
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    //save new invoice
    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }
    //get by id
    public Optional<Invoice> findById(int id){
        return invoiceRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
