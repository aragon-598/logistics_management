package com.ingeneo.logisticmanagement.services;

import java.util.List;

import com.ingeneo.logisticmanagement.models.Envio;
import com.ingeneo.logisticmanagement.models.TipoEnvio;

public interface EnvioService {
        List<Envio> getEnvios();

    List<Envio> getEnviosByTipoEnvio(TipoEnvio tipoEnvio);

    Envio getById(int idEnvio);

    Envio saveEnvio(Envio Envio);

    void deleteEnvioById(int idEnvio);

    boolean existsEnvio(int idEnvio);
}