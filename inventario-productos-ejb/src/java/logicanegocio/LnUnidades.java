/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logicanegocio;

import accesodatos.ProductosFacade;
import accesodatos.UnidadesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Unidades;

/**
 *
 * @author hack_
 */
@Stateless
@LocalBean
public class LnUnidades {

    @EJB
    private UnidadesFacade unidadesFacade;

    public List<Unidades> findUnidades(){
        return unidadesFacade.findAll();
    }
    
}
