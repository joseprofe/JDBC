package views;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.AlumnoDAO;
import models.Alumno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MatriculaView {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfCiclo;
	private JTextField tfMedia;
	private JLabel lblMatricula;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private AlumnoDAO alumnoDAO;
	private ArrayList<Alumno> alumnos;
	private int indice;

	/**
	 * Create the application.
	 */
	public MatriculaView() {
		initialize();
		this.alumnoDAO = new AlumnoDAO();
		this.alumnos = alumnoDAO.getAll();
		indice = 0;
		if (this.alumnos.size() > 0) {
			printAlumno();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 581, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblMatricula = new JLabel("Matr\u00EDculas");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblMatricula.setBounds(203, 11, 192, 45);
		frame.getContentPane().add(lblMatricula);

		btnAtras = new JButton("<");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indice--;
				if(indice < 0) {
					indice = alumnos.size() - 1;
				}
				printAlumno();
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAtras.setBounds(10, 11, 59, 45);
		frame.getContentPane().add(btnAtras);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				indice++;
				if(indice == alumnos.size()) {
					indice = 0;
				}
				printAlumno();
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSiguiente.setBounds(496, 16, 59, 45);
		frame.getContentPane().add(btnSiguiente);

		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setBounds(101, 123, 243, 26);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		tfApellidos = new JTextField();
		tfApellidos.setEditable(false);
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(101, 170, 243, 26);
		frame.getContentPane().add(tfApellidos);

		tfCiclo = new JTextField();
		tfCiclo.setEditable(false);
		tfCiclo.setColumns(10);
		tfCiclo.setBounds(101, 217, 243, 26);
		frame.getContentPane().add(tfCiclo);

		tfMedia = new JTextField();
		tfMedia.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tfMedia.setEditable(false);
		tfMedia.setBounds(398, 123, 86, 70);
		frame.getContentPane().add(tfMedia);
		tfMedia.setColumns(10);
	}

	private void printAlumno() {
		Alumno a = alumnos.get(indice);
		tfNombre.setText(a.getNombre());
		tfApellidos.setText(a.getApellidos());
		tfCiclo.setText(a.getCiclo());
		tfMedia.setText(String.valueOf(a.getMedia()));
	}
}
