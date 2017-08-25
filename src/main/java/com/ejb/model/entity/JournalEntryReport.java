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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "journal_entry_report")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JournalEntryReport.findAll", query = "SELECT j FROM JournalEntryReport j")
    , @NamedQuery(name = "JournalEntryReport.findById", query = "SELECT j FROM JournalEntryReport j WHERE j.id = :id")
    , @NamedQuery(name = "JournalEntryReport.findByYear", query = "SELECT j FROM JournalEntryReport j WHERE j.year = :year")
    , @NamedQuery(name = "JournalEntryReport.findByMonth", query = "SELECT j FROM JournalEntryReport j WHERE j.month = :month")
    , @NamedQuery(name = "JournalEntryReport.findByDate", query = "SELECT j FROM JournalEntryReport j WHERE j.date = :date")
    , @NamedQuery(name = "JournalEntryReport.findByCredit", query = "SELECT j FROM JournalEntryReport j WHERE j.credit = :credit")
    , @NamedQuery(name = "JournalEntryReport.findByDebit", query = "SELECT j FROM JournalEntryReport j WHERE j.debit = :debit")})
public class JournalEntryReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "credit")
    private Double credit;
    @Column(name = "debit")
    private Double debit;
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChartOfAccount chartOfAccountId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "main_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MainChartOfAccount mainChartOfAccountId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;

    public JournalEntryReport() {
    }

    public JournalEntryReport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
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

    public MainChartOfAccount getMainChartOfAccountId() {
        return mainChartOfAccountId;
    }

    public void setMainChartOfAccountId(MainChartOfAccount mainChartOfAccountId) {
        this.mainChartOfAccountId = mainChartOfAccountId;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
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
        if (!(object instanceof JournalEntryReport)) {
            return false;
        }
        JournalEntryReport other = (JournalEntryReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.JournalEntryReport[ id=" + id + " ]";
    }
    
}
