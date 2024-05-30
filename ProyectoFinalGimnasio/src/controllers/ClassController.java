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
		
		List<List<Object>> clases = data.get();
		vista.clase(clases);

	}
	
	public void CrearClase() {
		
		vista.clasesCrear();
		
	}
	
	public void consultarClase(String claseSeleccionada) {
		
		List<List> clientesClases = data.clientesClases(claseSeleccionada);
		vista.consultarClase(claseSeleccionada, clientesClases);
		
	}
}
