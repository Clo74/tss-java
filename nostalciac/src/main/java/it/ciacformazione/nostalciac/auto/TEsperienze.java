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
@Table(name = "t_esperienze")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TEsperienze.findAll", query = "SELECT t FROM TEsperienze t")
    , @NamedQuery(name = "TEsperienze.findByIdEsperienza", query = "SELECT t FROM TEsperienze t WHERE t.idEsperienza = :idEsperienza")
    , @NamedQuery(name = "TEsperienze.findByEsperienza", query = "SELECT t FROM TEsperienze t WHERE t.esperienza = :esperienza")
    , @NamedQuery(name = "TEsperienze.findByNoteEsperienza", query = "SELECT t FROM TEsperienze t WHERE t.noteEsperienza = :noteEsperienza")
    , @NamedQuery(name = "TEsperienze.findByLuogo", query = "SELECT t FROM TEsperienze t WHERE t.luogo = :luogo")
    , @NamedQuery(name = "TEsperienze.findByStato", query = "SELECT t FROM TEsperienze t WHERE t.stato = :stato")
    , @NamedQuery(name = "TEsperienze.findByDataInizioEsperienza", query = "SELECT t FROM TEsperienze t WHERE t.dataInizioEsperienza = :dataInizioEsperienza")
    , @NamedQuery(name = "TEsperienze.findByDataFineEsperienza", query = "SELECT t FROM TEsperienze t WHERE t.dataFineEsperienza = :dataFineEsperienza")})
public class TEsperienze implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_esperienza")
    private Integer idEsperienza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "esperienza")
    private String esperienza;
    @Size(max = 5000)
    @Column(name = "note_esperienza")
    private String noteEsperienza;
    @Size(max = 100)
    @Column(name = "luogo")
    private String luogo;
    @Size(max = 45)
    @Column(name = "stato")
    private String stato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inizio_esperienza")
    @Temporal(TemporalType.DATE)
    private Date dataInizioEsperienza;
    @Column(name = "data_fine_esperienza")
    @Temporal(TemporalType.DATE)
    private Date dataFineEsperienza;
    @JoinColumn(name = "id_anagrafica", referencedColumnName = "id_anagrafica")
    @ManyToOne(optional = false)
    private TAnagrafiche idAnagrafica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEsperienza")
    private Collection<TTagsEsperienze> tTagsEsperienzeCollection;

    public TEsperienze() {
    }

    public TEsperienze(Integer idEsperienza) {
        this.idEsperienza = idEsperienza;
    }

    public TEsperienze(Integer idEsperienza, String esperienza, Date dataInizioEsperienza) {
        this.idEsperienza = idEsperienza;
        this.esperienza = esperienza;
        this.dataInizioEsperienza = dataInizioEsperienza;
    }

    public Integer getIdEsperienza() {
        return idEsperienza;
    }

    public void setIdEsperienza(Integer idEsperienza) {
        this.idEsperienza = idEsperienza;
    }

    public String getEsperienza() {
        return esperienza;
    }

    public void setEsperienza(String esperienza) {
        this.esperienza = esperienza;
    }

    public String getNoteEsperienza() {
        return noteEsperienza;
    }

    public void setNoteEsperienza(String noteEsperienza) {
        this.noteEsperienza = noteEsperienza;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Date getDataInizioEsperienza() {
        return dataInizioEsperienza;
    }

    public void setDataInizioEsperienza(Date dataInizioEsperienza) {
        this.dataInizioEsperienza = dataInizioEsperienza;
    }

    public Date getDataFineEsperienza() {
        return dataFineEsperienza;
    }

    public void setDataFineEsperienza(Date dataFineEsperienza) {
        this.dataFineEsperienza = dataFineEsperienza;
    }

    public TAnagrafiche getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(TAnagrafiche idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    @XmlTransient
    public Collection<TTagsEsperienze> getTTagsEsperienzeCollection() {
        return tTagsEsperienzeCollection;
    }

    public void setTTagsEsperienzeCollection(Collection<TTagsEsperienze> tTagsEsperienzeCollection) {
        this.tTagsEsperienzeCollection = tTagsEsperienzeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEsperienza != null ? idEsperienza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TEsperienze)) {
            return false;
        }
        TEsperienze other = (TEsperienze) object;
        if ((this.idEsperienza == null && other.idEsperienza != null) || (this.idEsperienza != null && !this.idEsperienza.equals(other.idEsperienza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.ciacformazione.nostalciac.auto.TEsperienze[ idEsperienza=" + idEsperienza + " ]";
    }
    
}
