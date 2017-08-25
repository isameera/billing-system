/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "gate_pass")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GatePass.findAll", query = "SELECT g FROM GatePass g")
    , @NamedQuery(name = "GatePass.findById", query = "SELECT g FROM GatePass g WHERE g.id = :id")
    , @NamedQuery(name = "GatePass.findByGatepassId", query = "SELECT g FROM GatePass g WHERE g.gatepassId = :gatepassId")
    , @NamedQuery(name = "GatePass.findByDate", query = "SELECT g FROM GatePass g WHERE g.date = :date")
    , @NamedQuery(name = "GatePass.findByHandOverTo", query = "SELECT g FROM GatePass g WHERE g.handOverTo = :handOverTo")})
public class GatePass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "gatepass_id")
    private String gatepassId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 255)
    @Column(name = "hand_over_to")
    private String handOverTo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gatePassId")
    private Collection<GatePassItem> gatePassItemCollection;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "supplier_registration_id", referencedColumnName = "id")
    @ManyToOne
    private SupplierRegistration supplierRegistrationId;
    @JoinColumn(name = "universal_qty_item_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalQtyItemTypeManager universalQtyItemTypeManagerId;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne
    private Vehicle vehicleId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public GatePass() {
    }

    public GatePass(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGatepassId() {
        return gatepassId;
    }

    public void setGatepassId(String gatepassId) {
        this.gatepassId = gatepassId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHandOverTo() {
        return handOverTo;
    }

    public void setHandOverTo(String handOverTo) {
        this.handOverTo = handOverTo;
    }

    @XmlTransient
    public Collection<GatePassItem> getGatePassItemCollection() {
        return gatePassItemCollection;
    }

    public void setGatePassItemCollection(Collection<GatePassItem> gatePassItemCollection) {
        this.gatePassItemCollection = gatePassItemCollection;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public SupplierRegistration getSupplierRegistrationId() {
        return supplierRegistrationId;
    }

    public void setSupplierRegistrationId(SupplierRegistration supplierRegistrationId) {
        this.supplierRegistrationId = supplierRegistrationId;
    }

    public UniversalQtyItemTypeManager getUniversalQtyItemTypeManagerId() {
        return universalQtyItemTypeManagerId;
    }

    public void setUniversalQtyItemTypeManagerId(UniversalQtyItemTypeManager universalQtyItemTypeManagerId) {
        this.universalQtyItemTypeManagerId = universalQtyItemTypeManagerId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof GatePass)) {
            return false;
        }
        GatePass other = (GatePass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.GatePass[ id=" + id + " ]";
    }
    
}
