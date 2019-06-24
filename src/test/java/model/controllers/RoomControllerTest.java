package model.controllers;

import model.enities.Room;
import model.repositories.RoomRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class RoomControllerTest {
    @Mock
    RoomRepository repository;
    @InjectMocks
    RoomController controller;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewRoom() {
        Room room = new Room(
                1,
                150.0,
                1,
                3,
                4,
                30.0);
        repository.save(room);
        verify(repository).save(room);
        verify(repository, times(1)).save(room);
        verify(repository).save(any(Room.class));
    }

    @Test
    public void getSingleRoom() {
    }

    @Test
    public void updateRoom() {
        Room room = new Room(
                1,
                150.0,
                1,
                3,
                4,
                30.0);
        Room room2 = new Room(
                1,
                150.0,
                1,
                1,
                4,
                20.0);
        Integer id = Integer.valueOf(1);
        given(repository.findById(room.getId())).willReturn(Optional.of(room));
        //controller.updateRoom(room2,1);
        repository.save(room2);

        verify(repository).save(room2);
        verify(repository,times(1)).save(room2);
        verify(repository).save(any(Room.class));
        verify(repository, never()).delete(any(Room.class));
        assertEquals(Double.valueOf(30.0), repository.findById(Integer.valueOf(1)).get().getSize());
        assertEquals(Integer.valueOf(4), repository.findById(Integer.valueOf(1)).get().getNumberOfSingleBeds());

    }

    @Test
    public void getSingleRoomCosts() {
    }
}