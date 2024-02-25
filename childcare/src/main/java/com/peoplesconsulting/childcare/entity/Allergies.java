package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Allergies")
public class Allergies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allergy_id")
    private Long allergyId;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "health_id", nullable = false)
    private StudentHealthDetails studentHealthDetails;

    @NotNull
    @Column(name = "allergy_type", length = 100)
    private String allergyType;

    @Column(name = "allergy_details", length = 500)
    private String allergyDetails;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "modified_by", length = 100)
    private String modifiedBy;
    
    public StudentHealthDetails getStudentHealthDetails() {
		return studentHealthDetails;
	}

	public void setStudentHealthDetails(StudentHealthDetails studentHealthDetails) {
		this.studentHealthDetails = studentHealthDetails;
	}
	
	public Long getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Long allergyId) {
		this.allergyId = allergyId;
	}

	public String getAllergyType() {
		return allergyType;
	}

	public void setAllergyType(String allergyType) {
		this.allergyType = allergyType;
	}

	public String getAllergyDetails() {
		return allergyDetails;
	}

	public void setAllergyDetails(String allergyDetails) {
		this.allergyDetails = allergyDetails;
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
