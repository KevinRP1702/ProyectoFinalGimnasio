package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
	
	public boolean registrarCliente(String nombres, String apellidos, String fechaNacimiento, long telefono, String correo, String rutaImagen, int asistencias) {
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
                String insertarClienteQuery = "INSERT INTO Clientes (nombres, apellidos, fecha_nacimiento,telefono, correo, imagen, asistencias) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmtInsertar = con.prepareStatement(insertarClienteQuery)) {
                	
                	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsedDate = dateFormat.parse(fechaNacimiento);
                    java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
                    pstmtInsertar.setString(1, nombres);
                    pstmtInsertar.setString(2, apellidos);
                    pstmtInsertar.setDate(3, sqlDate);
                    pstmtInsertar.setLong(4, telefono);
                    pstmtInsertar.setString(5, correo);
                    pstmtInsertar.setString(6, rutaImagen);
                    pstmtInsertar.setInt(7, asistencias);

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

            String query = "SELECT idCliente, nombres, apellidos, fecha_nacimiento, correo, imagen, telefono FROM Clientes WHERE idCliente = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idCliente);
            
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                datosCliente.add(rs.getString("nombres"));
                datosCliente.add(rs.getString("apellidos"));
                datosCliente.add(rs.getString("fecha_nacimiento")); 
                datosCliente.add(rs.getString("correo"));
                datosCliente.add(rs.getString("idCliente"));
                datosCliente.add(rs.getString("imagen"));
                datosCliente.add(rs.getString("telefono"));
            } else {
                return null;
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return datosCliente;
    }
	
	public boolean editarCliente(int idCliente, String nuevosNombres, String nuevosApellidos, String nuevaFechaNacimiento, String nuevoCorreo, long nuevoTelefono,String nuevaImagen) {
        boolean actualizado = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://sql.freedb.tech:3306/freedb_data_base_gym", "freedb_data_base_master", "DdkJubsw3X%ZW2t");

            String query = "UPDATE Clientes SET nombres = ?, apellidos = ?, fecha_nacimiento = ?, correo = ?, telefono = ?, imagen = ? WHERE idCliente = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, nuevosNombres);
            pstmt.setString(2, nuevosApellidos);
            pstmt.setString(3, nuevaFechaNacimiento);
            pstmt.setString(4, nuevoCorreo);
            pstmt.setLong(5, nuevoTelefono);
            pstmt.setString(6, nuevaImagen);
            pstmt.setInt(7, idCliente);

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

	            String queryInscripciones = "DELETE FROM Inscripciones WHERE cliente_id = ?";
	            PreparedStatement pstmtInscripciones = con.prepareStatement(queryInscripciones);
	            pstmtInscripciones.setInt(1, idCliente);
	            pstmtInscripciones.executeUpdate();
	            
	            String queryPago = "DELETE FROM Pagos WHERE idCliente = ?";
	            PreparedStatement pstmtPago = con.prepareStatement(queryPago);
	            pstmtPago.setInt(1, idCliente);
	            pstmtPago.executeUpdate();
	            
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
	 
	 public void pdf(int idCliente) {
	        ArrayList<String> datosCliente = datosClientes(idCliente);

	        if (datosCliente == null) {
	            JOptionPane.showMessageDialog(null, "No se encontraron datos para el cliente con ID: " + idCliente);
	            return;
	        }

	        Document document = new Document(PageSize.A4);
	        JFileChooser chooser = new JFileChooser();
	        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        chooser.setAcceptAllFileFilterUsed(false);
	        FileNameExtensionFilter pdfs = new FileNameExtensionFilter("Documentos PDF", "pdf");
	        chooser.addChoosableFileFilter(pdfs);
	        chooser.setFileFilter(pdfs);

	        if (JFileChooser.CANCEL_OPTION == chooser.showDialog(null, "Generar PDF")) {
	            JOptionPane.showMessageDialog(null, "No se generó el PDF.");
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
	            Paragraph title = new Paragraph("Información del cliente", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
	            title.setAlignment(Element.ALIGN_CENTER);
	            title.setSpacingAfter(20);
	            document.add(title);

	            // Tabla principal para organizar la información
	            PdfPTable mainTable = new PdfPTable(2);
	            mainTable.setWidthPercentage(100);
	            mainTable.setWidths(new int[]{2, 1}); // Proporción de ancho de columnas

	            // Tabla para datos del cliente
	            PdfPTable dataTable = new PdfPTable(2);
	            dataTable.setWidthPercentage(100);
	            dataTable.setWidths(new int[]{1, 2}); // Proporción de ancho de columnas

	            // Añadir datos del cliente a la tabla
	            dataTable.addCell(createCell("Nombre(s):", PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
	            dataTable.addCell(createCell(datosCliente.get(0), PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA, 12)));
	            dataTable.addCell(createCell("Apellido(s):", PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
	            dataTable.addCell(createCell(datosCliente.get(1), PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA, 12)));
	            dataTable.addCell(createCell("Fecha de nacimiento:", PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
	            dataTable.addCell(createCell(datosCliente.get(2), PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA, 12)));
	            dataTable.addCell(createCell("Número de teléfono:", PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
	            dataTable.addCell(createCell(datosCliente.get(6), PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA, 12)));
	            dataTable.addCell(createCell("Correo electrónico:", PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
	            dataTable.addCell(createCell(datosCliente.get(3), PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA, 12)));
	            dataTable.addCell(createCell("Cliente id:", PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
	            dataTable.addCell(createCell(datosCliente.get(4), PdfPCell.ALIGN_LEFT, FontFactory.getFont(FontFactory.HELVETICA, 12)));

	            mainTable.addCell(dataTable);

	            PdfPCell imageCell = new PdfPCell();
	            imageCell.setBorder(PdfPCell.NO_BORDER);
	            try {
	                ImageIcon originalIcon = new ImageIcon(getClass().getResource(datosCliente.get(5)));

	                java.awt.Image originalImage = originalIcon.getImage();
	                java.awt.Image scaledImage = originalImage.getScaledInstance(150, 150, 0);
	                ImageIcon scaledIcon = new ImageIcon(scaledImage);

	                Image image = Image.getInstance(scaledIcon.getImage(), null);
	                
	                image.scaleToFit(150, 150); 

	                image.setAlignment(Element.ALIGN_CENTER);

	                imageCell.addElement(image);
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al cargar la imagen.");
	            }

	            mainTable.addCell(imageCell);

	            document.add(mainTable);

	            // Cierra el documento
	            document.close();
	            JOptionPane.showMessageDialog(null, "PDF generado exitosamente.");

	        } catch (FileNotFoundException | DocumentException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al generar el PDF.");
	        }
	    }

	 private PdfPCell createCell(String content, int alignment, Font font) {
	        PdfPCell cell = new PdfPCell(new Phrase(content, font));
	        cell.setHorizontalAlignment(alignment);
	        cell.setBorder(PdfPCell.NO_BORDER);
	        return cell;
	    }
	 
	 public void pdfTablaPrincipal() {
		 ArrayList<String[]> datosClientes = obtenerDatosClientes();

		    Document document = new Document(PageSize.A4);
		    JFileChooser chooser = new JFileChooser();
		    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		    chooser.setAcceptAllFileFilterUsed(false);
		    FileNameExtensionFilter pdfs = new FileNameExtensionFilter("Documentos PDF", "pdf");
		    chooser.addChoosableFileFilter(pdfs);
		    chooser.setFileFilter(pdfs);

		    if (JFileChooser.CANCEL_OPTION == chooser.showDialog(null, "Generar PDF")) {
		        JOptionPane.showMessageDialog(null, "No se generó el PDF.");
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
		        Paragraph title = new Paragraph("Desglose de los clientes", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
		        title.setAlignment(Element.ALIGN_CENTER);
		        document.add(title);
		        document.add(Chunk.NEWLINE); // Espacio en blanco para separar

		        // Crear la tabla
		        PdfPTable table = new PdfPTable(4); // 4 columnas
		        table.setWidthPercentage(100);
		        table.setSpacingBefore(10f);
		        table.setSpacingAfter(10f);

		        // Encabezados de la tabla
		        PdfPCell cell;

		        cell = new PdfPCell(new Phrase("Cliente ID", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		        table.addCell(cell);

		        cell = new PdfPCell(new Phrase("Nombre(s)", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		        table.addCell(cell);

		        cell = new PdfPCell(new Phrase("Apellidos", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		        table.addCell(cell);

		        cell = new PdfPCell(new Phrase("Correo", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
		        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		        table.addCell(cell);

		        // Datos de los clientes
		        for (String[] cliente : datosClientes) {
		            for (String data : cliente) {
		                cell = new PdfPCell(new Phrase(data, FontFactory.getFont(FontFactory.HELVETICA, 12)));
		                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(cell);
		            }
		        }

		        document.add(table);

		        // Cierra el documento
		        document.close();
		        JOptionPane.showMessageDialog(null, "PDF generado exitosamente.");
		    } catch (Exception e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Error al generar el PDF.");
		    }
	 }
}
