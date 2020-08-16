package com.example.fleetapp.controllers;

import com.example.fleetapp.models.Vehicle;
import com.example.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleController {
    //We need Location, Employee, Vehicle Make, Vehicle Status
    //Vehicle Type,Vehicle Model and Vehicle.
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleStatusService vehicleStatusService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicles")
    public String getVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("employees", employeeService.getEmployees());
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
        model.addAttribute("vehicleStatuses", vehicleStatusService.getVehicleStatuses());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        model.addAttribute("vehicleModels", vehicleModelService.getVehicleModels());

        return "Vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id) {
        return vehicleService.findById(id);
    }

    @RequestMapping(value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle) {
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
