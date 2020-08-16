package com.example.fleetapp.controllers;
import com.example.fleetapp.models.Invoice;
import com.example.fleetapp.services.ClientService;
import com.example.fleetapp.services.InvoiceService;
import com.example.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired	private InvoiceService invoiceService;
    @Autowired	private ClientService clientService;
    @Autowired	private InvoiceStatusService invoiceStatusService;


    @GetMapping("/invoice")
    public String getInvoices(Model model) {
        model.addAttribute("invoices", invoiceService.getInvoices());

        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());

        return "Invoice";
    }
    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoice";
    }
    @RequestMapping("invoices/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<Invoice> findById(int id){
        return invoiceService.findById(id);

    }
    @RequestMapping(value = "/invoices/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoice";
    }

    @RequestMapping(value = "/invoices/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        invoiceService.delete(id);
        return "redirect:/invoice";
    }
}
