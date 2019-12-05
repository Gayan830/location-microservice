package com.windhelm.location.controllers;

import com.windhelm.location.entity.Location;
import com.windhelm.location.repo.LocationReporsitory;
import com.windhelm.location.service.LocationService;
import com.windhelm.location.util.ReportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    LocationReporsitory repository;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    ServletContext sc;

    @RequestMapping("/showCreate")
    public String showCreate(){
        return "create_location";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap){
        Location savedLocation = locationService.saveLocation(location);
        String msg = "Location saved with id: "+ savedLocation.getId();
        modelMap.addAttribute("msg",msg);
        return "create_location";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap){
        List<Location> locations = locationService.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap){
//        Location location = locationService.getLocationById(id);
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);
        locationService.getAllLocation();
        List<Location> locations = locationService.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String updateLocation(@RequestParam("id") int id,ModelMap modelMap){
        Location location = locationService.getLocationById(id);
        modelMap.addAttribute("location",location);
        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelMap){
        locationService.updateLocation(location);
        List<Location> locations = locationService.getAllLocation();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/generateReport")
    public String generateReports(){
        String path = sc.getRealPath("/");
        System.out.println(path);
        List<Object[]> data = repository.findTypeCount();
        reportUtil.generatePieChart(path,data);
        return "report";
    }

}
