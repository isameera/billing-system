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
@Table(name = "unit_of_measure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnitOfMeasure.findAll", query = "SELECT u FROM UnitOfMeasure u")
    , @NamedQuery(name = "UnitOfMeasure.findById", query = "SELECT u FROM UnitOfMeasure u WHERE u.id = :id")
    , @NamedQuery(name = "UnitOfMeasure.findByName", query = "SELECT u FROM UnitOfMeasure u WHERE u.name = :name")
    , @NamedQuery(name = "UnitOfMeasure.findByAbbreviation", query = "SELECT u FROM UnitOfMeasure u WHERE u.abbreviation = :abbreviation")})
public class UnitOfMeasure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 150)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "abbreviation")
    private String abbreviation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitOfMeasureId")
    private Collection<ItemMaster> itemMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitOfMeasureId")
    private Collection<ItemUomPrice> itemUomPriceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitOfMeasureId")
    private Collection<OrgUnitOfMeasure> orgUnitOfMeasureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitOfMeasureId")
    private Collection<AssemblyItemManager> assemblyItemManagerCollection;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(Integer id) {
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @XmlTransient
    public Collection<ItemMaster> getItemMasterCollection() {
        return itemMasterCollection;
    }

    public void setItemMasterCollection(Collection<ItemMaster> itemMasterCollection) {
        this.itemMasterCollection = itemMasterCollection;
    }

    @XmlTransient
    public Collection<ItemUomPrice> getItemUomPriceCollection() {
        return itemUomPriceCollection;
    }

    public void setItemUomPriceCollection(Collection<ItemUomPrice> itemUomPriceCollection) {
        this.itemUomPriceCollection = itemUomPriceCollection;
    }

    @XmlTransient
    public Collection<OrgUnitOfMeasure> getOrgUnitOfMeasureCollection() {
        return orgUnitOfMeasureCollection;
    }

    public void setOrgUnitOfMeasureCollection(Collection<OrgUnitOfMeasure> orgUnitOfMeasureCollection) {
        this.orgUnitOfMeasureCollection = orgUnitOfMeasureCollection;
    }

    @XmlTransient
    public Collection<AssemblyItemManager> getAssemblyItemManagerCollection() {
        return assemblyItemManagerCollection;
    }

    public void setAssemblyItemManagerCollection(Collection<AssemblyItemManager> assemblyItemManagerCollection) {
        this.assemblyItemManagerCollection = assemblyItemManagerCollection;
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
        if (!(object instanceof UnitOfMeasure)) {
            return false;
        }
        UnitOfMeasure other = (UnitOfMeasure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UnitOfMeasure[ id=" + id + " ]";
    }
    
}
