/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robertrook
 */
@Entity
@Table(name = "artikel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a")
    , @NamedQuery(name = "Artikel.findByIdArtikel", query = "SELECT a FROM Artikel a WHERE a.idArtikel = :idArtikel")
    , @NamedQuery(name = "Artikel.findByNaam", query = "SELECT a FROM Artikel a WHERE a.naam = :naam")
    , @NamedQuery(name = "Artikel.findByPrijs", query = "SELECT a FROM Artikel a WHERE a.prijs = :prijs")
    , @NamedQuery(name = "Artikel.findByVoorraad", query = "SELECT a FROM Artikel a WHERE a.voorraad = :voorraad")})
public class Artikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Artikel")
    private Integer idArtikel;
    @Size(max = 25)
    @Column(name = "Naam")
    private String naam;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Prijs")
    private BigDecimal prijs;
    @Column(name = "Voorraad")
    private Integer voorraad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikel")
    private Collection<BestelArtikel> bestelArtikelCollection;

    public Artikel() {
    }

    public Artikel(Integer idArtikel) {
        this.idArtikel = idArtikel;
    }

    public Integer getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(Integer idArtikel) {
        this.idArtikel = idArtikel;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public Integer getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(Integer voorraad) {
        this.voorraad = voorraad;
    }

    @XmlTransient
    public Collection<BestelArtikel> getBestelArtikelCollection() {
        return bestelArtikelCollection;
    }

    public void setBestelArtikelCollection(Collection<BestelArtikel> bestelArtikelCollection) {
        this.bestelArtikelCollection = bestelArtikelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArtikel != null ? idArtikel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikel)) {
            return false;
        }
        Artikel other = (Artikel) object;
        if ((this.idArtikel == null && other.idArtikel != null) || (this.idArtikel != null && !this.idArtikel.equals(other.idArtikel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.Artikel[ idArtikel=" + idArtikel + " ]";
    }
    
}
