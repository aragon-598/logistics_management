package com.ingeneo.logisticmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingeneo.logisticmanagement.models.Producto;
import com.ingeneo.logisticmanagement.repository.ProductoRepository;

@Service
@Transactional
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
            return productoRepository.save(Producto);
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
