/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Notas;

/**
 *
 * @author hack_
 */
@Stateless
public class NotasFacade extends AbstractFacade<Notas> {

    @PersistenceContext(unitName = "inventario-productos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotasFacade() {
        super(Notas.class);
    }
    
}
