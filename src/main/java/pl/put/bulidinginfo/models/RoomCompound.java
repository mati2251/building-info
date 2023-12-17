package pl.put.bulidinginfo.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoomCompound extends Location {

    public RoomCompound(Integer id, String name, Type type, List<Location> locations) {
        super(id, name);
        this.locations = locations;
        this.type = type;
    }

    private List<Location> locations;

    private Type type;

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void removeLocation(Location location) {
        locations.remove(location);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public Float getArea() {
        return this.getLocations().stream().map(Location::getArea).reduce(0f, Float::sum);
    }

    @Override
    public Float getCube() {
        return this.getLocations().stream().map(Location::getCube).reduce(0f, Float::sum);
    }

    @Override
    public Float getHeating() {
        return this.getLocations().stream().map(Location::getHeating).reduce(0f, Float::sum);
    }

    @Override
    public Float getHeatingPerCubeMeter() {
        return (this.getHeating()/this.getCube());
    }

    @Override
    public int getLighting() {
        return this.getLocations().stream().map(Location::getLighting).reduce(0, Integer::sum);
    }

    @Override
    public Float getLightingPower() {
        return (this.getLighting()/this.getArea());
    }

    @Override
    public List<Location> getLocationsWithHigherHeatingRate(Float thresholdRate) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : getLocations()) {
            filteredLocations.addAll(location.getLocationsWithHigherHeatingRate(thresholdRate));
        }
        return filteredLocations;
    }

}

