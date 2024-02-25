package com.peoplesconsulting.childcare.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "Guardian")
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guardian_id")
    private Long guardianId;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "relation_type")
    private String relationType;

    @Column(name = "is_emergencycontact", columnDefinition = "TINYINT")
    private Boolean isEmergencyContact;

    @Column(name = "is_authorisedtopickup", columnDefinition = "TINYINT")
    private Boolean isAuthorisedToPickup;

    @Column(name = "is_primarycontact", columnDefinition = "TINYINT")
    private Boolean isPrimaryContact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "childcarecenter_id")
    private ChildcareCenter childcareCenter;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "createdby")
    private String createdBy;

    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

	public Long getGuardianId() {
		return guardianId;
	}

	public void setGuardianId(Long guardianId) {
		this.guardianId = guardianId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public Boolean getIsEmergencyContact() {
		return isEmergencyContact;
	}

	public void setIsEmergencyContact(Boolean isEmergencyContact) {
		this.isEmergencyContact = isEmergencyContact;
	}

	public Boolean getIsAuthorisedToPickup() {
		return isAuthorisedToPickup;
	}

	public void setIsAuthorisedToPickup(Boolean isAuthorisedToPickup) {
		this.isAuthorisedToPickup = isAuthorisedToPickup;
	}

	public Boolean getIsPrimaryContact() {
		return isPrimaryContact;
	}

	public void setIsPrimaryContact(Boolean isPrimaryContact) {
		this.isPrimaryContact = isPrimaryContact;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

