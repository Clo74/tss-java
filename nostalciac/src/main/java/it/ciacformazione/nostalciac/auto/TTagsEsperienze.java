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
@Table(name = "t_tags_esperienze")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TTagsEsperienze.findAll", query = "SELECT t FROM TTagsEsperienze t")
    , @NamedQuery(name = "TTagsEsperienze.findByIdTagEsperienza", query = "SELECT t FROM TTagsEsperienze t WHERE t.idTagEsperienza = :idTagEsperienza")})
public class TTagsEsperienze implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tag_esperienza")
    private Integer idTagEsperienza;
    @JoinColumn(name = "id_esperienza", referencedColumnName = "id_esperienza")
    @ManyToOne(optional = false)
    private TEsperienze idEsperienza;
    @JoinColumn(name = "id_tag", referencedColumnName = "id_tag")
    @ManyToOne(optional = false)
    private Tag idTag;

    public TTagsEsperienze() {
    }

    public TTagsEsperienze(Integer idTagEsperienza) {
        this.idTagEsperienza = idTagEsperienza;
    }

    public Integer getIdTagEsperienza() {
        return idTagEsperienza;
    }

    public void setIdTagEsperienza(Integer idTagEsperienza) {
        this.idTagEsperienza = idTagEsperienza;
    }

    public TEsperienze getIdEsperienza() {
        return idEsperienza;
    }

    public void setIdEsperienza(TEsperienze idEsperienza) {
        this.idEsperienza = idEsperienza;
    }

    public Tag getIdTag() {
        return idTag;
    }

    public void setIdTag(Tag idTag) {
        this.idTag = idTag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTagEsperienza != null ? idTagEsperienza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TTagsEsperienze)) {
            return false;
        }
        TTagsEsperienze other = (TTagsEsperienze) object;
        if ((this.idTagEsperienza == null && other.idTagEsperienza != null) || (this.idTagEsperienza != null && !this.idTagEsperienza.equals(other.idTagEsperienza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.ciacformazione.nostalciac.auto.TTagsEsperienze[ idTagEsperienza=" + idTagEsperienza + " ]";
    }
    
}
