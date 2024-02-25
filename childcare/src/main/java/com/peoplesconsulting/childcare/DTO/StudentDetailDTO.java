package com.peoplesconsulting.childcare.DTO;

import java.util.List;

import com.peoplesconsulting.childcare.entity.*;

public class StudentDetailDTO {
	private Student student;
    private Classroom classroom;
    private List<Activity> activities;
    private List<StudentActivity> studentActivities;
    private Guardian guardian;
    private Schedule schedule;
    private StudentHealthDetailsDTO studentHealthDetails;
    private List<ChildDocument> childDocuments;
    private StudentSubsidy studentSubsidies;
    private List<TimeCard> timeCards;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public List<StudentActivity> getStudentActivities() {
		return studentActivities;
	}
	public void setStudentActivities(List<StudentActivity> studentActivities) {
		this.studentActivities = studentActivities;
	}
	public Guardian getGuardian() {
		return guardian;
	}
	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public StudentHealthDetailsDTO getStudentHealthDetails() {
		return studentHealthDetails;
	}
	public void setStudentHealthDetails(StudentHealthDetailsDTO studentHealthDetails) {
		this.studentHealthDetails = studentHealthDetails;
	}
	public List<ChildDocument> getChildDocuments() {
		return childDocuments;
	}
	public void setChildDocuments(List<ChildDocument> childDocuments) {
		this.childDocuments = childDocuments;
	}
	public StudentSubsidy getStudentSubsidies() {
		return studentSubsidies;
	}
	public void setStudentSubsidies(StudentSubsidy studentSubsidies) {
		this.studentSubsidies = studentSubsidies;
	}
	public List<TimeCard> getTimeCards() {
		return timeCards;
	}
	public void setTimeCards(List<TimeCard> timeCards) {
		this.timeCards = timeCards;
	}
}
