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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.BaseColor;
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

	            Object[] datosInstructor = new Object[]{nombreInstructor, experiencia, formacion, horario, id};

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
	
	public boolean agregarInstructor(String nombreCompleto, String experiencia, String formacion, String horario) {
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
	            PreparedStatement stmtInsert = con.prepareStatement("INSERT INTO Instructores(nombre, experiencia, formacion, horario) VALUES (?, ?, ?, ?)");
	            stmtInsert.setString(1, nombreCompleto);
	            stmtInsert.setString(2, experiencia);
	            stmtInsert.setString(3, formacion);
	            stmtInsert.setString(4, horario);
	            
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
	    Object[] datosEntrenador = new Object[4]; 

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");
	        PreparedStatement stmt = con.prepareStatement("SELECT nombre, experiencia, formacion, horario FROM Instructores WHERE id_instructor = ?");
	        stmt.setInt(1, idEntrenador);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String experiencia = rs.getString("experiencia");
	            String formacion = rs.getString("formacion");
	            String horario = rs.getString("horario");
	            
	            datosEntrenador[0] = nombre;
	            datosEntrenador[1] = experiencia;
	            datosEntrenador[2] = formacion;
	            datosEntrenador[3] = horario;
	           
	        } else {
	            datosEntrenador = null; 
	        }

	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	    return datosEntrenador;
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
	    
	    try {
	        PdfWriter.getInstance(document, new FileOutputStream(chooser.getSelectedFile()));
	        document.open();

	        // Agrega contenido al documento
	        document.add(new Paragraph("Credencial de Entrenador"));
	        document.add(new Paragraph(" ")); // Espacio en blanco para separar

//	         Agrega la imagen (asegurándose de que la ruta de la imagen es correcta)
//	        Image image = Image.getInstance("/mnt/data/image.png");
//	        image.scaleToFit(200, 200); // Ajusta el tamaño de la imagen
//	        image.setAlignment(Element.ALIGN_CENTER);
//	        document.add(image);

	        // Agrega los datos del entrenador
	        document.add(new Paragraph("ID del entranador: " + idEntrenador, FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
	        document.add(new Paragraph("Nombre completo: " + datosEntrenador[0], FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
	        document.add(new Paragraph("Experiencia: " + datosEntrenador[1], FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
	        document.add(new Paragraph("Formación: " + datosEntrenador[2], FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
	        document.add(new Paragraph("Horario: " + datosEntrenador[3], FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
	        
	        // Cierra el documento
	        document.close();
	        
	    } catch (FileNotFoundException | DocumentException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
