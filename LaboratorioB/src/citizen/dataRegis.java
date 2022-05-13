package citizen;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class dataRegis {
	
	private final checkRegis checkreg;
	
	public dataRegis (final checkRegis checkreg) {
		this.checkreg = checkreg;
	}
	
	static String jdbcURL = "jdbc:postgresql://localhost:5432/dataCVcitta";
	static String username = "postgres";
	static String password = "password";
	
	public boolean checkID (String CFtext) {
		boolean check = false;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		
			String sql = "SELECT * FROM cittadini_vaccinati";
		
			Statement statement = connection.createStatement();
		
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next() && (check == false)) {
				String CF = result.getString("codice_fiscale");
				if (CFtext.contentEquals(CF)) {
						check = true;
				}
			}
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		
		return check;
	}
	
	public boolean checkLogged (String userText, String IDtext) {
		boolean checklog = false;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		
			String sql = "SELECT * FROM cittadini_registrati";
		
			Statement statement = connection.createStatement();
		
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next() && (checklog ==false)) {
				String usern = result.getString("username");
				String ID = result.getString("codice_fiscale");
				if (userText.contentEquals(usern)) {
					checkreg.setUserExist(true);
				}
				if (IDtext.contentEquals(ID)) {
					checkreg.setUserExist(false);
					checklog = true;
				}
			}
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		return checklog;
	}
	
	public void getInfos (String IDtext) {
		boolean check = false;
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		
			String sql = "SELECT * FROM cittadini_vaccinati";
		
			Statement statement = connection.createStatement();
		
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next() && (check == false)) {
				String ID = result.getString("codice_fiscale");
				String nomecentro = result.getString("nome_centro");
				String comunecentro = result.getString("comune_centro");
				String vaccinoricevuto = result.getString("vaccino_ricevuto");
				if (IDtext.contentEquals(ID)) {
					checkreg.setNomeCentro(nomecentro);
					checkreg.setComuneCentro(comunecentro);
					checkreg.setTipoVaccino(vaccinoricevuto);
					check = true;
				}
			}
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
	}
	
	public void setAll (String [] infos) {
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			String sql = "INSERT INTO cittadini_registrati (nome, cognome, codice_fiscale, email, comune_centro, centro_vaccinato, username, password, vaccino_ricevuto) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, infos[0]);
			statement.setString(2, infos[1]);
			statement.setString(3, infos[2]);
			statement.setString(4, infos[3]);
			statement.setString(5, infos[4]);
			statement.setString(6, infos[5]);
			statement.setString(7, infos[6]);
			statement.setString(8, infos[7]);
			statement.setString(9, infos[8]);
			
			statement.executeUpdate();
				
			
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		
		
	}

}
