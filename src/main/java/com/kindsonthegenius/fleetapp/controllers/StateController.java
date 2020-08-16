package com.kindsonthegenius.fleetapp.controllers;
import com.kindsonthegenius.fleetapp.models.Country;
import com.kindsonthegenius.fleetapp.models.State;
import com.kindsonthegenius.fleetapp.services.CountryService;
import com.kindsonthegenius.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/state")
    public String getStates(Model model){
        List<State> stateList = stateService.getStates();
        model.addAttribute("states",stateList);
        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries",countryList);
        return "State"; // return state.html
    }
    @PostMapping("/states/addNew")
    public String addNew(State state){
        stateService.save(state);
        return "redirect:/state";
    }
    @RequestMapping("states/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<State> findById(int id){
        return stateService.findById(id);

    }
    @RequestMapping(value = "/states/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(State state){
        stateService.save(state);
        return "redirect:/state";
    }

    @RequestMapping(value = "/state/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        stateService.delete(id);
        return "redirect:/state";
    }

}
