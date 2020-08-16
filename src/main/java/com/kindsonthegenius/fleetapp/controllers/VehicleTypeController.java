package com.kindsonthegenius.fleetapp.controllers;

import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.VehicleType;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {
    @Autowired
    private VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicleType")
    public String getVehicleTypes(Model model){
      
        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
     
        model.addAttribute("vehicleTypes",vehicleTypeList);
        return "VehicleType"; // return vehicleType.html
    }
    @PostMapping("/vehicleType/addNew")
    public String addNew(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }
    @RequestMapping("vehicleType/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<VehicleType> findById(int id){
        return vehicleTypeService.findById(id);

    }
    @RequestMapping(value = "/vehicleType/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicleType";
    }

    @RequestMapping(value = "/vehicleType/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        vehicleTypeService.delete(id);
        return "redirect:/vehicleType";
    }

}
