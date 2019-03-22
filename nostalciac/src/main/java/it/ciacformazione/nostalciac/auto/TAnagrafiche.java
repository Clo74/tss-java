/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.auto;

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
 * @author tss
 */
@Entity
@Table(name = "t_anagrafiche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAnagrafiche.findAll", query = "SELECT t FROM TAnagrafiche t")
    , @NamedQuery(name = "TAnagrafiche.findByIdAnagrafica", query = "SELECT t FROM TAnagrafiche t WHERE t.idAnagrafica = :idAnagrafica")
    , @NamedQuery(name = "TAnagrafiche.findByCognome", query = "SELECT t FROM TAnagrafiche t WHERE t.cognome = :cognome")
    , @NamedQuery(name = "TAnagrafiche.findByNome", query = "SELECT t FROM TAnagrafiche t WHERE t.nome = :nome")
    , @NamedQuery(name = "TAnagrafiche.findByDataNascita", query = "SELECT t FROM TAnagrafiche t WHERE t.dataNascita = :dataNascita")
    , @NamedQuery(name = "TAnagrafiche.findByUsr", query = "SELECT t FROM TAnagrafiche t WHERE t.usr = :usr")
    , @NamedQuery(name = "TAnagrafiche.findByPwd", query = "SELECT t FROM TAnagrafiche t WHERE t.pwd = :pwd")
    , @NamedQuery(name = "TAnagrafiche.findByMail", query = "SELECT t FROM TAnagrafiche t WHERE t.mail = :mail")
    , @NamedQuery(name = "TAnagrafiche.findByRuolo", query = "SELECT t FROM TAnagrafiche t WHERE t.ruolo = :ruolo")
    , @NamedQuery(name = "TAnagrafiche.findByIndirizzo", query = "SELECT t FROM TAnagrafiche t WHERE t.indirizzo = :indirizzo")
    , @NamedQuery(name = "TAnagrafiche.findByTel", query = "SELECT t FROM TAnagrafiche t WHERE t.tel = :tel")
    , @NamedQuery(name = "TAnagrafiche.findByNote", query = "SELECT t FROM TAnagrafiche t WHERE t.note = :note")
    , @NamedQuery(name = "TAnagrafiche.findByFilefoto", query = "SELECT t FROM TAnagrafiche t WHERE t.filefoto = :filefoto")
    , @NamedQuery(name = "TAnagrafiche.findByCitta", query = "SELECT t FROM TAnagrafiche t WHERE t.citta = :citta")})
public class TAnagrafiche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anagrafica")
    private Integer idAnagrafica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascita")
    @Temporal(TemporalType.DATE)
    private Date dataNascita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usr")
    private String usr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pwd")
    private String pwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mail")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ruolo")
    private String ruolo;
    @Size(max = 45)
    @Column(name = "indirizzo")
    private String indirizzo;
    @Size(max = 45)
    @Column(name = "tel")
    private String tel;
    @Size(max = 2000)
    @Column(name = "note")
    private String note;
    @Size(max = 100)
    @Column(name = "filefoto")
    private String filefoto;
    @Size(max = 50)
    @Column(name = "citta")
    private String citta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnagrafica")
    private Collection<TEsperienze> tEsperienzeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnagrafica")
    private Collection<TAnagraficheCorsi> tAnagraficheCorsiCollection;

    public TAnagrafiche() {
    }

    public TAnagrafiche(Integer idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public TAnagrafiche(Integer idAnagrafica, String cognome, String nome, String usr, String pwd, String mail, String ruolo) {
        this.idAnagrafica = idAnagrafica;
        this.cognome = cognome;
        this.nome = nome;
        this.usr = usr;
        this.pwd = pwd;
        this.mail = mail;
        this.ruolo = ruolo;
    }

    public Integer getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(Integer idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFilefoto() {
        return filefoto;
    }

    public void setFilefoto(String filefoto) {
        this.filefoto = filefoto;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @XmlTransient
    public Collection<TEsperienze> getTEsperienzeCollection() {
        return tEsperienzeCollection;
    }

    public void setTEsperienzeCollection(Collection<TEsperienze> tEsperienzeCollection) {
        this.tEsperienzeCollection = tEsperienzeCollection;
    }

    @XmlTransient
    public Collection<TAnagraficheCorsi> getTAnagraficheCorsiCollection() {
        return tAnagraficheCorsiCollection;
    }

    public void setTAnagraficheCorsiCollection(Collection<TAnagraficheCorsi> tAnagraficheCorsiCollection) {
        this.tAnagraficheCorsiCollection = tAnagraficheCorsiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnagrafica != null ? idAnagrafica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAnagrafiche)) {
            return false;
        }
        TAnagrafiche other = (TAnagrafiche) object;
        if ((this.idAnagrafica == null && other.idAnagrafica != null) || (this.idAnagrafica != null && !this.idAnagrafica.equals(other.idAnagrafica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.ciacformazione.nostalciac.auto.TAnagrafiche[ idAnagrafica=" + idAnagrafica + " ]";
    }
    
}
