package com.uptc.proveedores.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "idProductos")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "precioUnitario")
    private Float precioUnicatio;

    @ManyToMany
    @JoinTable(
            name = "proveedor_producto",
            joinColumns = @JoinColumn(name = "idProductos"),
            inverseJoinColumns = @JoinColumn(name="idPersona"))
    private List<Persona> listaProveedores;

    @OneToMany(mappedBy = "producto")
    private List<Detalle> detalles;
    /*mm*/

    public Producto(){}

    public Producto(Long id, String nombre, Float precioUnicatio) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnicatio = precioUnicatio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecioUnicatio() {
        return precioUnicatio;
    }

    public void setPrecioUnicatio(Float precioUnicatio) {
        this.precioUnicatio = precioUnicatio;
    }

    public List<Persona> getPersonas() {
        return listaProveedores;
    }

    public void setPersonas(List<Persona> personas) {
        this.listaProveedores = personas;
    }

    public List<Persona> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Persona> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precioUnicatio=" + precioUnicatio +
                '}';
    }
}
