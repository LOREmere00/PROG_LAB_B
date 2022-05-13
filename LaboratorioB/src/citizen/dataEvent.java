package citizen;



import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class dataEvent {
	
	static String jdbcURL = "jdbc:postgresql://localhost:5432/dataCVcitta";
	private String username = "postgres";
	private String password = "password";
	
	public dataEvent () {
	}
	
	public boolean insertEvent (ArrayList <String> infopack, String adversevent, int severity, String notes){
		
		Boolean checkIns = false;
		String utente = infopack.get(6);
		String comunecentro = infopack.get(4);
		String nomecentro = infopack.get(5);
		String tipo = infopack.get(8);
		String reazione = adversevent;
		int scala = severity;
		String noteopzionali = notes;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			
			
			
			String UPDATE_USERS_SQL = "update eventi_adv set (scala, note_opzionali) = (?, ?) where (id_utente, evento_avverso) = (?,?);";
			PreparedStatement statements = connection.prepareStatement(UPDATE_USERS_SQL);
			statements.setInt(1, scala);
			statements.setString(2, noteopzionali);
			statements.setString(3, utente);
			statements.setString(4, reazione);
			
			int rowss = statements.executeUpdate();
			if (rowss < 1) {

				String sql = "INSERT INTO eventi_adv (id_utente, comune_centro, centro_vaccinale, tipo_vaccino, evento_avverso, scala, note_opzionali) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, utente);
				statement.setString(2, comunecentro);
				statement.setString(3, nomecentro);
				statement.setString(4, tipo);
				statement.setString(5, reazione);
				statement.setInt(6, scala);
				statement.setString(7, noteopzionali);
				
				int rows = statement.executeUpdate();
				
				if (rows > 0) {
					checkIns = true;
				}
			}
			else {
				checkIns = true;
			}
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		
		return checkIns;
		
	}

}
