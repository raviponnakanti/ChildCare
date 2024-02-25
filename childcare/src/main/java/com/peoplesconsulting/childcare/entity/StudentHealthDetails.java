package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Student_Health_Details")
public class StudentHealthDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "health_id")
    private Long healthId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;

    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "center_id", nullable = true)
//    private ChildcareCenter childcareCenter;

	@OneToMany(mappedBy = "studentHealthDetails", cascade = CascadeType.ALL)
    private List<Allergies> allergies;

    @OneToMany(mappedBy = "studentHealthDetails", cascade = CascadeType.ALL)
    private List<Medications> medications;
    
    @Column(name = "health_notes", length = 1000)
    private String healthNotes;

    @Column(name = "diet_restriction", length = 1000)
    private String dietRestriction;

    @Column(name = "food_program", length = 1000)
    private String foodProgram;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "modified_by", length = 100)
    private String modifiedBy;

	public Long getHealthId() {
		return healthId;
	}

	public void setHealthId(Long healthId) {
		this.healthId = healthId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Allergies> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergies> allergies) {
		this.allergies = allergies;
	}

	public List<Medications> getMedications() {
		return medications;
	}

	public void setMedications(List<Medications> medications) {
		this.medications = medications;
	}

//	public Doctor getDoctor() {
//		return doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}

//	public ChildcareCenter getChildcareCenter() {
//		return childcareCenter;
//	}
//
//	public void setChildcareCenter(ChildcareCenter childcareCenter) {
//		this.childcareCenter = childcareCenter;
//	}

	public String getHealthNotes() {
		return healthNotes;
	}

	public void setHealthNotes(String healthNotes) {
		this.healthNotes = healthNotes;
	}

	public String getDietRestriction() {
		return dietRestriction;
	}

	public void setDietRestriction(String dietRestriction) {
		this.dietRestriction = dietRestriction;
	}

	public String getFoodProgram() {
		return foodProgram;
	}

	public void setFoodProgram(String foodProgram) {
		this.foodProgram = foodProgram;
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

