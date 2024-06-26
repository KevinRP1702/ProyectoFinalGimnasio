package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FeeModel {

	public ArrayList<String> datosClientes(int idCliente) {
		ArrayList<String> datosCliente = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT idCliente, nombres, apellidos, correo FROM `Clientes` WHERE idCliente = '" + idCliente + "';");

			if (rs.next()) {
				datosCliente.add(rs.getString("nombres"));
				datosCliente.add(rs.getString("apellidos"));
				datosCliente.add(rs.getString("correo"));
				datosCliente.add(rs.getString("idCliente"));
			}else {
				return null;
			}

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return datosCliente;
	}

	public void pagar(int idCliente, double monto) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

			String query = "INSERT INTO Pagos (idCliente, monto) VALUES (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, idCliente);
			pstmt.setDouble(2, monto);
			pstmt.executeUpdate();

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String[]> obtenerDatosPagos() {
		ArrayList<String[]> datosPagos = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t")) {
				String query = "SELECT c.nombres, c.apellidos, p.monto, p.idCliente " +
						"FROM Pagos p " +
						"JOIN Clientes c ON p.idCliente = c.idCliente;";

				try (PreparedStatement pstmt = con.prepareStatement(query);
						ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						String[] pagoData = new String[4];
						pagoData[0] = rs.getString("nombres");
						pagoData[1] = rs.getString("apellidos");
						pagoData[2] = rs.getString("monto");
						pagoData[3] = rs.getString("idCliente");
						datosPagos.add(pagoData);
					}
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return datosPagos;
	}

	public boolean eliminarPago(int idCliente) {
	   
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");
	        String selectQuery = "SELECT id_pago FROM Pagos WHERE idCliente = ? ORDER BY id_pago DESC LIMIT 1";
	        PreparedStatement  selectStmt = con.prepareStatement(selectQuery);
	        selectStmt.setInt(1, idCliente);
	        ResultSet rs = selectStmt.executeQuery();
	        
	        if (rs.next()) {
	            int idPago = rs.getInt("id_pago");
	            String deleteQuery = "DELETE FROM Pagos WHERE id_pago = ?";
	            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
	            deleteStmt.setInt(1, idPago);
	            deleteStmt.executeUpdate();
	            return true;
	        } else {
	           return false; 
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } 
	    return false;
	   
	}
	
	public boolean estadoMembresia(int idCliente) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t")) {
                String query = "SELECT 1 FROM Pagos WHERE idCliente = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setInt(1, idCliente);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            return true;
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
