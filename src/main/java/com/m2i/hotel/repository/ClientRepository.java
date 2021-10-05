package com.m2i.hotel.repository;


import com.m2i.hotel.entities.ClientlEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<ClientlEntity, Integer> {
    Optional<ClientlEntity> findById(Long id);
}
