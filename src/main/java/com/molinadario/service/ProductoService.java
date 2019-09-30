package com.molinadario.service;

import com.molinadario.entity.Producto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductoService {

    Producto buscarProducto(int idProducto);

    Producto createProduct(Producto producto);
    
    List<Producto> allProducto();
}
