package com.molinadario.service;

import com.molinadario.entity.Canje;
import com.molinadario.entity.Cliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteService {

    Cliente newCliente(Cliente cliente);

    Cliente findCliente(int idCliente);

    void deleteCliente(int idCliente);

    void updateCliente(int idCliente, Cliente updateCliente);
    
    List<Canje> findCanje(int idCliente);
    
    List<Cliente> allCliente();
}
