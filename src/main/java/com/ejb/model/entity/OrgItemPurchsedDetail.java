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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "org_item_purchsed_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrgItemPurchsedDetail.findAll", query = "SELECT o FROM OrgItemPurchsedDetail o")
    , @NamedQuery(name = "OrgItemPurchsedDetail.findById", query = "SELECT o FROM OrgItemPurchsedDetail o WHERE o.id = :id")
    , @NamedQuery(name = "OrgItemPurchsedDetail.findByPurchsedDate", query = "SELECT o FROM OrgItemPurchsedDetail o WHERE o.purchsedDate = :purchsedDate")
    , @NamedQuery(name = "OrgItemPurchsedDetail.findByAccountCode", query = "SELECT o FROM OrgItemPurchsedDetail o WHERE o.accountCode = :accountCode")
    , @NamedQuery(name = "OrgItemPurchsedDetail.findBySerialNo", query = "SELECT o FROM OrgItemPurchsedDetail o WHERE o.serialNo = :serialNo")
    , @NamedQuery(name = "OrgItemPurchsedDetail.findByPurchsedValue", query = "SELECT o FROM OrgItemPurchsedDetail o WHERE o.purchsedValue = :purchsedValue")
    , @NamedQuery(name = "OrgItemPurchsedDetail.findByIsSold", query = "SELECT o FROM OrgItemPurchsedDetail o WHERE o.isSold = :isSold")})
public class OrgItemPurchsedDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "purchsed_date")
    @Temporal(TemporalType.DATE)
    private Date purchsedDate;
    @Size(max = 45)
    @Column(name = "account_code")
    private String accountCode;
    @Size(max = 45)
    @Column(name = "serial_no")
    private String serialNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchsed_value")
    private Double purchsedValue;
    @Column(name = "is_sold")
    private Integer isSold;
    @JoinColumn(name = "item_supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemSupplier itemSupplierId;
    @JoinColumn(name = "org_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgItem orgItemId;

    public OrgItemPurchsedDetail() {
    }

    public OrgItemPurchsedDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPurchsedDate() {
        return purchsedDate;
    }

    public void setPurchsedDate(Date purchsedDate) {
        this.purchsedDate = purchsedDate;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Double getPurchsedValue() {
        return purchsedValue;
    }

    public void setPurchsedValue(Double purchsedValue) {
        this.purchsedValue = purchsedValue;
    }

    public Integer getIsSold() {
        return isSold;
    }

    public void setIsSold(Integer isSold) {
        this.isSold = isSold;
    }

    public ItemSupplier getItemSupplierId() {
        return itemSupplierId;
    }

    public void setItemSupplierId(ItemSupplier itemSupplierId) {
        this.itemSupplierId = itemSupplierId;
    }

    public OrgItem getOrgItemId() {
        return orgItemId;
    }

    public void setOrgItemId(OrgItem orgItemId) {
        this.orgItemId = orgItemId;
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
        if (!(object instanceof OrgItemPurchsedDetail)) {
            return false;
        }
        OrgItemPurchsedDetail other = (OrgItemPurchsedDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OrgItemPurchsedDetail[ id=" + id + " ]";
    }
    
}
