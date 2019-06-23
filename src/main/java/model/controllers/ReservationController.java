package model.controllers;

import model.exceptions.ClientNotFoundException;
import model.exceptions.ReservationNotFoundException;
import model.exceptions.RoomNotFoundException;
import model.exceptions.WorkerNotFoundException;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import model.enities.*;
import model.repositories.*;


@Controller    // This means that this class is a Controller
@RequestMapping(path="/reservation") // This means URL's start with /reservation
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping(path="/add")
    public @ResponseBody Reservation addNewReservation (@RequestParam Integer clientId, @RequestParam Integer workerId, @RequestParam Integer roomId, @RequestBody Reservation newReservation) {
        newReservation.setClient(clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException(clientId)));
        newReservation.setWorker(workerRepository.findById(workerId).orElseThrow(() -> new WorkerNotFoundException(workerId)));
        newReservation.setRoom(roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFoundException(roomId)));

        return reservationRepository.save(newReservation);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Reservation> getAllReservations() {
        // This returns a JSON or XML with the users
        return reservationRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Reservation getSingleReservation(@PathVariable Integer id){
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @PutMapping(path="/edit")
    public @ResponseBody Reservation updateReservation(@RequestBody Reservation newReservation, @RequestParam Integer id){
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setStartDate(newReservation.getStartDate());
            reservation.setEndDate(newReservation.getEndDate());
            return reservationRepository.save(reservation);
        }).orElseGet(() -> {
            newReservation.setId(id);
            return reservationRepository.save(newReservation);
        });
    }
}