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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "construction_site_clients_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionSiteClientsType.findAll", query = "SELECT c FROM ConstructionSiteClientsType c")
    , @NamedQuery(name = "ConstructionSiteClientsType.findById", query = "SELECT c FROM ConstructionSiteClientsType c WHERE c.id = :id")
    , @NamedQuery(name = "ConstructionSiteClientsType.findByName", query = "SELECT c FROM ConstructionSiteClientsType c WHERE c.name = :name")})
public class ConstructionSiteClientsType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constructionSiteClientsTypeId")
    private Collection<ConstructionSiteClients> constructionSiteClientsCollection;

    public ConstructionSiteClientsType() {
    }

    public ConstructionSiteClientsType(Integer id) {
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
    public Collection<ConstructionSiteClients> getConstructionSiteClientsCollection() {
        return constructionSiteClientsCollection;
    }

    public void setConstructionSiteClientsCollection(Collection<ConstructionSiteClients> constructionSiteClientsCollection) {
        this.constructionSiteClientsCollection = constructionSiteClientsCollection;
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
        if (!(object instanceof ConstructionSiteClientsType)) {
            return false;
        }
        ConstructionSiteClientsType other = (ConstructionSiteClientsType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionSiteClientsType[ id=" + id + " ]";
    }
    
}
