package com.molinadario.implementes;

import com.molinadario.entity.Canje;
import com.molinadario.entity.Cliente;
import com.molinadario.entity.Producto;
import com.molinadario.service.CanjeService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CanjeImplementsService implements CanjeService {

    @PersistenceContext(name = "JNDI_JAVA")
    private EntityManager entityManager;

    @Override
    public void newCanje(int idCliente, int idProducto) {

        Cliente cliente = null;
        Producto producto = null;

        cliente = entityManager.find(Cliente.class, idCliente);
        producto = entityManager.find(Producto.class, idProducto);

        if (cliente != null && producto != null) {
            Canje canje = new Canje(cliente, producto);
            cliente.addListCanje(canje);
        } else {
            System.out.println("Error al crear un canje****************");
        }
    }

}
