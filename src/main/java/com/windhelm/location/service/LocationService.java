package com.windhelm.location.service;

import com.windhelm.location.entity.Location;

import java.util.List;

public interface LocationService {

    Location saveLocation(Location location);
    Location updateLocation(Location location);
    void deleteLocation(Location location);
    Location getLocationById(int id);
    List<Location> getAllLocation();
}
