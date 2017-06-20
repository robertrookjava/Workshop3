/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author robertrook
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByIdAccount", query = "SELECT a FROM Account a WHERE a.idAccount = :idAccount")
    , @NamedQuery(name = "Account.findByGebruikersnaam", query = "SELECT a FROM Account a WHERE a.gebruikersnaam = :gebruikersnaam")
    , @NamedQuery(name = "Account.findByWachtwoord", query = "SELECT a FROM Account a WHERE a.wachtwoord = :wachtwoord")
    , @NamedQuery(name = "Account.findByDatumAanmaak", query = "SELECT a FROM Account a WHERE a.datumAanmaak = :datumAanmaak")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Account")
    private Integer idAccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Gebruikersnaam")
    private String gebruikersnaam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "Wachtwoord")
    private String wachtwoord;
    @Column(name = "Datum_Aanmaak")
    @Temporal(TemporalType.DATE)
    private Date datumAanmaak;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccount")
    private Collection<Bestelling> bestellingCollection;
    @JoinColumn(name = "accountype_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Accountype accountypeId;

    public Account() {
    }

    public Account(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public Account(Integer idAccount, String gebruikersnaam, String wachtwoord) {
        this.idAccount = idAccount;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public Date getDatumAanmaak() {
        return datumAanmaak;
    }

    public void setDatumAanmaak(Date datumAanmaak) {
        this.datumAanmaak = datumAanmaak;
    }

    @XmlTransient
    public Collection<Bestelling> getBestellingCollection() {
        return bestellingCollection;
    }

    public void setBestellingCollection(Collection<Bestelling> bestellingCollection) {
        this.bestellingCollection = bestellingCollection;
    }

    public Accountype getAccountypeId() {
        return accountypeId;
    }

    public void setAccountypeId(Accountype accountypeId) {
        this.accountypeId = accountypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccount != null ? idAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.idAccount == null && other.idAccount != null) || (this.idAccount != null && !this.idAccount.equals(other.idAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.rest.Account[ idAccount=" + idAccount + " ]";
    }
    
}
