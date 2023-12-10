package pl.put.bulidinginfo.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomCompoundTest {

    @Test
    public void testGetHeatingPerCubeMeterForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 0.0f);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0.0f);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            floor.getHeatingPerCubeMeter();
        });
        assertEquals("This method cannot be used on BUNCH OF ROOMS objects. This method is only used on the SINGLE ROOM object.", exception.getMessage());
    }

    @Test
    public void testGetHeatingPerCubeMeterForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 0.0f, 0.0f);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0.0f);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 20.0f, 0.0f, 0.0f);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 0.0f, 0.0f);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            building.getHeatingPerCubeMeter();
        });
        assertEquals("This method cannot be used on BUNCH OF ROOMS objects. This method is only used on the SINGLE ROOM object.", exception.getMessage());
    }

    @Test
    public void testGetLocationsWithHigherHeatingRateForFloor() {
        Room room = new Room(1, "Room", 10.0f, 10.0f, 30.0f, 0.0f);
        Room room2 = new Room(2, "Room2", 20.0f, 20.0f, 21.0f, 0.0f);
        Room room3 = new Room(3, "Room3", 20.0f, 20.0f, 20.0f, 0.0f );
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2, room3));

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            floor.getLocationsWithHigherHeatingRate(20.0f);
        });
        assertEquals("This method cannot be used on this object. This method is only used on the BUILDING object.", exception.getMessage());

    }

    @Test
    public void testGetLocationsWithHigherHeatingRateForBuilding() {
        Room room = new Room(1, "Room", 10.0f, 40.0f, 41.0f, 0.0f);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 40.0f, 0.0f);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 20.0f, 220.0f, 0.0f);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 31.0f, 0.0f);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));

        assertEquals(building.getLocationsWithHigherHeatingRate(1.0f), List.of(room, room3, room4));
    }

}
