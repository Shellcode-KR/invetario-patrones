/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    public Notas getUltimanota() {
        TypedQuery<Notas> consulta = em.createQuery(
                "SELECT n FROM Notas n WHERE n.id = (SELECT MAX(n2.id) FROM Notas n2)", Notas.class);
        Notas ultimaNota = consulta.getSingleResult();
        return ultimaNota;
    }

    public NotasFacade() {
        super(Notas.class);
    }

}
