/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import logicanegocio.LnProductos;
import modelo.Productos;
import modelo.Unidades;

/**
 *
 * @author hack_
 */
@Named(value = "adProductos")
@SessionScoped
public class AdProductos implements Serializable {

    @EJB
    private LnProductos lnProductos;
    private boolean actualizado = false;
    private int numerodias = 3;

    public int getNumerodias() {
        return numerodias;
    }

    public void setNumerodias(int numerodias) {
        this.numerodias = numerodias;
    }

    public boolean isActualizado() {
        return actualizado;
    }

    public void setActualizado(boolean actualizado) {
        this.actualizado = actualizado;
    }

    private Productos producto;
    private Unidades unidad;

    public Unidades getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidades unidad) {
        this.unidad = unidad;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public void agregarProducto() {
        producto.setUnidad(unidad);
        lnProductos.addProducto(producto);
    }

    public void actualizarProducto() {
        int existencias = producto.getExistencia();
        //Double precio = producto.getPrecio();
        producto = lnProductos.findProducto(producto.getIdproductos());
        producto.setExistencia(existencias);
        //producto.setPrecio(precio);
        lnProductos.updateProducto(producto);
        actualizado = true;
    }

    /**
     * Creates a new instance of AdProductos
     */
    public AdProductos() {
        producto = new Productos();
        unidad = new Unidades();
    }

    public List<Productos> getProductos() {
        return lnProductos.findProductos();
    }

    public List<Productos> getProductosConFechaElabNoMayor() {
        List<Productos> listaProductos = lnProductos.findProductos();
        List<Productos> productosFiltrados = new ArrayList<>();

        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -numerodias);
        Date fechaLimite = calendar.getTime();

        for (Productos producto : listaProductos) {
            if (producto.getFechaElab() != null && producto.getFechaElab().compareTo(fechaLimite) >= 0) {
                productosFiltrados.add(producto);
            }
        }

        return productosFiltrados;
    }
}
