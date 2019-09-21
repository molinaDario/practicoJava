package com.molinadario.service;

import javax.ejb.Local;

@Local
public interface CanjeService {

    void newCanje(int idCliente, int idProducto);
    
}
