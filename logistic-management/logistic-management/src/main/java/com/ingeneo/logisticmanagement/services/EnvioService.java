package com.ingeneo.logisticmanagement.services;

import java.util.List;

import com.ingeneo.logisticmanagement.models.Cliente;
import com.ingeneo.logisticmanagement.models.Envio;
import com.ingeneo.logisticmanagement.models.TipoEnvio;

public interface EnvioService {
        List<Envio> getEnvios();

    List<Envio> getEnviosByTipoEnvio(TipoEnvio tipoEnvio);

    Envio getById(int idEnvio);

    Envio saveEnvio(Envio Envio);

    boolean deleteEnvioById(int idEnvio);

    boolean existsEnvio(int idEnvio);

    List<Envio> getEnviosByCliente(Cliente cliente);

    String generateNumeroGuia();

    String generateIdTransporte();

    Envio generateDiscount(Envio envio);

    Envio updateEnvio(Envio Envio);
}
