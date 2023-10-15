package com.ingeneo.logisticmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.logisticmanagement.common.StandarizedApiMessageResponse;
import com.ingeneo.logisticmanagement.models.Cliente;
import com.ingeneo.logisticmanagement.services.ClienteService;

@RestController
@RequestMapping(path = "/cliente")
@CrossOrigin
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping(value="/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.getClientes());
    }

    @GetMapping(value="/{idCliente}")
    public ResponseEntity<?> findById(@PathVariable("idCliente") int idCliente) {
        Cliente cliente = clienteService.getById(idCliente);
        if (cliente!=null)
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("Cliente no encontrado"));
    }
    
    @PostMapping(value="/")
    public ResponseEntity<?> createCliente(@RequestBody Cliente entity) {
        Cliente newCliente = clienteService.saveCliente(entity);
        if (newCliente!=null)
            return ResponseEntity.status(HttpStatus.OK).body(newCliente);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo crear el cliente"));
    }

    @PutMapping(value="/edit/{idCliente}")
    public ResponseEntity<?> editCliente(@PathVariable int idCliente, @RequestBody Cliente entity) {
        entity.setId(idCliente);
        Cliente updatedCliente = clienteService.saveCliente(entity);
        if (updatedCliente!=null)
            return ResponseEntity.status(HttpStatus.OK).body(updatedCliente);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo editar el"));
    }

    @DeleteMapping(value="/delete/{idCliente}")
    public ResponseEntity<?> deleteCliente(@PathVariable("idCliente") int idCliente) {
        boolean isDeleted = clienteService.deleteClienteById(idCliente);
        if(isDeleted)
            return ResponseEntity.status(HttpStatus.OK).body(new StandarizedApiMessageResponse("Se elimino el cliente"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("No se pudo eliminar el cliente"));
    }
}
