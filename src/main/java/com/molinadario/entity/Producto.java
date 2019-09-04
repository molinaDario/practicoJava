package com.molinadario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "stock")
    private int stock;

    @Column(name = "nivel_reposicion")
    private int nivel_reposicion;

    @Column(name = "costo")
    private double costo;

    public Producto() {
    }

    public Producto(String descripcion, int stock, int nivel_reposicion, double costo) {
        this.descripcion = descripcion;
        this.stock = stock;
        this.nivel_reposicion = nivel_reposicion;
        this.costo = costo;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getNivel_reposicion() {
        return nivel_reposicion;
    }

    public void setNivel_reposicion(int nivel_reposicion) {
        this.nivel_reposicion = nivel_reposicion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", descripcion=" + descripcion + ", stock=" + stock + ", nivel_reposicion=" + nivel_reposicion + ", costo=" + costo + '}';
    }

}
