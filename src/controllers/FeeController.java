package controllers;

import models.FeeModel;
import views.FeeView;

public class FeeController {

	public FeeView vista;
	private FeeModel data;
	
	public FeeController(){
		
		vista = new FeeView();
		data = new FeeModel();
	}
	
	public void tarifa() {
		
		vista.tarifa();
		
	}
	
	public void pagar(int idUsuario) {
		vista.tarifaPago(idUsuario);
	}
}
