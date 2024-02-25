package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Medications")
public class Medications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private Long medicationId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_id", nullable = false)
    private StudentHealthDetails studentHealthDetails;    

	@NotNull
    @Column(name = "medication_name", length = 100)
    private String medicationName;

    @Column(name = "medication_details", length = 1000)
    private String medicationDetails;

    @Column(name = "medication_type", length = 100)
    private String medicationType;

    @NotNull
    @Column(name = "dosage", length = 50)
    private String dosage;

    @NotNull
    @Column(name = "frequency", length = 50)
    private String frequency;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = true)
    private Doctor doctor;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "reminder_days")
    private Integer reminderDays;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "modified_by", length = 100)
    private String modifiedBy;

	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	public String getMedicationDetails() {
		return medicationDetails;
	}

	public void setMedicationDetails(String medicationDetails) {
		this.medicationDetails = medicationDetails;
	}

	public String getMedicationType() {
		return medicationType;
	}

	public void setMedicationType(String medicationType) {
		this.medicationType = medicationType;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getReminderDays() {
		return reminderDays;
	}

	public void setReminderDays(Integer reminderDays) {
		this.reminderDays = reminderDays;
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
	
	public StudentHealthDetails getStudentHealthDetails() {
		return studentHealthDetails;
	}

	public void setStudentHealthDetails(StudentHealthDetails studentHealthDetails) {
		this.studentHealthDetails = studentHealthDetails;
	}

}
