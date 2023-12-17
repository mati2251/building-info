package pl.put.bulidinginfo.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Room.class, name = "ROOM"),
    @JsonSubTypes.Type(value = RoomCompound.class, name = "BUILDING"),
    @JsonSubTypes.Type(value = RoomCompound.class, name = "FLOOR")
})
public abstract class Location {
    public Integer id;
    public String name;
    public Type type;
    abstract public Float getArea();

    abstract public Float getCube();

    abstract public int getLighting();

    abstract public Float getLightingPower();

    Location(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
