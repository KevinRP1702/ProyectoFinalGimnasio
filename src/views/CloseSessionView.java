package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.Auth;
import controllers.CheckController;
import controllers.ClassController;
import controllers.ClientController;
import controllers.FeeController;
import controllers.HomeController;
import controllers.InstructorController;



public class CloseSessionView {

	private JFrame frame;
	private JPanel panel;

	
	public CloseSessionView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1108, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	//Vista para cerrar sesion
	public void Cerrar() {
		panel = new JPanel();
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


		JPanel panelBtnCerrarSesion = new JPanel();
		panelBtnCerrarSesion.setBounds(324, 252, 243, 40);
		panelBtnCerrarSesion.setBackground(Color.decode("#A73737"));
		panelcontenedor.add(panelBtnCerrarSesion);
		panelBtnCerrarSesion.setLayout(null);

		//Boton cerrar sesion
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(0, 0, 243, 40);
		panelBtnCerrarSesion.add(btnCerrar);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setFont(new Font("Calibri", Font.BOLD, 19));
		btnCerrar.setFocusPainted(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setBackground(new Color(55, 104, 167));

		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(frame, "¿Está seguro de que desea cerrar sesión?","Confirmar cerrar",JOptionPane.YES_NO_OPTION);

				if (confirmResult == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(frame, "Su sesión ha sido cerrada con éxito", "Cerrar sesión", JOptionPane.INFORMATION_MESSAGE);
					
					Auth controller = new Auth();
					frame.dispose();
					controller.login();
				}	 
			}
		});


		JLabel lblTituloContenido = new JLabel("¿Desea cerrar sesión?");
		lblTituloContenido.setBounds(324, 149, 310, 29);
		panelcontenedor.add(lblTituloContenido);
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));

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
  		lblLogo.setIcon(new ImageIcon(getClass().getResource("/imgs/logo.png")));
  		

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
  		lblInicio.setIcon(new ImageIcon(getClass().getResource("/imgs/menu_inicio.png")));
  		
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
  		lblClientes.setIcon(new ImageIcon(getClass().getResource("/imgs/menu_cliente.png")));
  		
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
  		lblTarifas.setIcon(new ImageIcon(getClass().getResource("/imgs/menu_tarifa.png")));
  	      		panel_3.add(lblTarifas);

  		//Instructores
  		JPanel panel_4 = new JPanel();
  		panel_4.setBackground(new Color(33, 65, 119));
  		panel_4.setBounds(0, 217, 190, 58);
  		panel_4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
  		panelOpciones.add(panel_4);
  		panel_4.setLayout(null);

  		JButton btnInstructores = new JButton("         Instructores");
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
  		
  		lblInstructores.setIcon(new ImageIcon(getClass().getResource("/imgs/menu_instructor.png")));
  		
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
  		lblClases.setIcon(new ImageIcon(getClass().getResource("/imgs/menu_rutina.png")));
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
  		
  		lblChecador.setIcon(new ImageIcon(getClass().getResource("/imgs/menu_checador.png")));
  	
  		panel_6.add(lblChecador);

  		//Cerrrar sesion
  		JPanel panel_7 = new JPanel();
  		panel_7.setBackground(Color.decode("#3768A7"));
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
  		lblCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/imgs/menu_cerrar_sesion.png")));
  		
  		panel_7.add(lblCerrarSesion);

  		frame.getContentPane().add(panel);
  		frame.setVisible(true);
  		frame.repaint();
  		frame.revalidate();

	}
}