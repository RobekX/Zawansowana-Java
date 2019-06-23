package model.enities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {


    private Room room = new Room(
            1,
            150.0,
            1,
            3,
            4,
            30.0);
    @Test
    public void getId() {
        assertEquals(Integer.valueOf(1),room.getId());
    }

    @Test
    public void getCost() {
        assertEquals(Double.valueOf(150.0),room.getCost());
    }

    @Test
    public void getRoomFloor() {
        assertEquals(Integer.valueOf(1),room.getRoomFloor());
    }

    @Test
    public void getNumberOfDoubleBeds() {
        assertEquals(Integer.valueOf(3),room.getNumberOfDoubleBeds());
    }

    @Test
    public void getNumberOfSingleBeds() {
        assertEquals(Integer.valueOf(4),room.getNumberOfSingleBeds());
    }

    @Test
    public void getSize() {
        assertEquals(Double.valueOf(30.),room.getSize());
    }

    @Test
    public void setId() {
        room.setId(2);
        assertEquals(Integer.valueOf(2),room.getId());
    }

    @Test
    public void setCost() {
        room.setCost(200.0);
        assertEquals(Double.valueOf(200.0),room.getCost());
    }

    @Test
    public void setRoomFloor() {
        room.setRoomFloor(11);
        assertEquals(Integer.valueOf(11),room.getRoomFloor());
    }

    @Test
    public void setNumberOfDoubleBeds() {
        room.setNumberOfDoubleBeds(20);
        assertEquals(Integer.valueOf(20),room.getNumberOfDoubleBeds());
    }

    @Test
    public void setNumberOfSingleBeds() {
        room.setNumberOfSingleBeds(33);
        assertEquals(Integer.valueOf(33),room.getNumberOfSingleBeds());
    }

    @Test
    public void setSize() {
        room.setSize(40.0);
        assertEquals(Double.valueOf(40.0),room.getSize());
    }

    @Test
    public void equals1() {
        Room room2 = new Room(
                2,
                150.0,
                1,
                3,
                4,
                30.0);
        assertNotEquals(room,room2);
    }


}