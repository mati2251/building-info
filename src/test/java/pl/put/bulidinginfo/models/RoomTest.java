package pl.put.bulidinginfo.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.codec.json.Jackson2JsonEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {
    @Test
    public void testGetArea() {
        Room room = new Room(1, "Room", 10.0f, 0.0f, 0.0f, 0.0f);
        assert room.getArea() == 10.0f;
    }

}
