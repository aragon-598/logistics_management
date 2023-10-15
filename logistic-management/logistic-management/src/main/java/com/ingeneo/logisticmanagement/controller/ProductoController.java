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
import com.ingeneo.logisticmanagement.models.Producto;
import com.ingeneo.logisticmanagement.services.ProductoService;

@RestController
@RequestMapping(path = "/producto")
@CrossOrigin
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping(value="/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productoService.getProductos());
    }

    @GetMapping(value="/{idProducto}")
    public ResponseEntity<?> findById(@PathVariable("idProducto") int idProducto) {
        Producto Producto = productoService.getById(idProducto);
        if (Producto!=null)
            return ResponseEntity.status(HttpStatus.OK).body(Producto);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("Producto no encontrado"));
    }
    
    @PostMapping(value="/")
    public ResponseEntity<?> createProducto(@RequestBody Producto entity) {
        Producto newProducto = productoService.saveProducto(entity);
        if (newProducto!=null)
            return ResponseEntity.status(HttpStatus.OK).body(newProducto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo crear el Producto"));
    }

    @PutMapping(value="/edit/{idProducto}")
    public ResponseEntity<?> editProducto(@PathVariable int idProducto, @RequestBody Producto entity) {
        entity.setId(idProducto);
        Producto updatedProducto = productoService.saveProducto(entity);
        if (updatedProducto!=null)
            return ResponseEntity.status(HttpStatus.OK).body(updatedProducto);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StandarizedApiMessageResponse("No se pudo editar el producto"));
    }

    @DeleteMapping(value="/delete/{idProducto}")
    public ResponseEntity<?> deleteProducto(@PathVariable("idProducto") int idProducto) {
        boolean isDeleted = productoService.deleteProductoById(idProducto);
        if(isDeleted)
            return ResponseEntity.status(HttpStatus.OK).body(new StandarizedApiMessageResponse("Se elimino el Producto"));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new StandarizedApiMessageResponse("No se pudo eliminar el Producto"));
    }
}
