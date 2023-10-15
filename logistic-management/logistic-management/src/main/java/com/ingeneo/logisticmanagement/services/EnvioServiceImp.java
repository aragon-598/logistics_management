package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingeneo.logisticmanagement.models.Cliente;
import com.ingeneo.logisticmanagement.models.Envio;
import com.ingeneo.logisticmanagement.models.TipoEnvio;
import com.ingeneo.logisticmanagement.repository.EnvioRepository;

public class EnvioServiceImp implements EnvioService {

    @Autowired
    EnvioRepository envioRepository;

    @Override
    public List<Envio> getEnvios() {
        return envioRepository.findAll();
    }

    @Override
    public List<Envio> getEnviosByTipoEnvio(TipoEnvio tipoEnvio) {
        return envioRepository.findByTipoEnvio(tipoEnvio);
    }

    @Override
    public Envio getById(int idEnvio) {
        return envioRepository.findById(idEnvio).orElse(null);
    }

    @Override
    public Envio saveEnvio(Envio Envio) {
        if (existsEnvio(Envio.getId()))
            return envioRepository.save(Envio);
        return null;
    }

    @Override
    public boolean deleteEnvioById(int idEnvio) {
        boolean exists = existsEnvio(idEnvio);
        if (exists){
            envioRepository.deleteById(idEnvio);
            return exists;
        }
        return exists;
    }

    @Override
    public boolean existsEnvio(int idEnvio) {
        return envioRepository.existsById(idEnvio);
    }

    @Override
    public List<Envio> getEnviosByCliente(Cliente cliente) {
        return envioRepository.findByCliente(cliente);
    }
    
}
