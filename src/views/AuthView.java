package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		frame.setResizable(false);
		frame.setResizable(false);
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
				lblLogintitulo.setHorizontalAlignment(SwingConstants.CENTER);
				lblLogintitulo.setFont(new Font("Calibri", Font.BOLD, 61));
				lblLogintitulo.setBounds(10, 49, 460, 109);
				panelLogincontenedor.add(lblLogintitulo);

				JLabel lblSub = new JLabel("Ingrese sus datos para iniciar sesión");
				lblSub.setHorizontalAlignment(SwingConstants.CENTER);
				lblSub.setFont(new Font("Calibri", Font.PLAIN, 18));
				lblSub.setBounds(10, 169, 450, 26);
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


				//Botono iniciar sesion
				JPanel panelCrearCuenta = new JPanel();
				panelCrearCuenta.setBounds(60, 452, 350, 40);
				panelCrearCuenta.setBackground(Color.decode("#214177"));
				panelLogincontenedor.add(panelCrearCuenta);
				panelCrearCuenta.setLayout(null);
				JButton btnCrearCuenta = new JButton("Crear cuenta");
				btnCrearCuenta.setBounds(0, 0, 350, 40);
				panelCrearCuenta.add(btnCrearCuenta);
				btnCrearCuenta.setForeground(Color.WHITE);
				btnCrearCuenta.setFont(new Font("Calibri", Font.BOLD, 17));
				btnCrearCuenta.setFocusPainted(false);
				btnCrearCuenta.setContentAreaFilled(false);
				btnCrearCuenta.setBorderPainted(false);

				btnCrearCuenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller = new Auth();
						frame.dispose();
						controller.registro();


					}
				});



				JLabel lblLinea = new JLabel("");
				lblLinea.setBackground(Color.decode("#CFCFCF"));
				lblLinea.setOpaque(true);
				lblLinea.setBounds(50, 435, 370, 1);
				panelLogincontenedor.add(lblLinea);

				JPanel panelIniciarSesion = new JPanel();
				panelIniciarSesion.setLayout(null);
				panelIniciarSesion.setBackground(Color.decode("#3768A7"));
				panelIniciarSesion.setBounds(60, 372, 350, 40);
				panelLogincontenedor.add(panelIniciarSesion);

				JButton btnIniciarSesion = new JButton("Iniciar sesión");
				btnIniciarSesion.addActionListener(new ActionListener() {
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
				btnIniciarSesion.setForeground(Color.WHITE);
				btnIniciarSesion.setFont(new Font("Calibri", Font.BOLD, 17));
				btnIniciarSesion.setFocusPainted(false);
				btnIniciarSesion.setContentAreaFilled(false);
				btnIniciarSesion.setBorderPainted(false);
				btnIniciarSesion.setBounds(0, 0, 350, 40);
				panelIniciarSesion.add(btnIniciarSesion);


				JPanel panel = new JPanel();
				panel.setBounds(550, 0, 542, 660);
				frame.getContentPane().add(panel);
				panel.setLayout(null);

				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(0, 0, 542, 660);
				//botonCrear.setIcon(new ImageIcon(getClass().getResource("/contenido/crearRenta.png")));
				
				lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/imgs/login.jpg")));
				panel.add(lblNewLabel);

				frame.getContentPane().add(panelLogin);
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
		lblSub.setHorizontalAlignment(SwingConstants.CENTER);
		lblSub.setFont(new Font("Calibri", Font.PLAIN, 22));
		lblSub.setBounds(71, 22, 420, 26);
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



		JPanel panelCrearCuenta = new JPanel();
		panelCrearCuenta.setBounds(111, 286, 350, 40);
		panelCrearCuenta.setBackground(Color.decode("#3768A7"));
		panelLogincontenedor.add(panelCrearCuenta);
		panelCrearCuenta.setLayout(null);
		
		JButton btnCrearCuenta = new JButton("Registrarte");
		btnCrearCuenta.setBounds(0, 0, 350, 40);
		panelCrearCuenta.add(btnCrearCuenta);
		btnCrearCuenta.setForeground(Color.WHITE);
		btnCrearCuenta.setFont(new Font("Calibri", Font.BOLD, 17));
		btnCrearCuenta.setFocusPainted(false);
		btnCrearCuenta.setContentAreaFilled(false);
		btnCrearCuenta.setBorderPainted(false);
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

	    	
	    	 	String usuario = textUsuario.getText();
		        String correo = textCorreo.getText();
		        String contra = new String(textCont.getPassword());
		        String contraConfir = new String(textContConfir.getPassword());

		        if (usuario.isEmpty() || correo.isEmpty() || contra.isEmpty() || contraConfir.isEmpty()) {
		            JOptionPane.showMessageDialog(frame, "Debe llenar todos los campos", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
		        } else if (!contra.equals(contraConfir)) {
		            JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden", "Error de contraseña", JOptionPane.ERROR_MESSAGE);
		        } else if (!correo.contains("@")) {
		            JOptionPane.showMessageDialog(frame, "El correo electrónico debe contener una '@'", "Correo inválido", JOptionPane.ERROR_MESSAGE);
		        } else {
		        	if( auth.registro(textUsuario.getText(), textCorreo.getText(), contra) == false) {
		        		 JOptionPane.showMessageDialog(frame, "Ya existe el usuario en la base", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		        	}else {
		        		  JOptionPane.showMessageDialog(frame, "Su cuenta ha sido creada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

				            controller = new Auth();
				            frame.dispose();
				            controller.login();
		        	}
		        }
			}
		});



		JLabel lblLinea = new JLabel("");
		lblLinea.setBackground(Color.decode("#CFCFCF"));
		lblLinea.setOpaque(true);
		lblLinea.setBounds(71, 53, 420, 1);
		panelLogincontenedor.add(lblLinea);

		JLabel lblRegresar = new JLabel("¿Ya tienes una cuenta?");
		lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegresar.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblRegresar.setForeground(Color.decode("#3588F4"));
		lblRegresar.setBounds(111, 337, 350, 36);
		lblRegresar.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Acción al hacer clic en el JLabel
				Auth Controller = new Auth();
				frame.dispose();
				Controller.login();
			}


		});
		panelLogincontenedor.add(lblRegresar);

		JLabel lblLogintitulo = new JLabel("Gym-World");
		lblLogintitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogintitulo.setBounds(132, 70, 826, 99);
		panelLogin.add(lblLogintitulo);
		lblLogintitulo.setFont(new Font("Calibri", Font.BOLD, 99));

		frame.getContentPane().add(panelLogin);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
}
