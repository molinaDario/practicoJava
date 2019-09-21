/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.molinadario.implementes;

import com.molinadario.entity.Producto;
import com.molinadario.service.ProductoService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ProductoImplementsService implements ProductoService {

    @PersistenceContext(name = "JNDI_JAVA")
    private EntityManager entityManager;

    @Override
    public Producto buscarProducto(int idProducto) {
        Producto producto = null;
        producto = entityManager.find(Producto.class, idProducto);
        return producto;
    }

    @Override
    public Producto createProduct(Producto producto) {
        entityManager.persist(producto);
        return producto;
    }

}
