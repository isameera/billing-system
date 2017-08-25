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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "document_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentMaster.findAll", query = "SELECT d FROM DocumentMaster d")
    , @NamedQuery(name = "DocumentMaster.findById", query = "SELECT d FROM DocumentMaster d WHERE d.id = :id")
    , @NamedQuery(name = "DocumentMaster.findByDocumentId", query = "SELECT d FROM DocumentMaster d WHERE d.documentId = :documentId")
    , @NamedQuery(name = "DocumentMaster.findByCreatedDate", query = "SELECT d FROM DocumentMaster d WHERE d.createdDate = :createdDate")})
public class DocumentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "document_id")
    private String documentId;
    @Lob
    @Size(max = 65535)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentId")
    private Collection<DocumentAttachment> documentAttachmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentMasterId")
    private Collection<VoucherCoveringLetter> voucherCoveringLetterCollection;
    @JoinColumn(name = "document_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentType documentTypeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralUserProfile createdBy;
    @JoinColumn(name = "document_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentCategory documentCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentId")
    private Collection<DocumentContent> documentContentCollection;

    public DocumentMaster() {
    }

    public DocumentMaster(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Collection<DocumentAttachment> getDocumentAttachmentCollection() {
        return documentAttachmentCollection;
    }

    public void setDocumentAttachmentCollection(Collection<DocumentAttachment> documentAttachmentCollection) {
        this.documentAttachmentCollection = documentAttachmentCollection;
    }

    @XmlTransient
    public Collection<VoucherCoveringLetter> getVoucherCoveringLetterCollection() {
        return voucherCoveringLetterCollection;
    }

    public void setVoucherCoveringLetterCollection(Collection<VoucherCoveringLetter> voucherCoveringLetterCollection) {
        this.voucherCoveringLetterCollection = voucherCoveringLetterCollection;
    }

    public DocumentType getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(DocumentType documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
    }

    public GeneralUserProfile getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(GeneralUserProfile createdBy) {
        this.createdBy = createdBy;
    }

    public DocumentCategory getDocumentCategoryId() {
        return documentCategoryId;
    }

    public void setDocumentCategoryId(DocumentCategory documentCategoryId) {
        this.documentCategoryId = documentCategoryId;
    }

    @XmlTransient
    public Collection<DocumentContent> getDocumentContentCollection() {
        return documentContentCollection;
    }

    public void setDocumentContentCollection(Collection<DocumentContent> documentContentCollection) {
        this.documentContentCollection = documentContentCollection;
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
        if (!(object instanceof DocumentMaster)) {
            return false;
        }
        DocumentMaster other = (DocumentMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DocumentMaster[ id=" + id + " ]";
    }
    
}
