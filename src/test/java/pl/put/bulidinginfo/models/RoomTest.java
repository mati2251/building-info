package pl.put.bulidinginfo.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {
    @Test
    public void testGetHeatingPerCubeMeter() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 60.0f, 0.0f);
        assertEquals(room.getHeatingPerCubeMeter(), 2.0f);
    }

    @Test
    public void testGetLocationsWithHigherHeatingRateForRoom() {
        Room room = new Room(1, "Room", 10.0f, 10.0f, 30.0f, 0.0f);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            room.getLocationsWithHigherHeatingRate(20.0f);
        });
        assertEquals("This method cannot be used on ROOM object. This method is only used on the BUNCH OF ROOMS objects.", exception.getMessage());

    }

}