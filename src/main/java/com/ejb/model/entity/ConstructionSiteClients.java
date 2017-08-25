/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.model.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "construction_site_clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConstructionSiteClients.findAll", query = "SELECT c FROM ConstructionSiteClients c")
    , @NamedQuery(name = "ConstructionSiteClients.findById", query = "SELECT c FROM ConstructionSiteClients c WHERE c.id = :id")
    , @NamedQuery(name = "ConstructionSiteClients.findByReference", query = "SELECT c FROM ConstructionSiteClients c WHERE c.reference = :reference")})
public class ConstructionSiteClients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "reference")
    private Integer reference;
    @JoinColumn(name = "construction_contract_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstructionContract constructionContractId;
    @JoinColumn(name = "construction_site_clients_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ConstructionSiteClientsType constructionSiteClientsTypeId;
    @JoinColumn(name = "universal_person_or_org_type_manager_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constructionSiteClientsId")
    private Collection<ConstructionContractVoucherManager> constructionContractVoucherManagerCollection;

    public ConstructionSiteClients() {
    }

    public ConstructionSiteClients(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public ConstructionContract getConstructionContractId() {
        return constructionContractId;
    }

    public void setConstructionContractId(ConstructionContract constructionContractId) {
        this.constructionContractId = constructionContractId;
    }

    public ConstructionSiteClientsType getConstructionSiteClientsTypeId() {
        return constructionSiteClientsTypeId;
    }

    public void setConstructionSiteClientsTypeId(ConstructionSiteClientsType constructionSiteClientsTypeId) {
        this.constructionSiteClientsTypeId = constructionSiteClientsTypeId;
    }

    public UniversalPersonOrOrgTypeManager getUniversalPersonOrOrgTypeManagerId() {
        return universalPersonOrOrgTypeManagerId;
    }

    public void setUniversalPersonOrOrgTypeManagerId(UniversalPersonOrOrgTypeManager universalPersonOrOrgTypeManagerId) {
        this.universalPersonOrOrgTypeManagerId = universalPersonOrOrgTypeManagerId;
    }

    @XmlTransient
    public Collection<ConstructionContractVoucherManager> getConstructionContractVoucherManagerCollection() {
        return constructionContractVoucherManagerCollection;
    }

    public void setConstructionContractVoucherManagerCollection(Collection<ConstructionContractVoucherManager> constructionContractVoucherManagerCollection) {
        this.constructionContractVoucherManagerCollection = constructionContractVoucherManagerCollection;
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
        if (!(object instanceof ConstructionSiteClients)) {
            return false;
        }
        ConstructionSiteClients other = (ConstructionSiteClients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ConstructionSiteClients[ id=" + id + " ]";
    }
    
}
