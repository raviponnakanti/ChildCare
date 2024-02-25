package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Enrollment")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @NotNull
    @Column(name = "enrollment_date")
    private LocalDateTime enrollmentDate;

    @Column(name = "enablesigninout_pin", columnDefinition = "TINYINT")
    private Boolean enableSigninOutPin;

    @Column(name = "signinout_pin", length = 15)
    private String signInOutPin;

    @Column(name = "exceededHoursToNotify")
    private Integer exceededHoursToNotify;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guardian_id", nullable = false)
    private Guardian guardian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id", nullable = false)
    private ChildcareCenter childcareCenter;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public LocalDateTime getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Boolean getEnableSigninOutPin() {
		return enableSigninOutPin;
	}

	public void setEnableSigninOutPin(Boolean enableSigninOutPin) {
		this.enableSigninOutPin = enableSigninOutPin;
	}

	public String getSignInOutPin() {
		return signInOutPin;
	}

	public void setSignInOutPin(String signInOutPin) {
		this.signInOutPin = signInOutPin;
	}

	public Integer getExceededHoursToNotify() {
		return exceededHoursToNotify;
	}

	public void setExceededHoursToNotify(Integer exceededHoursToNotify) {
		this.exceededHoursToNotify = exceededHoursToNotify;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}

	public ChildcareCenter getChildcareCenter() {
		return childcareCenter;
	}

	public void setChildcareCenter(ChildcareCenter childcareCenter) {
		this.childcareCenter = childcareCenter;
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

