package pl.put.bulidinginfo.models;

import java.util.ArrayList;
import java.util.List;

public class Room extends Location {
    public Float area;
    public Float cube;
    public Float heating;
    public Float lighting;

    public Room(Integer id, String name, Float area, Float cube, Float heating, Float lighting) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.lighting = lighting;
    }

    @Override
    public Float getArea() {
        return this.area;
    }

    @Override
    public Float getHeatingPerCubeMeter() { return (this.heating/this.cube); }

    @Override
    public List<Location> getLocationsWithHigherHeatingRate(Float thresholdRate) {
        List<Location> locations = new ArrayList<>();
        if (this.getHeatingPerCubeMeter() > thresholdRate) {
            locations.add(this);
        }
        return locations;
    }
}