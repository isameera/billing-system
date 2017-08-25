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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByNumber", query = "SELECT e FROM Employee e WHERE e.number = :number")
    , @NamedQuery(name = "Employee.findByOldRegNo", query = "SELECT e FROM Employee e WHERE e.oldRegNo = :oldRegNo")
    , @NamedQuery(name = "Employee.findByRegDate", query = "SELECT e FROM Employee e WHERE e.regDate = :regDate")
    , @NamedQuery(name = "Employee.findByVerifiedDate", query = "SELECT e FROM Employee e WHERE e.verifiedDate = :verifiedDate")
    , @NamedQuery(name = "Employee.findByEpfNo", query = "SELECT e FROM Employee e WHERE e.epfNo = :epfNo")
    , @NamedQuery(name = "Employee.findByDayOff", query = "SELECT e FROM Employee e WHERE e.dayOff = :dayOff")
    , @NamedQuery(name = "Employee.findByStartTime", query = "SELECT e FROM Employee e WHERE e.startTime = :startTime")
    , @NamedQuery(name = "Employee.findByEndTime", query = "SELECT e FROM Employee e WHERE e.endTime = :endTime")
    , @NamedQuery(name = "Employee.findByIgnoreStartTimePeriod", query = "SELECT e FROM Employee e WHERE e.ignoreStartTimePeriod = :ignoreStartTimePeriod")
    , @NamedQuery(name = "Employee.findByAnnualLeaves", query = "SELECT e FROM Employee e WHERE e.annualLeaves = :annualLeaves")
    , @NamedQuery(name = "Employee.findByIsValidLoan", query = "SELECT e FROM Employee e WHERE e.isValidLoan = :isValidLoan")
    , @NamedQuery(name = "Employee.findByPettyCashLevel", query = "SELECT e FROM Employee e WHERE e.pettyCashLevel = :pettyCashLevel")
    , @NamedQuery(name = "Employee.findByIsActive", query = "SELECT e FROM Employee e WHERE e.isActive = :isActive")
    , @NamedQuery(name = "Employee.findByBasicSalary", query = "SELECT e FROM Employee e WHERE e.basicSalary = :basicSalary")
    , @NamedQuery(name = "Employee.findByInsuranceId", query = "SELECT e FROM Employee e WHERE e.insuranceId = :insuranceId")
    , @NamedQuery(name = "Employee.findByResignDate", query = "SELECT e FROM Employee e WHERE e.resignDate = :resignDate")
    , @NamedQuery(name = "Employee.findByFpId", query = "SELECT e FROM Employee e WHERE e.fpId = :fpId")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "number")
    private String number;
    @Size(max = 45)
    @Column(name = "old_reg_no")
    private String oldRegNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reg_date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Column(name = "verified_date")
    @Temporal(TemporalType.DATE)
    private Date verifiedDate;
    @Size(max = 255)
    @Column(name = "epf_no")
    private String epfNo;
    @Size(max = 255)
    @Column(name = "day_off")
    private String dayOff;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ignore_start_time_period")
    private Double ignoreStartTimePeriod;
    @Column(name = "annual_leaves")
    private Integer annualLeaves;
    @Column(name = "is_valid_loan")
    private Integer isValidLoan;
    @Column(name = "petty_cash_level")
    private Double pettyCashLevel;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "basic_salary")
    private Double basicSalary;
    @Size(max = 45)
    @Column(name = "insurance_id")
    private String insuranceId;
    @Column(name = "resign_date")
    @Temporal(TemporalType.DATE)
    private Date resignDate;
    @Column(name = "fp_id")
    private Integer fpId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeAssetIssues> employeeAssetIssuesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeesId")
    private Collection<TeaSupplierPaymentApproval> teaSupplierPaymentApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<ConstructionSiteEmployeeMeal> constructionSiteEmployeeMealCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisor")
    private Collection<ConstructionSiteEmployeeMeal> constructionSiteEmployeeMealCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<FingerPrintEmployeeAttendance> fingerPrintEmployeeAttendanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<SecurityActivityLog> securityActivityLogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeAssetReturn> employeeAssetReturnCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeMonthlySalaryHistory> employeeMonthlySalaryHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeesId")
    private Collection<EmployeeOperationalDetails> employeeOperationalDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<TimeTable> timeTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestedBy")
    private Collection<VoucherInactiveRequest> voucherInactiveRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enteredBy")
    private Collection<ConstructionContractEmployeeHistory> constructionContractEmployeeHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<ConstructionContractEmployeeHistory> constructionContractEmployeeHistoryCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "approvedBy")
    private Collection<LeaveRequestApproval> leaveRequestApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<BalanceAnnualLeaveCounter> balanceAnnualLeaveCounterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<UniversalBoughtleafItemApproval> universalBoughtleafItemApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeTypeManager> employeeTypeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<ProductionTeaBook> productionTeaBookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "approvedBy")
    private Collection<VoucherApproval> voucherApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "helper")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "collectionOfficer")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<FactoryCollectedLeafConfirmation> factoryCollectedLeafConfirmationCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<LeaveRequestManager> leaveRequestManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeesId")
    private Collection<Incidents> incidentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<WorkShiftManagerIso> workShiftManagerIsoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection;
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    @ManyToOne
    private Designation designationId;
    @JoinColumn(name = "designation_grade_id", referencedColumnName = "id")
    @ManyToOne
    private DesignationGrade designationGradeId;
    @JoinColumn(name = "employee_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeCategory employeeCategoryId;
    @JoinColumn(name = "employee_permanent_ststus_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeePermanentStstus employeePermanentStstusId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "universal_basic_salary_calculation_id", referencedColumnName = "id")
    @ManyToOne
    private UniversalBasicSalaryCalculation universalBasicSalaryCalculationId;
    @JoinColumn(name = "employee_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeType employeeTypeId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeWorkingSection> employeeWorkingSectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<WorkShiftManager> workShiftManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<WelfareActiveInactiveHistory> welfareActiveInactiveHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<UniversalBoughtleafItemIssue> universalBoughtleafItemIssueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<DepositConfirmedBy> depositConfirmedByCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<JobCard> jobCardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<StockReconciliation> stockReconciliationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeSalaryIncrementHistory> employeeSalaryIncrementHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeNote> employeeNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<HolidayPayRegister> holidayPayRegisterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<TemporaryJob> temporaryJobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeFinalPayment> employeeFinalPaymentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeCommonSettings> employeeCommonSettingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteIncharge")
    private Collection<ConstructionContract> constructionContractCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectManager")
    private Collection<ConstructionContract> constructionContractCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<LeaveCoveredBy> leaveCoveredByCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeesId")
    private Collection<EmployeeItemLocation> employeeItemLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeAllowanceManager> employeeAllowanceManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<WelfarePaymentSchedule> welfarePaymentScheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "executive")
    private Collection<Seller> sellerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supervisor")
    private Collection<ConstructionSiteEmployeeSafty> constructionSiteEmployeeSaftyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<ComItemApproval> comItemApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeContractDetails> employeeContractDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<AdvanceRequest> advanceRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<GatePass> gatePassCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preparedBy")
    private Collection<Quotation> quotationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorizedBy")
    private Collection<Quotation> quotationCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<AtendenceRegistry> atendenceRegistryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<RouteEmployee> routeEmployeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "extendedBy")
    private Collection<EmployeePermanentDateExtendedHistory> employeePermanentDateExtendedHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<EmployeePermanentDateExtendedHistory> employeePermanentDateExtendedHistoryCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<LoanApproval> loanApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advicedBy")
    private Collection<ProductionAdvice> productionAdviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestedBy")
    private Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection;
    @OneToMany(mappedBy = "approvedBy")
    private Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "approvedBy")
    private Collection<VoucherInactiveApprove> voucherInactiveApproveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<LoanTransferForApproval> loanTransferForApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeeWorkmanCompensation> employeeWorkmanCompensationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<SellerPriceChangedHistory> sellerPriceChangedHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<EmployeePaymentDetails> employeePaymentDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<ComRequistedItemIssue> comRequistedItemIssueCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<SupplierAdvanceRequestIssuing> supplierAdvanceRequestIssuingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeesId")
    private Collection<WorkedHistory> workedHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<UniversalBoughtleafItemDeliveryDetails> universalBoughtleafItemDeliveryDetailsCollection;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, Date regDate) {
        this.id = id;
        this.regDate = regDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOldRegNo() {
        return oldRegNo;
    }

    public void setOldRegNo(String oldRegNo) {
        this.oldRegNo = oldRegNo;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    public String getEpfNo() {
        return epfNo;
    }

    public void setEpfNo(String epfNo) {
        this.epfNo = epfNo;
    }

    public String getDayOff() {
        return dayOff;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getIgnoreStartTimePeriod() {
        return ignoreStartTimePeriod;
    }

    public void setIgnoreStartTimePeriod(Double ignoreStartTimePeriod) {
        this.ignoreStartTimePeriod = ignoreStartTimePeriod;
    }

    public Integer getAnnualLeaves() {
        return annualLeaves;
    }

    public void setAnnualLeaves(Integer annualLeaves) {
        this.annualLeaves = annualLeaves;
    }

    public Integer getIsValidLoan() {
        return isValidLoan;
    }

    public void setIsValidLoan(Integer isValidLoan) {
        this.isValidLoan = isValidLoan;
    }

    public Double getPettyCashLevel() {
        return pettyCashLevel;
    }

    public void setPettyCashLevel(Double pettyCashLevel) {
        this.pettyCashLevel = pettyCashLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Date getResignDate() {
        return resignDate;
    }

    public void setResignDate(Date resignDate) {
        this.resignDate = resignDate;
    }

    public Integer getFpId() {
        return fpId;
    }

    public void setFpId(Integer fpId) {
        this.fpId = fpId;
    }

    @XmlTransient
    public Collection<EmployeeAssetIssues> getEmployeeAssetIssuesCollection() {
        return employeeAssetIssuesCollection;
    }

    public void setEmployeeAssetIssuesCollection(Collection<EmployeeAssetIssues> employeeAssetIssuesCollection) {
        this.employeeAssetIssuesCollection = employeeAssetIssuesCollection;
    }

    @XmlTransient
    public Collection<TeaSupplierPaymentApproval> getTeaSupplierPaymentApprovalCollection() {
        return teaSupplierPaymentApprovalCollection;
    }

    public void setTeaSupplierPaymentApprovalCollection(Collection<TeaSupplierPaymentApproval> teaSupplierPaymentApprovalCollection) {
        this.teaSupplierPaymentApprovalCollection = teaSupplierPaymentApprovalCollection;
    }

    @XmlTransient
    public Collection<ConstructionSiteEmployeeMeal> getConstructionSiteEmployeeMealCollection() {
        return constructionSiteEmployeeMealCollection;
    }

    public void setConstructionSiteEmployeeMealCollection(Collection<ConstructionSiteEmployeeMeal> constructionSiteEmployeeMealCollection) {
        this.constructionSiteEmployeeMealCollection = constructionSiteEmployeeMealCollection;
    }

    @XmlTransient
    public Collection<ConstructionSiteEmployeeMeal> getConstructionSiteEmployeeMealCollection1() {
        return constructionSiteEmployeeMealCollection1;
    }

    public void setConstructionSiteEmployeeMealCollection1(Collection<ConstructionSiteEmployeeMeal> constructionSiteEmployeeMealCollection1) {
        this.constructionSiteEmployeeMealCollection1 = constructionSiteEmployeeMealCollection1;
    }

    @XmlTransient
    public Collection<FingerPrintEmployeeAttendance> getFingerPrintEmployeeAttendanceCollection() {
        return fingerPrintEmployeeAttendanceCollection;
    }

    public void setFingerPrintEmployeeAttendanceCollection(Collection<FingerPrintEmployeeAttendance> fingerPrintEmployeeAttendanceCollection) {
        this.fingerPrintEmployeeAttendanceCollection = fingerPrintEmployeeAttendanceCollection;
    }

    @XmlTransient
    public Collection<SecurityActivityLog> getSecurityActivityLogCollection() {
        return securityActivityLogCollection;
    }

    public void setSecurityActivityLogCollection(Collection<SecurityActivityLog> securityActivityLogCollection) {
        this.securityActivityLogCollection = securityActivityLogCollection;
    }

    @XmlTransient
    public Collection<EmployeeAssetReturn> getEmployeeAssetReturnCollection() {
        return employeeAssetReturnCollection;
    }

    public void setEmployeeAssetReturnCollection(Collection<EmployeeAssetReturn> employeeAssetReturnCollection) {
        this.employeeAssetReturnCollection = employeeAssetReturnCollection;
    }

    @XmlTransient
    public Collection<EmployeeMonthlySalaryHistory> getEmployeeMonthlySalaryHistoryCollection() {
        return employeeMonthlySalaryHistoryCollection;
    }

    public void setEmployeeMonthlySalaryHistoryCollection(Collection<EmployeeMonthlySalaryHistory> employeeMonthlySalaryHistoryCollection) {
        this.employeeMonthlySalaryHistoryCollection = employeeMonthlySalaryHistoryCollection;
    }

    @XmlTransient
    public Collection<EmployeeOperationalDetails> getEmployeeOperationalDetailsCollection() {
        return employeeOperationalDetailsCollection;
    }

    public void setEmployeeOperationalDetailsCollection(Collection<EmployeeOperationalDetails> employeeOperationalDetailsCollection) {
        this.employeeOperationalDetailsCollection = employeeOperationalDetailsCollection;
    }

    @XmlTransient
    public Collection<TimeTable> getTimeTableCollection() {
        return timeTableCollection;
    }

    public void setTimeTableCollection(Collection<TimeTable> timeTableCollection) {
        this.timeTableCollection = timeTableCollection;
    }

    @XmlTransient
    public Collection<VoucherInactiveRequest> getVoucherInactiveRequestCollection() {
        return voucherInactiveRequestCollection;
    }

    public void setVoucherInactiveRequestCollection(Collection<VoucherInactiveRequest> voucherInactiveRequestCollection) {
        this.voucherInactiveRequestCollection = voucherInactiveRequestCollection;
    }

    @XmlTransient
    public Collection<ConstructionContractEmployeeHistory> getConstructionContractEmployeeHistoryCollection() {
        return constructionContractEmployeeHistoryCollection;
    }

    public void setConstructionContractEmployeeHistoryCollection(Collection<ConstructionContractEmployeeHistory> constructionContractEmployeeHistoryCollection) {
        this.constructionContractEmployeeHistoryCollection = constructionContractEmployeeHistoryCollection;
    }

    @XmlTransient
    public Collection<ConstructionContractEmployeeHistory> getConstructionContractEmployeeHistoryCollection1() {
        return constructionContractEmployeeHistoryCollection1;
    }

    public void setConstructionContractEmployeeHistoryCollection1(Collection<ConstructionContractEmployeeHistory> constructionContractEmployeeHistoryCollection1) {
        this.constructionContractEmployeeHistoryCollection1 = constructionContractEmployeeHistoryCollection1;
    }

    @XmlTransient
    public Collection<LeaveRequestApproval> getLeaveRequestApprovalCollection() {
        return leaveRequestApprovalCollection;
    }

    public void setLeaveRequestApprovalCollection(Collection<LeaveRequestApproval> leaveRequestApprovalCollection) {
        this.leaveRequestApprovalCollection = leaveRequestApprovalCollection;
    }

    @XmlTransient
    public Collection<BalanceAnnualLeaveCounter> getBalanceAnnualLeaveCounterCollection() {
        return balanceAnnualLeaveCounterCollection;
    }

    public void setBalanceAnnualLeaveCounterCollection(Collection<BalanceAnnualLeaveCounter> balanceAnnualLeaveCounterCollection) {
        this.balanceAnnualLeaveCounterCollection = balanceAnnualLeaveCounterCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemApproval> getUniversalBoughtleafItemApprovalCollection() {
        return universalBoughtleafItemApprovalCollection;
    }

    public void setUniversalBoughtleafItemApprovalCollection(Collection<UniversalBoughtleafItemApproval> universalBoughtleafItemApprovalCollection) {
        this.universalBoughtleafItemApprovalCollection = universalBoughtleafItemApprovalCollection;
    }

    @XmlTransient
    public Collection<EmployeeTypeManager> getEmployeeTypeManagerCollection() {
        return employeeTypeManagerCollection;
    }

    public void setEmployeeTypeManagerCollection(Collection<EmployeeTypeManager> employeeTypeManagerCollection) {
        this.employeeTypeManagerCollection = employeeTypeManagerCollection;
    }

    @XmlTransient
    public Collection<ProductionTeaBook> getProductionTeaBookCollection() {
        return productionTeaBookCollection;
    }

    public void setProductionTeaBookCollection(Collection<ProductionTeaBook> productionTeaBookCollection) {
        this.productionTeaBookCollection = productionTeaBookCollection;
    }

    @XmlTransient
    public Collection<VoucherApproval> getVoucherApprovalCollection() {
        return voucherApprovalCollection;
    }

    public void setVoucherApprovalCollection(Collection<VoucherApproval> voucherApprovalCollection) {
        this.voucherApprovalCollection = voucherApprovalCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection() {
        return leafCollectionMasterCollection;
    }

    public void setLeafCollectionMasterCollection(Collection<LeafCollectionMaster> leafCollectionMasterCollection) {
        this.leafCollectionMasterCollection = leafCollectionMasterCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection1() {
        return leafCollectionMasterCollection1;
    }

    public void setLeafCollectionMasterCollection1(Collection<LeafCollectionMaster> leafCollectionMasterCollection1) {
        this.leafCollectionMasterCollection1 = leafCollectionMasterCollection1;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeafConfirmation> getFactoryCollectedLeafConfirmationCollection() {
        return factoryCollectedLeafConfirmationCollection;
    }

    public void setFactoryCollectedLeafConfirmationCollection(Collection<FactoryCollectedLeafConfirmation> factoryCollectedLeafConfirmationCollection) {
        this.factoryCollectedLeafConfirmationCollection = factoryCollectedLeafConfirmationCollection;
    }

    @XmlTransient
    public Collection<LeaveRequestManager> getLeaveRequestManagerCollection() {
        return leaveRequestManagerCollection;
    }

    public void setLeaveRequestManagerCollection(Collection<LeaveRequestManager> leaveRequestManagerCollection) {
        this.leaveRequestManagerCollection = leaveRequestManagerCollection;
    }

    @XmlTransient
    public Collection<Incidents> getIncidentsCollection() {
        return incidentsCollection;
    }

    public void setIncidentsCollection(Collection<Incidents> incidentsCollection) {
        this.incidentsCollection = incidentsCollection;
    }

    @XmlTransient
    public Collection<WorkShiftManagerIso> getWorkShiftManagerIsoCollection() {
        return workShiftManagerIsoCollection;
    }

    public void setWorkShiftManagerIsoCollection(Collection<WorkShiftManagerIso> workShiftManagerIsoCollection) {
        this.workShiftManagerIsoCollection = workShiftManagerIsoCollection;
    }

    @XmlTransient
    public Collection<PreparePaymentsForSupplierSavings> getPreparePaymentsForSupplierSavingsCollection() {
        return preparePaymentsForSupplierSavingsCollection;
    }

    public void setPreparePaymentsForSupplierSavingsCollection(Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection) {
        this.preparePaymentsForSupplierSavingsCollection = preparePaymentsForSupplierSavingsCollection;
    }

    public Designation getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Designation designationId) {
        this.designationId = designationId;
    }

    public DesignationGrade getDesignationGradeId() {
        return designationGradeId;
    }

    public void setDesignationGradeId(DesignationGrade designationGradeId) {
        this.designationGradeId = designationGradeId;
    }

    public EmployeeCategory getEmployeeCategoryId() {
        return employeeCategoryId;
    }

    public void setEmployeeCategoryId(EmployeeCategory employeeCategoryId) {
        this.employeeCategoryId = employeeCategoryId;
    }

    public EmployeePermanentStstus getEmployeePermanentStstusId() {
        return employeePermanentStstusId;
    }

    public void setEmployeePermanentStstusId(EmployeePermanentStstus employeePermanentStstusId) {
        this.employeePermanentStstusId = employeePermanentStstusId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UniversalBasicSalaryCalculation getUniversalBasicSalaryCalculationId() {
        return universalBasicSalaryCalculationId;
    }

    public void setUniversalBasicSalaryCalculationId(UniversalBasicSalaryCalculation universalBasicSalaryCalculationId) {
        this.universalBasicSalaryCalculationId = universalBasicSalaryCalculationId;
    }

    public EmployeeType getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(EmployeeType employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    @XmlTransient
    public Collection<EmployeeWorkingSection> getEmployeeWorkingSectionCollection() {
        return employeeWorkingSectionCollection;
    }

    public void setEmployeeWorkingSectionCollection(Collection<EmployeeWorkingSection> employeeWorkingSectionCollection) {
        this.employeeWorkingSectionCollection = employeeWorkingSectionCollection;
    }

    @XmlTransient
    public Collection<WorkShiftManager> getWorkShiftManagerCollection() {
        return workShiftManagerCollection;
    }

    public void setWorkShiftManagerCollection(Collection<WorkShiftManager> workShiftManagerCollection) {
        this.workShiftManagerCollection = workShiftManagerCollection;
    }

    @XmlTransient
    public Collection<WelfareActiveInactiveHistory> getWelfareActiveInactiveHistoryCollection() {
        return welfareActiveInactiveHistoryCollection;
    }

    public void setWelfareActiveInactiveHistoryCollection(Collection<WelfareActiveInactiveHistory> welfareActiveInactiveHistoryCollection) {
        this.welfareActiveInactiveHistoryCollection = welfareActiveInactiveHistoryCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemIssue> getUniversalBoughtleafItemIssueCollection() {
        return universalBoughtleafItemIssueCollection;
    }

    public void setUniversalBoughtleafItemIssueCollection(Collection<UniversalBoughtleafItemIssue> universalBoughtleafItemIssueCollection) {
        this.universalBoughtleafItemIssueCollection = universalBoughtleafItemIssueCollection;
    }

    @XmlTransient
    public Collection<DepositConfirmedBy> getDepositConfirmedByCollection() {
        return depositConfirmedByCollection;
    }

    public void setDepositConfirmedByCollection(Collection<DepositConfirmedBy> depositConfirmedByCollection) {
        this.depositConfirmedByCollection = depositConfirmedByCollection;
    }

    @XmlTransient
    public Collection<JobCard> getJobCardCollection() {
        return jobCardCollection;
    }

    public void setJobCardCollection(Collection<JobCard> jobCardCollection) {
        this.jobCardCollection = jobCardCollection;
    }

    @XmlTransient
    public Collection<StockReconciliation> getStockReconciliationCollection() {
        return stockReconciliationCollection;
    }

    public void setStockReconciliationCollection(Collection<StockReconciliation> stockReconciliationCollection) {
        this.stockReconciliationCollection = stockReconciliationCollection;
    }

    @XmlTransient
    public Collection<EmployeeSalaryIncrementHistory> getEmployeeSalaryIncrementHistoryCollection() {
        return employeeSalaryIncrementHistoryCollection;
    }

    public void setEmployeeSalaryIncrementHistoryCollection(Collection<EmployeeSalaryIncrementHistory> employeeSalaryIncrementHistoryCollection) {
        this.employeeSalaryIncrementHistoryCollection = employeeSalaryIncrementHistoryCollection;
    }

    @XmlTransient
    public Collection<EmployeeNote> getEmployeeNoteCollection() {
        return employeeNoteCollection;
    }

    public void setEmployeeNoteCollection(Collection<EmployeeNote> employeeNoteCollection) {
        this.employeeNoteCollection = employeeNoteCollection;
    }

    @XmlTransient
    public Collection<SupplierFinalPaymentHistory> getSupplierFinalPaymentHistoryCollection() {
        return supplierFinalPaymentHistoryCollection;
    }

    public void setSupplierFinalPaymentHistoryCollection(Collection<SupplierFinalPaymentHistory> supplierFinalPaymentHistoryCollection) {
        this.supplierFinalPaymentHistoryCollection = supplierFinalPaymentHistoryCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceTransferRequest> getSupplierAdvanceTransferRequestCollection() {
        return supplierAdvanceTransferRequestCollection;
    }

    public void setSupplierAdvanceTransferRequestCollection(Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection) {
        this.supplierAdvanceTransferRequestCollection = supplierAdvanceTransferRequestCollection;
    }

    @XmlTransient
    public Collection<HolidayPayRegister> getHolidayPayRegisterCollection() {
        return holidayPayRegisterCollection;
    }

    public void setHolidayPayRegisterCollection(Collection<HolidayPayRegister> holidayPayRegisterCollection) {
        this.holidayPayRegisterCollection = holidayPayRegisterCollection;
    }

    @XmlTransient
    public Collection<TemporaryJob> getTemporaryJobCollection() {
        return temporaryJobCollection;
    }

    public void setTemporaryJobCollection(Collection<TemporaryJob> temporaryJobCollection) {
        this.temporaryJobCollection = temporaryJobCollection;
    }

    @XmlTransient
    public Collection<EmployeeFinalPayment> getEmployeeFinalPaymentCollection() {
        return employeeFinalPaymentCollection;
    }

    public void setEmployeeFinalPaymentCollection(Collection<EmployeeFinalPayment> employeeFinalPaymentCollection) {
        this.employeeFinalPaymentCollection = employeeFinalPaymentCollection;
    }

    @XmlTransient
    public Collection<EmployeeCommonSettings> getEmployeeCommonSettingsCollection() {
        return employeeCommonSettingsCollection;
    }

    public void setEmployeeCommonSettingsCollection(Collection<EmployeeCommonSettings> employeeCommonSettingsCollection) {
        this.employeeCommonSettingsCollection = employeeCommonSettingsCollection;
    }

    @XmlTransient
    public Collection<ConstructionContract> getConstructionContractCollection() {
        return constructionContractCollection;
    }

    public void setConstructionContractCollection(Collection<ConstructionContract> constructionContractCollection) {
        this.constructionContractCollection = constructionContractCollection;
    }

    @XmlTransient
    public Collection<ConstructionContract> getConstructionContractCollection1() {
        return constructionContractCollection1;
    }

    public void setConstructionContractCollection1(Collection<ConstructionContract> constructionContractCollection1) {
        this.constructionContractCollection1 = constructionContractCollection1;
    }

    @XmlTransient
    public Collection<LeaveCoveredBy> getLeaveCoveredByCollection() {
        return leaveCoveredByCollection;
    }

    public void setLeaveCoveredByCollection(Collection<LeaveCoveredBy> leaveCoveredByCollection) {
        this.leaveCoveredByCollection = leaveCoveredByCollection;
    }

    @XmlTransient
    public Collection<EmployeeItemLocation> getEmployeeItemLocationCollection() {
        return employeeItemLocationCollection;
    }

    public void setEmployeeItemLocationCollection(Collection<EmployeeItemLocation> employeeItemLocationCollection) {
        this.employeeItemLocationCollection = employeeItemLocationCollection;
    }

    @XmlTransient
    public Collection<EmployeeAllowanceManager> getEmployeeAllowanceManagerCollection() {
        return employeeAllowanceManagerCollection;
    }

    public void setEmployeeAllowanceManagerCollection(Collection<EmployeeAllowanceManager> employeeAllowanceManagerCollection) {
        this.employeeAllowanceManagerCollection = employeeAllowanceManagerCollection;
    }

    @XmlTransient
    public Collection<WelfarePaymentSchedule> getWelfarePaymentScheduleCollection() {
        return welfarePaymentScheduleCollection;
    }

    public void setWelfarePaymentScheduleCollection(Collection<WelfarePaymentSchedule> welfarePaymentScheduleCollection) {
        this.welfarePaymentScheduleCollection = welfarePaymentScheduleCollection;
    }

    @XmlTransient
    public Collection<Seller> getSellerCollection() {
        return sellerCollection;
    }

    public void setSellerCollection(Collection<Seller> sellerCollection) {
        this.sellerCollection = sellerCollection;
    }

    @XmlTransient
    public Collection<ConstructionSiteEmployeeSafty> getConstructionSiteEmployeeSaftyCollection() {
        return constructionSiteEmployeeSaftyCollection;
    }

    public void setConstructionSiteEmployeeSaftyCollection(Collection<ConstructionSiteEmployeeSafty> constructionSiteEmployeeSaftyCollection) {
        this.constructionSiteEmployeeSaftyCollection = constructionSiteEmployeeSaftyCollection;
    }

    @XmlTransient
    public Collection<ComItemApproval> getComItemApprovalCollection() {
        return comItemApprovalCollection;
    }

    public void setComItemApprovalCollection(Collection<ComItemApproval> comItemApprovalCollection) {
        this.comItemApprovalCollection = comItemApprovalCollection;
    }

    @XmlTransient
    public Collection<EmployeeContractDetails> getEmployeeContractDetailsCollection() {
        return employeeContractDetailsCollection;
    }

    public void setEmployeeContractDetailsCollection(Collection<EmployeeContractDetails> employeeContractDetailsCollection) {
        this.employeeContractDetailsCollection = employeeContractDetailsCollection;
    }

    @XmlTransient
    public Collection<AdvanceRequest> getAdvanceRequestCollection() {
        return advanceRequestCollection;
    }

    public void setAdvanceRequestCollection(Collection<AdvanceRequest> advanceRequestCollection) {
        this.advanceRequestCollection = advanceRequestCollection;
    }

    @XmlTransient
    public Collection<GatePass> getGatePassCollection() {
        return gatePassCollection;
    }

    public void setGatePassCollection(Collection<GatePass> gatePassCollection) {
        this.gatePassCollection = gatePassCollection;
    }

    @XmlTransient
    public Collection<Quotation> getQuotationCollection() {
        return quotationCollection;
    }

    public void setQuotationCollection(Collection<Quotation> quotationCollection) {
        this.quotationCollection = quotationCollection;
    }

    @XmlTransient
    public Collection<Quotation> getQuotationCollection1() {
        return quotationCollection1;
    }

    public void setQuotationCollection1(Collection<Quotation> quotationCollection1) {
        this.quotationCollection1 = quotationCollection1;
    }

    @XmlTransient
    public Collection<AtendenceRegistry> getAtendenceRegistryCollection() {
        return atendenceRegistryCollection;
    }

    public void setAtendenceRegistryCollection(Collection<AtendenceRegistry> atendenceRegistryCollection) {
        this.atendenceRegistryCollection = atendenceRegistryCollection;
    }

    @XmlTransient
    public Collection<RouteEmployee> getRouteEmployeeCollection() {
        return routeEmployeeCollection;
    }

    public void setRouteEmployeeCollection(Collection<RouteEmployee> routeEmployeeCollection) {
        this.routeEmployeeCollection = routeEmployeeCollection;
    }

    @XmlTransient
    public Collection<EmployeePermanentDateExtendedHistory> getEmployeePermanentDateExtendedHistoryCollection() {
        return employeePermanentDateExtendedHistoryCollection;
    }

    public void setEmployeePermanentDateExtendedHistoryCollection(Collection<EmployeePermanentDateExtendedHistory> employeePermanentDateExtendedHistoryCollection) {
        this.employeePermanentDateExtendedHistoryCollection = employeePermanentDateExtendedHistoryCollection;
    }

    @XmlTransient
    public Collection<EmployeePermanentDateExtendedHistory> getEmployeePermanentDateExtendedHistoryCollection1() {
        return employeePermanentDateExtendedHistoryCollection1;
    }

    public void setEmployeePermanentDateExtendedHistoryCollection1(Collection<EmployeePermanentDateExtendedHistory> employeePermanentDateExtendedHistoryCollection1) {
        this.employeePermanentDateExtendedHistoryCollection1 = employeePermanentDateExtendedHistoryCollection1;
    }

    @XmlTransient
    public Collection<LoanApproval> getLoanApprovalCollection() {
        return loanApprovalCollection;
    }

    public void setLoanApprovalCollection(Collection<LoanApproval> loanApprovalCollection) {
        this.loanApprovalCollection = loanApprovalCollection;
    }

    @XmlTransient
    public Collection<ProductionAdvice> getProductionAdviceCollection() {
        return productionAdviceCollection;
    }

    public void setProductionAdviceCollection(Collection<ProductionAdvice> productionAdviceCollection) {
        this.productionAdviceCollection = productionAdviceCollection;
    }

    @XmlTransient
    public Collection<RouteCollectedLeafRemovedLog> getRouteCollectedLeafRemovedLogCollection() {
        return routeCollectedLeafRemovedLogCollection;
    }

    public void setRouteCollectedLeafRemovedLogCollection(Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection) {
        this.routeCollectedLeafRemovedLogCollection = routeCollectedLeafRemovedLogCollection;
    }

    @XmlTransient
    public Collection<RouteCollectedLeafRemovedLog> getRouteCollectedLeafRemovedLogCollection1() {
        return routeCollectedLeafRemovedLogCollection1;
    }

    public void setRouteCollectedLeafRemovedLogCollection1(Collection<RouteCollectedLeafRemovedLog> routeCollectedLeafRemovedLogCollection1) {
        this.routeCollectedLeafRemovedLogCollection1 = routeCollectedLeafRemovedLogCollection1;
    }

    @XmlTransient
    public Collection<VoucherInactiveApprove> getVoucherInactiveApproveCollection() {
        return voucherInactiveApproveCollection;
    }

    public void setVoucherInactiveApproveCollection(Collection<VoucherInactiveApprove> voucherInactiveApproveCollection) {
        this.voucherInactiveApproveCollection = voucherInactiveApproveCollection;
    }

    @XmlTransient
    public Collection<LoanTransferForApproval> getLoanTransferForApprovalCollection() {
        return loanTransferForApprovalCollection;
    }

    public void setLoanTransferForApprovalCollection(Collection<LoanTransferForApproval> loanTransferForApprovalCollection) {
        this.loanTransferForApprovalCollection = loanTransferForApprovalCollection;
    }

    @XmlTransient
    public Collection<EmployeeWorkmanCompensation> getEmployeeWorkmanCompensationCollection() {
        return employeeWorkmanCompensationCollection;
    }

    public void setEmployeeWorkmanCompensationCollection(Collection<EmployeeWorkmanCompensation> employeeWorkmanCompensationCollection) {
        this.employeeWorkmanCompensationCollection = employeeWorkmanCompensationCollection;
    }

    @XmlTransient
    public Collection<SellerPriceChangedHistory> getSellerPriceChangedHistoryCollection() {
        return sellerPriceChangedHistoryCollection;
    }

    public void setSellerPriceChangedHistoryCollection(Collection<SellerPriceChangedHistory> sellerPriceChangedHistoryCollection) {
        this.sellerPriceChangedHistoryCollection = sellerPriceChangedHistoryCollection;
    }

    @XmlTransient
    public Collection<EmployeePaymentDetails> getEmployeePaymentDetailsCollection() {
        return employeePaymentDetailsCollection;
    }

    public void setEmployeePaymentDetailsCollection(Collection<EmployeePaymentDetails> employeePaymentDetailsCollection) {
        this.employeePaymentDetailsCollection = employeePaymentDetailsCollection;
    }

    @XmlTransient
    public Collection<ComRequistedItemIssue> getComRequistedItemIssueCollection() {
        return comRequistedItemIssueCollection;
    }

    public void setComRequistedItemIssueCollection(Collection<ComRequistedItemIssue> comRequistedItemIssueCollection) {
        this.comRequistedItemIssueCollection = comRequistedItemIssueCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceRequestIssuing> getSupplierAdvanceRequestIssuingCollection() {
        return supplierAdvanceRequestIssuingCollection;
    }

    public void setSupplierAdvanceRequestIssuingCollection(Collection<SupplierAdvanceRequestIssuing> supplierAdvanceRequestIssuingCollection) {
        this.supplierAdvanceRequestIssuingCollection = supplierAdvanceRequestIssuingCollection;
    }

    @XmlTransient
    public Collection<WorkedHistory> getWorkedHistoryCollection() {
        return workedHistoryCollection;
    }

    public void setWorkedHistoryCollection(Collection<WorkedHistory> workedHistoryCollection) {
        this.workedHistoryCollection = workedHistoryCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemDeliveryDetails> getUniversalBoughtleafItemDeliveryDetailsCollection() {
        return universalBoughtleafItemDeliveryDetailsCollection;
    }

    public void setUniversalBoughtleafItemDeliveryDetailsCollection(Collection<UniversalBoughtleafItemDeliveryDetails> universalBoughtleafItemDeliveryDetailsCollection) {
        this.universalBoughtleafItemDeliveryDetailsCollection = universalBoughtleafItemDeliveryDetailsCollection;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Employee[ id=" + id + " ]";
    }
    
}
