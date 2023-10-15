package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ingeneo.logisticmanagement.models.Producto;
import com.ingeneo.logisticmanagement.repository.ProductoRepository;

public class ProductoServiceImp implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getById(int idProducto) {
        return productoRepository.findById(idProducto).orElse(null);
    }

    @Override
    public Producto saveProducto(Producto Producto) {
        if(existsProducto(Producto.getId()))
            return saveProducto(Producto);
        return null;
    }

    @Override
    public boolean deleteProductoById(int idProducto) {
        boolean exists = existsProducto(idProducto);
        if(exists){
            productoRepository.deleteById(idProducto);
            return exists;
        }
        return exists;
    }

    @Override
    public boolean existsProducto(int idProducto) {
        return productoRepository.existsById(idProducto);
    }
    
}
