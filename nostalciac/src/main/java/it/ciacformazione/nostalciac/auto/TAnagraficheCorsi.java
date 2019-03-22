/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.auto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_anagrafiche_corsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TAnagraficheCorsi.findAll", query = "SELECT t FROM TAnagraficheCorsi t")
    , @NamedQuery(name = "TAnagraficheCorsi.findByIdAnagraficaCorso", query = "SELECT t FROM TAnagraficheCorsi t WHERE t.idAnagraficaCorso = :idAnagraficaCorso")})
public class TAnagraficheCorsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anagrafica_corso")
    private Integer idAnagraficaCorso;
    @JoinColumn(name = "id_anagrafica", referencedColumnName = "id_anagrafica")
    @ManyToOne(optional = false)
    private TAnagrafiche idAnagrafica;
    @JoinColumn(name = "id_corso", referencedColumnName = "id_corso")
    @ManyToOne(optional = false)
    private TCorsi idCorso;

    public TAnagraficheCorsi() {
    }

    public TAnagraficheCorsi(Integer idAnagraficaCorso) {
        this.idAnagraficaCorso = idAnagraficaCorso;
    }

    public Integer getIdAnagraficaCorso() {
        return idAnagraficaCorso;
    }

    public void setIdAnagraficaCorso(Integer idAnagraficaCorso) {
        this.idAnagraficaCorso = idAnagraficaCorso;
    }

    public TAnagrafiche getIdAnagrafica() {
        return idAnagrafica;
    }

    public void setIdAnagrafica(TAnagrafiche idAnagrafica) {
        this.idAnagrafica = idAnagrafica;
    }

    public TCorsi getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(TCorsi idCorso) {
        this.idCorso = idCorso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnagraficaCorso != null ? idAnagraficaCorso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TAnagraficheCorsi)) {
            return false;
        }
        TAnagraficheCorsi other = (TAnagraficheCorsi) object;
        if ((this.idAnagraficaCorso == null && other.idAnagraficaCorso != null) || (this.idAnagraficaCorso != null && !this.idAnagraficaCorso.equals(other.idAnagraficaCorso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.ciacformazione.nostalciac.auto.TAnagraficheCorsi[ idAnagraficaCorso=" + idAnagraficaCorso + " ]";
    }
    
}
