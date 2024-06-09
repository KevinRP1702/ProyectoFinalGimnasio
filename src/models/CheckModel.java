package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckModel {
	
	public int verificarVisitas(int idCliente) {
	    int asistencias = -1; // Default value indicating not found

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

	        String query = "SELECT asistencias FROM Clientes WHERE idCliente = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, idCliente);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            asistencias = rs.getInt("asistencias");
	        }

	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return asistencias;
	}

	public void ContarVisita(int userID,int asistencia ) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

		        // Step 1: Retrieve the current 'asistencias' count
		        String selectQuery = "SELECT asistencias FROM Clientes WHERE idCliente = ?";
		        PreparedStatement selectStmt = con.prepareStatement(selectQuery);
		        selectStmt.setInt(1, userID);

		        String updateQuery = "UPDATE Clientes SET asistencias = ? WHERE idCliente = ?";
		        PreparedStatement updateStmt = con.prepareStatement(updateQuery);
		        updateStmt.setInt(1, asistencia);
		        updateStmt.setInt(2, userID);

		        updateStmt.executeUpdate();

		        // Close connections
		        con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
	
	public String[] obtenerNombreCliente(String idCliente) {
	    String[] clienteData = new String[1];

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t")) {
	            String query = "SELECT idCliente, nombres FROM Clientes WHERE idCliente = ?;";
	            
	            try (PreparedStatement pstmt = con.prepareStatement(query)) {
	                pstmt.setString(1, idCliente);
	                ResultSet rs = pstmt.executeQuery();
	                
	                if (rs.next()) {
	                    clienteData[0] = rs.getString("nombres");
	                   
	                } else {
	                    clienteData = null;
	                }
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return clienteData;
	}
}
