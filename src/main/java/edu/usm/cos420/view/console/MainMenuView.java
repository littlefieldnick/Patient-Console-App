package edu.usm.cos420.view.console;

import java.util.Scanner;

public class MainMenuView {
	
	public static final int NO_CHOICE = 0;
    public static final int ADD_PATIENT = 1;
    public static final int LIST_PATIENT = 2;
    public static final int VIEW_PATIENT = 3;
    public static final int EDIT_PATIENT = 4;
    public static final int DELETE_PATIENT = 5;
    public static final int EXIT = 6;

    private Scanner in; 
    
    public MainMenuView() {
    	this.in = new Scanner(System.in);
    }
    
    public void displayMenu() {
    	System.out.println();
        System.out.println("Enter the number denoting the action " +
                           "to perform:");
        System.out.println("ADD PATIENT....................." + ADD_PATIENT);
        System.out.println("LIST PATIENTS........................" + LIST_PATIENT);
        System.out.println("VIEW PATIENT........................." + VIEW_PATIENT);
        System.out.println("EDIT PATIENT........................" + EDIT_PATIENT);
        System.out.println("DELETE PATIENT........................" + DELETE_PATIENT);
    }

    public int readIntWithPrompt (String prompt) {
        System.out.print(prompt); 
        System.out.flush();
        int choice = in.nextInt();
        return choice;
      }
}
