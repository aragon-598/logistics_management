package com.ingeneo.logisticmanagement.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.logisticmanagement.common.StandarizedApiMessageResponse;
import com.ingeneo.logisticmanagement.models.Cliente;
import com.ingeneo.logisticmanagement.models.Envio;
import com.ingeneo.logisticmanagement.models.TipoEnvio;
import com.ingeneo.logisticmanagement.services.EnvioService;

@RestController
@RequestMapping(path = "/envio")
@CrossOrigin
public class EnvioController {
    @Autowired
    EnvioService envioService;

    @GetMapping(value="/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(envioService.getEnvios());
    }

    @GetMapping(value="/find-by-tipo/{idTipoEnvio}")
    public ResponseEntity<?> findAllByTipo(@RequestParam("idTipoEnvio") TipoEnvio idTipoEnvio) {
        List<Envio> enviosByTipo = envioService.getEnviosByTipoEnvio(idTipoEnvio);
        return ResponseEntity.status(HttpStatus.OK).body(enviosByTipo);
    }

    @GetMapping(value="/find-by-cliente/{idCliente}")
    public ResponseEntity<?> findAllByTipo(@RequestParam("idCliente") Cliente idCliente) {
        List<Envio> enviosByTipo = envioService.getEnviosByCliente(idCliente);
        return ResponseEntity.status(HttpStatus.OK).body(enviosByTipo);
    }

    @GetMapping(value="/{idEnvio}")
    public ResponseEntity<?> findById(@PathVariable("idEnvio") int idEnvio) {
        Envio envio = envioService.getById(idEnvio);
        if (envio!=null)
            return ResponseEntity.status(HttpStatus.OK).body(envio);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("Envio no encontrada"));
    }
    
    @PostMapping(value="/")
    public ResponseEntity<?> createEnvio(@RequestBody Envio entity) {
        System.out.println(entity.getBodega().toString());
        Envio newEnvio = envioService.saveEnvio(entity);
        if (newEnvio!=null)
            return ResponseEntity.status(HttpStatus.OK).body(newEnvio);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo generar el envio"));
    }

    @PutMapping(value="/edit/{idEnvio}")
    public ResponseEntity<?> editEnvio(@PathVariable int idEnvio, @RequestBody Envio entity) {
        entity.setId(idEnvio);
        Envio updatedEnvio = envioService.updateEnvio(entity);
        if (updatedEnvio!=null)
            return ResponseEntity.status(HttpStatus.OK).body(updatedEnvio);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo editar el"));
    }

    @DeleteMapping(value="/delete/{idEnvio}")
    public ResponseEntity<?> deleteEnvio(@PathVariable("idEnvio") int idEnvio) {
        boolean isDeleted = envioService.deleteEnvioById(idEnvio);
        if(isDeleted)
            return ResponseEntity.status(HttpStatus.OK).body(new StandarizedApiMessageResponse("Se elimino el envio"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("No se pudo eliminar el envio"));
    }
}
