package model;

import lombok.Data;

@Data
public class Room {
 private Integer id;
 private Double cost; //Daily Cost per Day
 private Integer floor;
 private Integer numberofDoubleBeds;
 private Integer numberofSingleBeds;
 private Double size; //Size of room in m^2
}
