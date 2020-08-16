package com.example.fleetapp.controllers;
import com.example.fleetapp.models.Country;
import com.example.fleetapp.models.Location;
import com.example.fleetapp.models.State;
import com.example.fleetapp.services.CountryService;
import com.example.fleetapp.services.LocationService;
import com.example.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired 
    private LocationService locationService;
    
    @GetMapping("/location")
    public String getLocations(Model model){
        List<State> stateList = stateService.getStates();

        List<Country> countryList = countryService.getCountries();

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("countries",countryList);
        model.addAttribute("states",stateList);
        model.addAttribute("locations",locationList);
        return "Location"; // return location.html
    }
    @PostMapping("/location/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/location";
    }
    @RequestMapping("location/findById")
    @ResponseBody // without response body it will redirect to JSON data
    public Optional<Location> findById(int id){
        return locationService.findById(id);

    }
    @RequestMapping(value = "/location/update",method = {RequestMethod.PUT,RequestMethod.GET})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/location";
    }

    @RequestMapping(value = "/location/delete",method = {RequestMethod.DELETE,RequestMethod.GET})
    public String delete(Integer id){
        locationService.delete(id);
        return "redirect:/location";
    }

}
