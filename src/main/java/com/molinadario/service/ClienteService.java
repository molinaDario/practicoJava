package com.molinadario.service;

import com.molinadario.entity.Cliente;
import javax.ejb.Local;

@Local
public interface ClienteService {

    Cliente newCliente(Cliente cliente);

    Cliente findCliente(int idCliente);

    void deleteCliente(int idCliente);

    void updateCliente(int idCliente, Cliente updateCliente);

}
