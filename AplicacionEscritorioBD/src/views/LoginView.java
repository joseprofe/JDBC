package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UsuarioDAO;

public class LoginView {

	private JFrame frame;
	private JTextField tfUsername;
	private JPasswordField pwdfPassword;
	private JButton btnLogin;
	private UsuarioDAO usuarioDAO;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
		this.usuarioDAO = new UsuarioDAO();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(109, 65, 186, 20);
		frame.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		pwdfPassword = new JPasswordField();
		pwdfPassword.setBounds(109, 112, 186, 20);
		frame.getContentPane().add(pwdfPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Conectar con la BD y comprobar la tabla usuarios pa ver si furula.
				String username = tfUsername.getText();
				String password = new String(pwdfPassword.getPassword());
				boolean loginCorrecto = usuarioDAO.login(username, password);
				if(loginCorrecto) {
					JOptionPane.showMessageDialog(btnLogin, "Login correcto Bob.");
					new WelcomeView();
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(btnLogin, "Ah ah aaaah... login incorrecto...");
				}
			}
		});
		btnLogin.setBounds(157, 182, 89, 23);
		frame.getContentPane().add(btnLogin);
	}
}
