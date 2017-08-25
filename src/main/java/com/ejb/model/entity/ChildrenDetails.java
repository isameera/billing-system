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
import javax.persistence.Lob;
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
@Table(name = "children_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChildrenDetails.findAll", query = "SELECT c FROM ChildrenDetails c")
    , @NamedQuery(name = "ChildrenDetails.findById", query = "SELECT c FROM ChildrenDetails c WHERE c.id = :id")
    , @NamedQuery(name = "ChildrenDetails.findByName", query = "SELECT c FROM ChildrenDetails c WHERE c.name = :name")
    , @NamedQuery(name = "ChildrenDetails.findByStatus", query = "SELECT c FROM ChildrenDetails c WHERE c.status = :status")})
public class ChildrenDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "name")
    private String name;
    @Size(max = 450)
    @Column(name = "status")
    private String status;
    @Lob
    @Size(max = 65535)
    @Column(name = "special_events")
    private String specialEvents;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "family_member_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FamilyMemberDetails familyMemberDetailsId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SupplierRegistration supplierRegistrationId;

    public ChildrenDetails() {
    }

    public ChildrenDetails(Integer id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialEvents() {
        return specialEvents;
    }

    public void setSpecialEvents(String specialEvents) {
        this.specialEvents = specialEvents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FamilyMemberDetails getFamilyMemberDetailsId() {
        return familyMemberDetailsId;
    }

    public void setFamilyMemberDetailsId(FamilyMemberDetails familyMemberDetailsId) {
        this.familyMemberDetailsId = familyMemberDetailsId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
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
        if (!(object instanceof ChildrenDetails)) {
            return false;
        }
        ChildrenDetails other = (ChildrenDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ChildrenDetails[ id=" + id + " ]";
    }
    
}
