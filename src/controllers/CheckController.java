package controllers;

import views.CheckView;

public class CheckController {

	public CheckView vista;
	
	public CheckController() {
		
		vista = new CheckView();
	}
	
	public void checador() {
		
		vista.checador();
		
	}
}
