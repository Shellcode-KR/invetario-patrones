/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adms;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import logicanegocio.LnNotas;
import logicanegocio.LnProductos;
import logicanegocio.LnVentas;
import modelo.Notas;
import modelo.Productos;
import modelo.Venta;

/**
 *
 * @author hack_
 */
@Named(value = "adVenta")
@SessionScoped
public class AdVenta implements Serializable {

    @EJB
    private LnProductos lnProductos;

    private boolean notacreada = false;

    private int idnota;

    private List<Venta> carrito = new ArrayList<>();

    public List<Venta> getCarrito() {
        return carrito;
    }
    private Venta venta;
    private Notas nota;
    private Productos producto;

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    @EJB
    private LnNotas lnNotas;

    public boolean isNotacreada() {
        return notacreada;
    }

    //si la nota esta no esta, la crea
    public void crearNota() {
        if (!notacreada) {
            lnNotas.addNota(nota);
            notacreada = true;
        }
    }

    public Notas ultimanota() {
        nota = lnNotas.ultimaNota();
        return nota;
    }

    @EJB
    private LnVentas lnVentas;

    public Notas getNota() {
        return nota;
    }

    public void setNota(Notas nota) {
        this.nota = nota;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public boolean estaProducto() {
        for (Venta venta1 : carrito) {
            if (venta1.getIdProducto().getIdproductos().equals(producto.getIdproductos())) {
                return true;
            }
        }
        return false;
    }

    public Venta getProductoCarrito() {
        Venta vv = new Venta();
        for (Venta v : carrito) {
            if (v.getIdProducto().getIdproductos().equals(producto.getIdproductos())) {
                vv = v;
            }
        }
        return vv;
    }

    public void agregarVenta() {
        crearNota();
        ultimanota();
        venta.setFolioNota(nota);
        producto = lnProductos.findProducto(producto.getIdproductos());

        if (estaProducto()) {
            Venta v = getProductoCarrito();
            v.setCantidad(v.getCantidad() + venta.getCantidad());
            v.setImporte(producto.getPrecio() * v.getCantidad());
        } else {
            double aux = (producto.getPrecio() * venta.getCantidad());
            venta.setImporte(aux);
            venta.setIdProducto(producto);

            //lnVentas.addVenta(venta);
            carrito.add(venta);

        }

        venta = new Venta();
        producto = new Productos();

    }

    public double calcularTotal() {
        int total = 0;
        for (Venta venta : carrito) {
            total += venta.getImporte();
        }
        return total;
    }

    public void eliminarVenta(Venta venta) {
        carrito.remove(venta);
    }

    public void calcularTotales() {
        nota.setNumeroArticulosDiferentes(carrito.size());
        int aux = (int) (calcularTotal());
        nota.setImporte(aux);
        lnNotas.updateNota(nota);
    }

    public void comprar() {
        calcularTotales();
        for (Venta ventafinal : carrito) {
            lnVentas.addVenta(ventafinal);
            Productos auxp = new Productos();

            auxp = lnProductos.findProducto(ventafinal.getIdProducto().getIdproductos());  // Obtener el producto de la base de datos
            //producto= ventafinal.getIdProducto();

            Integer nExistencia = auxp.getExistencia() - ventafinal.getCantidad();
            auxp.setExistencia(nExistencia);
            lnProductos.updateProducto(auxp);

            nExistencia = 0;
            auxp = new Productos();
        }

        carrito = new ArrayList<>();
    }

    public void actualizarexistenciasProducto() {

    }

    public List<Venta> getProductosNota() {
        return lnVentas.findByFolioNota(nota);
    }

    public List<Venta> getVentas() {
        return lnVentas.findVentas();
    }

    /**
     * Creates a new instance of AdVenta
     */
    public AdVenta() {
        nota = new Notas();
        venta = new Venta();
        producto = new Productos();
        carrito = new ArrayList<>();
    }

}
