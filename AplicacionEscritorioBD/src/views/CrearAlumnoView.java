package views;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.AlumnoDAO;
import models.Alumno;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearAlumnoView {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfCiclo;
	private JTextField tfMedia;
	private JLabel lblMatricula;
	private AlumnoDAO alumnoDAO;
	private JButton btnCrear;

	/**
	 * Create the application.
	 */
	public CrearAlumnoView() {
		initialize();
		this.alumnoDAO = new AlumnoDAO();
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

		lblMatricula = new JLabel("Crear alumno");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblMatricula.setBounds(152, 11, 243, 45);
		frame.getContentPane().add(lblMatricula);


		tfNombre = new JTextField();
		tfNombre.setText("nombre");
		tfNombre.setBounds(101, 123, 243, 26);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		tfApellidos = new JTextField();
		tfApellidos.setText("apellidos");
		tfApellidos.setColumns(10);
		tfApellidos.setBounds(101, 170, 243, 26);
		frame.getContentPane().add(tfApellidos);

		tfCiclo = new JTextField();
		tfCiclo.setToolTipText("ciclo");
		tfCiclo.setText("ciclo");
		tfCiclo.setColumns(10);
		tfCiclo.setBounds(101, 217, 243, 26);
		frame.getContentPane().add(tfCiclo);

		tfMedia = new JTextField();
		tfMedia.setToolTipText("media");
		tfMedia.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tfMedia.setBounds(398, 123, 86, 70);
		frame.getContentPane().add(tfMedia);
		tfMedia.setColumns(10);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarAlumno();
			}
		});
		btnCrear.setBounds(216, 332, 89, 23);
		frame.getContentPane().add(btnCrear);
	}

	private void insertarAlumno() {
		if(tfApellidos.getText().isEmpty() || tfNombre.getText().isEmpty() || 
				tfCiclo.getText().isEmpty() || tfMedia.getText().isEmpty() ) {
			JOptionPane.showMessageDialog(btnCrear, "Revisa todos los campos");
		} else {
			try {
				double media = Double.parseDouble(tfMedia.getText());
				Alumno a = new Alumno(tfNombre.getText(), tfApellidos.getText(),
						tfCiclo.getText(), media);
				alumnoDAO.insert(a);
				JOptionPane.showMessageDialog(btnCrear, "Alumno creado");
				new MatriculaView();
				frame.dispose();

			} catch(Exception e) {
				JOptionPane.showMessageDialog(btnCrear, "La calificación debe ser decimal.");
			}
		}
	}
}
