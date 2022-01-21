package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Profesor;

public class ProfeDAO {

	final String DB_URL = "jdbc:mysql://localhost/test";
	final String USER = "pidgey";
	final String PASS = "P@ssw0rd";
	
	public ArrayList<Profesor> getAll() {
		final String QUERY = "SELECT id, nombre "
				+ "FROM profesores";
		var profesores = new ArrayList<Profesor>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var id = rs.getInt("id");
				var nombre = rs.getString("nombre");
				Profesor p = new Profesor(id, nombre);
				profesores.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profesores;
	}
	
	/**
	 * Busca el Profesor por su ID y si no lo encuentra devuelve NULL.
	 * @param idProfe
	 * @return
	 */
	public Profesor get(int idProfe) {
		final String QUERY = "SELECT id, nombre "
				+ "FROM profesores where id = " + idProfe;
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var id = rs.getInt("id");
				var nombre = rs.getString("nombre");
				Profesor p = new Profesor(id, nombre);
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
