package com.peoplesconsulting.childcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.peoplesconsulting.childcare.DTO.StudentDetailDTO;
import com.peoplesconsulting.childcare.DTO.StudentDetailsRequest;
import com.peoplesconsulting.childcare.DTO.StudentDetailsResponse;
import com.peoplesconsulting.childcare.DTO.StudentHealthDetailsDTO;
import com.peoplesconsulting.childcare.entity.*;

import com.peoplesconsulting.childcare.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private StudentActivityRepository studentActivityRepository;
    
    @Autowired
    private StudentActivityService studentActivityService;

    @Autowired
    private GuardianRepository guardianRepository;
    
    @Autowired
    private MedicationsRepository medicationsRepository;
    
    @Autowired
    private MedicationsService medicationsService;
    
    @Autowired
    private AllergiesRepository allergiesRepository;
    
    @Autowired
    private AllergiesService allergiesService;
    
    @Autowired
    private GuardianService guardianService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private StudentHealthDetailsRepository studentHealthDetailsRepository;

//    @Autowired
//    private ChildDocumentRepository childDocumentRepository;

    @Autowired
    private StudentSubsidyRepository studentSubsidyRepository;

    @Autowired
    private TimeCardRepository timeCardRepository;
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private ClassroomService classroomService;
    
    @Autowired
    private DoctorRepository docRepository;

    @Transactional
    public StudentDetailsResponse saveStudentWithDetails(StudentDetailDTO request) {
    	
    	StudentDetailsResponse response = new StudentDetailsResponse();
        
        Address studentAddress = getStudentAddress(request);
        studentAddress = createOrUpdateAddress(studentAddress);
        
        Address gaurdiantAddress = getGaurdianAddress(request);
        gaurdiantAddress = createOrUpdateAddress(gaurdiantAddress);  
        
        Guardian guardian = request.getGuardian();
        createOrUpdateGuardian(guardian,gaurdiantAddress);
        
        Classroom classroom = request.getClassroom();
        classroom.getClassroomId();
        
        if (classroomService.getClassroomById(classroom.getClassroomId()).isPresent()) {
        	classroom = classroomRepository.getById(classroom.getClassroomId());
         }
        
        Student student = request.getStudent();
        student.setClassroom(classroom);
        createOrUpdateStudent(student,studentAddress);
        
        updateOrCreateStudentActivites(request,student);
        
        createOrUpdateStudentHealthDetails(request,student);
        
        createOrUpdateStudentSchedule(request,student);
        
        createOrUpdateStudentSubsidy(request,student);
        
        createOrUpdateStudentTimeCard(request,student,classroom);
        
        response.setStudent(student);

        return response;
    }


	private void createOrUpdateStudentTimeCard(StudentDetailDTO request, Student student, Classroom classroom) {
		List<TimeCard> timeCard = request.getTimeCards();
		for(TimeCard card : timeCard) {
			card.setStudent(student);
			card.setClassroom(classroom);
			timeCardRepository.save(card);
		}
		
	}


	private void createOrUpdateStudentSubsidy(StudentDetailDTO request, Student student) {
		StudentSubsidy studentSubsidy = request.getStudentSubsidies();
		studentSubsidy.setStudent(student);
		studentSubsidyRepository.save(studentSubsidy);
	}


	private void createOrUpdateStudentSchedule(StudentDetailDTO request, Student student) {
		Schedule schedule = request.getSchedule();
		schedule.setStudent(student);
		scheduleRepository.save(schedule);
	}


	private void createOrUpdateStudentHealthDetails(StudentDetailDTO request, Student student) {
		StudentHealthDetailsDTO healthDetailsDto = request.getStudentHealthDetails();
		
		StudentHealthDetails healthDetails = new StudentHealthDetails();
		
		Long healthId = request.getStudentHealthDetails().getHealthId();
		if(healthId != null && healthId>0) {
			healthDetails = studentHealthDetailsRepository.getById(healthId);
		}else {
			healthDetails = new StudentHealthDetails();
		}
		healthDetails.setStudent(student);
		
		healthDetails.setDietRestriction(healthDetailsDto.getDietRestriction());
		healthDetails.setFoodProgram(healthDetailsDto.getFoodProgram());
		healthDetails.setHealthNotes(healthDetailsDto.getHealthNotes());
		studentHealthDetailsRepository.save(healthDetails);
		List<Allergies> updatedAllergies = new ArrayList<>();
		for (Allergies allergy : healthDetailsDto.getAllergies()) {
            // Check if allergy is a new record or an existing one
            if (allergy.getAllergyId() != null) {
                Optional<Allergies> existingAllergy = allergiesRepository.findById(allergy.getAllergyId());
                if (existingAllergy.isPresent()) {
                    updatedAllergies.add(existingAllergy.get());
                } else {
                	// Create new allergy and save it
                    Allergies newAllergy = new Allergies();
                    // Set properties of newAllergy using data from allergy
                    allergiesRepository.save(allergy);
                    updatedAllergies.add(allergy);
                }
            } else {
                // Create new allergy and save it
               // Allergies newAllergy = new Allergies();
                allergy.setStudentHealthDetails(healthDetails);
                // Set properties of newAllergy using data from allergy
                allergiesRepository.save(allergy);
                updatedAllergies.add(allergy);
            }
        }
		healthDetails.setAllergies(updatedAllergies);

        List<Medications> updatedMedications = new ArrayList<>();
        for (Medications medication : healthDetailsDto.getMedications()) {
        	Doctor doc = medication.getDoctor();
        	if(doc != null) {
        	createOrUpdateDoctor(doc);
        	}
            if (medication.getMedicationId() != null) {
                Optional<Medications> existingMedication = medicationsRepository.findById(medication.getMedicationId());
                if (existingMedication.isPresent()) {
                    updatedMedications.add(existingMedication.get());
                } else {
                    Medications newMedication = new Medications();
                    // Set properties of newMedication using data from medication
                    medication.setDoctor(doc);
                    medicationsRepository.save(medication);
                    updatedMedications.add(medication);
                }
            } else {
                // Create new medication and save it
                Medications newMedication = new Medications();
                medication.setStudentHealthDetails(healthDetails);
                // Set properties of newMedication using data from medication
                medication.setDoctor(doc);
                medicationsRepository.save(medication);
                updatedMedications.add(medication);
            }
        }
        healthDetails.setMedications(updatedMedications);
        studentHealthDetailsRepository.save(healthDetails);

	}


	private void updateOrCreateStudentActivites(StudentDetailDTO request, Student student) {
		List<StudentActivity> activites = request.getStudentActivities();
		Long stundentId = student.getStudentId();
		for(StudentActivity activity : activites) {
			activity.setStudent(student);
			if(activity.getStudentActivityId() != null && activity.getStudentActivityId() >= 0) {
				if(!studentActivityService.getStudentActivityById(stundentId).isPresent()) {
					activity = studentActivityRepository.save(activity);
				}
				activity.setStudentActivityId(activity.getStudentActivityId()); // Ensure the correct ID is set
				
				activity = studentActivityRepository.save(activity);
			}		
			activity = studentActivityRepository.save(activity);
		}		
	}
	
	private void createOrUpdateDoctor(Doctor doc) {
		if(doc.getDoctorId() != null && doc.getDoctorId() >= 0) {        	
    		doc = docRepository.save(doc);
        } else {
        	Address address = doc.getAddress();
        	if(address.getAddressId() != null && address.getAddressId() > 0) {
        		doc.setAddress(address);
        	} else {
        		createOrUpdateAddress(address);
        		doc.setAddress(address);
        	}        	
        	doc = docRepository.save(doc);
        }
		
	}


	private void createOrUpdateStudent(Student student, Address studentAddress) {
		if(student.getStudentId() != null && student.getStudentId() >= 0) {
        	if (!getStudentById(student.getStudentId()).isPresent()) {
               // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        		student = repository.save(student);
            }
        	student.setStudentId(student.getStudentId());
        	student.setAddress(studentAddress);
        	student = updateStudent(student.getStudentId(),student);
            
        } else {
        	student.setAddress(studentAddress);
        	student = repository.save(student);
        }
		
	}


	private Address createOrUpdateAddress(Address studentAddress) {
		if(studentAddress.getAddressId() != null && studentAddress.getAddressId() >= 0) {
        	if (!addressService.getAddressById(studentAddress.getAddressId()).isPresent()) {
               // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        		studentAddress = addressRepository.save(studentAddress);
            }
        	studentAddress.setAddressId(studentAddress.getAddressId());
            studentAddress = addressService.saveAddress(studentAddress);
            
        } else {
        	studentAddress = addressRepository.save(studentAddress);
        }
		return studentAddress;
	}
	
	private Guardian createOrUpdateGuardian(Guardian guardian, Address gaurdiantAddress) {
		if(guardian.getGuardianId() != null && guardian.getGuardianId() >= 0) {
        	if (!guardianService.getGuardianById(guardian.getGuardianId()).isPresent()) {
               // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        		guardian = guardianRepository.save(guardian);
            }
        	guardian.setGuardianId(guardian.getGuardianId());
        	guardian.setAddress(gaurdiantAddress);
        	guardian = guardianService.updateGuardian(guardian.getGuardianId(),guardian);
            
        } else {
        	guardian.setAddress(gaurdiantAddress);
        	guardian = guardianRepository.save(guardian);
        }
		return guardian;
	}


	private Address getStudentAddress(StudentDetailDTO request) {
		return request.getStudent().getAddress();
	}
	
	private Address getGaurdianAddress(StudentDetailDTO request) {
		return request.getGuardian().getAddress();
	}

    private List<TimeCard> mapTimeCardDTOsToEntities(List<TimeCard> timeCards, Student student) {
		// TODO Auto-generated method stub
		return null;
	}


	private List<StudentSubsidy> mapStudentSubsidyDTOsToEntities(List<StudentSubsidy> studentSubsidies,
			Student student) {
		// TODO Auto-generated method stub
		return null;
	}


	private List<ChildDocument> mapChildDocumentDTOsToEntities(List<ChildDocument> childDocuments, Student student) {
		// TODO Auto-generated method stub
		return null;
	}


	private StudentHealthDetails mapStudentHealthDetailsDTOToEntity(StudentHealthDetails studentHealthDetails,
			Student student) {
		// TODO Auto-generated method stub
		return null;
	}


	private Schedule mapScheduleDTOToEntity(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}


	private Guardian mapGuardianDTOToEntity(Guardian guardian) {
		// TODO Auto-generated method stub
		return null;
	}


	private List<StudentActivity> mapStudentActivityDTOsToEntities(List<StudentActivity> studentActivities,
			Student student) {
		// TODO Auto-generated method stub
		return null;
	}


	private List<Activity> mapActivityDTOsToEntities(List<Activity> activities) {
		// TODO Auto-generated method stub
		return null;
	}


	private Classroom mapClassroomDTOToEntity(Classroom classroom) {
		// TODO Auto-generated method stub
		return null;
	}


	private Student mapStudentDTOToEntity(Student student) {
		
		return null;
	}


	private Object mapStudentEntityToDTO(Student student) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student) {
        student.setStudentId(id); // Ensure the correct ID is set
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
