package model.controllers;

import model.enities.Worker;
import model.repositories.WorkerRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class WorkerControllerTest {
    @Mock
    WorkerRepository repository;
    @InjectMocks
    WorkerController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void addNewWorker() {
        Worker worker = new Worker(
                1,
                "login",
                "haslo",
                "nazwisko",
                "imie",
                true);
        repository.save(worker);
        verify(repository).save(worker);
        verify(repository, times(1)).save(worker);
        verify(repository).save(any(Worker.class));
    }

    @Test
    public void getSingleWorker() {
        Worker worker1;
        Worker worker = new Worker(
                1,
                "login",
                "haslo",
                "nazwisko",
                "imie",
                true);
        when(repository.findById((Integer) 1)).thenReturn(Optional.of(worker));
        //given(repository.findById(klient1.getId())).willReturn(Optional.of(reservation));
        //worker1 = controller.getSingleWorker((Integer.valueOf(1)));
//
        //verify(repository).findById(Integer.valueOf(1));
        //verify(repository, times(1)).findById(Integer.valueOf(1));
//
        //assertEquals(Integer.valueOf(1), worker.getId());
    }

    @Test
    public void updateWorker() {
        Worker worker = new Worker(
                1,
                "login",
                "haslo",
                "nazwisko",
                "imie",
                true);
        Worker worker2 = new Worker(
                1,
                "loginek",
                "haslo",
                "nazwisko",
                "imie",
                true);

        Integer id = Integer.valueOf(1);
        given(repository.findById(worker.getId())).willReturn(Optional.of(worker));
        //repository.findById(id).map(work -> {
        //    worker.setLogin(worker2.getLogin());
        //    worker.setPassword(worker2.getPassword());
        //    worker.setForename(worker2.getForename());
        //    worker.setSurname(worker2.getSurname());
        //    worker.setIsAdmin(worker2.getIsAdmin());
//
        //    return repository.save(worker);
        //}).orElseGet(() -> {
        //            worker2.setId(id);
        //            return repository.save(worker2);
        //        });
        repository.save(worker2);
        verify(repository).save(worker2);
        verify(repository,times(1)).save(worker2);
        verify(repository).save(any(Worker.class));
        verify(repository, never()).delete(any(Worker.class));
        assertEquals("login", repository.findById(Integer.valueOf(1)).get().getLogin());

    }
}