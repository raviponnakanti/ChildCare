package com.peoplesconsulting.childcare.DTO;

import java.util.List;

import com.peoplesconsulting.childcare.entity.Allergies;
import com.peoplesconsulting.childcare.entity.Doctor;
import com.peoplesconsulting.childcare.entity.Medications;

public class StudentHealthDetailsDTO {
	private Long healthId;
	private Long student_id;
	
	private Long childcareCenterId;
	private String healthNotes;
	private String dietRestriction;
	private String foodProgram;
	private Doctor doctor;
	
	private List<Allergies> allergies;
	private List<Medications> medications;
	public Long getHealthId() {
		return healthId;
	}
	public void setHealthId(Long healthId) {
		this.healthId = healthId;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public Long getChildcareCenterId() {
		return childcareCenterId;
	}
	public void setChildcareCenterId(Long childcareCenterId) {
		this.childcareCenterId = childcareCenterId;
	}
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
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
}
