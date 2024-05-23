package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controllers.Auth;
import models.AuthModel;

public class AuthView {

	private JFrame frame;
	private Auth controller;
	private AuthModel auth;
	private boolean autorizar;
	
	public AuthView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1108, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);
		
		auth = new AuthModel();
	}
	
	public void login() {
		//Diseño del login
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 550, 660);
		panelLogin.setBackground(Color.decode("#BCDAF2"));
		panelLogin.setLayout(null);
		
		JPanel panelLogincontenedor = new JPanel();
		panelLogincontenedor.setBackground(Color.decode("#FFFFFF"));
		panelLogincontenedor.setBounds(40, 60, 470, 540);
		panelLogin.add(panelLogincontenedor);
		panelLogincontenedor.setLayout(null);
		
		JLabel lblLogintitulo = new JLabel("Gym-World");
		lblLogintitulo.setFont(new Font("Calibri", Font.BOLD, 65));
		lblLogintitulo.setBounds(60, 49, 350, 109);
		panelLogincontenedor.add(lblLogintitulo);
		
		JLabel lblSub = new JLabel("Ingrese sus datos para iniciar sesión");
		lblSub.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSub.setBounds(89, 169, 292, 26);
		panelLogincontenedor.add(lblSub);
		
		
		
		JTextArea textUsuario = new JTextArea();
		textUsuario.setFont(new Font("Calibri", Font.PLAIN, 15));
		textUsuario.setBackground(Color.decode("#F5F5F5"));
		textUsuario.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		TextPrompt prompt1 = new TextPrompt("Usuario", textUsuario);
		prompt1.setFont(new Font("Calibri", Font.PLAIN, 15));
		prompt1.setForeground(new Color(192, 192, 192));
		textUsuario.setBounds(60, 245, 350, 40);
		textUsuario.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#D4D4D4"), 1),
                new EmptyBorder(10, 10, 10, 10)  // Agregar padding
        ));
		panelLogincontenedor.add(textUsuario);
		
		
		JPasswordField textCont = new JPasswordField();
		textCont.setFont(new Font("Calibri", Font.PLAIN, 15));
		textCont.setBackground(Color.decode("#F5F5F5"));
		textCont.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		
		char[] password = textCont.getPassword();
        String passwordText = new String(password);
		TextPrompt prompt2 = new TextPrompt("Contraseña", textCont);
		prompt2.setFont(new Font("Calibri", Font.PLAIN, 15));
		prompt2.setForeground(new Color(192, 192, 192));
		textCont.setBounds(60, 310, 350, 40);
		textCont.setBorder(BorderFactory.createCompoundBorder(
				
	                new LineBorder(Color.decode("#D4D4D4"), 1),
	                new EmptyBorder(10, 10, 10, 10)  // Agregar padding
	        ));
		panelLogincontenedor.add(textCont);
		
		
		
		
		JButton btnSesion = new JButton("Iniciar sesión");
		btnSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (textUsuario.getText().equals("") || textCont.getPassword().length == 0) {
					 
			            JOptionPane.showMessageDialog(frame, "Debe llenar todos los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
			        } else {
			        	
			        	
			        	if((auth.login(textUsuario.getText(), textCont.getText()) != false)) {
			        		frame.dispose();
			        	}
			        	else {
			        		JOptionPane.showMessageDialog(frame, "Sus credenciales no coinciden con una cuenta existente", "Error", JOptionPane.WARNING_MESSAGE);
			        	}
			           
			        }
					
				
				
				
			}
		});
		btnSesion.setFont(new Font("Calibri", Font.BOLD, 24));
		btnSesion.setForeground(new Color(255, 255, 255));
		btnSesion.setBackground(Color.decode("#3768A7"));
		btnSesion.setBounds(60, 375, 350, 40);
		btnSesion.setFocusPainted(false);
		
		panelLogincontenedor.add(btnSesion);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setFont(new Font("Calibri", Font.BOLD, 24));
		btnCrearCuenta.setForeground(new Color(255, 255, 255));
		btnCrearCuenta.setBackground(Color.decode("#214177"));
		btnCrearCuenta.setFocusPainted(false);
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller = new Auth();
	        	frame.dispose();
	        	controller.registro();
			}
		});
		
		btnCrearCuenta.setBounds(60, 450, 350, 40);
		panelLogincontenedor.add(btnCrearCuenta);
		
		JLabel lblLinea = new JLabel("");
		lblLinea.setBackground(Color.decode("#CFCFCF"));
		lblLinea.setOpaque(true);
		lblLinea.setBounds(50, 435, 370, 1);
		panelLogincontenedor.add(lblLinea);
		
		JPanel panel = new JPanel();
		panel.setBounds(550, 0, 542, 660);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 542, 660);
		ImageIcon imageIcon = new ImageIcon("src/login.jpg"); 
        lblNewLabel.setIcon(imageIcon);
		panel.add(lblNewLabel);
		
		frame.add(panelLogin);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
		
	}
	
	public void registro() {
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 1092, 660);
		panelLogin.setBackground(Color.decode("#BCDAF2"));
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		JPanel panelLogincontenedor = new JPanel();
		panelLogincontenedor.setBackground(Color.decode("#FFFFFF"));
		panelLogincontenedor.setBounds(266, 166, 560, 384);
		panelLogin.add(panelLogincontenedor);
		panelLogincontenedor.setLayout(null);
		
		JLabel lblSub = new JLabel("¡Crear una cuenta!");
		lblSub.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSub.setBounds(193, 22, 217, 26);
		panelLogincontenedor.add(lblSub);
		
		JTextArea textUsuario = new JTextArea();
		textUsuario.setFont(new Font("Calibri", Font.PLAIN, 15));
		textUsuario.setBackground(Color.decode("#F5F5F5"));
		textUsuario.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		TextPrompt prompt1 = new TextPrompt("Nombre de usuario", textUsuario);
		prompt1.setFont(new Font("Calibri", Font.PLAIN, 15));
		prompt1.setForeground(new Color(192, 192, 192));
		textUsuario.setBounds(40, 79, 480, 40);
		textUsuario.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#D4D4D4"), 1),
                new EmptyBorder(10, 10, 10, 10)  // Agregar padding
        ));
		panelLogincontenedor.add(textUsuario);
		
		
		
		JTextArea textCorreo = new JTextArea();
		textCorreo.setFont(new Font("Calibri", Font.PLAIN, 15));
		textCorreo.setBackground(Color.decode("#F5F5F5"));
		textCorreo.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		TextPrompt prompt3 = new TextPrompt("Corrreo electrónico", textCorreo);
		prompt3.setFont(new Font("Calibri", Font.PLAIN, 15));
		prompt3.setForeground(new Color(192, 192, 192));
		textCorreo.setBounds(40, 133, 480, 40);
		textCorreo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#D4D4D4"), 1),
                new EmptyBorder(10, 10, 10, 10)  // Agregar padding
        ));
		panelLogincontenedor.add(textCorreo);
		
		JPasswordField textCont = new JPasswordField();
		textCont.setFont(new Font("Calibri", Font.PLAIN, 15));
		textCont.setBackground(Color.decode("#F5F5F5"));
		textCont.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		
		TextPrompt prompt2 = new TextPrompt("Contraseña", textCont);
		prompt2.setFont(new Font("Calibri", Font.PLAIN, 15));
		prompt2.setForeground(new Color(192, 192, 192));
		textCont.setBounds(40, 184, 480, 40);
		textCont.setBorder(BorderFactory.createCompoundBorder(
	                new LineBorder(Color.decode("#D4D4D4"), 1),
	                new EmptyBorder(10, 10, 10, 10)  // Agregar padding
	        ));
		panelLogincontenedor.add(textCont);
		
		
		JPasswordField textContConfir = new JPasswordField();
		textContConfir.setFont(new Font("Calibri", Font.PLAIN, 15));
		textContConfir.setBackground(Color.decode("#F5F5F5"));
		textContConfir.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		
		TextPrompt prompt4 = new TextPrompt("Confirmar contraseña", textContConfir);
		prompt4.setFont(new Font("Calibri", Font.PLAIN, 15));
		prompt4.setForeground(new Color(192, 192, 192));
		textContConfir.setBounds(40, 235, 480, 40);
		textContConfir.setBorder(BorderFactory.createCompoundBorder(
	                new LineBorder(Color.decode("#D4D4D4"), 1),
	                new EmptyBorder(10, 10, 10, 10)  // Agregar padding
	        ));
		panelLogincontenedor.add(textContConfir);
		
		
		
		
		JButton btnSesion = new JButton("Registrarte");
		btnSesion.setFont(new Font("Calibri", Font.BOLD, 24));
		btnSesion.setForeground(new Color(255, 255, 255));
		btnSesion.setBackground(Color.decode("#3768A7"));
		btnSesion.setBounds(40, 286, 480, 40);
		btnSesion.setFocusPainted(false);
		btnSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textCont.getText().isEmpty() || textContConfir.getText().isEmpty() || textUsuario.getText().isEmpty() || textCorreo.getText().isEmpty()) {
					 JOptionPane.showMessageDialog(frame, "Debe llenar todos los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
				}

				else {
					auth.registro(textUsuario.getText(), textCorreo.getText(), textCont.getText());
					JOptionPane.showMessageDialog(frame, "Su cuenta ha sido creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
					
					controller = new Auth();
		        	frame.dispose();
		        	controller.login();
				}
				
			}
		});
		
		panelLogincontenedor.add(btnSesion);
		
		JLabel lblLinea = new JLabel("");
		lblLinea.setBackground(Color.decode("#CFCFCF"));
		lblLinea.setOpaque(true);
		lblLinea.setBounds(71, 53, 420, 1);
		panelLogincontenedor.add(lblLinea);
		
		JLabel lblNewLabel = new JLabel("¿Ya tienes una cuenta?");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.decode("#3588F4"));
		lblNewLabel.setBounds(203, 337, 239, 36);
		panelLogincontenedor.add(lblNewLabel);
		
		JLabel lblLogintitulo = new JLabel("Gym-World");
		lblLogintitulo.setBounds(293, 70, 533, 99);
		panelLogin.add(lblLogintitulo);
		lblLogintitulo.setFont(new Font("Calibri", Font.BOLD, 99));
		
		frame.add(panelLogin);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
}
