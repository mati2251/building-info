package pl.put.bulidinginfo.models;

import java.util.List;
import java.util.stream.Collectors;

public class RoomCompound extends Location{

    RoomCompound(Integer id, String name, Type type, List<Location> locations) {
        super(id, name);
        this.locations = locations;
    }
    
    private List<Location> locations;

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void removeLocation(Location location) {
        locations.remove(location);
    }

    public List<Location> getLocations() {
        return locations;
    }

    @Override
    public Float getArea() {
        return this.getLocations().stream().map(location -> location.getArea()).reduce(0f, Float::sum);
    }

    @Override
    public Float getHeatingPerCubeMeter() {
        throw new UnsupportedOperationException("This method cannot be used on BUNCH OF ROOMS objects. This method is only used on the SINGLE ROOM object.");
    }

    @Override
    public List<Location> getLocationsWithHigherHeatingRate(Float thresholdRate) {
        return this.getLocations().stream().filter(location -> location.getHeatingPerCubeMeter() > thresholdRate).collect(Collectors.toList());
    }

}

