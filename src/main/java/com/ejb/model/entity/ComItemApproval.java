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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "com_item_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComItemApproval.findAll", query = "SELECT c FROM ComItemApproval c")
    , @NamedQuery(name = "ComItemApproval.findById", query = "SELECT c FROM ComItemApproval c WHERE c.id = :id")
    , @NamedQuery(name = "ComItemApproval.findByDate", query = "SELECT c FROM ComItemApproval c WHERE c.date = :date")})
public class ComItemApproval implements Serializable {

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
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "com_item_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComItemRequest comItemRequestId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comItemApprovalId")
    private Collection<PurchaseMethod> purchaseMethodCollection;

    public ComItemApproval() {
    }

    public ComItemApproval(Integer id) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ComItemRequest getComItemRequestId() {
        return comItemRequestId;
    }

    public void setComItemRequestId(ComItemRequest comItemRequestId) {
        this.comItemRequestId = comItemRequestId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @XmlTransient
    public Collection<PurchaseMethod> getPurchaseMethodCollection() {
        return purchaseMethodCollection;
    }

    public void setPurchaseMethodCollection(Collection<PurchaseMethod> purchaseMethodCollection) {
        this.purchaseMethodCollection = purchaseMethodCollection;
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
        if (!(object instanceof ComItemApproval)) {
            return false;
        }
        ComItemApproval other = (ComItemApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComItemApproval[ id=" + id + " ]";
    }
    
}
