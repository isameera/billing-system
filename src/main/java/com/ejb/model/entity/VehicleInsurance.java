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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "vehicle_insurance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleInsurance.findAll", query = "SELECT v FROM VehicleInsurance v")
    , @NamedQuery(name = "VehicleInsurance.findById", query = "SELECT v FROM VehicleInsurance v WHERE v.id = :id")
    , @NamedQuery(name = "VehicleInsurance.findByDateOfRenewal", query = "SELECT v FROM VehicleInsurance v WHERE v.dateOfRenewal = :dateOfRenewal")
    , @NamedQuery(name = "VehicleInsurance.findByDateOfExp", query = "SELECT v FROM VehicleInsurance v WHERE v.dateOfExp = :dateOfExp")
    , @NamedQuery(name = "VehicleInsurance.findByCost", query = "SELECT v FROM VehicleInsurance v WHERE v.cost = :cost")
    , @NamedQuery(name = "VehicleInsurance.findByIsClaimed", query = "SELECT v FROM VehicleInsurance v WHERE v.isClaimed = :isClaimed")
    , @NamedQuery(name = "VehicleInsurance.findByComment", query = "SELECT v FROM VehicleInsurance v WHERE v.comment = :comment")})
public class VehicleInsurance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_renewal")
    @Temporal(TemporalType.DATE)
    private Date dateOfRenewal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_exp")
    @Temporal(TemporalType.DATE)
    private Date dateOfExp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_claimed")
    private int isClaimed;
    @Size(max = 1005)
    @Column(name = "comment")
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleInsuranceId")
    private Collection<VehicleInsuranceClame> vehicleInsuranceClameCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "insurance_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InsuranceType insuranceTypeId;
    @JoinColumn(name = "vehicle_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vehicle vehicleId;

    public VehicleInsurance() {
    }

    public VehicleInsurance(Integer id) {
        this.id = id;
    }

    public VehicleInsurance(Integer id, Date dateOfRenewal, Date dateOfExp, double cost, int isClaimed) {
        this.id = id;
        this.dateOfRenewal = dateOfRenewal;
        this.dateOfExp = dateOfExp;
        this.cost = cost;
        this.isClaimed = isClaimed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfRenewal() {
        return dateOfRenewal;
    }

    public void setDateOfRenewal(Date dateOfRenewal) {
        this.dateOfRenewal = dateOfRenewal;
    }

    public Date getDateOfExp() {
        return dateOfExp;
    }

    public void setDateOfExp(Date dateOfExp) {
        this.dateOfExp = dateOfExp;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(int isClaimed) {
        this.isClaimed = isClaimed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<VehicleInsuranceClame> getVehicleInsuranceClameCollection() {
        return vehicleInsuranceClameCollection;
    }

    public void setVehicleInsuranceClameCollection(Collection<VehicleInsuranceClame> vehicleInsuranceClameCollection) {
        this.vehicleInsuranceClameCollection = vehicleInsuranceClameCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public InsuranceType getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(InsuranceType insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
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
        if (!(object instanceof VehicleInsurance)) {
            return false;
        }
        VehicleInsurance other = (VehicleInsurance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VehicleInsurance[ id=" + id + " ]";
    }
    
}
