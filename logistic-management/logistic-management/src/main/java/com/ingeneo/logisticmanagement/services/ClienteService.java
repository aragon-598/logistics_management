package com.ingeneo.logisticmanagement.services;

import java.util.List;

import com.ingeneo.logisticmanagement.models.Cliente;

public interface ClienteService {
    List<Cliente> getClientes();

    Cliente getById(int idCliente);

    Cliente saveCliente(Cliente Cliente);

    void deleteClienteById(int idCliente);

    boolean existsCliente(int idCliente);
}
