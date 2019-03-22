/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.auto;

import it.ciacformazione.nostalciac.entity.Sede;
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
 * @author tss
 */
@Entity
@Table(name = "t_corsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TCorsi.findAll", query = "SELECT t FROM TCorsi t")
    , @NamedQuery(name = "TCorsi.findByIdCorso", query = "SELECT t FROM TCorsi t WHERE t.idCorso = :idCorso")
    , @NamedQuery(name = "TCorsi.findByNomeCorso", query = "SELECT t FROM TCorsi t WHERE t.nomeCorso = :nomeCorso")
    , @NamedQuery(name = "TCorsi.findByEdizione", query = "SELECT t FROM TCorsi t WHERE t.edizione = :edizione")
    , @NamedQuery(name = "TCorsi.findByDataInizio", query = "SELECT t FROM TCorsi t WHERE t.dataInizio = :dataInizio")
    , @NamedQuery(name = "TCorsi.findByDataFine", query = "SELECT t FROM TCorsi t WHERE t.dataFine = :dataFine")
    , @NamedQuery(name = "TCorsi.findByNoteCorso", query = "SELECT t FROM TCorsi t WHERE t.noteCorso = :noteCorso")})
public class TCorsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_corso")
    private Integer idCorso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nome_corso")
    private String nomeCorso;
    @Size(max = 45)
    @Column(name = "edizione")
    private String edizione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inizio")
    @Temporal(TemporalType.DATE)
    private Date dataInizio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_fine")
    @Temporal(TemporalType.DATE)
    private Date dataFine;
    @Size(max = 5000)
    @Column(name = "note_corso")
    private String noteCorso;
    @JoinColumn(name = "id_sede", referencedColumnName = "id_sede")
    @ManyToOne(optional = false)
    private Sede idSede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCorso")
    private Collection<TTagsCorsi> tTagsCorsiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCorso")
    private Collection<TAnagraficheCorsi> tAnagraficheCorsiCollection;

    public TCorsi() {
    }

    public TCorsi(Integer idCorso) {
        this.idCorso = idCorso;
    }

    public TCorsi(Integer idCorso, String nomeCorso, Date dataInizio, Date dataFine) {
        this.idCorso = idCorso;
        this.nomeCorso = nomeCorso;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Integer getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(Integer idCorso) {
        this.idCorso = idCorso;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public String getEdizione() {
        return edizione;
    }

    public void setEdizione(String edizione) {
        this.edizione = edizione;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public String getNoteCorso() {
        return noteCorso;
    }

    public void setNoteCorso(String noteCorso) {
        this.noteCorso = noteCorso;
    }

    public Sede getIdSede() {
        return idSede;
    }

    public void setIdSede(Sede idSede) {
        this.idSede = idSede;
    }

    @XmlTransient
    public Collection<TTagsCorsi> getTTagsCorsiCollection() {
        return tTagsCorsiCollection;
    }

    public void setTTagsCorsiCollection(Collection<TTagsCorsi> tTagsCorsiCollection) {
        this.tTagsCorsiCollection = tTagsCorsiCollection;
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
        hash += (idCorso != null ? idCorso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TCorsi)) {
            return false;
        }
        TCorsi other = (TCorsi) object;
        if ((this.idCorso == null && other.idCorso != null) || (this.idCorso != null && !this.idCorso.equals(other.idCorso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.ciacformazione.nostalciac.auto.TCorsi[ idCorso=" + idCorso + " ]";
    }
    
}
