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
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
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
import models.FeeModel;



public class FeeView {

	private JFrame frame;
	private JPanel panel;
	String userID;
	int monto = 0;


	public FeeView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1108, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

	}

	//Vista principal de tarifas
	public void tarifa() {
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

		JLabel lblTituloContenido = new JLabel("Tarifa");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 160, 29);
		panelCabeceraContenido.add(lblTituloContenido);



		List<String> opcionesClases = new ArrayList<>();
		opcionesClases.add("Consultar");


		String[] opciones = opcionesClases.toArray(new String[0]);;
		ImageIcon imageIcon_lblBotoncontenido = new ImageIcon("img/clase_crear.png");

		JPanel panelBotoncontenido_2 = new JPanel();
		panelBotoncontenido_2.setLayout(null);
		panelBotoncontenido_2.setBackground(new Color(55, 104, 167));
		panelBotoncontenido_2.setBounds(675, 5, 203, 30);
		panelCabeceraContenido.add(panelBotoncontenido_2);

		JLabel lblBotoncontenido_2 = new JLabel();
		lblBotoncontenido_2.setBounds(0, 3, 26, 26);
		ImageIcon imageIcon_lblBotoncontenido_2 = new ImageIcon("img/tarifa_pagar.png");
		lblBotoncontenido_2.setIcon(imageIcon_lblBotoncontenido_2);
		panelBotoncontenido_2.add(lblBotoncontenido_2);

		//Boton para agregar cliente
		JButton btnAgregarCliente = new JButton("Pagar membresía");
		btnAgregarCliente.setBounds(0, -1, 203, 30);
		panelBotoncontenido_2.add(btnAgregarCliente);
		btnAgregarCliente.setContentAreaFilled(false);
		btnAgregarCliente.setForeground(Color.WHITE);
		btnAgregarCliente.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAgregarCliente.setFocusPainted(false);
		btnAgregarCliente.setBorderPainted(false);
		btnAgregarCliente.setBackground(new Color(55, 104, 167));
		
		JPanel panelBotonEliminarPago = new JPanel();
		panelBotonEliminarPago.setLayout(null);
		panelBotonEliminarPago.setBackground(Color.decode("#A73737"));
		panelBotonEliminarPago.setBounds(451, 5, 203, 30);
		panelCabeceraContenido.add(panelBotonEliminarPago);
		
		JButton btnEliminarPago = new JButton("Eliminar pago");
		btnEliminarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmResult = JOptionPane.showConfirmDialog(frame, "¿Está seguro de que desea eliminar el pago?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);


				if (confirmResult == JOptionPane.YES_OPTION) {
				userID = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario:", "Solicitud de ID", JOptionPane.QUESTION_MESSAGE);
				// Mostrar el ID ingresado (para confirmar que se ha capturado correctamente)
				if (userID != null && !userID.trim().isEmpty()) {
					FeeModel model = new FeeModel();

					
					if(model.eliminarPago(Integer.parseInt(userID)) == false) {
						JOptionPane.showMessageDialog(null, "No se encontró el ID del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						
						FeeController controller = new FeeController();
						JOptionPane.showMessageDialog(null, "El pago se eliminó con éxito.", "Eliminación con éxito", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						
						controller.tarifa();
					}
				} else {
					JOptionPane.showMessageDialog(null, "No se ingresó ningún ID.", "Error", JOptionPane.ERROR_MESSAGE);
				
				}
			}
			}
		});
		btnEliminarPago.setForeground(Color.WHITE);
		btnEliminarPago.setFont(new Font("Calibri", Font.BOLD, 18));
		btnEliminarPago.setFocusPainted(false);
		btnEliminarPago.setContentAreaFilled(false);
		btnEliminarPago.setBorderPainted(false);
		btnEliminarPago.setBackground(new Color(55, 104, 167));
		btnEliminarPago.setBounds(0, -1, 203, 30);
		panelBotonEliminarPago.add(btnEliminarPago);
		
		btnAgregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userID = JOptionPane.showInputDialog(null, "Ingrese el ID del usuario:", "Solicitud de ID", JOptionPane.QUESTION_MESSAGE);
				// Mostrar el ID ingresado (para confirmar que se ha capturado correctamente)
				if (userID != null && !userID.trim().isEmpty()) {
					FeeModel model = new FeeModel();

					if(model.datosClientes(Integer.parseInt(userID)) == null) {
						JOptionPane.showMessageDialog(null, "No se encontró el ID del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
					}else {
						
						FeeController controller = new FeeController();
						frame.dispose();
						controller.pagar(Integer.parseInt(userID));
					}
				} else {
					JOptionPane.showMessageDialog(null, "No se ingresó ningún ID.", "Error", JOptionPane.ERROR_MESSAGE);
				}


			}
		});


		//Contenido inferior
		FeeModel datas = new FeeModel();
		ArrayList<String[]> datos = datas.obtenerDatosPagos();

		//Tabla para clientes
		String[] columnNames = {"Nombres", "Apellido", "Pago", "ID Usuario"};
		Object[][] data = new Object[datos.size()][4];

		for (int i = 0; i < datos.size(); i++) {
			String[] pago = datos.get(i);
			//String primerNombre = pago[0].split(" ")[0];

			data[i][0] = pago[0]; 
			data[i][1] = pago[1]; 
			data[i][2] = "$" + pago[2]; 
			data[i][3] = pago[3]; 

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

		//Personalizar encabezado de la tabla
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Calibri", Font.PLAIN, 18));
		header.setBackground(Color.decode("#214177"));
		header.setForeground(Color.WHITE);

		//Personalizar celdas
		table.setFont(new Font("Calibri", Font.PLAIN, 16));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);

		//Configurar que la tabla no sea editable
		table.setDefaultEditor(Object.class, null);

		//Mostrar la tabla en un JScrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 50, 862, 513);

		panelcontenedor.setLayout(null); 
		panelcontenedor.add(scrollPane);



		vistaComun();


	}
	//Vista para pagar
	public void tarifaPago(int idUsuario) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1092, 660);
		panel.setBackground(Color.decode("#F2F2F2"));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		//Contenido
		FeeModel modelo = new FeeModel();
		ArrayList<String> datosCliente = modelo.datosClientes(idUsuario);
		JPanel panelcontenedor1 =new JPanel();
		panelcontenedor1.setBackground(Color.decode("#FFFFFF"));
		panelcontenedor1.setBounds(200, 75, 455, 574);
		panel.add(panelcontenedor1);
		panelcontenedor1.setLayout(null);

		JPanel panelCabeceraContenido = new JPanel();
		panelCabeceraContenido.setLayout(null);
		panelCabeceraContenido.setBackground(new Color(188, 218, 242));
		panelCabeceraContenido.setBounds(0, 0, 455, 40);
		panelcontenedor1.add(panelCabeceraContenido);

		//Toda la informacion del cliente
		JLabel lblTituloContenido = new JLabel("Datos del usuario");
		lblTituloContenido.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido.setBounds(10, 11, 447, 29);
		panelCabeceraContenido.add(lblTituloContenido);


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
		lblCorreoCliente.setBounds(10, 200, 212, 23);
		panelcontenedor1.add(lblCorreoCliente);

		JLabel lblClienteId = new JLabel("Cliente id:");
		lblClienteId.setFont(new Font("Calibri", Font.BOLD, 18));
		lblClienteId.setBounds(10, 265, 120, 23);
		panelcontenedor1.add(lblClienteId);

		JLabel lblEstadoMembresia = new JLabel("Estado de membresía:");
		lblEstadoMembresia.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEstadoMembresia.setBounds(10, 340, 189, 23);
		panelcontenedor1.add(lblEstadoMembresia);

		JLabel lblNombreClienteCambia = new JLabel(datosCliente.get(0));
		lblNombreClienteCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNombreClienteCambia.setBounds(110, 70, 335, 23);
		panelcontenedor1.add(lblNombreClienteCambia);

		JLabel lblApellidosClienteCambia = new JLabel(datosCliente.get(1));
		lblApellidosClienteCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblApellidosClienteCambia.setBounds(108, 135, 337, 23);
		panelcontenedor1.add(lblApellidosClienteCambia);

		JLabel lblCorreoClienteCambia = new JLabel(datosCliente.get(2));
		lblCorreoClienteCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCorreoClienteCambia.setBounds(173, 200, 272, 23);
		panelcontenedor1.add(lblCorreoClienteCambia);

		JLabel lblClienteIdCambia = new JLabel(datosCliente.get(3));
		lblClienteIdCambia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblClienteIdCambia.setBounds(87, 265, 358, 23);
		panelcontenedor1.add(lblClienteIdCambia);

		if(modelo.estadoMembresia(idUsuario) == false) {
			JLabel lblEstadoMembresiaCambio = new JLabel("Inactiva");
			lblEstadoMembresiaCambio.setFont(new Font("Calibri", Font.PLAIN, 18));
			lblEstadoMembresiaCambio.setBounds(196, 460, 233, 23);
			panelcontenedor1.add(lblEstadoMembresiaCambio);
		}else {
			JLabel lblEstadoMembresiaCambio = new JLabel("Activa");
			lblEstadoMembresiaCambio.setFont(new Font("Calibri", Font.PLAIN, 18));
			lblEstadoMembresiaCambio.setBounds(196, 460, 233, 23);
			panelcontenedor1.add(lblEstadoMembresiaCambio);
		}
		


		//Panel para realizar el pago
		JPanel panelcontenedor2;
		panelcontenedor2 = new JPanel();
		panelcontenedor2.setLayout(null);
		panelcontenedor2.setBackground(Color.WHITE);
		panelcontenedor2.setBounds(663, 75, 419, 300);
		panel.add(panelcontenedor2);


		String[] months = {"1", "2", "3", "4", "5", "6","7", "8", "9", "10", "11", "12"};
		String[] valores= {"300", "350", "400", "450", "475", "500"};


		JComboBox<String> comboBox = new JComboBox<>(months);
		comboBox.setLocation(149, 166);
		comboBox.setSize(173, 29);

		comboBox.setFont(new Font("Calibri", Font.PLAIN, 18));
		panelcontenedor2.add(comboBox);
		
		JComboBox<String> comboBox2 = new JComboBox<>(valores);
		comboBox2.setLocation(149, 126);
		comboBox2.setSize(173, 29);

		comboBox2.setFont(new Font("Calibri", Font.PLAIN, 18));
		panelcontenedor2.add(comboBox2);



		JTextPane txt_Experiencia_1 = new JTextPane();
		txt_Experiencia_1.setText("Seleccione la cantidad de meses y precio actual de la mensualida para el pago del cliente ");
		txt_Experiencia_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		txt_Experiencia_1.setBackground(Color.WHITE);
		txt_Experiencia_1.setBounds(10, 51, 399, 64);
		txt_Experiencia_1.setBorder(new LineBorder(Color.WHITE));
		txt_Experiencia_1.setEditable(false);
		panelcontenedor2.add(txt_Experiencia_1);

		JPanel panelBtnPagar = new JPanel();
		panelBtnPagar.setBounds(102, 220, 220, 40);
		panelBtnPagar.setBackground(Color.decode("#3768A7"));
		panelcontenedor2.add(panelBtnPagar);
		panelBtnPagar.setLayout(null);


		//Panel para confirmar el pago y informacion de este
		JPanel panelcontenedor3 = new JPanel();
		panelcontenedor3.setLayout(null);
		panelcontenedor3.setBackground(Color.WHITE);
		panelcontenedor3.setBounds(665, 386, 419, 263);
		panel.add(panelcontenedor3);

		JPanel panelCabeceraContenido_1 = new JPanel();
		panelCabeceraContenido_1.setLayout(null);
		panelCabeceraContenido_1.setBackground(new Color(188, 218, 242));
		panelCabeceraContenido_1.setBounds(0, 0, 419, 40);
		panelcontenedor3.add(panelCabeceraContenido_1);


		JPanel panelCabeceraContenido_2 = new JPanel();
		panelCabeceraContenido_2.setLayout(null);
		panelCabeceraContenido_2.setBackground(new Color(188, 218, 242));
		panelCabeceraContenido_2.setBounds(0, 0, 419, 40);
		panelcontenedor2.add(panelCabeceraContenido_2);

		JLabel lblPagarMembresia = new JLabel("Pagar membresia");
		lblPagarMembresia.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblPagarMembresia.setBounds(10, 11, 409, 29);
		panelCabeceraContenido_2.add(lblPagarMembresia);

		JLabel lblTituloContenido3 = new JLabel("Datos de la tarifa");
		lblTituloContenido3.setFont(new Font("Calibri", Font.PLAIN, 26));
		lblTituloContenido3.setBounds(10, 11, 447, 29);
		panelCabeceraContenido_1.add(lblTituloContenido3);

		//El boton pagar hace que aparezca la informacion del panel de confirmar pago
		JButton btnBtnPagar = new JButton("Pagar");
		btnBtnPagar.setBounds(0, 0, 220, 40);
		panelBtnPagar.add(btnBtnPagar);
		btnBtnPagar.setForeground(Color.WHITE);
		btnBtnPagar.setFont(new Font("Calibri", Font.BOLD, 17));
		btnBtnPagar.setFocusPainted(false);
		btnBtnPagar.setContentAreaFilled(false);
		btnBtnPagar.setBorderPainted(false);
		btnBtnPagar.setBackground(new Color(55, 104, 167));
		
		JLabel lblMesePago = new JLabel("Costo :        		$");
		lblMesePago.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMesePago.setBounds(20, 126, 173, 29);
		panelcontenedor2.add(lblMesePago);
		
		JLabel lblMensualidad = new JLabel("Meses:");
		lblMensualidad.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblMensualidad.setBounds(20, 167, 173, 29);
		panelcontenedor2.add(lblMensualidad);
		btnBtnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelcontenedor3.removeAll();
				panelcontenedor3.revalidate();
				panelcontenedor3.repaint();

				String costo = (String) comboBox2.getSelectedItem();
				String meses = (String) comboBox.getSelectedItem();

				monto = Integer.parseInt(costo) * Integer.parseInt(meses);
				JLabel lblUsuario = new JLabel(" Usuario:" + datosCliente.get(0) + " " + datosCliente.get(1));
				lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 18));
				lblUsuario.setBounds(25, 65, 240, 23);
				panelcontenedor3.add(lblUsuario);

				JLabel lblMeses = new JLabel("Meses pagados: " + meses);
				lblMeses.setFont(new Font("Calibri", Font.PLAIN, 18));
				lblMeses.setBounds(28, 145, 184, 23);
				panelcontenedor3.add(lblMeses);

				JLabel lblId = new JLabel("Id: " + datosCliente.get(3));
				lblId.setFont(new Font("Calibri", Font.PLAIN, 18));
				lblId.setBounds(28, 105, 240, 23);
				panelcontenedor3.add(lblId);

				JLabel lblTotal = new JLabel("Total: $" + monto);
				lblTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
				lblTotal.setBounds(267, 145, 122, 23);
				panelcontenedor3.add(lblTotal);

				JPanel panelBtnPagar_1 = new JPanel();
				panelBtnPagar_1.setLayout(null);
				panelBtnPagar_1.setBackground(new Color(55, 104, 167));
				panelBtnPagar_1.setBounds(115, 200, 220, 40);
				panelcontenedor3.add(panelBtnPagar_1);

				JButton btnBtnPagar_1 = new JButton("Continuar");
				btnBtnPagar_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FeeController controller = new FeeController();
						FeeModel modelo = new FeeModel();
						modelo.pagar(idUsuario, monto);
						JOptionPane.showMessageDialog(null, "El pago se realizó con éxito.", "Pago realizado", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						controller.tarifa();

					}
				});
				btnBtnPagar_1.setForeground(Color.WHITE);
				btnBtnPagar_1.setFont(new Font("Calibri", Font.BOLD, 17));
				btnBtnPagar_1.setFocusPainted(false);
				btnBtnPagar_1.setContentAreaFilled(false);
				btnBtnPagar_1.setBorderPainted(false);
				btnBtnPagar_1.setBackground(new Color(55, 104, 167));
				btnBtnPagar_1.setBounds(0, 0, 220, 40);
				panelBtnPagar_1.add(btnBtnPagar_1);
				panelcontenedor3.revalidate();
				panelcontenedor3.repaint();
			}
		});
		vistaComun();
	}

	//Parte de botones de ventanas principales y cabecera que se repite
	public void vistaComun()
	{
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
				panel_3.setBackground(Color.decode("#3768A7"));
				panel_3.setBounds(0, 156, 190, 61);
				panel_3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(207, 207, 207)));
				panelOpciones.add(panel_3);
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

}