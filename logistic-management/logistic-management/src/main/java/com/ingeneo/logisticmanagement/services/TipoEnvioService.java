package com.ingeneo.logisticmanagement.services;

import java.util.List;

import com.ingeneo.logisticmanagement.models.TipoEnvio;

public interface TipoEnvioService {
    List<TipoEnvio> getTipoEnvios();

    TipoEnvio getById(int idTipoEnvio);

    TipoEnvio saveTipoEnvio(TipoEnvio TipoEnvio);

    void deleteTipoEnvioById(int idTipoEnvio);

    boolean existsTipoEnvio(int idTipoEnvio);
}
