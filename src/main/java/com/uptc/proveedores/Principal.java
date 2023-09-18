package com.uptc.proveedores;

import com.uptc.proveedores.entity.Detalle;
import com.uptc.proveedores.entity.Factura;
import com.uptc.proveedores.entity.Persona;
import com.uptc.proveedores.entity.Producto;
import com.uptc.proveedores.persistence.PersistenceUtil;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        /*EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist();
        em.getTransaction().commit();*/



    }

    public static void imprimirFactura(Long idFactura){
        EntityManager em = PersistenceUtil.getEntityManager();
        Factura factura = em.find(Factura.class,idFactura);
        System.out.println("Factura "+factura.getId());
        System.out.println("Cliente: "+factura.getCliente().getNombre() +" "+factura.getCliente().getApellido() +"       Fecha de compra: "+factura.getFecha());
        System.out.println("Dirección cliente: "+factura.getCliente().getDireccion());
        System.out.println("id item     "+"Nombre Item      "+"Cantidad     "+"Valor unitario venta     "+"Venta");
        List<Detalle> listaDetalles= factura.getDetalles();
        Producto producto = new Producto();
        Detalle detalle= new Detalle();
        float subtotal=0;
        float totalVenta=0;
        for (int j = 0; j < listaDetalles.size(); j++) {
            detalle=listaDetalles.get(j);
            producto= em.find(Producto.class, detalle.getProducto().getId());
            subtotal= producto.getPrecioUnicatio()*detalle.getCantidad();
            totalVenta+=subtotal;
            System.out.println(producto.getId()+"           "+producto.getNombre()+"               "+detalle.getCantidad()+"                "+producto.getPrecioUnicatio()+"                "+subtotal);

        }
        System.out.println("                                                               TOTAL  "+ totalVenta);
        System.out.println("Atendido por: "+factura.getVendedor().getNombre()+" "+factura.getVendedor().getApellido());

    }

    public static void obtenerTotalVentasVendedor(Long idVendedor){
        EntityManager em = PersistenceUtil.getEntityManager();
        Persona vendedor = em.find(Persona.class,idVendedor);
        float totalventas=0;
        List<Factura> listaFactVendededor=vendedor.getFacturasComoVendedor();
        Detalle detalle = new Detalle();
        Producto producto = new Producto();
        List<Detalle> listaDetalles = new ArrayList<>();
        float subtotal=0;
        for (int i = 0; i < listaFactVendededor.size(); i++) {
            //Lista de detalles por cada factura
            listaDetalles= listaFactVendededor.get(i).getDetalles();
            for (int j = 0; j < listaDetalles.size(); j++) {
                detalle=listaDetalles.get(j);
                producto= em.find(Producto.class, detalle.getProducto().getId());
                subtotal= producto.getPrecioUnicatio()*detalle.getCantidad();
                totalventas+=subtotal;
            }
        }
        System.out.println("El valor vendido por el vendedor "+idVendedor+ "fue: "+totalventas);
    }
    public static void productosProveedor(Long idproveedor){


        EntityManager em = PersistenceUtil.getEntityManager();
        Persona persona = em.find(Persona.class,idproveedor);
        System.out.println(persona.getProductos());

    }
    public static List<Factura> facturasCliente(Long idCliente){
        EntityManager em = PersistenceUtil.getEntityManager();
        Persona persona = em.find(Persona.class,idCliente);
        List<Factura> facturaList = persona.getFacturasComoCliente();
        //System.out.println(facturaList);
        //System.out.println(persona.getFacturasComoCliente());
        return facturaList;
    }

    public static void insertarEnBaseDeDatos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        //Datos tabla Persona
        Persona persona1 = new Persona(1L,"Juan","Serrano", new Date(), "CC","1016102880", "Calle 45 ");
        Persona persona2 = new Persona(2L,"Camila","Perez", new Date(), "CC","1012345880","Calle 46 ");
        Persona persona3 = new Persona(3L,"Laura","Orjuela", new Date(), "CC","1100292880","Calle 47 ");
        Persona persona4 = new Persona(4L,"Tatiana","Sanchez", new Date(), "CC","1316112345","Calle 48 ");
        Persona persona5 = new Persona(5L,"Isabella","Bermudez", new Date(), "CC","1012102550","Calle 49 ");
        Persona persona6 = new Persona(6L,"Lorena","Toro", new Date(), "CC","1300102880","Calle 50 ");
        Persona persona7 = new Persona(7L,"Esperanza","Caramelo", new Date(), "CC","1226155880", "Calle 51 ");
        Persona persona8 = new Persona(8L,"Paola","Barrios", new Date(), "CC","1078902456", "Calle 52 ");
        List<Factura> listFac= new ArrayList<>();
        persona1.setFacturasComoCliente(listFac);
        persona2.setFacturasComoCliente(listFac);
        persona3.setFacturasComoCliente(listFac);
        persona4.setFacturasComoCliente(listFac);
        persona5.setFacturasComoCliente(listFac);
        persona6.setFacturasComoCliente(listFac);
        persona7.setFacturasComoCliente(listFac);
        persona8.setFacturasComoCliente(listFac);

        persona1.setFacturasComoVendedor(listFac);
        persona2.setFacturasComoVendedor(listFac);
        persona3.setFacturasComoVendedor(listFac);
        persona4.setFacturasComoVendedor(listFac);
        persona5.setFacturasComoVendedor(listFac);
        persona6.setFacturasComoVendedor(listFac);
        persona7.setFacturasComoVendedor(listFac);
        persona8.setFacturasComoVendedor(listFac);

        em.persist(persona1);
        em.persist(persona2);
        em.persist(persona3);
        em.persist(persona4);
        em.persist(persona5);
        em.persist(persona6);
        em.persist(persona7);
        em.persist(persona8);
        em.getTransaction().commit();

        EntityManager em2 = PersistenceUtil.getEntityManager();
        em2.getTransaction().begin();
        //Datos tabla Producto
        Producto producto1 = new Producto(1L,"Mouse", 25F);
        Producto producto2 = new Producto(2L,"Keypad", 35F);
        Producto producto3 = new Producto(3L,"HeadPhone", 12F);
        Producto producto4 = new Producto(4L,"Watch", 26F);
        Producto producto5 = new Producto(5L,"Kindle", 18F);

        em2.persist(producto1);
        em2.persist(producto5);
        em2.persist(producto4);
        em2.persist(producto3);
        em2.persist(producto2);
        em2.getTransaction().commit();

        EntityManager em3 = PersistenceUtil.getEntityManager();
        em3.getTransaction().begin();
        //Datos tabla Factura
        Factura factura1 = new Factura(1L, new Date(), persona1, persona2);
        Factura factura2 = new Factura(2L, new Date(), persona2, persona3);
        Factura factura3 = new Factura(3L, new Date(), persona3, persona4);
        Factura factura4 = new Factura(4L, new Date(), persona4, persona5);
        Factura factura5 = new Factura(5L, new Date(), persona5, persona1);
        Factura factura6 = new Factura(6L, new Date(), persona5, persona1);

        //Insertar lista facturas vendedores y a clientes
        persona1.getFacturasComoCliente().add(factura1);
        persona2.getFacturasComoCliente().add(factura2);
        persona3.getFacturasComoCliente().add(factura3);
        persona4.getFacturasComoCliente().add(factura4);
        persona5.getFacturasComoCliente().add(factura5);
        persona5.getFacturasComoCliente().add(factura6);

        persona1.getFacturasComoVendedor().add(factura5);
        persona2.getFacturasComoVendedor().add(factura1);
        persona3.getFacturasComoVendedor().add(factura2);
        persona4.getFacturasComoVendedor().add(factura3);
        persona5.getFacturasComoVendedor().add(factura4);
        persona1.getFacturasComoVendedor().add(factura6);

        em3.persist(factura1);
        em3.persist(factura2);
        em3.persist(factura3);
        em3.persist(factura4);
        em3.persist(factura5);
        em3.persist(factura6);
        em3.getTransaction().commit();

        EntityManager em4 = PersistenceUtil.getEntityManager();
        em4.getTransaction().begin();
        //Datos tabla Detalle
        Detalle detalle1 = new Detalle(1L, 55L, 23F,factura1,producto2);
        Detalle detalle2 = new Detalle(2L, 25L, 65F,factura2,producto1);
        Detalle detalle3 = new Detalle(3L, 35L, 85F,factura3,producto4);
        Detalle detalle4 = new Detalle(4L, 13L, 75F,factura4,producto5);
        Detalle detalle5 = new Detalle(5L, 5L, 20F,factura5,producto3);
        Detalle detalle6 = new Detalle(6L, 2L, 56F,factura6,producto1);
        Detalle detalle7 = new Detalle(7L, 3L, 89F,factura6,producto5);
        Detalle detalle8 = new Detalle(8L, 1L, 65F,factura6,producto4);

        List<Persona> listaProovedores = new ArrayList<>();
        listaProovedores.add(persona1);
        listaProovedores.add(persona2);
        listaProovedores.add(persona3);
        producto1.setListaProveedores(listaProovedores);

        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(producto1);
        listaProductos.add(producto3);
        listaProductos.add(producto5);
        persona2.setProductos(listaProductos);


        //factura1.setFecha(new Date());

        em4.persist(detalle1);
        em4.persist(detalle2);
        em4.persist(detalle3);
        em4.persist(detalle4);
        em4.persist(detalle5);
        em4.persist(detalle6);
        em4.persist(detalle7);
        em4.persist(detalle8);


        em4.getTransaction().commit();

    }
}
