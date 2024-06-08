package controllers;

import views.ClientView;

public class ClientController {

	public ClientView vista;
	
	public ClientController() {
			
			vista = new ClientView();
			
		}
		
		public void cliente() {
			
			vista.cliente();
			
		}
		
		public void crearCliente() {
			
			vista.crearClientes();
			
		}
		
//		public void crearClienteFoto() {
//			
//			vista.crearClientesFoto();
//			
//		}
		
		public void consultar(int idUsuario) {
			vista.informacionClientes(idUsuario);
		}
		
		public void editar(int idUsuario) {
			vista.clienteEditar(idUsuario);
		}
}
