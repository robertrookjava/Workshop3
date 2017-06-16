/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.io.Serializable;
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
@Table(name = "adres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")
    , @NamedQuery(name = "Adres.findByIdAdres", query = "SELECT a FROM Adres a WHERE a.idAdres = :idAdres")
    , @NamedQuery(name = "Adres.findByStraat", query = "SELECT a FROM Adres a WHERE a.straat = :straat")
    , @NamedQuery(name = "Adres.findByHuisnummer", query = "SELECT a FROM Adres a WHERE a.huisnummer = :huisnummer")
    , @NamedQuery(name = "Adres.findByToevoeging", query = "SELECT a FROM Adres a WHERE a.toevoeging = :toevoeging")
    , @NamedQuery(name = "Adres.findByPostcode", query = "SELECT a FROM Adres a WHERE a.postcode = :postcode")
    , @NamedQuery(name = "Adres.findByWoonplaats", query = "SELECT a FROM Adres a WHERE a.woonplaats = :woonplaats")})
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAdres")
    private Integer idAdres;
    @Size(max = 45)
    @Column(name = "Straat")
    private String straat;
    @Column(name = "Huisnummer")
    private Integer huisnummer;
    @Size(max = 10)
    @Column(name = "Toevoeging")
    private String toevoeging;
    @Size(max = 10)
    @Column(name = "Postcode")
    private String postcode;
    @Size(max = 30)
    @Column(name = "Woonplaats")
    private String woonplaats;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adres")
    private Collection<KlantHeeftAdres> klantHeeftAdresCollection;

    public Adres() {
    }

    public Adres(Integer idAdres) {
        this.idAdres = idAdres;
    }

    public Integer getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(Integer idAdres) {
        this.idAdres = idAdres;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public Integer getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(Integer huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
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
        hash += (idAdres != null ? idAdres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adres)) {
            return false;
        }
        Adres other = (Adres) object;
        if ((this.idAdres == null && other.idAdres != null) || (this.idAdres != null && !this.idAdres.equals(other.idAdres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.Adres[ idAdres=" + idAdres + " ]";
    }
    
}
