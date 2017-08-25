/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

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
 * @author Sameera
 */
@Entity
@Table(name = "org_item_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgItemLocation.findAll", query = "SELECT o FROM OrgItemLocation o")
    , @NamedQuery(name = "OrgItemLocation.findById", query = "SELECT o FROM OrgItemLocation o WHERE o.id = :id")})
public class OrgItemLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @JoinColumn(name = "org_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgLocation orgLocationId;

    public OrgItemLocation() {
    }

    public OrgItemLocation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    public OrgLocation getOrgLocationId() {
        return orgLocationId;
    }

    public void setOrgLocationId(OrgLocation orgLocationId) {
        this.orgLocationId = orgLocationId;
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
        if (!(object instanceof OrgItemLocation)) {
            return false;
        }
        OrgItemLocation other = (OrgItemLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgItemLocation[ id=" + id + " ]";
    }
    
}
