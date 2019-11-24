package com.molinadario.controller;

import com.molinadario.entity.Cliente;
import com.molinadario.entity.Producto;
import com.molinadario.service.CanjeService;
import com.molinadario.service.ClienteService;
import com.molinadario.service.ProductoService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CanjeProducto", urlPatterns = {"/CanjeProducto"})
public class CanjeProducto extends HttpServlet {

    @EJB
    private ProductoService productoService;

    @EJB
    private CanjeService canjeService;

    @EJB
    private ClienteService clienteService;

    private List<Producto> listProducto;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cliente cliente = (Cliente) request.getSession().getAttribute("sessionCliente");

        System.out.println("cliente session: " + cliente);

        String[] productoSeleccionado = request.getParameterValues("productos");

        double total = 0;

        if (productoSeleccionado != null) {

            if (productoSeleccionado.length > 0) {

                listProducto = new ArrayList<>();

                for (String elem : productoSeleccionado) {
                    int idProducto = Integer.parseInt(elem);
                    listProducto.add(productoService.buscarProducto(idProducto));
                }
            }
            for (Producto producto : listProducto) {
                System.out.println(producto);
                total += producto.getPrecio();
            }
            System.out.println("Total: " + total);

            if (cliente.getSaldo() > total) {

                for (Producto producto : listProducto) {

                    if (producto.getStock() > producto.getNivel_reposicion()) {

                        canjeService.newCanje(cliente.getId_cliente(), producto.getId_producto());

                        producto.setStock(producto.getStock() - 1);

                        cliente.setSaldo(cliente.getSaldo() - producto.getPrecio());

                        cliente.setPuntos(cliente.getPuntos() + (total * 20) / 100);

                        clienteService.updateCliente(cliente);

                        productoService.updateProducto(producto);
                    }
                }

                request.setAttribute("ClienteUpdate", clienteService.findCliente(cliente.getId_cliente()));

                request.getRequestDispatcher("CanjeRealizado.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
