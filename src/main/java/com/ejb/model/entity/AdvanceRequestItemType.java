/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "advance_request_item_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvanceRequestItemType.findAll", query = "SELECT a FROM AdvanceRequestItemType a")
    , @NamedQuery(name = "AdvanceRequestItemType.findById", query = "SELECT a FROM AdvanceRequestItemType a WHERE a.id = :id")
    , @NamedQuery(name = "AdvanceRequestItemType.findByName", query = "SELECT a FROM AdvanceRequestItemType a WHERE a.name = :name")})
public class AdvanceRequestItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advanceRequestItemTypeId")
    private Collection<AdvanceRequestItem> advanceRequestItemCollection;

    public AdvanceRequestItemType() {
    }

    public AdvanceRequestItemType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<AdvanceRequestItem> getAdvanceRequestItemCollection() {
        return advanceRequestItemCollection;
    }

    public void setAdvanceRequestItemCollection(Collection<AdvanceRequestItem> advanceRequestItemCollection) {
        this.advanceRequestItemCollection = advanceRequestItemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdvanceRequestItemType)) {
            return false;
        }
        AdvanceRequestItemType other = (AdvanceRequestItemType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AdvanceRequestItemType[ id=" + id + " ]";
    }
    
}
