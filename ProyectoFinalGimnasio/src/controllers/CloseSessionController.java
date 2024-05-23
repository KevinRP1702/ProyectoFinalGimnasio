package controllers;

import views.CloseSessionView;

public class CloseSessionController {

	public CloseSessionView vista;
	
	public CloseSessionController() {
		
		vista = new CloseSessionView();
		
	}
	
	public void cerrar() {
		
		vista.Cerrar();
	}
}
