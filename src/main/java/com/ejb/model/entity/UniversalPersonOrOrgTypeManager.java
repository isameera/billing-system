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
@Table(name = "universal_person_or_org_type_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UniversalPersonOrOrgTypeManager.findAll", query = "SELECT u FROM UniversalPersonOrOrgTypeManager u")
    , @NamedQuery(name = "UniversalPersonOrOrgTypeManager.findById", query = "SELECT u FROM UniversalPersonOrOrgTypeManager u WHERE u.id = :id")
    , @NamedQuery(name = "UniversalPersonOrOrgTypeManager.findByName", query = "SELECT u FROM UniversalPersonOrOrgTypeManager u WHERE u.name = :name")})
public class UniversalPersonOrOrgTypeManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<BankAccount> bankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<ChequeDetails> chequeDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<RecurantExpenses> recurantExpensesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<OrgItem> orgItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<JobCard> jobCardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<DeliveryNote> deliveryNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<ConstructionSiteClients> constructionSiteClientsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<TemporaryJob> temporaryJobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<Seller> sellerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<ItemSupplier> itemSupplierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<VehicleOwnerManager> vehicleOwnerManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<ProductionRequest> productionRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<PaymentHistory> paymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universalPersonOrOrgTypeManagerId")
    private Collection<PayeeAccumulatedTotal> payeeAccumulatedTotalCollection;

    public UniversalPersonOrOrgTypeManager() {
    }

    public UniversalPersonOrOrgTypeManager(Integer id) {
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
    public Collection<BankAccount> getBankAccountCollection() {
        return bankAccountCollection;
    }

    public void setBankAccountCollection(Collection<BankAccount> bankAccountCollection) {
        this.bankAccountCollection = bankAccountCollection;
    }

    @XmlTransient
    public Collection<ChequeDetails> getChequeDetailsCollection() {
        return chequeDetailsCollection;
    }

    public void setChequeDetailsCollection(Collection<ChequeDetails> chequeDetailsCollection) {
        this.chequeDetailsCollection = chequeDetailsCollection;
    }

    @XmlTransient
    public Collection<RecurantExpenses> getRecurantExpensesCollection() {
        return recurantExpensesCollection;
    }

    public void setRecurantExpensesCollection(Collection<RecurantExpenses> recurantExpensesCollection) {
        this.recurantExpensesCollection = recurantExpensesCollection;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistory> getUniversalOrgPersonFinancialHistoryCollection() {
        return universalOrgPersonFinancialHistoryCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryCollection(Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection) {
        this.universalOrgPersonFinancialHistoryCollection = universalOrgPersonFinancialHistoryCollection;
    }

    @XmlTransient
    public Collection<OrgItem> getOrgItemCollection() {
        return orgItemCollection;
    }

    public void setOrgItemCollection(Collection<OrgItem> orgItemCollection) {
        this.orgItemCollection = orgItemCollection;
    }

    @XmlTransient
    public Collection<JobCard> getJobCardCollection() {
        return jobCardCollection;
    }

    public void setJobCardCollection(Collection<JobCard> jobCardCollection) {
        this.jobCardCollection = jobCardCollection;
    }

    @XmlTransient
    public Collection<DeliveryNote> getDeliveryNoteCollection() {
        return deliveryNoteCollection;
    }

    public void setDeliveryNoteCollection(Collection<DeliveryNote> deliveryNoteCollection) {
        this.deliveryNoteCollection = deliveryNoteCollection;
    }

    @XmlTransient
    public Collection<ConstructionSiteClients> getConstructionSiteClientsCollection() {
        return constructionSiteClientsCollection;
    }

    public void setConstructionSiteClientsCollection(Collection<ConstructionSiteClients> constructionSiteClientsCollection) {
        this.constructionSiteClientsCollection = constructionSiteClientsCollection;
    }

    @XmlTransient
    public Collection<TemporaryJob> getTemporaryJobCollection() {
        return temporaryJobCollection;
    }

    public void setTemporaryJobCollection(Collection<TemporaryJob> temporaryJobCollection) {
        this.temporaryJobCollection = temporaryJobCollection;
    }

    @XmlTransient
    public Collection<Seller> getSellerCollection() {
        return sellerCollection;
    }

    public void setSellerCollection(Collection<Seller> sellerCollection) {
        this.sellerCollection = sellerCollection;
    }

    @XmlTransient
    public Collection<ItemSupplier> getItemSupplierCollection() {
        return itemSupplierCollection;
    }

    public void setItemSupplierCollection(Collection<ItemSupplier> itemSupplierCollection) {
        this.itemSupplierCollection = itemSupplierCollection;
    }

    @XmlTransient
    public Collection<VehicleOwnerManager> getVehicleOwnerManagerCollection() {
        return vehicleOwnerManagerCollection;
    }

    public void setVehicleOwnerManagerCollection(Collection<VehicleOwnerManager> vehicleOwnerManagerCollection) {
        this.vehicleOwnerManagerCollection = vehicleOwnerManagerCollection;
    }

    @XmlTransient
    public Collection<ProductionRequest> getProductionRequestCollection() {
        return productionRequestCollection;
    }

    public void setProductionRequestCollection(Collection<ProductionRequest> productionRequestCollection) {
        this.productionRequestCollection = productionRequestCollection;
    }

    @XmlTransient
    public Collection<PaymentHistory> getPaymentHistoryCollection() {
        return paymentHistoryCollection;
    }

    public void setPaymentHistoryCollection(Collection<PaymentHistory> paymentHistoryCollection) {
        this.paymentHistoryCollection = paymentHistoryCollection;
    }

    @XmlTransient
    public Collection<PayeeAccumulatedTotal> getPayeeAccumulatedTotalCollection() {
        return payeeAccumulatedTotalCollection;
    }

    public void setPayeeAccumulatedTotalCollection(Collection<PayeeAccumulatedTotal> payeeAccumulatedTotalCollection) {
        this.payeeAccumulatedTotalCollection = payeeAccumulatedTotalCollection;
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
        if (!(object instanceof UniversalPersonOrOrgTypeManager)) {
            return false;
        }
        UniversalPersonOrOrgTypeManager other = (UniversalPersonOrOrgTypeManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UniversalPersonOrOrgTypeManager[ id=" + id + " ]";
    }
    
}
