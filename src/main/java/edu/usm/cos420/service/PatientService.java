package edu.usm.cos420.service;

import java.sql.SQLException;
import java.util.List;

import edu.usm.cos420.dao.PatientDao;
import edu.usm.cos420.dao.console.impl.PatientDaoImpl;
import edu.usm.cos420.domain.Patient;

public class PatientService {
	PatientDao pDao;
	
	public PatientService() {
		pDao = new PatientDaoImpl("patients.json");
	}
	
	public void addPatient(Patient p) {
		pDao.createPatient(p);
	}
	
	public List<Patient> getPatients(){
		return pDao.listPatients();
	}
	
	public Patient getPatient(long id) {
		return pDao.readPatient(id);
	}
	
	public void updatePatient(Patient p) {
		pDao.updatePatient(p);
	}
	
	public void deletePatient(long id) {
		pDao.deletePatient(id);
	}
	
	public boolean doesExist(long id) {
		return pDao.readPatient(id) != null;
	}
}
