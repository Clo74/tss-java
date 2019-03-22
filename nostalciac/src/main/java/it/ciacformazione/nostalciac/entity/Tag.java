/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.nostalciac.entity;

import it.ciacformazione.nostalciac.auto.TTagsCorsi;
import it.ciacformazione.nostalciac.auto.TTagsEsperienze;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tss
 */
@Entity
@Table(name = "t_tags")
public class Tag implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTag")
    private Collection<TTagsCorsi> tTagsCorsiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTag")
    private Collection<TTagsEsperienze> tTagsEsperienzeCollection;
    @Id
    @Column(name = "id_tag")
    private int id;
    @Column(name = "tag",nullable = false, length = 50)
    private String tag;
    @Column(name = "tipo")
    private String tipo;
    
    public Tag() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tag other = (Tag) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tag{" + "id=" + id + ", tag=" + tag + ", tipo=" + tipo + '}';
    }

    @XmlTransient
    public Collection<TTagsCorsi> getTTagsCorsiCollection() {
        return tTagsCorsiCollection;
    }

    public void setTTagsCorsiCollection(Collection<TTagsCorsi> tTagsCorsiCollection) {
        this.tTagsCorsiCollection = tTagsCorsiCollection;
    }

    @XmlTransient
    public Collection<TTagsEsperienze> getTTagsEsperienzeCollection() {
        return tTagsEsperienzeCollection;
    }

    public void setTTagsEsperienzeCollection(Collection<TTagsEsperienze> tTagsEsperienzeCollection) {
        this.tTagsEsperienzeCollection = tTagsEsperienzeCollection;
    }
    
    
}
