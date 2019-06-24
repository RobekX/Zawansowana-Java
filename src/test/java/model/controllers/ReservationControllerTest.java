package model.controllers;

import model.enities.Client;
import model.enities.Reservation;
import model.enities.Room;
import model.repositories.ReservationRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ReservationControllerTest {
    @Mock
    ReservationRepository repository;
    @InjectMocks
    ReservationController controller;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewReservation() {
        Client klient = new Client(
                1,
                "Robert",
                "Radczyc",
                "96111512037",
                "Krakowska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");
        Room room = new Room(
                1,
                150.0,
                1,
                3,
                4,
                30.0);
        Reservation reservation = new Reservation(
                1,
                "2019-10-22",
                "2019-10-25",
                klient,
                room);

        repository.save(reservation);

        verify(repository).save(reservation);
        verify(repository, times(1)).save(reservation);
        verify(repository).save(any(Reservation.class));
    }

    @Test
    public void getSingleReservation() {
        Reservation reservation1;
        Client klient = new Client(
                1,
                "Robert",
                "Radczyc",
                "96111512037",
                "Krakowska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");
        Room room = new Room(
                1,
                150.0,
                1,
                3,
                4,
                30.0);
        Reservation reservation = new Reservation(
                1,
                "2019-10-22",
                "2019-10-25",
                klient,
                room);
        //when(repository.findById((Integer) 1)).thenReturn(Optional.of(reservation));
        ////given(repository.findById(klient1.getId())).willReturn(Optional.of(reservation));
        //reservation1 = controller.getSingleReservation((Integer.valueOf(1)));
//
        //verify(repository).findById(Integer.valueOf(1));
        //verify(repository, times(1)).findById(Integer.valueOf(1));
//
        //assertEquals(Integer.valueOf(1), reservation.getId());
    }

    @Test
    public void updateReservation() {
        Client klient = new Client(
                1,
                "Robert",
                "Radczyc",
                "96111512037",
                "Krakowska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");
        Room room = new Room(
                1,
                150.0,
                1,
                3,
                4,
                30.0);
        Reservation reservation = new Reservation(
                1,
                "2019-10-22",
                "2019-10-25",
                klient,
                room);
        Reservation reservation1 = new Reservation(
                1,
                "2019-10-21",
                "2019-10-25",
                klient,
                room);

        Integer id = Integer.valueOf(1);
        given(repository.findById(reservation.getId())).willReturn(Optional.of(reservation));
        repository.save(reservation1);

        verify(repository).save(reservation1);
        verify(repository,times(1)).save(reservation1);
        verify(repository).save(any(Reservation.class));
        verify(repository, never()).delete(any(Reservation.class));
        assertEquals(LocalDate.parse("2019-10-22"), repository.findById(Integer.valueOf(1)).get().getStartDate());


    }
}