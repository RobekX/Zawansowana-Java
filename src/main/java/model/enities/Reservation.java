package model.enities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private Worker worker;
    private Double totalCost;
    private Long days;

    public Reservation(){

    }

    public Reservation(Integer id){

    }

    public Reservation(Integer id, LocalDate startDate, LocalDate endDate, Client client, Room room) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.room = room;
        this.totalCost = setTotalCost();
    }

    private Double setTotalCost() {
        setDaysOfRental();
        totalCost = room.getCost() * days;
        return totalCost;
    }

    private Long setDaysOfRental() {
        days = ChronoUnit.DAYS.between(startDate, endDate);
        return days;
    }
}