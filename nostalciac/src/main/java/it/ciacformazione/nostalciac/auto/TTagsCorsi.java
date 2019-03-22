/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.auto;

import it.ciacformazione.nostalciac.entity.Tag;
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
@Table(name = "t_tags_corsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTagsCorsi.findAll", query = "SELECT t FROM TTagsCorsi t")
    , @NamedQuery(name = "TTagsCorsi.findByIdTagCorso", query = "SELECT t FROM TTagsCorsi t WHERE t.idTagCorso = :idTagCorso")})
public class TTagsCorsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tag_corso")
    private Integer idTagCorso;
    @JoinColumn(name = "id_tag", referencedColumnName = "id_tag")
    @ManyToOne(optional = false)
    private Tag idTag;
    @JoinColumn(name = "id_corso", referencedColumnName = "id_corso")
    @ManyToOne(optional = false)
    private TCorsi idCorso;

    public TTagsCorsi() {
    }

    public TTagsCorsi(Integer idTagCorso) {
        this.idTagCorso = idTagCorso;
    }

    public Integer getIdTagCorso() {
        return idTagCorso;
    }

    public void setIdTagCorso(Integer idTagCorso) {
        this.idTagCorso = idTagCorso;
    }

    public Tag getIdTag() {
        return idTag;
    }

    public void setIdTag(Tag idTag) {
        this.idTag = idTag;
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
        hash += (idTagCorso != null ? idTagCorso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTagsCorsi)) {
            return false;
        }
        TTagsCorsi other = (TTagsCorsi) object;
        if ((this.idTagCorso == null && other.idTagCorso != null) || (this.idTagCorso != null && !this.idTagCorso.equals(other.idTagCorso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.ciacformazione.nostalciac.auto.TTagsCorsi[ idTagCorso=" + idTagCorso + " ]";
    }
    
}
