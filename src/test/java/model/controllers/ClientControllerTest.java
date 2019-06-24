package model.controllers;

import model.enities.Client;
import model.repositories.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class ClientControllerTest {
    @Mock
    ClientRepository repository;

    @Mock
    ClientController controller;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewClient() {
        Client klient1 = new Client(
                1,
                "Robert",
                "Radczyc",
                "96111512037",
                "Krakowska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");
        repository.save(klient1);
        verify(repository).save(klient1);
        verify(repository, times(1)).save(klient1);
        verify(repository).save(any(Client.class));
    }

    @Test
    public void getSingleClient() {
        Client klient;
        Client klient1 = new Client(
                1,
                "Robert",
                "Radczyc",
                "96111512037",
                "Krakowska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");
        //when(repository.findById((Integer) 1)).thenReturn(Optional.of(klient1));
        ////given(repository.findById(klient1.getId())).willReturn(Optional.of(klient1));
        // klient = controller.getSingleClient((Integer.valueOf(1)));
//
        //verify(repository).findById(Integer.valueOf(1));
        //verify(repository, times(1)).findById(Integer.valueOf(1));
//
        //assertEquals(Integer.valueOf(1), klient.getId());
    }

    @Test
    public void updateClient() {
        Client klient1 = new Client(
                1,
                "Robert",
                "Radczyc",
                "96111512037",
                "Krakowska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");

        Client klient2 = new Client(
                1,
                "Roman",
                "Radczyc",
                "96111512037",
                "Niska",
                "97-500",
                "Radomsko",
                "517602801",
                "robek005@gmail.com");

        Integer id = Integer.valueOf(1);
        given(repository.findById(klient1.getId())).willReturn(Optional.of(klient1));
        repository.save(klient2);

        verify(repository).save(klient2);
        verify(repository,times(1)).save(klient2);
        verify(repository).save(any(Client.class));
        verify(repository, never()).delete(any(Client.class));
        assertEquals("Robert", repository.findById(Integer.valueOf(1)).get().getForename());
        assertEquals("Krakowska", repository.findById(Integer.valueOf(1)).get().getStreet());

    }
}