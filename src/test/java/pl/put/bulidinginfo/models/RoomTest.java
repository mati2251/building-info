package pl.put.bulidinginfo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
    @Test
    public void testGetArea() {
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0);
        assertEquals(room.getArea(), 10.0f);
    }

}
