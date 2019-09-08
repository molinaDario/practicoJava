package com.molinadario.implementes;

import com.molinadario.entity.Cliente;
import com.molinadario.service.ClienteService;
import com.molindario.exception.ClienteException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ClienteImplementsService implements ClienteService {

    @PersistenceContext(name = "JNDI_JAVA")
    private EntityManager entityManager;

    @Override
    public Cliente newCliente(Cliente cliente) {

        Cliente newCliente = null;
        if (entityManager.find(Cliente.class, cliente.getId_cliente()) == null) {
            entityManager.persist(cliente);
            newCliente = cliente;
        } else {
            throw new ClienteException("El cliente ya existe");
        }
        return newCliente;
    }

    @Override
    public Cliente findCliente(int idCliente) {

        Cliente cliente = null;
        cliente = entityManager.find(Cliente.class, idCliente);
        if (cliente != null) {
            return cliente;
        } else {
            throw new ClienteException("El cliente no existe");
        }
    }

    @Override
    public void deleteCliente(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCliente(int idCliente, Cliente updateCliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
