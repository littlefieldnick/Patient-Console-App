package edu.usm.cos420;

import java.text.ParseException;

import edu.usm.cos420.controller.console.MainMenuController;
import edu.usm.cos420.view.console.MainMenuView;

public class App {
	public static void main(String [] args) throws ParseException {
		MainMenuView mainMenu = new MainMenuView();
		MainMenuController controller = new MainMenuController(mainMenu);
		controller.init();
	}
}
