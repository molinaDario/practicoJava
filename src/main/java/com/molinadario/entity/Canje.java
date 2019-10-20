package com.molinadario.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_canje")
public class Canje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_canje;
    
    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @JoinColumn(name = "fk_producto")  
    private Producto producto;

    public Canje() {
    }

    public Canje(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
    }

    public int getId_canje() {
        return id_canje;
    }

    public void setId_canje(int id_canje) {
        this.id_canje = id_canje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Canje{" + "id_canje=" + id_canje + ", producto=" + producto + '}';
    }

}
