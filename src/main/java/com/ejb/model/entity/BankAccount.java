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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "bank_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankAccount.findAll", query = "SELECT b FROM BankAccount b")
    , @NamedQuery(name = "BankAccount.findById", query = "SELECT b FROM BankAccount b WHERE b.id = :id")
    , @NamedQuery(name = "BankAccount.findByAccountNumber", query = "SELECT b FROM BankAccount b WHERE b.accountNumber = :accountNumber")
    , @NamedQuery(name = "BankAccount.findByName", query = "SELECT b FROM BankAccount b WHERE b.name = :name")
    , @NamedQuery(name = "BankAccount.findByCode", query = "SELECT b FROM BankAccount b WHERE b.code = :code")
    , @NamedQuery(name = "BankAccount.findByOpeningBalance", query = "SELECT b FROM BankAccount b WHERE b.openingBalance = :openingBalance")
    , @NamedQuery(name = "BankAccount.findByReference", query = "SELECT b FROM BankAccount b WHERE b.reference = :reference")
    , @NamedQuery(name = "BankAccount.findByIsActive", query = "SELECT b FROM BankAccount b WHERE b.isActive = :isActive")})
public class BankAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "account_number")
    private String accountNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opening_balance")
    private double openingBalance;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "is_active")
    private Integer isActive;
    @JoinColumn(name = "sub_chart_of_accountis_sca", referencedColumnName = "id")
    @ManyToOne
    private SubChartOfAccount subChartOfAccountisSca;
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bank bankId;
    @JoinColumn(name = "bank_account_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankAccountType bankAccountTypeId;
    @JoinColumn(name = "branche_of_the_bank_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BrancheOfTheBank brancheOfTheBankId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccountId")
    private Collection<SupplierPaymentController> supplierPaymentControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccountId")
    private Collection<OrgBankAccount> orgBankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccountId")
    private Collection<EmployeeBankAccount> employeeBankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccountId")
    private Collection<UniversalOrgPersonFinancialHistoryBankAccount> universalOrgPersonFinancialHistoryBankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccountId")
    private Collection<EventTickets> eventTicketsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankAccountId")
    private Collection<BankCustomerTransactionHistory> bankCustomerTransactionHistoryCollection;

    public BankAccount() {
    }

    public BankAccount(Integer id) {
        this.id = id;
    }

    public BankAccount(Integer id, String accountNumber, String name, double openingBalance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.openingBalance = openingBalance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public SubChartOfAccount getSubChartOfAccountisSca() {
        return subChartOfAccountisSca;
    }

    public void setSubChartOfAccountisSca(SubChartOfAccount subChartOfAccountisSca) {
        this.subChartOfAccountisSca = subChartOfAccountisSca;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public BankAccountType getBankAccountTypeId() {
        return bankAccountTypeId;
    }

    public void setBankAccountTypeId(BankAccountType bankAccountTypeId) {
        this.bankAccountTypeId = bankAccountTypeId;
    }

    public BrancheOfTheBank getBrancheOfTheBankId() {
        return brancheOfTheBankId;
    }

    public void setBrancheOfTheBankId(BrancheOfTheBank brancheOfTheBankId) {
        this.brancheOfTheBankId = brancheOfTheBankId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    @XmlTransient
    public Collection<SupplierPaymentController> getSupplierPaymentControllerCollection() {
        return supplierPaymentControllerCollection;
    }

    public void setSupplierPaymentControllerCollection(Collection<SupplierPaymentController> supplierPaymentControllerCollection) {
        this.supplierPaymentControllerCollection = supplierPaymentControllerCollection;
    }

    @XmlTransient
    public Collection<OrgBankAccount> getOrgBankAccountCollection() {
        return orgBankAccountCollection;
    }

    public void setOrgBankAccountCollection(Collection<OrgBankAccount> orgBankAccountCollection) {
        this.orgBankAccountCollection = orgBankAccountCollection;
    }

    @XmlTransient
    public Collection<EmployeeBankAccount> getEmployeeBankAccountCollection() {
        return employeeBankAccountCollection;
    }

    public void setEmployeeBankAccountCollection(Collection<EmployeeBankAccount> employeeBankAccountCollection) {
        this.employeeBankAccountCollection = employeeBankAccountCollection;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistoryBankAccount> getUniversalOrgPersonFinancialHistoryBankAccountCollection() {
        return universalOrgPersonFinancialHistoryBankAccountCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryBankAccountCollection(Collection<UniversalOrgPersonFinancialHistoryBankAccount> universalOrgPersonFinancialHistoryBankAccountCollection) {
        this.universalOrgPersonFinancialHistoryBankAccountCollection = universalOrgPersonFinancialHistoryBankAccountCollection;
    }

    @XmlTransient
    public Collection<EventTickets> getEventTicketsCollection() {
        return eventTicketsCollection;
    }

    public void setEventTicketsCollection(Collection<EventTickets> eventTicketsCollection) {
        this.eventTicketsCollection = eventTicketsCollection;
    }

    @XmlTransient
    public Collection<BankCustomerTransactionHistory> getBankCustomerTransactionHistoryCollection() {
        return bankCustomerTransactionHistoryCollection;
    }

    public void setBankCustomerTransactionHistoryCollection(Collection<BankCustomerTransactionHistory> bankCustomerTransactionHistoryCollection) {
        this.bankCustomerTransactionHistoryCollection = bankCustomerTransactionHistoryCollection;
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
        if (!(object instanceof BankAccount)) {
            return false;
        }
        BankAccount other = (BankAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.BankAccount[ id=" + id + " ]";
    }
    
}
