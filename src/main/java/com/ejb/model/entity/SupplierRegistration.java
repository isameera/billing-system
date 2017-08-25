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
import javax.persistence.Lob;
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
@Table(name = "supplier_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierRegistration.findAll", query = "SELECT s FROM SupplierRegistration s")
    , @NamedQuery(name = "SupplierRegistration.findById", query = "SELECT s FROM SupplierRegistration s WHERE s.id = :id")
    , @NamedQuery(name = "SupplierRegistration.findBySupplierId", query = "SELECT s FROM SupplierRegistration s WHERE s.supplierId = :supplierId")
    , @NamedQuery(name = "SupplierRegistration.findByOldSupplierId", query = "SELECT s FROM SupplierRegistration s WHERE s.oldSupplierId = :oldSupplierId")
    , @NamedQuery(name = "SupplierRegistration.findByRegDate", query = "SELECT s FROM SupplierRegistration s WHERE s.regDate = :regDate")
    , @NamedQuery(name = "SupplierRegistration.findByDyNumber", query = "SELECT s FROM SupplierRegistration s WHERE s.dyNumber = :dyNumber")
    , @NamedQuery(name = "SupplierRegistration.findByIsBlacklisted", query = "SELECT s FROM SupplierRegistration s WHERE s.isBlacklisted = :isBlacklisted")
    , @NamedQuery(name = "SupplierRegistration.findByIsDySupplier", query = "SELECT s FROM SupplierRegistration s WHERE s.isDySupplier = :isDySupplier")
    , @NamedQuery(name = "SupplierRegistration.findByIsWelfareMember", query = "SELECT s FROM SupplierRegistration s WHERE s.isWelfareMember = :isWelfareMember")
    , @NamedQuery(name = "SupplierRegistration.findByPaymentDate", query = "SELECT s FROM SupplierRegistration s WHERE s.paymentDate = :paymentDate")
    , @NamedQuery(name = "SupplierRegistration.findByIsEmployee", query = "SELECT s FROM SupplierRegistration s WHERE s.isEmployee = :isEmployee")
    , @NamedQuery(name = "SupplierRegistration.findByIsActive", query = "SELECT s FROM SupplierRegistration s WHERE s.isActive = :isActive")
    , @NamedQuery(name = "SupplierRegistration.findByIncentivePayMode", query = "SELECT s FROM SupplierRegistration s WHERE s.incentivePayMode = :incentivePayMode")})
public class SupplierRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "supplier_id")
    private String supplierId;
    @Size(max = 45)
    @Column(name = "old_supplier_id")
    private String oldSupplierId;
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Size(max = 45)
    @Column(name = "dy_number")
    private String dyNumber;
    @Column(name = "is_blacklisted")
    private Integer isBlacklisted;
    @Column(name = "is_dy_supplier")
    private Integer isDySupplier;
    @Column(name = "is_welfare_member")
    private Integer isWelfareMember;
    @Lob
    @Size(max = 65535)
    @Column(name = "feed_back")
    private String feedBack;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column(name = "is_employee")
    private Integer isEmployee;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "incentive_pay_mode")
    private Integer incentivePayMode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierSavingsAccount> supplierSavingsAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierPaymentController> supplierPaymentControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierPaymentModeManager> supplierPaymentModeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierCollectedLeafController> supplierCollectedLeafControllerCollection;
    @OneToMany(mappedBy = "supplierRegistrationId")
    private Collection<WelfarePayments> welfarePaymentsCollection;
    @OneToMany(mappedBy = "supplierRegistrationId")
    private Collection<WelfareManager> welfareManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierTransportRate> supplierTransportRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<UniversalBoughtleafItemInstallment> universalBoughtleafItemInstallmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierVehicleMonthlyPayments> supplierVehicleMonthlyPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "existSupplier")
    private Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newSupplier")
    private Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierIncentiveFactory> supplierIncentiveFactoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierIncentive> supplierIncentiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierRoute> supplierRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierBagWeight> supplierBagWeightCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<ChildrenDetails> childrenDetailsCollection;
    @OneToMany(mappedBy = "supplierRegistrationId")
    private Collection<GatePass> gatePassCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<FamilyMemberDetails> familyMemberDetailsCollection;
    @OneToMany(mappedBy = "supplierRegistrationId")
    private Collection<WelfareCommitteeMembers> welfareCommitteeMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<UniversalBoughtleafItemController> universalBoughtleafItemControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<CooperatSupplier> cooperatSupplierCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "supplier_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierCategory supplierCategoryId;
    @JoinColumn(name = "supplier_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierType supplierTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<FactoryCollectedLeafBySupplier> factoryCollectedLeafBySupplierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<TeaSupplierPayments> teaSupplierPaymentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<DealingCompanies> dealingCompaniesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierPassbook> supplierPassbookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SuplierAreaProperty> suplierAreaPropertyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<SupplierAllowanceOrDeductionManager> supplierAllowanceOrDeductionManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierRegistrationId")
    private Collection<RouteCollectedLeaf> routeCollectedLeafCollection;

    public SupplierRegistration() {
    }

    public SupplierRegistration(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getOldSupplierId() {
        return oldSupplierId;
    }

    public void setOldSupplierId(String oldSupplierId) {
        this.oldSupplierId = oldSupplierId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getDyNumber() {
        return dyNumber;
    }

    public void setDyNumber(String dyNumber) {
        this.dyNumber = dyNumber;
    }

    public Integer getIsBlacklisted() {
        return isBlacklisted;
    }

    public void setIsBlacklisted(Integer isBlacklisted) {
        this.isBlacklisted = isBlacklisted;
    }

    public Integer getIsDySupplier() {
        return isDySupplier;
    }

    public void setIsDySupplier(Integer isDySupplier) {
        this.isDySupplier = isDySupplier;
    }

    public Integer getIsWelfareMember() {
        return isWelfareMember;
    }

    public void setIsWelfareMember(Integer isWelfareMember) {
        this.isWelfareMember = isWelfareMember;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Integer isEmployee) {
        this.isEmployee = isEmployee;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getIncentivePayMode() {
        return incentivePayMode;
    }

    public void setIncentivePayMode(Integer incentivePayMode) {
        this.incentivePayMode = incentivePayMode;
    }

    @XmlTransient
    public Collection<SupplierSavingsAccount> getSupplierSavingsAccountCollection() {
        return supplierSavingsAccountCollection;
    }

    public void setSupplierSavingsAccountCollection(Collection<SupplierSavingsAccount> supplierSavingsAccountCollection) {
        this.supplierSavingsAccountCollection = supplierSavingsAccountCollection;
    }

    @XmlTransient
    public Collection<SupplierPaymentController> getSupplierPaymentControllerCollection() {
        return supplierPaymentControllerCollection;
    }

    public void setSupplierPaymentControllerCollection(Collection<SupplierPaymentController> supplierPaymentControllerCollection) {
        this.supplierPaymentControllerCollection = supplierPaymentControllerCollection;
    }

    @XmlTransient
    public Collection<SupplierPaymentModeManager> getSupplierPaymentModeManagerCollection() {
        return supplierPaymentModeManagerCollection;
    }

    public void setSupplierPaymentModeManagerCollection(Collection<SupplierPaymentModeManager> supplierPaymentModeManagerCollection) {
        this.supplierPaymentModeManagerCollection = supplierPaymentModeManagerCollection;
    }

    @XmlTransient
    public Collection<SupplierCollectedLeafController> getSupplierCollectedLeafControllerCollection() {
        return supplierCollectedLeafControllerCollection;
    }

    public void setSupplierCollectedLeafControllerCollection(Collection<SupplierCollectedLeafController> supplierCollectedLeafControllerCollection) {
        this.supplierCollectedLeafControllerCollection = supplierCollectedLeafControllerCollection;
    }

    @XmlTransient
    public Collection<WelfarePayments> getWelfarePaymentsCollection() {
        return welfarePaymentsCollection;
    }

    public void setWelfarePaymentsCollection(Collection<WelfarePayments> welfarePaymentsCollection) {
        this.welfarePaymentsCollection = welfarePaymentsCollection;
    }

    @XmlTransient
    public Collection<WelfareManager> getWelfareManagerCollection() {
        return welfareManagerCollection;
    }

    public void setWelfareManagerCollection(Collection<WelfareManager> welfareManagerCollection) {
        this.welfareManagerCollection = welfareManagerCollection;
    }

    @XmlTransient
    public Collection<SupplierTransportRate> getSupplierTransportRateCollection() {
        return supplierTransportRateCollection;
    }

    public void setSupplierTransportRateCollection(Collection<SupplierTransportRate> supplierTransportRateCollection) {
        this.supplierTransportRateCollection = supplierTransportRateCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection() {
        return leafCollectionMasterCollection;
    }

    public void setLeafCollectionMasterCollection(Collection<LeafCollectionMaster> leafCollectionMasterCollection) {
        this.leafCollectionMasterCollection = leafCollectionMasterCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemInstallment> getUniversalBoughtleafItemInstallmentCollection() {
        return universalBoughtleafItemInstallmentCollection;
    }

    public void setUniversalBoughtleafItemInstallmentCollection(Collection<UniversalBoughtleafItemInstallment> universalBoughtleafItemInstallmentCollection) {
        this.universalBoughtleafItemInstallmentCollection = universalBoughtleafItemInstallmentCollection;
    }

    @XmlTransient
    public Collection<SupplierFinalPaymentHistory> getSupplierFinalPaymentHistoryCollection() {
        return supplierFinalPaymentHistoryCollection;
    }

    public void setSupplierFinalPaymentHistoryCollection(Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection) {
        this.supplierFinalPaymentHistoryCollection = supplierFinalPaymentHistoryCollection;
    }

    @XmlTransient
    public Collection<SupplierVehicleMonthlyPayments> getSupplierVehicleMonthlyPaymentsCollection() {
        return supplierVehicleMonthlyPaymentsCollection;
    }

    public void setSupplierVehicleMonthlyPaymentsCollection(Collection<SupplierVehicleMonthlyPayments> supplierVehicleMonthlyPaymentsCollection) {
        this.supplierVehicleMonthlyPaymentsCollection = supplierVehicleMonthlyPaymentsCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequest> getSupplierAdvanceRequestCollection() {
        return supplierAdvanceRequestCollection;
    }

    public void setSupplierAdvanceRequestCollection(Collection<SupplierAdvanceRequest> supplierAdvanceRequestCollection) {
        this.supplierAdvanceRequestCollection = supplierAdvanceRequestCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceTransferRequest> getSupplierAdvanceTransferRequestCollection() {
        return supplierAdvanceTransferRequestCollection;
    }

    public void setSupplierAdvanceTransferRequestCollection(Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection) {
        this.supplierAdvanceTransferRequestCollection = supplierAdvanceTransferRequestCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceTransferRequest> getSupplierAdvanceTransferRequestCollection1() {
        return supplierAdvanceTransferRequestCollection1;
    }

    public void setSupplierAdvanceTransferRequestCollection1(Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection1) {
        this.supplierAdvanceTransferRequestCollection1 = supplierAdvanceTransferRequestCollection1;
    }

    @XmlTransient
    public Collection<SupplierIncentiveFactory> getSupplierIncentiveFactoryCollection() {
        return supplierIncentiveFactoryCollection;
    }

    public void setSupplierIncentiveFactoryCollection(Collection<SupplierIncentiveFactory> supplierIncentiveFactoryCollection) {
        this.supplierIncentiveFactoryCollection = supplierIncentiveFactoryCollection;
    }

    @XmlTransient
    public Collection<SupplierIncentive> getSupplierIncentiveCollection() {
        return supplierIncentiveCollection;
    }

    public void setSupplierIncentiveCollection(Collection<SupplierIncentive> supplierIncentiveCollection) {
        this.supplierIncentiveCollection = supplierIncentiveCollection;
    }

    @XmlTransient
    public Collection<SupplierRoute> getSupplierRouteCollection() {
        return supplierRouteCollection;
    }

    public void setSupplierRouteCollection(Collection<SupplierRoute> supplierRouteCollection) {
        this.supplierRouteCollection = supplierRouteCollection;
    }

    @XmlTransient
    public Collection<SupplierBagWeight> getSupplierBagWeightCollection() {
        return supplierBagWeightCollection;
    }

    public void setSupplierBagWeightCollection(Collection<SupplierBagWeight> supplierBagWeightCollection) {
        this.supplierBagWeightCollection = supplierBagWeightCollection;
    }

    @XmlTransient
    public Collection<ChildrenDetails> getChildrenDetailsCollection() {
        return childrenDetailsCollection;
    }

    public void setChildrenDetailsCollection(Collection<ChildrenDetails> childrenDetailsCollection) {
        this.childrenDetailsCollection = childrenDetailsCollection;
    }

    @XmlTransient
    public Collection<GatePass> getGatePassCollection() {
        return gatePassCollection;
    }

    public void setGatePassCollection(Collection<GatePass> gatePassCollection) {
        this.gatePassCollection = gatePassCollection;
    }

    @XmlTransient
    public Collection<FamilyMemberDetails> getFamilyMemberDetailsCollection() {
        return familyMemberDetailsCollection;
    }

    public void setFamilyMemberDetailsCollection(Collection<FamilyMemberDetails> familyMemberDetailsCollection) {
        this.familyMemberDetailsCollection = familyMemberDetailsCollection;
    }

    @XmlTransient
    public Collection<WelfareCommitteeMembers> getWelfareCommitteeMembersCollection() {
        return welfareCommitteeMembersCollection;
    }

    public void setWelfareCommitteeMembersCollection(Collection<WelfareCommitteeMembers> welfareCommitteeMembersCollection) {
        this.welfareCommitteeMembersCollection = welfareCommitteeMembersCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemController> getUniversalBoughtleafItemControllerCollection() {
        return universalBoughtleafItemControllerCollection;
    }

    public void setUniversalBoughtleafItemControllerCollection(Collection<UniversalBoughtleafItemController> universalBoughtleafItemControllerCollection) {
        this.universalBoughtleafItemControllerCollection = universalBoughtleafItemControllerCollection;
    }

    @XmlTransient
    public Collection<CooperatSupplier> getCooperatSupplierCollection() {
        return cooperatSupplierCollection;
    }

    public void setCooperatSupplierCollection(Collection<CooperatSupplier> cooperatSupplierCollection) {
        this.cooperatSupplierCollection = cooperatSupplierCollection;
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

    public SupplierCategory getSupplierCategoryId() {
        return supplierCategoryId;
    }

    public void setSupplierCategoryId(SupplierCategory supplierCategoryId) {
        this.supplierCategoryId = supplierCategoryId;
    }

    public SupplierType getSupplierTypeId() {
        return supplierTypeId;
    }

    public void setSupplierTypeId(SupplierType supplierTypeId) {
        this.supplierTypeId = supplierTypeId;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeafBySupplier> getFactoryCollectedLeafBySupplierCollection() {
        return factoryCollectedLeafBySupplierCollection;
    }

    public void setFactoryCollectedLeafBySupplierCollection(Collection<FactoryCollectedLeafBySupplier> factoryCollectedLeafBySupplierCollection) {
        this.factoryCollectedLeafBySupplierCollection = factoryCollectedLeafBySupplierCollection;
    }

    @XmlTransient
    public Collection<TeaSupplierPayments> getTeaSupplierPaymentsCollection() {
        return teaSupplierPaymentsCollection;
    }

    public void setTeaSupplierPaymentsCollection(Collection<TeaSupplierPayments> teaSupplierPaymentsCollection) {
        this.teaSupplierPaymentsCollection = teaSupplierPaymentsCollection;
    }

    @XmlTransient
    public Collection<DealingCompanies> getDealingCompaniesCollection() {
        return dealingCompaniesCollection;
    }

    public void setDealingCompaniesCollection(Collection<DealingCompanies> dealingCompaniesCollection) {
        this.dealingCompaniesCollection = dealingCompaniesCollection;
    }

    @XmlTransient
    public Collection<SupplierPassbook> getSupplierPassbookCollection() {
        return supplierPassbookCollection;
    }

    public void setSupplierPassbookCollection(Collection<SupplierPassbook> supplierPassbookCollection) {
        this.supplierPassbookCollection = supplierPassbookCollection;
    }

    @XmlTransient
    public Collection<SuplierAreaProperty> getSuplierAreaPropertyCollection() {
        return suplierAreaPropertyCollection;
    }

    public void setSuplierAreaPropertyCollection(Collection<SuplierAreaProperty> suplierAreaPropertyCollection) {
        this.suplierAreaPropertyCollection = suplierAreaPropertyCollection;
    }

    @XmlTransient
    public Collection<SupplierAllowanceOrDeductionManager> getSupplierAllowanceOrDeductionManagerCollection() {
        return supplierAllowanceOrDeductionManagerCollection;
    }

    public void setSupplierAllowanceOrDeductionManagerCollection(Collection<SupplierAllowanceOrDeductionManager> supplierAllowanceOrDeductionManagerCollection) {
        this.supplierAllowanceOrDeductionManagerCollection = supplierAllowanceOrDeductionManagerCollection;
    }

    @XmlTransient
    public Collection<RouteCollectedLeaf> getRouteCollectedLeafCollection() {
        return routeCollectedLeafCollection;
    }

    public void setRouteCollectedLeafCollection(Collection<RouteCollectedLeaf> routeCollectedLeafCollection) {
        this.routeCollectedLeafCollection = routeCollectedLeafCollection;
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
        if (!(object instanceof SupplierRegistration)) {
            return false;
        }
        SupplierRegistration other = (SupplierRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SupplierRegistration[ id=" + id + " ]";
    }
    
}
