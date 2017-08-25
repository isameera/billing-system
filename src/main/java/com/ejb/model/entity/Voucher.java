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
@Table(name = "voucher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voucher.findAll", query = "SELECT v FROM Voucher v")
    , @NamedQuery(name = "Voucher.findById", query = "SELECT v FROM Voucher v WHERE v.id = :id")
    , @NamedQuery(name = "Voucher.findByVoucherId", query = "SELECT v FROM Voucher v WHERE v.voucherId = :voucherId")
    , @NamedQuery(name = "Voucher.findByDate", query = "SELECT v FROM Voucher v WHERE v.date = :date")
    , @NamedQuery(name = "Voucher.findByPaymentDate", query = "SELECT v FROM Voucher v WHERE v.paymentDate = :paymentDate")
    , @NamedQuery(name = "Voucher.findByVoucherTotal", query = "SELECT v FROM Voucher v WHERE v.voucherTotal = :voucherTotal")
    , @NamedQuery(name = "Voucher.findByTotalPaid", query = "SELECT v FROM Voucher v WHERE v.totalPaid = :totalPaid")
    , @NamedQuery(name = "Voucher.findByDue", query = "SELECT v FROM Voucher v WHERE v.due = :due")
    , @NamedQuery(name = "Voucher.findByDiscount", query = "SELECT v FROM Voucher v WHERE v.discount = :discount")
    , @NamedQuery(name = "Voucher.findByIsActive", query = "SELECT v FROM Voucher v WHERE v.isActive = :isActive")
    , @NamedQuery(name = "Voucher.findByIsCompleted", query = "SELECT v FROM Voucher v WHERE v.isCompleted = :isCompleted")})
public class Voucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "voucher_id")
    private String voucherId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voucher_total")
    private double voucherTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_paid")
    private double totalPaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "due")
    private double due;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private double discount;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private int isActive;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<GjeVoucherManager> gjeVoucherManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<ChequeDetails> chequeDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<AdvanceRequestManager> advanceRequestManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucher")
    private Collection<VoucherReceiptManager> voucherReceiptManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt")
    private Collection<VoucherReceiptManager> voucherReceiptManagerCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherPaymentMode> voucherPaymentModeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherMagazine> voucherMagazineCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherInactiveRequest> voucherInactiveRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<ComItemRequest> comItemRequestCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "login_session_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoginSession loginSessionId;
    @JoinColumn(name = "universal_payment_mode_id", referencedColumnName = "id")
    @ManyToOne
    private UniversalPaymentMode universalPaymentModeId;
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLogin userLoginId;
    @JoinColumn(name = "voucher_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherTotalManager voucherMasterId;
    @JoinColumn(name = "voucher_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherType voucherTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherTaxDetails> voucherTaxDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherApproval> voucherApprovalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherSubReasonManager> voucherSubReasonManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<WarehouseGrnDetails> warehouseGrnDetailsCollection;
    @OneToMany(mappedBy = "voucherId")
    private Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<PackageGradingManager> packageGradingManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<UncommonVoucherDetails> uncommonVoucherDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<DepositConfirmedBy> depositConfirmedByCollection;
    @OneToMany(mappedBy = "voucherId")
    private Collection<VariableAllowanceTransactions> variableAllowanceTransactionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<RequestPurchaseOrderSiteManager> requestPurchaseOrderSiteManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<UniversalBoughtleafItemRequestVoucher> universalBoughtleafItemRequestVoucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<WarehouseGrnItemDetails> warehouseGrnItemDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<ReferenceVoucher> referenceVoucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherCoveringLetter> voucherCoveringLetterCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<InvoiceDispatchManager> invoiceDispatchManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<RecurantExpensesHistory> recurantExpensesHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<ConstructionContractVoucherManager> constructionContractVoucherManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<Quotation> quotationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<TeaSupplierPaymentVouchers> teaSupplierPaymentVouchersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId1")
    private Collection<OldVoucher> oldVoucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId1")
    private Collection<VoucherItem> voucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<PaymentHistory> paymentHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<UniversalOrgPersonFinancialHistoryVoucher> universalOrgPersonFinancialHistoryVoucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<NotificationControllerVoucher> notificationControllerVoucherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<SupplierItemManagerBatch> supplierItemManagerBatchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherId")
    private Collection<VoucherJobManager> voucherJobManagerCollection;

    public Voucher() {
    }

    public Voucher(Integer id) {
        this.id = id;
    }

    public Voucher(Integer id, String voucherId, Date date, double voucherTotal, double totalPaid, double due, double discount, int isActive) {
        this.id = id;
        this.voucherId = voucherId;
        this.date = date;
        this.voucherTotal = voucherTotal;
        this.totalPaid = totalPaid;
        this.due = due;
        this.discount = discount;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getVoucherTotal() {
        return voucherTotal;
    }

    public void setVoucherTotal(double voucherTotal) {
        this.voucherTotal = voucherTotal;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    @XmlTransient
    public Collection<GjeVoucherManager> getGjeVoucherManagerCollection() {
        return gjeVoucherManagerCollection;
    }

    public void setGjeVoucherManagerCollection(Collection<GjeVoucherManager> gjeVoucherManagerCollection) {
        this.gjeVoucherManagerCollection = gjeVoucherManagerCollection;
    }

    @XmlTransient
    public Collection<ChequeDetails> getChequeDetailsCollection() {
        return chequeDetailsCollection;
    }

    public void setChequeDetailsCollection(Collection<ChequeDetails> chequeDetailsCollection) {
        this.chequeDetailsCollection = chequeDetailsCollection;
    }

    @XmlTransient
    public Collection<AdvanceRequestManager> getAdvanceRequestManagerCollection() {
        return advanceRequestManagerCollection;
    }

    public void setAdvanceRequestManagerCollection(Collection<AdvanceRequestManager> advanceRequestManagerCollection) {
        this.advanceRequestManagerCollection = advanceRequestManagerCollection;
    }

    @XmlTransient
    public Collection<VoucherReceiptManager> getVoucherReceiptManagerCollection() {
        return voucherReceiptManagerCollection;
    }

    public void setVoucherReceiptManagerCollection(Collection<VoucherReceiptManager> voucherReceiptManagerCollection) {
        this.voucherReceiptManagerCollection = voucherReceiptManagerCollection;
    }

    @XmlTransient
    public Collection<VoucherReceiptManager> getVoucherReceiptManagerCollection1() {
        return voucherReceiptManagerCollection1;
    }

    public void setVoucherReceiptManagerCollection1(Collection<VoucherReceiptManager> voucherReceiptManagerCollection1) {
        this.voucherReceiptManagerCollection1 = voucherReceiptManagerCollection1;
    }

    @XmlTransient
    public Collection<VoucherPaymentMode> getVoucherPaymentModeCollection() {
        return voucherPaymentModeCollection;
    }

    public void setVoucherPaymentModeCollection(Collection<VoucherPaymentMode> voucherPaymentModeCollection) {
        this.voucherPaymentModeCollection = voucherPaymentModeCollection;
    }

    @XmlTransient
    public Collection<VoucherMagazine> getVoucherMagazineCollection() {
        return voucherMagazineCollection;
    }

    public void setVoucherMagazineCollection(Collection<VoucherMagazine> voucherMagazineCollection) {
        this.voucherMagazineCollection = voucherMagazineCollection;
    }

    @XmlTransient
    public Collection<VoucherInactiveRequest> getVoucherInactiveRequestCollection() {
        return voucherInactiveRequestCollection;
    }

    public void setVoucherInactiveRequestCollection(Collection<VoucherInactiveRequest> voucherInactiveRequestCollection) {
        this.voucherInactiveRequestCollection = voucherInactiveRequestCollection;
    }

    @XmlTransient
    public Collection<ComItemRequest> getComItemRequestCollection() {
        return comItemRequestCollection;
    }

    public void setComItemRequestCollection(Collection<ComItemRequest> comItemRequestCollection) {
        this.comItemRequestCollection = comItemRequestCollection;
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

    public LoginSession getLoginSessionId() {
        return loginSessionId;
    }

    public void setLoginSessionId(LoginSession loginSessionId) {
        this.loginSessionId = loginSessionId;
    }

    public UniversalPaymentMode getUniversalPaymentModeId() {
        return universalPaymentModeId;
    }

    public void setUniversalPaymentModeId(UniversalPaymentMode universalPaymentModeId) {
        this.universalPaymentModeId = universalPaymentModeId;
    }

    public UserLogin getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(UserLogin userLoginId) {
        this.userLoginId = userLoginId;
    }

    public VoucherTotalManager getVoucherMasterId() {
        return voucherMasterId;
    }

    public void setVoucherMasterId(VoucherTotalManager voucherMasterId) {
        this.voucherMasterId = voucherMasterId;
    }

    public VoucherType getVoucherTypeId() {
        return voucherTypeId;
    }

    public void setVoucherTypeId(VoucherType voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
    }

    @XmlTransient
    public Collection<VoucherTaxDetails> getVoucherTaxDetailsCollection() {
        return voucherTaxDetailsCollection;
    }

    public void setVoucherTaxDetailsCollection(Collection<VoucherTaxDetails> voucherTaxDetailsCollection) {
        this.voucherTaxDetailsCollection = voucherTaxDetailsCollection;
    }

    @XmlTransient
    public Collection<VoucherApproval> getVoucherApprovalCollection() {
        return voucherApprovalCollection;
    }

    public void setVoucherApprovalCollection(Collection<VoucherApproval> voucherApprovalCollection) {
        this.voucherApprovalCollection = voucherApprovalCollection;
    }

    @XmlTransient
    public Collection<VoucherSubReasonManager> getVoucherSubReasonManagerCollection() {
        return voucherSubReasonManagerCollection;
    }

    public void setVoucherSubReasonManagerCollection(Collection<VoucherSubReasonManager> voucherSubReasonManagerCollection) {
        this.voucherSubReasonManagerCollection = voucherSubReasonManagerCollection;
    }

    @XmlTransient
    public Collection<WarehouseGrnDetails> getWarehouseGrnDetailsCollection() {
        return warehouseGrnDetailsCollection;
    }

    public void setWarehouseGrnDetailsCollection(Collection<WarehouseGrnDetails> warehouseGrnDetailsCollection) {
        this.warehouseGrnDetailsCollection = warehouseGrnDetailsCollection;
    }

    @XmlTransient
    public Collection<PreparePaymentsForSupplierSavings> getPreparePaymentsForSupplierSavingsCollection() {
        return preparePaymentsForSupplierSavingsCollection;
    }

    public void setPreparePaymentsForSupplierSavingsCollection(Collection<PreparePaymentsForSupplierSavings> preparePaymentsForSupplierSavingsCollection) {
        this.preparePaymentsForSupplierSavingsCollection = preparePaymentsForSupplierSavingsCollection;
    }

    @XmlTransient
    public Collection<PackageGradingManager> getPackageGradingManagerCollection() {
        return packageGradingManagerCollection;
    }

    public void setPackageGradingManagerCollection(Collection<PackageGradingManager> packageGradingManagerCollection) {
        this.packageGradingManagerCollection = packageGradingManagerCollection;
    }

    @XmlTransient
    public Collection<UncommonVoucherDetails> getUncommonVoucherDetailsCollection() {
        return uncommonVoucherDetailsCollection;
    }

    public void setUncommonVoucherDetailsCollection(Collection<UncommonVoucherDetails> uncommonVoucherDetailsCollection) {
        this.uncommonVoucherDetailsCollection = uncommonVoucherDetailsCollection;
    }

    @XmlTransient
    public Collection<DepositConfirmedBy> getDepositConfirmedByCollection() {
        return depositConfirmedByCollection;
    }

    public void setDepositConfirmedByCollection(Collection<DepositConfirmedBy> depositConfirmedByCollection) {
        this.depositConfirmedByCollection = depositConfirmedByCollection;
    }

    @XmlTransient
    public Collection<VariableAllowanceTransactions> getVariableAllowanceTransactionsCollection() {
        return variableAllowanceTransactionsCollection;
    }

    public void setVariableAllowanceTransactionsCollection(Collection<VariableAllowanceTransactions> variableAllowanceTransactionsCollection) {
        this.variableAllowanceTransactionsCollection = variableAllowanceTransactionsCollection;
    }

    @XmlTransient
    public Collection<RequestPurchaseOrderSiteManager> getRequestPurchaseOrderSiteManagerCollection() {
        return requestPurchaseOrderSiteManagerCollection;
    }

    public void setRequestPurchaseOrderSiteManagerCollection(Collection<RequestPurchaseOrderSiteManager> requestPurchaseOrderSiteManagerCollection) {
        this.requestPurchaseOrderSiteManagerCollection = requestPurchaseOrderSiteManagerCollection;
    }

    @XmlTransient
    public Collection<UniversalBoughtleafItemRequestVoucher> getUniversalBoughtleafItemRequestVoucherCollection() {
        return universalBoughtleafItemRequestVoucherCollection;
    }

    public void setUniversalBoughtleafItemRequestVoucherCollection(Collection<UniversalBoughtleafItemRequestVoucher> universalBoughtleafItemRequestVoucherCollection) {
        this.universalBoughtleafItemRequestVoucherCollection = universalBoughtleafItemRequestVoucherCollection;
    }

    @XmlTransient
    public Collection<WarehouseGrnItemDetails> getWarehouseGrnItemDetailsCollection() {
        return warehouseGrnItemDetailsCollection;
    }

    public void setWarehouseGrnItemDetailsCollection(Collection<WarehouseGrnItemDetails> warehouseGrnItemDetailsCollection) {
        this.warehouseGrnItemDetailsCollection = warehouseGrnItemDetailsCollection;
    }

    @XmlTransient
    public Collection<ReferenceVoucher> getReferenceVoucherCollection() {
        return referenceVoucherCollection;
    }

    public void setReferenceVoucherCollection(Collection<ReferenceVoucher> referenceVoucherCollection) {
        this.referenceVoucherCollection = referenceVoucherCollection;
    }

    @XmlTransient
    public Collection<VoucherCoveringLetter> getVoucherCoveringLetterCollection() {
        return voucherCoveringLetterCollection;
    }

    public void setVoucherCoveringLetterCollection(Collection<VoucherCoveringLetter> voucherCoveringLetterCollection) {
        this.voucherCoveringLetterCollection = voucherCoveringLetterCollection;
    }

    @XmlTransient
    public Collection<InvoiceDispatchManager> getInvoiceDispatchManagerCollection() {
        return invoiceDispatchManagerCollection;
    }

    public void setInvoiceDispatchManagerCollection(Collection<InvoiceDispatchManager> invoiceDispatchManagerCollection) {
        this.invoiceDispatchManagerCollection = invoiceDispatchManagerCollection;
    }

    @XmlTransient
    public Collection<RecurantExpensesHistory> getRecurantExpensesHistoryCollection() {
        return recurantExpensesHistoryCollection;
    }

    public void setRecurantExpensesHistoryCollection(Collection<RecurantExpensesHistory> recurantExpensesHistoryCollection) {
        this.recurantExpensesHistoryCollection = recurantExpensesHistoryCollection;
    }

    @XmlTransient
    public Collection<ConstructionContractVoucherManager> getConstructionContractVoucherManagerCollection() {
        return constructionContractVoucherManagerCollection;
    }

    public void setConstructionContractVoucherManagerCollection(Collection<ConstructionContractVoucherManager> constructionContractVoucherManagerCollection) {
        this.constructionContractVoucherManagerCollection = constructionContractVoucherManagerCollection;
    }

    @XmlTransient
    public Collection<Quotation> getQuotationCollection() {
        return quotationCollection;
    }

    public void setQuotationCollection(Collection<Quotation> quotationCollection) {
        this.quotationCollection = quotationCollection;
    }

    @XmlTransient
    public Collection<TeaSupplierPaymentVouchers> getTeaSupplierPaymentVouchersCollection() {
        return teaSupplierPaymentVouchersCollection;
    }

    public void setTeaSupplierPaymentVouchersCollection(Collection<TeaSupplierPaymentVouchers> teaSupplierPaymentVouchersCollection) {
        this.teaSupplierPaymentVouchersCollection = teaSupplierPaymentVouchersCollection;
    }

    @XmlTransient
    public Collection<OldVoucher> getOldVoucherCollection() {
        return oldVoucherCollection;
    }

    public void setOldVoucherCollection(Collection<OldVoucher> oldVoucherCollection) {
        this.oldVoucherCollection = oldVoucherCollection;
    }

    @XmlTransient
    public Collection<VoucherItem> getVoucherItemCollection() {
        return voucherItemCollection;
    }

    public void setVoucherItemCollection(Collection<VoucherItem> voucherItemCollection) {
        this.voucherItemCollection = voucherItemCollection;
    }

    @XmlTransient
    public Collection<PaymentHistory> getPaymentHistoryCollection() {
        return paymentHistoryCollection;
    }

    public void setPaymentHistoryCollection(Collection<PaymentHistory> paymentHistoryCollection) {
        this.paymentHistoryCollection = paymentHistoryCollection;
    }

    @XmlTransient
    public Collection<UniversalOrgPersonFinancialHistoryVoucher> getUniversalOrgPersonFinancialHistoryVoucherCollection() {
        return universalOrgPersonFinancialHistoryVoucherCollection;
    }

    public void setUniversalOrgPersonFinancialHistoryVoucherCollection(Collection<UniversalOrgPersonFinancialHistoryVoucher> universalOrgPersonFinancialHistoryVoucherCollection) {
        this.universalOrgPersonFinancialHistoryVoucherCollection = universalOrgPersonFinancialHistoryVoucherCollection;
    }

    @XmlTransient
    public Collection<NotificationControllerVoucher> getNotificationControllerVoucherCollection() {
        return notificationControllerVoucherCollection;
    }

    public void setNotificationControllerVoucherCollection(Collection<NotificationControllerVoucher> notificationControllerVoucherCollection) {
        this.notificationControllerVoucherCollection = notificationControllerVoucherCollection;
    }

    @XmlTransient
    public Collection<SupplierItemManagerBatch> getSupplierItemManagerBatchCollection() {
        return supplierItemManagerBatchCollection;
    }

    public void setSupplierItemManagerBatchCollection(Collection<SupplierItemManagerBatch> supplierItemManagerBatchCollection) {
        this.supplierItemManagerBatchCollection = supplierItemManagerBatchCollection;
    }

    @XmlTransient
    public Collection<VoucherJobManager> getVoucherJobManagerCollection() {
        return voucherJobManagerCollection;
    }

    public void setVoucherJobManagerCollection(Collection<VoucherJobManager> voucherJobManagerCollection) {
        this.voucherJobManagerCollection = voucherJobManagerCollection;
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
        if (!(object instanceof Voucher)) {
            return false;
        }
        Voucher other = (Voucher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Voucher[ id=" + id + " ]";
    }
    
}
