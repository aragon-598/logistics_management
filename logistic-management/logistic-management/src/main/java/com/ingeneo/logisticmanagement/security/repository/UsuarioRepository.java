package com.ingeneo.logisticmanagement.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
}
