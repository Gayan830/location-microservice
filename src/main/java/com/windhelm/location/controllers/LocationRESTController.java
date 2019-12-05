package com.windhelm.location.controllers;

import com.windhelm.location.entity.Location;
import com.windhelm.location.repo.LocationReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationReporsitory locationReporsitory;

    @GetMapping
    public List<Location> getLocations(){
        return locationReporsitory.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationReporsitory.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationReporsitory.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id){
        locationReporsitory.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable int id){
//        Optional<Location> location = locationReporsitory.findById(id);
//        if(location.isPresent()){
//            return location.get();
//        } else {
//            return new Location();
//        }
        return locationReporsitory.findById(id).get();

    }

}
