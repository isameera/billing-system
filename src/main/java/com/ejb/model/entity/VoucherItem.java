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
@Table(name = "voucher_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherItem.findAll", query = "SELECT v FROM VoucherItem v")
    , @NamedQuery(name = "VoucherItem.findById", query = "SELECT v FROM VoucherItem v WHERE v.id = :id")
    , @NamedQuery(name = "VoucherItem.findByQty", query = "SELECT v FROM VoucherItem v WHERE v.qty = :qty")
    , @NamedQuery(name = "VoucherItem.findByRecevedQty", query = "SELECT v FROM VoucherItem v WHERE v.recevedQty = :recevedQty")
    , @NamedQuery(name = "VoucherItem.findByAmount", query = "SELECT v FROM VoucherItem v WHERE v.amount = :amount")
    , @NamedQuery(name = "VoucherItem.findByDueAmount", query = "SELECT v FROM VoucherItem v WHERE v.dueAmount = :dueAmount")
    , @NamedQuery(name = "VoucherItem.findByDiscount", query = "SELECT v FROM VoucherItem v WHERE v.discount = :discount")
    , @NamedQuery(name = "VoucherItem.findByDate", query = "SELECT v FROM VoucherItem v WHERE v.date = :date")
    , @NamedQuery(name = "VoucherItem.findByIsActive", query = "SELECT v FROM VoucherItem v WHERE v.isActive = :isActive")
    , @NamedQuery(name = "VoucherItem.findByIsPaid", query = "SELECT v FROM VoucherItem v WHERE v.isPaid = :isPaid")
    , @NamedQuery(name = "VoucherItem.findByWorrentyPeriod", query = "SELECT v FROM VoucherItem v WHERE v.worrentyPeriod = :worrentyPeriod")
    , @NamedQuery(name = "VoucherItem.findByUnitPrice", query = "SELECT v FROM VoucherItem v WHERE v.unitPrice = :unitPrice")})
public class VoucherItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private double qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "receved_qty")
    private Double recevedQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "due_amount")
    private double dueAmount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private double discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private int isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_paid")
    private int isPaid;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "worrenty_period")
    private Integer worrentyPeriod;
    @Column(name = "unit_price")
    private Double unitPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<GjeVoucherItem> gjeVoucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<NotificationControllerVoucherItem> notificationControllerVoucherItemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<SupplierItemManagerBatchVoucherItems> supplierItemManagerBatchVoucherItemsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<VoucherItemManager> voucherItemManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId1")
    private Collection<VoucherItemManager> voucherItemManagerCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<VoucherItemLocationManager> voucherItemLocationManagerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<UncommonVoucherItemDetails> uncommonVoucherItemDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<VoucherItemReceivedCheques> voucherItemReceivedChequesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<VoucherItemInactive> voucherItemInactiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<VoucherItemSubReasonManager> voucherItemSubReasonManagerCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "login_session_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LoginSession loginSessionId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;
    @JoinColumn(name = "sub_chart_of_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubChartOfAccount subChartOfAccountId;
    @JoinColumn(name = "user_login_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UserLogin userLoginId;
    @JoinColumn(name = "voucher_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId1;
    @JoinColumn(name = "voucher_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherType voucherTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "voucherItemId")
    private Collection<VoucherItemCalculatedBy> voucherItemCalculatedByCollection;

    public VoucherItem() {
    }

    public VoucherItem(Integer id) {
        this.id = id;
    }

    public VoucherItem(Integer id, double qty, double amount, double dueAmount, double discount, Date date, int isActive, int isPaid) {
        this.id = id;
        this.qty = qty;
        this.amount = amount;
        this.dueAmount = dueAmount;
        this.discount = discount;
        this.date = date;
        this.isActive = isActive;
        this.isPaid = isPaid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Double getRecevedQty() {
        return recevedQty;
    }

    public void setRecevedQty(Double recevedQty) {
        this.recevedQty = recevedQty;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWorrentyPeriod() {
        return worrentyPeriod;
    }

    public void setWorrentyPeriod(Integer worrentyPeriod) {
        this.worrentyPeriod = worrentyPeriod;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @XmlTransient
    public Collection<GjeVoucherItem> getGjeVoucherItemCollection() {
        return gjeVoucherItemCollection;
    }

    public void setGjeVoucherItemCollection(Collection<GjeVoucherItem> gjeVoucherItemCollection) {
        this.gjeVoucherItemCollection = gjeVoucherItemCollection;
    }

    @XmlTransient
    public Collection<NotificationControllerVoucherItem> getNotificationControllerVoucherItemCollection() {
        return notificationControllerVoucherItemCollection;
    }

    public void setNotificationControllerVoucherItemCollection(Collection<NotificationControllerVoucherItem> notificationControllerVoucherItemCollection) {
        this.notificationControllerVoucherItemCollection = notificationControllerVoucherItemCollection;
    }

    @XmlTransient
    public Collection<SupplierItemManagerBatchVoucherItems> getSupplierItemManagerBatchVoucherItemsCollection() {
        return supplierItemManagerBatchVoucherItemsCollection;
    }

    public void setSupplierItemManagerBatchVoucherItemsCollection(Collection<SupplierItemManagerBatchVoucherItems> supplierItemManagerBatchVoucherItemsCollection) {
        this.supplierItemManagerBatchVoucherItemsCollection = supplierItemManagerBatchVoucherItemsCollection;
    }

    @XmlTransient
    public Collection<VoucherItemManager> getVoucherItemManagerCollection() {
        return voucherItemManagerCollection;
    }

    public void setVoucherItemManagerCollection(Collection<VoucherItemManager> voucherItemManagerCollection) {
        this.voucherItemManagerCollection = voucherItemManagerCollection;
    }

    @XmlTransient
    public Collection<VoucherItemManager> getVoucherItemManagerCollection1() {
        return voucherItemManagerCollection1;
    }

    public void setVoucherItemManagerCollection1(Collection<VoucherItemManager> voucherItemManagerCollection1) {
        this.voucherItemManagerCollection1 = voucherItemManagerCollection1;
    }

    @XmlTransient
    public Collection<VoucherItemLocationManager> getVoucherItemLocationManagerCollection() {
        return voucherItemLocationManagerCollection;
    }

    public void setVoucherItemLocationManagerCollection(Collection<VoucherItemLocationManager> voucherItemLocationManagerCollection) {
        this.voucherItemLocationManagerCollection = voucherItemLocationManagerCollection;
    }

    @XmlTransient
    public Collection<UncommonVoucherItemDetails> getUncommonVoucherItemDetailsCollection() {
        return uncommonVoucherItemDetailsCollection;
    }

    public void setUncommonVoucherItemDetailsCollection(Collection<UncommonVoucherItemDetails> uncommonVoucherItemDetailsCollection) {
        this.uncommonVoucherItemDetailsCollection = uncommonVoucherItemDetailsCollection;
    }

    @XmlTransient
    public Collection<VoucherItemReceivedCheques> getVoucherItemReceivedChequesCollection() {
        return voucherItemReceivedChequesCollection;
    }

    public void setVoucherItemReceivedChequesCollection(Collection<VoucherItemReceivedCheques> voucherItemReceivedChequesCollection) {
        this.voucherItemReceivedChequesCollection = voucherItemReceivedChequesCollection;
    }

    @XmlTransient
    public Collection<VoucherItemInactive> getVoucherItemInactiveCollection() {
        return voucherItemInactiveCollection;
    }

    public void setVoucherItemInactiveCollection(Collection<VoucherItemInactive> voucherItemInactiveCollection) {
        this.voucherItemInactiveCollection = voucherItemInactiveCollection;
    }

    @XmlTransient
    public Collection<VoucherItemSubReasonManager> getVoucherItemSubReasonManagerCollection() {
        return voucherItemSubReasonManagerCollection;
    }

    public void setVoucherItemSubReasonManagerCollection(Collection<VoucherItemSubReasonManager> voucherItemSubReasonManagerCollection) {
        this.voucherItemSubReasonManagerCollection = voucherItemSubReasonManagerCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public LoginSession getLoginSessionId() {
        return loginSessionId;
    }

    public void setLoginSessionId(LoginSession loginSessionId) {
        this.loginSessionId = loginSessionId;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
    }

    public SubChartOfAccount getSubChartOfAccountId() {
        return subChartOfAccountId;
    }

    public void setSubChartOfAccountId(SubChartOfAccount subChartOfAccountId) {
        this.subChartOfAccountId = subChartOfAccountId;
    }

    public UserLogin getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(UserLogin userLoginId) {
        this.userLoginId = userLoginId;
    }

    public Voucher getVoucherId1() {
        return voucherId1;
    }

    public void setVoucherId1(Voucher voucherId1) {
        this.voucherId1 = voucherId1;
    }

    public VoucherType getVoucherTypeId() {
        return voucherTypeId;
    }

    public void setVoucherTypeId(VoucherType voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
    }

    @XmlTransient
    public Collection<VoucherItemCalculatedBy> getVoucherItemCalculatedByCollection() {
        return voucherItemCalculatedByCollection;
    }

    public void setVoucherItemCalculatedByCollection(Collection<VoucherItemCalculatedBy> voucherItemCalculatedByCollection) {
        this.voucherItemCalculatedByCollection = voucherItemCalculatedByCollection;
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
        if (!(object instanceof VoucherItem)) {
            return false;
        }
        VoucherItem other = (VoucherItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherItem[ id=" + id + " ]";
    }
    
}
