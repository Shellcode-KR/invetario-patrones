/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hack_
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.idventa = :idventa"),
    @NamedQuery(name = "Venta.findByCantidad", query = "SELECT v FROM Venta v WHERE v.cantidad = :cantidad")})
public class Venta implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe")
    private Double importe;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventa")
    private Integer idventa;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "folio_nota", referencedColumnName = "idnota")
    @ManyToOne
    private Notas folioNota;
    @JoinColumn(name = "id_producto", referencedColumnName = "idproductos")
    @ManyToOne
    private Productos idProducto;

    public Venta() {
    }

    public Venta(Integer idventa) {
        this.idventa = idventa;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Notas getFolioNota() {
        return folioNota;
    }

    public void setFolioNota(Notas folioNota) {
        this.folioNota = folioNota;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.idventa, other.idventa)) {
            return false;
        }
        if (!Objects.equals(this.cantidad, other.cantidad)) {
            return false;
        }
        return Objects.equals(this.idProducto, other.idProducto);
    }

   

    @Override
    public String toString() {
        return "Venta{" + "importe=" + importe + ", idventa=" + idventa + ", cantidad=" + cantidad + ", folioNota=" + folioNota + ", idProducto=" + idProducto + '}';
    }

    

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
    
}
