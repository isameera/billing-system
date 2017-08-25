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
import javax.persistence.Lob;
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
@Table(name = "vehicle_insurance_clame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleInsuranceClame.findAll", query = "SELECT v FROM VehicleInsuranceClame v")
    , @NamedQuery(name = "VehicleInsuranceClame.findById", query = "SELECT v FROM VehicleInsuranceClame v WHERE v.id = :id")
    , @NamedQuery(name = "VehicleInsuranceClame.findByDateOfAccident", query = "SELECT v FROM VehicleInsuranceClame v WHERE v.dateOfAccident = :dateOfAccident")
    , @NamedQuery(name = "VehicleInsuranceClame.findByDateOfClame", query = "SELECT v FROM VehicleInsuranceClame v WHERE v.dateOfClame = :dateOfClame")
    , @NamedQuery(name = "VehicleInsuranceClame.findByAmount", query = "SELECT v FROM VehicleInsuranceClame v WHERE v.amount = :amount")})
public class VehicleInsuranceClame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_of_accident")
    @Temporal(TemporalType.DATE)
    private Date dateOfAccident;
    @Column(name = "date_of_clame")
    @Temporal(TemporalType.DATE)
    private Date dateOfClame;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reason")
    private String reason;
    @Lob
    @Size(max = 65535)
    @Column(name = "about_damage")
    private String aboutDamage;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "repaired_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile repairedBy;
    @JoinColumn(name = "drive_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile driveBy;
    @JoinColumn(name = "vehicle_insurance_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VehicleInsurance vehicleInsuranceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleInsuranceClameId")
    private Collection<AccidentImage> accidentImageCollection;

    public VehicleInsuranceClame() {
    }

    public VehicleInsuranceClame(Integer id) {
        this.id = id;
    }

    public VehicleInsuranceClame(Integer id, Date dateOfAccident, double amount, String reason) {
        this.id = id;
        this.dateOfAccident = dateOfAccident;
        this.amount = amount;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateOfAccident() {
        return dateOfAccident;
    }

    public void setDateOfAccident(Date dateOfAccident) {
        this.dateOfAccident = dateOfAccident;
    }

    public Date getDateOfClame() {
        return dateOfClame;
    }

    public void setDateOfClame(Date dateOfClame) {
        this.dateOfClame = dateOfClame;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAboutDamage() {
        return aboutDamage;
    }

    public void setAboutDamage(String aboutDamage) {
        this.aboutDamage = aboutDamage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GeneralOrganizationProfile getRepairedBy() {
        return repairedBy;
    }

    public void setRepairedBy(GeneralOrganizationProfile repairedBy) {
        this.repairedBy = repairedBy;
    }

    public GeneralUserProfile getDriveBy() {
        return driveBy;
    }

    public void setDriveBy(GeneralUserProfile driveBy) {
        this.driveBy = driveBy;
    }

    public VehicleInsurance getVehicleInsuranceId() {
        return vehicleInsuranceId;
    }

    public void setVehicleInsuranceId(VehicleInsurance vehicleInsuranceId) {
        this.vehicleInsuranceId = vehicleInsuranceId;
    }

    @XmlTransient
    public Collection<AccidentImage> getAccidentImageCollection() {
        return accidentImageCollection;
    }

    public void setAccidentImageCollection(Collection<AccidentImage> accidentImageCollection) {
        this.accidentImageCollection = accidentImageCollection;
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
        if (!(object instanceof VehicleInsuranceClame)) {
            return false;
        }
        VehicleInsuranceClame other = (VehicleInsuranceClame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.VehicleInsuranceClame[ id=" + id + " ]";
    }
    
}
