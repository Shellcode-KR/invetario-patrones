/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Venta;

/**
 *
 * @author hack_
 */
@Stateless
public class VentaFacade extends AbstractFacade<Venta> {

    @PersistenceContext(unitName = "inventario-productos-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Venta> findByFolioNota(Integer folioNota) {
        TypedQuery<Venta> query = em.createQuery("SELECT v FROM Venta v WHERE v.folioNota = :folioNota", Venta.class);
        query.setParameter("folioNota", folioNota);
        return query.getResultList();
    }

    public VentaFacade() {
        super(Venta.class);
    }

}
