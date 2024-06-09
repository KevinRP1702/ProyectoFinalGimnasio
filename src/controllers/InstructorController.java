package controllers;

import java.util.List;

import javax.swing.JFrame;

import models.InstructorModel;
import views.InstructorView;

public class InstructorController {
	
	public InstructorView vista;
	private InstructorModel data;
	
	public InstructorController() {
		
		vista = new InstructorView();
		data = new InstructorModel();
	
	}
	
	public void instructor() {
		
		Object[][] instructores = data.get();
		vista.instructor(instructores);
		
	}
	
	public void CrearInstructor(String imgInstructor) {
		
		vista.crearInstructor(imgInstructor);
		
	}
	
	public void editarInstructor(String idInstructor) {
		
		vista.editarInstructor(idInstructor);
	}
	
	public void AvatarInstructor() {
		
		vista.crearInstructorAvatar();
		
	}
}
