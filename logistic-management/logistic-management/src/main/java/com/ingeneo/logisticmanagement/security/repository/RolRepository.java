package com.ingeneo.logisticmanagement.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    
}
