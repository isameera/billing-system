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
@Table(name = "holiday_pay_register")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HolidayPayRegister.findAll", query = "SELECT h FROM HolidayPayRegister h")
    , @NamedQuery(name = "HolidayPayRegister.findById", query = "SELECT h FROM HolidayPayRegister h WHERE h.id = :id")
    , @NamedQuery(name = "HolidayPayRegister.findByYear", query = "SELECT h FROM HolidayPayRegister h WHERE h.year = :year")
    , @NamedQuery(name = "HolidayPayRegister.findByJanTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.janTotDays = :janTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByFebTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.febTotDays = :febTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByMarTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.marTotDays = :marTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByAprTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.aprTotDays = :aprTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByMayTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.mayTotDays = :mayTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByJunTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.junTotDays = :junTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByJulTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.julTotDays = :julTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByAugTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.augTotDays = :augTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findBySepTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.sepTotDays = :sepTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByOctTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.octTotDays = :octTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByNovTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.novTotDays = :novTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByDecTotDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.decTotDays = :decTotDays")
    , @NamedQuery(name = "HolidayPayRegister.findByTotalDays", query = "SELECT h FROM HolidayPayRegister h WHERE h.totalDays = :totalDays")
    , @NamedQuery(name = "HolidayPayRegister.findByWC", query = "SELECT h FROM HolidayPayRegister h WHERE h.wC = :wC")
    , @NamedQuery(name = "HolidayPayRegister.findByTotalMonths", query = "SELECT h FROM HolidayPayRegister h WHERE h.totalMonths = :totalMonths")
    , @NamedQuery(name = "HolidayPayRegister.findByHolidaysPrevious", query = "SELECT h FROM HolidayPayRegister h WHERE h.holidaysPrevious = :holidaysPrevious")
    , @NamedQuery(name = "HolidayPayRegister.findByQualifying", query = "SELECT h FROM HolidayPayRegister h WHERE h.qualifying = :qualifying")
    , @NamedQuery(name = "HolidayPayRegister.findByAttendancePerc", query = "SELECT h FROM HolidayPayRegister h WHERE h.attendancePerc = :attendancePerc")
    , @NamedQuery(name = "HolidayPayRegister.findByJanEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.janEarning = :janEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByFebEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.febEarning = :febEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByMarEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.marEarning = :marEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByAprEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.aprEarning = :aprEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByMayEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.mayEarning = :mayEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByJunEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.junEarning = :junEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByJulEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.julEarning = :julEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByAugEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.augEarning = :augEarning")
    , @NamedQuery(name = "HolidayPayRegister.findBySepEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.sepEarning = :sepEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByOctEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.octEarning = :octEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByNovEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.novEarning = :novEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByDecEarning", query = "SELECT h FROM HolidayPayRegister h WHERE h.decEarning = :decEarning")
    , @NamedQuery(name = "HolidayPayRegister.findByTotalEarnings", query = "SELECT h FROM HolidayPayRegister h WHERE h.totalEarnings = :totalEarnings")
    , @NamedQuery(name = "HolidayPayRegister.findByRatePerDay", query = "SELECT h FROM HolidayPayRegister h WHERE h.ratePerDay = :ratePerDay")
    , @NamedQuery(name = "HolidayPayRegister.findByHolidayPay", query = "SELECT h FROM HolidayPayRegister h WHERE h.holidayPay = :holidayPay")
    , @NamedQuery(name = "HolidayPayRegister.findByEpf8", query = "SELECT h FROM HolidayPayRegister h WHERE h.epf8 = :epf8")
    , @NamedQuery(name = "HolidayPayRegister.findByBalance", query = "SELECT h FROM HolidayPayRegister h WHERE h.balance = :balance")
    , @NamedQuery(name = "HolidayPayRegister.findByPss", query = "SELECT h FROM HolidayPayRegister h WHERE h.pss = :pss")
    , @NamedQuery(name = "HolidayPayRegister.findByAttendanceBonus", query = "SELECT h FROM HolidayPayRegister h WHERE h.attendanceBonus = :attendanceBonus")
    , @NamedQuery(name = "HolidayPayRegister.findByAmountPaid", query = "SELECT h FROM HolidayPayRegister h WHERE h.amountPaid = :amountPaid")})
public class HolidayPayRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "jan_tot_days")
    private Double janTotDays;
    @Column(name = "feb_tot_days")
    private Double febTotDays;
    @Column(name = "mar_tot_days")
    private Double marTotDays;
    @Column(name = "apr_tot_days")
    private Double aprTotDays;
    @Column(name = "may_tot_days")
    private Double mayTotDays;
    @Column(name = "jun_tot_days")
    private Double junTotDays;
    @Column(name = "jul_tot_days")
    private Double julTotDays;
    @Column(name = "aug_tot_days")
    private Double augTotDays;
    @Column(name = "sep_tot_days")
    private Double sepTotDays;
    @Column(name = "oct_tot_days")
    private Double octTotDays;
    @Column(name = "nov_tot_days")
    private Double novTotDays;
    @Column(name = "dec_tot_days")
    private Double decTotDays;
    @Column(name = "total_days")
    private Double totalDays;
    @Column(name = "w_c")
    private Double wC;
    @Column(name = "total_months")
    private Integer totalMonths;
    @Column(name = "holidays_previous")
    private Double holidaysPrevious;
    @Column(name = "qualifying")
    private Double qualifying;
    @Column(name = "attendance_perc")
    private Double attendancePerc;
    @Column(name = "jan_earning")
    private Double janEarning;
    @Column(name = "feb_earning")
    private Double febEarning;
    @Column(name = "mar_earning")
    private Double marEarning;
    @Column(name = "apr_earning")
    private Double aprEarning;
    @Column(name = "may_earning")
    private Double mayEarning;
    @Column(name = "jun_earning")
    private Double junEarning;
    @Column(name = "jul_earning")
    private Double julEarning;
    @Column(name = "aug_earning")
    private Double augEarning;
    @Column(name = "sep_earning")
    private Double sepEarning;
    @Column(name = "oct_earning")
    private Double octEarning;
    @Column(name = "nov_earning")
    private Double novEarning;
    @Column(name = "dec_earning")
    private Double decEarning;
    @Column(name = "total_earnings")
    private Double totalEarnings;
    @Column(name = "rate_per_day")
    private Double ratePerDay;
    @Column(name = "holiday_pay")
    private Double holidayPay;
    @Column(name = "epf_8")
    private Double epf8;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "pss")
    private Double pss;
    @Column(name = "attendance_bonus")
    private Double attendanceBonus;
    @Column(name = "amount_paid")
    private Double amountPaid;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "general_organization_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GeneralOrganizationProfile generalOrganizationProfileId;

    public HolidayPayRegister() {
    }

    public HolidayPayRegister(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getJanTotDays() {
        return janTotDays;
    }

    public void setJanTotDays(Double janTotDays) {
        this.janTotDays = janTotDays;
    }

    public Double getFebTotDays() {
        return febTotDays;
    }

    public void setFebTotDays(Double febTotDays) {
        this.febTotDays = febTotDays;
    }

    public Double getMarTotDays() {
        return marTotDays;
    }

    public void setMarTotDays(Double marTotDays) {
        this.marTotDays = marTotDays;
    }

    public Double getAprTotDays() {
        return aprTotDays;
    }

    public void setAprTotDays(Double aprTotDays) {
        this.aprTotDays = aprTotDays;
    }

    public Double getMayTotDays() {
        return mayTotDays;
    }

    public void setMayTotDays(Double mayTotDays) {
        this.mayTotDays = mayTotDays;
    }

    public Double getJunTotDays() {
        return junTotDays;
    }

    public void setJunTotDays(Double junTotDays) {
        this.junTotDays = junTotDays;
    }

    public Double getJulTotDays() {
        return julTotDays;
    }

    public void setJulTotDays(Double julTotDays) {
        this.julTotDays = julTotDays;
    }

    public Double getAugTotDays() {
        return augTotDays;
    }

    public void setAugTotDays(Double augTotDays) {
        this.augTotDays = augTotDays;
    }

    public Double getSepTotDays() {
        return sepTotDays;
    }

    public void setSepTotDays(Double sepTotDays) {
        this.sepTotDays = sepTotDays;
    }

    public Double getOctTotDays() {
        return octTotDays;
    }

    public void setOctTotDays(Double octTotDays) {
        this.octTotDays = octTotDays;
    }

    public Double getNovTotDays() {
        return novTotDays;
    }

    public void setNovTotDays(Double novTotDays) {
        this.novTotDays = novTotDays;
    }

    public Double getDecTotDays() {
        return decTotDays;
    }

    public void setDecTotDays(Double decTotDays) {
        this.decTotDays = decTotDays;
    }

    public Double getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Double totalDays) {
        this.totalDays = totalDays;
    }

    public Double getWC() {
        return wC;
    }

    public void setWC(Double wC) {
        this.wC = wC;
    }

    public Integer getTotalMonths() {
        return totalMonths;
    }

    public void setTotalMonths(Integer totalMonths) {
        this.totalMonths = totalMonths;
    }

    public Double getHolidaysPrevious() {
        return holidaysPrevious;
    }

    public void setHolidaysPrevious(Double holidaysPrevious) {
        this.holidaysPrevious = holidaysPrevious;
    }

    public Double getQualifying() {
        return qualifying;
    }

    public void setQualifying(Double qualifying) {
        this.qualifying = qualifying;
    }

    public Double getAttendancePerc() {
        return attendancePerc;
    }

    public void setAttendancePerc(Double attendancePerc) {
        this.attendancePerc = attendancePerc;
    }

    public Double getJanEarning() {
        return janEarning;
    }

    public void setJanEarning(Double janEarning) {
        this.janEarning = janEarning;
    }

    public Double getFebEarning() {
        return febEarning;
    }

    public void setFebEarning(Double febEarning) {
        this.febEarning = febEarning;
    }

    public Double getMarEarning() {
        return marEarning;
    }

    public void setMarEarning(Double marEarning) {
        this.marEarning = marEarning;
    }

    public Double getAprEarning() {
        return aprEarning;
    }

    public void setAprEarning(Double aprEarning) {
        this.aprEarning = aprEarning;
    }

    public Double getMayEarning() {
        return mayEarning;
    }

    public void setMayEarning(Double mayEarning) {
        this.mayEarning = mayEarning;
    }

    public Double getJunEarning() {
        return junEarning;
    }

    public void setJunEarning(Double junEarning) {
        this.junEarning = junEarning;
    }

    public Double getJulEarning() {
        return julEarning;
    }

    public void setJulEarning(Double julEarning) {
        this.julEarning = julEarning;
    }

    public Double getAugEarning() {
        return augEarning;
    }

    public void setAugEarning(Double augEarning) {
        this.augEarning = augEarning;
    }

    public Double getSepEarning() {
        return sepEarning;
    }

    public void setSepEarning(Double sepEarning) {
        this.sepEarning = sepEarning;
    }

    public Double getOctEarning() {
        return octEarning;
    }

    public void setOctEarning(Double octEarning) {
        this.octEarning = octEarning;
    }

    public Double getNovEarning() {
        return novEarning;
    }

    public void setNovEarning(Double novEarning) {
        this.novEarning = novEarning;
    }

    public Double getDecEarning() {
        return decEarning;
    }

    public void setDecEarning(Double decEarning) {
        this.decEarning = decEarning;
    }

    public Double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(Double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public Double getRatePerDay() {
        return ratePerDay;
    }

    public void setRatePerDay(Double ratePerDay) {
        this.ratePerDay = ratePerDay;
    }

    public Double getHolidayPay() {
        return holidayPay;
    }

    public void setHolidayPay(Double holidayPay) {
        this.holidayPay = holidayPay;
    }

    public Double getEpf8() {
        return epf8;
    }

    public void setEpf8(Double epf8) {
        this.epf8 = epf8;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getPss() {
        return pss;
    }

    public void setPss(Double pss) {
        this.pss = pss;
    }

    public Double getAttendanceBonus() {
        return attendanceBonus;
    }

    public void setAttendanceBonus(Double attendanceBonus) {
        this.attendanceBonus = attendanceBonus;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public GeneralOrganizationProfile getGeneralOrganizationProfileId() {
        return generalOrganizationProfileId;
    }

    public void setGeneralOrganizationProfileId(GeneralOrganizationProfile generalOrganizationProfileId) {
        this.generalOrganizationProfileId = generalOrganizationProfileId;
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
        if (!(object instanceof HolidayPayRegister)) {
            return false;
        }
        HolidayPayRegister other = (HolidayPayRegister) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.HolidayPayRegister[ id=" + id + " ]";
    }
    
}
