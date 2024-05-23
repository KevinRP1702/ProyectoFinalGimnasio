package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.CheckController;
import controllers.ClassController;
import controllers.ClientController;
import controllers.CloseSessionController;
import controllers.FeeController;
import controllers.HomeController;
import controllers.InstructorController;



public class FeeView {

	private JFrame frame;


	public FeeView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1108, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setLocationRelativeTo(null);

	}

	public void tarifa() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

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

		JLabel lblTituloContenido = new JLabel("Tarifas");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 160, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		JButton btnRegistrarCliente = new JButton("Pagar membresía");
		btnRegistrarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FeeController controller = new FeeController();
					frame.dispose();
					controller.pagar();
					// Acción al hacer clic en el botón
				}
			});
		btnRegistrarCliente.setForeground(Color.WHITE);
		btnRegistrarCliente.setFont(new Font("Calibri", Font.BOLD, 20));
		btnRegistrarCliente.setFocusPainted(false);
		btnRegistrarCliente.setBorderPainted(false);
		btnRegistrarCliente.setBackground(Color.decode("#3768A7"));
		btnRegistrarCliente.setBounds(682, 5, 190, 30);
		
		panelCabeceraContenido.add(btnRegistrarCliente);

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
		lblMarca.setBounds(2, 514, 188, 45);
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Calibri", Font.BOLD, 38));
		panelOpciones.add(lblMarca);



		//Inicio
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#214177"));
		panel_1.setBounds(0, 0, 190, 95);
		panel_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
		panelOpciones.add(panel_1);
		panel_1.setLayout(null);

		JButton btnInicio = new JButton("           Inicio");
		btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicio.setBounds(0, 27, 190, 58);
		panel_1.add(btnInicio);
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 20));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setBackground(Color.decode("#214177"));
		btnInicio.setFocusPainted(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);

		btnInicio.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_1.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_1.setBackground(Color.decode("#214177"));
			}
		});

		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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


		JButton btnClientes = new JButton(" Clientes");
		btnClientes.setBounds(0, 11, 190, 44);
		panel_2.add(btnClientes);
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setFont(new Font("Calibri", Font.BOLD, 20));
		btnClientes.setFocusPainted(false);
		btnClientes.setBorderPainted(false);
		btnClientes.setBackground(new Color(33, 65, 119));
		btnClientes.setContentAreaFilled(false);
		btnClientes.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_2.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_2.setBackground(Color.decode("#214177"));
			}
		});
		
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
		panel_3.setLayout(null);

		JButton btnTarifas = new JButton("Tarifas");
		btnTarifas.setBounds(0, 11, 190, 44);
		panel_3.add(btnTarifas);
		btnTarifas.setForeground(Color.WHITE);
		btnTarifas.setFont(new Font("Calibri", Font.BOLD, 20));
		btnTarifas.setFocusPainted(false);
		btnTarifas.setBorderPainted(false);
		btnTarifas.setContentAreaFilled(false);
		btnTarifas.setBackground(new Color(33, 65, 119));
		btnTarifas.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_3.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_3.setBackground(Color.decode("#214177"));
			}
		});

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
		panel_4.setBackground(new Color(33, 65, 119));
		panel_4.setBounds(0, 217, 190, 58);
		panel_4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
		panelOpciones.add(panel_4);
		panel_4.setLayout(null);

		JButton btnInstructores = new JButton("          Instructores");
		btnInstructores.setHorizontalAlignment(SwingConstants.LEFT);
		btnInstructores.setBounds(0, 11, 190, 44);
		panel_4.add(btnInstructores);
		btnInstructores.setForeground(Color.WHITE);
		btnInstructores.setFont(new Font("Calibri", Font.BOLD, 20));
		btnInstructores.setFocusPainted(false);
		btnInstructores.setBorderPainted(false);
		btnInstructores.setContentAreaFilled(false);
		btnInstructores.setBackground(new Color(33, 65, 119));
		btnInstructores.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_4.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_4.setBackground(Color.decode("#214177"));
			}
		});

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

		JButton btnClases = new JButton("Clases");
		btnClases.setBounds(0, 11, 190, 44);
		panel_5.add(btnClases);
		btnClases.setForeground(Color.WHITE);
		btnClases.setFont(new Font("Calibri", Font.BOLD, 20));
		btnClases.setFocusPainted(false);
		btnClases.setBorderPainted(false);
		btnClases.setContentAreaFilled(false);
		btnClases.setBackground(new Color(33, 65, 119));
		btnClases.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_5.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_5.setBackground(Color.decode("#214177"));
			}
		});
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

		JButton btnChecador = new JButton("          Checador");
		btnChecador.setHorizontalAlignment(SwingConstants.LEFT);
		btnChecador.setBounds(0, 11, 190, 44);
		panel_6.add(btnChecador);
		btnChecador.setForeground(Color.WHITE);
		btnChecador.setFont(new Font("Calibri", Font.BOLD, 20));
		btnChecador.setFocusPainted(false);
		btnChecador.setBorderPainted(false);
		btnChecador.setContentAreaFilled(false);
		btnChecador.setBackground(new Color(33, 65, 119));
		btnChecador.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_6.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_6.setBackground(Color.decode("#214177"));
			}
		});

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
		btnCerrarSesion.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setBackground(new Color(33, 65, 119));
		btnCerrarSesion.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_7.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_7.setBackground(Color.decode("#214177"));
			}
		});

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseSessionController controller = new CloseSessionController();
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
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	public void tarifaPago() {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

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
		
		JLabel lblTituloContenido = new JLabel("Tarifas pago");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 160, 29);
		panelCabeceraContenido.add(lblTituloContenido);
		
		JButton btnPagar = new JButton("Pagar membresía");
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setFont(new Font("Calibri", Font.BOLD, 20));
		btnPagar.setFocusPainted(false);
		btnPagar.setBorderPainted(false);
		btnPagar.setBackground(new Color(55, 104, 167));
		btnPagar.setBounds(536, 107, 190, 30);
		panelcontenedor.add(btnPagar);

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
		lblMarca.setBounds(2, 514, 188, 45);
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Calibri", Font.BOLD, 38));
		panelOpciones.add(lblMarca);



		//Inicio
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#214177"));
		panel_1.setBounds(0, 0, 190, 95);
		panel_1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
		panelOpciones.add(panel_1);
		panel_1.setLayout(null);

		JButton btnInicio = new JButton("           Inicio");
		btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
		btnInicio.setBounds(0, 27, 190, 58);
		panel_1.add(btnInicio);
		btnInicio.setFont(new Font("Calibri", Font.BOLD, 20));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setBackground(Color.decode("#214177"));
		btnInicio.setFocusPainted(false);
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);

		btnInicio.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_1.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_1.setBackground(Color.decode("#214177"));
			}
		});

		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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


		JButton btnClientes = new JButton(" Clientes");
		btnClientes.setBounds(0, 11, 190, 44);
		panel_2.add(btnClientes);
		btnClientes.setForeground(Color.WHITE);
		btnClientes.setFont(new Font("Calibri", Font.BOLD, 20));
		btnClientes.setFocusPainted(false);
		btnClientes.setBorderPainted(false);
		btnClientes.setBackground(new Color(33, 65, 119));
		btnClientes.setContentAreaFilled(false);
		btnClientes.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_2.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_2.setBackground(Color.decode("#214177"));
			}
		});
		
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
		panel_3.setLayout(null);

		JButton btnTarifas = new JButton("Tarifas");
		btnTarifas.setBounds(0, 11, 190, 44);
		panel_3.add(btnTarifas);
		btnTarifas.setForeground(Color.WHITE);
		btnTarifas.setFont(new Font("Calibri", Font.BOLD, 20));
		btnTarifas.setFocusPainted(false);
		btnTarifas.setBorderPainted(false);
		btnTarifas.setContentAreaFilled(false);
		btnTarifas.setBackground(new Color(33, 65, 119));
		btnTarifas.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_3.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_3.setBackground(Color.decode("#214177"));
			}
		});

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
		panel_4.setBackground(new Color(33, 65, 119));
		panel_4.setBounds(0, 217, 190, 58);
		panel_4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
		panelOpciones.add(panel_4);
		panel_4.setLayout(null);

		JButton btnInstructores = new JButton("          Instructores");
		btnInstructores.setHorizontalAlignment(SwingConstants.LEFT);
		btnInstructores.setBounds(0, 11, 190, 44);
		panel_4.add(btnInstructores);
		btnInstructores.setForeground(Color.WHITE);
		btnInstructores.setFont(new Font("Calibri", Font.BOLD, 20));
		btnInstructores.setFocusPainted(false);
		btnInstructores.setBorderPainted(false);
		btnInstructores.setContentAreaFilled(false);
		btnInstructores.setBackground(new Color(33, 65, 119));
		btnInstructores.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_4.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_4.setBackground(Color.decode("#214177"));
			}
		});

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

		JButton btnClases = new JButton("Clases");
		btnClases.setBounds(0, 11, 190, 44);
		panel_5.add(btnClases);
		btnClases.setForeground(Color.WHITE);
		btnClases.setFont(new Font("Calibri", Font.BOLD, 20));
		btnClases.setFocusPainted(false);
		btnClases.setBorderPainted(false);
		btnClases.setContentAreaFilled(false);
		btnClases.setBackground(new Color(33, 65, 119));
		btnClases.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_5.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_5.setBackground(Color.decode("#214177"));
			}
		});
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

		JButton btnChecador = new JButton("          Checador");
		btnChecador.setHorizontalAlignment(SwingConstants.LEFT);
		btnChecador.setBounds(0, 11, 190, 44);
		panel_6.add(btnChecador);
		btnChecador.setForeground(Color.WHITE);
		btnChecador.setFont(new Font("Calibri", Font.BOLD, 20));
		btnChecador.setFocusPainted(false);
		btnChecador.setBorderPainted(false);
		btnChecador.setContentAreaFilled(false);
		btnChecador.setBackground(new Color(33, 65, 119));
		btnChecador.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_6.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_6.setBackground(Color.decode("#214177"));
			}
		});

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
		btnCerrarSesion.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setContentAreaFilled(false);
		btnCerrarSesion.setBackground(new Color(33, 65, 119));
		btnCerrarSesion.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				panel_7.setBackground(Color.decode("#3768A7"));
			}

			public void focusLost(FocusEvent e) {
				panel_7.setBackground(Color.decode("#214177"));
			}
		});

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseSessionController controller = new CloseSessionController();
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
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	



}
