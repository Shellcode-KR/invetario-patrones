/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logicanegocio;

import accesodatos.ProductosFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Productos;

/**
 *
 * @author hack_
 */
@Stateless
@LocalBean
public class LnProductos {

    @EJB
    private ProductosFacade productosFacade;

    public List<Productos> findProductos(){
        return productosFacade.findAll();
    }
    public void  addProducto(Productos p){
        productosFacade.create(p);
    }
    
}
