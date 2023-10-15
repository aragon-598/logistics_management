package com.ingeneo.logisticmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.TipoEnvio;

@Repository
public interface TipoEnvioRepository  extends JpaRepository<TipoEnvio,Long>{
    
}
