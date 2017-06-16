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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robertrook
 */
@Entity
@Table(name = "klant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klant.findAll", query = "SELECT k FROM Klant k")
    , @NamedQuery(name = "Klant.findByIdKlant", query = "SELECT k FROM Klant k WHERE k.idKlant = :idKlant")
    , @NamedQuery(name = "Klant.findByVoornaam", query = "SELECT k FROM Klant k WHERE k.voornaam = :voornaam")
    , @NamedQuery(name = "Klant.findByAchternaam", query = "SELECT k FROM Klant k WHERE k.achternaam = :achternaam")
    , @NamedQuery(name = "Klant.findByTussenvoegsel", query = "SELECT k FROM Klant k WHERE k.tussenvoegsel = :tussenvoegsel")
    , @NamedQuery(name = "Klant.findByTelefoonnummer", query = "SELECT k FROM Klant k WHERE k.telefoonnummer = :telefoonnummer")
    , @NamedQuery(name = "Klant.findByEmailadres", query = "SELECT k FROM Klant k WHERE k.emailadres = :emailadres")})
public class Klant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Klant")
    private Integer idKlant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "Voornaam")
    private String voornaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "Achternaam")
    private String achternaam;
    @Size(max = 15)
    @Column(name = "Tussenvoegsel")
    private String tussenvoegsel;
    @Size(max = 20)
    @Column(name = "Telefoonnummer")
    private String telefoonnummer;
    @Size(max = 45)
    @Column(name = "Emailadres")
    private String emailadres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKlant")
    private Collection<Bestelling> bestellingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "klant")
    private Collection<KlantHeeftAdres> klantHeeftAdresCollection;

    public Klant() {
    }

    public Klant(Integer idKlant) {
        this.idKlant = idKlant;
    }

    public Klant(Integer idKlant, String voornaam, String achternaam) {
        this.idKlant = idKlant;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }

    public Integer getIdKlant() {
        return idKlant;
    }

    public void setIdKlant(Integer idKlant) {
        this.idKlant = idKlant;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    @XmlTransient
    public Collection<Bestelling> getBestellingCollection() {
        return bestellingCollection;
    }

    public void setBestellingCollection(Collection<Bestelling> bestellingCollection) {
        this.bestellingCollection = bestellingCollection;
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
        hash += (idKlant != null ? idKlant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klant)) {
            return false;
        }
        Klant other = (Klant) object;
        if ((this.idKlant == null && other.idKlant != null) || (this.idKlant != null && !this.idKlant.equals(other.idKlant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.Klant[ idKlant=" + idKlant + " ]";
    }
    
}
