/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

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
public class KlantHeeftAdresPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idKlant")
    private int idKlant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdres")
    private int idAdres;

    public KlantHeeftAdresPK() {
    }

    public KlantHeeftAdresPK(int idKlant, int idAdres) {
        this.idKlant = idKlant;
        this.idAdres = idAdres;
    }

    public int getIdKlant() {
        return idKlant;
    }

    public void setIdKlant(int idKlant) {
        this.idKlant = idKlant;
    }

    public int getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(int idAdres) {
        this.idAdres = idAdres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idKlant;
        hash += (int) idAdres;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KlantHeeftAdresPK)) {
            return false;
        }
        KlantHeeftAdresPK other = (KlantHeeftAdresPK) object;
        if (this.idKlant != other.idKlant) {
            return false;
        }
        if (this.idAdres != other.idAdres) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.KlantHeeftAdresPK[ idKlant=" + idKlant + ", idAdres=" + idAdres + " ]";
    }
    
}
