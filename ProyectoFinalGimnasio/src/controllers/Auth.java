package controllers;

import views.AuthView;
import views.CloseSessionView;

public class Auth {

	public AuthView vista;
	public CloseSessionView vista2;
	
	public Auth() {
		
		vista = new AuthView();
		vista2 = new CloseSessionView();
	}
	
	public void login() {
		
		vista.login();
		
	}
	
	public void registro() {
		
		vista.registro();
		
	}
	
	public void cerrar() {
		
		vista2.Cerrar();
		
	}
}
