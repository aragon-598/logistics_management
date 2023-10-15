package com.ingeneo.logisticmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    
}
