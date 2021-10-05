package com.m2i.hotel.api;


import com.m2i.hotel.entities.ResaEntity;
import com.m2i.hotel.exception.ResourceNotFoundException;
import com.m2i.hotel.repository.ResaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/resa")
public class ResaAPIController {

    @Autowired
    ResaRepository rr;

    // Get All Resas
    @GetMapping("/resa")
    public Iterable<ResaEntity> getAllResas() {
        return rr.findAll();
    }

    // Get a Single Resa
    @GetMapping("/resa/{id}")
    public ResaEntity getResaById(@PathVariable(value = "id") Long id) throws Throwable {
        return (ResaEntity) rr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resa", "id", id));
    }

    // Create a new Resa
    @PostMapping("/resa")
    public ResaEntity createResa (@Valid @RequestBody ResaEntity r) {
        return (ResaEntity) rr.save(r);
    }

    // Update a Guest
    @PutMapping("/resa/{id}")
    public ResaEntity updateResa (@PathVariable(value = "id") Long id,
                             @Valid @RequestBody ResaEntity resaDetails) throws Throwable {

        ResaEntity r = (ResaEntity) rr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room", "id", id));

        r.setClient(resaDetails.getClient());
        r.setHotel(resaDetails.getHotel());
        r.setDateDeb(resaDetails.getDateDeb());
        r.setDateFin(resaDetails.getDateFin());
        r.setNum_chambre(resaDetails.getNum_chambre());

        ResaEntity updatedResa = (ResaEntity) rr.save(r);
        return updatedResa;
    }

    // Delete a Guest
    @DeleteMapping("/resa/{id}")
    public ResponseEntity<?> deleteResa (@PathVariable(value = "id") Long id) throws Throwable {
        ResaEntity r = (ResaEntity) rr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room", "id", id));

        rr.delete(r);

        return ResponseEntity.ok().build();
    }



}
