package com.ingeneo.logisticmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingeneo.logisticmanagement.common.StandarizedApiMessageResponse;
import com.ingeneo.logisticmanagement.models.Bodega;
import com.ingeneo.logisticmanagement.services.BodegaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping(path = "/bodega")
@CrossOrigin
public class BodegaController {

    @Autowired
    BodegaService bodegaService;

    @GetMapping(value="/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(bodegaService.getBodegas());
    }

    @GetMapping(value="/find-by-tipo/{idTipoBodega}")
    public ResponseEntity<?> findAllByTipo(@RequestParam("idTipoBodega") int idTipoBodega) {
        List<Bodega> bodegasByTipo = bodegaService.getBodegasByTipBodega(null);
        return ResponseEntity.status(HttpStatus.OK).body(bodegasByTipo);
    }

    @GetMapping(value="/{idBodega}")
    public ResponseEntity<?> findById(@PathVariable("idBodega") int idBodega) {
        Bodega bodega = bodegaService.getById(idBodega);
        if (bodega!=null)
            return ResponseEntity.status(HttpStatus.OK).body(bodega);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("Bodega no encontrada"));
    }
    
    @PostMapping(value="/")
    public ResponseEntity<?> createBodega(@RequestBody Bodega entity) {
        Bodega newBodega = bodegaService.saveBodega(entity);
        if (newBodega!=null)
            return ResponseEntity.status(HttpStatus.OK).body(newBodega);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo guardar la bodega"));
    }

    @PutMapping(value="/edit/{idBodega}")
    public ResponseEntity<?> editBodega(@PathVariable int idBodega, @RequestBody Bodega entity) {
        entity.setId(idBodega);
        Bodega updatedBodega = bodegaService.saveBodega(entity);
        if (updatedBodega!=null)
            return ResponseEntity.status(HttpStatus.OK).body(updatedBodega);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo editar la bodega"));
    }

    @DeleteMapping(value="/delete/{idBodega}")
    public ResponseEntity<?> deleteBodega(@PathVariable("idBodega") int idBodega) {
        boolean isDeleted = bodegaService.deleteBodegaById(idBodega);
        if(isDeleted)
            return ResponseEntity.status(HttpStatus.OK).body(new StandarizedApiMessageResponse("Se elimino la bodega"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("No se pudo eliminar la bodega"));
    }
    
    
    
}
