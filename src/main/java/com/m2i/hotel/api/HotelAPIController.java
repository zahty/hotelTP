package com.m2i.hotel.api;

import com.m2i.hotel.entities.HotelEntity;
import com.m2i.hotel.exception.ResourceNotFoundException;
import com.m2i.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class HotelAPIController {

    @Autowired
    HotelRepository hr;

    // Get All Hotels
    @GetMapping("/hotels")
    public Iterable<HotelEntity> getAllHotels() {
        return hr.findAll();
    }

    // Create new hotel
    @PostMapping("/hotel")
    public HotelEntity createHotel (@Valid @RequestBody HotelEntity h){
        return hr.save(h);
    }

    // Get a single Clients
    @GetMapping("/hotel/{id}")
    public HotelEntity getHotelById(@PathVariable(value = "id") Long id) throws Throwable{
        return (HotelEntity) hr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));
    }

    // Update a Client
    @PutMapping("/hotel/{id}")
    public HotelEntity updateHotel( @PathVariable(value = "id") Long id,
                                    @Valid @RequestBody HotelEntity  hotelDetails ) throws Throwable {
       HotelEntity  h = ( HotelEntity ) hr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));

       h.setNom(hotelDetails.getNom());
       h.setEtoiles(hotelDetails.getEtoiles());
       h.setAdresse(hotelDetails.getAdresse());
       h.setTelephone(hotelDetails.getTelephone());
       h.setEmail(hotelDetails.getEmail());
       h.setVille(hotelDetails.getVille());

       HotelEntity updateHotel = (HotelEntity) hr.save(h);

        return updateHotel;
    }

    // Delete a Client
    @DeleteMapping("/hotel/{id}")
    public ResponseEntity<?> deleteHotel (@PathVariable(value = "id") Long id) throws Throwable {
        HotelEntity h = ( HotelEntity ) hr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel", "id", id));

        hr.delete(h);

        return ResponseEntity.ok().build();
    }
}
