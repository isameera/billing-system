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
@Table(name = "universal_boughtleaf_item_delivery_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalBoughtleafItemDeliveryDetails.findAll", query = "SELECT u FROM UniversalBoughtleafItemDeliveryDetails u")
    , @NamedQuery(name = "UniversalBoughtleafItemDeliveryDetails.findById", query = "SELECT u FROM UniversalBoughtleafItemDeliveryDetails u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalBoughtleafItemDeliveryDetails.findByReferenceNo", query = "SELECT u FROM UniversalBoughtleafItemDeliveryDetails u WHERE u.referenceNo = :referenceNo")
    , @NamedQuery(name = "UniversalBoughtleafItemDeliveryDetails.findByConfermationLetter", query = "SELECT u FROM UniversalBoughtleafItemDeliveryDetails u WHERE u.confermationLetter = :confermationLetter")
    , @NamedQuery(name = "UniversalBoughtleafItemDeliveryDetails.findByDeliveryDate", query = "SELECT u FROM UniversalBoughtleafItemDeliveryDetails u WHERE u.deliveryDate = :deliveryDate")
    , @NamedQuery(name = "UniversalBoughtleafItemDeliveryDetails.findByVerifiedDocImg", query = "SELECT u FROM UniversalBoughtleafItemDeliveryDetails u WHERE u.verifiedDocImg = :verifiedDocImg")
    , @NamedQuery(name = "UniversalBoughtleafItemDeliveryDetails.findByVerifiedDate", query = "SELECT u FROM UniversalBoughtleafItemDeliveryDetails u WHERE u.verifiedDate = :verifiedDate")})
public class UniversalBoughtleafItemDeliveryDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference_no")
    private Integer referenceNo;
    @Size(max = 45)
    @Column(name = "confermation_letter")
    private String confermationLetter;
    @Column(name = "delivery_date")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Size(max = 45)
    @Column(name = "verified_doc_img")
    private String verifiedDocImg;
    @Column(name = "verified_date")
    @Temporal(TemporalType.DATE)
    private Date verifiedDate;
    @JoinColumn(name = "universal_tea_item_issue_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalBoughtleafItemIssue universalTeaItemIssueId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public UniversalBoughtleafItemDeliveryDetails() {
    }

    public UniversalBoughtleafItemDeliveryDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(Integer referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getConfermationLetter() {
        return confermationLetter;
    }

    public void setConfermationLetter(String confermationLetter) {
        this.confermationLetter = confermationLetter;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getVerifiedDocImg() {
        return verifiedDocImg;
    }

    public void setVerifiedDocImg(String verifiedDocImg) {
        this.verifiedDocImg = verifiedDocImg;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public UniversalBoughtleafItemIssue getUniversalTeaItemIssueId() {
        return universalTeaItemIssueId;
    }

    public void setUniversalTeaItemIssueId(UniversalBoughtleafItemIssue universalTeaItemIssueId) {
        this.universalTeaItemIssueId = universalTeaItemIssueId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof UniversalBoughtleafItemDeliveryDetails)) {
            return false;
        }
        UniversalBoughtleafItemDeliveryDetails other = (UniversalBoughtleafItemDeliveryDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalBoughtleafItemDeliveryDetails[ id=" + id + " ]";
    }
    
}
