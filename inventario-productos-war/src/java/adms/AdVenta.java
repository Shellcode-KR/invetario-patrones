/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package adms;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import logicanegocio.LnNotas;
import logicanegocio.LnVentas;
import modelo.Notas;
import modelo.Venta;

/**
 *
 * @author hack_
 */
@Named(value = "adVenta")
@SessionScoped
public class AdVenta implements Serializable {
    
    private boolean notacreada = false;

    private int idnota;
    
    private Venta venta;
    private Notas nota;
    @EJB
    private LnNotas lnNotas;

    public boolean isNotacreada() {
        return notacreada;
    }
    //si la nota esta no esta, la crea
    public void crearNota(){
        if (!notacreada) {
            lnNotas.addNota(nota);
            notacreada=true;
        }
    }
    public Notas ultimanota(){
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
    
    
    public void agregarVenta(){
        crearNota();
        ultimanota();
        venta.setFolioNota(nota);
        lnVentas.addVenta(venta);
    }
    
    public List<Venta> getProductosNota(){
        return lnVentas.findByFolioNota(nota.getIdnota()+"");
    }
    /**
     * Creates a new instance of AdVenta
     */
    public AdVenta() {
        nota = new Notas();
        venta = new Venta();
    }
    
}
