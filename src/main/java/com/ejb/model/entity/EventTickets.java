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
@Table(name = "event_tickets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventTickets.findAll", query = "SELECT e FROM EventTickets e")
    , @NamedQuery(name = "EventTickets.findById", query = "SELECT e FROM EventTickets e WHERE e.id = :id")
    , @NamedQuery(name = "EventTickets.findByImg", query = "SELECT e FROM EventTickets e WHERE e.img = :img")
    , @NamedQuery(name = "EventTickets.findByPrice", query = "SELECT e FROM EventTickets e WHERE e.price = :price")})
public class EventTickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "img")
    private String img;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private BankAccount bankAccountId;
    @JoinColumn(name = "social_media_events_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SocialMediaEvents socialMediaEventsId;

    public EventTickets() {
    }

    public EventTickets(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public BankAccount getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccount bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public SocialMediaEvents getSocialMediaEventsId() {
        return socialMediaEventsId;
    }

    public void setSocialMediaEventsId(SocialMediaEvents socialMediaEventsId) {
        this.socialMediaEventsId = socialMediaEventsId;
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
        if (!(object instanceof EventTickets)) {
            return false;
        }
        EventTickets other = (EventTickets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EventTickets[ id=" + id + " ]";
    }
    
}
