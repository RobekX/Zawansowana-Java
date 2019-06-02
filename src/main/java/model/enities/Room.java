package model.enities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double cost; //Daily Cost per Day
    private Integer floor;
    private Integer numberofDoubleBeds;
    private Integer numberofSingleBeds;
    private Double size; //Size of room in m^2
}