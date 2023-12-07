package pl.put.bulidinginfo.models;

public class Room extends Location {
    public Float area;
    public Float cube;
    public Float heating;
    public Integer lighting;

    Room(Integer id, String name, Float area, Float cube, Float heating, Integer lighting) {
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
}