/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "bestel_artikel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BestelArtikel.findAll", query = "SELECT b FROM BestelArtikel b")
    , @NamedQuery(name = "BestelArtikel.findById", query = "SELECT b FROM BestelArtikel b WHERE b.id = :id")
    , @NamedQuery(name = "BestelArtikel.findByIdBestelling", query = "SELECT b FROM BestelArtikel b WHERE b.bestelArtikelPK.idBestelling = :idBestelling")
    , @NamedQuery(name = "BestelArtikel.findByIdArtikel", query = "SELECT b FROM BestelArtikel b WHERE b.bestelArtikelPK.idArtikel = :idArtikel")
    , @NamedQuery(name = "BestelArtikel.findByAantal", query = "SELECT b FROM BestelArtikel b WHERE b.aantal = :aantal")})
public class BestelArtikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BestelArtikelPK bestelArtikelPK;
    @Column(name = "id")
    private Integer id;
    @Column(name = "Aantal")
    private Integer aantal;
    @JoinColumn(name = "id_Artikel", referencedColumnName = "id_Artikel", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Artikel artikel;
    @JoinColumn(name = "id_Bestelling", referencedColumnName = "id_Bestelling", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bestelling bestelling;

    public BestelArtikel() {
    }

    public BestelArtikel(BestelArtikelPK bestelArtikelPK) {
        this.bestelArtikelPK = bestelArtikelPK;
    }

    public BestelArtikel(int idBestelling, int idArtikel) {
        this.bestelArtikelPK = new BestelArtikelPK(idBestelling, idArtikel);
    }

    public BestelArtikelPK getBestelArtikelPK() {
        return bestelArtikelPK;
    }

    public void setBestelArtikelPK(BestelArtikelPK bestelArtikelPK) {
        this.bestelArtikelPK = bestelArtikelPK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAantal() {
        return aantal;
    }

    public void setAantal(Integer aantal) {
        this.aantal = aantal;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Bestelling getBestelling() {
        return bestelling;
    }

    public void setBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestelArtikelPK != null ? bestelArtikelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BestelArtikel)) {
            return false;
        }
        BestelArtikel other = (BestelArtikel) object;
        if ((this.bestelArtikelPK == null && other.bestelArtikelPK != null) || (this.bestelArtikelPK != null && !this.bestelArtikelPK.equals(other.bestelArtikelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.BestelArtikel[ bestelArtikelPK=" + bestelArtikelPK + " ]";
    }
    
}
