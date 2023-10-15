package com.ingeneo.logisticmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingeneo.logisticmanagement.models.Cliente;
import com.ingeneo.logisticmanagement.models.Envio;
import com.ingeneo.logisticmanagement.models.TipoEnvio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio,Integer>{
    List<Envio> findByTipoEnvio(TipoEnvio tipoEnvio);
    
    List<Envio> findByCliente(Cliente cliente);

    boolean existsByNumeroGuia(String numeroGuia);
    
    boolean existsByIdTransporte(String idTransporte);

}
