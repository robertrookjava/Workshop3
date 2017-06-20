/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robertrook
 */
@Entity
@Table(name = "adres_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdresType.findAll", query = "SELECT a FROM AdresType a")
    , @NamedQuery(name = "AdresType.findByIdAdrestype", query = "SELECT a FROM AdresType a WHERE a.idAdrestype = :idAdrestype")
    , @NamedQuery(name = "AdresType.findBySoort", query = "SELECT a FROM AdresType a WHERE a.soort = :soort")})
public class AdresType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdres_type")
    private Integer idAdrestype;
    @Size(max = 45)
    @Column(name = "Soort")
    private String soort;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdrestype")
    private Collection<KlantHeeftAdres> klantHeeftAdresCollection;

    public AdresType() {
    }

    public AdresType(Integer idAdrestype) {
        this.idAdrestype = idAdrestype;
    }

    public Integer getIdAdrestype() {
        return idAdrestype;
    }

    public void setIdAdrestype(Integer idAdrestype) {
        this.idAdrestype = idAdrestype;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    @XmlTransient
    public Collection<KlantHeeftAdres> getKlantHeeftAdresCollection() {
        return klantHeeftAdresCollection;
    }

    public void setKlantHeeftAdresCollection(Collection<KlantHeeftAdres> klantHeeftAdresCollection) {
        this.klantHeeftAdresCollection = klantHeeftAdresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdrestype != null ? idAdrestype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresType)) {
            return false;
        }
        AdresType other = (AdresType) object;
        if ((this.idAdrestype == null && other.idAdrestype != null) || (this.idAdrestype != null && !this.idAdrestype.equals(other.idAdrestype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.AdresType[ idAdrestype=" + idAdrestype + " ]";
    }
    
}
