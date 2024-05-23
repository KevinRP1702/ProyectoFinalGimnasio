package controllers;

import views.HomeView;

public class HomeController {

	public HomeView vista;
	
	public HomeController() {
		
		vista = new HomeView();
		
	}
	
	public void inicio() {
		
		vista.Inicio();;
		
	}
}
