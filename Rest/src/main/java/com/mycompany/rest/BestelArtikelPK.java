/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author robertrook
 */
@Embeddable
public class BestelArtikelPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Bestelling")
    private int idBestelling;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Artikel")
    private int idArtikel;

    public BestelArtikelPK() {
    }

    public BestelArtikelPK(int idBestelling, int idArtikel) {
        this.idBestelling = idBestelling;
        this.idArtikel = idArtikel;
    }

    public int getIdBestelling() {
        return idBestelling;
    }

    public void setIdBestelling(int idBestelling) {
        this.idBestelling = idBestelling;
    }

    public int getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(int idArtikel) {
        this.idArtikel = idArtikel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idBestelling;
        hash += (int) idArtikel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BestelArtikelPK)) {
            return false;
        }
        BestelArtikelPK other = (BestelArtikelPK) object;
        if (this.idBestelling != other.idBestelling) {
            return false;
        }
        if (this.idArtikel != other.idArtikel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.BestelArtikelPK[ idBestelling=" + idBestelling + ", idArtikel=" + idArtikel + " ]";
    }
    
}
