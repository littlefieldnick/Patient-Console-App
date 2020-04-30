package edu.usm.cos420.view.console;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import edu.usm.cos420.domain.Patient;

public class PatientView {
	private Scanner in;

	public PatientView() {
		this.in = new Scanner(System.in);
	}
	
	public void viewPatient(Patient p) {
		System.out.println();
		System.out.println(p);
	}

	public void listAllPatients(List<Patient> patients) {
		System.out.println();
		if(patients.size() == 0) {
			System.out.println("There are no patients in the database to view.");
			return;
		}
		
		for(Patient p: patients) {
			System.out.println(p.getBasicInfo());
		}
	}
	
	public void displayError(String error) {
		System.out.println();
		System.out.println("An error has occurred: " + error);
	}
	
	public Date readDateWithPrompt(String prompt) {
		Date date = null;
		System.out.print(prompt); 
		System.out.flush();
		boolean wrongFormat = true;
		
		while(wrongFormat) {
			try {
				String choice = in.nextLine();
				if(choice.isEmpty())
					return null;
				date = new SimpleDateFormat("MM/dd/yyyy").parse(choice);
				wrongFormat = false;
			} catch(ParseException e) {
				System.out.println("Date is not a valid format! Use the format MM/dd/yyyy.");
			}
		}
		
		return date;
	}

	public int readIntWithPrompt (String prompt) {
		System.out.print(prompt); 
		System.out.flush();
		int choice = Integer.parseInt(in.nextLine());
		return choice;
	}

	public String readStringWithPrompt (String prompt) {
		System.out.print(prompt); 
		System.out.flush();
		String choice = in.nextLine();
		return choice;
	}

}
