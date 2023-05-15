/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logicanegocio;

import accesodatos.NotasFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Notas;

/**
 *
 * @author hack_
 */
@Stateless
@LocalBean
public class LnNotas {

    @EJB
    private NotasFacade notasFacade;

    public void addNota(Notas n){
        notasFacade.create(n);
    }
    public Notas ultimaNota(){
        return notasFacade.getUltimanota();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
