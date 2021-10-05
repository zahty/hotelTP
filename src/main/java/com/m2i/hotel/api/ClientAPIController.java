package com.m2i.hotel.api;


import com.m2i.hotel.entities.ClientlEntity;
import com.m2i.hotel.exception.ResourceNotFoundException;
import com.m2i.hotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClientAPIController {

    @Autowired
    ClientRepository cr;

    // Get All Clients
    @GetMapping("/clients")
    public Iterable<ClientlEntity> getAllResa() {
        return cr.findAll();
    }

    // Create new Clients
    @PostMapping("/clients")
    public ClientlEntity createClient (@Valid @RequestBody ClientlEntity client){
        return cr.save(client);
    }

    // Get a single Clients
    @GetMapping("/clients/{id}")
    public ClientlEntity getClientById(@PathVariable(value = "id") Long id) throws Throwable{
        return (ClientlEntity) cr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
    }

    // Update a Client
    @PutMapping("/clients/{id}")
    public ClientlEntity updateClient ( @PathVariable(value = "id") Long id, @Valid @RequestBody
                                        ClientlEntity clientDetails ) throws Throwable {
        ClientlEntity c = ( ClientlEntity ) cr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));

        c.setNom_complet(clientDetails.getNom_complet());
        c.setTelephone(clientDetails.getTelephone());
        c.setEmail(clientDetails.getEmail());
        c.setAdresse(clientDetails.getAdresse());

        ClientlEntity updateClient = (ClientlEntity) cr.save(c);
        return updateClient;
    }

    // Delete a Client
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") Long id) throws Throwable {
        ClientlEntity c = ( ClientlEntity ) cr.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));

        cr.delete(c);

        return ResponseEntity.ok().build();
    }
}
