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
@Table(name = "factory_collected_leaf_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactoryCollectedLeafStatus.findAll", query = "SELECT f FROM FactoryCollectedLeafStatus f")
    , @NamedQuery(name = "FactoryCollectedLeafStatus.findById", query = "SELECT f FROM FactoryCollectedLeafStatus f WHERE f.id = :id")
    , @NamedQuery(name = "FactoryCollectedLeafStatus.findByName", query = "SELECT f FROM FactoryCollectedLeafStatus f WHERE f.name = :name")})
public class FactoryCollectedLeafStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factoryCollectedLeafStatusId")
    private Collection<FactoryCollectedLeafConfirmation> factoryCollectedLeafConfirmationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectedLeafConfirmationStatusId")
    private Collection<FactoryCollectedLeaf> factoryCollectedLeafCollection;

    public FactoryCollectedLeafStatus() {
    }

    public FactoryCollectedLeafStatus(Integer id) {
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
    public Collection<FactoryCollectedLeafConfirmation> getFactoryCollectedLeafConfirmationCollection() {
        return factoryCollectedLeafConfirmationCollection;
    }

    public void setFactoryCollectedLeafConfirmationCollection(Collection<FactoryCollectedLeafConfirmation> factoryCollectedLeafConfirmationCollection) {
        this.factoryCollectedLeafConfirmationCollection = factoryCollectedLeafConfirmationCollection;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeaf> getFactoryCollectedLeafCollection() {
        return factoryCollectedLeafCollection;
    }

    public void setFactoryCollectedLeafCollection(Collection<FactoryCollectedLeaf> factoryCollectedLeafCollection) {
        this.factoryCollectedLeafCollection = factoryCollectedLeafCollection;
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
        if (!(object instanceof FactoryCollectedLeafStatus)) {
            return false;
        }
        FactoryCollectedLeafStatus other = (FactoryCollectedLeafStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.FactoryCollectedLeafStatus[ id=" + id + " ]";
    }
    
}
