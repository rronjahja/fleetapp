package com.example.fleetapp.controllers;
import com.example.fleetapp.models.EmployeeType;
import com.example.fleetapp.services.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {
    @Autowired
    private EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeType")
    public String getEmployeeTypes(Model model){
    
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
  
        model.addAttribute("employeeTypes",employeeTypeList);
        return "EmployeeType"; // return employeeType.html
    }
    @PostMapping("/employeeTypes/addNew")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";
    }
    @RequestMapping("employeeTypes/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<EmployeeType> findById(int id){
        return employeeTypeService.findById(id);

    }
    @RequestMapping(value = "/employeeTypes/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeeType";
    }

    @RequestMapping(value = "/employeeTypes/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/employeeType";
    }

}
