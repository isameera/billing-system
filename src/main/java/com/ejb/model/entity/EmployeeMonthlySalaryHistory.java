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
@Table(name = "employee_monthly_salary_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeMonthlySalaryHistory.findAll", query = "SELECT e FROM EmployeeMonthlySalaryHistory e")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findById", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByPaymentDate", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.paymentDate = :paymentDate")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByYear", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.year = :year")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByMonth", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.month = :month")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByBasicSalary", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.basicSalary = :basicSalary")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByTotalAllowance", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.totalAllowance = :totalAllowance")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByTotalDeduction", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.totalDeduction = :totalDeduction")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByTotalSalary", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.totalSalary = :totalSalary")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByEpfCompany", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.epfCompany = :epfCompany")
    , @NamedQuery(name = "EmployeeMonthlySalaryHistory.findByEpfEmployee", query = "SELECT e FROM EmployeeMonthlySalaryHistory e WHERE e.epfEmployee = :epfEmployee")})
public class EmployeeMonthlySalaryHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "basic_salary")
    private Double basicSalary;
    @Column(name = "total_allowance")
    private Double totalAllowance;
    @Column(name = "total_deduction")
    private Double totalDeduction;
    @Column(name = "total_salary")
    private Double totalSalary;
    @Column(name = "epf_company")
    private Double epfCompany;
    @Column(name = "epf_employee")
    private Double epfEmployee;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeMonthlySalaryHistoryId")
    private Collection<LeaveCounter> leaveCounterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeMonthlySalaryHistoryId")
    private Collection<EmployeeAllowanceDeductionHistoryManager> employeeAllowanceDeductionHistoryManagerCollection;

    public EmployeeMonthlySalaryHistory() {
    }

    public EmployeeMonthlySalaryHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getTotalAllowance() {
        return totalAllowance;
    }

    public void setTotalAllowance(Double totalAllowance) {
        this.totalAllowance = totalAllowance;
    }

    public Double getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(Double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Double getEpfCompany() {
        return epfCompany;
    }

    public void setEpfCompany(Double epfCompany) {
        this.epfCompany = epfCompany;
    }

    public Double getEpfEmployee() {
        return epfEmployee;
    }

    public void setEpfEmployee(Double epfEmployee) {
        this.epfEmployee = epfEmployee;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    @XmlTransient
    public Collection<LeaveCounter> getLeaveCounterCollection() {
        return leaveCounterCollection;
    }

    public void setLeaveCounterCollection(Collection<LeaveCounter> leaveCounterCollection) {
        this.leaveCounterCollection = leaveCounterCollection;
    }

    @XmlTransient
    public Collection<EmployeeAllowanceDeductionHistoryManager> getEmployeeAllowanceDeductionHistoryManagerCollection() {
        return employeeAllowanceDeductionHistoryManagerCollection;
    }

    public void setEmployeeAllowanceDeductionHistoryManagerCollection(Collection<EmployeeAllowanceDeductionHistoryManager> employeeAllowanceDeductionHistoryManagerCollection) {
        this.employeeAllowanceDeductionHistoryManagerCollection = employeeAllowanceDeductionHistoryManagerCollection;
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
        if (!(object instanceof EmployeeMonthlySalaryHistory)) {
            return false;
        }
        EmployeeMonthlySalaryHistory other = (EmployeeMonthlySalaryHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeMonthlySalaryHistory[ id=" + id + " ]";
    }
    
}
