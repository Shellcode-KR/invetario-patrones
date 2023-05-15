/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hack_
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findByIdnota", query = "SELECT n FROM Notas n WHERE n.idnota = :idnota"),
    @NamedQuery(name = "Notas.findByFechaNota", query = "SELECT n FROM Notas n WHERE n.fechaNota = :fechaNota"),
    @NamedQuery(name = "Notas.findByNumeroArticulosDiferentes", query = "SELECT n FROM Notas n WHERE n.numeroArticulosDiferentes = :numeroArticulosDiferentes"),
    @NamedQuery(name = "Notas.findByImporte", query = "SELECT n FROM Notas n WHERE n.importe = :importe")})
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnota")
    private Integer idnota;
    @Column(name = "fecha_nota")
    @Temporal(TemporalType.DATE)
    private Date fechaNota;
    @Size(max = 45)
    @Column(name = "numero_articulos_diferentes")
    private String numeroArticulosDiferentes;
    @Column(name = "importe")
    private Integer importe;
    @OneToMany(mappedBy = "folioNota")
    private List<Venta> ventaList;

    public Notas() {
    }

    public Notas(Integer idnota) {
        this.idnota = idnota;
    }

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public Date getFechaNota() {
        return fechaNota;
    }

    public void setFechaNota(Date fechaNota) {
        this.fechaNota = fechaNota;
    }

    public String getNumeroArticulosDiferentes() {
        return numeroArticulosDiferentes;
    }

    public void setNumeroArticulosDiferentes(String numeroArticulosDiferentes) {
        this.numeroArticulosDiferentes = numeroArticulosDiferentes;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnota != null ? idnota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notas)) {
            return false;
        }
        Notas other = (Notas) object;
        if ((this.idnota == null && other.idnota != null) || (this.idnota != null && !this.idnota.equals(other.idnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Notas[ idnota=" + idnota + " ]";
    }
    
}
