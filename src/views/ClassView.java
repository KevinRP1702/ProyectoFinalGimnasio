package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controllers.Auth;
import controllers.CheckController;
import controllers.ClassController;
import controllers.ClientController;
import controllers.FeeController;
import controllers.HomeController;
import controllers.InstructorController;
import models.ClassModel;



public class ClassView {

	private JFrame frame;
	String claseSeleccionada;

	public ClassView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1108, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}


	public void clase(List<List<Object>> clases) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//Contenido superior
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

		JLabel lblTituloContenido = new JLabel("Clases");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 160, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		
		// Crear un JComboBox en lugar de un JButton
		List<String> opcionesClases = new ArrayList<>();
		opcionesClases.add("Consultar");
		for (int i = 0; i < clases.size(); i++) {
		    String clase = clases.get(i).get(0).toString().replaceAll("[\\[\\]]", "");
		    opcionesClases.add(clase);
		}
		
		String[] opciones = opcionesClases.toArray(new String[0]);; 
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Calibri", Font.BOLD, 20));
		comboBox.setFocusable(false);
		comboBox.setBorder(BorderFactory.createLineBorder(Color.decode("#3768A7")));
		comboBox.setBackground(Color.decode("#3768A7"));
		comboBox.setBounds(682, 5, 190, 30);
	
		// Acción al seleccionar una opción en el JComboBox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					
				}else {
				claseSeleccionada = (String) comboBox.getSelectedItem();
				// Acción al seleccionar una opción
					ClassController controller = new ClassController();
					frame.dispose();
					controller.consultarClase(claseSeleccionada);
				}
			}
		});

		panelCabeceraContenido.add(comboBox);



		JPanel panelBotoncontenido_1 = new JPanel();
		panelBotoncontenido_1.setBackground(new Color(55, 104, 167));
		panelBotoncontenido_1.setBounds(465, 5, 190, 30);
		panelCabeceraContenido.add(panelBotoncontenido_1);
		panelBotoncontenido_1.setLayout(null);
		JLabel lblBotoncontenido = new JLabel();
		lblBotoncontenido.setBounds(10, 0, 26, 26);
		ImageIcon imageIcon_lblBotoncontenido = new ImageIcon("img/clase_crear.png");
		lblBotoncontenido.setIcon(imageIcon_lblBotoncontenido);
		panelBotoncontenido_1.add(lblBotoncontenido);
		
		
		JButton btnAgregarCliente = new JButton("    Agregar clase");
		btnAgregarCliente.setBounds(0, 0, 190, 30);
		panelBotoncontenido_1.add(btnAgregarCliente);
		btnAgregarCliente.setContentAreaFilled(false);
		btnAgregarCliente.setForeground(Color.WHITE);
		btnAgregarCliente.setFont(new Font("Calibri", Font.BOLD, 20));
		btnAgregarCliente.setFocusPainted(false);
		btnAgregarCliente.setBorderPainted(false);
		btnAgregarCliente.setBackground(new Color(55, 104, 167));
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción al hacer clic en el botón Crear clases
				ClassController controller = new ClassController();
				frame.dispose();
				controller.CrearClase();
			}
		});
		
		JPanel panelBotoncontenido_2 = new JPanel();
		panelBotoncontenido_2.setLayout(null);
		panelBotoncontenido_2.setBackground(new Color(55, 104, 167));
		panelBotoncontenido_2.setBounds(682, 5, 190, 30);
		panelCabeceraContenido.add(panelBotoncontenido_2);

		JLabel lblBotoncontenido_2 = new JLabel();
		lblBotoncontenido_2.setBounds(5, 3, 26, 26);
		ImageIcon imageIcon_lblBotoncontenido_2 = new ImageIcon("img/clase_descarga.png");
		lblBotoncontenido_2.setIcon(imageIcon_lblBotoncontenido_2);
		panelBotoncontenido_2.add(lblBotoncontenido_2);


		



		//Contenido inferior
		ClassModel datas = new ClassModel();
		List<List<Object>> datos = datas.get();
		String[] columnNames = {"Clase", "Instructor", "Integrantes"};
		Object[][] data = new Object[clases.size()][3];

		for(int i = 0; i < datos.size(); i++) {
			String clase = datos.get(i).get(0).toString().replaceAll("[\\[\\]]", "");
			String instructor = datos.get(i).get(1).toString().replaceAll("[\\[\\]]", "");
			String integrantes = datos.get(i).get(2).toString().replaceAll("[\\[\\]]", "");
			data[i][0] = clase;
			data[i][1] = instructor;
			data[i][2] = integrantes;
		}
		
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Hacer todas las celdas no editables
			}
		};
		
		JTable table = new JTable(model) {
			@Override
			public boolean getScrollableTracksViewportWidth() {
				return getPreferredSize().width < getParent().getWidth();
			}
		};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

		// Personalizar encabezado de la tabla
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.PLAIN, 18));
		header.setBackground(Color.decode("#214177"));
		header.setForeground(Color.WHITE);

		// Personalizar celdas
		table.setFont(new Font("Calibri", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);

	
		// Configurar que la tabla no sea editable
		table.setDefaultEditor(Object.class, null);

		// Mostrar la tabla en un JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 50, 862, 513);

		panelcontenedor.setLayout(null); 
		panelcontenedor.add(scrollPane);



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


		JButton btnClientes = new JButton(" Clientes");
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
		panel_5.setBackground(Color.decode("#3768A7"));
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

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}


	public void clasesCrear() {
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

		JLabel lblTituloContenido = new JLabel("Crear clase");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 160, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		JTextArea  textClasenombre = new JTextArea();
		textClasenombre.setFont(new Font("Calibri", Font.PLAIN, 18));
		textClasenombre.setBackground(Color.decode("#F5F5F5"));
		textClasenombre.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		TextPrompt prompt1 = new TextPrompt("Usuario", textClasenombre);
		prompt1.setText("Nombre de la clase");
		prompt1.setFont(new Font("Calibri", Font.PLAIN, 18));
		prompt1.setForeground(new Color(192, 192, 192));
		textClasenombre.setBounds(191, 200, 500, 40);
		textClasenombre.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.decode("#D4D4D4"), 1),
				new EmptyBorder(10, 10, 10, 10)  // Agregar padding
				));
		panelcontenedor.add(textClasenombre);

		JTextArea textClaseinstructor = new JTextArea();
		textClaseinstructor.setFont(new Font("Calibri", Font.PLAIN, 18));
		textClaseinstructor.setBackground(Color.decode("#F5F5F5"));
		textClaseinstructor.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		TextPrompt prompt2 = new TextPrompt("Usuario", textClaseinstructor);
		prompt2.setText("Nombre del instructor que repartirá la clase");
		prompt2.setFont(new Font("Calibri", Font.PLAIN, 18));
		prompt2.setForeground(new Color(192, 192, 192));
		textClaseinstructor.setBounds(191, 255, 502, 40);
		textClaseinstructor.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.decode("#D4D4D4"), 1),
				new EmptyBorder(10, 10, 10, 10)  // Agregar padding
				));
		panelcontenedor.add(textClaseinstructor);


		JButton btnCrearClases = new JButton("Registrar clase");
		btnCrearClases.setBounds(191, 320, 502, 40);
		panelcontenedor.add(btnCrearClases);
		btnCrearClases.setForeground(Color.WHITE);
		btnCrearClases.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCrearClases.setFocusPainted(false);
		btnCrearClases.setBorderPainted(false);
		btnCrearClases.setBackground(Color.decode("#214177"));
		btnCrearClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreClase = textClasenombre.getText().trim();
				String nombreInstructor = textClaseinstructor.getText().trim();

				if (nombreClase.isEmpty() || nombreInstructor.isEmpty()) {

					JOptionPane.showMessageDialog(frame, "Por favor, complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
				} else {
					
					ClassModel registro = new ClassModel();
					Boolean checar = registro.registroClase(nombreClase, nombreInstructor);
					if(checar == false) {
						JOptionPane.showMessageDialog(frame, "La clase se ha registrado con éxito.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
						ClassController controller = new ClassController();
						frame.dispose();
						controller.clase();
					}else {
						JOptionPane.showMessageDialog(frame, "La clase ya se encuentra registrada.", "Registro erroneo", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos de la clase");
		lblIngreseLosDatos.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblIngreseLosDatos.setBounds(277, 139, 328, 29);
		panelcontenedor.add(lblIngreseLosDatos);

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


		JButton btnClientes = new JButton(" Clientes");
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
		panel_5.setBackground(Color.decode("#3768A7"));
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
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Su cuenta ha sido cerrada.","Alerta de Cuenta Cerrada",JOptionPane.WARNING_MESSAGE);
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

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}

	public void consultarClase(String claseSeleccionada, List<List> clientesClases) {
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//Contenido superior
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



		//Boton agregar cliente
		JPanel panelBotoncontenido_1 = new JPanel();
		panelBotoncontenido_1.setBackground(new Color(55, 104, 167));
		panelBotoncontenido_1.setBounds(465, 5, 190, 30);
		panelCabeceraContenido.add(panelBotoncontenido_1);
		panelBotoncontenido_1.setLayout(null);

		JLabel lblBotoncontenido_1 = new JLabel();
		lblBotoncontenido_1.setBounds(10, 0, 26, 26);
		ImageIcon imageIcon_lblBotoncontenido_1 = new ImageIcon("img/clase_crear.png");
		lblBotoncontenido_1.setIcon(imageIcon_lblBotoncontenido_1);
		panelBotoncontenido_1.add(lblBotoncontenido_1);

		JButton btnAgregarCliente = new JButton("    Agregar cliente");
		btnAgregarCliente.setBounds(0, 0, 190, 30);
		panelBotoncontenido_1.add(btnAgregarCliente);
		btnAgregarCliente.setContentAreaFilled(false);
		btnAgregarCliente.setForeground(Color.WHITE);
		btnAgregarCliente.setFont(new Font("Calibri", Font.BOLD, 20));
		btnAgregarCliente.setFocusPainted(false);
		btnAgregarCliente.setBorderPainted(false);
		btnAgregarCliente.setBackground(new Color(55, 104, 167));
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassModel datos = new ClassModel();
				String idCliente = JOptionPane.showInputDialog("Ingrese el ID del cliente");
				
				boolean ingresarClase = datos.entrarClase(Integer.valueOf(idCliente), claseSeleccionada);
				
				if(ingresarClase == true) {
					JOptionPane.showMessageDialog(frame, "El cliente ya se encuentra registrado en la clase o no existe en la base de datos", "Error al ingresar", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(frame, "El cliente ha sido registrado con éxito", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
					ClassController controller = new ClassController();
					frame.dispose();
					controller.clase();
				}
			}
		});


		//Boton descargar cliente


		JPanel panelBotoncontenido_2 = new JPanel();
		panelBotoncontenido_2.setLayout(null);
		panelBotoncontenido_2.setBackground(new Color(55, 104, 167));
		panelBotoncontenido_2.setBounds(682, 5, 190, 30);
		panelCabeceraContenido.add(panelBotoncontenido_2);

		JLabel lblBotoncontenido_2 = new JLabel();
		lblBotoncontenido_2.setBounds(5, 3, 26, 26);
		ImageIcon imageIcon_lblBotoncontenido_2 = new ImageIcon("img/clase_descarga.png");
		lblBotoncontenido_2.setIcon(imageIcon_lblBotoncontenido_2);
		panelBotoncontenido_2.add(lblBotoncontenido_2);

		
		JButton btnDescargarCliente = new JButton("Descargar");
		btnDescargarCliente.setForeground(Color.WHITE);
		btnDescargarCliente.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDescargarCliente.setFocusPainted(false);
		btnDescargarCliente.setContentAreaFilled(false);
		btnDescargarCliente.setBorderPainted(false);
		btnDescargarCliente.setBackground(new Color(55, 104, 167));
		btnDescargarCliente.setBounds(0, 0, 190, 30);
		panelBotoncontenido_2.add(btnDescargarCliente);
		btnDescargarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassModel modelo = new ClassModel();
				modelo.pdf(claseSeleccionada);
				JOptionPane.showMessageDialog(frame, "El pdf ha sido descargado correctamente.", "Descarga exitosa", JOptionPane.INFORMATION_MESSAGE);
				ClassController controller = new ClassController();
				frame.dispose();
				controller.clase();
			}
		});


		//Contenido inferior
		ClassModel datos = new ClassModel();
		JButton btnEliminarClase = new JButton("Eliminar clase");
		btnEliminarClase.setFocusPainted(false);

		btnEliminarClase.setForeground(new Color(255, 255, 255));
		btnEliminarClase.setBackground(Color.decode("#A73737"));
        btnEliminarClase.setFont(new Font("Calibri", Font.BOLD, 20));
        btnEliminarClase.setBounds(713, 51, 138, 40);
        btnEliminarClase.setBorder(null);
        panelcontenedor.add(btnEliminarClase);
        btnEliminarClase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                int confirmResult = JOptionPane.showConfirmDialog(frame,
                        "¿Está seguro de que desea eliminar la clase?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);

            
                if (confirmResult == JOptionPane.YES_OPTION) {
                	datos.eliminar(claseSeleccionada);
                    JOptionPane.showMessageDialog(frame, "Clase eliminada exitosamente");
                    ClassController controller = new ClassController();
    				frame.dispose();
    				controller.clase();;
                }
            }
        });
	
		
		datos.clientesClases(claseSeleccionada);
		String[] columnNames = {"Nombre(s)", "Apellido(s)", "Cliente ID"};
		Object[][] data = new Object[clientesClases.size()][3];
		
		
		for(int i = 0; i < clientesClases.size(); i++) {
			String nombres = clientesClases.get(i).get(0).toString().replaceAll("[\\[\\]]", "");
			String apellidos = clientesClases.get(i).get(1).toString().replaceAll("[\\[\\]]", "");
			String correo = clientesClases.get(i).get(2).toString().replaceAll("[\\[\\]]", "");
			data[i][0] = nombres;
			data[i][1] = apellidos;
			data[i][2] = correo;
		}
		
		JLabel lblTituloContenido = new JLabel("Clase de: " + claseSeleccionada);
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 250, 29);
		panelCabeceraContenido.add(lblTituloContenido);
		
		JLabel lblInstructor = new JLabel("Instructor de la clase:" + datos.nombreEntrenador(claseSeleccionada));
		lblInstructor.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblInstructor.setBounds(10, 62, 582, 29);
		panelcontenedor.add(lblInstructor);

		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; 
			}
		};
		 
		JTable table = new JTable(model) {
			@Override
			public boolean getScrollableTracksViewportWidth() {
				return getPreferredSize().width < getParent().getWidth();
			}
		};
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);


		// Personalizar encabezado de la tabla
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.PLAIN, 18));
		header.setBackground(Color.decode("#214177"));
		header.setForeground(Color.WHITE);

		// Personalizar celdas
		table.setFont(new Font("Calibri", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false); 
		table.setDefaultEditor(Object.class, null);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 102, 862, 461);

		panelcontenedor.setLayout(null); 
		panelcontenedor.add(scrollPane);


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


		JButton btnClientes = new JButton(" Clientes");
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
		panel_5.setBackground(Color.decode("#3768A7"));
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
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,"Su cuenta ha sido cerrada.","Alerta de Cuenta Cerrada",JOptionPane.WARNING_MESSAGE);
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

		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();

	}


}
