package model;

import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;
@Data
public class Reservation {
    private UUID id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Client client;
    private Room room;
    private Double totalCost;
    private Long days;

    public Reservation(UUID id, LocalDate startDate, LocalDate endDate, Client client, Room room) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.room = room;
        this.totalCost = setTotalCost();
    }

    private Double setTotalCost(){
        setDaysOfRental();
        totalCost = room.getCost()*days;
        return totalCost;
    }
    private Long setDaysOfRental(){
        days = ChronoUnit.DAYS.between(startDate,endDate);
        return days;
    }
}