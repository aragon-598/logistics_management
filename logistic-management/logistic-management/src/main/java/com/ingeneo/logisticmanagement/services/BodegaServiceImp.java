package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.logisticmanagement.models.Bodega;
import com.ingeneo.logisticmanagement.models.TipoBodega;
import com.ingeneo.logisticmanagement.repository.BodegaRepository;

@Service
@Transactional
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
        return bodegaRepository.save(bodega);
    }

    @Override
    public boolean deleteBodegaById(int idBodega) {
        boolean exists = existsBodega(idBodega);
        if(exists){
            bodegaRepository.deleteById(idBodega);
            return exists;
        }
        return exists;
    }

    @Override
    public boolean existsBodega(int idBodega) {
        return bodegaRepository.existsById(idBodega);
    }
    
}
