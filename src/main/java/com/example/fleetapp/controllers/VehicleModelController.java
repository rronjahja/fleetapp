package com.example.fleetapp.controllers;
import com.example.fleetapp.models.VehicleModel;
import com.example.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {
    @Autowired
    private VehicleModelService vehicleModelService;

    @GetMapping("/vehicleModel")
    public String getVehicleModels(Model model){
      
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
       
        model.addAttribute("vehicleModels",vehicleModelList);
        return "VehicleModel"; // return vehicleModel.html
    }
    @PostMapping("/vehicleModel/addNew")
    public String addNew(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }
    @RequestMapping("vehicleModel/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<VehicleModel> findById(int id){
        return vehicleModelService.findById(id);

    }
    @RequestMapping(value = "/vehicleModel/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehicleModel";
    }

    @RequestMapping(value = "/vehicleModel/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        vehicleModelService.delete(id);
        return "redirect:/vehicleModel";
    }

}
