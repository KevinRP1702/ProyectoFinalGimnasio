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
		
		public void crearCliente(String rutaImagen) {
			
			vista.crearClientes(rutaImagen);
			
		}
		
		public void crearClienteFoto(int idUsuario, int opcion) {
			
			vista.crearClientesFoto(idUsuario, opcion);
			
		}
		
		public void consultar(int idUsuario) {
			vista.informacionClientes(idUsuario);
		}
		
		public void editar(int idUsuario, String rutaImagen) {
			vista.clienteEditar(idUsuario, rutaImagen);
		}
}
