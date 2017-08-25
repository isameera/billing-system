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
@Table(name = "universal_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalStatus.findAll", query = "SELECT u FROM UniversalStatus u")
    , @NamedQuery(name = "UniversalStatus.findById", query = "SELECT u FROM UniversalStatus u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalStatus.findByName", query = "SELECT u FROM UniversalStatus u WHERE u.name = :name")})
public class UniversalStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalStatusId")
    private Collection<UniversalStatusManager> universalStatusManagerCollection;

    public UniversalStatus() {
    }

    public UniversalStatus(Integer id) {
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
    public Collection<UniversalStatusManager> getUniversalStatusManagerCollection() {
        return universalStatusManagerCollection;
    }

    public void setUniversalStatusManagerCollection(Collection<UniversalStatusManager> universalStatusManagerCollection) {
        this.universalStatusManagerCollection = universalStatusManagerCollection;
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
        if (!(object instanceof UniversalStatus)) {
            return false;
        }
        UniversalStatus other = (UniversalStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalStatus[ id=" + id + " ]";
    }
    
}
