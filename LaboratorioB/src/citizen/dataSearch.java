package citizen;



import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dataSearch {
	
	static String jdbcURL = "jdbc:postgresql://localhost:5432/dataCVcitta";
	private String username = "postgres";
	private String password = "password";
	
	
	public dataSearch () {
	}
	
	public ArrayList<ArrayList<String>> cercanome (String nome){
		ArrayList<ArrayList<String>> matrixinfo = new ArrayList<ArrayList<String>>();
		int i = 0;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		
			String sql = "SELECT * FROM centro_vaccinale";
		
			Statement statement = connection.createStatement();
		
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				String nomecentro = result.getString("nome_centro");
				String indirizzocentro = result.getString("indirizzo_centro");
				String tipologiacentro = result.getString("tipologia_centro");
				String comunecentro = result.getString("comune_centro");
				char[] chars2 = nomecentro.toLowerCase().toCharArray();
				  boolean found2 = false;
				  for (int f = 0; f < chars2.length; f++) {
				    if (!found2 && Character.isLetter(chars2[f])) {
				      chars2[f] = Character.toUpperCase(chars2[f]);
				      found2 = true;
				    } else if (Character.isWhitespace(chars2[f]) || chars2[f]=='.' || chars2[f]=='\'') { 
				      found2 = false;
				    }
				  }
				  String novastringa = String.valueOf(chars2);
				 if (novastringa.contains(nome)){
					 ArrayList<String> rowinfo = new ArrayList<String>();
					 rowinfo.add(0, nomecentro);
					 rowinfo.add(1, comunecentro);
					 rowinfo.add(2, indirizzocentro);
					 rowinfo.add(3, tipologiacentro);
					 matrixinfo.add(i, rowinfo);
					 i++;
				}
			}
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		
		return matrixinfo;
	}
	
	
	public ArrayList<ArrayList<String>> cercacomunetipo (String comune, String tipo){
		
		ArrayList<ArrayList<String>> matrixinfo = new ArrayList<ArrayList<String>>();
		int i = 0;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			String sql = "SELECT * FROM centro_vaccinale";
		
			Statement statement = connection.createStatement();
		
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				String nomecentro = result.getString("nome_centro");
				String indirizzocentro = result.getString("indirizzo_centro");
				String tipologiacentro = result.getString("tipologia_centro");
				String comunecentro = result.getString("comune_centro");
				
				char[] charscom = comunecentro.toLowerCase().toCharArray();
				  boolean found2 = false;
				  for (int f = 0; f < charscom.length; f++) {
				    if (!found2 && Character.isLetter(charscom[f])) {
				    	charscom[f] = Character.toUpperCase(charscom[f]);
				      found2 = true;
				    } else if (Character.isWhitespace(charscom[f]) || charscom[f]=='.' || charscom[f]=='\'') { 
				      found2 = false;
				    }
				  }
				  String novastringa = String.valueOf(charscom);
				 if (novastringa.contains(comune) && tipo.contentEquals(tipologiacentro)){
					 ArrayList<String> rowinfo = new ArrayList<String>();
					 rowinfo.add(0, nomecentro);
					 rowinfo.add(1, comunecentro);
					 rowinfo.add(2, indirizzocentro);
					 rowinfo.add(3, tipologiacentro);
					 matrixinfo.add(i, rowinfo);
					 i++;
				}
			}
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		
		return matrixinfo;
	}
}
