package edu.usm.cos420.controller.console;

import java.text.ParseException;

import edu.usm.cos420.service.PatientService;
import edu.usm.cos420.view.console.MainMenuView;
import edu.usm.cos420.view.console.PatientView;

public class MainMenuController {
	MainMenuView mainMenu;
	PatientController patientController;
	public MainMenuController(MainMenuView view) {
		this.mainMenu = view;
		this.patientController = new PatientController(new PatientView(), new PatientService());
	}

	public void init() throws ParseException {
		int menuOption = Integer.MAX_VALUE;
		while(menuOption != MainMenuView.EXIT) {
			mainMenu.displayMenu();
			menuOption = mainMenu.readIntWithPrompt("Enter Option: ");
			if(menuOption == MainMenuView.ADD_PATIENT)
				patientController.addPatient();
			else if(menuOption == MainMenuView.LIST_PATIENT)
				patientController.displayAllPatients();
			else if(menuOption == MainMenuView.VIEW_PATIENT)
				patientController.viewPatientInfo();
			else if(menuOption == MainMenuView.EDIT_PATIENT)
				patientController.editPatientInfo();
			else if(menuOption == MainMenuView.DELETE_PATIENT)
				patientController.deletePatient();
		
		}
	}
}
