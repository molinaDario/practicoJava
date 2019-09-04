package com.molinadario.service;

import com.molinadario.entity.Producto;
import javax.ejb.Local;


@Local
public interface ProductoService {
    
     Producto buscarProducto(int idProducto);
}
