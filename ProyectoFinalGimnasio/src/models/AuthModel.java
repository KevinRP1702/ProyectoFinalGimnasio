package models;
import java.sql.*;

import controllers.HomeController;  

public class AuthModel {
	
	public HomeController home;

	public boolean login(String usuario, String contra) {
		boolean inicio = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `Usuarios`WHERE usuario = '"+usuario+"' AND contraseña = '"+contra+"';");  
			while(rs.next()) {
				
					home = new HomeController();
					home.inicio();
					return true;
			}
			con.close();  
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void registro(String nombre,String correo, String contraseña) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
				
				PreparedStatement stmt=con.prepareStatement("insert into Usuarios(usuario, correo, contraseña) values(?,?,?)");  
				stmt.setString(1,nombre);
				stmt.setString(2,correo);
				stmt.setString(3,contraseña);  
				  
				int i=stmt.executeUpdate();  
 
				con.close();  
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
