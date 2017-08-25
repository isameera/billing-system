/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "schools_attended")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolsAttended.findAll", query = "SELECT s FROM SchoolsAttended s")
    , @NamedQuery(name = "SchoolsAttended.findById", query = "SELECT s FROM SchoolsAttended s WHERE s.id = :id")
    , @NamedQuery(name = "SchoolsAttended.findByDateRom", query = "SELECT s FROM SchoolsAttended s WHERE s.dateRom = :dateRom")
    , @NamedQuery(name = "SchoolsAttended.findByDateTo", query = "SELECT s FROM SchoolsAttended s WHERE s.dateTo = :dateTo")})
public class SchoolsAttended implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_rom")
    @Temporal(TemporalType.DATE)
    private Date dateRom;
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "general_user_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile generalUserProfileId;
    @JoinColumn(name = "schools_attended_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SchoolsAttendedType schoolsAttendedTypeId;

    public SchoolsAttended() {
    }

    public SchoolsAttended(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateRom() {
        return dateRom;
    }

    public void setDateRom(Date dateRom) {
        this.dateRom = dateRom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getGeneralUserProfileId() {
        return generalUserProfileId;
    }

    public void setGeneralUserProfileId(GeneralUserProfile generalUserProfileId) {
        this.generalUserProfileId = generalUserProfileId;
    }

    public SchoolsAttendedType getSchoolsAttendedTypeId() {
        return schoolsAttendedTypeId;
    }

    public void setSchoolsAttendedTypeId(SchoolsAttendedType schoolsAttendedTypeId) {
        this.schoolsAttendedTypeId = schoolsAttendedTypeId;
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
        if (!(object instanceof SchoolsAttended)) {
            return false;
        }
        SchoolsAttended other = (SchoolsAttended) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.SchoolsAttended[ id=" + id + " ]";
    }
    
}
