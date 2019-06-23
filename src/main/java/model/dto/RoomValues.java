package model.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class RoomValues {
    private Double costPLN;
    private Double costEUR;
    private Double costUSD;
    private Double costGBP;


}
