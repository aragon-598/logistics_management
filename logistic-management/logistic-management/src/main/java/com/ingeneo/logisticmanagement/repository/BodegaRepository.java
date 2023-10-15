package com.ingeneo.logisticmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Bodega;

@Repository 
public interface BodegaRepository extends JpaRepository<Bodega,Integer> {
    
}
