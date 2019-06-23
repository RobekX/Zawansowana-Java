package model.enities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double cost; //Daily Cost per Day
    private Integer roomFloor;
    private Integer numberOfDoubleBeds;
    private Integer numberOfSingleBeds;
    private Double size; //Size of room in m^2

    public Room(){

    }
    public Room(Integer id){

    }
}
