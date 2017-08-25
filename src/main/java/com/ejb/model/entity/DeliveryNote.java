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
@Table(name = "delivery_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeliveryNote.findAll", query = "SELECT d FROM DeliveryNote d")
    , @NamedQuery(name = "DeliveryNote.findById", query = "SELECT d FROM DeliveryNote d WHERE d.id = :id")
    , @NamedQuery(name = "DeliveryNote.findByDeliveryNoteId", query = "SELECT d FROM DeliveryNote d WHERE d.deliveryNoteId = :deliveryNoteId")
    , @NamedQuery(name = "DeliveryNote.findByReference", query = "SELECT d FROM DeliveryNote d WHERE d.reference = :reference")
    , @NamedQuery(name = "DeliveryNote.findByDate", query = "SELECT d FROM DeliveryNote d WHERE d.date = :date")
    , @NamedQuery(name = "DeliveryNote.findByIsCompleted", query = "SELECT d FROM DeliveryNote d WHERE d.isCompleted = :isCompleted")})
public class DeliveryNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "delivery_note_id")
    private String deliveryNoteId;
    @Column(name = "reference")
    private Integer reference;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "is_completed")
    private Integer isCompleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryNoteId")
    private Collection<UncommonDispatchNote> uncommonDispatchNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryNoteId")
    private Collection<WarehouseGrnDetails> warehouseGrnDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryNoteId")
    private Collection<DeliveryNoteManager> deliveryNoteManagerCollection;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryNoteId")
    private Collection<DeliveryAcceptanceNote> deliveryAcceptanceNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryNoteId")
    private Collection<InvoiceDispatchManager> invoiceDispatchManagerCollection;

    public DeliveryNote() {
    }

    public DeliveryNote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryNoteId() {
        return deliveryNoteId;
    }

    public void setDeliveryNoteId(String deliveryNoteId) {
        this.deliveryNoteId = deliveryNoteId;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Integer isCompleted) {
        this.isCompleted = isCompleted;
    }

    @XmlTransient
    public Collection<UncommonDispatchNote> getUncommonDispatchNoteCollection() {
        return uncommonDispatchNoteCollection;
    }

    public void setUncommonDispatchNoteCollection(Collection<UncommonDispatchNote> uncommonDispatchNoteCollection) {
        this.uncommonDispatchNoteCollection = uncommonDispatchNoteCollection;
    }

    @XmlTransient
    public Collection<WarehouseGrnDetails> getWarehouseGrnDetailsCollection() {
        return warehouseGrnDetailsCollection;
    }

    public void setWarehouseGrnDetailsCollection(Collection<WarehouseGrnDetails> warehouseGrnDetailsCollection) {
        this.warehouseGrnDetailsCollection = warehouseGrnDetailsCollection;
    }

    @XmlTransient
    public Collection<DeliveryNoteManager> getDeliveryNoteManagerCollection() {
        return deliveryNoteManagerCollection;
    }

    public void setDeliveryNoteManagerCollection(Collection<DeliveryNoteManager> deliveryNoteManagerCollection) {
        this.deliveryNoteManagerCollection = deliveryNoteManagerCollection;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    @XmlTransient
    public Collection<DeliveryAcceptanceNote> getDeliveryAcceptanceNoteCollection() {
        return deliveryAcceptanceNoteCollection;
    }

    public void setDeliveryAcceptanceNoteCollection(Collection<DeliveryAcceptanceNote> deliveryAcceptanceNoteCollection) {
        this.deliveryAcceptanceNoteCollection = deliveryAcceptanceNoteCollection;
    }

    @XmlTransient
    public Collection<InvoiceDispatchManager> getInvoiceDispatchManagerCollection() {
        return invoiceDispatchManagerCollection;
    }

    public void setInvoiceDispatchManagerCollection(Collection<InvoiceDispatchManager> invoiceDispatchManagerCollection) {
        this.invoiceDispatchManagerCollection = invoiceDispatchManagerCollection;
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
        if (!(object instanceof DeliveryNote)) {
            return false;
        }
        DeliveryNote other = (DeliveryNote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DeliveryNote[ id=" + id + " ]";
    }
    
}
