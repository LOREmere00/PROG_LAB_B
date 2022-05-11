package centriVaccinali;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registraCentroVaccinale extends JPanel {

	/*
	 * Dichiarazione variabili per il layout
	 */
	JPanel panel;
	private JTextField textField_ID;
	private JTextField textField_comune;
	private JTextField textField_CAP;
	private JTextField textField_numVia;
	private JTextField textField_nomeVia;
	private JPasswordField passwordField_psw;
	private JTextField textField_nomeCentro;
	private char c;
	String colonnaQuery, tabQuery;
	Connection connection;
	String[] arrTipoVia = { "via", "viale", "piazzale" };
	String[] arrTipologiaCentro = { "ospedaliero", "hub", "aziendale" };
	String[] arrProvince = { "Agrigento", "Alessandria", "Ancona", "Aosta", "Arezzo", "Ascoli Piceno", "Asti",
			"Avellino", "Bari", "Barletta Andria Trani", "Belluno", "Benevento", "Bergamo", "Biella", "Bologna",
			"Bolzano", "Brescia", "Brindisi", "Cagliari", "Caltanissetta", "Campobasso", "Caserta", "Catania",
			"Catanzaro", "Chieti", "Como", "Cosenza", "Cremona", "Crotone", "Cuneo", "Enna", "Fermo", "Ferrara",
			"Firenze", "Foggia", "Forlì-Cesena", "Frosinone", "Genova", "Gorizia", "Grosseto", "Imperia", "Isernia",
			"La Spezia", "LAquila", "Latina", "Lecce", "Lecco", "Livorno", "Lodi", "Lucca", "Macerata", "Mantova",
			"Massa Carrara", "Matera", "Messina", "Milano", "Modena", "Monza e Brianza", "Napoli", "Novara", "Nuoro",
			"Oristano", "Padova", "Palermo", "Parma", "Pavia", "Perugia", "Pesaro Urbino", "Pescara", "Piacenza",
			"Pisa", "Pistoia", "Pordenone", "Potenza", "Prato", "Ragusa", "Ravenna", "Reggio Calabria", "Reggio Emilia",
			"Rieti", "Rimini", "Roma", "Rovigo", "Salerno", "Sassari", "Savona", "Siena", "Siracusa", "Sondrio",
			"Sud Sardegna", "Taranto", "Teramo", "Terni", "Torino", "Trapani", "Trento", "Treviso", "Trieste", "Udine",
			"Varese", "Venezia", "Verbano Cusio Ossola", "Vercelli", "Verona", "Vibo Valetina", "Vicenza", "Viterbo" };
	Boolean[] contr = { true, true, true, true, true };

	/*
	 * Dichiarazione variabili per connessione al DB
	 */
	String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "postgres";

	/*
	 * Dichiarazione variabili per inserimento in database (col -> colonna)
	 */
	String ID, PSW, colNomeCentro, colTipoCentro, colProvincia, colComune, colTipoVia, colNomeVia, colTipoVaccino;
	int colNumeroCivico = 0, colCAP = 0;

	public registraCentroVaccinale() {

		setLayout(new GridLayout(1, 0, 0, 0));
		panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 100, 80, 145, 100, 90, 135, 100 };
		gbl_panel.rowHeights = new int[] { 75, 40, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 75 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		panel.setLayout(gbl_panel);
		GestioneLayout();
	}

	private boolean check_cred(String ID, String PSW) {

		boolean res = false;
		try {

			/*
			 * Connessione al DB
			 */
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connessione al server DB avvenuta con successo.");

			/*
			 * Creazione query
			 */
			String sql = "SELECT * FROM credenziali WHERE nome_utente = '" + ID + "' AND password = '" + PSW + "'";
			Statement statement = connection.createStatement();
			ResultSet resSet = statement.executeQuery(sql);
			if (resSet.next())

				res = true;
			connection.close();
		} catch (SQLException e) {

			System.out.println("Connessione al DB fallita.");
			e.printStackTrace();
		}
		return res;
	}

	private void InserimentoDB(String colNomeCentro, String colTipoCentro, String colProvincia, String colComune,
			String colTipoVia, int colNumeroCivico, String colNomeVia, int colCAP) {

		try {

			/*
			 * Apertura connessione DB
			 */
			connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("connessione al server DB per inserimento avvenuta con successo.");

			/*
			 * Preparazione della query di inserimento
			 */
			String sql = "INSERT INTO centrivaccinali (nome_centro, tipo_centro, provincia, comune, tipo_via, numero_civico, nome_via, cap) VALUES ('"
					+ colNomeCentro + "', '" + colTipoCentro + "', '" + colProvincia + "', '" + colComune + "', '"
					+ colTipoVia + "', '" + colNumeroCivico + "', '" + colNomeVia + "', '" + colCAP + "')";
			System.out.println("sql: " + sql);
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

			/*
			 * Chiusura connessione DB
			 */
			connection.close();
		} catch (SQLException e) {

			System.out.println("Connessione al DB in inserimento fallita.");
			e.printStackTrace();
		}
	}

	private void GestioneLayout() {


		try {

			/*
			 * Inserimento immagine primula
			 */
			BufferedImage prim = ImageIO.read(new File("./src/primula.png"));
			Image newPrim = prim.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblPrim = new JLabel(new ImageIcon(newPrim));
			lblPrim.setPreferredSize(new Dimension(50, 50));
			GridBagConstraints gbc_lblPrim = new GridBagConstraints();
			gbc_lblPrim.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lblPrim.insets = new Insets(0, 0, 5, 0);
			gbc_lblPrim.gridx = 6;
			gbc_lblPrim.gridy = 0;
			panel.add(lblPrim, gbc_lblPrim);

			/*
			 * Inserimento immagine/pulsante "goBack"
			 */
			BufferedImage back = ImageIO.read(new File("./src/gobackb.png"));
			Image newBack = back.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JButton butt = new JButton(new ImageIcon(newBack));
			butt.setContentAreaFilled(false);
			butt.setBorderPainted(false);
			butt.setPreferredSize(new Dimension(75, 90));
			butt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					registraVaccinato home = new registraVaccinato();
					removeAll();
					add(home);
					repaint();
					revalidate();
				}
			});
			GridBagConstraints gbc_butt = new GridBagConstraints();
			gbc_butt.insets = new Insets(0, 0, 5, 5);
			gbc_butt.gridx = 0;
			gbc_butt.gridy = 0;
			panel.add(butt, gbc_butt);
		} catch (Exception e) {

			e.printStackTrace();
		}

		/*
		 * Label titolo
		 */
		JLabel lbl_title1 = new JLabel("INSERIRE LE CREDENZIALI");
		lbl_title1.setForeground(Color.BLUE);
		lbl_title1.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_title1 = new GridBagConstraints();
		gbc_lbl_title1.anchor = GridBagConstraints.NORTH;
		gbc_lbl_title1.gridwidth = 5;
		gbc_lbl_title1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_title1.gridx = 1;
		gbc_lbl_title1.gridy = 1;
		panel.add(lbl_title1, gbc_lbl_title1);

		/*
		 * TextField ID
		 */
		textField_ID = new JTextField("Inserire ID");
		textField_ID.setForeground(Color.GRAY);
		textField_ID.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textField_ID.getText().equals("Inserire ID"))
						&& (textField_ID.getForeground().equals(Color.GRAY))) {

					textField_ID.setText("");
					textField_ID.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_ID.getText().equals("")) {

					textField_ID.setText("Inserire ID");
					textField_ID.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textField_ID = new GridBagConstraints();
		gbc_textField_ID.gridwidth = 2;
		gbc_textField_ID.insets = new Insets(0, 0, 5, 5);
		gbc_textField_ID.fill = GridBagConstraints.BOTH;
		gbc_textField_ID.gridx = 1;
		gbc_textField_ID.gridy = 2;
		panel.add(textField_ID, gbc_textField_ID);
		textField_ID.setColumns(10);

		/*
		 * PasswordField password
		 */
		passwordField_psw = new JPasswordField("Inserire la password");
		c = passwordField_psw.getEchoChar();
		passwordField_psw.setEchoChar((char) 0);
		passwordField_psw.setForeground(Color.GRAY);
		passwordField_psw.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((String.valueOf(passwordField_psw.getPassword()).equals("Inserire la password"))
						&& (passwordField_psw.getForeground().equals(Color.GRAY))) {

					passwordField_psw.setEchoChar(c);
					passwordField_psw.setText("");
					passwordField_psw.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (String.valueOf(passwordField_psw.getPassword()).equals("")) {

					passwordField_psw.setText("Inserire la password");
					passwordField_psw.setEchoChar((char) 0);
					passwordField_psw.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_passwordField_psw = new GridBagConstraints();
		gbc_passwordField_psw.gridwidth = 2;
		gbc_passwordField_psw.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_psw.fill = GridBagConstraints.BOTH;
		gbc_passwordField_psw.gridx = 4;
		gbc_passwordField_psw.gridy = 2;
		panel.add(passwordField_psw, gbc_passwordField_psw);

		/*
		 * Label errore ID
		 */
		JLabel lbl_errID = new JLabel("errore ID");
		lbl_errID.setVisible(false);
		lbl_errID.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errID = new GridBagConstraints();
		gbc_lbl_errID.gridwidth = 2;
		gbc_lbl_errID.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errID.gridx = 1;
		gbc_lbl_errID.gridy = 3;
		panel.add(lbl_errID, gbc_lbl_errID);

		/*
		 * Label errore password
		 */
		JLabel lbl_errPsw = new JLabel("errore password");
		lbl_errPsw.setVisible(false);
		lbl_errPsw.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errPsw = new GridBagConstraints();
		gbc_lbl_errPsw.gridwidth = 2;
		gbc_lbl_errPsw.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errPsw.gridx = 4;
		gbc_lbl_errPsw.gridy = 3;
		panel.add(lbl_errPsw, gbc_lbl_errPsw);

		/*
		 * Label titolo 2
		 */
		JLabel lbl_title2 = new JLabel(
				"---------------------------------- Dati centro vaccinale ----------------------------------");
		lbl_title2.setForeground(Color.BLACK);
		lbl_title2.setFont(new Font("Gill Sans Nova", Font.BOLD, 13));
		GridBagConstraints gbc_lbl_title2 = new GridBagConstraints();
		gbc_lbl_title2.gridwidth = 7;
		gbc_lbl_title2.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_title2.gridx = 0;
		gbc_lbl_title2.gridy = 4;
		panel.add(lbl_title2, gbc_lbl_title2);

		/*
		 * TextField nome centro
		 */
		textField_nomeCentro = new JTextField("Inserire nome centro");
		textField_nomeCentro.setForeground(Color.GRAY);
		textField_nomeCentro.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textField_nomeCentro.getText().equals("Inserire nome centro"))
						&& (textField_nomeCentro.getForeground().equals(Color.GRAY))) {

					textField_nomeCentro.setText("");
					textField_nomeCentro.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_nomeCentro.getText().equals("")) {

					textField_nomeCentro.setText("Inserire nome centro");
					textField_nomeCentro.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textField_nomeCentro = new GridBagConstraints();
		gbc_textField_nomeCentro.gridwidth = 2;
		gbc_textField_nomeCentro.insets = new Insets(0, 0, 5, 5);
		gbc_textField_nomeCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_nomeCentro.gridx = 1;
		gbc_textField_nomeCentro.gridy = 6;
		panel.add(textField_nomeCentro, gbc_textField_nomeCentro);
		textField_nomeCentro.setColumns(10);

		/*
		 * Label tipo centro vaccinale
		 */
		JLabel lbl_centroVaccinale = new JLabel("Centro Vaccinale:");
		GridBagConstraints gbc_lbl_centroVaccinale = new GridBagConstraints();
		gbc_lbl_centroVaccinale.fill = GridBagConstraints.VERTICAL;
		gbc_lbl_centroVaccinale.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_centroVaccinale.gridx = 4;
		gbc_lbl_centroVaccinale.gridy = 6;
		panel.add(lbl_centroVaccinale, gbc_lbl_centroVaccinale);

		/*
		 * ComboBox selezione tipo centro
		 */
		JComboBox<Object> comboBox_selTipoCentro = new JComboBox<Object>(arrTipologiaCentro);
		GridBagConstraints gbc_comboBox_selCentro = new GridBagConstraints();
		gbc_comboBox_selCentro.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_selCentro.fill = GridBagConstraints.BOTH;
		gbc_comboBox_selCentro.gridx = 5;
		gbc_comboBox_selCentro.gridy = 6;
		panel.add(comboBox_selTipoCentro, gbc_comboBox_selCentro);

		/*
		 * Label errore nome centro
		 */
		JLabel lbl_errNomeCentro = new JLabel("errore nome centro");
		lbl_errNomeCentro.setVisible(false);
		lbl_errNomeCentro.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errNomeCentro = new GridBagConstraints();
		gbc_lbl_errNomeCentro.gridwidth = 2;
		gbc_lbl_errNomeCentro.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errNomeCentro.gridx = 1;
		gbc_lbl_errNomeCentro.gridy = 7;
		panel.add(lbl_errNomeCentro, gbc_lbl_errNomeCentro);

		/*
		 * Label provincia
		 */
		JLabel lbl_provincia = new JLabel("Provincia:");
		GridBagConstraints gbc_lbl_provincia = new GridBagConstraints();
		gbc_lbl_provincia.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_provincia.gridx = 1;
		gbc_lbl_provincia.gridy = 8;
		panel.add(lbl_provincia, gbc_lbl_provincia);
		
		/*
		 * ComboBox provincia
		 */
		JComboBox<Object> comboBox_provincia = new JComboBox<Object>(arrProvince);
		GridBagConstraints gbc_comboBox_proincia = new GridBagConstraints();
		gbc_comboBox_proincia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_proincia.fill = GridBagConstraints.BOTH;
		gbc_comboBox_proincia.gridx = 2;
		gbc_comboBox_proincia.gridy = 8;
		panel.add(comboBox_provincia, gbc_comboBox_proincia);
		
		/*
		 * TextField comune
		 */
		GridBagConstraints gbc_textField_comune = new GridBagConstraints();
		textField_comune = new JTextField("Inserire comune");
		textField_comune.setForeground(Color.GRAY);
		textField_comune.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textField_comune.getText().equals("Inserire comune"))
						&& (textField_comune.getForeground().equals(Color.GRAY))) {

					textField_comune.setText("");
					textField_comune.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_comune.getText().equals("")) {

					textField_comune.setText("Inserire comune");
					textField_comune.setForeground(Color.GRAY);
				}
			}
		});
		gbc_textField_comune.gridwidth = 2;
		gbc_textField_comune.insets = new Insets(0, 0, 5, 5);
		gbc_textField_comune.fill = GridBagConstraints.BOTH;
		gbc_textField_comune.gridx = 4;
		gbc_textField_comune.gridy = 8;
		panel.add(textField_comune, gbc_textField_comune);
		textField_comune.setColumns(10);

		/*
		 * Label errore comune
		 */
		JLabel lbl_errComune = new JLabel("errore comune");
		lbl_errComune.setVisible(false);
		lbl_errComune.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errComune = new GridBagConstraints();
		gbc_lbl_errComune.gridwidth = 2;
		gbc_lbl_errComune.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errComune.gridx = 4;
		gbc_lbl_errComune.gridy = 9;
		panel.add(lbl_errComune, gbc_lbl_errComune);

		/*
		 * Label qualificatore via
		 */
		JLabel lbl_qualificatoreVia = new JLabel("Qualificatore via:");
		GridBagConstraints gbc_lbl_qualificatoreVia = new GridBagConstraints();
		gbc_lbl_qualificatoreVia.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_qualificatoreVia.gridx = 1;
		gbc_lbl_qualificatoreVia.gridy = 10;
		panel.add(lbl_qualificatoreVia, gbc_lbl_qualificatoreVia);

		/*
		 * ComboBox tipo via
		 */
		JComboBox<Object> comboBox_tipoVia = new JComboBox<Object>(arrTipoVia);
		GridBagConstraints gbc_comboBox_tipoVia = new GridBagConstraints();
		gbc_comboBox_tipoVia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_tipoVia.fill = GridBagConstraints.BOTH;
		gbc_comboBox_tipoVia.gridx = 2;
		gbc_comboBox_tipoVia.gridy = 10;
		panel.add(comboBox_tipoVia, gbc_comboBox_tipoVia);

		/*
		 * TextField nome via
		 */
		textField_nomeVia = new JTextField("Inserire nome via");
		textField_nomeVia.setForeground(Color.GRAY);
		textField_nomeVia.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textField_nomeVia.getText().equals("Inserire nome via"))
						&& (textField_nomeVia.getForeground().equals(Color.GRAY))) {

					textField_nomeVia.setText("");
					textField_nomeVia.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_nomeVia.getText().equals("")) {

					textField_nomeVia.setText("Inserire nome via");
					textField_nomeVia.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textField_nomeVia = new GridBagConstraints();
		gbc_textField_nomeVia.gridwidth = 2;
		gbc_textField_nomeVia.insets = new Insets(0, 0, 5, 5);
		gbc_textField_nomeVia.fill = GridBagConstraints.BOTH;
		gbc_textField_nomeVia.gridx = 4;
		gbc_textField_nomeVia.gridy = 10;
		panel.add(textField_nomeVia, gbc_textField_nomeVia);
		textField_nomeVia.setColumns(10);

		/*
		 * Label errore nome via
		 */
		JLabel lbl_errNomeVia = new JLabel("errore nome via");
		lbl_errNomeVia.setVisible(false);
		lbl_errNomeVia.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errNomeVia = new GridBagConstraints();
		gbc_lbl_errNomeVia.gridwidth = 2;
		gbc_lbl_errNomeVia.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errNomeVia.gridx = 4;
		gbc_lbl_errNomeVia.gridy = 11;
		panel.add(lbl_errNomeVia, gbc_lbl_errNomeVia);

		/*
		 * TextField numero via
		 */
		textField_numVia = new JTextField("Inserire numero via");
		textField_numVia.setForeground(Color.GRAY);
		textField_numVia.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textField_numVia.getText().equals("Inserire numero via"))
						&& (textField_numVia.getForeground().equals(Color.GRAY))) {

					textField_numVia.setText("");
					textField_numVia.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_numVia.getText().equals("")) {

					textField_numVia.setText("Inserire numero via");
					textField_numVia.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textField_numVia = new GridBagConstraints();
		gbc_textField_numVia.gridwidth = 2;
		gbc_textField_numVia.insets = new Insets(0, 0, 5, 5);
		gbc_textField_numVia.fill = GridBagConstraints.BOTH;
		gbc_textField_numVia.gridx = 1;
		gbc_textField_numVia.gridy = 12;
		panel.add(textField_numVia, gbc_textField_numVia);
		textField_numVia.setColumns(10);

		/*
		 * TextField CAP
		 */
		textField_CAP = new JTextField("Inserire CAP");
		textField_CAP.setForeground(Color.GRAY);
		textField_CAP.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textField_CAP.getText().equals("Inserire CAP"))
						&& (textField_CAP.getForeground().equals(Color.GRAY))) {

					textField_CAP.setText("");
					textField_CAP.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_CAP.getText().equals("")) {

					textField_CAP.setText("Inserire CAP");
					textField_CAP.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textField_CAP = new GridBagConstraints();
		gbc_textField_CAP.gridwidth = 2;
		gbc_textField_CAP.insets = new Insets(0, 0, 5, 5);
		gbc_textField_CAP.fill = GridBagConstraints.BOTH;
		gbc_textField_CAP.gridx = 4;
		gbc_textField_CAP.gridy = 12;
		panel.add(textField_CAP, gbc_textField_CAP);
		textField_CAP.setColumns(10);

		/*
		 * Label errore numero via
		 */
		JLabel lbl_errNumVia = new JLabel("errore numero via");
		lbl_errNumVia.setVisible(false);
		lbl_errNumVia.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errNumVia = new GridBagConstraints();
		gbc_lbl_errNumVia.gridwidth = 2;
		gbc_lbl_errNumVia.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errNumVia.gridx = 1;
		gbc_lbl_errNumVia.gridy = 13;
		panel.add(lbl_errNumVia, gbc_lbl_errNumVia);

		/*
		 * Label errore CAP
		 */
		JLabel lbl_errCAP = new JLabel("errore CAP");
		lbl_errCAP.setVisible(false);
		lbl_errCAP.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errCAP = new GridBagConstraints();
		gbc_lbl_errCAP.gridwidth = 2;
		gbc_lbl_errCAP.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errCAP.gridx = 4;
		gbc_lbl_errCAP.gridy = 13;
		panel.add(lbl_errCAP, gbc_lbl_errCAP);

		/*
		 * Button registra centro
		 */
		JButton btn_regCentro = new JButton("Registra centro");
		btn_regCentro.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				/*
				 * Assegnamento variabili prima della chiamata alla fuznione per il controllo
				 * delle credenziali
				 */
				ID = (String) textField_ID.getText();
				PSW = (String) passwordField_psw.getText();

				/*
				 * Assegnamento variabili prima della chiamata alla funzione per l'inserimento
				 */
				colNomeCentro = textField_nomeCentro.getText();
				colTipoCentro = (String) comboBox_selTipoCentro.getSelectedItem();
				colProvincia = (String) comboBox_provincia.getSelectedItem();
				colComune = textField_comune.getText();
				colTipoVia = (String) comboBox_tipoVia.getSelectedItem();
				colNumeroCivico = Integer.parseInt(textField_numVia.getText());
				colNomeVia = textField_nomeVia.getText();
				colCAP = Integer.parseInt(textField_CAP.getText());

				/*
				 * Chiamata funzione di controllo delle credenziali
				 */
				boolean check = check_cred(ID, PSW);

				/*
				 * Controllo e comparsa errori (se necessario) per i campi JTextField
				 */
				if (colNomeCentro == null || !(colNomeCentro.matches("[a-zA-Z ]+"))) {

					lbl_errNomeCentro.setVisible(true);
					contr[0] = false;
				} else {

					lbl_errNomeCentro.setVisible(false);
					contr[0] = true;
				}

				if (colComune == null || !(colComune.matches("[a-zA-Z ]+"))) {

					lbl_errComune.setVisible(true);
					contr[1] = false;
				} else {

					lbl_errComune.setVisible(false);
					contr[1] = true;
				}

				if (!(colNumeroCivico % 1 == 0)) {

					lbl_errNumVia.setVisible(true);
					contr[2] = false;
				} else {

					lbl_errNumVia.setVisible(false);
					contr[2] = true;
				}

				if (colNomeVia == null || !(colNomeVia.matches("[a-zA-Z ]+"))) {

					lbl_errNomeVia.setVisible(true);
					contr[3] = false;
				} else {

					lbl_errNomeVia.setVisible(false);
					contr[3] = true;
				}

				if (!(colCAP % 1 == 0) || !(colCAP >= 10000 && colCAP <= 99999)) {

					lbl_errCAP.setVisible(true);
					contr[4] = false;
				} else {

					lbl_errCAP.setVisible(false);
					contr[4] = true;
				}

				for (int i = 0; i < 5; i++) {
					System.out.println("val check / contr" + check + ", " + contr[i]);
				}
				/*
				 * Check per credenziali e campi corretti
				 */
				if (check == true && contr[0] == true && contr[1] == true && contr[2] == true && contr[3] == true
						&& contr[4] == true) {

					InserimentoDB(colNomeCentro, colTipoCentro, colProvincia, colComune, colTipoVia, colNumeroCivico,
							colNomeVia, colCAP);
					confermaReg pan = new confermaReg();
					removeAll();
					add(pan);
					repaint();
					revalidate();
				} else {

					System.out.println("Errore");
				}
			}
		});
		GridBagConstraints gbc_btn_regCentro = new GridBagConstraints();
		gbc_btn_regCentro.gridwidth = 5;
		gbc_btn_regCentro.fill = GridBagConstraints.VERTICAL;
		gbc_btn_regCentro.insets = new Insets(0, 0, 5, 5);
		gbc_btn_regCentro.gridx = 1;
		gbc_btn_regCentro.gridy = 14;
		panel.add(btn_regCentro, gbc_btn_regCentro);
	}
}