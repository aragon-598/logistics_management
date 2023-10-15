package com.ingeneo.logisticmanagement.services;

import java.util.List;

import com.ingeneo.logisticmanagement.models.TipoBodega;

public interface TipoBodegaService {
    List<TipoBodega> getTipoBodegas();

    TipoBodega getById(int idTipoBodega);

    TipoBodega saveTipoBodega(TipoBodega TipoBodega);

    boolean deleteTipoBodegaById(int idTipoBodega);

    boolean existsTipoBodega(int idTipoBodega);
}
