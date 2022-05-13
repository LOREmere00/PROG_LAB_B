package citizen;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class dataLogin {
	
	private final checkLogin check1;
	
	public dataLogin (final checkLogin check1) {
		this.check1 = check1;
	}
	
	//private final checkLogin check1;
	
	static String jdbcURL = "jdbc:postgresql://localhost:5432/dataCVcitta";
	static String username = "postgres";
	static String password = "password";
	
	public ArrayList<String> getAllDatas(String userText, String passText) {
		
		ArrayList <String> infopack = new ArrayList<String>();
		boolean wrongpass = false;
		
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		
			String sql = "SELECT * FROM cittadini_registrati";
		
			Statement statement = connection.createStatement();
		
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next() && (wrongpass == false)) {
				String nome = result.getString("nome");
				String cognome = result.getString("cognome");
				String CF = result.getString("codice_fiscale");
				String email = result.getString("email");
				String comunecentro = result.getString("comune_centro");
				String centrovaccinato = result.getString("centro_vaccinato");
				String username = result.getString("username");
				String password = result.getString("password");
				String tipovaccino = result.getString("vaccino_ricevuto");
				if (userText.contentEquals(username)) {
					if (passText.contentEquals(password)) {
						infopack.add(0, nome);
						infopack.add(1, cognome);
						infopack.add(2, CF);
						infopack.add(3, email);
						infopack.add(4, comunecentro);
						infopack.add(5, centrovaccinato);
						infopack.add(6, username);
						infopack.add(7, password);
						infopack.add(8, tipovaccino);
					}
					else {
						wrongpass = true;
						check1.setWrongPass(true);
					}
				}
			}
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		
		return infopack;
	}

}
