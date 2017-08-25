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
@Table(name = "old_voucher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OldVoucher.findAll", query = "SELECT o FROM OldVoucher o")
    , @NamedQuery(name = "OldVoucher.findById", query = "SELECT o FROM OldVoucher o WHERE o.id = :id")
    , @NamedQuery(name = "OldVoucher.findByVoucherId", query = "SELECT o FROM OldVoucher o WHERE o.voucherId = :voucherId")})
public class OldVoucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "voucher_id")
    private String voucherId;
    @JoinColumn(name = "voucher_id1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId1;

    public OldVoucher() {
    }

    public OldVoucher(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }

    public Voucher getVoucherId1() {
        return voucherId1;
    }

    public void setVoucherId1(Voucher voucherId1) {
        this.voucherId1 = voucherId1;
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
        if (!(object instanceof OldVoucher)) {
            return false;
        }
        OldVoucher other = (OldVoucher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.OldVoucher[ id=" + id + " ]";
    }
    
}
