package edu.usm.cos420.dao.console.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import edu.usm.cos420.dao.GenericDao;
import edu.usm.cos420.dao.JsonDao;
import edu.usm.cos420.dao.PatientDao;
import edu.usm.cos420.domain.Patient;

/**
 * 
 *  A Data Access Object specifically for CItem entities 
 *     
 */
public class PatientDaoImpl implements PatientDao
{
	private GenericDao<Long, Patient> patientDao;

	/**
	 * Default constructor creates an Json file called citem.json
	 * TypeToken allows the GSON parser to map to/from JSON to objects
	 */
	public PatientDaoImpl()
	{
		Type t = new TypeToken<Map<Long, Patient>>(){}.getType(); 
		patientDao = new JsonDao<Long, Patient>("citem.json",t); 
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public PatientDaoImpl(String fileName)
	{
		Type t = new TypeToken<Map<Long, Patient>>(){}.getType(); 
		patientDao = new JsonDao<Long, Patient>(fileName,t); 
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,CItem> 
	 */
	public PatientDaoImpl(GenericDao<Long,Patient> dao)
	{
		patientDao = dao;
	}

	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,CItem> 
	 */
	public GenericDao<Long, Patient> getCItemDao() {
		return patientDao;
	}

	public Long createPatient(Patient patient) {
		patientDao.add(patient.getId(), patient);
		return patient.getId();
	}

	
	public Patient readPatient(Long patientId) {
		return patientDao.find(patientId);
	}

	
	public void updatePatient(Patient patient){
		patientDao.update(patient.getId(), patient);

	}

	
	public void deletePatient(Long patientId){
		patientDao.remove(patientId);

	}

	
	public List<Patient> listPatients() {
		return patientDao.list();
	}

}