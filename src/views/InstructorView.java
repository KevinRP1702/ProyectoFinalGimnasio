package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.DocumentFilter.FilterBypass;

import controllers.Auth;
import controllers.CheckController;
import controllers.ClassController;
import controllers.ClientController;
import controllers.FeeController;
import controllers.HomeController;
import controllers.InstructorController;
import models.InstructorModel;

import javax.swing.*;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructorView {

	private JFrame frame;
	private JPanel panel;
	JLabel lbl_Instructor_1 = new JLabel();
	JLabel lbl_Instructor_2 = new JLabel();
	JLabel lbl_Instructor_3 = new JLabel();
	JLabel lbl_Instructor_4 = new JLabel();
	JTextPane txt_Experiencia_1 = new JTextPane();
	JTextPane txt_Experiencia_2 = new JTextPane();
	JTextPane txt_Experiencia_3 = new JTextPane();
	JTextPane txt_Experiencia_4 = new JTextPane();
	JTextPane txt_Formacion_1 = new JTextPane();
	JTextPane txt_Formacion_2 = new JTextPane();
	JTextPane txt_Formacion_3 = new JTextPane();
	JTextPane txt_Formacion_4 = new JTextPane();
	JTextPane txt_Horario_1 = new JTextPane();
	JTextPane txt_Horario_2 = new JTextPane();
	JTextPane txt_Horario_3 = new JTextPane();
	JTextPane txt_Horario_4 = new JTextPane();
	JLabel lblImg_Instructor_1 = new JLabel("");
	JLabel lblImg_Instructor_2 = new JLabel("");
	JLabel lblImg_Instructor_3 = new JLabel("");
	JLabel lblImg_Instructor_4 = new JLabel("");

	public InstructorView(){
		frame = new JFrame();
		frame.setBounds(100, 100, 1108, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	//Primera vista de instructor
	public void instructor(Object[][] instructores) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);



		//Contenido
		InstructorModel instructorModel = new InstructorModel();


		// Obtener los datos de los instructores
		Object[][] instructoresa = new Object[4][];
		Object[][] datosInstructores = instructorModel.get();

		// Llenar los primeros 4 espacios del arreglo con los datos de los instructores obtenidos
		for (int i = 0; i < datosInstructores.length && i < 4; i++) {
			instructores[i] = datosInstructores[i];
		}

		JPanel panelcontenedor =new JPanel();
		panelcontenedor.setBackground(Color.decode("#FFFFFF"));
		panelcontenedor.setBounds(200, 76, 882, 573);
		panel.add(panelcontenedor);
		panelcontenedor.setLayout(null);

		JPanel panelCabeceraContenido = new JPanel();
		panelCabeceraContenido.setBounds(0, 0, 882, 40);
		panelCabeceraContenido.setLayout(null);
		panelCabeceraContenido.setBackground(new Color(188, 218, 242));
		panelcontenedor.add(panelCabeceraContenido);

		JLabel lblTituloContenido = new JLabel("Instructores activos");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 360, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		JPanel panel_Instructor_1 = new JPanel();
		panel_Instructor_1.setBounds(15, 55, 200, 415);
		panel_Instructor_1.setBackground(new Color(255, 255, 255));
		panelcontenedor.add(panel_Instructor_1);
		panel_Instructor_1.setBorder(new LineBorder(Color.decode("#F0F0F0"), 2));
		panel_Instructor_1.setLayout(null);


		lblImg_Instructor_1.setOpaque(true);
		lblImg_Instructor_1.setBackground(new Color(0, 255, 255));
		lblImg_Instructor_1.setBounds(50, 15, 100, 100);
		ImageIcon imageIcon_lblImg_Instructor_1 = new ImageIcon("img/mujerpfp.png");
		lblImg_Instructor_1.setIcon(imageIcon_lblImg_Instructor_1);
		panel_Instructor_1.add(lblImg_Instructor_1);

		if (instructores[0] != null) {
			// Obtener el primer dato del primer arreglo
			Object primerDato = instructores[0][0]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			lbl_Instructor_1.setText(primerDato.toString());
		}else {
			lbl_Instructor_1.setText("");
		}
		lbl_Instructor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Instructor_1.setFont(new Font("Calibri", Font.BOLD, 16));
		lbl_Instructor_1.setBounds(10, 140, 180, 28);
		panel_Instructor_1.add(lbl_Instructor_1);

		if (instructores[0] != null) {
			// Obtener el primer dato del primer arreglo
			Object segundoDato = instructores[0][1]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Experiencia_1.setText(segundoDato.toString());
		}else {
			txt_Experiencia_1.setText("");
		}
		txt_Experiencia_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Experiencia_1.setBackground(Color.WHITE);
		txt_Experiencia_1.setBounds(10, 180, 180, 64);
		txt_Experiencia_1.setBorder(new LineBorder(Color.WHITE));
		txt_Experiencia_1.setEditable(false);

		StyledDocument doc_1 = txt_Experiencia_1.getStyledDocument();
		SimpleAttributeSet center_1 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_1, StyleConstants.ALIGN_CENTER);
		doc_1.setParagraphAttributes(0, doc_1.getLength(), center_1, false);

		panel_Instructor_1.add(txt_Experiencia_1);

		if (instructores[0] != null) {
			// Obtener el primer dato del primer arreglo
			Object tercerDato = instructores[0][2]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Formacion_1.setText(tercerDato.toString());
		}else {
			txt_Formacion_1.setText("");
		}
		txt_Formacion_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Formacion_1.setEditable(false);
		txt_Formacion_1.setBorder(new LineBorder(Color.WHITE));
		txt_Formacion_1.setBackground(Color.WHITE);
		txt_Formacion_1.setBounds(10, 255, 180, 64);

		StyledDocument doc_2 = txt_Formacion_1.getStyledDocument();
		SimpleAttributeSet center_2 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_2, StyleConstants.ALIGN_CENTER);
		doc_2.setParagraphAttributes(0, doc_2.getLength(), center_2, false);

		panel_Instructor_1.add(txt_Formacion_1);

		if (instructores[0] != null) {
			// Obtener el primer dato del primer arreglo
			Object cuartoDato = instructores[0][3]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Horario_1.setText(cuartoDato.toString());
		}else {
			txt_Horario_1.setText("");
		}
		txt_Horario_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Horario_1.setEditable(false);
		txt_Horario_1.setBorder(new LineBorder(Color.WHITE));
		txt_Horario_1.setBackground(Color.WHITE);
		txt_Horario_1.setBounds(10, 330, 180, 64);

		StyledDocument doc_3 = txt_Horario_1.getStyledDocument();
		SimpleAttributeSet center_3 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_3, StyleConstants.ALIGN_CENTER);
		doc_3.setParagraphAttributes(0, doc_3.getLength(), center_3, false);

		panel_Instructor_1.add(txt_Horario_1);

		//Segundo instructor
		JPanel panel_Instructor_2 = new JPanel();
		panel_Instructor_2.setBounds(232, 55, 200, 415);
		panel_Instructor_2.setBackground(new Color(255, 255, 255));
		panelcontenedor.add(panel_Instructor_2);
		panel_Instructor_2.setBorder(new LineBorder(Color.decode("#F0F0F0"), 2));
		panel_Instructor_2.setLayout(null);


		lblImg_Instructor_2.setOpaque(true);
		lblImg_Instructor_2.setBackground(Color.CYAN);
		lblImg_Instructor_2.setBounds(50, 15, 100, 100);
		ImageIcon imageIcon_Instructor_2 = new ImageIcon("img/hombrepfp.png");
		lblImg_Instructor_2.setIcon(imageIcon_Instructor_2);
		panel_Instructor_2.add(lblImg_Instructor_2);

		if (instructores[1] != null) {
			// Obtener el primer dato del primer arreglo
			Object primerDato = instructores[1][0]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			lbl_Instructor_2.setText(primerDato.toString());
		}else {
			lbl_Instructor_2.setText("");
		}
		lbl_Instructor_2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Instructor_2.setFont(new Font("Calibri", Font.BOLD, 16));
		lbl_Instructor_2.setBounds(10, 136, 180, 28);
		panel_Instructor_2.add(lbl_Instructor_2);

		if (instructores[1] != null) {
			// Obtener el primer dato del primer arreglo
			Object segundoDato = instructores[1][1]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Experiencia_2.setText(segundoDato.toString());
		}else {
			txt_Experiencia_2.setText("");
		}
		txt_Experiencia_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Experiencia_2.setEditable(false);
		txt_Experiencia_2.setBorder(new LineBorder(Color.WHITE));
		txt_Experiencia_2.setBackground(Color.WHITE);
		txt_Experiencia_2.setBounds(10, 175, 180, 64);
		panel_Instructor_2.add(txt_Experiencia_2);

		StyledDocument doc_4 = txt_Experiencia_2.getStyledDocument();
		SimpleAttributeSet center_4 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_4, StyleConstants.ALIGN_CENTER);
		doc_4.setParagraphAttributes(0, doc_4.getLength(), center_4, false);

		if (instructores[1] != null) {
			// Obtener el primer dato del primer arreglo
			Object tercerDato = instructores[1][2]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Formacion_2.setText(tercerDato.toString());
		}else {
			txt_Formacion_2.setText("");
		}
		txt_Formacion_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Formacion_2.setEditable(false);
		txt_Formacion_2.setBorder(new LineBorder(Color.WHITE));
		txt_Formacion_2.setBackground(Color.WHITE);
		txt_Formacion_2.setBounds(10, 250, 180, 64);
		panel_Instructor_2.add(txt_Formacion_2);

		StyledDocument doc_5 = txt_Formacion_2.getStyledDocument();
		SimpleAttributeSet center_5 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_5, StyleConstants.ALIGN_CENTER);
		doc_5.setParagraphAttributes(0, doc_5.getLength(), center_5, false);

		if (instructores[1] != null) {
			// Obtener el primer dato del primer arreglo
			Object cuartoDato = instructores[1][3]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Horario_2.setText(cuartoDato.toString());
		}else {
			txt_Horario_2.setText("");
		}
		txt_Horario_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Horario_2.setEditable(false);
		txt_Horario_2.setBorder(new LineBorder(Color.WHITE));
		txt_Horario_2.setBackground(Color.WHITE);
		txt_Horario_2.setBounds(10, 329, 180, 64);
		panel_Instructor_2.add(txt_Horario_2);

		StyledDocument doc_6 = txt_Horario_2.getStyledDocument();
		SimpleAttributeSet center_6 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_6, StyleConstants.ALIGN_CENTER);
		doc_6.setParagraphAttributes(0, doc_6.getLength(), center_6, false);

		//Tercer instructor
		JPanel panel_Instructor_3 = new JPanel();
		panel_Instructor_3.setBounds(449, 55, 200, 415);
		panel_Instructor_3.setBackground(new Color(255, 255, 255));
		panelcontenedor.add(panel_Instructor_3);
		panel_Instructor_3.setBorder(new LineBorder(Color.decode("#F0F0F0"), 2));
		panel_Instructor_3.setLayout(null);

		lblImg_Instructor_3.setOpaque(true);
		lblImg_Instructor_3.setBackground(Color.CYAN);
		lblImg_Instructor_3.setBounds(50, 15, 100, 100);
		ImageIcon imageIcon_lblImg_Instructor_3 = new ImageIcon("img/hombrepfp.png");
		lblImg_Instructor_3.setIcon(imageIcon_lblImg_Instructor_3);
		panel_Instructor_3.add(lblImg_Instructor_3);


		if (instructores[2] != null) {
			// Obtener el primer dato del primer arreglo
			Object primerDato = instructores[2][0]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			lbl_Instructor_3.setText(primerDato.toString());
		}else {
			lbl_Instructor_3.setText("");
		}
		lbl_Instructor_3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Instructor_3.setFont(new Font("Calibri", Font.BOLD, 16));
		lbl_Instructor_3.setBounds(10, 126, 180, 28);
		panel_Instructor_3.add(lbl_Instructor_3);



		if (instructores[2] != null) {
			// Obtener el primer dato del primer arreglo
			Object cuartoDato = instructores[2][3]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Horario_3.setText(cuartoDato.toString());
		}else {
			txt_Horario_3.setText("");
		}
		txt_Horario_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Horario_3.setEditable(false);
		txt_Horario_3.setBorder(new LineBorder(Color.WHITE));
		txt_Horario_3.setBackground(Color.WHITE);
		txt_Horario_3.setBounds(10, 328, 180, 64);
		panel_Instructor_3.add(txt_Horario_3);

		StyledDocument doc_7 = txt_Horario_3.getStyledDocument();
		SimpleAttributeSet center_7 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_7, StyleConstants.ALIGN_CENTER);
		doc_7.setParagraphAttributes(0, doc_7.getLength(), center_7, false);


		if (instructores[2] != null) {
			// Obtener el primer dato del primer arreglo
			Object tercerDato = instructores[2][2]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Formacion_3.setText(tercerDato.toString());
		}else {
			txt_Formacion_3.setText("");
		}
		txt_Formacion_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Formacion_3.setEditable(false);
		txt_Formacion_3.setBorder(new LineBorder(Color.WHITE));
		txt_Formacion_3.setBackground(Color.WHITE);
		txt_Formacion_3.setBounds(10, 253, 180, 64);
		panel_Instructor_3.add(txt_Formacion_3);

		StyledDocument doc_9 = txt_Formacion_3.getStyledDocument();
		SimpleAttributeSet center_9 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_9, StyleConstants.ALIGN_CENTER);
		doc_9.setParagraphAttributes(0, doc_9.getLength(), center_9, false);

		if (instructores[2] != null) {
			// Obtener el primer dato del primer arreglo
			Object segundoDato = instructores[2][1]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Experiencia_3.setText(segundoDato.toString());
		}else {
			txt_Experiencia_3.setText("");
		}
		txt_Experiencia_3.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Experiencia_3.setEditable(false);
		txt_Experiencia_3.setBorder(new LineBorder(Color.WHITE));
		txt_Experiencia_3.setBackground(Color.WHITE);
		txt_Experiencia_3.setBounds(10, 176, 180, 64);
		panel_Instructor_3.add(txt_Experiencia_3);

		StyledDocument doc_8 = txt_Experiencia_3.getStyledDocument();
		SimpleAttributeSet center_8 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_8, StyleConstants.ALIGN_CENTER);
		doc_8.setParagraphAttributes(0, doc_8.getLength(), center_8, false);

		//Cuarto instructor

		JPanel panel_Instructor_4 = new JPanel();
		panel_Instructor_4.setBounds(667, 55, 200, 415);
		panel_Instructor_4.setBackground(new Color(255, 255, 255));
		panelcontenedor.add(panel_Instructor_4);
		panel_Instructor_4.setBorder(new LineBorder(Color.decode("#F0F0F0"), 2));
		panel_Instructor_4.setLayout(null);


		lblImg_Instructor_4.setOpaque(true);
		lblImg_Instructor_4.setBackground(Color.CYAN);
		lblImg_Instructor_4.setBounds(49, 15, 100, 100);
		ImageIcon imageIcon_Instructor_4 = new ImageIcon("img/mujerpfp.png");
		lblImg_Instructor_4.setIcon(imageIcon_Instructor_4);
		panel_Instructor_4.add(lblImg_Instructor_4);

		if (instructores[3] != null) {
			// Obtener el primer dato del primer arreglo
			Object primerDato = instructores[3][0]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			lbl_Instructor_4.setText(primerDato.toString());
		}else {
			lbl_Instructor_4.setText("");
		}
		lbl_Instructor_4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Instructor_4.setFont(new Font("Calibri", Font.BOLD, 16));
		lbl_Instructor_4.setBounds(10, 126, 180, 28);
		panel_Instructor_4.add(lbl_Instructor_4);

		if (instructores[3] != null) {
			// Obtener el primer dato del primer arreglo
			Object cuartoDato = instructores[3][3]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Horario_4.setText(cuartoDato.toString());
		}else {
			txt_Horario_4.setText("");
		}
		txt_Horario_4.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Horario_4.setEditable(false);
		txt_Horario_4.setBorder(new LineBorder(Color.WHITE));
		txt_Horario_4.setBackground(Color.WHITE);
		txt_Horario_4.setBounds(10, 326, 180, 64);
		panel_Instructor_4.add(txt_Horario_4);

		StyledDocument doc_12 = txt_Horario_4.getStyledDocument();
		SimpleAttributeSet center_12 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_12, StyleConstants.ALIGN_CENTER);
		doc_12.setParagraphAttributes(0, doc_12.getLength(), center_12, false);

		if (instructores[3] != null) {
			// Obtener el primer dato del primer arreglo
			Object tercerDato = instructores[3][2]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Formacion_4.setText(tercerDato.toString());
		}else {
			txt_Formacion_4.setText("");
		}
		txt_Formacion_4.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Formacion_4.setEditable(false);
		txt_Formacion_4.setBorder(new LineBorder(Color.WHITE));
		txt_Formacion_4.setBackground(Color.WHITE);
		txt_Formacion_4.setBounds(10, 251, 180, 64);
		panel_Instructor_4.add(txt_Formacion_4);

		StyledDocument doc_11 = txt_Formacion_4.getStyledDocument();
		SimpleAttributeSet center_11 = new SimpleAttributeSet();
		StyleConstants.setAlignment(center_11, StyleConstants.ALIGN_CENTER);
		doc_11.setParagraphAttributes(0, doc_11.getLength(), center_11, false);



		if (instructores[3] != null) {
			// Obtener el primer dato del primer arreglo
			Object segundoDato = instructores[3][1]; // Suponiendo que el primer dato es el nombre del instructor

			// Asignar el primer dato al componente lbl_instructor1
			txt_Experiencia_4.setText(segundoDato.toString());
		}else {
			txt_Experiencia_4.setText("");
		}
		txt_Experiencia_4.setFont(new Font("Calibri", Font.PLAIN, 15));
		txt_Experiencia_4.setEditable(false);
		txt_Experiencia_4.setBorder(new LineBorder(Color.WHITE));
		txt_Experiencia_4.setBackground(Color.WHITE);
		txt_Experiencia_4.setBounds(10, 176, 180, 64);
		panel_Instructor_4.add(txt_Experiencia_4);



		//Botones

		if (lbl_Instructor_1.getText().equals("")) {
			JPanel panelBtnAñadirinstructor1 = new JPanel();
			panelBtnAñadirinstructor1.setBounds(15, 480, 200, 20);
			panelBtnAñadirinstructor1.setBackground(Color.decode("#3768A7"));
			panelcontenedor.add(panelBtnAñadirinstructor1);
			panelBtnAñadirinstructor1.setLayout(null);

			JButton btnAñadirInstructor1 = new JButton("Añadir instructor");
			btnAñadirInstructor1.setForeground(Color.WHITE);
			btnAñadirInstructor1.setFont(new Font("Calibri", Font.BOLD, 17));
			btnAñadirInstructor1.setFocusPainted(false);
			btnAñadirInstructor1.setContentAreaFilled(false);
			btnAñadirInstructor1.setBorderPainted(false);
			btnAñadirInstructor1.setBackground(new Color(55, 104, 167));
			btnAñadirInstructor1.setBounds(0, 0, 200, 20);
			panelBtnAñadirinstructor1.add(btnAñadirInstructor1);

			btnAñadirInstructor1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.CrearInstructor();
				}
			});
		} else {
			JButton btnDescargarCredencial1 = new JButton("Descargar credencial");
			btnDescargarCredencial1.setBounds(15, 481, 200, 20);
			panelcontenedor.add(btnDescargarCredencial1);
			btnDescargarCredencial1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[0][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.pdf(Integer.parseInt(quintoDato.toString()));
				}
			});
			btnDescargarCredencial1.setForeground(Color.WHITE);
			btnDescargarCredencial1.setFont(new Font("Calibri", Font.BOLD, 17));
			btnDescargarCredencial1.setFocusPainted(false);
			btnDescargarCredencial1.setBorderPainted(false);
			btnDescargarCredencial1.setContentAreaFilled(false);
			btnDescargarCredencial1.setBackground(Color.decode("#3768A7"));

			JPanel panelBtnInstructor1 = new JPanel();
			panelBtnInstructor1.setBounds(15, 480, 200, 20);
			panelBtnInstructor1.setBackground(Color.decode("#3768A7"));
			panelcontenedor.add(panelBtnInstructor1);
			panelBtnInstructor1.setLayout(null);

			JPanel panelBtnInstructor2 = new JPanel();
			panelBtnInstructor2.setBounds(15, 510, 200, 20);
			panelBtnInstructor2.setBackground(Color.decode("#3768A7"));
			panelcontenedor.add(panelBtnInstructor2);
			panelBtnInstructor2.setLayout(null);

			JButton btnEditarInstructor1 = new JButton("Editar instructor");
			btnEditarInstructor1.setForeground(Color.WHITE);
			btnEditarInstructor1.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEditarInstructor1.setFocusPainted(false);
			btnEditarInstructor1.setContentAreaFilled(false);
			btnEditarInstructor1.setBorderPainted(false);
			btnEditarInstructor1.setBackground(new Color(55, 104, 167));
			btnEditarInstructor1.setBounds(0, 0, 200, 20);
			panelBtnInstructor2.add(btnEditarInstructor1);

			btnEditarInstructor1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Editar instructor 1");
				}
			});

			JPanel panelBtnInstructor3 = new JPanel();
			panelBtnInstructor3.setBounds(15, 540, 200, 20);
			panelBtnInstructor3.setBackground(Color.decode("#A73737"));
			panelcontenedor.add(panelBtnInstructor3);
			panelBtnInstructor3.setLayout(null);

			JButton btnEliminarInstructor1 = new JButton("Eliminar instructor");
			btnEliminarInstructor1.setForeground(Color.WHITE);
			btnEliminarInstructor1.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEliminarInstructor1.setFocusPainted(false);
			btnEliminarInstructor1.setContentAreaFilled(false);
			btnEliminarInstructor1.setBorderPainted(false);
			btnEliminarInstructor1.setBackground(new Color(55, 104, 167));
			btnEliminarInstructor1.setBounds(0, 0, 200, 20);
			panelBtnInstructor3.add(btnEliminarInstructor1);


			btnEliminarInstructor1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[0][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.eliminarInstructor(Integer.parseInt(quintoDato.toString()));
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.instructor();
				}
			});
		}

		if (lbl_Instructor_2.getText().equals("")) {
			JPanel panelBtnAñadirinstructor2 = new JPanel();
			panelBtnAñadirinstructor2.setLayout(null);
			panelBtnAñadirinstructor2.setBackground(new Color(55, 104, 167));
			panelBtnAñadirinstructor2.setBounds(232, 481, 200, 20);
			panelcontenedor.add(panelBtnAñadirinstructor2);

			JButton btnAñadirInstructor2 = new JButton("Añadir instructor");
			btnAñadirInstructor2.setForeground(Color.WHITE);
			btnAñadirInstructor2.setFont(new Font("Calibri", Font.BOLD, 17));
			btnAñadirInstructor2.setFocusPainted(false);
			btnAñadirInstructor2.setContentAreaFilled(false);
			btnAñadirInstructor2.setBorderPainted(false);
			btnAñadirInstructor2.setBackground(new Color(55, 104, 167));
			btnAñadirInstructor2.setBounds(0, 0, 200, 20);
			panelBtnAñadirinstructor2.add(btnAñadirInstructor2);

			btnAñadirInstructor2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.CrearInstructor();
				}
			});
		} else {
			JPanel panelBtnInstructor4 = new JPanel();
			panelBtnInstructor4.setBounds(232, 480, 200, 20);
			panelBtnInstructor4.setBackground(Color.decode("#3768A7"));
			panelcontenedor.add(panelBtnInstructor4);
			panelBtnInstructor4.setLayout(null);

			JButton btnDescargarCredencial2 = new JButton("Descargar credencial");
			btnDescargarCredencial2.setForeground(Color.WHITE);
			btnDescargarCredencial2.setFont(new Font("Calibri", Font.BOLD, 17));
			btnDescargarCredencial2.setFocusPainted(false);
			btnDescargarCredencial2.setContentAreaFilled(false);
			btnDescargarCredencial2.setBorderPainted(false);
			btnDescargarCredencial2.setBackground(new Color(55, 104, 167));
			btnDescargarCredencial2.setBounds(0, 0, 200, 20);
			panelBtnInstructor4.add(btnDescargarCredencial2);

			btnDescargarCredencial2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[1][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.pdf(Integer.parseInt(quintoDato.toString()));
				}
			});

			JPanel panelBtnInstructor5 = new JPanel();
			panelBtnInstructor5.setBounds(232, 510, 200, 20);
			panelBtnInstructor5.setBackground(Color.decode("#3768A7"));
			panelcontenedor.add(panelBtnInstructor5);
			panelBtnInstructor5.setLayout(null);

			JButton btnEditarInstructor2 = new JButton("Editar instructor");
			btnEditarInstructor2.setForeground(Color.WHITE);
			btnEditarInstructor2.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEditarInstructor2.setFocusPainted(false);
			btnEditarInstructor2.setContentAreaFilled(false);
			btnEditarInstructor2.setBorderPainted(false);
			btnEditarInstructor2.setBackground(new Color(55, 104, 167));
			btnEditarInstructor2.setBounds(0, 0, 200, 20);
			panelBtnInstructor5.add(btnEditarInstructor2);

			btnEditarInstructor2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Editar instructor 2");
				}
			});

			JPanel panelBtnInstructor6 = new JPanel();
			panelBtnInstructor6.setBounds(232, 540, 200, 20);
			panelBtnInstructor6.setBackground(Color.decode("#A73737"));
			panelcontenedor.add(panelBtnInstructor6);
			panelBtnInstructor6.setLayout(null);

			JButton btnEliminarInstructor2 = new JButton("Eliminar instructor");
			btnEliminarInstructor2.setForeground(Color.WHITE);
			btnEliminarInstructor2.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEliminarInstructor2.setFocusPainted(false);
			btnEliminarInstructor2.setContentAreaFilled(false);
			btnEliminarInstructor2.setBorderPainted(false);
			btnEliminarInstructor2.setBackground(new Color(55, 104, 167));
			btnEliminarInstructor2.setBounds(0, 0, 200, 20);
			panelBtnInstructor6.add(btnEliminarInstructor2);

			btnEliminarInstructor2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[1][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.eliminarInstructor(Integer.parseInt(quintoDato.toString()));
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.instructor();
				}
			});
		}

		if (lbl_Instructor_3.getText().equals("")) {
			JPanel panelBtnAñadirinstructor3 = new JPanel();
			panelBtnAñadirinstructor3.setLayout(null);
			panelBtnAñadirinstructor3.setBackground(new Color(55, 104, 167));
			panelBtnAñadirinstructor3.setBounds(449, 481, 200, 20);
			panelcontenedor.add(panelBtnAñadirinstructor3);

			JButton btnAñadirInstructor3 = new JButton("Añadir instructor");
			btnAñadirInstructor3.setForeground(Color.WHITE);
			btnAñadirInstructor3.setFont(new Font("Calibri", Font.BOLD, 17));
			btnAñadirInstructor3.setFocusPainted(false);
			btnAñadirInstructor3.setContentAreaFilled(false);
			btnAñadirInstructor3.setBorderPainted(false);
			btnAñadirInstructor3.setBackground(new Color(55, 104, 167));
			btnAñadirInstructor3.setBounds(0, 0, 200, 20);
			panelBtnAñadirinstructor3.add(btnAñadirInstructor3);

			btnAñadirInstructor3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.CrearInstructor();
				}
			});
		} else {
			JPanel panelBtnInstructor7 = new JPanel();
			panelBtnInstructor7.setBounds(449, 480, 200, 20);
			panelBtnInstructor7.setBackground(Color.decode("#3768A7"));
			panelcontenedor.add(panelBtnInstructor7);
			panelBtnInstructor7.setLayout(null);

			JButton btnDescargarCredencial3 = new JButton("Descargar credencial");
			btnDescargarCredencial3.setForeground(Color.WHITE);
			btnDescargarCredencial3.setFont(new Font("Calibri", Font.BOLD, 17));
			btnDescargarCredencial3.setFocusPainted(false);
			btnDescargarCredencial3.setContentAreaFilled(false);
			btnDescargarCredencial3.setBorderPainted(false);
			btnDescargarCredencial3.setBackground(new Color(55, 104, 167));
			btnDescargarCredencial3.setBounds(0, 0, 200, 20);
			panelBtnInstructor7.add(btnDescargarCredencial3);

			btnDescargarCredencial3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[2][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.pdf(Integer.parseInt(quintoDato.toString()));
				}
			});

			JPanel panelBtnInstructor8 = new JPanel();
			panelBtnInstructor8.setBounds(449, 510, 200, 20);
			panelBtnInstructor8.setBackground(Color.decode("#3768A7"));
			panelcontenedor.add(panelBtnInstructor8);
			panelBtnInstructor8.setLayout(null);

			JButton btnEditarInstructor3 = new JButton("Editar instructor");
			btnEditarInstructor3.setForeground(Color.WHITE);
			btnEditarInstructor3.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEditarInstructor3.setFocusPainted(false);
			btnEditarInstructor3.setContentAreaFilled(false);
			btnEditarInstructor3.setBorderPainted(false);
			btnEditarInstructor3.setBackground(new Color(55, 104, 167));
			btnEditarInstructor3.setBounds(0, 0, 200, 20);
			panelBtnInstructor8.add(btnEditarInstructor3);

			btnEditarInstructor3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Editar instructor 3");
				}
			});

			JPanel panelBtnInstructor9 = new JPanel();
			panelBtnInstructor9.setBounds(449, 540, 200, 20);
			panelBtnInstructor9.setBackground(Color.decode("#A73737"));
			panelcontenedor.add(panelBtnInstructor9);
			panelBtnInstructor9.setLayout(null);

			JButton btnEliminarInstructor = new JButton("Eliminar instructor");
			btnEliminarInstructor.setForeground(Color.WHITE);
			btnEliminarInstructor.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEliminarInstructor.setFocusPainted(false);
			btnEliminarInstructor.setContentAreaFilled(false);
			btnEliminarInstructor.setBorderPainted(false);
			btnEliminarInstructor.setBackground(new Color(55, 104, 167));
			btnEliminarInstructor.setBounds(0, 0, 200, 20);
			panelBtnInstructor9.add(btnEliminarInstructor);

			btnEliminarInstructor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[1][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.eliminarInstructor(Integer.parseInt(quintoDato.toString()));
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.instructor();
				}
			});
		}

		if (lbl_Instructor_4.getText().equals("")) {
			JPanel panelBtnAñadirinstructor4 = new JPanel();
			panelBtnAñadirinstructor4.setLayout(null);
			panelBtnAñadirinstructor4.setBackground(new Color(55, 104, 167));
			panelBtnAñadirinstructor4.setBounds(667, 481, 200, 20);
			panelcontenedor.add(panelBtnAñadirinstructor4);

			JButton btnAñadirInstructor1_3 = new JButton("Añadir instructor");
			btnAñadirInstructor1_3.setForeground(Color.WHITE);
			btnAñadirInstructor1_3.setFont(new Font("Calibri", Font.BOLD, 17));
			btnAñadirInstructor1_3.setFocusPainted(false);
			btnAñadirInstructor1_3.setContentAreaFilled(false);
			btnAñadirInstructor1_3.setBorderPainted(false);
			btnAñadirInstructor1_3.setBackground(new Color(55, 104, 167));
			btnAñadirInstructor1_3.setBounds(0, 0, 200, 20);
			panelBtnAñadirinstructor4.add(btnAñadirInstructor1_3);

			btnAñadirInstructor1_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.CrearInstructor();
				}
			});
		} else {
			JPanel panelBtnInstructor10 = new JPanel();
			panelBtnInstructor10.setLayout(null);
			panelBtnInstructor10.setBackground(new Color(55, 104, 167));
			panelBtnInstructor10.setBounds(667, 481, 200, 20);
			panelcontenedor.add(panelBtnInstructor10);

			JButton btnDescargarCredencial4 = new JButton("Descargar credencial");
			btnDescargarCredencial4.setForeground(Color.WHITE);
			btnDescargarCredencial4.setFont(new Font("Calibri", Font.BOLD, 17));
			btnDescargarCredencial4.setFocusPainted(false);
			btnDescargarCredencial4.setContentAreaFilled(false);
			btnDescargarCredencial4.setBorderPainted(false);
			btnDescargarCredencial4.setBackground(new Color(55, 104, 167));
			btnDescargarCredencial4.setBounds(0, 0, 200, 20);
			panelBtnInstructor10.add(btnDescargarCredencial4);

			btnDescargarCredencial4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[3][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.pdf(Integer.parseInt(quintoDato.toString()));
				}
			});

			JPanel panelBtnInstructor11 = new JPanel();
			panelBtnInstructor11.setLayout(null);
			panelBtnInstructor11.setBackground(new Color(55, 104, 167));
			panelBtnInstructor11.setBounds(667, 510, 200, 20);
			panelcontenedor.add(panelBtnInstructor11);

			JButton btnEditarInstructor4 = new JButton("Editar instructor");
			btnEditarInstructor4.setForeground(Color.WHITE);
			btnEditarInstructor4.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEditarInstructor4.setFocusPainted(false);
			btnEditarInstructor4.setContentAreaFilled(false);
			btnEditarInstructor4.setBorderPainted(false);
			btnEditarInstructor4.setBackground(new Color(55, 104, 167));
			btnEditarInstructor4.setBounds(0, 0, 200, 20);
			panelBtnInstructor11.add(btnEditarInstructor4);

			btnEditarInstructor4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Editar instructor 4");
				}
			});

			JPanel panelBtnInstructor12 = new JPanel();
			panelBtnInstructor12.setLayout(null);
			panelBtnInstructor12.setBackground(new Color(167, 55, 55));
			panelBtnInstructor12.setBounds(667, 540, 200, 20);
			panelcontenedor.add(panelBtnInstructor12);

			JButton btnEliminarInstructor4 = new JButton("Eliminar instructor");
			btnEliminarInstructor4.setForeground(Color.WHITE);
			btnEliminarInstructor4.setFont(new Font("Calibri", Font.BOLD, 17));
			btnEliminarInstructor4.setFocusPainted(false);
			btnEliminarInstructor4.setContentAreaFilled(false);
			btnEliminarInstructor4.setBorderPainted(false);
			btnEliminarInstructor4.setBackground(new Color(55, 104, 167));
			btnEliminarInstructor4.setBounds(0, 0, 200, 20);
			panelBtnInstructor12.add(btnEliminarInstructor4);

			btnEliminarInstructor4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object quintoDato = instructores[1][4]; // Suponiendo que el primer dato es el nombre del instructor
					instructorModel.eliminarInstructor(Integer.parseInt(quintoDato.toString()));
					InstructorController controller= new InstructorController();
					frame.dispose();
					controller.instructor();
				}
			});
		}
		vistaComun();
		frame.repaint();
	}

	//Para crear los instructores
	public void crearInstructor() {
		panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		InstructorModel instructorModel = new InstructorModel();
		//Contenido
		JPanel panelcontenedor =new JPanel();
		panelcontenedor.setBackground(Color.decode("#FFFFFF"));
		panelcontenedor.setBounds(200, 76, 882, 573);
		panel.add(panelcontenedor);
		panelcontenedor.setLayout(null);

		JPanel panelCabeceraContenido = new JPanel();
		panelCabeceraContenido.setLayout(null);
		panelCabeceraContenido.setBackground(new Color(188, 218, 242));
		panelCabeceraContenido.setBounds(0, 0, 882, 40);
		panelcontenedor.add(panelCabeceraContenido);

		JLabel lblTituloContenido = new JLabel("Crear instructor");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 438, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del instructor");
		lblIngreseLosDatos.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblIngreseLosDatos.setBounds(243, 72, 414, 29);
		panelcontenedor.add(lblIngreseLosDatos);

		JLabel lblNombreCompleto = new JLabel("Nombre completo");
		lblNombreCompleto.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblNombreCompleto.setBounds(191, 137, 168, 29);
		panelcontenedor.add(lblNombreCompleto);

		//LLenar la informacion del instructor
		JTextArea textClasenombre = new JTextArea();
		textClasenombre.setFont(new Font("Calibri", Font.PLAIN, 18));
		textClasenombre.setBackground(Color.decode("#F5F5F5"));
		textClasenombre.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		textClasenombre.setBounds(191, 168, 500, 35);
		((PlainDocument) textClasenombre.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(40));
		 ((PlainDocument) textClasenombre.getDocument()).setDocumentFilter(new LetterFilter());
		panelcontenedor.add(textClasenombre);

		JLabel lblExperiencia = new JLabel("Experiencia");
		lblExperiencia.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblExperiencia.setBounds(191, 214, 168, 29);
		panelcontenedor.add(lblExperiencia);

		JTextArea textExperiencia = new JTextArea();
		textExperiencia.setFont(new Font("Calibri", Font.PLAIN, 18));
		textExperiencia.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		textExperiencia.setBackground(new Color(245, 245, 245));
		textExperiencia.setBounds(191, 240, 500, 62);
		((PlainDocument) textExperiencia.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(100));
		panelcontenedor.add(textExperiencia);

		JLabel lblFormacion = new JLabel("Formación");
		lblFormacion.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblFormacion.setBounds(191, 307, 202, 29);
		panelcontenedor.add(lblFormacion);

		JTextArea textFormacion = new JTextArea();
		textFormacion.setFont(new Font("Calibri", Font.PLAIN, 18));
		textFormacion.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		textFormacion.setBackground(new Color(245, 245, 245));
		textFormacion.setBounds(191, 332, 500, 62);
		((PlainDocument) textFormacion.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(100));
		panelcontenedor.add(textFormacion);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblHorario.setBounds(191, 401, 202, 29);
		panelcontenedor.add(lblHorario);

		JTextArea textHorario = new JTextArea();
		textHorario.setFont(new Font("Calibri", Font.PLAIN, 18));
		textHorario.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		textHorario.setBackground(new Color(245, 245, 245));
		textHorario.setBounds(191, 427, 500, 40);
		((PlainDocument) textHorario.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(80));
		panelcontenedor.add(textHorario);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(191, 494, 502, 40);
		panelcontenedor.add(panel_1);
		panel_1.setBackground(Color.decode("#214177"));
		panel_1.setLayout(null);
		
		//registrar el instructor
		JButton btnRegistrarInstructor = new JButton("Registrar instructor");
		btnRegistrarInstructor.setBounds(0, 0, 502, 38);
		panel_1.add(btnRegistrarInstructor);
		btnRegistrarInstructor.setForeground(Color.WHITE);
		btnRegistrarInstructor.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegistrarInstructor.setFocusPainted(false);
		btnRegistrarInstructor.setBorderPainted(false);
		btnRegistrarInstructor.setContentAreaFilled(false);
		btnRegistrarInstructor.setBackground(Color.decode("#214177"));

		btnRegistrarInstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textClasenombre.getText().trim();
				String experiencia = textExperiencia.getText().trim();
				String formacion = textFormacion.getText().trim();
				String horario = textHorario.getText().trim();

				if (nombre.isEmpty() || experiencia.isEmpty() || formacion.isEmpty() || horario.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if(instructorModel.agregarInstructor(nombre, experiencia, formacion, horario) == true) {
						JOptionPane.showMessageDialog(frame, "El instructor ya se encuentra registrado.", "Registro erroneo", JOptionPane.ERROR_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(frame, "Instructor registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);


						InstructorController controller= new InstructorController();
						frame.dispose();
						controller.instructor();
					}
				}
			}
		});

		vistaComun();


	}
	//Avatar del instructor
//	public void crearInstructorAvatar() {
//		panel = new JPanel();
//		panel.setBounds(0, 0, 1092, 660);
//		panel.setBackground(Color.decode("#F2F2F2"));
//		frame.getContentPane().add(panel);
//		panel.setLayout(null);
//
//		//Contenido
//		JPanel panelcontenedor =new JPanel();
//		panelcontenedor.setBackground(Color.decode("#FFFFFF"));
//		panelcontenedor.setBounds(200, 75, 882, 573);
//		panel.add(panelcontenedor);
//		panelcontenedor.setLayout(null);
//
//		JPanel panelCabeceraContenido = new JPanel();
//		panelCabeceraContenido.setLayout(null);
//		panelCabeceraContenido.setBackground(new Color(188, 218, 242));
//		panelCabeceraContenido.setBounds(0, 0, 882, 40);
//		panelcontenedor.add(panelCabeceraContenido);
//
//		JLabel lblTituloContenido = new JLabel("Crear instructor");
//		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
//		lblTituloContenido.setBounds(10, 11, 438, 29);
//		panelCabeceraContenido.add(lblTituloContenido);
//
//		JLabel lblIngreseLosDatos = new JLabel("Selecciona un avatar");
//		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
//		lblIngreseLosDatos.setFont(new Font("Calibri", Font.PLAIN, 26));
//		lblIngreseLosDatos.setBounds(237, 73, 414, 29);
//		panelcontenedor.add(lblIngreseLosDatos);
//
//		JLabel lblAvatar1 = new JLabel("");
//		lblAvatar1.setOpaque(true);
//		lblAvatar1.setBackground(new Color(0, 64, 128));
//		lblAvatar1.setFont(new Font("Calibri", Font.PLAIN, 16));
//		lblAvatar1.setBounds(235, 140, 160, 160);
//		ImageIcon imageIcon_lblAvatar1 = new ImageIcon("img/hombreCrearpfp.png");
//		lblAvatar1.setIcon(imageIcon_lblAvatar1);
//		lblAvatar1.addMouseListener(new MouseAdapter() {
//
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// Acción al hacer clic en el label
//				InstructorController controller= new InstructorController();
//				frame.dispose();
//				controller.instructor();
//
//			}
//		});
//		panelcontenedor.add(lblAvatar1);
//
//		JLabel lblAvatar2 = new JLabel("");
//		lblAvatar2.setOpaque(true);
//		lblAvatar2.setFont(new Font("Calibri", Font.PLAIN, 16));
//		lblAvatar2.setBackground(new Color(0, 64, 128));
//		lblAvatar2.setBounds(510, 140, 160, 160);
//		ImageIcon imageIcon_lblAvatar2 = new ImageIcon("img/imgEntrenador1.png");
//		lblAvatar2.setIcon(imageIcon_lblAvatar2);
//		lblAvatar2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				ImageIcon nuevaImagen = new ImageIcon("img/imgEntrenador1.png");
//				lblImg_Instructor_1.setIcon(nuevaImagen);
//				InstructorController controller= new InstructorController();
//				frame.dispose();
//				controller.instructor();
//			}
//		});
//		panelcontenedor.add(lblAvatar2);
//		vistaComun();
//	}
	//editar instructor
	  public void editarInstructor() {

	        panel = new JPanel();
	        panel.setBounds(0, 0, 1092, 660);
	        panel.setBackground(Color.decode("#F2F2F2"));
	        frame.getContentPane().add(panel);
	        panel.setLayout(null);

	        // Contenido
	        JPanel panelcontenedor = new JPanel();
	        panelcontenedor.setBackground(Color.decode("#FFFFFF"));
	        panelcontenedor.setBounds(200, 76, 882, 573);
	        panel.add(panelcontenedor);
	        panelcontenedor.setLayout(null);

	        JPanel panelCabeceraContenido = new JPanel();
	        panelCabeceraContenido.setLayout(null);
	        panelCabeceraContenido.setBackground(new Color(188, 218, 242));
	        panelCabeceraContenido.setBounds(0, 0, 882, 40);
	        panelcontenedor.add(panelCabeceraContenido);

	        JLabel lblTituloContenido = new JLabel("Editar instructor");
	        lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
	        lblTituloContenido.setBounds(10, 11, 438, 29);
	        panelCabeceraContenido.add(lblTituloContenido);

	        JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del instructor");
	        lblIngreseLosDatos.setFont(new Font("Calibri", Font.PLAIN, 26));
	        lblIngreseLosDatos.setBounds(243, 72, 414, 29);
	        panelcontenedor.add(lblIngreseLosDatos);

	        JLabel lblNombreCompleto = new JLabel("Nombre completo");
	        lblNombreCompleto.setFont(new Font("Calibri", Font.PLAIN, 16));
	        lblNombreCompleto.setBounds(191, 137, 168, 29);
	        panelcontenedor.add(lblNombreCompleto);

	        JTextArea textClasenombre = new JTextArea();
	        textClasenombre.setFont(new Font("Calibri", Font.PLAIN, 18));
	        textClasenombre.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
	        textClasenombre.setBackground(Color.decode("#F5F5F5"));
	        textClasenombre.setBounds(191, 168, 500, 35);
	        textClasenombre.setBorder(BorderFactory.createCompoundBorder(
	                new LineBorder(Color.decode("#D4D4D4"), 1),
	                new EmptyBorder(10, 10, 10, 10)
	        ));
	        ((PlainDocument) textClasenombre.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(40));
	        ((PlainDocument) textClasenombre.getDocument()).setDocumentFilter(new LetterFilter());
	        panelcontenedor.add(textClasenombre);

	        JLabel lblExperiencia = new JLabel("Experiencia");
	        lblExperiencia.setFont(new Font("Calibri", Font.PLAIN, 16));
	        lblExperiencia.setBounds(191, 214, 168, 29);
	        panelcontenedor.add(lblExperiencia);

	        JTextArea textExperiencia = new JTextArea();
	        textExperiencia.setFont(new Font("Calibri", Font.PLAIN, 18));
	        textExperiencia.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
	        textExperiencia.setBackground(new Color(245, 245, 245));
	        textExperiencia.setBounds(191, 240, 500, 62);
	        ((PlainDocument) textExperiencia.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(100));
	        panelcontenedor.add(textExperiencia);

	        JLabel lblFormacion = new JLabel("Formación");
	        lblFormacion.setFont(new Font("Calibri", Font.PLAIN, 16));
	        lblFormacion.setBounds(191, 307, 202, 29);
	        panelcontenedor.add(lblFormacion);

	        JTextArea textFormacion = new JTextArea();
	        textFormacion.setFont(new Font("Calibri", Font.PLAIN, 18));
	        textFormacion.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
	        textFormacion.setBackground(new Color(245, 245, 245));
	        textFormacion.setBounds(191, 332, 500, 62);
	        ((PlainDocument) textFormacion.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(100));
	        panelcontenedor.add(textFormacion);

	        JLabel lblHorario = new JLabel("Horario");
	        lblHorario.setFont(new Font("Calibri", Font.PLAIN, 16));
	        lblHorario.setBounds(191, 401, 202, 29);
	        panelcontenedor.add(lblHorario);

	        JTextArea textHorario = new JTextArea();
	        textHorario.setFont(new Font("Calibri", Font.PLAIN, 18));
	        textHorario.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
	        textHorario.setBackground(new Color(245, 245, 245));
	        textHorario.setBounds(191, 427, 500, 40);
	        ((PlainDocument) textHorario.getDocument()).setDocumentFilter(new FixedLengthDocumentFilter(80));
	        panelcontenedor.add(textHorario);

	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(191, 477, 502, 35);
	        panelcontenedor.add(panel_1);
	        panel_1.setBackground(Color.decode("#214177"));
	        panel_1.setLayout(null);

	        JButton btnRegistrarInstructor = new JButton("Guardar cambios ");
	        btnRegistrarInstructor.setBounds(0, 0, 502, 35);
	        panel_1.add(btnRegistrarInstructor);
	        btnRegistrarInstructor.setForeground(Color.WHITE);
	        btnRegistrarInstructor.setFont(new Font("Calibri", Font.BOLD, 20));
	        btnRegistrarInstructor.setFocusPainted(false);
	        btnRegistrarInstructor.setBorderPainted(false);
	        btnRegistrarInstructor.setContentAreaFilled(false);
	        btnRegistrarInstructor.setBackground(Color.decode("#214177"));

	        JPanel panel_1_1 = new JPanel();
	        panel_1_1.setLayout(null);
	        panel_1_1.setBackground(Color.decode("#A73737"));
	        panel_1_1.setBounds(189, 524, 502, 35);
	        panelcontenedor.add(panel_1_1);

	        JButton btnCancelar = new JButton("Cancelar cambios");
	        btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	InstructorController controller = new InstructorController();
					frame.dispose();
					controller.instructor();
	                
	            }
	        });
	        btnCancelar.setForeground(Color.WHITE);
	        btnCancelar.setFont(new Font("Calibri", Font.BOLD, 20));
	        btnCancelar.setFocusPainted(false);
	        btnCancelar.setContentAreaFilled(false);
	        btnCancelar.setBorderPainted(false);
	        btnCancelar.setBackground(new Color(33, 65, 119));
	        btnCancelar.setBounds(0, 0, 502, 35);
	        panel_1_1.add(btnCancelar);

	        btnRegistrarInstructor.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String nombre = textClasenombre.getText().trim();
	                String experiencia = textExperiencia.getText().trim();
	                String formacion = textFormacion.getText().trim();
	                String horario = textHorario.getText().trim();

	                if (nombre.isEmpty() || experiencia.isEmpty() || formacion.isEmpty() || horario.isEmpty()) {
	                    JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(frame, "Instructor registrado exitosamente.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
	                }
	            }
	        });

	        vistaComun();
	    }


	//Parte de botones ventanas principales y cabecera
	public void vistaComun() {

		//Cabecera

				JPanel panelCabecera = new JPanel();
				panelCabecera.setBackground(Color.decode("#BCDAF2"));
				panelCabecera.setBounds(0, 0, 1092, 65);
				panel.add(panelCabecera);
				panelCabecera.setLayout(null);

				JLabel lblTitulo = new JLabel("La disciplina es la madre del éxito");
				lblTitulo.setFont(new Font("Calibri", Font.BOLD, 24));
				lblTitulo.setBounds(420, 22, 452, 45);
				panelCabecera.add(lblTitulo);


				JLabel lblLogo = new JLabel("");
				lblLogo.setBounds(0, 0, 192, 67);
				ImageIcon imageIcon = new ImageIcon("img/logo.png"); 
				lblLogo.setIcon(imageIcon);

				panelCabecera.add(lblLogo);

				//Opciones
				JPanel panelOpciones = new JPanel();
				panelOpciones.setBackground(Color.decode("#214177"));
				panelOpciones.setBounds(0, 64, 190, 596);
				panel.add(panelOpciones);
				panelOpciones.setLayout(null);

				JLabel lblMarca = new JLabel("Gym-World");
				lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
				lblMarca.setBounds(2, 514, 188, 45);
				lblMarca.setForeground(Color.WHITE);
				lblMarca.setFont(new Font("Calibri", Font.BOLD, 29));
				panelOpciones.add(lblMarca);



				//Inicio
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.decode("#214177"));
				panel_1.setBounds(0, 0, 190, 95);
				panel_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_1);
				panel_1.setLayout(null);

				JButton btnInicio = new JButton("         Inicio");
				btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
				btnInicio.setBounds(0, 27, 190, 58);
				panel_1.add(btnInicio);
				btnInicio.setFont(new Font("Calibri", Font.BOLD, 20));
				btnInicio.setForeground(new Color(255, 255, 255));
				btnInicio.setBackground(Color.decode("#214177"));
				btnInicio.setFocusPainted(false);
				btnInicio.setBorderPainted(false);
				btnInicio.setContentAreaFilled(false);
				btnInicio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HomeController controller = new HomeController();
						frame.dispose();
						controller.inicio();
					}
				});
				JLabel lblInicio = new JLabel();
				lblInicio.setBounds(10, 30, 40, 40);
				ImageIcon imageIcon_Inicio = new ImageIcon("img/menu_inicio.png");
				lblInicio.setIcon(imageIcon_Inicio);
				panel_1.add(lblInicio);


				//Clintes

				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(33, 65, 119));
				panel_2.setBounds(0, 95, 190, 61);
				panel_2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_2);
				panel_2.setLayout(null);


				JButton btnClientes = new JButton("       Clientes");
				btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
				btnClientes.setBounds(0, 11, 190, 44);
				panel_2.add(btnClientes);
				btnClientes.setForeground(Color.WHITE);
				btnClientes.setFont(new Font("Calibri", Font.BOLD, 20));
				btnClientes.setFocusPainted(false);
				btnClientes.setBorderPainted(false);
				btnClientes.setBackground(new Color(33, 65, 119));
				btnClientes.setContentAreaFilled(false);
				btnClientes.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ClientController controller = new ClientController();
						frame.dispose();
						controller.cliente();
					}
				});

				JLabel lblClientes = new JLabel();
				lblClientes.setBounds(10, 10, 40, 40);
				ImageIcon imageIcon_Clientes = new ImageIcon("img/menu_cliente.png");
				lblClientes.setIcon(imageIcon_Clientes);
				panel_2.add(lblClientes);

				//Tarifas
				JPanel panel_3 = new JPanel();
				panel_3.setBackground(new Color(33, 65, 119));
				panel_3.setBounds(0, 156, 190, 61);
				panel_3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_3);
				panel_3.setBackground(Color.decode("#214177"));
				panel_3.setLayout(null);

				JButton btnTarifas = new JButton("       Tarifas");
				btnTarifas.setHorizontalAlignment(SwingConstants.LEFT);
				btnTarifas.setBounds(0, 11, 190, 44);
				panel_3.add(btnTarifas);
				btnTarifas.setForeground(Color.WHITE);
				btnTarifas.setFont(new Font("Calibri", Font.BOLD, 20));
				btnTarifas.setFocusPainted(false);
				btnTarifas.setBorderPainted(false);
				btnTarifas.setContentAreaFilled(false);
				btnTarifas.setBackground(new Color(33, 65, 119));
				btnTarifas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Acción al hacer clic en el botón
						FeeController controller = new FeeController();
						frame.dispose();
						controller.tarifa();
					}
				});

				JLabel lblTarifas = new JLabel();
				lblTarifas.setBounds(10, 10, 40, 40);
				ImageIcon imageIcon_Tarifas = new ImageIcon("img/menu_tarifa.png");
				lblTarifas.setIcon(imageIcon_Tarifas);
				panel_3.add(lblTarifas);

				//Instructores
				JPanel panel_4 = new JPanel();
				panel_4.setBackground(Color.decode("#3768A7"));
				panel_4.setBounds(0, 217, 190, 58);
				panel_4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_4);
				panel_4.setLayout(null);

				JButton btnInstructores = new JButton("        Instructores");
				btnInstructores.setHorizontalAlignment(SwingConstants.LEFT);
				btnInstructores.setBounds(0, 11, 190, 44);
				panel_4.add(btnInstructores);
				btnInstructores.setForeground(Color.WHITE);
				btnInstructores.setFont(new Font("Calibri", Font.BOLD, 17));
				btnInstructores.setFocusPainted(false);
				btnInstructores.setBorderPainted(false);
				btnInstructores.setContentAreaFilled(false);
				btnInstructores.setBackground(new Color(33, 65, 119));
				btnInstructores.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Acción al hacer clic en el botón
						InstructorController controller = new InstructorController();
						frame.dispose();
						controller.instructor();
					}
				});

				JLabel lblInstructores = new JLabel();
				lblInstructores.setBounds(10, 10, 40, 40);
				ImageIcon imageIcon_Intructores = new ImageIcon("img/menu_instructor.png");
				lblInstructores.setIcon(imageIcon_Intructores);
				panel_4.add(lblInstructores);

				//Clases
				JPanel panel_5 = new JPanel();
				panel_5.setBackground(new Color(33, 65, 119));
				panel_5.setBounds(0, 276, 190, 58);
				panel_5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_5);
				panel_5.setLayout(null);

				JButton btnClases = new JButton("        Clases");
				btnClases.setHorizontalAlignment(SwingConstants.LEFT);
				btnClases.setBounds(0, 11, 190, 44);
				panel_5.add(btnClases);
				btnClases.setForeground(Color.WHITE);
				btnClases.setFont(new Font("Calibri", Font.BOLD, 20));
				btnClases.setFocusPainted(false);
				btnClases.setBorderPainted(false);
				btnClases.setContentAreaFilled(false);
				btnClases.setBackground(new Color(33, 65, 119));

				JLabel lblClases = new JLabel();
				lblClases.setBounds(10, 10, 40, 40);
				ImageIcon imageIcon_Clases = new ImageIcon("img/menu_rutina.png");
				lblClases.setIcon(imageIcon_Clases);
				panel_5.add(lblClases);

				btnClases.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Acción al hacer clic en el botón
						ClassController controller = new ClassController();
						frame.dispose();
						controller.clase();
					}
				});

				//Checador
				JPanel panel_6 = new JPanel();
				panel_6.setBackground(new Color(33, 65, 119));
				panel_6.setBounds(0, 335, 190, 61);
				panel_6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_6);
				panel_6.setLayout(null);

				JButton btnChecador = new JButton("        Checador");
				btnChecador.setHorizontalAlignment(SwingConstants.LEFT);
				btnChecador.setBounds(0, 11, 190, 44);
				panel_6.add(btnChecador);
				btnChecador.setForeground(Color.WHITE);
				btnChecador.setFont(new Font("Calibri", Font.BOLD, 20));
				btnChecador.setFocusPainted(false);
				btnChecador.setBorderPainted(false);
				btnChecador.setContentAreaFilled(false);
				btnChecador.setBackground(new Color(33, 65, 119));
				btnChecador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Acción al hacer clic en el botón
						CheckController controller = new CheckController();
						frame.dispose();
						controller.checador();
					}
				});

				JLabel lblChecador = new JLabel();
				lblChecador.setBounds(10, 10, 40, 40);
				ImageIcon imageIcon_Checador = new ImageIcon("img/menu_Checador.png");
				lblChecador.setIcon(imageIcon_Checador);
				panel_6.add(lblChecador);

				//Cerrrar sesion
				JPanel panel_7 = new JPanel();
				panel_7.setBackground(new Color(33, 65, 119));
				panel_7.setBounds(0, 396, 190, 58);
				panel_7.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_7);
				panel_7.setLayout(null);

				JButton btnCerrarSesion = new JButton("         Cerrar sesion");
				btnCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
				btnCerrarSesion.setBounds(0, 11, 190, 44);
				panel_7.add(btnCerrarSesion);
				btnCerrarSesion.setForeground(Color.WHITE);
				btnCerrarSesion.setFont(new Font("Calibri", Font.BOLD, 17));
				btnCerrarSesion.setFocusPainted(false);
				btnCerrarSesion.setBorderPainted(false);
				btnCerrarSesion.setContentAreaFilled(false);
				btnCerrarSesion.setBackground(new Color(33, 65, 119));
				btnCerrarSesion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Auth controller = new Auth();
						frame.dispose();
						controller.cerrar();
						// Acción al hacer clic en el botón
					}
				});

				JLabel lblCerrarSesion = new JLabel();
				lblCerrarSesion.setBounds(10, 10, 40, 40);
				ImageIcon imageIcon_CerrarSesion = new ImageIcon("img/menu_cerrar_sesion.png");
				lblCerrarSesion.setIcon(imageIcon_CerrarSesion);
				panel_7.add(lblCerrarSesion);

				frame.getContentPane().add(panel);
				frame.setVisible(true);
				frame.repaint();
				frame.revalidate();

	}

	// Filtro para permitir solo letras
	class LetterFilter extends DocumentFilter {
	    @Override
	    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
	        if (string != null) {
	            string = string.replaceAll("[^a-zA-Z ]", ""); // permite solo letras y espacios
	            super.insertString(fb, offset, string, attr);
	        }
	    }

	    @Override
	    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	        if (text != null) {
	            text = text.replaceAll("[^a-zA-Z ]", ""); // permite solo letras y espacios
	            super.replace(fb, offset, length, text, attrs);
	        }
	    }
	}

	// Limite para campos
	class FixedLengthDocumentFilter extends DocumentFilter {
	    private int limit;

	    public FixedLengthDocumentFilter(int limit) {
	        this.limit = limit;
	    }

	    @Override
	    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
	        if (string == null) return;

	        if ((fb.getDocument().getLength() + string.length()) <= limit) {
	            super.insertString(fb, offset, string, attr);
	        }
	    }

	    @Override
	    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	        if (text == null) return;

	        if ((fb.getDocument().getLength() + text.length() - length) <= limit) {
	            super.replace(fb, offset, length, text, attrs);
	        }
	    }
	}

	


}