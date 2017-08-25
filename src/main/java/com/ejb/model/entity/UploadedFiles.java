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
@Table(name = "uploaded_files")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UploadedFiles.findAll", query = "SELECT u FROM UploadedFiles u")
    , @NamedQuery(name = "UploadedFiles.findById", query = "SELECT u FROM UploadedFiles u WHERE u.id = :id")
    , @NamedQuery(name = "UploadedFiles.findByName", query = "SELECT u FROM UploadedFiles u WHERE u.name = :name")
    , @NamedQuery(name = "UploadedFiles.findByUrl", query = "SELECT u FROM UploadedFiles u WHERE u.url = :url")
    , @NamedQuery(name = "UploadedFiles.findByDate", query = "SELECT u FROM UploadedFiles u WHERE u.date = :date")})
public class UploadedFiles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 245)
    @Column(name = "name")
    private String name;
    @Size(max = 345)
    @Column(name = "url")
    private String url;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "document_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DocumentType documentTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uploadedFilesId")
    private Collection<UploadedFileManager> uploadedFileManagerCollection;

    public UploadedFiles() {
    }

    public UploadedFiles(Integer id) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DocumentType getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(DocumentType documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    @XmlTransient
    public Collection<UploadedFileManager> getUploadedFileManagerCollection() {
        return uploadedFileManagerCollection;
    }

    public void setUploadedFileManagerCollection(Collection<UploadedFileManager> uploadedFileManagerCollection) {
        this.uploadedFileManagerCollection = uploadedFileManagerCollection;
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
        if (!(object instanceof UploadedFiles)) {
            return false;
        }
        UploadedFiles other = (UploadedFiles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.UploadedFiles[ id=" + id + " ]";
    }
    
}
