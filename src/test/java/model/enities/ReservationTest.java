package model.enities;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReservationTest {
    private Client klient1;
    private Room room;
    private Reservation resev;

    @Before
    public void setUp() throws Exception {
        klient1 = new Client(
                1,
                "Robert",
                "Radczyc",
                "96111512037",
                "Krakowska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");
        room = new Room(
                1,
                150.0,
                1,
                3,
                4,
                30.0);
        resev = new Reservation(
                1,
                "2019-10-22",
                "2019-10-25",
                klient1,
                room);
    }

    @Test
    public void getId() {
        assertEquals(Integer.valueOf(1),resev.getId());
    }

    @Test
    public void getStartDate() {
        assertEquals(LocalDate.of(2019,10,22),resev.getStartDate());
    }

    @Test
    public void getEndDate() {
        assertEquals(LocalDate.of(2019,10,25),resev.getEndDate());
    }

    @Test
    public void getClient() {
        assertEquals(klient1,resev.getClient());
    }

    @Test
    public void getRoom() {
        assertEquals(room,resev.getRoom());
    }


    @Test
    public void getTotalCost() {
        assertEquals(Double.valueOf(450.0),resev.getTotalCost());
    }

    @Test
    public void getDays() {
        assertEquals(Long.valueOf(3),resev.getDays());
    }

    @Test
    public void setId() {
        resev.setId(2);
        assertEquals(Integer.valueOf(2),resev.getId());
    }

    @Test
    public void setStartDate() {
        resev.setStartDate("2019-10-24");
        assertEquals(LocalDate.of(2019,10,24),resev.getStartDate());
    }

    @Test
    public void setEndDate() {
        resev.setStartDate("2019-10-28");
        assertEquals(LocalDate.of(2019,10,28),resev.getStartDate());
    }

    @Test
    public void setClient() {
       Client klient2 = new Client(
               2,
               "Andrzej",
               "Kruk",
               "96111512037",
               "Krakowska",
               "97-500",
               "Radomsko",
               "517602801",
               "robek005@gmail.com");
       resev.setClient(klient2);
        assertEquals(klient2,resev.getClient());
    }

    @Test
    public void setRoom() {
        Room room2 =  new Room(
                2,
                100.0,
                2,
                1,
                2,
                15.0);
        resev.setRoom(room2);
        assertEquals(room2,resev.getRoom());
    }
}