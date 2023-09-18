package com.uptc.proveedores.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @Column(name = "idPersona")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Column(name = "numeroDocumento")
    private String numeroDocumento;
    @Column(name = "direccion")
    private String direccion;
    /*M:M*/
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturasComoCliente;

    @OneToMany(mappedBy = "vendedor")
    private List<Factura> facturasComoVendedor;

    @ManyToMany(mappedBy = "listaProveedores")
    private List<Producto>productos;
    public Persona(){}

    public Persona(Long id, String nombre, String apellido, Date fechaNacimiento, String tipoDocumento, String numeroDocumento, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion=direccion;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public List<Factura> getFacturasComoCliente() {
        return facturasComoCliente;
    }

    public void setFacturasComoCliente(List<Factura> facturasComoCliente) {
        this.facturasComoCliente = facturasComoCliente;
    }

    public List<Factura> getFacturasComoVendedor() {
        return facturasComoVendedor;
    }

    public void setFacturasComoVendedor(List<Factura> facturasComoVendedor) {
        this.facturasComoVendedor = facturasComoVendedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
