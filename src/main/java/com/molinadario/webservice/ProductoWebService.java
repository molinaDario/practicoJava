/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.molinadario.webservice;

import com.molinadario.entity.Producto;
import com.molinadario.service.ProductoService;
import com.molindario.exception.ProductoException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dario
 */
@Path("/producto")
public class ProductoWebService {

    @EJB
    private ProductoService productoService;

    @POST
    @Path("/nuevoProducto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Producto newProducto(Producto producto) {

        if (productoService.buscarProducto(producto.getNombre()) == null) {
            productoService.createProduct(producto);
            return productoService.buscarProducto(producto.getId_producto());
        } else {
            throw new ProductoException("El Producto ya existe");
        }
    }

    @GET
    @Path("/{idProducto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producto buscarProducto(@PathParam("idProducto") int idProducto) {

        if (productoService.buscarProducto(idProducto).getId_producto() != 0) {
            return productoService.buscarProducto(idProducto);
        } else {
            throw new ProductoException("El producto no existe");
        }
    }

}
