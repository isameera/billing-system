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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sameera
 */
@Entity
@Table(name = "cheque_condition_controller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChequeConditionController.findAll", query = "SELECT c FROM ChequeConditionController c")
    , @NamedQuery(name = "ChequeConditionController.findById", query = "SELECT c FROM ChequeConditionController c WHERE c.id = :id")})
public class ChequeConditionController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "cheque_codition_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChequeCodition chequeCoditionId;
    @JoinColumn(name = "cheque_details_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ChequeDetails chequeDetailsId;

    public ChequeConditionController() {
    }

    public ChequeConditionController(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChequeCodition getChequeCoditionId() {
        return chequeCoditionId;
    }

    public void setChequeCoditionId(ChequeCodition chequeCoditionId) {
        this.chequeCoditionId = chequeCoditionId;
    }

    public ChequeDetails getChequeDetailsId() {
        return chequeDetailsId;
    }

    public void setChequeDetailsId(ChequeDetails chequeDetailsId) {
        this.chequeDetailsId = chequeDetailsId;
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
        if (!(object instanceof ChequeConditionController)) {
            return false;
        }
        ChequeConditionController other = (ChequeConditionController) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.ChequeConditionController[ id=" + id + " ]";
    }
    
}
