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
import logicanegocio.LnClientes;
import modelo.Cliente;

/**
 *
 * @author hack_
 */
@Named(value = "adClientes")
@SessionScoped
public class AdClientes implements Serializable {

    @EJB
    private LnClientes lnClientes;
    private Cliente cliente;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Cliente> getClientes(){
        return lnClientes.findClientes();
    }
    public void agregarCliente(){
            //Convierte los apellidos en un string para un solo campo en la tabla
            apellidoPaterno=apellidoPaterno.trim();
            apellidoMaterno=apellidoMaterno.trim();
            cliente.setApellidoCl(apellidoPaterno+" "+apellidoMaterno);
            
            lnClientes.addCliente(cliente);
    }
    
    
    /**
     * Creates a new instance of AdClientes
     */
    public AdClientes() {
    }
    
}
