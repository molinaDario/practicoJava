/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.molinadario.implementes;

import com.molinadario.entity.Producto;
import com.molinadario.service.ProductoService;
import com.molindario.exception.ProductoException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

    @Override
    public List<Producto> allProducto() {

        List<Producto> listProducto = null;

        TypedQuery<Producto> queryAllProducto = entityManager.createNamedQuery("all_producto", Producto.class);

        listProducto = queryAllProducto.getResultList();

        if (listProducto != null) {
            return listProducto;
        } else {
            throw new ProductoException("No hay Productos");
        }
    }

}
