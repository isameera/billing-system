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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "delivery_acceptance_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryAcceptanceNote.findAll", query = "SELECT d FROM DeliveryAcceptanceNote d")
    , @NamedQuery(name = "DeliveryAcceptanceNote.findById", query = "SELECT d FROM DeliveryAcceptanceNote d WHERE d.id = :id")
    , @NamedQuery(name = "DeliveryAcceptanceNote.findByAcceptanceNoteId", query = "SELECT d FROM DeliveryAcceptanceNote d WHERE d.acceptanceNoteId = :acceptanceNoteId")
    , @NamedQuery(name = "DeliveryAcceptanceNote.findByDate", query = "SELECT d FROM DeliveryAcceptanceNote d WHERE d.date = :date")})
public class DeliveryAcceptanceNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "acceptance_note_id")
    private String acceptanceNoteId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "delivery_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DeliveryNote deliveryNoteId;
    @JoinColumn(name = "accepted_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile acceptedBy;

    public DeliveryAcceptanceNote() {
    }

    public DeliveryAcceptanceNote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcceptanceNoteId() {
        return acceptanceNoteId;
    }

    public void setAcceptanceNoteId(String acceptanceNoteId) {
        this.acceptanceNoteId = acceptanceNoteId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public DeliveryNote getDeliveryNoteId() {
        return deliveryNoteId;
    }

    public void setDeliveryNoteId(DeliveryNote deliveryNoteId) {
        this.deliveryNoteId = deliveryNoteId;
    }

    public GeneralUserProfile getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(GeneralUserProfile acceptedBy) {
        this.acceptedBy = acceptedBy;
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
        if (!(object instanceof DeliveryAcceptanceNote)) {
            return false;
        }
        DeliveryAcceptanceNote other = (DeliveryAcceptanceNote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DeliveryAcceptanceNote[ id=" + id + " ]";
    }
    
}
