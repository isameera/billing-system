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
@Table(name = "property_crop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PropertyCrop.findAll", query = "SELECT p FROM PropertyCrop p")
    , @NamedQuery(name = "PropertyCrop.findById", query = "SELECT p FROM PropertyCrop p WHERE p.id = :id")
    , @NamedQuery(name = "PropertyCrop.findByLandAreaUnderCrop", query = "SELECT p FROM PropertyCrop p WHERE p.landAreaUnderCrop = :landAreaUnderCrop")
    , @NamedQuery(name = "PropertyCrop.findByAvgCropMonth", query = "SELECT p FROM PropertyCrop p WHERE p.avgCropMonth = :avgCropMonth")
    , @NamedQuery(name = "PropertyCrop.findBySuppliedQty", query = "SELECT p FROM PropertyCrop p WHERE p.suppliedQty = :suppliedQty")})
public class PropertyCrop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "land_area_under_crop")
    private Double landAreaUnderCrop;
    @Column(name = "avg_crop_month")
    private Double avgCropMonth;
    @Column(name = "supplied_qty")
    private Double suppliedQty;
    @JoinColumn(name = "property_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyMaster propertyMasterId;
    @JoinColumn(name = "crop_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CropType cropTypeId;

    public PropertyCrop() {
    }

    public PropertyCrop(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLandAreaUnderCrop() {
        return landAreaUnderCrop;
    }

    public void setLandAreaUnderCrop(Double landAreaUnderCrop) {
        this.landAreaUnderCrop = landAreaUnderCrop;
    }

    public Double getAvgCropMonth() {
        return avgCropMonth;
    }

    public void setAvgCropMonth(Double avgCropMonth) {
        this.avgCropMonth = avgCropMonth;
    }

    public Double getSuppliedQty() {
        return suppliedQty;
    }

    public void setSuppliedQty(Double suppliedQty) {
        this.suppliedQty = suppliedQty;
    }

    public PropertyMaster getPropertyMasterId() {
        return propertyMasterId;
    }

    public void setPropertyMasterId(PropertyMaster propertyMasterId) {
        this.propertyMasterId = propertyMasterId;
    }

    public CropType getCropTypeId() {
        return cropTypeId;
    }

    public void setCropTypeId(CropType cropTypeId) {
        this.cropTypeId = cropTypeId;
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
        if (!(object instanceof PropertyCrop)) {
            return false;
        }
        PropertyCrop other = (PropertyCrop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.PropertyCrop[ id=" + id + " ]";
    }

}
