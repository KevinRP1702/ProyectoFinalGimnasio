package models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class InstructorModel {
	
	 public Object[][] get() {
		 	Object[][] datos = new Object[4][]; 
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM `Instructores`");

	        int index = 0;
	        
	        while (rs.next() && index < 4) {
	            String nombreInstructor = rs.getString("nombre");
	            String experiencia = rs.getString("experiencia");
	            String formacion = rs.getString("formacion");
	            String horario = rs.getString("horario");
	            String id = rs.getString("id_instructor");
	            String imagen = rs.getString("imagen");

	            Object[] datosInstructor = new Object[]{nombreInstructor, experiencia, formacion, horario, id, imagen};

	            datos[index] = datosInstructor;
                
                index++; 
	        }

	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }  

	    return datos;
	}
	 
	public void eliminarInstructor(int idInstructor) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
	    
	        // Eliminar al instructor
	        String deleteInstructor = "DELETE FROM `Instructores` WHERE id_instructor = ?";
	        PreparedStatement stmtDeleteInstructor = con.prepareStatement(deleteInstructor);
	        stmtDeleteInstructor.setInt(1, idInstructor);
	        stmtDeleteInstructor.executeUpdate();
	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }  
	}
	
	public boolean agregarInstructor(String nombreCompleto, String experiencia, String formacion, String horario, String rutaImagen) {
		boolean instructorCreado = false;
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym","freedb_data_base_master","DdkJubsw3X%ZW2t");
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM `Instructores` WHERE nombre = '" + nombreCompleto + "'");
	        if (rs.next()) {
	            instructorCreado = true;
	            return true;
	        }
	        
	        if (!instructorCreado) {
	            PreparedStatement stmtInsert = con.prepareStatement("INSERT INTO Instructores(nombre, experiencia, formacion, horario, imagen) VALUES (?, ?, ?, ?, ?)");
	            stmtInsert.setString(1, nombreCompleto);
	            stmtInsert.setString(2, experiencia);
	            stmtInsert.setString(3, formacion);
	            stmtInsert.setString(4, horario);
	            stmtInsert.setString(5, rutaImagen);
	            int i = stmtInsert.executeUpdate();
	            
	            return false;
	        }
	        
	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return true;
	}
	
	public Object[] getEntrenador(int idEntrenador) {
	    Object[] datosEntrenador = new Object[5]; 

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");
	        PreparedStatement stmt = con.prepareStatement("SELECT nombre, experiencia, formacion, horario, imagen FROM Instructores WHERE id_instructor = ?");
	        stmt.setInt(1, idEntrenador);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String experiencia = rs.getString("experiencia");
	            String formacion = rs.getString("formacion");
	            String horario = rs.getString("horario");
	            String imagen = rs.getString("imagen");
	            
	            datosEntrenador[0] = nombre;
	            datosEntrenador[1] = experiencia;
	            datosEntrenador[2] = formacion;
	            datosEntrenador[3] = horario;
	            datosEntrenador[4] = imagen;
	           
	        } else {
	            datosEntrenador = null; 
	        }

	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return datosEntrenador;
	}
	
	public boolean editarInstructor(int idInstructor, String nombre, String experiencia, String formacion, String horario) {
		 boolean edicion = false;
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

		        String query = "UPDATE Instructores SET nombre = ?, experiencia = ?, formacion = ?, horario = ? WHERE id_instructor = ?";
		        PreparedStatement stmt = con.prepareStatement(query);
		        stmt.setString(1, nombre);
		        stmt.setString(2, experiencia);
		        stmt.setString(3, formacion);
		        stmt.setString(4, horario);
		        stmt.setInt(5, idInstructor);

		        int filasActualizadas = stmt.executeUpdate();
		        if (filasActualizadas > 0) {
		           edicion = true;
		        } else {
		          edicion = false;
		        }

		        // Cerrar recursos
		        stmt.close();
		        con.close();
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		 
		 return edicion;
	}
	
	public void agregarImagen(String rutaImagen, int idInstructor) {
		boolean edicion = false;
		 try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

		        String query = "UPDATE Instructores SET imagen = ?  WHERE id_instructor = ?";
		        PreparedStatement stmt = con.prepareStatement(query);
		        stmt.setString(1, rutaImagen);
		        stmt.setInt(2, idInstructor);

		        int filasActualizadas = stmt.executeUpdate();
		        if (filasActualizadas > 0) {
		           edicion = true;
		        } else {
		          edicion = false;
		        }

		        // Cerrar recursos
		        stmt.close();
		        con.close();
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		 
	}
	
	public void pdf(int idEntrenador) {
	    Object[] datosEntrenador = getEntrenador(idEntrenador);
	    Document document = new Document(PageSize.A4);
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

	    File selectedFile = chooser.getSelectedFile();
	    if (!selectedFile.getName().toLowerCase().endsWith(".pdf")) {
	        selectedFile = new File(selectedFile.getAbsolutePath() + ".pdf");
	    }

	    try {
	        PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
	        document.open();

	        // Título del documento
	        Paragraph title = new Paragraph("Credencial de Entrenador", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
	        title.setAlignment(Element.ALIGN_CENTER);
	        document.add(title);
	        document.add(Chunk.NEWLINE); // Espacio en blanco para separar

	        // Tabla para organizar los elementos
	        PdfPTable table = new PdfPTable(1);
	        table.setWidthPercentage(50);
	        table.setHorizontalAlignment(Element.ALIGN_CENTER);

	        // Crear celda con borde para simular la credencial
	        PdfPCell credentialCell = new PdfPCell();
	        credentialCell.setBorder(PdfPCell.BOX);
	        credentialCell.setBorderWidth(2); // Ancho del borde
	        credentialCell.setPadding(10); // Espacio interior de la celda

	        // Imagen del entrenador
	        try {
	        	ImageIcon originalIcon = new ImageIcon(getClass().getResource(datosEntrenador[4].toString()));
	        	
	        	java.awt.Image originalImage = originalIcon.getImage();
                java.awt.Image scaledImage = originalImage.getScaledInstance(100, 100, 0);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                
                Image image = Image.getInstance(scaledIcon.getImage(), null);
                
                image.scaleToFit(100, 100); 
                image.setAlignment(Element.ALIGN_CENTER);

                credentialCell.addElement(image);
	        } catch (BadElementException | IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al cargar la imagen.");
	        }

	        // Añadir datos del entrenador a la celda
	        credentialCell.addElement(createParagraph("ID del entrenador: " + idEntrenador));
	        credentialCell.addElement(createParagraph("Nombre completo: " + datosEntrenador[0]));
	        credentialCell.addElement(createParagraph("Experiencia: " + datosEntrenador[1]));
	        credentialCell.addElement(createParagraph("Formación: " + datosEntrenador[2]));
	        credentialCell.addElement(createParagraph("Horario: " + datosEntrenador[3]));

	        // Añadir celda completa a la tabla
	        table.addCell(credentialCell);

	        document.add(table);

	        // Cierra el documento
	        document.close();
	        JOptionPane.showMessageDialog(null, "PDF generado exitosamente.");
	        
	    } catch (FileNotFoundException | DocumentException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al generar el PDF.");
	    }
	}

	private Paragraph createParagraph(String text) {
	    Paragraph paragraph = new Paragraph(text, FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK));
	    paragraph.setAlignment(Element.ALIGN_CENTER);
	    return paragraph;
	}
}
