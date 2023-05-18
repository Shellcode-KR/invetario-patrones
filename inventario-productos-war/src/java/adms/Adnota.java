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
import modelo.Notas;

/**
 *
 * @author hack_
 */
@Named(value = "adnota")
@SessionScoped
public class Adnota implements Serializable {

    @EJB
    private LnNotas lnNotas;

    
    
    /**
     * Creates a new instance of Adnota
     */
    public List<Notas> getNotas(){
        return lnNotas.findNotas();
    }
    public Adnota() {
    }
    
}
