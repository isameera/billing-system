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
@Table(name = "employee_final_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeFinalPayment.findAll", query = "SELECT e FROM EmployeeFinalPayment e")
    , @NamedQuery(name = "EmployeeFinalPayment.findById", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.id = :id")
    , @NamedQuery(name = "EmployeeFinalPayment.findByYear", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.year = :year")
    , @NamedQuery(name = "EmployeeFinalPayment.findByMonth", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.month = :month")
    , @NamedQuery(name = "EmployeeFinalPayment.findByTotalDays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.totalDays = :totalDays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByHolidays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.holidays = :holidays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByHolidayAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.holidayAmount = :holidayAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByDayOtHours", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.dayOtHours = :dayOtHours")
    , @NamedQuery(name = "EmployeeFinalPayment.findByDayOtPay", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.dayOtPay = :dayOtPay")
    , @NamedQuery(name = "EmployeeFinalPayment.findByNightOtHours", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.nightOtHours = :nightOtHours")
    , @NamedQuery(name = "EmployeeFinalPayment.findByNightOtPay", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.nightOtPay = :nightOtPay")
    , @NamedQuery(name = "EmployeeFinalPayment.findByTotalOtPay", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.totalOtPay = :totalOtPay")
    , @NamedQuery(name = "EmployeeFinalPayment.findByPayForEpf", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.payForEpf = :payForEpf")
    , @NamedQuery(name = "EmployeeFinalPayment.findByPss", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.pss = :pss")
    , @NamedQuery(name = "EmployeeFinalPayment.findByAttendanceIncentive", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.attendanceIncentive = :attendanceIncentive")
    , @NamedQuery(name = "EmployeeFinalPayment.findBySpecialIncentive", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.specialIncentive = :specialIncentive")
    , @NamedQuery(name = "EmployeeFinalPayment.findByAddPay", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.addPay = :addPay")
    , @NamedQuery(name = "EmployeeFinalPayment.findByBfCoins", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.bfCoins = :bfCoins")
    , @NamedQuery(name = "EmployeeFinalPayment.findByGrossAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.grossAmount = :grossAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByEpfDeduction", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.epfDeduction = :epfDeduction")
    , @NamedQuery(name = "EmployeeFinalPayment.findByBfDebit", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.bfDebit = :bfDebit")
    , @NamedQuery(name = "EmployeeFinalPayment.findByTea", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.tea = :tea")
    , @NamedQuery(name = "EmployeeFinalPayment.findByFood", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.food = :food")
    , @NamedQuery(name = "EmployeeFinalPayment.findByLoan", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.loan = :loan")
    , @NamedQuery(name = "EmployeeFinalPayment.findByAdvance", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.advance = :advance")
    , @NamedQuery(name = "EmployeeFinalPayment.findByWelfare", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.welfare = :welfare")
    , @NamedQuery(name = "EmployeeFinalPayment.findByUniform", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.uniform = :uniform")
    , @NamedQuery(name = "EmployeeFinalPayment.findByTotalDeduction", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.totalDeduction = :totalDeduction")
    , @NamedQuery(name = "EmployeeFinalPayment.findByBalance", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.balance = :balance")
    , @NamedQuery(name = "EmployeeFinalPayment.findByCfCoins", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.cfCoins = :cfCoins")
    , @NamedQuery(name = "EmployeeFinalPayment.findByCfDebit", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.cfDebit = :cfDebit")
    , @NamedQuery(name = "EmployeeFinalPayment.findByCash", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.cash = :cash")
    , @NamedQuery(name = "EmployeeFinalPayment.findByBank", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.bank = :bank")
    , @NamedQuery(name = "EmployeeFinalPayment.findByFine", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.fine = :fine")
    , @NamedQuery(name = "EmployeeFinalPayment.findByStationAllowance", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.stationAllowance = :stationAllowance")
    , @NamedQuery(name = "EmployeeFinalPayment.findByBfUniform", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.bfUniform = :bfUniform")
    , @NamedQuery(name = "EmployeeFinalPayment.findByCfUniform", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.cfUniform = :cfUniform")
    , @NamedQuery(name = "EmployeeFinalPayment.findByTax", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.tax = :tax")
    , @NamedQuery(name = "EmployeeFinalPayment.findByTelephone", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.telephone = :telephone")
    , @NamedQuery(name = "EmployeeFinalPayment.findByDonation", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.donation = :donation")
    , @NamedQuery(name = "EmployeeFinalPayment.findByDaysPay", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.daysPay = :daysPay")
    , @NamedQuery(name = "EmployeeFinalPayment.findByNoPayDays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.noPayDays = :noPayDays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByNoPayAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.noPayAmount = :noPayAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByEtf", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.etf = :etf")
    , @NamedQuery(name = "EmployeeFinalPayment.findBySundayHolidays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.sundayHolidays = :sundayHolidays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByPoyaHolidays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.poyaHolidays = :poyaHolidays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByStatutoryHoildays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.statutoryHoildays = :statutoryHoildays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByWeekdayOtHours", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.weekdayOtHours = :weekdayOtHours")
    , @NamedQuery(name = "EmployeeFinalPayment.findByHolidayOtHours", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.holidayOtHours = :holidayOtHours")
    , @NamedQuery(name = "EmployeeFinalPayment.findByStatutoryOtHours", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.statutoryOtHours = :statutoryOtHours")
    , @NamedQuery(name = "EmployeeFinalPayment.findByPoyaHolidayAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.poyaHolidayAmount = :poyaHolidayAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findBySundayHolidayAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.sundayHolidayAmount = :sundayHolidayAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByStatutoryHolidayAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.statutoryHolidayAmount = :statutoryHolidayAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByWeekdayOtAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.weekdayOtAmount = :weekdayOtAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByHolidayOtAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.holidayOtAmount = :holidayOtAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByStatutoryOtAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.statutoryOtAmount = :statutoryOtAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByOfficeDays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.officeDays = :officeDays")
    , @NamedQuery(name = "EmployeeFinalPayment.findBySiteDays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.siteDays = :siteDays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByOfficeBata", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.officeBata = :officeBata")
    , @NamedQuery(name = "EmployeeFinalPayment.findBySiteBata", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.siteBata = :siteBata")
    , @NamedQuery(name = "EmployeeFinalPayment.findByTotalBata", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.totalBata = :totalBata")
    , @NamedQuery(name = "EmployeeFinalPayment.findByUniformDays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.uniformDays = :uniformDays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByDustDays", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.dustDays = :dustDays")
    , @NamedQuery(name = "EmployeeFinalPayment.findByUniformAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.uniformAmount = :uniformAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByDustAmount", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.dustAmount = :dustAmount")
    , @NamedQuery(name = "EmployeeFinalPayment.findByAttendanceRate", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.attendanceRate = :attendanceRate")
    , @NamedQuery(name = "EmployeeFinalPayment.findByElectricityAndWater", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.electricityAndWater = :electricityAndWater")
    , @NamedQuery(name = "EmployeeFinalPayment.findByFoodAndMeal", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.foodAndMeal = :foodAndMeal")
    , @NamedQuery(name = "EmployeeFinalPayment.findByFoodAndMealPenalty", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.foodAndMealPenalty = :foodAndMealPenalty")
    , @NamedQuery(name = "EmployeeFinalPayment.findBySafetyKit", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.safetyKit = :safetyKit")
    , @NamedQuery(name = "EmployeeFinalPayment.findByPenalty", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.penalty = :penalty")
    , @NamedQuery(name = "EmployeeFinalPayment.findByBankRecovery", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.bankRecovery = :bankRecovery")
    , @NamedQuery(name = "EmployeeFinalPayment.findByBfFestivalAdvance", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.bfFestivalAdvance = :bfFestivalAdvance")
    , @NamedQuery(name = "EmployeeFinalPayment.findByFestivalAdvance", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.festivalAdvance = :festivalAdvance")
    , @NamedQuery(name = "EmployeeFinalPayment.findByCfFestivalAdvance", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.cfFestivalAdvance = :cfFestivalAdvance")
    , @NamedQuery(name = "EmployeeFinalPayment.findByIsPaid", query = "SELECT e FROM EmployeeFinalPayment e WHERE e.isPaid = :isPaid")})
public class EmployeeFinalPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_days")
    private Double totalDays;
    @Column(name = "holidays")
    private Double holidays;
    @Column(name = "holiday_amount")
    private Double holidayAmount;
    @Column(name = "day_ot_hours")
    private Double dayOtHours;
    @Column(name = "day_ot_pay")
    private Double dayOtPay;
    @Column(name = "night_ot_hours")
    private Double nightOtHours;
    @Column(name = "night_ot_pay")
    private Double nightOtPay;
    @Column(name = "total_ot_pay")
    private Double totalOtPay;
    @Column(name = "pay_for_epf")
    private Double payForEpf;
    @Column(name = "pss")
    private Double pss;
    @Column(name = "attendance_incentive")
    private Double attendanceIncentive;
    @Column(name = "special_incentive")
    private Double specialIncentive;
    @Column(name = "add_pay")
    private Double addPay;
    @Column(name = "bf_coins")
    private Double bfCoins;
    @Column(name = "gross_amount")
    private Double grossAmount;
    @Column(name = "epf_deduction")
    private Double epfDeduction;
    @Column(name = "bf_debit")
    private Double bfDebit;
    @Column(name = "tea")
    private Double tea;
    @Column(name = "food")
    private Double food;
    @Column(name = "loan")
    private Double loan;
    @Column(name = "advance")
    private Double advance;
    @Column(name = "welfare")
    private Double welfare;
    @Column(name = "uniform")
    private Double uniform;
    @Column(name = "total_deduction")
    private Double totalDeduction;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "cf_coins")
    private Double cfCoins;
    @Column(name = "cf_debit")
    private Double cfDebit;
    @Column(name = "cash")
    private Double cash;
    @Column(name = "bank")
    private Double bank;
    @Column(name = "fine")
    private Double fine;
    @Column(name = "station_allowance")
    private Double stationAllowance;
    @Column(name = "bf_uniform")
    private Double bfUniform;
    @Column(name = "cf_uniform")
    private Double cfUniform;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "telephone")
    private Double telephone;
    @Column(name = "donation")
    private Double donation;
    @Column(name = "days_pay")
    private Double daysPay;
    @Column(name = "no_pay_days")
    private Double noPayDays;
    @Column(name = "no_pay_amount")
    private Double noPayAmount;
    @Column(name = "etf")
    private Double etf;
    @Column(name = "sunday_holidays")
    private Double sundayHolidays;
    @Column(name = "poya_holidays")
    private Double poyaHolidays;
    @Column(name = "statutory_hoildays")
    private Double statutoryHoildays;
    @Column(name = "weekday_ot_hours")
    private Double weekdayOtHours;
    @Column(name = "holiday_ot_hours")
    private Double holidayOtHours;
    @Column(name = "statutory_ot_hours")
    private Double statutoryOtHours;
    @Column(name = "poya_holiday_amount")
    private Double poyaHolidayAmount;
    @Column(name = "sunday_holiday_amount")
    private Double sundayHolidayAmount;
    @Column(name = "statutory_holiday_amount")
    private Double statutoryHolidayAmount;
    @Column(name = "weekday_ot_amount")
    private Double weekdayOtAmount;
    @Column(name = "holiday_ot_amount")
    private Double holidayOtAmount;
    @Column(name = "statutory_ot_amount")
    private Double statutoryOtAmount;
    @Column(name = "office_days")
    private Double officeDays;
    @Column(name = "site_days")
    private Double siteDays;
    @Column(name = "office_bata")
    private Double officeBata;
    @Column(name = "site_bata")
    private Double siteBata;
    @Column(name = "total_bata")
    private Double totalBata;
    @Column(name = "uniform_days")
    private Double uniformDays;
    @Column(name = "dust_days")
    private Double dustDays;
    @Column(name = "uniform_amount")
    private Double uniformAmount;
    @Column(name = "dust_amount")
    private Double dustAmount;
    @Column(name = "attendance_rate")
    private Double attendanceRate;
    @Column(name = "electricity_and_water")
    private Double electricityAndWater;
    @Column(name = "food_and_meal")
    private Double foodAndMeal;
    @Column(name = "food_and_meal_penalty")
    private Double foodAndMealPenalty;
    @Column(name = "safety_kit")
    private Double safetyKit;
    @Column(name = "penalty")
    private Double penalty;
    @Column(name = "bank_recovery")
    private Double bankRecovery;
    @Column(name = "bf_festival_advance")
    private Double bfFestivalAdvance;
    @Column(name = "festival_advance")
    private Double festivalAdvance;
    @Column(name = "cf_festival_advance")
    private Double cfFestivalAdvance;
    @Column(name = "is_paid")
    private Integer isPaid;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    @JoinColumn(name = "employee_final_payment_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmployeeFinalPaymentType employeeFinalPaymentTypeId;

    public EmployeeFinalPayment() {
    }

    public EmployeeFinalPayment(Integer id) {
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Double totalDays) {
        this.totalDays = totalDays;
    }

    public Double getHolidays() {
        return holidays;
    }

    public void setHolidays(Double holidays) {
        this.holidays = holidays;
    }

    public Double getHolidayAmount() {
        return holidayAmount;
    }

    public void setHolidayAmount(Double holidayAmount) {
        this.holidayAmount = holidayAmount;
    }

    public Double getDayOtHours() {
        return dayOtHours;
    }

    public void setDayOtHours(Double dayOtHours) {
        this.dayOtHours = dayOtHours;
    }

    public Double getDayOtPay() {
        return dayOtPay;
    }

    public void setDayOtPay(Double dayOtPay) {
        this.dayOtPay = dayOtPay;
    }

    public Double getNightOtHours() {
        return nightOtHours;
    }

    public void setNightOtHours(Double nightOtHours) {
        this.nightOtHours = nightOtHours;
    }

    public Double getNightOtPay() {
        return nightOtPay;
    }

    public void setNightOtPay(Double nightOtPay) {
        this.nightOtPay = nightOtPay;
    }

    public Double getTotalOtPay() {
        return totalOtPay;
    }

    public void setTotalOtPay(Double totalOtPay) {
        this.totalOtPay = totalOtPay;
    }

    public Double getPayForEpf() {
        return payForEpf;
    }

    public void setPayForEpf(Double payForEpf) {
        this.payForEpf = payForEpf;
    }

    public Double getPss() {
        return pss;
    }

    public void setPss(Double pss) {
        this.pss = pss;
    }

    public Double getAttendanceIncentive() {
        return attendanceIncentive;
    }

    public void setAttendanceIncentive(Double attendanceIncentive) {
        this.attendanceIncentive = attendanceIncentive;
    }

    public Double getSpecialIncentive() {
        return specialIncentive;
    }

    public void setSpecialIncentive(Double specialIncentive) {
        this.specialIncentive = specialIncentive;
    }

    public Double getAddPay() {
        return addPay;
    }

    public void setAddPay(Double addPay) {
        this.addPay = addPay;
    }

    public Double getBfCoins() {
        return bfCoins;
    }

    public void setBfCoins(Double bfCoins) {
        this.bfCoins = bfCoins;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(Double grossAmount) {
        this.grossAmount = grossAmount;
    }

    public Double getEpfDeduction() {
        return epfDeduction;
    }

    public void setEpfDeduction(Double epfDeduction) {
        this.epfDeduction = epfDeduction;
    }

    public Double getBfDebit() {
        return bfDebit;
    }

    public void setBfDebit(Double bfDebit) {
        this.bfDebit = bfDebit;
    }

    public Double getTea() {
        return tea;
    }

    public void setTea(Double tea) {
        this.tea = tea;
    }

    public Double getFood() {
        return food;
    }

    public void setFood(Double food) {
        this.food = food;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan(Double loan) {
        this.loan = loan;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public Double getWelfare() {
        return welfare;
    }

    public void setWelfare(Double welfare) {
        this.welfare = welfare;
    }

    public Double getUniform() {
        return uniform;
    }

    public void setUniform(Double uniform) {
        this.uniform = uniform;
    }

    public Double getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(Double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getCfCoins() {
        return cfCoins;
    }

    public void setCfCoins(Double cfCoins) {
        this.cfCoins = cfCoins;
    }

    public Double getCfDebit() {
        return cfDebit;
    }

    public void setCfDebit(Double cfDebit) {
        this.cfDebit = cfDebit;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Double getBank() {
        return bank;
    }

    public void setBank(Double bank) {
        this.bank = bank;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    public Double getStationAllowance() {
        return stationAllowance;
    }

    public void setStationAllowance(Double stationAllowance) {
        this.stationAllowance = stationAllowance;
    }

    public Double getBfUniform() {
        return bfUniform;
    }

    public void setBfUniform(Double bfUniform) {
        this.bfUniform = bfUniform;
    }

    public Double getCfUniform() {
        return cfUniform;
    }

    public void setCfUniform(Double cfUniform) {
        this.cfUniform = cfUniform;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTelephone() {
        return telephone;
    }

    public void setTelephone(Double telephone) {
        this.telephone = telephone;
    }

    public Double getDonation() {
        return donation;
    }

    public void setDonation(Double donation) {
        this.donation = donation;
    }

    public Double getDaysPay() {
        return daysPay;
    }

    public void setDaysPay(Double daysPay) {
        this.daysPay = daysPay;
    }

    public Double getNoPayDays() {
        return noPayDays;
    }

    public void setNoPayDays(Double noPayDays) {
        this.noPayDays = noPayDays;
    }

    public Double getNoPayAmount() {
        return noPayAmount;
    }

    public void setNoPayAmount(Double noPayAmount) {
        this.noPayAmount = noPayAmount;
    }

    public Double getEtf() {
        return etf;
    }

    public void setEtf(Double etf) {
        this.etf = etf;
    }

    public Double getSundayHolidays() {
        return sundayHolidays;
    }

    public void setSundayHolidays(Double sundayHolidays) {
        this.sundayHolidays = sundayHolidays;
    }

    public Double getPoyaHolidays() {
        return poyaHolidays;
    }

    public void setPoyaHolidays(Double poyaHolidays) {
        this.poyaHolidays = poyaHolidays;
    }

    public Double getStatutoryHoildays() {
        return statutoryHoildays;
    }

    public void setStatutoryHoildays(Double statutoryHoildays) {
        this.statutoryHoildays = statutoryHoildays;
    }

    public Double getWeekdayOtHours() {
        return weekdayOtHours;
    }

    public void setWeekdayOtHours(Double weekdayOtHours) {
        this.weekdayOtHours = weekdayOtHours;
    }

    public Double getHolidayOtHours() {
        return holidayOtHours;
    }

    public void setHolidayOtHours(Double holidayOtHours) {
        this.holidayOtHours = holidayOtHours;
    }

    public Double getStatutoryOtHours() {
        return statutoryOtHours;
    }

    public void setStatutoryOtHours(Double statutoryOtHours) {
        this.statutoryOtHours = statutoryOtHours;
    }

    public Double getPoyaHolidayAmount() {
        return poyaHolidayAmount;
    }

    public void setPoyaHolidayAmount(Double poyaHolidayAmount) {
        this.poyaHolidayAmount = poyaHolidayAmount;
    }

    public Double getSundayHolidayAmount() {
        return sundayHolidayAmount;
    }

    public void setSundayHolidayAmount(Double sundayHolidayAmount) {
        this.sundayHolidayAmount = sundayHolidayAmount;
    }

    public Double getStatutoryHolidayAmount() {
        return statutoryHolidayAmount;
    }

    public void setStatutoryHolidayAmount(Double statutoryHolidayAmount) {
        this.statutoryHolidayAmount = statutoryHolidayAmount;
    }

    public Double getWeekdayOtAmount() {
        return weekdayOtAmount;
    }

    public void setWeekdayOtAmount(Double weekdayOtAmount) {
        this.weekdayOtAmount = weekdayOtAmount;
    }

    public Double getHolidayOtAmount() {
        return holidayOtAmount;
    }

    public void setHolidayOtAmount(Double holidayOtAmount) {
        this.holidayOtAmount = holidayOtAmount;
    }

    public Double getStatutoryOtAmount() {
        return statutoryOtAmount;
    }

    public void setStatutoryOtAmount(Double statutoryOtAmount) {
        this.statutoryOtAmount = statutoryOtAmount;
    }

    public Double getOfficeDays() {
        return officeDays;
    }

    public void setOfficeDays(Double officeDays) {
        this.officeDays = officeDays;
    }

    public Double getSiteDays() {
        return siteDays;
    }

    public void setSiteDays(Double siteDays) {
        this.siteDays = siteDays;
    }

    public Double getOfficeBata() {
        return officeBata;
    }

    public void setOfficeBata(Double officeBata) {
        this.officeBata = officeBata;
    }

    public Double getSiteBata() {
        return siteBata;
    }

    public void setSiteBata(Double siteBata) {
        this.siteBata = siteBata;
    }

    public Double getTotalBata() {
        return totalBata;
    }

    public void setTotalBata(Double totalBata) {
        this.totalBata = totalBata;
    }

    public Double getUniformDays() {
        return uniformDays;
    }

    public void setUniformDays(Double uniformDays) {
        this.uniformDays = uniformDays;
    }

    public Double getDustDays() {
        return dustDays;
    }

    public void setDustDays(Double dustDays) {
        this.dustDays = dustDays;
    }

    public Double getUniformAmount() {
        return uniformAmount;
    }

    public void setUniformAmount(Double uniformAmount) {
        this.uniformAmount = uniformAmount;
    }

    public Double getDustAmount() {
        return dustAmount;
    }

    public void setDustAmount(Double dustAmount) {
        this.dustAmount = dustAmount;
    }

    public Double getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(Double attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public Double getElectricityAndWater() {
        return electricityAndWater;
    }

    public void setElectricityAndWater(Double electricityAndWater) {
        this.electricityAndWater = electricityAndWater;
    }

    public Double getFoodAndMeal() {
        return foodAndMeal;
    }

    public void setFoodAndMeal(Double foodAndMeal) {
        this.foodAndMeal = foodAndMeal;
    }

    public Double getFoodAndMealPenalty() {
        return foodAndMealPenalty;
    }

    public void setFoodAndMealPenalty(Double foodAndMealPenalty) {
        this.foodAndMealPenalty = foodAndMealPenalty;
    }

    public Double getSafetyKit() {
        return safetyKit;
    }

    public void setSafetyKit(Double safetyKit) {
        this.safetyKit = safetyKit;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public Double getBankRecovery() {
        return bankRecovery;
    }

    public void setBankRecovery(Double bankRecovery) {
        this.bankRecovery = bankRecovery;
    }

    public Double getBfFestivalAdvance() {
        return bfFestivalAdvance;
    }

    public void setBfFestivalAdvance(Double bfFestivalAdvance) {
        this.bfFestivalAdvance = bfFestivalAdvance;
    }

    public Double getFestivalAdvance() {
        return festivalAdvance;
    }

    public void setFestivalAdvance(Double festivalAdvance) {
        this.festivalAdvance = festivalAdvance;
    }

    public Double getCfFestivalAdvance() {
        return cfFestivalAdvance;
    }

    public void setCfFestivalAdvance(Double cfFestivalAdvance) {
        this.cfFestivalAdvance = cfFestivalAdvance;
    }

    public Integer getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Integer isPaid) {
        this.isPaid = isPaid;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeFinalPaymentType getEmployeeFinalPaymentTypeId() {
        return employeeFinalPaymentTypeId;
    }

    public void setEmployeeFinalPaymentTypeId(EmployeeFinalPaymentType employeeFinalPaymentTypeId) {
        this.employeeFinalPaymentTypeId = employeeFinalPaymentTypeId;
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
        if (!(object instanceof EmployeeFinalPayment)) {
            return false;
        }
        EmployeeFinalPayment other = (EmployeeFinalPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejb.model.entity.EmployeeFinalPayment[ id=" + id + " ]";
    }
    
}
