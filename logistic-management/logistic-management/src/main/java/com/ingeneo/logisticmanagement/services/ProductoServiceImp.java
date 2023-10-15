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
    public void deleteProductoById(int idProducto) {
        if(existsProducto(idProducto))
            productoRepository.deleteById(idProducto);
    }

    @Override
    public boolean existsProducto(int idProducto) {
        return productoRepository.existsById(idProducto);
    }
    
}
