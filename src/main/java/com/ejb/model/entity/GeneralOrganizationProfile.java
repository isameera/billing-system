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
@Table(name = "general_organization_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GeneralOrganizationProfile.findAll", query = "SELECT g FROM GeneralOrganizationProfile g")
    , @NamedQuery(name = "GeneralOrganizationProfile.findById", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.id = :id")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByCode", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.code = :code")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByName", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.name = :name")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByAddress1", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.address1 = :address1")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByAddress2", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.address2 = :address2")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByAddress3", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.address3 = :address3")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByEmail", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.email = :email")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByPhone", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.phone = :phone")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByPhoneOther", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.phoneOther = :phoneOther")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByVision", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.vision = :vision")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByMision", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.mision = :mision")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByRegistrationNo", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.registrationNo = :registrationNo")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByWebsite", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.website = :website")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByFax", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.fax = :fax")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByObjectives", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.objectives = :objectives")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByMoto", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.moto = :moto")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByLogo", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.logo = :logo")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByHeader", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.header = :header")
    , @NamedQuery(name = "GeneralOrganizationProfile.findByPostalCode", query = "SELECT g FROM GeneralOrganizationProfile g WHERE g.postalCode = :postalCode")})
public class GeneralOrganizationProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 450)
    @Column(name = "address3")
    private String address3;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Size(max = 45)
    @Column(name = "phone_other")
    private String phoneOther;
    @Size(max = 45)
    @Column(name = "vision")
    private String vision;
    @Size(max = 45)
    @Column(name = "mision")
    private String mision;
    @Size(max = 45)
    @Column(name = "registration_no")
    private String registrationNo;
    @Size(max = 45)
    @Column(name = "website")
    private String website;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "fax")
    private String fax;
    @Size(max = 45)
    @Column(name = "objectives")
    private String objectives;
    @Size(max = 45)
    @Column(name = "moto")
    private String moto;
    @Size(max = 45)
    @Column(name = "logo")
    private String logo;
    @Size(max = 45)
    @Column(name = "header")
    private String header;
    @Size(max = 45)
    @Column(name = "postal_code")
    private String postalCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SellingMark> sellingMarkCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<TimeLine> timeLineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Building> buildingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LeafFinalPaymentRateByRoute> leafFinalPaymentRateByRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<InventoryController> inventoryControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<CompanyMonthlyWorkdays> companyMonthlyWorkdaysCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgItemClass> orgItemClassCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SecurityActivityLog> securityActivityLogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ChequeDetails> chequeDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<EmployeeTypeDeductionRate> employeeTypeDeductionRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<FinanceYear> financeYearCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LeafPackgeWeight> leafPackgeWeightCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Route> routeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<EmployeeMonthlySalaryHistory> employeeMonthlySalaryHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SocialMediaProfilePageByOrg> socialMediaProfilePageByOrgCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgEmployeeType> orgEmployeeTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<TimeTable> timeTableCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ComItemRequest> comItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteId")
    private Collection<ComItemRequest> comItemRequestCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LoginSession> loginSessionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<VehicleGopManager> vehicleGopManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<VoucherTotalManager> voucherTotalManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<NotificationController> notificationControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<RecurantExpenses> recurantExpensesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Voucher> voucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Post> postCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<TeaStock> teaStockCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgBankAccount> orgBankAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<TeaRateManager> teaRateManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<FactoryMatchRate> factoryMatchRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LabourDistribution> labourDistributionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<DesignationLevelUserManager> designationLevelUserManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgSocialMediaProfilePage> orgSocialMediaProfilePageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ReceivedCheques> receivedChequesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SubChartOfAccount> subChartOfAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SocialMediaGroup> socialMediaGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UniversalRateSettings> universalRateSettingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrganizationTypeManager> organizationTypeManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId1")
    private Collection<OrganizationTypeManager> organizationTypeManagerCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Magazine> magazineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileIdGop")
    private Collection<GeneralUserProfile> generalUserProfileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgItemModel> orgItemModelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<CenterCourseManager> centerCourseManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ItemPackaging> itemPackagingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "packReceivedBy")
    private Collection<ItemPackaging> itemPackagingCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ProductionTeaBook> productionTeaBookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<MonthlyProductionPlan> monthlyProductionPlanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repairedBy")
    private Collection<VehicleInsuranceClame> vehicleInsuranceClameCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgUserManager> orgUserManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LeafCollectionMaster> leafCollectionMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgDepartments> orgDepartmentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Stamp> stampCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LeafMatchRateByRoute> leafMatchRateByRouteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maintenanceBy")
    private Collection<VehicleMaintenanceHistory> vehicleMaintenanceHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgMainChartOfAccount> orgMainChartOfAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<FactoryCurrentMonth> factoryCurrentMonthCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<SocialMediaEvents> socialMediaEventsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LoanMaster> loanMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UserDocument> userDocumentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<GupGopManager> gupGopManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<WorkShiftManagerIso> workShiftManagerIsoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OpeningBalances> openingBalancesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<GeneralJournalEntry> generalJournalEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<BrancheOfTheBank> brancheOfTheBankCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<TeaFactoryItemInstallment> teaFactoryItemInstallmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Employee> employeeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgDesignation> orgDesignationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<StudentCourseMaster> studentCourseMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<FamilyMembers> familyMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgItemCategory> orgItemCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<JobCard> jobCardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<DeliveryNote> deliveryNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<EmployeeSalaryIncrementHistory> employeeSalaryIncrementHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgEmployeeCategory> orgEmployeeCategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LeaveType> leaveTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<AwardingBody> awardingBodyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SupplierAdvanceTransferRequest> supplierAdvanceTransferRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<HolidayPayRegister> holidayPayRegisterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SerialNo> serialNoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<InterfaceMenuGopManager> interfaceMenuGopManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<RequestPurchaseOrderSiteManager> requestPurchaseOrderSiteManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<TemporaryJob> temporaryJobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<EmployeeCommonSettings> employeeCommonSettingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ConstructionContract> constructionContractCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgAccountType> orgAccountTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<VoucherItemInactive> voucherItemInactiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<EmployeeItemLocation> employeeItemLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgInterfaceDualEntry> orgInterfaceDualEntryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<EmployeeAllowanceManager> employeeAllowanceManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<WelfarePaymentSchedule> welfarePaymentScheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Seller> sellerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<DocumentMaster> documentMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ItemSupplier> itemSupplierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<DeliveryAcceptanceNote> deliveryAcceptanceNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<BlRateSettings> blRateSettingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgSystemInterfaceController> orgSystemInterfaceControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UserLoginGroup> userLoginGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderFrom")
    private Collection<OrderMaster> orderMasterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderTo")
    private Collection<OrderMaster> orderMasterCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<Batch> batchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgLocation> orgLocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<CollectionTarget> collectionTargetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<FactoryCollectedLeaf> factoryCollectedLeafCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<JournalEntryReport> journalEntryReportCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ProductionRequest> productionRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgItemType> orgItemTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<FingerPrintMachine> fingerPrintMachineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<VehicleInsurance> vehicleInsuranceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgCategoryManager> orgCategoryManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<GopCoaManager> gopCoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<GatePass> gatePassCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<AtendenceRegistry> atendenceRegistryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UniversalSettingsManager> universalSettingsManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ItemCategoryTypeController> itemCategoryTypeControllerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<AttendenceAllowanceRate> attendenceAllowanceRateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgCoaManager> orgCoaManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<CashSettlementHistory> cashSettlementHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UserLogin> userLoginCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ProductBatchManager> productBatchManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<WorkShift> workShiftCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<LeafRateManager> leafRateManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UseCaseHasUserRole> useCaseHasUserRoleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<RouteTransportRateHistory> routeTransportRateHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UniversalBasicSalaryCalculation> universalBasicSalaryCalculationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ProductionAdvice> productionAdviceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<CooperatSupplier> cooperatSupplierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SupplierRegistration> supplierRegistrationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgChartOfAccount> orgChartOfAccountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<VoucherItem> voucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<HelpTicket> helpTicketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<CompanyHolidayScheduler> companyHolidaySchedulerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OtRateController> otRateControllerCollection;
    @JoinColumn(name = "country_id_c", referencedColumnName = "id")
    @ManyToOne
    private Country countryIdC;
    @JoinColumn(name = "organization_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrganizationType organizationTypeId;
    @JoinColumn(name = "registration_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private RegistrationType registrationTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<DealingCompanies> dealingCompaniesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentRecever")
    private Collection<PaymentHistory> paymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<ItemGrading> itemGradingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SupplierPassbook> supplierPassbookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<DesignationLevelManager> designationLevelManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<PropertyArea> propertyAreaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<UploadedFileManager> uploadedFileManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgWorkingSection> orgWorkingSectionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgTaxCategoryManager> orgTaxCategoryManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<StockHistoryManager> stockHistoryManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgUnitOfMeasure> orgUnitOfMeasureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<HolidayPayWorkDays> holidayPayWorkDaysCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<WorkedHistory> workedHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgDesignationGrade> orgDesignationGradeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<TransactionManagement> transactionManagementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<SchoolsAttended> schoolsAttendedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalOrganizationProfileId")
    private Collection<OrgDesignationLevel> orgDesignationLevelCollection;

    public GeneralOrganizationProfile() {
    }

    public GeneralOrganizationProfile(Integer id) {
        this.id = id;
    }

    public GeneralOrganizationProfile(Integer id, String name, String address1, String address2, String address3, String phone) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneOther() {
        return phoneOther;
    }

    public void setPhoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @XmlTransient
    public Collection<SellingMark> getSellingMarkCollection() {
        return sellingMarkCollection;
    }

    public void setSellingMarkCollection(Collection<SellingMark> sellingMarkCollection) {
        this.sellingMarkCollection = sellingMarkCollection;
    }

    @XmlTransient
    public Collection<TimeLine> getTimeLineCollection() {
        return timeLineCollection;
    }

    public void setTimeLineCollection(Collection<TimeLine> timeLineCollection) {
        this.timeLineCollection = timeLineCollection;
    }

    @XmlTransient
    public Collection<Building> getBuildingCollection() {
        return buildingCollection;
    }

    public void setBuildingCollection(Collection<Building> buildingCollection) {
        this.buildingCollection = buildingCollection;
    }

    @XmlTransient
    public Collection<LeafFinalPaymentRateByRoute> getLeafFinalPaymentRateByRouteCollection() {
        return leafFinalPaymentRateByRouteCollection;
    }

    public void setLeafFinalPaymentRateByRouteCollection(Collection<LeafFinalPaymentRateByRoute> leafFinalPaymentRateByRouteCollection) {
        this.leafFinalPaymentRateByRouteCollection = leafFinalPaymentRateByRouteCollection;
    }

    @XmlTransient
    public Collection<InventoryController> getInventoryControllerCollection() {
        return inventoryControllerCollection;
    }

    public void setInventoryControllerCollection(Collection<InventoryController> inventoryControllerCollection) {
        this.inventoryControllerCollection = inventoryControllerCollection;
    }

    @XmlTransient
    public Collection<CompanyMonthlyWorkdays> getCompanyMonthlyWorkdaysCollection() {
        return companyMonthlyWorkdaysCollection;
    }

    public void setCompanyMonthlyWorkdaysCollection(Collection<CompanyMonthlyWorkdays> companyMonthlyWorkdaysCollection) {
        this.companyMonthlyWorkdaysCollection = companyMonthlyWorkdaysCollection;
    }

    @XmlTransient
    public Collection<OrgItemClass> getOrgItemClassCollection() {
        return orgItemClassCollection;
    }

    public void setOrgItemClassCollection(Collection<OrgItemClass> orgItemClassCollection) {
        this.orgItemClassCollection = orgItemClassCollection;
    }

    @XmlTransient
    public Collection<SecurityActivityLog> getSecurityActivityLogCollection() {
        return securityActivityLogCollection;
    }

    public void setSecurityActivityLogCollection(Collection<SecurityActivityLog> securityActivityLogCollection) {
        this.securityActivityLogCollection = securityActivityLogCollection;
    }

    @XmlTransient
    public Collection<ChequeDetails> getChequeDetailsCollection() {
        return chequeDetailsCollection;
    }

    public void setChequeDetailsCollection(Collection<ChequeDetails> chequeDetailsCollection) {
        this.chequeDetailsCollection = chequeDetailsCollection;
    }

    @XmlTransient
    public Collection<EmployeeTypeDeductionRate> getEmployeeTypeDeductionRateCollection() {
        return employeeTypeDeductionRateCollection;
    }

    public void setEmployeeTypeDeductionRateCollection(Collection<EmployeeTypeDeductionRate> employeeTypeDeductionRateCollection) {
        this.employeeTypeDeductionRateCollection = employeeTypeDeductionRateCollection;
    }

    @XmlTransient
    public Collection<FinanceYear> getFinanceYearCollection() {
        return financeYearCollection;
    }

    public void setFinanceYearCollection(Collection<FinanceYear> financeYearCollection) {
        this.financeYearCollection = financeYearCollection;
    }

    @XmlTransient
    public Collection<LeafPackgeWeight> getLeafPackgeWeightCollection() {
        return leafPackgeWeightCollection;
    }

    public void setLeafPackgeWeightCollection(Collection<LeafPackgeWeight> leafPackgeWeightCollection) {
        this.leafPackgeWeightCollection = leafPackgeWeightCollection;
    }

    @XmlTransient
    public Collection<Route> getRouteCollection() {
        return routeCollection;
    }

    public void setRouteCollection(Collection<Route> routeCollection) {
        this.routeCollection = routeCollection;
    }

    @XmlTransient
    public Collection<EmployeeMonthlySalaryHistory> getEmployeeMonthlySalaryHistoryCollection() {
        return employeeMonthlySalaryHistoryCollection;
    }

    public void setEmployeeMonthlySalaryHistoryCollection(Collection<EmployeeMonthlySalaryHistory> employeeMonthlySalaryHistoryCollection) {
        this.employeeMonthlySalaryHistoryCollection = employeeMonthlySalaryHistoryCollection;
    }

    @XmlTransient
    public Collection<SocialMediaProfilePageByOrg> getSocialMediaProfilePageByOrgCollection() {
        return socialMediaProfilePageByOrgCollection;
    }

    public void setSocialMediaProfilePageByOrgCollection(Collection<SocialMediaProfilePageByOrg> socialMediaProfilePageByOrgCollection) {
        this.socialMediaProfilePageByOrgCollection = socialMediaProfilePageByOrgCollection;
    }

    @XmlTransient
    public Collection<OrgEmployeeType> getOrgEmployeeTypeCollection() {
        return orgEmployeeTypeCollection;
    }

    public void setOrgEmployeeTypeCollection(Collection<OrgEmployeeType> orgEmployeeTypeCollection) {
        this.orgEmployeeTypeCollection = orgEmployeeTypeCollection;
    }

    @XmlTransient
    public Collection<TimeTable> getTimeTableCollection() {
        return timeTableCollection;
    }

    public void setTimeTableCollection(Collection<TimeTable> timeTableCollection) {
        this.timeTableCollection = timeTableCollection;
    }

    @XmlTransient
    public Collection<ComItemRequest> getComItemRequestCollection() {
        return comItemRequestCollection;
    }

    public void setComItemRequestCollection(Collection<ComItemRequest> comItemRequestCollection) {
        this.comItemRequestCollection = comItemRequestCollection;
    }

    @XmlTransient
    public Collection<ComItemRequest> getComItemRequestCollection1() {
        return comItemRequestCollection1;
    }

    public void setComItemRequestCollection1(Collection<ComItemRequest> comItemRequestCollection1) {
        this.comItemRequestCollection1 = comItemRequestCollection1;
    }

    @XmlTransient
    public Collection<LoginSession> getLoginSessionCollection() {
        return loginSessionCollection;
    }

    public void setLoginSessionCollection(Collection<LoginSession> loginSessionCollection) {
        this.loginSessionCollection = loginSessionCollection;
    }

    @XmlTransient
    public Collection<VehicleGopManager> getVehicleGopManagerCollection() {
        return vehicleGopManagerCollection;
    }

    public void setVehicleGopManagerCollection(Collection<VehicleGopManager> vehicleGopManagerCollection) {
        this.vehicleGopManagerCollection = vehicleGopManagerCollection;
    }

    @XmlTransient
    public Collection<VoucherTotalManager> getVoucherTotalManagerCollection() {
        return voucherTotalManagerCollection;
    }

    public void setVoucherTotalManagerCollection(Collection<VoucherTotalManager> voucherTotalManagerCollection) {
        this.voucherTotalManagerCollection = voucherTotalManagerCollection;
    }

    @XmlTransient
    public Collection<NotificationController> getNotificationControllerCollection() {
        return notificationControllerCollection;
    }

    public void setNotificationControllerCollection(Collection<NotificationController> notificationControllerCollection) {
        this.notificationControllerCollection = notificationControllerCollection;
    }

    @XmlTransient
    public Collection<RecurantExpenses> getRecurantExpensesCollection() {
        return recurantExpensesCollection;
    }

    public void setRecurantExpensesCollection(Collection<RecurantExpenses> recurantExpensesCollection) {
        this.recurantExpensesCollection = recurantExpensesCollection;
    }

    @XmlTransient
    public Collection<Voucher> getVoucherCollection() {
        return voucherCollection;
    }

    public void setVoucherCollection(Collection<Voucher> voucherCollection) {
        this.voucherCollection = voucherCollection;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    @XmlTransient
    public Collection<TeaStock> getTeaStockCollection() {
        return teaStockCollection;
    }

    public void setTeaStockCollection(Collection<TeaStock> teaStockCollection) {
        this.teaStockCollection = teaStockCollection;
    }

    @XmlTransient
    public Collection<OrgBankAccount> getOrgBankAccountCollection() {
        return orgBankAccountCollection;
    }

    public void setOrgBankAccountCollection(Collection<OrgBankAccount> orgBankAccountCollection) {
        this.orgBankAccountCollection = orgBankAccountCollection;
    }

    @XmlTransient
    public Collection<TeaRateManager> getTeaRateManagerCollection() {
        return teaRateManagerCollection;
    }

    public void setTeaRateManagerCollection(Collection<TeaRateManager> teaRateManagerCollection) {
        this.teaRateManagerCollection = teaRateManagerCollection;
    }

    @XmlTransient
    public Collection<FactoryMatchRate> getFactoryMatchRateCollection() {
        return factoryMatchRateCollection;
    }

    public void setFactoryMatchRateCollection(Collection<FactoryMatchRate> factoryMatchRateCollection) {
        this.factoryMatchRateCollection = factoryMatchRateCollection;
    }

    @XmlTransient
    public Collection<LabourDistribution> getLabourDistributionCollection() {
        return labourDistributionCollection;
    }

    public void setLabourDistributionCollection(Collection<LabourDistribution> labourDistributionCollection) {
        this.labourDistributionCollection = labourDistributionCollection;
    }

    @XmlTransient
    public Collection<DesignationLevelUserManager> getDesignationLevelUserManagerCollection() {
        return designationLevelUserManagerCollection;
    }

    public void setDesignationLevelUserManagerCollection(Collection<DesignationLevelUserManager> designationLevelUserManagerCollection) {
        this.designationLevelUserManagerCollection = designationLevelUserManagerCollection;
    }

    @XmlTransient
    public Collection<OrgSocialMediaProfilePage> getOrgSocialMediaProfilePageCollection() {
        return orgSocialMediaProfilePageCollection;
    }

    public void setOrgSocialMediaProfilePageCollection(Collection<OrgSocialMediaProfilePage> orgSocialMediaProfilePageCollection) {
        this.orgSocialMediaProfilePageCollection = orgSocialMediaProfilePageCollection;
    }

    @XmlTransient
    public Collection<ReceivedCheques> getReceivedChequesCollection() {
        return receivedChequesCollection;
    }

    public void setReceivedChequesCollection(Collection<ReceivedCheques> receivedChequesCollection) {
        this.receivedChequesCollection = receivedChequesCollection;
    }

    @XmlTransient
    public Collection<SubChartOfAccount> getSubChartOfAccountCollection() {
        return subChartOfAccountCollection;
    }

    public void setSubChartOfAccountCollection(Collection<SubChartOfAccount> subChartOfAccountCollection) {
        this.subChartOfAccountCollection = subChartOfAccountCollection;
    }

    @XmlTransient
    public Collection<SocialMediaGroup> getSocialMediaGroupCollection() {
        return socialMediaGroupCollection;
    }

    public void setSocialMediaGroupCollection(Collection<SocialMediaGroup> socialMediaGroupCollection) {
        this.socialMediaGroupCollection = socialMediaGroupCollection;
    }

    @XmlTransient
    public Collection<UniversalRateSettings> getUniversalRateSettingsCollection() {
        return universalRateSettingsCollection;
    }

    public void setUniversalRateSettingsCollection(Collection<UniversalRateSettings> universalRateSettingsCollection) {
        this.universalRateSettingsCollection = universalRateSettingsCollection;
    }

    @XmlTransient
    public Collection<OrganizationTypeManager> getOrganizationTypeManagerCollection() {
        return organizationTypeManagerCollection;
    }

    public void setOrganizationTypeManagerCollection(Collection<OrganizationTypeManager> organizationTypeManagerCollection) {
        this.organizationTypeManagerCollection = organizationTypeManagerCollection;
    }

    @XmlTransient
    public Collection<OrganizationTypeManager> getOrganizationTypeManagerCollection1() {
        return organizationTypeManagerCollection1;
    }

    public void setOrganizationTypeManagerCollection1(Collection<OrganizationTypeManager> organizationTypeManagerCollection1) {
        this.organizationTypeManagerCollection1 = organizationTypeManagerCollection1;
    }

    @XmlTransient
    public Collection<Magazine> getMagazineCollection() {
        return magazineCollection;
    }

    public void setMagazineCollection(Collection<Magazine> magazineCollection) {
        this.magazineCollection = magazineCollection;
    }

    @XmlTransient
    public Collection<GeneralUserProfile> getGeneralUserProfileCollection() {
        return generalUserProfileCollection;
    }

    public void setGeneralUserProfileCollection(Collection<GeneralUserProfile> generalUserProfileCollection) {
        this.generalUserProfileCollection = generalUserProfileCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequest> getUniversalBoughtleafItemRequestCollection() {
        return universalBoughtleafItemRequestCollection;
    }

    public void setUniversalBoughtleafItemRequestCollection(Collection<UniversalBoughtleafItemRequest> universalBoughtleafItemRequestCollection) {
        this.universalBoughtleafItemRequestCollection = universalBoughtleafItemRequestCollection;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistory> getUniversalOrgPersonFinancialHistoryCollection() {
        return universalOrgPersonFinancialHistoryCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryCollection(Collection<UniversalOrgPersonFinancialHistory> universalOrgPersonFinancialHistoryCollection) {
        this.universalOrgPersonFinancialHistoryCollection = universalOrgPersonFinancialHistoryCollection;
    }

    @XmlTransient
    public Collection<OrgItemModel> getOrgItemModelCollection() {
        return orgItemModelCollection;
    }

    public void setOrgItemModelCollection(Collection<OrgItemModel> orgItemModelCollection) {
        this.orgItemModelCollection = orgItemModelCollection;
    }

    @XmlTransient
    public Collection<CenterCourseManager> getCenterCourseManagerCollection() {
        return centerCourseManagerCollection;
    }

    public void setCenterCourseManagerCollection(Collection<CenterCourseManager> centerCourseManagerCollection) {
        this.centerCourseManagerCollection = centerCourseManagerCollection;
    }

    @XmlTransient
    public Collection<ItemPackaging> getItemPackagingCollection() {
        return itemPackagingCollection;
    }

    public void setItemPackagingCollection(Collection<ItemPackaging> itemPackagingCollection) {
        this.itemPackagingCollection = itemPackagingCollection;
    }

    @XmlTransient
    public Collection<ItemPackaging> getItemPackagingCollection1() {
        return itemPackagingCollection1;
    }

    public void setItemPackagingCollection1(Collection<ItemPackaging> itemPackagingCollection1) {
        this.itemPackagingCollection1 = itemPackagingCollection1;
    }

    @XmlTransient
    public Collection<ProductionTeaBook> getProductionTeaBookCollection() {
        return productionTeaBookCollection;
    }

    public void setProductionTeaBookCollection(Collection<ProductionTeaBook> productionTeaBookCollection) {
        this.productionTeaBookCollection = productionTeaBookCollection;
    }

    @XmlTransient
    public Collection<MonthlyProductionPlan> getMonthlyProductionPlanCollection() {
        return monthlyProductionPlanCollection;
    }

    public void setMonthlyProductionPlanCollection(Collection<MonthlyProductionPlan> monthlyProductionPlanCollection) {
        this.monthlyProductionPlanCollection = monthlyProductionPlanCollection;
    }

    @XmlTransient
    public Collection<VehicleInsuranceClame> getVehicleInsuranceClameCollection() {
        return vehicleInsuranceClameCollection;
    }

    public void setVehicleInsuranceClameCollection(Collection<VehicleInsuranceClame> vehicleInsuranceClameCollection) {
        this.vehicleInsuranceClameCollection = vehicleInsuranceClameCollection;
    }

    @XmlTransient
    public Collection<OrgUserManager> getOrgUserManagerCollection() {
        return orgUserManagerCollection;
    }

    public void setOrgUserManagerCollection(Collection<OrgUserManager> orgUserManagerCollection) {
        this.orgUserManagerCollection = orgUserManagerCollection;
    }

    @XmlTransient
    public Collection<LeafCollectionMaster> getLeafCollectionMasterCollection() {
        return leafCollectionMasterCollection;
    }

    public void setLeafCollectionMasterCollection(Collection<LeafCollectionMaster> leafCollectionMasterCollection) {
        this.leafCollectionMasterCollection = leafCollectionMasterCollection;
    }

    @XmlTransient
    public Collection<OrgDepartments> getOrgDepartmentsCollection() {
        return orgDepartmentsCollection;
    }

    public void setOrgDepartmentsCollection(Collection<OrgDepartments> orgDepartmentsCollection) {
        this.orgDepartmentsCollection = orgDepartmentsCollection;
    }

    @XmlTransient
    public Collection<Stamp> getStampCollection() {
        return stampCollection;
    }

    public void setStampCollection(Collection<Stamp> stampCollection) {
        this.stampCollection = stampCollection;
    }

    @XmlTransient
    public Collection<LeafMatchRateByRoute> getLeafMatchRateByRouteCollection() {
        return leafMatchRateByRouteCollection;
    }

    public void setLeafMatchRateByRouteCollection(Collection<LeafMatchRateByRoute> leafMatchRateByRouteCollection) {
        this.leafMatchRateByRouteCollection = leafMatchRateByRouteCollection;
    }

    @XmlTransient
    public Collection<VehicleMaintenanceHistory> getVehicleMaintenanceHistoryCollection() {
        return vehicleMaintenanceHistoryCollection;
    }

    public void setVehicleMaintenanceHistoryCollection(Collection<VehicleMaintenanceHistory> vehicleMaintenanceHistoryCollection) {
        this.vehicleMaintenanceHistoryCollection = vehicleMaintenanceHistoryCollection;
    }

    @XmlTransient
    public Collection<OrgMainChartOfAccount> getOrgMainChartOfAccountCollection() {
        return orgMainChartOfAccountCollection;
    }

    public void setOrgMainChartOfAccountCollection(Collection<OrgMainChartOfAccount> orgMainChartOfAccountCollection) {
        this.orgMainChartOfAccountCollection = orgMainChartOfAccountCollection;
    }

    @XmlTransient
    public Collection<FactoryCurrentMonth> getFactoryCurrentMonthCollection() {
        return factoryCurrentMonthCollection;
    }

    public void setFactoryCurrentMonthCollection(Collection<FactoryCurrentMonth> factoryCurrentMonthCollection) {
        this.factoryCurrentMonthCollection = factoryCurrentMonthCollection;
    }

    @XmlTransient
    public Collection<SocialMediaEvents> getSocialMediaEventsCollection() {
        return socialMediaEventsCollection;
    }

    public void setSocialMediaEventsCollection(Collection<SocialMediaEvents> socialMediaEventsCollection) {
        this.socialMediaEventsCollection = socialMediaEventsCollection;
    }

    @XmlTransient
    public Collection<LoanMaster> getLoanMasterCollection() {
        return loanMasterCollection;
    }

    public void setLoanMasterCollection(Collection<LoanMaster> loanMasterCollection) {
        this.loanMasterCollection = loanMasterCollection;
    }

    @XmlTransient
    public Collection<UserDocument> getUserDocumentCollection() {
        return userDocumentCollection;
    }

    public void setUserDocumentCollection(Collection<UserDocument> userDocumentCollection) {
        this.userDocumentCollection = userDocumentCollection;
    }

    @XmlTransient
    public Collection<GupGopManager> getGupGopManagerCollection() {
        return gupGopManagerCollection;
    }

    public void setGupGopManagerCollection(Collection<GupGopManager> gupGopManagerCollection) {
        this.gupGopManagerCollection = gupGopManagerCollection;
    }

    @XmlTransient
    public Collection<WorkShiftManagerIso> getWorkShiftManagerIsoCollection() {
        return workShiftManagerIsoCollection;
    }

    public void setWorkShiftManagerIsoCollection(Collection<WorkShiftManagerIso> workShiftManagerIsoCollection) {
        this.workShiftManagerIsoCollection = workShiftManagerIsoCollection;
    }

    @XmlTransient
    public Collection<OpeningBalances> getOpeningBalancesCollection() {
        return openingBalancesCollection;
    }

    public void setOpeningBalancesCollection(Collection<OpeningBalances> openingBalancesCollection) {
        this.openingBalancesCollection = openingBalancesCollection;
    }

    @XmlTransient
    public Collection<GeneralJournalEntry> getGeneralJournalEntryCollection() {
        return generalJournalEntryCollection;
    }

    public void setGeneralJournalEntryCollection(Collection<GeneralJournalEntry> generalJournalEntryCollection) {
        this.generalJournalEntryCollection = generalJournalEntryCollection;
    }

    @XmlTransient
    public Collection<BrancheOfTheBank> getBrancheOfTheBankCollection() {
        return brancheOfTheBankCollection;
    }

    public void setBrancheOfTheBankCollection(Collection<BrancheOfTheBank> brancheOfTheBankCollection) {
        this.brancheOfTheBankCollection = brancheOfTheBankCollection;
    }

    @XmlTransient
    public Collection<TeaFactoryItemInstallment> getTeaFactoryItemInstallmentCollection() {
        return teaFactoryItemInstallmentCollection;
    }

    public void setTeaFactoryItemInstallmentCollection(Collection<TeaFactoryItemInstallment> teaFactoryItemInstallmentCollection) {
        this.teaFactoryItemInstallmentCollection = teaFactoryItemInstallmentCollection;
    }

    @XmlTransient
    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<OrgDesignation> getOrgDesignationCollection() {
        return orgDesignationCollection;
    }

    public void setOrgDesignationCollection(Collection<OrgDesignation> orgDesignationCollection) {
        this.orgDesignationCollection = orgDesignationCollection;
    }

    @XmlTransient
    public Collection<StudentCourseMaster> getStudentCourseMasterCollection() {
        return studentCourseMasterCollection;
    }

    public void setStudentCourseMasterCollection(Collection<StudentCourseMaster> studentCourseMasterCollection) {
        this.studentCourseMasterCollection = studentCourseMasterCollection;
    }

    @XmlTransient
    public Collection<FamilyMembers> getFamilyMembersCollection() {
        return familyMembersCollection;
    }

    public void setFamilyMembersCollection(Collection<FamilyMembers> familyMembersCollection) {
        this.familyMembersCollection = familyMembersCollection;
    }

    @XmlTransient
    public Collection<OrgItemCategory> getOrgItemCategoryCollection() {
        return orgItemCategoryCollection;
    }

    public void setOrgItemCategoryCollection(Collection<OrgItemCategory> orgItemCategoryCollection) {
        this.orgItemCategoryCollection = orgItemCategoryCollection;
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
    public Collection<EmployeeSalaryIncrementHistory> getEmployeeSalaryIncrementHistoryCollection() {
        return employeeSalaryIncrementHistoryCollection;
    }

    public void setEmployeeSalaryIncrementHistoryCollection(Collection<EmployeeSalaryIncrementHistory> employeeSalaryIncrementHistoryCollection) {
        this.employeeSalaryIncrementHistoryCollection = employeeSalaryIncrementHistoryCollection;
    }

    @XmlTransient
    public Collection<OrgEmployeeCategory> getOrgEmployeeCategoryCollection() {
        return orgEmployeeCategoryCollection;
    }

    public void setOrgEmployeeCategoryCollection(Collection<OrgEmployeeCategory> orgEmployeeCategoryCollection) {
        this.orgEmployeeCategoryCollection = orgEmployeeCategoryCollection;
    }

    @XmlTransient
    public Collection<LeaveType> getLeaveTypeCollection() {
        return leaveTypeCollection;
    }

    public void setLeaveTypeCollection(Collection<LeaveType> leaveTypeCollection) {
        this.leaveTypeCollection = leaveTypeCollection;
    }

    @XmlTransient
    public Collection<AwardingBody> getAwardingBodyCollection() {
        return awardingBodyCollection;
    }

    public void setAwardingBodyCollection(Collection<AwardingBody> awardingBodyCollection) {
        this.awardingBodyCollection = awardingBodyCollection;
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
    public Collection<SerialNo> getSerialNoCollection() {
        return serialNoCollection;
    }

    public void setSerialNoCollection(Collection<SerialNo> serialNoCollection) {
        this.serialNoCollection = serialNoCollection;
    }

    @XmlTransient
    public Collection<InterfaceMenuGopManager> getInterfaceMenuGopManagerCollection() {
        return interfaceMenuGopManagerCollection;
    }

    public void setInterfaceMenuGopManagerCollection(Collection<InterfaceMenuGopManager> interfaceMenuGopManagerCollection) {
        this.interfaceMenuGopManagerCollection = interfaceMenuGopManagerCollection;
    }

    @XmlTransient
    public Collection<RequestPurchaseOrderSiteManager> getRequestPurchaseOrderSiteManagerCollection() {
        return requestPurchaseOrderSiteManagerCollection;
    }

    public void setRequestPurchaseOrderSiteManagerCollection(Collection<RequestPurchaseOrderSiteManager> requestPurchaseOrderSiteManagerCollection) {
        this.requestPurchaseOrderSiteManagerCollection = requestPurchaseOrderSiteManagerCollection;
    }

    @XmlTransient
    public Collection<TemporaryJob> getTemporaryJobCollection() {
        return temporaryJobCollection;
    }

    public void setTemporaryJobCollection(Collection<TemporaryJob> temporaryJobCollection) {
        this.temporaryJobCollection = temporaryJobCollection;
    }

    @XmlTransient
    public Collection<SupplierAdvanceIssuingSummary> getSupplierAdvanceIssuingSummaryCollection() {
        return supplierAdvanceIssuingSummaryCollection;
    }

    public void setSupplierAdvanceIssuingSummaryCollection(Collection<SupplierAdvanceIssuingSummary> supplierAdvanceIssuingSummaryCollection) {
        this.supplierAdvanceIssuingSummaryCollection = supplierAdvanceIssuingSummaryCollection;
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
    public Collection<OrgAccountType> getOrgAccountTypeCollection() {
        return orgAccountTypeCollection;
    }

    public void setOrgAccountTypeCollection(Collection<OrgAccountType> orgAccountTypeCollection) {
        this.orgAccountTypeCollection = orgAccountTypeCollection;
    }

    @XmlTransient
    public Collection<VoucherItemInactive> getVoucherItemInactiveCollection() {
        return voucherItemInactiveCollection;
    }

    public void setVoucherItemInactiveCollection(Collection<VoucherItemInactive> voucherItemInactiveCollection) {
        this.voucherItemInactiveCollection = voucherItemInactiveCollection;
    }

    @XmlTransient
    public Collection<EmployeeItemLocation> getEmployeeItemLocationCollection() {
        return employeeItemLocationCollection;
    }

    public void setEmployeeItemLocationCollection(Collection<EmployeeItemLocation> employeeItemLocationCollection) {
        this.employeeItemLocationCollection = employeeItemLocationCollection;
    }

    @XmlTransient
    public Collection<OrgInterfaceDualEntry> getOrgInterfaceDualEntryCollection() {
        return orgInterfaceDualEntryCollection;
    }

    public void setOrgInterfaceDualEntryCollection(Collection<OrgInterfaceDualEntry> orgInterfaceDualEntryCollection) {
        this.orgInterfaceDualEntryCollection = orgInterfaceDualEntryCollection;
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
    public Collection<DocumentMaster> getDocumentMasterCollection() {
        return documentMasterCollection;
    }

    public void setDocumentMasterCollection(Collection<DocumentMaster> documentMasterCollection) {
        this.documentMasterCollection = documentMasterCollection;
    }

    @XmlTransient
    public Collection<ItemSupplier> getItemSupplierCollection() {
        return itemSupplierCollection;
    }

    public void setItemSupplierCollection(Collection<ItemSupplier> itemSupplierCollection) {
        this.itemSupplierCollection = itemSupplierCollection;
    }

    @XmlTransient
    public Collection<DeliveryAcceptanceNote> getDeliveryAcceptanceNoteCollection() {
        return deliveryAcceptanceNoteCollection;
    }

    public void setDeliveryAcceptanceNoteCollection(Collection<DeliveryAcceptanceNote> deliveryAcceptanceNoteCollection) {
        this.deliveryAcceptanceNoteCollection = deliveryAcceptanceNoteCollection;
    }

    @XmlTransient
    public Collection<BlRateSettings> getBlRateSettingsCollection() {
        return blRateSettingsCollection;
    }

    public void setBlRateSettingsCollection(Collection<BlRateSettings> blRateSettingsCollection) {
        this.blRateSettingsCollection = blRateSettingsCollection;
    }

    @XmlTransient
    public Collection<OrgSystemInterfaceController> getOrgSystemInterfaceControllerCollection() {
        return orgSystemInterfaceControllerCollection;
    }

    public void setOrgSystemInterfaceControllerCollection(Collection<OrgSystemInterfaceController> orgSystemInterfaceControllerCollection) {
        this.orgSystemInterfaceControllerCollection = orgSystemInterfaceControllerCollection;
    }

    @XmlTransient
    public Collection<UserLoginGroup> getUserLoginGroupCollection() {
        return userLoginGroupCollection;
    }

    public void setUserLoginGroupCollection(Collection<UserLoginGroup> userLoginGroupCollection) {
        this.userLoginGroupCollection = userLoginGroupCollection;
    }

    @XmlTransient
    public Collection<OrderMaster> getOrderMasterCollection() {
        return orderMasterCollection;
    }

    public void setOrderMasterCollection(Collection<OrderMaster> orderMasterCollection) {
        this.orderMasterCollection = orderMasterCollection;
    }

    @XmlTransient
    public Collection<OrderMaster> getOrderMasterCollection1() {
        return orderMasterCollection1;
    }

    public void setOrderMasterCollection1(Collection<OrderMaster> orderMasterCollection1) {
        this.orderMasterCollection1 = orderMasterCollection1;
    }

    @XmlTransient
    public Collection<Batch> getBatchCollection() {
        return batchCollection;
    }

    public void setBatchCollection(Collection<Batch> batchCollection) {
        this.batchCollection = batchCollection;
    }

    @XmlTransient
    public Collection<OrgLocation> getOrgLocationCollection() {
        return orgLocationCollection;
    }

    public void setOrgLocationCollection(Collection<OrgLocation> orgLocationCollection) {
        this.orgLocationCollection = orgLocationCollection;
    }

    @XmlTransient
    public Collection<CollectionTarget> getCollectionTargetCollection() {
        return collectionTargetCollection;
    }

    public void setCollectionTargetCollection(Collection<CollectionTarget> collectionTargetCollection) {
        this.collectionTargetCollection = collectionTargetCollection;
    }

    @XmlTransient
    public Collection<FactoryCollectedLeaf> getFactoryCollectedLeafCollection() {
        return factoryCollectedLeafCollection;
    }

    public void setFactoryCollectedLeafCollection(Collection<FactoryCollectedLeaf> factoryCollectedLeafCollection) {
        this.factoryCollectedLeafCollection = factoryCollectedLeafCollection;
    }

    @XmlTransient
    public Collection<JournalEntryReport> getJournalEntryReportCollection() {
        return journalEntryReportCollection;
    }

    public void setJournalEntryReportCollection(Collection<JournalEntryReport> journalEntryReportCollection) {
        this.journalEntryReportCollection = journalEntryReportCollection;
    }

    @XmlTransient
    public Collection<ProductionRequest> getProductionRequestCollection() {
        return productionRequestCollection;
    }

    public void setProductionRequestCollection(Collection<ProductionRequest> productionRequestCollection) {
        this.productionRequestCollection = productionRequestCollection;
    }

    @XmlTransient
    public Collection<OrgItemType> getOrgItemTypeCollection() {
        return orgItemTypeCollection;
    }

    public void setOrgItemTypeCollection(Collection<OrgItemType> orgItemTypeCollection) {
        this.orgItemTypeCollection = orgItemTypeCollection;
    }

    @XmlTransient
    public Collection<FingerPrintMachine> getFingerPrintMachineCollection() {
        return fingerPrintMachineCollection;
    }

    public void setFingerPrintMachineCollection(Collection<FingerPrintMachine> fingerPrintMachineCollection) {
        this.fingerPrintMachineCollection = fingerPrintMachineCollection;
    }

    @XmlTransient
    public Collection<VehicleInsurance> getVehicleInsuranceCollection() {
        return vehicleInsuranceCollection;
    }

    public void setVehicleInsuranceCollection(Collection<VehicleInsurance> vehicleInsuranceCollection) {
        this.vehicleInsuranceCollection = vehicleInsuranceCollection;
    }

    @XmlTransient
    public Collection<OrgCategoryManager> getOrgCategoryManagerCollection() {
        return orgCategoryManagerCollection;
    }

    public void setOrgCategoryManagerCollection(Collection<OrgCategoryManager> orgCategoryManagerCollection) {
        this.orgCategoryManagerCollection = orgCategoryManagerCollection;
    }

    @XmlTransient
    public Collection<GopCoaManager> getGopCoaManagerCollection() {
        return gopCoaManagerCollection;
    }

    public void setGopCoaManagerCollection(Collection<GopCoaManager> gopCoaManagerCollection) {
        this.gopCoaManagerCollection = gopCoaManagerCollection;
    }

    @XmlTransient
    public Collection<GatePass> getGatePassCollection() {
        return gatePassCollection;
    }

    public void setGatePassCollection(Collection<GatePass> gatePassCollection) {
        this.gatePassCollection = gatePassCollection;
    }

    @XmlTransient
    public Collection<AtendenceRegistry> getAtendenceRegistryCollection() {
        return atendenceRegistryCollection;
    }

    public void setAtendenceRegistryCollection(Collection<AtendenceRegistry> atendenceRegistryCollection) {
        this.atendenceRegistryCollection = atendenceRegistryCollection;
    }

    @XmlTransient
    public Collection<UniversalSettingsManager> getUniversalSettingsManagerCollection() {
        return universalSettingsManagerCollection;
    }

    public void setUniversalSettingsManagerCollection(Collection<UniversalSettingsManager> universalSettingsManagerCollection) {
        this.universalSettingsManagerCollection = universalSettingsManagerCollection;
    }

    @XmlTransient
    public Collection<ItemCategoryTypeController> getItemCategoryTypeControllerCollection() {
        return itemCategoryTypeControllerCollection;
    }

    public void setItemCategoryTypeControllerCollection(Collection<ItemCategoryTypeController> itemCategoryTypeControllerCollection) {
        this.itemCategoryTypeControllerCollection = itemCategoryTypeControllerCollection;
    }

    @XmlTransient
    public Collection<AttendenceAllowanceRate> getAttendenceAllowanceRateCollection() {
        return attendenceAllowanceRateCollection;
    }

    public void setAttendenceAllowanceRateCollection(Collection<AttendenceAllowanceRate> attendenceAllowanceRateCollection) {
        this.attendenceAllowanceRateCollection = attendenceAllowanceRateCollection;
    }

    @XmlTransient
    public Collection<OrgCoaManager> getOrgCoaManagerCollection() {
        return orgCoaManagerCollection;
    }

    public void setOrgCoaManagerCollection(Collection<OrgCoaManager> orgCoaManagerCollection) {
        this.orgCoaManagerCollection = orgCoaManagerCollection;
    }

    @XmlTransient
    public Collection<CashSettlementHistory> getCashSettlementHistoryCollection() {
        return cashSettlementHistoryCollection;
    }

    public void setCashSettlementHistoryCollection(Collection<CashSettlementHistory> cashSettlementHistoryCollection) {
        this.cashSettlementHistoryCollection = cashSettlementHistoryCollection;
    }

    @XmlTransient
    public Collection<UserLogin> getUserLoginCollection() {
        return userLoginCollection;
    }

    public void setUserLoginCollection(Collection<UserLogin> userLoginCollection) {
        this.userLoginCollection = userLoginCollection;
    }

    @XmlTransient
    public Collection<ProductBatchManager> getProductBatchManagerCollection() {
        return productBatchManagerCollection;
    }

    public void setProductBatchManagerCollection(Collection<ProductBatchManager> productBatchManagerCollection) {
        this.productBatchManagerCollection = productBatchManagerCollection;
    }

    @XmlTransient
    public Collection<WorkShift> getWorkShiftCollection() {
        return workShiftCollection;
    }

    public void setWorkShiftCollection(Collection<WorkShift> workShiftCollection) {
        this.workShiftCollection = workShiftCollection;
    }

    @XmlTransient
    public Collection<LeafRateManager> getLeafRateManagerCollection() {
        return leafRateManagerCollection;
    }

    public void setLeafRateManagerCollection(Collection<LeafRateManager> leafRateManagerCollection) {
        this.leafRateManagerCollection = leafRateManagerCollection;
    }

    @XmlTransient
    public Collection<UseCaseHasUserRole> getUseCaseHasUserRoleCollection() {
        return useCaseHasUserRoleCollection;
    }

    public void setUseCaseHasUserRoleCollection(Collection<UseCaseHasUserRole> useCaseHasUserRoleCollection) {
        this.useCaseHasUserRoleCollection = useCaseHasUserRoleCollection;
    }

    @XmlTransient
    public Collection<RouteTransportRateHistory> getRouteTransportRateHistoryCollection() {
        return routeTransportRateHistoryCollection;
    }

    public void setRouteTransportRateHistoryCollection(Collection<RouteTransportRateHistory> routeTransportRateHistoryCollection) {
        this.routeTransportRateHistoryCollection = routeTransportRateHistoryCollection;
    }

    @XmlTransient
    public Collection<UniversalBasicSalaryCalculation> getUniversalBasicSalaryCalculationCollection() {
        return universalBasicSalaryCalculationCollection;
    }

    public void setUniversalBasicSalaryCalculationCollection(Collection<UniversalBasicSalaryCalculation> universalBasicSalaryCalculationCollection) {
        this.universalBasicSalaryCalculationCollection = universalBasicSalaryCalculationCollection;
    }

    @XmlTransient
    public Collection<ProductionAdvice> getProductionAdviceCollection() {
        return productionAdviceCollection;
    }

    public void setProductionAdviceCollection(Collection<ProductionAdvice> productionAdviceCollection) {
        this.productionAdviceCollection = productionAdviceCollection;
    }

    @XmlTransient
    public Collection<CooperatSupplier> getCooperatSupplierCollection() {
        return cooperatSupplierCollection;
    }

    public void setCooperatSupplierCollection(Collection<CooperatSupplier> cooperatSupplierCollection) {
        this.cooperatSupplierCollection = cooperatSupplierCollection;
    }

    @XmlTransient
    public Collection<SupplierRegistration> getSupplierRegistrationCollection() {
        return supplierRegistrationCollection;
    }

    public void setSupplierRegistrationCollection(Collection<SupplierRegistration> supplierRegistrationCollection) {
        this.supplierRegistrationCollection = supplierRegistrationCollection;
    }

    @XmlTransient
    public Collection<OrgChartOfAccount> getOrgChartOfAccountCollection() {
        return orgChartOfAccountCollection;
    }

    public void setOrgChartOfAccountCollection(Collection<OrgChartOfAccount> orgChartOfAccountCollection) {
        this.orgChartOfAccountCollection = orgChartOfAccountCollection;
    }

    @XmlTransient
    public Collection<VoucherItem> getVoucherItemCollection() {
        return voucherItemCollection;
    }

    public void setVoucherItemCollection(Collection<VoucherItem> voucherItemCollection) {
        this.voucherItemCollection = voucherItemCollection;
    }

    @XmlTransient
    public Collection<HelpTicket> getHelpTicketCollection() {
        return helpTicketCollection;
    }

    public void setHelpTicketCollection(Collection<HelpTicket> helpTicketCollection) {
        this.helpTicketCollection = helpTicketCollection;
    }

    @XmlTransient
    public Collection<CompanyHolidayScheduler> getCompanyHolidaySchedulerCollection() {
        return companyHolidaySchedulerCollection;
    }

    public void setCompanyHolidaySchedulerCollection(Collection<CompanyHolidayScheduler> companyHolidaySchedulerCollection) {
        this.companyHolidaySchedulerCollection = companyHolidaySchedulerCollection;
    }

    @XmlTransient
    public Collection<OtRateController> getOtRateControllerCollection() {
        return otRateControllerCollection;
    }

    public void setOtRateControllerCollection(Collection<OtRateController> otRateControllerCollection) {
        this.otRateControllerCollection = otRateControllerCollection;
    }

    public Country getCountryIdC() {
        return countryIdC;
    }

    public void setCountryIdC(Country countryIdC) {
        this.countryIdC = countryIdC;
    }

    public OrganizationType getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(OrganizationType organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }

    public RegistrationType getRegistrationTypeId() {
        return registrationTypeId;
    }

    public void setRegistrationTypeId(RegistrationType registrationTypeId) {
        this.registrationTypeId = registrationTypeId;
    }

    @XmlTransient
    public Collection<DealingCompanies> getDealingCompaniesCollection() {
        return dealingCompaniesCollection;
    }

    public void setDealingCompaniesCollection(Collection<DealingCompanies> dealingCompaniesCollection) {
        this.dealingCompaniesCollection = dealingCompaniesCollection;
    }

    @XmlTransient
    public Collection<PaymentHistory> getPaymentHistoryCollection() {
        return paymentHistoryCollection;
    }

    public void setPaymentHistoryCollection(Collection<PaymentHistory> paymentHistoryCollection) {
        this.paymentHistoryCollection = paymentHistoryCollection;
    }

    @XmlTransient
    public Collection<ItemGrading> getItemGradingCollection() {
        return itemGradingCollection;
    }

    public void setItemGradingCollection(Collection<ItemGrading> itemGradingCollection) {
        this.itemGradingCollection = itemGradingCollection;
    }

    @XmlTransient
    public Collection<SupplierPassbook> getSupplierPassbookCollection() {
        return supplierPassbookCollection;
    }

    public void setSupplierPassbookCollection(Collection<SupplierPassbook> supplierPassbookCollection) {
        this.supplierPassbookCollection = supplierPassbookCollection;
    }

    @XmlTransient
    public Collection<DesignationLevelManager> getDesignationLevelManagerCollection() {
        return designationLevelManagerCollection;
    }

    public void setDesignationLevelManagerCollection(Collection<DesignationLevelManager> designationLevelManagerCollection) {
        this.designationLevelManagerCollection = designationLevelManagerCollection;
    }

    @XmlTransient
    public Collection<PropertyArea> getPropertyAreaCollection() {
        return propertyAreaCollection;
    }

    public void setPropertyAreaCollection(Collection<PropertyArea> propertyAreaCollection) {
        this.propertyAreaCollection = propertyAreaCollection;
    }

    @XmlTransient
    public Collection<UploadedFileManager> getUploadedFileManagerCollection() {
        return uploadedFileManagerCollection;
    }

    public void setUploadedFileManagerCollection(Collection<UploadedFileManager> uploadedFileManagerCollection) {
        this.uploadedFileManagerCollection = uploadedFileManagerCollection;
    }

    @XmlTransient
    public Collection<OrgWorkingSection> getOrgWorkingSectionCollection() {
        return orgWorkingSectionCollection;
    }

    public void setOrgWorkingSectionCollection(Collection<OrgWorkingSection> orgWorkingSectionCollection) {
        this.orgWorkingSectionCollection = orgWorkingSectionCollection;
    }

    @XmlTransient
    public Collection<OrgTaxCategoryManager> getOrgTaxCategoryManagerCollection() {
        return orgTaxCategoryManagerCollection;
    }

    public void setOrgTaxCategoryManagerCollection(Collection<OrgTaxCategoryManager> orgTaxCategoryManagerCollection) {
        this.orgTaxCategoryManagerCollection = orgTaxCategoryManagerCollection;
    }

    @XmlTransient
    public Collection<StockHistoryManager> getStockHistoryManagerCollection() {
        return stockHistoryManagerCollection;
    }

    public void setStockHistoryManagerCollection(Collection<StockHistoryManager> stockHistoryManagerCollection) {
        this.stockHistoryManagerCollection = stockHistoryManagerCollection;
    }

    @XmlTransient
    public Collection<OrgUnitOfMeasure> getOrgUnitOfMeasureCollection() {
        return orgUnitOfMeasureCollection;
    }

    public void setOrgUnitOfMeasureCollection(Collection<OrgUnitOfMeasure> orgUnitOfMeasureCollection) {
        this.orgUnitOfMeasureCollection = orgUnitOfMeasureCollection;
    }

    @XmlTransient
    public Collection<HolidayPayWorkDays> getHolidayPayWorkDaysCollection() {
        return holidayPayWorkDaysCollection;
    }

    public void setHolidayPayWorkDaysCollection(Collection<HolidayPayWorkDays> holidayPayWorkDaysCollection) {
        this.holidayPayWorkDaysCollection = holidayPayWorkDaysCollection;
    }

    @XmlTransient
    public Collection<WorkedHistory> getWorkedHistoryCollection() {
        return workedHistoryCollection;
    }

    public void setWorkedHistoryCollection(Collection<WorkedHistory> workedHistoryCollection) {
        this.workedHistoryCollection = workedHistoryCollection;
    }

    @XmlTransient
    public Collection<OrgDesignationGrade> getOrgDesignationGradeCollection() {
        return orgDesignationGradeCollection;
    }

    public void setOrgDesignationGradeCollection(Collection<OrgDesignationGrade> orgDesignationGradeCollection) {
        this.orgDesignationGradeCollection = orgDesignationGradeCollection;
    }

    @XmlTransient
    public Collection<TransactionManagement> getTransactionManagementCollection() {
        return transactionManagementCollection;
    }

    public void setTransactionManagementCollection(Collection<TransactionManagement> transactionManagementCollection) {
        this.transactionManagementCollection = transactionManagementCollection;
    }

    @XmlTransient
    public Collection<SchoolsAttended> getSchoolsAttendedCollection() {
        return schoolsAttendedCollection;
    }

    public void setSchoolsAttendedCollection(Collection<SchoolsAttended> schoolsAttendedCollection) {
        this.schoolsAttendedCollection = schoolsAttendedCollection;
    }

    @XmlTransient
    public Collection<OrgDesignationLevel> getOrgDesignationLevelCollection() {
        return orgDesignationLevelCollection;
    }

    public void setOrgDesignationLevelCollection(Collection<OrgDesignationLevel> orgDesignationLevelCollection) {
        this.orgDesignationLevelCollection = orgDesignationLevelCollection;
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
        if (!(object instanceof GeneralOrganizationProfile)) {
            return false;
        }
        GeneralOrganizationProfile other = (GeneralOrganizationProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GeneralOrganizationProfile[ id=" + id + " ]";
    }
    
}
