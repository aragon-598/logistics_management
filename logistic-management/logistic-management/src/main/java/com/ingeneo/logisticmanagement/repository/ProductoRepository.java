package com.ingeneo.logisticmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    
}
