package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClientModel {

	public ArrayList<String[]> obtenerDatosClientes() {
        ArrayList<String[]> datosClientes = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t")) {
                String query = "SELECT idCliente, nombres, apellidos, correo FROM Clientes;";
                
                try (PreparedStatement pstmt = con.prepareStatement(query);
                     ResultSet rs = pstmt.executeQuery()) {
                    
                    while (rs.next()) {
                        String[] clienteData = new String[4];
                        clienteData[0] = rs.getString("idCliente");
                        clienteData[1] = rs.getString("nombres");
                        clienteData[2] = rs.getString("apellidos");
                        clienteData[3] = rs.getString("correo");
                        datosClientes.add(clienteData);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return datosClientes;
    }
	
	public boolean registrarCliente(String nombres, String apellidos, String fechaNacimiento, int telefono, String correo) {
        boolean clienteExiste = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

           
            String verificarClienteQuery = "SELECT * FROM Clientes WHERE nombres = ? AND apellidos = ?";
            try (PreparedStatement pstmtVerificar = con.prepareStatement(verificarClienteQuery)) {
                pstmtVerificar.setString(1, nombres);
                pstmtVerificar.setString(2, apellidos);

                try (ResultSet rsVerificar = pstmtVerificar.executeQuery()) {
                    if (rsVerificar.next()) {
                        clienteExiste = true;
                        return false; 
                    }
                }
            }

            if (!clienteExiste) {
                String insertarClienteQuery = "INSERT INTO Clientes (nombres, apellidos, fecha_nacimiento,telefono, correo) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmtInsertar = con.prepareStatement(insertarClienteQuery)) {
                	
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsedDate = dateFormat.parse(fechaNacimiento);
                    java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                    pstmtInsertar.setString(1, nombres);
                    pstmtInsertar.setString(2, apellidos);
                    pstmtInsertar.setDate(3, sqlDate);
                    pstmtInsertar.setInt(4, telefono);
                    pstmtInsertar.setString(5, correo);
                   

                    int filasInsertadas = pstmtInsertar.executeUpdate();
                    if (filasInsertadas > 0) {
                        return true; 
                    }
                } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

	public ArrayList<String> datosClientes(int idCliente) {
        ArrayList<String> datosCliente = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

            String query = "SELECT idCliente, nombres, apellidos, fecha_nacimiento, correo FROM Clientes WHERE idCliente = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idCliente);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                datosCliente.add(rs.getString("nombres"));
                datosCliente.add(rs.getString("apellidos"));
                datosCliente.add(rs.getString("fecha_nacimiento")); 
                datosCliente.add(rs.getString("correo"));
                datosCliente.add(rs.getString("idCliente"));
            } else {
                return null;
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return datosCliente;
    }
	
	public boolean editarCliente(int idCliente, String nuevosNombres, String nuevosApellidos, String nuevaFechaNacimiento, String nuevoCorreo, String nuevoTelefono) {
        boolean actualizado = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

            String query = "UPDATE Clientes SET nombres = ?, apellidos = ?, fecha_nacimiento = ?, correo = ?, telefono = ? WHERE idCliente = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, nuevosNombres);
            pstmt.setString(2, nuevosApellidos);
            pstmt.setString(3, nuevaFechaNacimiento);
            pstmt.setString(4, nuevoCorreo);
            pstmt.setString(5, nuevoTelefono);
            pstmt.setInt(6, idCliente);

            int filasActualizadas = pstmt.executeUpdate();
            if (filasActualizadas > 0) {
                actualizado = true;
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return actualizado;
    }
	
	 public boolean eliminarCliente(int idCliente) {
	        boolean eliminado = false;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

	            String query = "DELETE FROM Clientes WHERE idCliente = ?";
	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, idCliente);

	            int filasEliminadas = pstmt.executeUpdate();
	            if (filasEliminadas > 0) {
	                eliminado = true;
	            }

	            con.close();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }

	        return eliminado;
	    }
	
}
