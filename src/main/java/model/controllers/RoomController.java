package model.controllers;
import model.dto.RoomValues;
import model.exceptions.ClientNotFoundException;
import model.exceptions.RoomNotFoundException;
import model.utils.Currency;
import model.utils.CurrencyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import model.enities.*;
import model.repositories.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/room") // This means URL's start with /client
public class RoomController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private RoomRepository roomRepository;

    @PostMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody Room addNewRoom (@RequestBody Room newRoom) {
        return roomRepository.save(newRoom);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Room> getAllRooms() {
        // This returns a JSON or XML with the users
        return roomRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Room getSingleRoom(@PathVariable Integer id){
        return roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PutMapping(path="/edit")
    public @ResponseBody Room updateRoom(@RequestBody Room newRoom, @RequestParam Integer id){
        return roomRepository.findById(id).map(room -> {
            room.setCost(newRoom.getCost());
            room.setRoomFloor(newRoom.getRoomFloor());
            room.setNumberOfDoubleBeds(newRoom.getNumberOfDoubleBeds());
            room.setNumberOfSingleBeds(newRoom.getNumberOfSingleBeds());
            room.setSize(newRoom.getSize());
            return roomRepository.save(room);
        }).orElseGet(() -> {
            newRoom.setId(id);
            return roomRepository.save(newRoom);
        });
    }

    @GetMapping(path="/cost/{id}")
    public @ResponseBody
    RoomValues getSingleRoomCosts(@PathVariable Integer id){
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        RoomValues roomValues = new RoomValues();
        Currency currency = new Currency();
        roomValues.setCostPLN(room.getCost());
        roomValues.setCostEUR(room.getCost()/currency.getRateValue(CurrencyCode.EUR));
        roomValues.setCostGBP(room.getCost()/currency.getRateValue(CurrencyCode.GBP));
        roomValues.setCostUSD(room.getCost()/currency.getRateValue(CurrencyCode.USD));

        return roomValues;
    }
}
