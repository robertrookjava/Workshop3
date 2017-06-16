/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robertrook
 */
@Entity
@Table(name = "bestelling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestelling.findAll", query = "SELECT b FROM Bestelling b")
    , @NamedQuery(name = "Bestelling.findByIdBestelling", query = "SELECT b FROM Bestelling b WHERE b.idBestelling = :idBestelling")
    , @NamedQuery(name = "Bestelling.findByDatumBestelling", query = "SELECT b FROM Bestelling b WHERE b.datumBestelling = :datumBestelling")})
public class Bestelling implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Bestelling")
    private Integer idBestelling;
    @Column(name = "Datum_Bestelling")
    @Temporal(TemporalType.DATE)
    private Date datumBestelling;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bestelling")
    private Collection<BestelArtikel> bestelArtikelCollection;
    @JoinColumn(name = "id_Klant", referencedColumnName = "id_Klant")
    @ManyToOne(optional = false)
    private Klant idKlant;
    @JoinColumn(name = "id_Account", referencedColumnName = "id_Account")
    @ManyToOne(optional = false)
    private Account idAccount;

    public Bestelling() {
    }

    public Bestelling(Integer idBestelling) {
        this.idBestelling = idBestelling;
    }

    public Integer getIdBestelling() {
        return idBestelling;
    }

    public void setIdBestelling(Integer idBestelling) {
        this.idBestelling = idBestelling;
    }

    public Date getDatumBestelling() {
        return datumBestelling;
    }

    public void setDatumBestelling(Date datumBestelling) {
        this.datumBestelling = datumBestelling;
    }

    @XmlTransient
    public Collection<BestelArtikel> getBestelArtikelCollection() {
        return bestelArtikelCollection;
    }

    public void setBestelArtikelCollection(Collection<BestelArtikel> bestelArtikelCollection) {
        this.bestelArtikelCollection = bestelArtikelCollection;
    }

    public Klant getIdKlant() {
        return idKlant;
    }

    public void setIdKlant(Klant idKlant) {
        this.idKlant = idKlant;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBestelling != null ? idBestelling.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestelling)) {
            return false;
        }
        Bestelling other = (Bestelling) object;
        if ((this.idBestelling == null && other.idBestelling != null) || (this.idBestelling != null && !this.idBestelling.equals(other.idBestelling))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.Bestelling[ idBestelling=" + idBestelling + " ]";
    }
    
}
