package pl.put.bulidinginfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.put.bulidinginfo.models.Room;
import pl.put.bulidinginfo.models.RoomCompound;
import pl.put.bulidinginfo.models.Type;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BulidingInfoApplicationTests {

    @Autowired
    private BuildingInfoController buildingInfoController;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetCube() {
        Room room = new Room(1, "Room", 10.0f, 30.0f, 0.0f, 0.0f);
        Room room2 = new Room(2, "Room2", 20.0f, 40.0f, 0.0f, 0.0f);
        RoomCompound floor = new RoomCompound(3, "Floor", Type.FLOOR, List.of(room, room2));
        Room room3 = new Room(4, "Room3", 30.0f, 50.0f, 0.0f, 0.0f);
        Room room4 = new Room(5, "Room4", 40.0f, 20.0f, 0.0f, 0.0f);
        RoomCompound floor2 = new RoomCompound(6, "Floor2", Type.FLOOR, List.of(room3, room4));
        RoomCompound building = new RoomCompound(7, "Building", Type.BUILDING, List.of(floor, floor2));
        assertEquals(buildingInfoController.getCube(building), 140.0f);
    }

}
