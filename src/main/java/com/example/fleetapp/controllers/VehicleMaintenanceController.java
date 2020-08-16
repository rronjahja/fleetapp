package com.example.fleetapp.controllers;

import com.example.fleetapp.models.VehicleMaintenance;
import com.example.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleMaintenanceController {
    @Autowired
    private VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances(Model model) {
        model.addAttribute("vehicleMaintenances", vehicleMaintenanceService.getVehicleMaintenances());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("suppliers", supplierService.getSuppliers());


        return "VehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping("vehicleMaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(int id) {
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value = "/vehicleMaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance) {
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping(value = "/vehicleMaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }
}
