package com.molinadario.implementes;

import com.molinadario.entity.Canje;
import com.molinadario.entity.Cliente;
import com.molinadario.service.ClienteService;
import com.molindario.exception.ClienteException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ClienteImplementsService implements ClienteService {

    @PersistenceContext(name = "JNDI_JAVA")
    private EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger("ClienteImplementsService");

    @Override
    public Cliente newCliente(Cliente cliente) {

        LOGGER.info("method newCliente");

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

        LOGGER.info("method findCliente");

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
    public Cliente updateCliente(Cliente updateCliente) {
        LOGGER.info("method updateCliente");

        Cliente findCliente = entityManager.find(Cliente.class, updateCliente.getId_cliente());

        if (findCliente != null) {

            entityManager.merge(updateCliente);
            entityManager.flush();
            entityManager.clear();
            System.out.println("Cliente Actualizado " + findCliente);

        } else {
            throw new ClienteException("El cliente no es correcto");
        }
        return entityManager.find(Cliente.class, updateCliente.getId_cliente());
    }

    @Override
    public List<Canje> findCanje(int idCliente) {

        LOGGER.info("method findCanje");

        Cliente cliente = null;

        cliente = entityManager.find(Cliente.class, idCliente);

        if (cliente != null) {
            List<Canje> listCanje = cliente.getListCanje();
            for (Canje canje : listCanje) {
                System.out.println("ListCanje: " + canje);
            }
            return listCanje;
        } else {
            throw new ClienteException("ERROR (Cliente no existe) ");
        }

    }

    @Override
    public List<Cliente> allCliente() {

        List<Cliente> listCliente = null;

        TypedQuery<Cliente> queryCliente = entityManager.createNamedQuery("All_Cliente", Cliente.class);

        listCliente = queryCliente.getResultList();

        if (listCliente != null) {
            return listCliente;
        } else {
            throw new ClienteException("No existe ninun cliente");
        }
    }
}
