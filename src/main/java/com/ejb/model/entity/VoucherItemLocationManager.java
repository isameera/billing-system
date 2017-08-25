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
@Table(name = "voucher_item_location_manager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherItemLocationManager.findAll", query = "SELECT v FROM VoucherItemLocationManager v")
    , @NamedQuery(name = "VoucherItemLocationManager.findById", query = "SELECT v FROM VoucherItemLocationManager v WHERE v.id = :id")})
public class VoucherItemLocationManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "org_location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OrgLocation orgLocationId;
    @JoinColumn(name = "voucher_item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VoucherItem voucherItemId;

    public VoucherItemLocationManager() {
    }

    public VoucherItemLocationManager(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrgLocation getOrgLocationId() {
        return orgLocationId;
    }

    public void setOrgLocationId(OrgLocation orgLocationId) {
        this.orgLocationId = orgLocationId;
    }

    public VoucherItem getVoucherItemId() {
        return voucherItemId;
    }

    public void setVoucherItemId(VoucherItem voucherItemId) {
        this.voucherItemId = voucherItemId;
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
        if (!(object instanceof VoucherItemLocationManager)) {
            return false;
        }
        VoucherItemLocationManager other = (VoucherItemLocationManager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherItemLocationManager[ id=" + id + " ]";
    }
    
}
