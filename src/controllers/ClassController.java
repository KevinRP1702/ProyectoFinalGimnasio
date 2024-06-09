package controllers;

import java.util.List;

import models.ClassModel;
import views.ClassView;

public class ClassController {

	public ClassView vista;
	private ClassModel data;
	
	public ClassController() {
		
		data = new ClassModel();
		vista = new ClassView();
		
	}
	
	public void clase() {
		
		vista.clase();

	}
	
	public void CrearClase() {
		
		vista.clasesCrear();
		
	}
	
	public void consultarClase(String claseSeleccionada) {

		vista.consultarClase(claseSeleccionada);
		
	}
	
	public void editarClase(String claseSeleccionada) {
		vista.claseEditar(claseSeleccionada);
	}
}
