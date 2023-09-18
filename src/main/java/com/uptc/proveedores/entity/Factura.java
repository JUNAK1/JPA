package com.uptc.proveedores.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @Column(name = "idFactura")
    private Long id;
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "idCliente", insertable = false, updatable = false)
    private Long idCliente;
    @Column(name = "idVendedor", insertable = false, updatable = false)
    private Long idvendedor;

    /*M:M*/

    @ManyToOne
    @JoinColumn(name="idCliente",nullable = false)//
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name="idVendedor", nullable = false)
    private Persona vendedor;

    @OneToMany(mappedBy = "factura")
    private List<Detalle> detalles;
    public Factura(){}

    public Factura(Long id, Date fecha, Long idCliente, Long idvendedor) {
        this.id = id;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idvendedor = idvendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Long idvendedor) {
        this.idvendedor = idvendedor;
    }



    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", idCliente=" + idCliente +
                ", idvendedor=" + idvendedor +
                '}';
    }


