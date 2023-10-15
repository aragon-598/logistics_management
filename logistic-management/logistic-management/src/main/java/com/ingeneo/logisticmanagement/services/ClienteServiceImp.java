package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingeneo.logisticmanagement.models.Cliente;
import com.ingeneo.logisticmanagement.repository.ClienteRepository;

public class ClienteServiceImp implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getById(int idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        if (existsCliente(cliente.getId()))
            return clienteRepository.save(cliente);
        return null;
    }

    @Override
    public boolean deleteClienteById(int idCliente) {
        boolean exists = existsCliente(idCliente);
        if (exists){
            clienteRepository.deleteById(idCliente);
            return exists;
        }
        return exists;
    }

    @Override
    public boolean existsCliente(int idCliente) {
        return clienteRepository.existsById(idCliente);
    }
    
}
