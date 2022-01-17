package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Alumno;

public class AlumnoDAO {

	final String DB_URL = "jdbc:mysql://localhost/test";
	final String USER = "pidgey";
	final String PASS = "P@ssw0rd";	

	public Alumno first() {
		final String QUERY = "SELECT nombre, apellidos, ciclo, calificacionmedia  "
				+ "FROM alumnos limit 1";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String ciclo = rs.getString("ciclo");
				double media = rs.getDouble("calificacionmedia");
				Alumno a = new Alumno(nombre, apellidos, ciclo, media);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Alumno> getAll() {
		final String QUERY = "SELECT nombre, apellidos, ciclo, calificacionmedia  "
				+ "FROM alumnos";
		var alumnos = new ArrayList<Alumno>();
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				var nombre = rs.getString("nombre");
				var apellidos = rs.getString("apellidos");
				var ciclo = rs.getString("ciclo");
				var media = rs.getDouble("calificacionmedia");
				Alumno a = new Alumno(nombre, apellidos, ciclo, media);
				alumnos.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	public void insert(Alumno a) {
		final String INSERT = "INSERT INTO alumnos(`nombre`,`apellidos`,`ciclo`,`calificacionMedia`)\r\n"
				+ "VALUES('"+a.getNombre()+"','"+a.getApellidos()+"','"+a.getCiclo()+"',"+a.getMedia()+");";
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
