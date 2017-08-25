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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "document_attachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentAttachment.findAll", query = "SELECT d FROM DocumentAttachment d")
    , @NamedQuery(name = "DocumentAttachment.findById", query = "SELECT d FROM DocumentAttachment d WHERE d.id = :id")
    , @NamedQuery(name = "DocumentAttachment.findByUrl", query = "SELECT d FROM DocumentAttachment d WHERE d.url = :url")
    , @NamedQuery(name = "DocumentAttachment.findByFileSize", query = "SELECT d FROM DocumentAttachment d WHERE d.fileSize = :fileSize")})
public class DocumentAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 450)
    @Column(name = "url")
    private String url;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "file_size")
    private Double fileSize;
    @JoinColumn(name = "attachment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AttachmentType attachmentTypeId;
    @JoinColumn(name = "document_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentMaster documentId;

    public DocumentAttachment() {
    }

    public DocumentAttachment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }

    public AttachmentType getAttachmentTypeId() {
        return attachmentTypeId;
    }

    public void setAttachmentTypeId(AttachmentType attachmentTypeId) {
        this.attachmentTypeId = attachmentTypeId;
    }

    public DocumentMaster getDocumentId() {
        return documentId;
    }

    public void setDocumentId(DocumentMaster documentId) {
        this.documentId = documentId;
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
        if (!(object instanceof DocumentAttachment)) {
            return false;
        }
        DocumentAttachment other = (DocumentAttachment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.DocumentAttachment[ id=" + id + " ]";
    }
    
}
