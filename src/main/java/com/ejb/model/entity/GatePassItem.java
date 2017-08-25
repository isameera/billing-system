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
@Table(name = "gate_pass_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GatePassItem.findAll", query = "SELECT g FROM GatePassItem g")
    , @NamedQuery(name = "GatePassItem.findById", query = "SELECT g FROM GatePassItem g WHERE g.id = :id")})
public class GatePassItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "gate_pass_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GatePass gatePassId;
    @JoinColumn(name = "universal_boughtleaf_item_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalBoughtleafItemRequest universalBoughtleafItemRequestId;

    public GatePassItem() {
    }

    public GatePassItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GatePass getGatePassId() {
        return gatePassId;
    }

    public void setGatePassId(GatePass gatePassId) {
        this.gatePassId = gatePassId;
    }

    public UniversalBoughtleafItemRequest getUniversalBoughtleafItemRequestId() {
        return universalBoughtleafItemRequestId;
    }

    public void setUniversalBoughtleafItemRequestId(UniversalBoughtleafItemRequest universalBoughtleafItemRequestId) {
        this.universalBoughtleafItemRequestId = universalBoughtleafItemRequestId;
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
        if (!(object instanceof GatePassItem)) {
            return false;
        }
        GatePassItem other = (GatePassItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GatePassItem[ id=" + id + " ]";
    }
    
}
