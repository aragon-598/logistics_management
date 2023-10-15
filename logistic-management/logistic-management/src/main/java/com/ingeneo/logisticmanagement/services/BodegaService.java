package com.ingeneo.logisticmanagement.services;

import java.util.List;

import com.ingeneo.logisticmanagement.models.Bodega;
import com.ingeneo.logisticmanagement.models.TipoBodega;

public interface BodegaService {
    List<Bodega> getBodegas();

    List<Bodega> getBodegasByTipBodega(TipoBodega tipoBodega);

    Bodega getById(int idBodega);

    Bodega saveBodega(Bodega bodega);

    void deleteBodegaById(int idBodega);

    boolean existsBodega(int idBodega);
}
