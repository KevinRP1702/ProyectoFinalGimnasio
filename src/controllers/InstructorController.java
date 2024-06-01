package controllers;

import javax.swing.JFrame;

import views.InstructorView;

public class InstructorController {
	
	public InstructorView vista;
	
	public InstructorController() {
		
		vista = new InstructorView();
		
	}
	
	public void instructor() {
		
		vista.instructor();
		
	}
	
	public void CrearInstructor() {
		
		vista.crearInstructor();
		
	}
	
	public void AvatarInstructor() {
		
		vista.crearInstructorAvatar();
		
	}
}
