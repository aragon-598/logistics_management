package com.ingeneo.logisticmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.TipoBodega;

@Repository
public interface TipoBodegaRepository extends JpaRepository<TipoBodega,Integer> {
    
}
