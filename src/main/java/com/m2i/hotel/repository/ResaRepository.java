package com.m2i.hotel.repository;

import com.m2i.hotel.entities.ResaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ResaRepository extends CrudRepository<ResaEntity, Integer> {
    Optional<ResaEntity> findById(Long id);
}
