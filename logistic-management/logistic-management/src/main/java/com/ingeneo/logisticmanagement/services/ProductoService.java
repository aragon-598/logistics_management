package com.ingeneo.logisticmanagement.services;

import java.util.List;

import com.ingeneo.logisticmanagement.models.Producto;

public interface ProductoService {
    List<Producto> getProductos();

    Producto getById(int idProducto);

    Producto saveProducto(Producto Producto);

    boolean deleteProductoById(int idProducto);

    boolean existsProducto(int idProducto);
}
