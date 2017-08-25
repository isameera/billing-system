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
@Table(name = "com_requisted_item_issue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComRequistedItemIssue.findAll", query = "SELECT c FROM ComRequistedItemIssue c")
    , @NamedQuery(name = "ComRequistedItemIssue.findById", query = "SELECT c FROM ComRequistedItemIssue c WHERE c.id = :id")
    , @NamedQuery(name = "ComRequistedItemIssue.findByQty", query = "SELECT c FROM ComRequistedItemIssue c WHERE c.qty = :qty")
    , @NamedQuery(name = "ComRequistedItemIssue.findByDate", query = "SELECT c FROM ComRequistedItemIssue c WHERE c.date = :date")
    , @NamedQuery(name = "ComRequistedItemIssue.findByValue", query = "SELECT c FROM ComRequistedItemIssue c WHERE c.value = :value")})
public class ComRequistedItemIssue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "value")
    private Double value;
    @JoinColumn(name = "com_requested_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ComRequestedItem comRequestedItemId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public ComRequistedItemIssue() {
    }

    public ComRequistedItemIssue(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ComRequestedItem getComRequestedItemId() {
        return comRequestedItemId;
    }

    public void setComRequestedItemId(ComRequestedItem comRequestedItemId) {
        this.comRequestedItemId = comRequestedItemId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof ComRequistedItemIssue)) {
            return false;
        }
        ComRequistedItemIssue other = (ComRequistedItemIssue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ComRequistedItemIssue[ id=" + id + " ]";
    }
    
}
