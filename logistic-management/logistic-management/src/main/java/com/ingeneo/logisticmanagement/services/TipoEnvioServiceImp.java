package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingeneo.logisticmanagement.models.TipoEnvio;
import com.ingeneo.logisticmanagement.repository.TipoEnvioRepository;

public class TipoEnvioServiceImp implements TipoEnvioService{

    @Autowired
    TipoEnvioRepository tipoEnvioRepository;

    @Override
    public List<TipoEnvio> getTipoEnvios() {
        return tipoEnvioRepository.findAll();
    }

    @Override
    public TipoEnvio getById(int idTipoEnvio) {
        return tipoEnvioRepository.findById(idTipoEnvio).orElse(null);
    }

    @Override
    public TipoEnvio saveTipoEnvio(TipoEnvio TipoEnvio) {
        if(existsTipoEnvio(TipoEnvio.getId()))
            return tipoEnvioRepository.save(TipoEnvio);
        return null;
    }

    @Override
    public boolean deleteTipoEnvioById(int idTipoEnvio) {
        boolean exists = existsTipoEnvio(idTipoEnvio);
        if(exists){
            tipoEnvioRepository.deleteById(idTipoEnvio);
            return exists;
        }
        return exists;
    }

    @Override
    public boolean existsTipoEnvio(int idTipoEnvio) {
        return tipoEnvioRepository.existsById(idTipoEnvio);
    }

        
}
