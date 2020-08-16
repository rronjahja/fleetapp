package com.kindsonthegenius.fleetapp.controllers;
import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.VehicleMake;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
    @Autowired
    private VehicleMakeService vehicleMakeService;

    @GetMapping("/vehicleMake")
    public String getVehicleMakes(Model model){

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();

        model.addAttribute("vehicleMakes",vehicleMakeList);
        return "VehicleMake"; // return vehicleMake.html
    }
    @PostMapping("/vehicleMake/addNew")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }
    @RequestMapping("vehicleMake/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeService.findById(id);

    }
    @RequestMapping(value = "/vehicleMake/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehicleMake";
    }

    @RequestMapping(value = "/vehicleMake/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        vehicleMakeService.delete(id);
        return "redirect:/vehicleMake";
    }

}
