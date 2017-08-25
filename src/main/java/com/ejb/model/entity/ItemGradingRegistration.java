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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "item_grading_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemGradingRegistration.findAll", query = "SELECT i FROM ItemGradingRegistration i")
    , @NamedQuery(name = "ItemGradingRegistration.findById", query = "SELECT i FROM ItemGradingRegistration i WHERE i.id = :id")
    , @NamedQuery(name = "ItemGradingRegistration.findBySampleQty", query = "SELECT i FROM ItemGradingRegistration i WHERE i.sampleQty = :sampleQty")})
public class ItemGradingRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sample_qty")
    private Double sampleQty;
    @JoinColumn(name = "grade_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GradeCategory gradeCategoryId;
    @JoinColumn(name = "grade_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GradeType gradeTypeId;
    @JoinColumn(name = "item_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMaster itemMasterId;
    @JoinColumn(name = "package_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PackageType packageTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemGradingRegistrationId")
    private Collection<ItemGrading> itemGradingCollection;

    public ItemGradingRegistration() {
    }

    public ItemGradingRegistration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSampleQty() {
        return sampleQty;
    }

    public void setSampleQty(Double sampleQty) {
        this.sampleQty = sampleQty;
    }

    public GradeCategory getGradeCategoryId() {
        return gradeCategoryId;
    }

    public void setGradeCategoryId(GradeCategory gradeCategoryId) {
        this.gradeCategoryId = gradeCategoryId;
    }

    public GradeType getGradeTypeId() {
        return gradeTypeId;
    }

    public void setGradeTypeId(GradeType gradeTypeId) {
        this.gradeTypeId = gradeTypeId;
    }

    public ItemMaster getItemMasterId() {
        return itemMasterId;
    }

    public void setItemMasterId(ItemMaster itemMasterId) {
        this.itemMasterId = itemMasterId;
    }

    public PackageType getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(PackageType packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    @XmlTransient
    public Collection<ItemGrading> getItemGradingCollection() {
        return itemGradingCollection;
    }

    public void setItemGradingCollection(Collection<ItemGrading> itemGradingCollection) {
        this.itemGradingCollection = itemGradingCollection;
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
        if (!(object instanceof ItemGradingRegistration)) {
            return false;
        }
        ItemGradingRegistration other = (ItemGradingRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ItemGradingRegistration[ id=" + id + " ]";
    }
    
}
