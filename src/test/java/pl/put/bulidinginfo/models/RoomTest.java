package pl.put.bulidinginfo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
    @Test
    public void testGetCube() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 0);
        assertEquals(room.getCube(), 30.0f);
    }

    @Test
    public void testGetArea() {
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0);
        assertEquals(room.getArea(), 10.0f);
    }

    @Test
    public void testGetHeating() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 30.0f, 0);
        assertEquals(room.getHeating(), 30.0f);
    }

    @Test
    public void testGetHeatingPerCubeMeter() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 30.0f, 0);
        assertEquals(room.getHeatingPerCubeMeter(), 1.0f);
    }
}
