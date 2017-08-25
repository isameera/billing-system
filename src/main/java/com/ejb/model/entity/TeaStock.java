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
@Table(name = "tea_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeaStock.findAll", query = "SELECT t FROM TeaStock t")
    , @NamedQuery(name = "TeaStock.findById", query = "SELECT t FROM TeaStock t WHERE t.id = :id")
    , @NamedQuery(name = "TeaStock.findByDate", query = "SELECT t FROM TeaStock t WHERE t.date = :date")
    , @NamedQuery(name = "TeaStock.findByQty", query = "SELECT t FROM TeaStock t WHERE t.qty = :qty")
    , @NamedQuery(name = "TeaStock.findByAvg", query = "SELECT t FROM TeaStock t WHERE t.avg = :avg")
    , @NamedQuery(name = "TeaStock.findByAmount", query = "SELECT t FROM TeaStock t WHERE t.amount = :amount")})
public class TeaStock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Column(name = "avg")
    private Double avg;
    @Column(name = "amount")
    private Double amount;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "tea_stock_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TeaStockLocation teaStockLocationId;

    public TeaStock() {
    }

    public TeaStock(Integer id) {
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

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public TeaStockLocation getTeaStockLocationId() {
        return teaStockLocationId;
    }

    public void setTeaStockLocationId(TeaStockLocation teaStockLocationId) {
        this.teaStockLocationId = teaStockLocationId;
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
        if (!(object instanceof TeaStock)) {
            return false;
        }
        TeaStock other = (TeaStock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.TeaStock[ id=" + id + " ]";
    }
    
}
