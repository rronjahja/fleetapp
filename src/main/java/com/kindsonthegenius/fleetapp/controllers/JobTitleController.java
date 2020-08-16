package com.kindsonthegenius.fleetapp.controllers;
import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.JobTitle;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.JobTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {
    @Autowired
    private JobTitleService jobTitleService;

    @GetMapping("/jobTitle")
    public String getJobTitles(Model model){

        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
 
        model.addAttribute("jobTitles",jobTitleList);
        return "JobTitle"; // return jobTitle.html
    }
    @PostMapping("/jobTitle/addNew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }
    @RequestMapping("jobTitle/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<JobTitle> findById(int id){
        return jobTitleService.findById(id);

    }
    @RequestMapping(value = "/jobTitle/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobTitle";
    }

    @RequestMapping(value = "/jobTitle/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        jobTitleService.delete(id);
        return "redirect:/jobTitle";
    }

}
