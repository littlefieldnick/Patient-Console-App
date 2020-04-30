package edu.usm.cos420.controller.console;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import edu.usm.cos420.domain.Patient;
import edu.usm.cos420.service.PatientService;
import edu.usm.cos420.view.console.PatientView;

public class PatientController {
	PatientView view = new PatientView();
	PatientService pService = new PatientService();
	
	public PatientController(PatientView view, PatientService service) {
		this.view = view;
		this.pService = service;
	}
	
	public void addPatient() throws ParseException {
		int id = view.readIntWithPrompt("Enter patient id: ");
		
		if(pService.doesExist(id)) {
			view.displayError("This patient already exists. Patient cannot be created with this id.");
			return;
		}
		
		String fName = view.readStringWithPrompt("Enter first name: ");
		String lName = view.readStringWithPrompt("Enter last name: ");
		String address = view.readStringWithPrompt("Enter address: ");
		String gender = view.readStringWithPrompt("Enter gender: ");
		Date dob = view.readDateWithPrompt("Enter date of birth (mm/dd/yyyy): ");
		Patient patient = new Patient(id, fName, lName, address, gender, dob);
		pService.addPatient(patient);
	}
	
	public void displayAllPatients() {
		List<Patient> patients = pService.getPatients();
		this.view.listAllPatients(patients);
	}

	public void viewPatientInfo() {
		this.displayAllPatients();
		int id = view.readIntWithPrompt("Enter patient id from the list above: ");
		if(!pService.doesExist(id)) {
			view.displayError("Patient does not exist. Check patient id.");
			return;
		}
		Patient p = pService.getPatient(id);
		this.view.viewPatient(p);
	}

	public void editPatientInfo() {
		this.displayAllPatients();
		int id = view.readIntWithPrompt("Enter patient id from the list above: ");
		if(!pService.doesExist(id)) {
			view.displayError("Patient does not exist. Check patient id.");
			return;
		}
		
		Patient patient = this.pService.getPatient(id);
		String fName = view.readStringWithPrompt("Enter first name (Press enter to remain the same): ");
		String lName = view.readStringWithPrompt("Enter last name (Press enter to remain the same): ");
		String address = view.readStringWithPrompt("Enter address (Press enter to remain the same): ");
		String gender = view.readStringWithPrompt("Enter gender (Press enter to remain the same): ");
		Date dob = view.readDateWithPrompt("Enter date of birth [mm/dd/yyyy] (Press enter to remain the same): ");
		
		if(!fName.isEmpty())
			patient.setFirstName(fName);
		
		if(!lName.isEmpty())
			patient.setLastName(lName);
		
		if(!address.isEmpty())
			patient.setAddress(address);
		
		if(!gender.isEmpty())
			patient.setGender(gender);
		
		if(dob != null)
			patient.setBirthDate(dob);
		
		this.pService.updatePatient(patient);
		
	}

	public void deletePatient() {
		this.displayAllPatients();
		int id = view.readIntWithPrompt("Enter patient id from the list above: ");
		
		if(!pService.doesExist(id)) {
			view.displayError("Patient does not exist. Check patient id.");
			return;
		}
		
		this.pService.deletePatient(id);
	}

}
