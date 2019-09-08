package com.molinadario.webservice;

import com.molinadario.entity.Cliente;
import com.molinadario.service.ClienteService;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cliente")
public class ClienteWebService {

    @EJB
    private ClienteService clienteService;

    //<<< Nuevo Cliente >>>
    @POST
    @Path("/nuevoCliente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente newCliente(Cliente cliente) {

        Cliente newcliente = null;
        newcliente = clienteService.newCliente(cliente);
        return newcliente;
    }

    //<<< Buscar Cliente >>>
    @GET
    @Path("/{idCliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findCliente(@PathParam("idCliente") int idCliente) {

        Cliente cliente = null;
        cliente = clienteService.findCliente(idCliente);
        return cliente;

    }

}
