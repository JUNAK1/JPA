package com.uptc.proveedores.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalles")
public class Detalle {
    @Id
    @Column(name = "idDetalles")
    private Long id;
    @Column(name = "cantidad")
    private Long cantidad;
    @Column(name = "precioVenta")
    private Float precioVenta;
    //@Column(name = "idFactura",insertable = false,updatable = false)
    //private Long facturaId;

    //@Column(name = "idProductos",insertable = false,updatable = false)
    //private Long productosId;

    /*MM*/
    @ManyToOne
    @JoinColumn(name="idFactura", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="idProductos", nullable = false)
    private Producto producto;
    public Detalle(){}
    public Detalle(Long id, Long cantidad, Float precioVenta, Factura factura, Producto producto) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.factura = factura;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                ", facturaId=" + factura +
                ", productosId=" + producto +
                '}';
    }
}
