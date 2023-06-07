/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logicanegocio;

import accesodatos.ClienteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Cliente;

/**
 *
 * @author hack_
 */
@Stateless
@LocalBean
public class LnClientes {

    @EJB
    private ClienteFacade clienteFacade;

    public List<Cliente> findClientes(){
        return clienteFacade.findAll();
    }
    public void addCliente(Cliente p){
        clienteFacade.create(p);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
