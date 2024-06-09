package models;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ClassModel {

	public boolean registroClase(String nombreClase, String nombreInstructor) {
		
		boolean claseCreada = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
				
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT * FROM `Clases` WHERE clase = '"+nombreClase+"';");  
				if (rs.next()) {
		                claseCreada = true;
		                return true; 
		        }
				
				if(claseCreada == false) {
						PreparedStatement stmt2=con.prepareStatement("insert into Clases(clase, instructor) values(?,?)");  
						stmt2.setString(1,nombreClase);
						stmt2.setString(2,nombreInstructor); 
				  
						int i=stmt2.executeUpdate();
						return false;
				}
				
				con.close();  
				
			} catch (ClassNotFoundException |SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return true;
	}
	
	public ArrayList<String[]> obtenerDatosClases() {
	    ArrayList<String[]> datosClases = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t")) {
	            String query = "SELECT idClase, clase, instructor FROM Clases;";
	            
	            try (PreparedStatement pstmt = con.prepareStatement(query);
	                 ResultSet rs = pstmt.executeQuery()) {
	                
	                while (rs.next()) {
	                    String[] claseData = new String[3];
	                    claseData[0] = rs.getString("idClase");
	                    claseData[1] = rs.getString("clase");
	                    claseData[2] = rs.getString("instructor");

	              
	                    String subQuery = "SELECT COUNT(*) FROM Inscripciones WHERE clase_id = ?";
	                    try (PreparedStatement subPstmt = con.prepareStatement(subQuery)) {
	                        subPstmt.setString(1, claseData[0]);
	                        try (ResultSet rs2 = subPstmt.executeQuery()) {
	                            if (rs2.next()) {
	                                String numeroClientes = Integer.toString(rs2.getInt(1));
	                                claseData = Arrays.copyOf(claseData, claseData.length + 1);
	                                claseData[3] = numeroClientes;
	                            }
	                        }
	                    }	
	                    
	                    datosClases.add(claseData);
	                }
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return datosClases;
	}
	
	public boolean entrarClase(int idCliente, String clase) {
		int idClase = 0;
		boolean clienteRegistrado = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM `Clases` WHERE clase = '"+clase+"';");  
			if (rs.next()) {
	             idClase = Integer.valueOf(rs.getString(1));
			}
			
			Statement stmt2 = con.createStatement();  
		    ResultSet rs2 = stmt2.executeQuery("SELECT * FROM `Inscripciones` WHERE clase_id = '" + idClase + "' AND cliente_id = '" + idCliente + "';");  
		    if (rs2.next()) {
		         clienteRegistrado = true;
		         return true;
		    }else {
		    	clienteRegistrado = false;
		    }
			
			if(clienteRegistrado == false) {
				
				PreparedStatement stmt4=con.prepareStatement("insert into Inscripciones(clase_id, cliente_id) values(?,?)");  
				stmt4.setInt(1,idClase);
				stmt4.setInt(2,idCliente);
				
				int i=stmt4.executeUpdate();
				return false;
			}
			
			con.close();  
				
			} catch (ClassNotFoundException |SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return true;
	}
	
	public List<String[]> clientesClases(String clase) {
        List<String[]> data2 = new ArrayList<>();
        int idClase = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t")) {
                // Obtener el ID de la clase
                String claseQuery = "SELECT idClase FROM Clases WHERE clase = ?";
                try (PreparedStatement pstmtClase = con.prepareStatement(claseQuery)) {
                    pstmtClase.setString(1, clase);
                    try (ResultSet rsClase = pstmtClase.executeQuery()) {
                        if (rsClase.next()) {
                            idClase = rsClase.getInt("idClase");
                        }
                    }
                }

                // Obtener los IDs de los clientes inscritos en la clase
                List<Integer> idClientes = new ArrayList<>();
                String inscripcionesQuery = "SELECT cliente_id FROM Inscripciones WHERE clase_id = ?";
                try (PreparedStatement pstmtInscripciones = con.prepareStatement(inscripcionesQuery)) {
                    pstmtInscripciones.setInt(1, idClase);
                    try (ResultSet rsInscripciones = pstmtInscripciones.executeQuery()) {
                        while (rsInscripciones.next()) {
                            idClientes.add(rsInscripciones.getInt("cliente_id"));
                        }
                    }
                }

                // Obtener los datos de los clientes
                String clienteQuery = "SELECT idCliente, nombres, apellidos FROM Clientes WHERE idCliente = ?";
                try (PreparedStatement pstmtCliente = con.prepareStatement(clienteQuery)) {
                    for (int idCliente : idClientes) {
                        pstmtCliente.setInt(1, idCliente);
                        try (ResultSet rsCliente = pstmtCliente.executeQuery()) {
                            if (rsCliente.next()) {
                                String[] clienteData = new String[3];
                                clienteData[0] = rsCliente.getString("idCliente");
                                clienteData[1] = rsCliente.getString("nombres");
                                clienteData[2] = rsCliente.getString("apellidos");
                                data2.add(clienteData);
                            }
                        }
                    }
                }
            }
            return data2;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public void pdf(String clase) {
		List<String[]> clientes = clientesClases(clase);

        Document document = new Document(PageSize.A4.rotate());
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter pdfs = new FileNameExtensionFilter("Documentos PDF", "pdf");
        chooser.addChoosableFileFilter(pdfs);
        chooser.setFileFilter(pdfs);

        if (JFileChooser.CANCEL_OPTION == chooser.showDialog(null, "Generar PDF")) {
            JOptionPane.showMessageDialog(null, "No se genero el PDF.");
            return;
        }else {
        	 JOptionPane.showMessageDialog(null, "Se generó el PDF correctamente.");
        }
        try {
            PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile()));
            document.open();

            // Agrega contenido al documento
            document.add(new Paragraph("Tabla de clientes de la clase de: " + clase));

            // Crea la tabla
            PdfPTable table = new PdfPTable(new float[]{1, 1, 1});
            table.setWidthPercentage(100);

            PdfPCell nombresHeader = new PdfPCell(new Phrase("Nombre(s)"));
            nombresHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell apellidosHeader = new PdfPCell(new Phrase("Apellido(s)"));
            apellidosHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell idHeader = new PdfPCell(new Phrase("ID cliente"));
            idHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(nombresHeader);
            table.addCell(apellidosHeader);
            table.addCell(idHeader);

            // Agrega filas y columnas a la tabla utilizando los datos obtenidos de clientesClases
            for (String[] cliente : clientes) {
                table.addCell(cliente[1]); // Nombre
                table.addCell(cliente[2]); // Apellido
                table.addCell(cliente[0]); // ID cliente
            }

            // Agrega la tabla al documento
            document.add(table);

            // Cierra el documento
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
	}
	
	public String nombreEntrenador(String clase) {
		int idClase = 0;
		String nombre = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
				
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT * FROM `Clases` WHERE clase = '"+clase+"';");  
				if (rs.next()) {
		             idClase = Integer.valueOf(rs.getString(1));
				}
				
				Statement stmt3=con.createStatement();  
				ResultSet rs3=stmt3.executeQuery("SELECT * FROM `Clases` WHERE idClase = '"+idClase+"';");  
			            if(rs3.next()) {
			            	nombre = rs3.getString(3);
			            }
			    
			   
				con.close();  
				return nombre;
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return null;
	}
	
	public void eliminar(String clase) {
		int idClase = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
				
				Statement stmt = con.createStatement();
				ResultSet rs=stmt.executeQuery("SELECT * FROM `Clases` WHERE clase = '"+clase+"';");  
	            if (rs.next()) {
	            	idClase = Integer.valueOf(rs.getString(1));
	            }

	         
	            String deleteInscripciones = "DELETE FROM `Inscripciones` WHERE clase_id = ?";
	            PreparedStatement stmtDeleteInscripciones = con.prepareStatement(deleteInscripciones);
	            stmtDeleteInscripciones.setInt(1, idClase);
	            stmtDeleteInscripciones.executeUpdate();

	        
	            String deleteClase = "DELETE FROM `Clases` WHERE idClase = ?";
	            PreparedStatement stmtDeleteClase = con.prepareStatement(deleteClase);
	            stmtDeleteClase.setInt(1, idClase);
	            stmtDeleteClase.executeUpdate();

	            
			    con.close();  
						
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public boolean editarClase(String claseCambio , String nombreClase, String instructor) {
			boolean actualizado = false;
			
			try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

		        String updateQuery = "UPDATE Clases SET clase = ?, instructor = ? WHERE clase = ?";
		        PreparedStatement updateStmt = con.prepareStatement(updateQuery);
		        updateStmt.setString(1, nombreClase);
		        updateStmt.setString(2, instructor);
		        updateStmt.setString(3, claseCambio);

		        int filasActualizadas = updateStmt.executeUpdate();
		        if (filasActualizadas > 0) {
		            actualizado = true;
		        }
		        con.close();
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		    return actualizado;
		}
}
