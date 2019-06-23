package model.enities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
    Client   klient1 = new Client(1,"Robert","Radczyc","96111512037","Krakowska","97-500","Radomsko","517602801","robek005@gmail.com");

    @Test
    public void getId() {
        assertEquals(Integer.valueOf(1),klient1.getId());
    }

    @Test
    public void getForename() {
        assertEquals("Robert",klient1.getForename());
    }

    @Test
    public void getSurname() {
        assertEquals("Radczyc",klient1.getSurname());
    }

    @Test
    public void getPesel() {
        assertEquals("96111512037",klient1.getPesel());
    }

    @Test
    public void getStreet() {
        assertEquals("Krakowska",klient1.getStreet());
    }

    @Test
    public void getPostalCode() {
        assertEquals("97-500",klient1.getPostalCode());
    }

    @Test
    public void getCity() {
        assertEquals("Radomsko",klient1.getCity());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("517602801",klient1.getPhoneNumber());
    }

    @Test
    public void getEmailAddress() {
        assertEquals("robek005@gmail.com",klient1.getEmailAddress());
    }

    @Test
    public void setId() {
        klient1.setId(2);
        assertEquals(Integer.valueOf(2),klient1.getId());
    }

    @Test
    public void setForename() {
        klient1.setForename("Albert");
        assertEquals("Albert",klient1.getForename());
    }

    @Test
    public void setSurname() {
        klient1.setSurname("Inne");
        assertEquals("Inne",klient1.getSurname());
    }

    @Test
    public void setPesel() {
        // Bez sensu nie przejdzie validacji
    }

    @Test
    public void setStreet() {
        klient1.setStreet("Piotrkowska");
        assertEquals("Piotrkowska",klient1.getStreet());
    }

    @Test
    public void setPostalCode() {
        klient1.setPostalCode("90-303");
        assertEquals("90-303",klient1.getPostalCode());
    }

    @Test
    public void setCity() {
        klient1.setCity("Lodz");
        assertEquals("Lodz",klient1.getCity());
    }

    @Test
    public void setPhoneNumber() {
        klient1.setPhoneNumber("512524133");
        assertEquals("512524133",klient1.getPhoneNumber());
    }

    @Test
    public void setEmailAddress() {
        klient1.setEmailAddress("arkadiusz.inny@gmail.com");
        assertEquals("arkadiusz.inny@gmail.com",klient1.getEmailAddress());
    }
}