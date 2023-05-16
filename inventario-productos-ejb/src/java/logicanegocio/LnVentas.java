/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logicanegocio;

import accesodatos.VentaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Notas;
import modelo.Venta;

/**
 *
 * @author hack_
 */
@Stateless
@LocalBean
public class LnVentas {

    @EJB
    private VentaFacade ventaFacade;
    
    public List<Venta> findByFolioNota(Notas folioNota){
        return ventaFacade.findByFolioNota(folioNota);
    }
    
    public void addVenta(Venta v){
       ventaFacade.create(v);
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
