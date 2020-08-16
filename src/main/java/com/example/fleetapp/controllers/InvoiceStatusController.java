package com.example.fleetapp.controllers;
import com.example.fleetapp.models.InvoiceStatus;
import com.example.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatus")
    public String getInvoiceStatuss(Model model){
      
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
     
        model.addAttribute("invoiceStatuss",invoiceStatusList);
        return "InvoiceStatus"; // return invoiceStatus.html
    }
    @PostMapping("/invoiceStatus/addNew")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }
    @RequestMapping("invoiceStatus/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusService.findById(id);

    }
    @RequestMapping(value = "/invoiceStatus/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatus";
    }

    @RequestMapping(value = "/invoiceStatus/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatus";
    }

}
