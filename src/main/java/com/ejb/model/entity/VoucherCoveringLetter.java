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
@Table(name = "voucher_covering_letter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VoucherCoveringLetter.findAll", query = "SELECT v FROM VoucherCoveringLetter v")
    , @NamedQuery(name = "VoucherCoveringLetter.findById", query = "SELECT v FROM VoucherCoveringLetter v WHERE v.id = :id")})
public class VoucherCoveringLetter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "document_master_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentMaster documentMasterId;
    @JoinColumn(name = "voucher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Voucher voucherId;

    public VoucherCoveringLetter() {
    }

    public VoucherCoveringLetter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentMaster getDocumentMasterId() {
        return documentMasterId;
    }

    public void setDocumentMasterId(DocumentMaster documentMasterId) {
        this.documentMasterId = documentMasterId;
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
        if (!(object instanceof VoucherCoveringLetter)) {
            return false;
        }
        VoucherCoveringLetter other = (VoucherCoveringLetter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VoucherCoveringLetter[ id=" + id + " ]";
    }
    
}
