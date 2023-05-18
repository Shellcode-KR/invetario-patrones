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

    public void agregarVenta() {
        crearNota();
        ultimanota();
        venta.setFolioNota(nota);
        producto = lnProductos.findProducto(producto.getIdproductos());
        int aux = (int) (producto.getPrecio() * venta.getCantidad());
        venta.setImporte(aux);
        venta.setIdProducto(producto);

        //lnVentas.addVenta(venta);
        carrito.add(venta);
        venta = new Venta();

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
            producto = lnProductos.findProducto(ventafinal.getIdProducto().getIdproductos());  // Obtener el producto de la base de datos
            int nExistencia = producto.getExistencia() - ventafinal.getCantidad();
            producto.setExistencia(nExistencia);
            lnProductos.updateProducto(producto);
        }

        carrito = new ArrayList<>();
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
