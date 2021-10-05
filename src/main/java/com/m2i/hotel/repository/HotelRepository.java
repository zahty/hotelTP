package com.m2i.hotel.repository;


import com.m2i.hotel.entities.HotelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelRepository extends CrudRepository<HotelEntity, Integer> {
    Optional<HotelEntity> findById(Long id);
}
