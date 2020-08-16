package com.example.fleetapp.controllers;
import com.example.fleetapp.models.VehicleStatus;
import com.example.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {
    @Autowired
    private VehicleStatusService vehicleStatusService;

    @GetMapping("/vehicleStatuses")
    public String getVehicleStatuses(Model model){

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuses();
        model.addAttribute("vehicleStatuses",vehicleStatusList);
        return "VehicleStatus"; // return vehicleStatus.html
    }
    @PostMapping("/vehicleStatuses/addNew")
    public String addNew(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }
    @RequestMapping("vehicleStatuses/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusService.findById(id);

    }
    @RequestMapping(value = "/vehicleStatuses/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehicleStatuses";
    }

    @RequestMapping(value = "/vehicleStatuses/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        vehicleStatusService.delete(id);
        return "redirect:/vehicleStatuses";
    }

}
