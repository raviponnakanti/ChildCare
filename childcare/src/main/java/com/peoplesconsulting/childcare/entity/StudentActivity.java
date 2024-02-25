package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Student_Activity")
public class StudentActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_activity_id")
    private Long studentActivityId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id")
    private ChildcareCenter center;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Column(name = "activity_data")
    private byte[] activityData;

    @Column(name = "student_activity_details")
    private String studentActivityDetails;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

	public Long getStudentActivityId() {
		return studentActivityId;
	}

	public void setStudentActivityId(Long studentActivityId) {
		this.studentActivityId = studentActivityId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ChildcareCenter getCenter() {
		return center;
	}

	public void setCenter(ChildcareCenter center) {
		this.center = center;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public byte[] getActivityData() {
		return activityData;
	}

	public void setActivityData(byte[] activityData) {
		this.activityData = activityData;
	}

	public String getStudentActivityDetails() {
		return studentActivityDetails;
	}

	public void setStudentActivityDetails(String studentActivityDetails) {
		this.studentActivityDetails = studentActivityDetails;
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
