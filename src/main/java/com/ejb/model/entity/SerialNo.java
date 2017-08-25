/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "serial_no")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SerialNo.findAll", query = "SELECT s FROM SerialNo s")
    , @NamedQuery(name = "SerialNo.findById", query = "SELECT s FROM SerialNo s WHERE s.id = :id")
    , @NamedQuery(name = "SerialNo.findByNo", query = "SELECT s FROM SerialNo s WHERE s.no = :no")
    , @NamedQuery(name = "SerialNo.findByDate", query = "SELECT s FROM SerialNo s WHERE s.date = :date")
    , @NamedQuery(name = "SerialNo.findByIsQualityAssured", query = "SELECT s FROM SerialNo s WHERE s.isQualityAssured = :isQualityAssured")})
public class SerialNo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "no")
    private String no;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "is_quality_assured")
    private Integer isQualityAssured;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "product_batch_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductBatchManager productBatchManagerId;
    @JoinColumn(name = "production_line_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductionLine productionLineId;

    public SerialNo() {
    }

    public SerialNo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIsQualityAssured() {
        return isQualityAssured;
    }

    public void setIsQualityAssured(Integer isQualityAssured) {
        this.isQualityAssured = isQualityAssured;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public ProductBatchManager getProductBatchManagerId() {
        return productBatchManagerId;
    }

    public void setProductBatchManagerId(ProductBatchManager productBatchManagerId) {
        this.productBatchManagerId = productBatchManagerId;
    }

    public ProductionLine getProductionLineId() {
        return productionLineId;
    }

    public void setProductionLineId(ProductionLine productionLineId) {
        this.productionLineId = productionLineId;
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
        if (!(object instanceof SerialNo)) {
            return false;
        }
        SerialNo other = (SerialNo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SerialNo[ id=" + id + " ]";
    }
    
}
