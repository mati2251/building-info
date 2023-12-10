package pl.put.bulidinginfo.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoomCompound extends Location{

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

    public Type getType() { return this.type; }

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
        if (getType() != Type.BUILDING) {
            throw new UnsupportedOperationException("This method cannot be used on this object. This method is only used on the BUILDING object.");
        }

        List<Location> filteredLocations = new ArrayList<>();
        for (Location floor : getLocations()) {
            if (floor instanceof RoomCompound) {
                for (Location room : ((RoomCompound) floor).getLocations()) {
                    if (room.getHeatingPerCubeMeter() > thresholdRate) {
                        filteredLocations.add(room);
                    }
                }
            }
        }
        return filteredLocations;
    }
}

