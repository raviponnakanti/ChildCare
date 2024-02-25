package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Student_Subsidy")
public class StudentSubsidy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subsidy_id")
    private Long subsidyId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id", nullable = false)
    private ChildcareCenter childcareCenter;

    @NotNull
    @Column(name = "subsidy_amount")
    private BigDecimal subsidyAmount;

    @NotNull
    @Column(name = "subsidy_name")
    private String subsidyName;

    @Column(name = "subsidy_provider_id")
    private String subsidyProviderId;

    @Column(name = "subsidy_provider_name")
    private String subsidyProviderName;

    @Column(name = "subsidy_days")
    private Integer subsidyDays;

    @Column(name = "subsidy_daytype")
    private Integer subsidyDayType;

    @Column(name = "subsidy_period")
    private Integer subsidyPeriod;

    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "days_to_reminder")
    private Integer daysToReminder;

    @Column(name = "subsidy_info")
    private String subsidyInfo;

    @NotNull
    @Column(name = "subsidy_perday")
    private BigDecimal subsidyPerDay;

    @NotNull
    @Column(name = "copayperday")
    private BigDecimal copayPerDay;

    @NotNull
    @Column(name = "payment_frequency_days")
    private Integer paymentFrequencyDays;

    @NotNull
    @Column(name = "payment_frequency_type")
    private Integer paymentFrequencyType;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "createdby", length = 100)
    private String createdBy;

    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @Column(name = "modifiedby", length = 100)
    private String modifiedBy;

	public Long getSubsidyId() {
		return subsidyId;
	}

	public void setSubsidyId(Long subsidyId) {
		this.subsidyId = subsidyId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ChildcareCenter getChildcareCenter() {
		return childcareCenter;
	}

	public void setChildcareCenter(ChildcareCenter childcareCenter) {
		this.childcareCenter = childcareCenter;
	}

	public BigDecimal getSubsidyAmount() {
		return subsidyAmount;
	}

	public void setSubsidyAmount(BigDecimal subsidyAmount) {
		this.subsidyAmount = subsidyAmount;
	}

	public String getSubsidyName() {
		return subsidyName;
	}

	public void setSubsidyName(String subsidyName) {
		this.subsidyName = subsidyName;
	}

	public String getSubsidyProviderId() {
		return subsidyProviderId;
	}

	public void setSubsidyProviderId(String subsidyProviderId) {
		this.subsidyProviderId = subsidyProviderId;
	}

	public String getSubsidyProviderName() {
		return subsidyProviderName;
	}

	public void setSubsidyProviderName(String subsidyProviderName) {
		this.subsidyProviderName = subsidyProviderName;
	}

	public Integer getSubsidyDays() {
		return subsidyDays;
	}

	public void setSubsidyDays(Integer subsidyDays) {
		this.subsidyDays = subsidyDays;
	}

	public Integer getSubsidyDayType() {
		return subsidyDayType;
	}

	public void setSubsidyDayType(Integer subsidyDayType) {
		this.subsidyDayType = subsidyDayType;
	}

	public Integer getSubsidyPeriod() {
		return subsidyPeriod;
	}

	public void setSubsidyPeriod(Integer subsidyPeriod) {
		this.subsidyPeriod = subsidyPeriod;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getDaysToReminder() {
		return daysToReminder;
	}

	public void setDaysToReminder(Integer daysToReminder) {
		this.daysToReminder = daysToReminder;
	}

	public String getSubsidyInfo() {
		return subsidyInfo;
	}

	public void setSubsidyInfo(String subsidyInfo) {
		this.subsidyInfo = subsidyInfo;
	}

	public BigDecimal getSubsidyPerDay() {
		return subsidyPerDay;
	}

	public void setSubsidyPerDay(BigDecimal subsidyPerDay) {
		this.subsidyPerDay = subsidyPerDay;
	}

	public BigDecimal getCopayPerDay() {
		return copayPerDay;
	}

	public void setCopayPerDay(BigDecimal copayPerDay) {
		this.copayPerDay = copayPerDay;
	}

	public Integer getPaymentFrequencyDays() {
		return paymentFrequencyDays;
	}

	public void setPaymentFrequencyDays(Integer paymentFrequencyDays) {
		this.paymentFrequencyDays = paymentFrequencyDays;
	}

	public Integer getPaymentFrequencyType() {
		return paymentFrequencyType;
	}

	public void setPaymentFrequencyType(Integer paymentFrequencyType) {
		this.paymentFrequencyType = paymentFrequencyType;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

   
}

