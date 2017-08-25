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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "org_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgCategory.findAll", query = "SELECT o FROM OrgCategory o")
    , @NamedQuery(name = "OrgCategory.findById", query = "SELECT o FROM OrgCategory o WHERE o.id = :id")
    , @NamedQuery(name = "OrgCategory.findByName", query = "SELECT o FROM OrgCategory o WHERE o.name = :name")})
public class OrgCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "orgCategoryId")
    private Collection<OrgCategory> orgCategoryCollection;
    @JoinColumn(name = "org_category_id", referencedColumnName = "id")
    @ManyToOne
    private OrgCategory orgCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orgCategoryId")
    private Collection<OrgCategoryManager> orgCategoryManagerCollection;

    public OrgCategory() {
    }

    public OrgCategory(Integer id) {
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
    public Collection<OrgCategory> getOrgCategoryCollection() {
        return orgCategoryCollection;
    }

    public void setOrgCategoryCollection(Collection<OrgCategory> orgCategoryCollection) {
        this.orgCategoryCollection = orgCategoryCollection;
    }

    public OrgCategory getOrgCategoryId() {
        return orgCategoryId;
    }

    public void setOrgCategoryId(OrgCategory orgCategoryId) {
        this.orgCategoryId = orgCategoryId;
    }

    @XmlTransient
    public Collection<OrgCategoryManager> getOrgCategoryManagerCollection() {
        return orgCategoryManagerCollection;
    }

    public void setOrgCategoryManagerCollection(Collection<OrgCategoryManager> orgCategoryManagerCollection) {
        this.orgCategoryManagerCollection = orgCategoryManagerCollection;
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
        if (!(object instanceof OrgCategory)) {
            return false;
        }
        OrgCategory other = (OrgCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgCategory[ id=" + id + " ]";
    }
    
}
