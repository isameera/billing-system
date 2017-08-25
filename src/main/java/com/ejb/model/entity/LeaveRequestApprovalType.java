/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "leave_request_approval_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequestApprovalType.findAll", query = "SELECT l FROM LeaveRequestApprovalType l")
    , @NamedQuery(name = "LeaveRequestApprovalType.findById", query = "SELECT l FROM LeaveRequestApprovalType l WHERE l.id = :id")
    , @NamedQuery(name = "LeaveRequestApprovalType.findByName", query = "SELECT l FROM LeaveRequestApprovalType l WHERE l.name = :name")})
public class LeaveRequestApprovalType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveRequestApprovalTypeId")
    private Collection<LeaveRequestApproval> leaveRequestApprovalCollection;

    public LeaveRequestApprovalType() {
    }

    public LeaveRequestApprovalType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<LeaveRequestApproval> getLeaveRequestApprovalCollection() {
        return leaveRequestApprovalCollection;
    }

    public void setLeaveRequestApprovalCollection(Collection<LeaveRequestApproval> leaveRequestApprovalCollection) {
        this.leaveRequestApprovalCollection = leaveRequestApprovalCollection;
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
        if (!(object instanceof LeaveRequestApprovalType)) {
            return false;
        }
        LeaveRequestApprovalType other = (LeaveRequestApprovalType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.LeaveRequestApprovalType[ id=" + id + " ]";
    }
    
}
