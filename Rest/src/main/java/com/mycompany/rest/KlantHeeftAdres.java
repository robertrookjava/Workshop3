/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author robertrook
 */
@Entity
@Table(name = "klant_heeft_adres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KlantHeeftAdres.findAll", query = "SELECT k FROM KlantHeeftAdres k")
    , @NamedQuery(name = "KlantHeeftAdres.findByIdKlant", query = "SELECT k FROM KlantHeeftAdres k WHERE k.klantHeeftAdresPK.idKlant = :idKlant")
    , @NamedQuery(name = "KlantHeeftAdres.findByIdAdres", query = "SELECT k FROM KlantHeeftAdres k WHERE k.klantHeeftAdresPK.idAdres = :idAdres")})
public class KlantHeeftAdres implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KlantHeeftAdresPK klantHeeftAdresPK;
    @JoinColumn(name = "idAdres", referencedColumnName = "idAdres", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Adres adres;
    @JoinColumn(name = "idKlant", referencedColumnName = "id_Klant", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Klant klant;
    @JoinColumn(name = "idAdres_type", referencedColumnName = "idAdres_type")
    @ManyToOne(optional = false)
    private AdresType idAdrestype;

    public KlantHeeftAdres() {
    }

    public KlantHeeftAdres(KlantHeeftAdresPK klantHeeftAdresPK) {
        this.klantHeeftAdresPK = klantHeeftAdresPK;
    }

    public KlantHeeftAdres(int idKlant, int idAdres) {
        this.klantHeeftAdresPK = new KlantHeeftAdresPK(idKlant, idAdres);
    }

    public KlantHeeftAdresPK getKlantHeeftAdresPK() {
        return klantHeeftAdresPK;
    }

    public void setKlantHeeftAdresPK(KlantHeeftAdresPK klantHeeftAdresPK) {
        this.klantHeeftAdresPK = klantHeeftAdresPK;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public AdresType getIdAdrestype() {
        return idAdrestype;
    }

    public void setIdAdrestype(AdresType idAdrestype) {
        this.idAdrestype = idAdrestype;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klantHeeftAdresPK != null ? klantHeeftAdresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlantHeeftAdres)) {
            return false;
        }
        KlantHeeftAdres other = (KlantHeeftAdres) object;
        if ((this.klantHeeftAdresPK == null && other.klantHeeftAdresPK != null) || (this.klantHeeftAdresPK != null && !this.klantHeeftAdresPK.equals(other.klantHeeftAdresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.KlantHeeftAdres[ klantHeeftAdresPK=" + klantHeeftAdresPK + " ]";
    }
    
}
