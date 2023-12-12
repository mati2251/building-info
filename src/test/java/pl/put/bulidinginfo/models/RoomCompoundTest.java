package pl.put.bulidinginfo.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomCompoundTest {
    @Test
    public void testGetAreaForFloor() {
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 0.0f, 0.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        assertEquals(floor.getArea(), 30.0f);
    }

    @Test
    public void testGetAreaForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 0.0f, 0.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 0.0f, 0.0f, 0);
        Room room4 = new Room(5, "Room4", 40.0f, 0.0f, 0.0f, 0);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));
        assertEquals(building.getArea(), 100.0f);
    }
}
