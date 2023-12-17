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

    @Test
    public void testGetLightingForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 10);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 20);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        assertEquals(floor.getLighting(), 30);
    }

    @Test
    public void testGetLightingForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 0.0f, 10);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 20);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 20.0f, 0.0f, 30);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 0.0f, 40);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));
        assertEquals(building.getLighting(), 100);
    }

    @Test
    public void testGetLightingPowerForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 30);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 90);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        assertEquals(floor.getLightingPower(), 4.0f);
    }

    @Test
    public void testGetLightingPowerForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 0.0f, 100);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 50);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 20.0f, 0.0f, 300);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 0.0f, 30);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));
        assertEquals(building.getLightingPower(), 4.8f);
    }


    @Test
    public void testGetCubeForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        assertEquals(floor.getCube(), 70.0f);
    }

    @Test
    public void testGetCubeForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 0.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 20.0f, 0.0f, 0);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 0.0f, 0);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));
        assertEquals(building.getCube(), 130.0f);
    }

    @Test
    public void testGetHeatingForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 30.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 40.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        assertEquals(floor.getHeating(), 70.0f);
    }

    @Test
    public void testGetHeatingForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 40.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 60.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 60.0f, 20.0f, 80.0f, 0);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 20.0f, 0);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));
        assertEquals(building.getHeating(), 200.0f);
    }

    @Test
    public void testGetHeatingPerCubeMeterForFloor() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 80.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 60.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        assertEquals(floor.getHeatingPerCubeMeter(), 2.0f);
}

    @Test
    public void testGetHeatingPerCubeMeterForBuilding(){
        Room room = new Room(1, "Room", 10.0f, 40.0f, 40.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 60.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 60.0f, 50.0f, 80.0f, 0);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 20.0f, 0);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));
        assertEquals(building.getHeatingPerCubeMeter(), 1.25f);
    }

    @Test
    public void testGetLocationsWithHigherHeatingRateForFloor() {
        Room room = new Room(1, "Room", 10.0f, 10.0f, 30.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 20.0f, 21.0f, 0);
        Room room3 = new Room(3, "Room3", 20.0f, 20.0f, 20.0f, 0;
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2, room3));

        assertEquals(floor.getLocationsWithHigherHeatingRate(1.0f), List.of(room, room2));

    }

    @Test
    public void testGetLocationsWithHigherHeatingRateForBuilding() {
        Room room = new Room(1, "Room", 10.0f, 40.0f, 41.0f, 0);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 40.0f, 0);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 20.0f, 220.0f, 0);
        Room room4 = new Room(5, "Room4", 40.0f, 30.0f, 31.0f, 0);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));

        assertEquals(building.getLocationsWithHigherHeatingRate(1.0f), List.of(room, room3, room4));
    }
}