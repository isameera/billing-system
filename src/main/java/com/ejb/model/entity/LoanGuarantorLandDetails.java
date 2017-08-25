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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "loan_guarantor_land_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoanGuarantorLandDetails.findAll", query = "SELECT l FROM LoanGuarantorLandDetails l")
    , @NamedQuery(name = "LoanGuarantorLandDetails.findById", query = "SELECT l FROM LoanGuarantorLandDetails l WHERE l.id = :id")
    , @NamedQuery(name = "LoanGuarantorLandDetails.findByComment", query = "SELECT l FROM LoanGuarantorLandDetails l WHERE l.comment = :comment")})
public class LoanGuarantorLandDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "gurantor_loan_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GurantorLoanManager gurantorLoanManagerId;
    @JoinColumn(name = "property_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PropertyMaster propertyMasterId;

    public LoanGuarantorLandDetails() {
    }

    public LoanGuarantorLandDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GurantorLoanManager getGurantorLoanManagerId() {
        return gurantorLoanManagerId;
    }

    public void setGurantorLoanManagerId(GurantorLoanManager gurantorLoanManagerId) {
        this.gurantorLoanManagerId = gurantorLoanManagerId;
    }

    public PropertyMaster getPropertyMasterId() {
        return propertyMasterId;
    }

    public void setPropertyMasterId(PropertyMaster propertyMasterId) {
        this.propertyMasterId = propertyMasterId;
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
        if (!(object instanceof LoanGuarantorLandDetails)) {
            return false;
        }
        LoanGuarantorLandDetails other = (LoanGuarantorLandDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LoanGuarantorLandDetails[ id=" + id + " ]";
    }
    
}
