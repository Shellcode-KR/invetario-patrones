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
import logicanegocio.LnUnidades;
import modelo.Unidades;

/**
 *
 * @author hack_
 */
@Named(value = "adUnidades")
@SessionScoped
public class AdUnidades implements Serializable {

    @EJB
    private LnUnidades lnUnidades;

    /**
     * Creates a new instance of AdUnidades
     */
    
    public List<Unidades> getUnidades(){
        return lnUnidades.findUnidades();
    }
    
    public AdUnidades() {
    }
    
}
