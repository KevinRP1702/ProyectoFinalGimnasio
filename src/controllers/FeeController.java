package controllers;

import views.FeeView;

public class FeeController {

	public FeeView vista;
	
	public FeeController(){
		
		vista = new FeeView();
	}
	
	public void tarifa() {
		
		vista.tarifa();
		
	}
	
	public void pagar() {
		vista.tarifaPago();
	}
}
