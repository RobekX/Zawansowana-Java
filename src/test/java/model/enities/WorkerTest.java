package model.enities;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorkerTest {
private Worker emplo = new Worker(
        1,
        "login",
        "haslo",
        "nazwisko",
        "imie",
        true);
    @Test
    public void getId() {
        assertEquals(Integer.valueOf(1),emplo.getId());
    }

    @Test
    public void getLogin() {
        assertEquals("login",emplo.getLogin());
    }

    @Test
    public void getPassword() {
        assertEquals("haslo",emplo.getPassword());
    }

    @Test
    public void getForename() {
        assertEquals("nazwisko",emplo.getForename());
    }

    @Test
    public void getSurname() {
        assertEquals("imie",emplo.getSurname());
    }

    @Test
    public void getIsAdmin() {
        assertEquals(true,emplo.getIsAdmin());
    }

    @Test
    public void setId() {
        emplo.setId(2);
        assertEquals(Integer.valueOf(2),emplo.getId());
    }

    @Test
    public void setLogin() {
        emplo.setLogin("login1");
        assertEquals("login1",emplo.getLogin());
    }

    @Test
    public void setPassword() {
        emplo.setPassword("login1");
        assertEquals("login1",emplo.getPassword());
    }

    @Test
    public void setForename() {
        emplo.setForename("login1");
        assertEquals("login1",emplo.getForename());
    }

    @Test
    public void setSurname() {
        emplo.setSurname("login1");
        assertEquals("login1",emplo.getSurname());
    }

    @Test
    public void setIsAdmin() {
        emplo.setIsAdmin(false);
        assertEquals(false,emplo.getIsAdmin());
    }

    @Test
    public void equals1() {
         Worker emplo1 = new Worker(
                2,
                "login2",
                "haslo2",
                "nazwisko2",
                "imie2",
                true);
         assertNotEquals(emplo,emplo1);
    }

   
}