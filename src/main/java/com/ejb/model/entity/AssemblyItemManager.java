/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "assembly_item_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssemblyItemManager.findAll", query = "SELECT a FROM AssemblyItemManager a")
    , @NamedQuery(name = "AssemblyItemManager.findById", query = "SELECT a FROM AssemblyItemManager a WHERE a.id = :id")
    , @NamedQuery(name = "AssemblyItemManager.findByQty", query = "SELECT a FROM AssemblyItemManager a WHERE a.qty = :qty")
    , @NamedQuery(name = "AssemblyItemManager.findByCost", query = "SELECT a FROM AssemblyItemManager a WHERE a.cost = :cost")
    , @NamedQuery(name = "AssemblyItemManager.findByStandardMinQty", query = "SELECT a FROM AssemblyItemManager a WHERE a.standardMinQty = :standardMinQty")})
public class AssemblyItemManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "standard_min_qty")
    private Double standardMinQty;
    @OneToMany(mappedBy = "assemblyItemManagerId")
    private Collection<AssemblyItemManager> assemblyItemManagerCollection;
    @JoinColumn(name = "assembly_item_manager_id", referencedColumnName = "id")
    @ManyToOne
    private AssemblyItemManager assemblyItemManagerId;
    @JoinColumn(name = "item_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemCategory itemCategoryId;
    @JoinColumn(name = "org_item_row_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemRowId;
    @JoinColumn(name = "org_item_finisched_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemFinischedId;
    @JoinColumn(name = "unit_of_measure_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnitOfMeasure unitOfMeasureId;

    public AssemblyItemManager() {
    }

    public AssemblyItemManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getStandardMinQty() {
        return standardMinQty;
    }

    public void setStandardMinQty(Double standardMinQty) {
        this.standardMinQty = standardMinQty;
    }

    @XmlTransient
    public Collection<AssemblyItemManager> getAssemblyItemManagerCollection() {
        return assemblyItemManagerCollection;
    }

    public void setAssemblyItemManagerCollection(Collection<AssemblyItemManager> assemblyItemManagerCollection) {
        this.assemblyItemManagerCollection = assemblyItemManagerCollection;
    }

    public AssemblyItemManager getAssemblyItemManagerId() {
        return assemblyItemManagerId;
    }

    public void setAssemblyItemManagerId(AssemblyItemManager assemblyItemManagerId) {
        this.assemblyItemManagerId = assemblyItemManagerId;
    }

    public ItemCategory getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(ItemCategory itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public OrgItem getOrgItemRowId() {
        return orgItemRowId;
    }

    public void setOrgItemRowId(OrgItem orgItemRowId) {
        this.orgItemRowId = orgItemRowId;
    }

    public OrgItem getOrgItemFinischedId() {
        return orgItemFinischedId;
    }

    public void setOrgItemFinischedId(OrgItem orgItemFinischedId) {
        this.orgItemFinischedId = orgItemFinischedId;
    }

    public UnitOfMeasure getUnitOfMeasureId() {
        return unitOfMeasureId;
    }

    public void setUnitOfMeasureId(UnitOfMeasure unitOfMeasureId) {
        this.unitOfMeasureId = unitOfMeasureId;
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
        if (!(object instanceof AssemblyItemManager)) {
            return false;
        }
        AssemblyItemManager other = (AssemblyItemManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.AssemblyItemManager[ id=" + id + " ]";
    }
    
}
