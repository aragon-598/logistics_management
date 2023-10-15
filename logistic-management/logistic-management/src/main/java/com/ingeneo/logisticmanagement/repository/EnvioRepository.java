package com.ingeneo.logisticmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio,Long>{
    
}
