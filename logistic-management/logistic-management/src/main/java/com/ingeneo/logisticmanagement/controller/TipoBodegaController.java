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
import com.ingeneo.logisticmanagement.models.TipoBodega;
import com.ingeneo.logisticmanagement.services.TipoBodegaService;

@RestController
@RequestMapping(path = "/tipo-bodega")
@CrossOrigin
public class TipoBodegaController {
    @Autowired
    TipoBodegaService tipoBodegaService;

    @GetMapping(value="/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoBodegaService.getTipoBodegas());
    }

    @GetMapping(value="/{idTipoBodega}")
    public ResponseEntity<?> findById(@PathVariable("idTipoBodega") int idTipoBodega) {
        TipoBodega TipoBodega = tipoBodegaService.getById(idTipoBodega);
        if (TipoBodega!=null)
            return ResponseEntity.status(HttpStatus.OK).body(TipoBodega);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("TipoBodega no encontrado"));
    }
    
    @PostMapping(value="/")
    public ResponseEntity<?> createTipoBodega(@RequestBody TipoBodega entity) {
        TipoBodega newTipoBodega = tipoBodegaService.saveTipoBodega(entity);
        if (newTipoBodega!=null)
            return ResponseEntity.status(HttpStatus.OK).body(newTipoBodega);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo crear el TipoBodega"));
    }

    @PutMapping(value="/edit/{idTipoBodega}")
    public ResponseEntity<?> editTipoBodega(@PathVariable int idTipoBodega, @RequestBody TipoBodega entity) {
        entity.setId(idTipoBodega);
        TipoBodega updatedTipoBodega = tipoBodegaService.saveTipoBodega(entity);
        if (updatedTipoBodega!=null)
            return ResponseEntity.status(HttpStatus.OK).body(updatedTipoBodega);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo editar el TipoBodega"));
    }

    @DeleteMapping(value="/delete/{idTipoBodega}")
    public ResponseEntity<?> deleteTipoBodega(@PathVariable("idTipoBodega") int idTipoBodega) {
        boolean isDeleted = tipoBodegaService.deleteTipoBodegaById(idTipoBodega);
        if(isDeleted)
            return ResponseEntity.status(HttpStatus.OK).body(new StandarizedApiMessageResponse("Se elimino el TipoBodega"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("No se pudo eliminar el TipoBodega"));
    }    
}
