package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @NotNull
    @Column(name = "doctor_name", length = 100)
    private String doctorName;

    @ManyToOne()
    @JoinColumn(name = "addressid",nullable = true)
    private Address address;

    @Column(name = "doctor_type", length = 100)
    private String doctorType;

    @Column(name = "doctor_details", length = 1000)
    private String doctorDetails;

//    @ManyToOne()
//    @JoinColumn(name = "center_id", nullable = false)
//    private ChildcareCenter childcareCenter;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "createdby", length = 100)
    private String createdBy;

    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @Column(name = "modifiedby", length = 100)
    private String modifiedBy;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public String getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(String doctorDetails) {
		this.doctorDetails = doctorDetails;
	}

//	public ChildcareCenter getChildcareCenter() {
//		return childcareCenter;
//	}
//
//	public void setChildcareCenter(ChildcareCenter childcareCenter) {
//		this.childcareCenter = childcareCenter;
//	}

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

