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
    @Column(name = "idFactura",insertable = false,updatable = false)
    private Long facturaId;

    @Column(name = "idProductos",insertable = false,updatable = false)
    private Long productosId;

    /*MM*/
    @ManyToOne
    @JoinColumn(name="idFactura", nullable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="idProductos", nullable = false)
    private Producto producto;
    public Detalle(){}

    public Detalle(Long id, Long cantidad, Float precioVenta, Long facturaId, Long productosId) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.facturaId = facturaId;
        this.productosId = productosId;
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

    public Long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    public Long getProductosId() {
        return productosId;
    }

    public void setProductosId(Long productosId) {
        this.productosId = productosId;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioVenta=" + precioVenta +
                ", facturaId=" + facturaId +
                ", productosId=" + productosId +
                '}';
    }
}
