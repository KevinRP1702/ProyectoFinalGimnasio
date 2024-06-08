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
import models.ClientModel;
import models.FeeModel;



public class ClientView {

	private JFrame frame;
	private JPanel panel;
	String userID;


	public ClientView(){
		frame = new JFrame();
		frame.setBounds(100, 100, 1108, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

	}

	public void cliente() {


		panel = new JPanel();
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
		/*
		for (int i = 0; i < clases.size(); i++) {
		    String clase = clases.get(i).get(0).toString().replaceAll("[\\[\\]]", "");
		    opcionesClases.add(clase);
		}
		 */

		String[] opciones = opcionesClases.toArray(new String[0]);;
		ImageIcon imageIcon_lblBotoncontenido = new ImageIcon("img/clase_crear.png");

		JPanel panelBotoncontenido_2 = new JPanel();
		panelBotoncontenido_2.setLayout(null);
		panelBotoncontenido_2.setBackground(new Color(55, 104, 167));
		panelBotoncontenido_2.setBounds(675, 5, 203, 30);
		panelCabeceraContenido.add(panelBotoncontenido_2);

		JLabel lblBotoncontenido_2 = new JLabel();
		lblBotoncontenido_2.setBounds(22, 3, 26, 26);
		ImageIcon imageIcon_lblBotoncontenido_2 = new ImageIcon("img/cliente_lupa.png");
		lblBotoncontenido_2.setIcon(imageIcon_lblBotoncontenido_2);
		panelBotoncontenido_2.add(lblBotoncontenido_2);


		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(0, -1, 203, 30);
		panelBotoncontenido_2.add(btnConsultar);
		btnConsultar.setContentAreaFilled(false);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnConsultar.setFocusPainted(false);
		btnConsultar.setBorderPainted(false);
		btnConsultar.setBackground(new Color(55, 104, 167));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 userID = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario:", "Solicitud de ID", JOptionPane.QUESTION_MESSAGE);

				// Mostrar el ID ingresado (para confirmar que se ha capturado correctamente)
				if (userID != null && !userID.trim().isEmpty()) {
					ClientModel model = new ClientModel();
					
					if(model.datosClientes(Integer.parseInt(userID)) == null) {
						JOptionPane.showMessageDialog(null, "No se encontró el ID del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						ClientController controller = new ClientController();
						frame.dispose();
						
						controller.consultar(Integer.parseInt(userID));
					}
				} else {
					JOptionPane.showMessageDialog(null, "No se ingresó ningún ID.", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		JPanel panelBotoncontenido_1 = new JPanel();
		panelBotoncontenido_1.setLayout(null);
		panelBotoncontenido_1.setBackground(new Color(55, 104, 167));
		panelBotoncontenido_1.setBounds(462, 5, 203, 30);
		panelCabeceraContenido.add(panelBotoncontenido_1);

		JLabel lblBotoncontenido_1 = new JLabel();
		lblBotoncontenido_1.setBounds(33, 3, 26, 26);
		ImageIcon icon = new ImageIcon("img/cliente_Usar.png"); 
		lblBotoncontenido_1.setIcon(icon);
		panelBotoncontenido_1.add(lblBotoncontenido_1);

		JButton btnCrearCliente = new JButton("Crear");
		btnCrearCliente.setForeground(Color.WHITE);
		btnCrearCliente.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCrearCliente.setFocusPainted(false);
		btnCrearCliente.setContentAreaFilled(false);
		btnCrearCliente.setBorderPainted(false);
		btnCrearCliente.setBackground(new Color(55, 104, 167));
		btnCrearCliente.setBounds(0, -1, 203, 30);
		panelBotoncontenido_1.add(btnCrearCliente);
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientController controller = new ClientController();
				frame.dispose();
				controller.crearCliente();
			}
		});

		//Contenido inferior
		ClientModel datas = new ClientModel();
		ArrayList<String[]> datosClientes = datas.obtenerDatosClientes();
		String[] columnNames = {"Cliente ID", "Nombre(s)", "Apellidos", "Correo"};
		Object[][] data = new Object[datosClientes.size()][4];

		for (int i = 0; i < datosClientes.size(); i++) {
			String[] datos = datosClientes.get(i);
		    data[i][0] = datos[0];
		    data[i][1] = datos[1];
		    data[i][2] = datos[2];
		    data[i][3] = datos[3];
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

		/*
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
		 */
		vistaComun();


	}
	public void crearClientesFoto() {
		panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//Contenido
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

		JLabel lblTituloContenido = new JLabel("Crear clientes");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 160, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		JLabel lblSeleccionaUnaFoto = new JLabel("Selecciona una foto de perfil");
		lblSeleccionaUnaFoto.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblSeleccionaUnaFoto.setBounds(301, 97, 337, 29);
		panelcontenedor.add(lblSeleccionaUnaFoto);

		vistaComun();
	}
	public void crearClientes() {
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

		JLabel lblTituloContenido = new JLabel("Crear cliente");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 160, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		JTextArea  textClienteNombre = new JTextArea();
		textClienteNombre.setFont(new Font("Calibri", Font.PLAIN, 18));
		textClienteNombre.setBackground(Color.decode("#F5F5F5"));
		textClienteNombre.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		TextPrompt prompt1 = new TextPrompt("Nombre(s)", textClienteNombre);
		prompt1.setFont(new Font("Calibri", Font.PLAIN, 18));
		prompt1.setForeground(new Color(192, 192, 192));
		textClienteNombre.setBounds(191, 116, 500, 40);
		textClienteNombre.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.decode("#D4D4D4"), 1),
				new EmptyBorder(10, 10, 10, 10)  // Agregar padding
				));
		panelcontenedor.add(textClienteNombre);

		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del cliente");
		lblIngreseLosDatos.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblIngreseLosDatos.setBounds(276, 66, 328, 29);
		panelcontenedor.add(lblIngreseLosDatos);

		JTextArea textClienteApellidos = new JTextArea();
		textClienteApellidos.setFont(new Font("Calibri", Font.PLAIN, 18));
		textClienteApellidos.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		textClienteApellidos.setBackground(new Color(245, 245, 245));
		textClienteApellidos.setBounds(191, 175, 500, 40);
		TextPrompt prompt2 = new TextPrompt("Apellidos(s)", textClienteApellidos);
		prompt2.setFont(new Font("Calibri", Font.PLAIN, 18));
		prompt2.setForeground(new Color(192, 192, 192));
		textClienteApellidos.setBounds(191, 175, 500, 40);
		textClienteApellidos.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.decode("#D4D4D4"), 1),
				new EmptyBorder(10, 10, 10, 10)  // Agregar padding
				));

		panelcontenedor.add(textClienteApellidos);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Calibri", Font.PLAIN, 19));
		lblFechaDeNacimiento.setBounds(191, 245, 328, 29);
		panelcontenedor.add(lblFechaDeNacimiento);


		// Valores predefinidos para los ComboBox
		String[] dias = {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
		};

		String[] meses = {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
		};

		String[] años = {
				"1964", "1965", "1966", "1967", "1968", "1969",
				"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
				"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
				"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
				"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
				"2020", "2021", "2022", "2023", "2024"
		};

		
		// Crear y configurar los ComboBox para día, mes y año

		JComboBox<String> diaComboBox = new JComboBox<>(dias);
		diaComboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		diaComboBox.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		diaComboBox.setBackground(Color.decode("#F5F5F5"));
		diaComboBox.setBounds(191, 277, 150, 40);
		panelcontenedor.add(diaComboBox);

		JComboBox<String> mesComboBox = new JComboBox<>(meses);
		mesComboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		mesComboBox.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		mesComboBox.setBackground(Color.decode("#F5F5F5"));
		mesComboBox.setBounds(369, 277, 150, 40);
		panelcontenedor.add(mesComboBox);

		JComboBox<String> añoComboBox = new JComboBox<>(años);
		añoComboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		añoComboBox.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		añoComboBox.setBackground(Color.decode("#F5F5F5"));
		añoComboBox.setBounds(541, 277, 150, 40);
		panelcontenedor.add(añoComboBox);

		JTextArea textNumeroCliente = new JTextArea();
		textNumeroCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		textNumeroCliente.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		textNumeroCliente.setBackground(new Color(245, 245, 245));
		textNumeroCliente.setBounds(191, 350, 500, 40);
		TextPrompt prompt4 = new TextPrompt("Número de teléfono", textNumeroCliente);
		prompt4.setFont(new Font("Calibri", Font.PLAIN, 18));
		prompt4.setForeground(new Color(192, 192, 192));
		textNumeroCliente.setBounds(191, 350, 500, 40);
		textNumeroCliente.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.decode("#D4D4D4"), 1),
				new EmptyBorder(10, 10, 10, 10)  // Agregar padding
				));

		panelcontenedor.add(textNumeroCliente);

		JTextArea textCorreoCliente = new JTextArea();
		textCorreoCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		textCorreoCliente.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
		textCorreoCliente.setBackground(new Color(245, 245, 245));
		textCorreoCliente.setBounds(191, 409, 500, 40);
		TextPrompt prompt3 = new TextPrompt("Correo electrónico", textCorreoCliente);
		prompt3.setFont(new Font("Calibri", Font.PLAIN, 18));
		prompt3.setForeground(new Color(192, 192, 192));
		textCorreoCliente.setBounds(191, 409, 500, 40);
		textCorreoCliente.setBorder(BorderFactory.createCompoundBorder(
				new LineBorder(Color.decode("#D4D4D4"), 1),
				new EmptyBorder(10, 10, 10, 10)  // Agregar padding
				));
		panelcontenedor.add(textCorreoCliente);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(191, 476, 500, 40);
		panelcontenedor.add(panel_1);
		panel_1.setLayout(null);

		JButton btnCrearClases = new JButton("Registrar cliente");
		btnCrearClases.setBounds(0, 0, 502, 40);
		panel_1.add(btnCrearClases);
		btnCrearClases.setForeground(Color.WHITE);
		btnCrearClases.setFont(new Font("Calibri", Font.BOLD, 20));
		btnCrearClases.setFocusPainted(false);
		btnCrearClases.setBorderPainted(false);
		btnCrearClases.setBackground(Color.decode("#214177"));
		btnCrearClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientModel modelo = new ClientModel();
				String fecha = (String) añoComboBox.getSelectedItem() + "-" + (String) mesComboBox.getSelectedItem() + "-" + (String) diaComboBox.getSelectedItem();

				if(modelo.registrarCliente(textClienteNombre.getText(), textClienteApellidos.getText(), fecha, Integer.parseInt(textNumeroCliente.getText()), textCorreoCliente.getText()) == false) {
					JOptionPane.showMessageDialog(null, "El cliente ya se encuentra en la base", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "El cliente se creó correctamente", "Cliente creado", JOptionPane.INFORMATION_MESSAGE);
					ClientController controller = new ClientController();
					frame.dispose();
					controller.cliente();
				}
			}
		});

		vistaComun();
	}
	
	public void informacionClientes(int idUsuario) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//Contenido
		JPanel panelcontenedor1 =new JPanel();
		panelcontenedor1.setBackground(Color.decode("#FFFFFF"));
		panelcontenedor1.setBounds(210, 86, 882, 574);
		panel.add(panelcontenedor1);
		panelcontenedor1.setLayout(null);

		JPanel panelCabeceraContenido = new JPanel();
		panelCabeceraContenido.setLayout(null);
		panelCabeceraContenido.setBackground(new Color(188, 218, 242));
		panelCabeceraContenido.setBounds(0, 0, 882, 40);
		panelcontenedor1.add(panelCabeceraContenido);

		JLabel lblTituloContenido = new JLabel("Información del cliente");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 447, 29);
		panelCabeceraContenido.add(lblTituloContenido);

		JPanel panelBtnEditarUsuario = new JPanel();
		panelCabeceraContenido.add(panelBtnEditarUsuario);
		panelBtnEditarUsuario.setBackground(new Color(55, 104, 167));
		panelBtnEditarUsuario.setBounds(682, 5, 190, 30);
		panelBtnEditarUsuario.setLayout(null);

		//boton para editar cliente
		JButton btnEditarCliente = new JButton("Editar cliente");
		btnEditarCliente.setBounds(0, 0, 190, 30);
		panelBtnEditarUsuario.add(btnEditarCliente);
		btnEditarCliente.setContentAreaFilled(false);
		btnEditarCliente.setForeground(Color.WHITE);
		btnEditarCliente.setFont(new Font("Calibri", Font.BOLD, 20));
		btnEditarCliente.setFocusPainted(false);
		btnEditarCliente.setBorderPainted(false);
		btnEditarCliente.setBackground(new Color(55, 104, 167));
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientController controller = new ClientController();
				frame.dispose();
				
				controller.editar(idUsuario);
			}
		});

		ClientModel modelo = new ClientModel();
		ArrayList<String> datosCliente = modelo.datosClientes(idUsuario);

		JLabel lblNombreCliente = new JLabel("Nombre(s):");
		lblNombreCliente.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNombreCliente.setBounds(10, 70, 114, 23);
		panelcontenedor1.add(lblNombreCliente);

		JLabel lblApellidosCliente = new JLabel("Apellido(s)");
		lblApellidosCliente.setFont(new Font("Calibri", Font.BOLD, 18));
		lblApellidosCliente.setBounds(10, 135, 114, 23);
		panelcontenedor1.add(lblApellidosCliente);

		JLabel lblCorreoCliente = new JLabel("Correo electrónico:");
		lblCorreoCliente.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCorreoCliente.setBounds(10, 330, 212, 23);
		panelcontenedor1.add(lblCorreoCliente);

		JLabel lblClienteId = new JLabel("Cliente id:");
		lblClienteId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblClienteId.setBounds(10, 395, 120, 23);
		panelcontenedor1.add(lblClienteId);

		JLabel lblFinalizacinMembresia = new JLabel("Fecha de nacimiento");
		lblFinalizacinMembresia.setFont(new Font("Calibri", Font.BOLD, 18));
		lblFinalizacinMembresia.setBounds(10, 200, 244, 23);
		panelcontenedor1.add(lblFinalizacinMembresia);

		JLabel lblEstadoMembresia = new JLabel("Estado de membresía:");
		lblEstadoMembresia.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEstadoMembresia.setBounds(10, 265, 189, 23);
		panelcontenedor1.add(lblEstadoMembresia);

		JLabel lblNombreClienteCambia = new JLabel(datosCliente.get(0));
		lblNombreClienteCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNombreClienteCambia.setBounds(218, 70, 114, 23);
		panelcontenedor1.add(lblNombreClienteCambia);

		JLabel lblApellidosClienteCambia = new JLabel(datosCliente.get(1));
		lblApellidosClienteCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblApellidosClienteCambia.setBounds(218, 135, 114, 23);
		panelcontenedor1.add(lblApellidosClienteCambia);

		JLabel lblClienteIdCambia = new JLabel(datosCliente.get(4));
		lblClienteIdCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblClienteIdCambia.setBounds(218, 395, 120, 23);
		panelcontenedor1.add(lblClienteIdCambia);

		JLabel lblcorreoCambia = new JLabel(datosCliente.get(3));
		lblcorreoCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblcorreoCambia.setBounds(218, 330, 212, 23);
		panelcontenedor1.add(lblcorreoCambia);

		JLabel lblFecha_nacimiento = new JLabel(datosCliente.get(2));
		lblFecha_nacimiento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblFecha_nacimiento.setBounds(218, 200, 244, 23);
		panelcontenedor1.add(lblFecha_nacimiento);

		JLabel lblEstadoMembresiaCambio = new JLabel("Activo");
		lblEstadoMembresiaCambio.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstadoMembresiaCambio.setBounds(217, 265, 189, 23);
		panelcontenedor1.add(lblEstadoMembresiaCambio);

		JLabel lblAvatarCliente = new JLabel("");
		lblAvatarCliente.setOpaque(true);
		lblAvatarCliente.setBackground(new Color(0, 0, 64));
		lblAvatarCliente.setBounds(614, 138, 160, 160);
		ImageIcon imageIcon = new ImageIcon("img/pfp1.png"); 
		lblAvatarCliente.setIcon(imageIcon);

		panelcontenedor1.add(lblAvatarCliente);

		JPanel panelDescargarCredencial = new JPanel();
		panelDescargarCredencial.setLayout(null);
		panelDescargarCredencial.setBackground(new Color(55, 104, 167));
		panelDescargarCredencial.setBounds(590, 342, 210, 40);
		panelcontenedor1.add(panelDescargarCredencial);

		//Boton para descargar credencial
		JButton btnDescargarCredencial = new JButton("Descargar credencial");
		btnDescargarCredencial.setVerticalAlignment(SwingConstants.BOTTOM);
		btnDescargarCredencial.setBounds(0, 0, 210, 40);
		panelDescargarCredencial.add(btnDescargarCredencial);
		btnDescargarCredencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDescargarCredencial.setForeground(Color.WHITE);
		btnDescargarCredencial.setFont(new Font("Calibri", Font.BOLD, 20));
		btnDescargarCredencial.setFocusPainted(false);
		btnDescargarCredencial.setContentAreaFilled(false);
		btnDescargarCredencial.setBorderPainted(false);
		btnDescargarCredencial.setBackground(new Color(55, 104, 167));


		JPanel panelEliminarCuenta = new JPanel();
		panelEliminarCuenta.setLayout(null);
		panelEliminarCuenta.setBackground(Color.decode("#A73737"));
		panelEliminarCuenta.setBounds(590, 410, 210, 40);
		panelcontenedor1.add(panelEliminarCuenta);

		//Botono para eliminar cuenta
		JButton btnEliminarCuenta = new JButton("Eliminar cuenta");
		btnEliminarCuenta.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEliminarCuenta.setBounds(0, 0, 210, 40);
		panelEliminarCuenta.add(btnEliminarCuenta);
		btnEliminarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(modelo.eliminarCliente(idUsuario) == false) {
					JOptionPane.showMessageDialog(null, "El cliente no se encuentra en la base", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "El cliente ha sido eliminado con éxito", "Eliminado con éxito", JOptionPane.INFORMATION_MESSAGE);
					ClientController controller = new ClientController();
					frame.dispose();
					controller.cliente();
				}
			}
		});
		btnEliminarCuenta.setForeground(Color.WHITE);
		btnEliminarCuenta.setFont(new Font("Calibri", Font.BOLD, 20));
		btnEliminarCuenta.setFocusPainted(false);
		btnEliminarCuenta.setContentAreaFilled(false);
		btnEliminarCuenta.setBorderPainted(false);
		btnEliminarCuenta.setBackground(new Color(55, 104, 167));

		vistaComun();


	}
	
	public void clienteEditar(int idCliente) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Contenido
		
				JPanel panelcontenedor1 = new JPanel();
				panelcontenedor1.setBackground(Color.decode("#FFFFFF"));
				panelcontenedor1.setBounds(210, 86, 882, 574);
				panel.add(panelcontenedor1);
				panelcontenedor1.setLayout(null);


				JPanel panelCabeceraContenido = new JPanel();
				panelCabeceraContenido.setLayout(null);
				panelCabeceraContenido.setBackground(new Color(188, 218, 242));
				panelCabeceraContenido.setBounds(0, 0, 882, 40);
				panelcontenedor1.add(panelCabeceraContenido);

				JLabel lblTituloContenido = new JLabel("Información del cliente");
				lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
				lblTituloContenido.setBounds(10, 11, 447, 29);
				panelCabeceraContenido.add(lblTituloContenido);


				JPanel panelBtnCancelar = new JPanel();
				panelBtnCancelar.setLayout(null);
				panelBtnCancelar.setBackground(Color.decode("#A73737"));
				panelBtnCancelar.setBounds(470, 5, 190, 30);
				panelCabeceraContenido.add(panelBtnCancelar);

				//Boton para cancelar cambios
				JButton btnCancelarCambios = new JButton("Cancelar cambios");

				btnCancelarCambios.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnCancelarCambios.setBorderPainted(false);
				btnCancelarCambios.setForeground(Color.WHITE);
				btnCancelarCambios.setFont(new Font("Calibri", Font.BOLD, 20));
				btnCancelarCambios.setFocusPainted(false);
				btnCancelarCambios.setContentAreaFilled(false);
				btnCancelarCambios.setBackground(new Color(55, 104, 167));
				btnCancelarCambios.setBounds(0, 0, 190, 30);
				panelBtnCancelar.add(btnCancelarCambios);
				btnCancelarCambios.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ClientController controller = new ClientController();
						frame.dispose();
						controller.cliente();
					}
				});

				//Contenido del cliente
				JLabel lblNombreCliente = new JLabel("Nombre(s):");
				lblNombreCliente.setFont(new Font("Calibri", Font.BOLD, 18));
				lblNombreCliente.setBounds(10, 70, 114, 23);
				panelcontenedor1.add(lblNombreCliente);

				JLabel lblApellidosCliente = new JLabel("Apellido(s)");
				lblApellidosCliente.setFont(new Font("Calibri", Font.BOLD, 18));
				lblApellidosCliente.setBounds(10, 135, 114, 23);
				panelcontenedor1.add(lblApellidosCliente);

				JLabel lblCorreoCliente = new JLabel("Correo electrónico(s)");
				lblCorreoCliente.setFont(new Font("Calibri", Font.BOLD, 18));
				lblCorreoCliente.setBounds(10, 330, 189, 23);
				panelcontenedor1.add(lblCorreoCliente);

				JLabel lblClienteId = new JLabel("Cliente id:");
				lblClienteId.setFont(new Font("Calibri", Font.BOLD, 18));
				lblClienteId.setBounds(10, 395, 120, 23);
				panelcontenedor1.add(lblClienteId);

				JLabel lblFinalizacinMembresia = new JLabel("Fecha de nacimiento");
				lblFinalizacinMembresia.setFont(new Font("Calibri", Font.BOLD, 18));
				lblFinalizacinMembresia.setBounds(10, 200, 175, 23);
				panelcontenedor1.add(lblFinalizacinMembresia);

				JLabel lblNumeroCliente = new JLabel("Número de teléfono");
				lblNumeroCliente.setFont(new Font("Calibri", Font.BOLD, 18));
				lblNumeroCliente.setBounds(10, 265, 189, 23);
				panelcontenedor1.add(lblNumeroCliente);

				JLabel lblAvatarCliente = new JLabel("");
				lblAvatarCliente.setOpaque(true);
				lblAvatarCliente.setBackground(new Color(0, 0, 64));
				lblAvatarCliente.setBounds(614, 138, 160, 160);
				ImageIcon imageIcon = new ImageIcon("img/logo.png"); 
				lblAvatarCliente.setIcon(imageIcon);
				panelcontenedor1.add(lblAvatarCliente);


				JTextArea textNombreCliente = new JTextArea();
				textNombreCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
				textNombreCliente.setBackground(Color.decode("#F5F5F5"));
				textNombreCliente.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
				textNombreCliente.setBounds(192, 70, 320, 25);
				textNombreCliente.setBorder(BorderFactory.createCompoundBorder(
						new LineBorder(Color.decode("#D4D4D4"), 1),
						new EmptyBorder(10, 10, 10, 10)  
						));
				panelcontenedor1.add(textNombreCliente);

				JTextArea textApellidosCliente = new JTextArea();
				textApellidosCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
				textApellidosCliente.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
				textApellidosCliente.setBackground(new Color(245, 245, 245));
				textApellidosCliente.setBounds(192, 133, 320, 25);
				panelcontenedor1.add(textApellidosCliente);


				// Valores predefinidos para los ComboBox
				String[] dias = {
						"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
						"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
						"21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
				};

				String[] meses = {
						"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
				};

				String[] años = {
						"1964", "1965", "1966", "1967", "1968", "1969",
						"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
						"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
						"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
						"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
						"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
						"2020", "2021", "2022", "2023", "2024"
				};

				// Crear y configurar los ComboBox para día, mes y año

				JComboBox<String> diaComboBox = new JComboBox<>(dias);
				diaComboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
				diaComboBox.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
				diaComboBox.setBackground(Color.decode("#F5F5F5"));
				diaComboBox.setBounds(192, 198, 93, 25);
				panelcontenedor1.add(diaComboBox);

				JComboBox<String> mesComboBox = new JComboBox<>(meses);
				mesComboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
				mesComboBox.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
				mesComboBox.setBackground(Color.decode("#F5F5F5"));
				mesComboBox.setBounds(312, 198, 93, 25);
				panelcontenedor1.add(mesComboBox);

				JComboBox<String> añoComboBox = new JComboBox<>(años);
				añoComboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
				añoComboBox.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
				añoComboBox.setBackground(Color.decode("#F5F5F5"));
				añoComboBox.setBounds(419, 198, 93, 25);
				panelcontenedor1.add(añoComboBox);

				String fecha = (String) añoComboBox.getSelectedItem() + "-" + (String) mesComboBox.getSelectedItem() + "-" + (String) diaComboBox.getSelectedItem();
				
				JTextArea textNumeroCliente = new JTextArea();
				textNumeroCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
				textNumeroCliente.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
				textNumeroCliente.setBackground(new Color(245, 245, 245));
				textNumeroCliente.setBounds(192, 263, 320, 25);
				panelcontenedor1.add(textNumeroCliente);

				JTextArea textCorreoCliente = new JTextArea();
				textCorreoCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
				textCorreoCliente.setBorder(new LineBorder(Color.decode("#D4D4D4"), 1));
				textCorreoCliente.setBackground(new Color(245, 245, 245));
				textCorreoCliente.setBounds(192, 328, 320, 25);
				panelcontenedor1.add(textCorreoCliente);

				JLabel lblClienteId_1 = new JLabel("Cliente id:" + idCliente);
				lblClienteId_1.setFont(new Font("Calibri", Font.PLAIN, 18));
				lblClienteId_1.setBounds(192, 398, 120, 23);
				panelcontenedor1.add(lblClienteId_1);


				JPanel panelBtnGuardar = new JPanel();
				panelCabeceraContenido.add(panelBtnGuardar);
				panelBtnGuardar.setBackground(new Color(55, 104, 167));
				panelBtnGuardar.setBounds(682, 5, 190, 30);
				panelBtnGuardar.setLayout(null);

				//Boton para confirmar cambios
				JButton btnGuardar = new JButton("Confirmar cambios");
				btnGuardar.setBounds(0, 0, 190, 30);
				panelBtnGuardar.add(btnGuardar);
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (textNombreCliente.getText().isEmpty() ||
								textApellidosCliente.getText().isEmpty() ||
								textNumeroCliente.getText().isEmpty() ||
								textCorreoCliente.getText().isEmpty() ) {

							JOptionPane.showMessageDialog(frame, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							ClientModel model = new ClientModel();
							ClientController controller = new ClientController();
							
							model.editarCliente(idCliente, textNombreCliente.getText(), textApellidosCliente.getText(), fecha, textCorreoCliente.getText(), textNumeroCliente.getText());
							JOptionPane.showMessageDialog(frame, "Cambios confirmados.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
							controller.cliente();
							
						}
					}
				});

				btnGuardar.setContentAreaFilled(false);
				btnGuardar.setForeground(Color.WHITE);
				btnGuardar.setFont(new Font("Calibri", Font.BOLD, 18));
				btnGuardar.setFocusPainted(false);
				btnGuardar.setBorderPainted(false);
				btnGuardar.setBackground(new Color(55, 104, 167));
		vistaComun();
	}

	public void vistaComun(){
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
		ImageIcon imageIcon = new ImageIcon("src/logo.png"); 
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
		panel_2.setBackground(Color.decode("#3768A7"));
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
}