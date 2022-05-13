package citizen;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class dataInfo {
	
	static String jdbcURL = "jdbc:postgresql://localhost:5432/dataCVcitta";
	private String username = "postgres";
	private String password = "password";
	
	private final panInfo pann;
	
	public dataInfo (final panInfo pann) {
		this.pann = pann;
	}
	
	public int vaccinesData (String nomeCV, String comuneCV) {
		boolean trovato = false;
		int n = 0;
		ArrayList <String> nomevax = new ArrayList <String>();
		ArrayList <Integer> contavax = new ArrayList <Integer>();
		int markc = 0;
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		
			String sql = "SELECT * FROM eventi_adv";
		
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				trovato = false;
				String nomecentro = result.getString("centro_vaccinale");
				String comunecentro = result.getString("comune_centro");
				String tipovaccino = result.getString("tipo_vaccino");
				if ((nomeCV.contentEquals(nomecentro)) && (comuneCV.contentEquals(comunecentro))) {
					n++;
					if (nomevax.isEmpty()) {
						nomevax.add(tipovaccino);
						contavax.add(1);
					}else {
						for (int i = 0; i<nomevax.size(); i++) {
							if (tipovaccino.contentEquals(nomevax.get(i))) {
								markc = contavax.get(i);
								markc++;
								contavax.set(i, markc);
								trovato = true;
							}
						}
						if (trovato == false) {
							nomevax.add(tipovaccino);
							contavax.add(1);
						}
					}
				}
			}
			pann.setNomeVax(nomevax);
			pann.setContaVax(contavax);
			connection.close();
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		
		return n;
	}
	
	public Map<String,ArrayList<String[]>> eventsData(String nomeCV, String comuneCV, String vaccineselected) {
		ArrayList <String> eventi = new ArrayList <String>();
		ArrayList <Integer> conta = new ArrayList <Integer>();
		ArrayList <Integer> scalatot = new ArrayList <Integer>();
		Map<String,ArrayList<String[]>> mappanote = new HashMap<String,ArrayList<String[]>>();
		int markc = 0;
		int marks = 0;
		boolean trovato;
		boolean trovatomap;

		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
		
			String sql = "SELECT * FROM eventi_adv";
		
			Statement statement = connection.createStatement();
		
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				String [] sevandnota = new String [3];
				ArrayList<String[]> notevento = new ArrayList<String[]>();
				trovato = false;
				trovatomap = false;
				String nomeutente = result.getString("id_utente");
				String nomecentro = result.getString("centro_vaccinale");
				String comunecentro = result.getString("comune_centro");
				String tipovaccino = result.getString("tipo_vaccino");
				String eventoavverso = result.getString("evento_avverso");
				int scala = result.getInt("scala");
				String noteopzionali = result.getString("note_opzionali");
				if ((nomeCV.contentEquals(nomecentro)) && (comuneCV.contentEquals(comunecentro))) {
					if (tipovaccino.contentEquals(vaccineselected)) {
						if (eventi.isEmpty()) {
							
							eventi.add(eventoavverso);
							conta.add(1);
							scalatot.add(scala);
						}
						else {
							for (int i = 0; i<eventi.size(); i++) {
								if (eventoavverso.contentEquals(eventi.get(i))) {
									markc = conta.get(i);
									markc++;
									conta.set(i, markc);
									marks = scalatot.get(i);
									marks = marks + scala;
									scalatot.set(i, marks);
									trovato = true;
								}
							}
							if (trovato == false) {
								eventi.add(eventoavverso);
								conta.add(1);
								scalatot.add(scala);
							}
							
						}
						sevandnota[0] = nomeutente;
						sevandnota[1] = String.valueOf(scala);
						sevandnota[2] = noteopzionali;
						if (mappanote.isEmpty()) {
							notevento.add(sevandnota);
							mappanote.put(eventoavverso, notevento);
						}else {
							for (Map.Entry<String, ArrayList<String[]>> mappamatch : mappanote.entrySet()) {
								if (eventoavverso.contentEquals(mappamatch.getKey())){
									notevento = mappanote.get(eventoavverso);
									notevento.add(sevandnota);
									mappanote.replace(eventoavverso, notevento);
									trovatomap = true;
								}
							}
							if (trovatomap == false) {
								notevento.add(sevandnota);
								mappanote.put(eventoavverso, notevento);
							}
						}
					}
				}
			}
			
			pann.setEventi(eventi);
			pann.setContaEvent(conta);
			pann.setScalaTot(scalatot);
			connection.close();	
			
		} catch (SQLException e1) {
			System.out.println("connessione fallita");
			e1.printStackTrace();
		}
		return mappanote;
	}	
}
