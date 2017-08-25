/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "cheque_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChequeDetails.findAll", query = "SELECT c FROM ChequeDetails c")
    , @NamedQuery(name = "ChequeDetails.findById", query = "SELECT c FROM ChequeDetails c WHERE c.id = :id")
    , @NamedQuery(name = "ChequeDetails.findByReference", query = "SELECT c FROM ChequeDetails c WHERE c.reference = :reference")
    , @NamedQuery(name = "ChequeDetails.findByChequeNo", query = "SELECT c FROM ChequeDetails c WHERE c.chequeNo = :chequeNo")
    , @NamedQuery(name = "ChequeDetails.findByChequeDate", query = "SELECT c FROM ChequeDetails c WHERE c.chequeDate = :chequeDate")
    , @NamedQuery(name = "ChequeDetails.findByIsDeposited", query = "SELECT c FROM ChequeDetails c WHERE c.isDeposited = :isDeposited")
    , @NamedQuery(name = "ChequeDetails.findByChequeAmount", query = "SELECT c FROM ChequeDetails c WHERE c.chequeAmount = :chequeAmount")})
public class ChequeDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Size(max = 45)
    @Column(name = "cheque_no")
    private String chequeNo;
    @Column(name = "cheque_date")
    @Temporal(TemporalType.DATE)
    private Date chequeDate;
    @Column(name = "is_deposited")
    private Integer isDeposited;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cheque_amount")
    private Double chequeAmount;
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bank bankId;
    @JoinColumn(name = "cheque_detail_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChequeDetailsType chequeDetailTypeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chequeDetailsId")
    private Collection<ChequeConditionController> chequeConditionControllerCollection;

    public ChequeDetails() {
    }

    public ChequeDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public Integer getIsDeposited() {
        return isDeposited;
    }

    public void setIsDeposited(Integer isDeposited) {
        this.isDeposited = isDeposited;
    }

    public Double getChequeAmount() {
        return chequeAmount;
    }

    public void setChequeAmount(Double chequeAmount) {
        this.chequeAmount = chequeAmount;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public ChequeDetailsType getChequeDetailTypeId() {
        return chequeDetailTypeId;
    }

    public void setChequeDetailTypeId(ChequeDetailsType chequeDetailTypeId) {
        this.chequeDetailTypeId = chequeDetailTypeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
    }

    @XmlTransient
    public Collection<ChequeConditionController> getChequeConditionControllerCollection() {
        return chequeConditionControllerCollection;
    }

    public void setChequeConditionControllerCollection(Collection<ChequeConditionController> chequeConditionControllerCollection) {
        this.chequeConditionControllerCollection = chequeConditionControllerCollection;
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
        if (!(object instanceof ChequeDetails)) {
            return false;
        }
        ChequeDetails other = (ChequeDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ChequeDetails[ id=" + id + " ]";
    }
    
}
