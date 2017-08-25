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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "stock_reconciliation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StockReconciliation.findAll", query = "SELECT s FROM StockReconciliation s")
    , @NamedQuery(name = "StockReconciliation.findById", query = "SELECT s FROM StockReconciliation s WHERE s.id = :id")
    , @NamedQuery(name = "StockReconciliation.findByQty", query = "SELECT s FROM StockReconciliation s WHERE s.qty = :qty")
    , @NamedQuery(name = "StockReconciliation.findByJustification", query = "SELECT s FROM StockReconciliation s WHERE s.justification = :justification")})
public class StockReconciliation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qty")
    private Double qty;
    @Size(max = 1000)
    @Column(name = "justification")
    private String justification;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "stock_history_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StockHistoryManager stockHistoryManagerId;

    public StockReconciliation() {
    }

    public StockReconciliation(Integer id) {
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

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public StockHistoryManager getStockHistoryManagerId() {
        return stockHistoryManagerId;
    }

    public void setStockHistoryManagerId(StockHistoryManager stockHistoryManagerId) {
        this.stockHistoryManagerId = stockHistoryManagerId;
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
        if (!(object instanceof StockReconciliation)) {
            return false;
        }
        StockReconciliation other = (StockReconciliation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.StockReconciliation[ id=" + id + " ]";
    }
    
}
