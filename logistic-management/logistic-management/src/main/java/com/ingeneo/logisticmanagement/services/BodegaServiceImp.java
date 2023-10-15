package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingeneo.logisticmanagement.models.Bodega;
import com.ingeneo.logisticmanagement.models.TipoBodega;
import com.ingeneo.logisticmanagement.repository.BodegaRepository;

public class BodegaServiceImp implements BodegaService {

    @Autowired
    BodegaRepository bodegaRepository;

    @Override
    public List<Bodega> getBodegas() {
        return bodegaRepository.findAll();
    }

    @Override
    public List<Bodega> getBodegasByTipBodega(TipoBodega tipoBodega) {
        return bodegaRepository.findByTipoBodega(tipoBodega);
    }

    @Override
    public Bodega getById(int idBodega) {
        return bodegaRepository.findById(idBodega).orElse(null);
    }

    @Override
    public Bodega saveBodega(Bodega bodega) {
        if(!existsBodega(bodega.getId()))
            return bodegaRepository.save(bodega);
        return null;
    }

    @Override
    public void deleteBodegaById(int idBodega) {
        if(existsBodega(idBodega))
            bodegaRepository.deleteById(idBodega);
    }

    @Override
    public boolean existsBodega(int idBodega) {
        return bodegaRepository.existsById(idBodega);
    }
    
}
