package edu.usm.cos420.controller.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usm.cos420.dao.cloud.impl.PatientCloudSQLDaoImpl;
import edu.usm.cos420.dao.PatientDao;
import edu.usm.cos420.domain.Patient;

@WebServlet(urlPatterns = {"/list"})
public class ListPatientServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//Get DB information
		Properties properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream("database.properties"));

		String dbUrl = String.format(this.getServletContext().getInitParameter("sql.urlRemote"), 
				properties.getProperty("sql.dbName"), properties.getProperty("sql.instanceName"), 
				properties.getProperty("sql.userName"), properties.getProperty("sql.password"));
		
//		System.out.println("Database URL: " + dbUrl );
		PatientDao dao = null;
		
		try {
			dao = new PatientCloudSQLDaoImpl(dbUrl);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
		List<Patient> patients = null;
		
		try {
			patients = dao.listPatients();
		} catch (Exception e) {
			throw new ServletException("Error listing patients", e);
		}
		
		req.getSession().getServletContext().setAttribute("patients", patients);
		
	    req.setAttribute("page", "list");

		req.getRequestDispatcher("/base.jsp").forward(req, resp);
	}
}
