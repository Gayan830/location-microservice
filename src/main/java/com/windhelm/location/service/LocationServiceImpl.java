package com.windhelm.location.service;

import com.windhelm.location.entity.Location;
import com.windhelm.location.repo.LocationReporsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationReporsitory locationReporsitory;

    @Override
    public Location saveLocation(Location location) {
        return locationReporsitory.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationReporsitory.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationReporsitory.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return locationReporsitory.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAllLocation() {
        return locationReporsitory.findAll();
    }

    public LocationReporsitory getLocationReporsitory() {
        return locationReporsitory;
    }

    public void setLocationReporsitory(LocationReporsitory locationReporsitory) {
        this.locationReporsitory = locationReporsitory;
    }
}
