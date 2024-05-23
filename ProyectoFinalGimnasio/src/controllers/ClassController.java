package controllers;

import views.ClassView;

public class ClassController {

	public ClassView vista;
	
	public ClassController() {
		
		vista = new ClassView();
		
	}
	
	public void clase() {
		
		vista.clase();
		
	}
	
	public void CrearClase() {
		
		vista.clasesCrear();
		
	}
	
	public void consultarClase() {
		
		vista.consultarClase();
		
	}
}
