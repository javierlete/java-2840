package com.ipartek.formacion.presentacion.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.daos.DaoPersona;
import com.ipartek.formacion.daos.DaoPersonaSqlite;
import com.ipartek.formacion.pojos.Persona;
import com.ipartek.formacion.pojos.PojosException;
import com.ipartek.formacion.pojos.Rol;

public class DaoPersonaSwing {

	private static final DaoPersona dao = new DaoPersonaSqlite("jdbc:sqlite:bdd/tienda.db");
	private static DefaultTableModel modelo;
	
	private JFrame frmFormularioPersonas;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfFecha;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DaoPersonaSwing window = new DaoPersonaSwing();
					window.frmFormularioPersonas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public DaoPersonaSwing() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		initialize();

		modelo = (DefaultTableModel) table.getModel();

		modelo.addColumn("Id");
		modelo.addColumn("Nombre");
		modelo.addColumn("Fecha de nacimiento");
		modelo.addColumn("Rol");

		rellenarTabla();
	}

	private void rellenarTabla() {
		modelo.setRowCount(0);
		
		for (var p : dao.obtenerTodosConRol()) {
			modelo.addRow(new Object[] { p.getId(), p.getNombre(), p.getFechaNacimiento(), p.getRol().getNombre() });
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFormularioPersonas = new JFrame();
		frmFormularioPersonas.setTitle("Formulario Personas");
		frmFormularioPersonas.setBounds(100, 100, 483, 468);
		frmFormularioPersonas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFormularioPersonas.getContentPane().setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frmFormularioPersonas.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		tfId = new JTextField();
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.insets = new Insets(0, 0, 5, 0);
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.gridx = 1;
		gbc_tfId.gridy = 0;
		panel.add(tfId, gbc_tfId);
		tfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 1;
		panel.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fecha");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		tfFecha = new JTextField();
		GridBagConstraints gbc_tfFecha = new GridBagConstraints();
		gbc_tfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_tfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFecha.gridx = 1;
		gbc_tfFecha.gridy = 2;
		panel.add(tfFecha, gbc_tfFecha);
		tfFecha.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Long id = null; // Long.parseLong(tfId.getText());
					var nombre = tfNombre.getText();
					var fechaNacimiento = LocalDate.parse(tfFecha.getText());
					var rol = new Rol(2L, null, null);
					
					dao.insertar(new Persona(id, nombre, fechaNacimiento, rol));
					
					rellenarTabla();
				} catch (PojosException pe) {
					JOptionPane.showMessageDialog(frmFormularioPersonas, pe.getMessage(), "Atención", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.WEST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 3;
		panel.add(btnGuardar, gbc_btnGuardar);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
	}

}
