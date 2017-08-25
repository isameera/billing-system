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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "recurant_expenses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecurantExpenses.findAll", query = "SELECT r FROM RecurantExpenses r")
    , @NamedQuery(name = "RecurantExpenses.findById", query = "SELECT r FROM RecurantExpenses r WHERE r.id = :id")
    , @NamedQuery(name = "RecurantExpenses.findByReference", query = "SELECT r FROM RecurantExpenses r WHERE r.reference = :reference")
    , @NamedQuery(name = "RecurantExpenses.findByStartDate", query = "SELECT r FROM RecurantExpenses r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "RecurantExpenses.findByAmount", query = "SELECT r FROM RecurantExpenses r WHERE r.amount = :amount")
    , @NamedQuery(name = "RecurantExpenses.findByNoOfReference", query = "SELECT r FROM RecurantExpenses r WHERE r.noOfReference = :noOfReference")})
public class RecurantExpenses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "no_of_reference")
    private Integer noOfReference;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChartOfAccount chartOfAccountId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "recurant_expense_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RecurantExpenseType recurantExpenseTypeId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recurantExpensesId")
    private Collection<RecurantExpensesHistory> recurantExpensesHistoryCollection;

    public RecurantExpenses() {
    }

    public RecurantExpenses(Integer id) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNoOfReference() {
        return noOfReference;
    }

    public void setNoOfReference(Integer noOfReference) {
        this.noOfReference = noOfReference;
    }

    public ChartOfAccount getChartOfAccountId() {
        return chartOfAccountId;
    }

    public void setChartOfAccountId(ChartOfAccount chartOfAccountId) {
        this.chartOfAccountId = chartOfAccountId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public RecurantExpenseType getRecurantExpenseTypeId() {
        return recurantExpenseTypeId;
    }

    public void setRecurantExpenseTypeId(RecurantExpenseType recurantExpenseTypeId) {
        this.recurantExpenseTypeId = recurantExpenseTypeId;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    @XmlTransient
    public Collection<RecurantExpensesHistory> getRecurantExpensesHistoryCollection() {
        return recurantExpensesHistoryCollection;
    }

    public void setRecurantExpensesHistoryCollection(Collection<RecurantExpensesHistory> recurantExpensesHistoryCollection) {
        this.recurantExpensesHistoryCollection = recurantExpensesHistoryCollection;
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
        if (!(object instanceof RecurantExpenses)) {
            return false;
        }
        RecurantExpenses other = (RecurantExpenses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.RecurantExpenses[ id=" + id + " ]";
    }
    
}
