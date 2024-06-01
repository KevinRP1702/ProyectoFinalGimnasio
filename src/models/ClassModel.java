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
	
	public List<List<Object>> get() {
	        List<List<Object>> datos = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
				Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
				Statement stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery("SELECT * FROM `Clases`");

		            while (rs.next()) {
		            	String nombreClase = rs.getString("clase");
		                String instructor = rs.getString("instructor");
		                List<Object> claseData = new ArrayList<>();
		                claseData.add(nombreClase);
		                claseData.add(instructor);

		                // Obtener el conteo de inscritos para la clase actual
		                Statement stmt2 = con.createStatement();
		                ResultSet rs2 = stmt2.executeQuery("SELECT COUNT(*) FROM Inscripciones WHERE clase_id = " + rs.getString("idClase"));

		                int numeroClientes = 0;
		                if (rs2.next()) {
		                    numeroClientes = rs2.getInt(1);
		                }

		                claseData.add(numeroClientes);
		                datos.add(claseData);
		            	}
		            
				con.close();  
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return datos;
		
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
	
	public List<List> clientesClases(String clase) {
		List<List> data = new ArrayList();
		List<List> data2 = new ArrayList();
		int idClase = 0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				Connection con=DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
				
				Statement stmt=con.createStatement();  
				ResultSet rs=stmt.executeQuery("SELECT * FROM `Clases` WHERE clase = '"+clase+"';");  
				if (rs.next()) {
		             idClase = Integer.valueOf(rs.getString(1));
				}
				
				Statement stmt3=con.createStatement();  
				ResultSet rs3=stmt3.executeQuery("SELECT * FROM `Inscripciones` WHERE clase_id = '"+idClase+"';");  
			            while(rs3.next()) {
				    	String [] idClientes = {rs3.getString(3)};	
				    	List<String> info = Arrays.asList(idClientes);
				    	
				    	data.add(info);
			            }
			    
			    for(int i = 0; i < data.size(); i++) {
					Statement stm2 = con.createStatement(); 
				    ResultSet rs2 = stm2.executeQuery("SELECT * FROM `Clientes` WHERE idCliente = '"+data.get(i).get(0)+"';");

				    while(rs2.next()) {
				    	String [] clientes = {rs2.getString(2), rs2.getString(3), rs2.getString(1)};	
				    	List<String> info = Arrays.asList(clientes);
				    	
				    	data2.add(info);
				    }
			    }
				con.close();  
				return data2;
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		return null;
	}
	
	public void pdf(String clase) {
		List<List> clientes = clientesClases(clase); // Almacena los datos obtenidos del método clientesClases
	    
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
		}
	    try {
	        PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile()));
	        document.open();

	        // Agrega contenido al documento
	        document.add(new Paragraph("Tabla de clientes de la clase de: " + clase));

	        // Crea la tabla
	        PdfPTable table = new PdfPTable(new float[] { 1, 1, 1 });
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
	        for (List<String> cliente : clientes) {
	            table.addCell(cliente.get(0)); // Nombre
	            table.addCell(cliente.get(1)); // Apellido
	            table.addCell(cliente.get(2)); // Correo
	        }

	        // Agrega la tabla al documento
	        document.add(table);

	        // Cierra el documento
	        document.close();
	        
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
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
}
