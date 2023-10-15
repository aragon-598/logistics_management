package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingeneo.logisticmanagement.models.TipoBodega;
import com.ingeneo.logisticmanagement.repository.TipoBodegaRepository;

public class TipoBodegaServiceImp implements TipoBodegaService {

    @Autowired
    TipoBodegaRepository tipoBodegaRepository;

    @Override
    public List<TipoBodega> getTipoBodegas() {
        return tipoBodegaRepository.findAll();
    }

    @Override
    public TipoBodega getById(int idTipoBodega) {
        return tipoBodegaRepository.findById(idTipoBodega).orElse(null);
    }

    @Override
    public TipoBodega saveTipoBodega(TipoBodega TipoBodega) {
        if(existsTipoBodega(TipoBodega.getId()))
            return tipoBodegaRepository.save(TipoBodega);
        return null;
    }

    @Override
    public boolean deleteTipoBodegaById(int idTipoBodega) {
        boolean exists = existsTipoBodega(idTipoBodega);
        if(exists){
            tipoBodegaRepository.deleteById(idTipoBodega);
            return exists;
        }
        return exists;
    }

    @Override
    public boolean existsTipoBodega(int idTipoBodega) {
        return tipoBodegaRepository.existsById(idTipoBodega);
    }
    
}
