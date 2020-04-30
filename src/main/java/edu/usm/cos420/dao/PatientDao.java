package edu.usm.cos420.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usm.cos420.domain.Patient;
import edu.usm.cos420.domain.Result;

public interface PatientDao {
	Long createPatient(Patient patient);

	Patient readPatient(Long patientId);

	void updatePatient(Patient patient);

	void deletePatient(Long patientId);

	List<Patient> listPatients();
}