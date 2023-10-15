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
import com.ingeneo.logisticmanagement.models.TipoEnvio;
import com.ingeneo.logisticmanagement.services.TipoEnvioService;

@RestController
@RequestMapping(path = "/tipo-envio")
@CrossOrigin
public class TipoEnvioController {
    @Autowired
    TipoEnvioService tipoEnvioService;

    @GetMapping(value="/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoEnvioService.getTipoEnvios());
    }

    @GetMapping(value="/{idTipoEnvio}")
    public ResponseEntity<?> findById(@PathVariable("idTipoEnvio") int idTipoEnvio) {
        TipoEnvio TipoEnvio = tipoEnvioService.getById(idTipoEnvio);
        if (TipoEnvio!=null)
            return ResponseEntity.status(HttpStatus.OK).body(TipoEnvio);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("TipoEnvio no encontrado"));
    }
    
    @PostMapping(value="/")
    public ResponseEntity<?> createTipoEnvio(@RequestBody TipoEnvio entity) {
        TipoEnvio newTipoEnvio = tipoEnvioService.saveTipoEnvio(entity);
        if (newTipoEnvio!=null)
            return ResponseEntity.status(HttpStatus.OK).body(newTipoEnvio);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo crear el TipoEnvio"));
    }

    @PutMapping(value="/edit/{idTipoEnvio}")
    public ResponseEntity<?> editTipoEnvio(@PathVariable int idTipoEnvio, @RequestBody TipoEnvio entity) {
        entity.setId(idTipoEnvio);
        TipoEnvio updatedTipoEnvio = tipoEnvioService.saveTipoEnvio(entity);
        if (updatedTipoEnvio!=null)
            return ResponseEntity.status(HttpStatus.OK).body(updatedTipoEnvio);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo editar el TipoEnvio"));
    }

    @DeleteMapping(value="/delete/{idTipoEnvio}")
    public ResponseEntity<?> deleteTipoEnvio(@PathVariable("idTipoEnvio") int idTipoEnvio) {
        boolean isDeleted = tipoEnvioService.deleteTipoEnvioById(idTipoEnvio);
        if(isDeleted)
            return ResponseEntity.status(HttpStatus.OK).body(new StandarizedApiMessageResponse("Se elimino el TipoEnvio"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("No se pudo eliminar el TipoEnvio"));
    }
}
