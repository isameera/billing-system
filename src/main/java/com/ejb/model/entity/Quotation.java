/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "quotation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quotation.findAll", query = "SELECT q FROM Quotation q")
    , @NamedQuery(name = "Quotation.findById", query = "SELECT q FROM Quotation q WHERE q.id = :id")
    , @NamedQuery(name = "Quotation.findByWarrentyPeriod", query = "SELECT q FROM Quotation q WHERE q.warrentyPeriod = :warrentyPeriod")
    , @NamedQuery(name = "Quotation.findByCreditPeriod", query = "SELECT q FROM Quotation q WHERE q.creditPeriod = :creditPeriod")
    , @NamedQuery(name = "Quotation.findByValidityPeriod", query = "SELECT q FROM Quotation q WHERE q.validityPeriod = :validityPeriod")
    , @NamedQuery(name = "Quotation.findByAdvance", query = "SELECT q FROM Quotation q WHERE q.advance = :advance")})
public class Quotation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "warrenty_period")
    private Double warrentyPeriod;
    @Column(name = "credit_period")
    private Integer creditPeriod;
    @Column(name = "validity_period")
    private Double validityPeriod;
    @Column(name = "advance")
    private Double advance;
    @JoinColumn(name = "prepared_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee preparedBy;
    @JoinColumn(name = "authorized_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee authorizedBy;
    @JoinColumn(name = "attention", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile attention;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public Quotation() {
    }

    public Quotation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWarrentyPeriod() {
        return warrentyPeriod;
    }

    public void setWarrentyPeriod(Double warrentyPeriod) {
        this.warrentyPeriod = warrentyPeriod;
    }

    public Integer getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(Integer creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public Double getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Double validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public Employee getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(Employee preparedBy) {
        this.preparedBy = preparedBy;
    }

    public Employee getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(Employee authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public GeneralUserProfile getAttention() {
        return attention;
    }

    public void setAttention(GeneralUserProfile attention) {
        this.attention = attention;
    }

    public Voucher getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Voucher voucherId) {
        this.voucherId = voucherId;
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
        if (!(object instanceof Quotation)) {
            return false;
        }
        Quotation other = (Quotation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.Quotation[ id=" + id + " ]";
    }
    
}
