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
import javax.persistence.Lob;
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
@Table(name = "dispatched_invoice_return")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DispatchedInvoiceReturn.findAll", query = "SELECT d FROM DispatchedInvoiceReturn d")
    , @NamedQuery(name = "DispatchedInvoiceReturn.findById", query = "SELECT d FROM DispatchedInvoiceReturn d WHERE d.id = :id")
    , @NamedQuery(name = "DispatchedInvoiceReturn.findByDate", query = "SELECT d FROM DispatchedInvoiceReturn d WHERE d.date = :date")})
public class DispatchedInvoiceReturn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "uncommon_voucher_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UncommonVoucherDetails uncommonVoucherDetailsId;

    public DispatchedInvoiceReturn() {
    }

    public DispatchedInvoiceReturn(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UncommonVoucherDetails getUncommonVoucherDetailsId() {
        return uncommonVoucherDetailsId;
    }

    public void setUncommonVoucherDetailsId(UncommonVoucherDetails uncommonVoucherDetailsId) {
        this.uncommonVoucherDetailsId = uncommonVoucherDetailsId;
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
        if (!(object instanceof DispatchedInvoiceReturn)) {
            return false;
        }
        DispatchedInvoiceReturn other = (DispatchedInvoiceReturn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DispatchedInvoiceReturn[ id=" + id + " ]";
    }
    
}
