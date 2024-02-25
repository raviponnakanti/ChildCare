package com.peoplesconsulting.childcare.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Long classroomId;

    @NotNull
    @Column(name = "classroom_name")
    private String classroomName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "center_id", nullable = false)
    private ChildcareCenter childcareCenter;

    @NotNull
    @Column(name = "age_group")
    private String ageGroup;

    @Column(name = "age_from")
    private int ageFrom;

    @Column(name = "age_to")
    private int ageTo;

    @NotNull
    @Column(name = "capacity")
    private int capacity;

    @NotNull
    @Column(name = "status")
    private int status;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

    // Constructors

    public Classroom() {
    }

    public Classroom(String classroomName, ChildcareCenter childcareCenter, String ageGroup, int ageFrom, int ageTo, int capacity, int status, LocalDateTime createdDate, String createdBy, LocalDateTime modifiedDate, String modifiedBy) {
        this.classroomName = classroomName;
        this.childcareCenter = childcareCenter;
        this.ageGroup = ageGroup;
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.capacity = capacity;
        this.status = status;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    // Getters and setters

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public ChildcareCenter getChildcareCenter() {
        return childcareCenter;
    }

    public void setChildcareCenter(ChildcareCenter childcareCenter) {
        this.childcareCenter = childcareCenter;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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