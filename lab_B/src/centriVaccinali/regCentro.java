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
import java.sql.PreparedStatement;
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

public class regCentro extends JPanel {

	/*
	 * Variabili per il layout
	 */
	JPanel panel;
	private JTextField textFieldID;
	private JTextField textFieldComune;
	private JTextField textFieldCap;
	private JTextField textFieldNumVia;
	private JTextField textFieldNomeVia;
	private JPasswordField pswField;
	private char c;
	String risComboQualificatore;
	String colonnaQuery, tabQuery;

	/*
	 * Variabili per connessione al DB
	 */
	String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
	String username = "postgres";
	String password = "postgres";

	/*
	 * Dichiarazione variabili per inserimento in database (col -> colonna)
	 */
	String colNomeCentro, colNomeVia, colComune, colProvincia;
	int colQualificatore, colNumeroCivico, colCAP, colTipologia;

	public regCentro() {

		setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 100, 112, 113, 100, 225, 100, 0 };
		gbl_panel.rowHeights = new int[] { 75, 40, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 75, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		// prova
		colonnaQuery = "nome_regione";
		tabQuery = "regioni_province";
		RichiestaDB(colonnaQuery, tabQuery);

		GestioneLayout();
	}

	private void RichiestaDB(String colonnaQuery, String tabQuery) {

		try {

			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("connessione al server DB per richiesta avvenuta con successo.");
			String sql = "SELECT DISTINCT " + colonnaQuery + " FROM " + tabQuery;

			Statement statement = connection.createStatement();
			ResultSet resSet = statement.executeQuery(sql);
			String[] res = new String[20];
			int i = 0;
			while (resSet.next()) {

				res[i] = resSet.getString(colonnaQuery);
				i++;
				System.out.println("risultato: " + res[i]);
			}
			connection.close();
		} catch (SQLException e) {

			System.out.println("connessione al DB in richiesta fallita.");
			e.printStackTrace();
		}
	}

	private void InserimentoDB(String colNomeCentro, int colQualificatore, String colNomeVia, int colNumeroCivico,
			String colComune, String colProvincia, int colCAP, int colTipologia) {

		try {

			/*
			 * Apertura connessione DB
			 */
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("connessione al server DB per inserimento avvenuta con successo.");

			/*
			 * Preparazione della query di inserimento
			 */
			String sql = "INSERT INTO centrivaccinali VALUES (nome_centro, qualificatore, nome_via, numero_civico, comune, provincia, cap, tipologia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, colNomeCentro);
			statement.setInt(2, colQualificatore);
			statement.setString(3, colNomeVia);
			statement.setInt(4, colNumeroCivico);
			statement.setString(5, colComune);
			statement.setString(6, colProvincia);
			statement.setInt(7, colCAP);
			statement.setInt(8, colTipologia);

			int rows = statement.executeUpdate();
			if (rows > 0) {

				System.out.println("Centro vaccinale inserito.");
			}
			/*
			 * Chiusura connessione DB
			 */
			connection.close();
		} catch (SQLException e) {

			System.out.println("connessione al DB in inserimento fallita.");
			e.printStackTrace();
		}
	}

	private void GestioneLayout() {

		String[] arrTipoVia = { "via", "viale", "piazzale" };
		String[] arrTipologiaVacc = { "ospedaliero", "hub", "aziendale" };
		String[] arrTipoVaccino = { "Astrazeneca", "Pfizer", "Jonson&Jonson", "Moderna" };

		try {

			// Inserimento immagine primula
			BufferedImage prim = ImageIO.read(new File("./src/primula.png"));
			Image newPrim = prim.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblPrim = new JLabel(new ImageIcon(newPrim));
			lblPrim.setPreferredSize(new Dimension(50, 50));
			GridBagConstraints gbc_lblPrim = new GridBagConstraints();
			gbc_lblPrim.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lblPrim.insets = new Insets(0, 0, 5, 0);
			gbc_lblPrim.gridx = 5;
			gbc_lblPrim.gridy = 0;
			panel.add(lblPrim, gbc_lblPrim);

			// Inserimento immagine/pulsante "goBack"
			BufferedImage back = ImageIO.read(new File("./src/gobackb.png"));
			Image newBack = back.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JButton butt = new JButton(new ImageIcon(newBack));
			butt.setContentAreaFilled(false);
			butt.setBorderPainted(false);
			butt.setPreferredSize(new Dimension(75, 90));
			butt.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					regCitt home = new regCitt();
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

		JLabel lbl_credentials = new JLabel("INSERIRE LE CREDENZIALI");
		lbl_credentials.setForeground(Color.BLUE);
		lbl_credentials.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_credentials = new GridBagConstraints();
		gbc_lbl_credentials.anchor = GridBagConstraints.NORTH;
		gbc_lbl_credentials.gridwidth = 4;
		gbc_lbl_credentials.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_credentials.gridx = 1;
		gbc_lbl_credentials.gridy = 1;
		panel.add(lbl_credentials, gbc_lbl_credentials);

		textFieldID = new JTextField("Inserire ID");
		textFieldID.setForeground(Color.GRAY);
		textFieldID.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textFieldID.getText().equals("Inserire ID")) && (textFieldID.getForeground().equals(Color.GRAY))) {

					textFieldID.setText("");
					textFieldID.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldID.getText().equals("")) {

					textFieldID.setText("Inserire ID");
					textFieldID.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textFieldID = new GridBagConstraints();
		gbc_textFieldID.gridwidth = 2;
		gbc_textFieldID.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldID.fill = GridBagConstraints.BOTH;
		gbc_textFieldID.gridx = 1;
		gbc_textFieldID.gridy = 2;
		panel.add(textFieldID, gbc_textFieldID);
		textFieldID.setColumns(10);

		pswField = new JPasswordField("Inserire la password");
		c = pswField.getEchoChar();
		pswField.setEchoChar((char) 0);
		pswField.setForeground(Color.GRAY);
		pswField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((String.valueOf(pswField.getPassword()).equals("Inserire la password"))
						&& (pswField.getForeground().equals(Color.GRAY))) {

					pswField.setEchoChar(c);
					pswField.setText("");
					pswField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (String.valueOf(pswField.getPassword()).equals("")) {

					pswField.setText("Inserire la password");
					pswField.setEchoChar((char) 0);
					pswField.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_pswField = new GridBagConstraints();
		gbc_pswField.insets = new Insets(0, 0, 5, 5);
		gbc_pswField.fill = GridBagConstraints.BOTH;
		gbc_pswField.gridx = 4;
		gbc_pswField.gridy = 2;
		panel.add(pswField, gbc_pswField);

		JLabel errID = new JLabel("errore ID");
		errID.setVisible(false);
		errID.setForeground(Color.RED);
		GridBagConstraints gbc_errID = new GridBagConstraints();
		gbc_errID.gridwidth = 2;
		gbc_errID.insets = new Insets(0, 0, 5, 5);
		gbc_errID.gridx = 1;
		gbc_errID.gridy = 3;
		panel.add(errID, gbc_errID);

		JLabel errPsw = new JLabel("errore password");
		errPsw.setVisible(false);
		errPsw.setForeground(Color.RED);
		GridBagConstraints gbc_errPsw = new GridBagConstraints();
		gbc_errPsw.insets = new Insets(0, 0, 5, 5);
		gbc_errPsw.gridx = 4;
		gbc_errPsw.gridy = 3;
		panel.add(errPsw, gbc_errPsw);

		JLabel lblNewLabel_2 = new JLabel(
				"---------------------------------- Dati centro vaccinale ----------------------------------");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Gill Sans Nova", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 6;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JComboBox<Object> regione = new JComboBox<Object>();
		GridBagConstraints gbc_regione = new GridBagConstraints();
		gbc_regione.gridwidth = 2;
		gbc_regione.insets = new Insets(0, 0, 5, 5);
		gbc_regione.fill = GridBagConstraints.BOTH;
		gbc_regione.gridx = 1;
		gbc_regione.gridy = 6;
		panel.add(regione, gbc_regione);

		JComboBox<Object> provincia = new JComboBox<Object>();
		GridBagConstraints gbc_proincia = new GridBagConstraints();
		gbc_proincia.insets = new Insets(0, 0, 5, 5);
		gbc_proincia.fill = GridBagConstraints.BOTH;
		gbc_proincia.gridx = 4;
		gbc_proincia.gridy = 6;
		panel.add(provincia, gbc_proincia);

		textFieldComune = new JTextField("Inserire comune");
		textFieldComune.setForeground(Color.GRAY);
		textFieldComune.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textFieldComune.getText().equals("Inserire comune"))
						&& (textFieldComune.getForeground().equals(Color.GRAY))) {

					textFieldComune.setText("");
					textFieldComune.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldComune.getText().equals("")) {

					textFieldComune.setText("Inserire comune");
					textFieldComune.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_comune = new GridBagConstraints();
		gbc_comune.gridwidth = 2;
		gbc_comune.insets = new Insets(0, 0, 5, 5);
		gbc_comune.fill = GridBagConstraints.BOTH;
		gbc_comune.gridx = 1;
		gbc_comune.gridy = 8;
		panel.add(textFieldComune, gbc_comune);
		textFieldComune.setColumns(10);

		textFieldCap = new JTextField("Inserire CAP");
		textFieldCap.setForeground(Color.GRAY);
		textFieldCap.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textFieldCap.getText().equals("Inserire CAP"))
						&& (textFieldCap.getForeground().equals(Color.GRAY))) {

					textFieldCap.setText("");
					textFieldCap.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldCap.getText().equals("")) {

					textFieldCap.setText("Inserire CAP");
					textFieldCap.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_cap = new GridBagConstraints();
		gbc_cap.insets = new Insets(0, 0, 5, 5);
		gbc_cap.fill = GridBagConstraints.BOTH;
		gbc_cap.gridx = 4;
		gbc_cap.gridy = 8;
		panel.add(textFieldCap, gbc_cap);
		textFieldCap.setColumns(10);

		JLabel errComune = new JLabel("errore comune");
		errComune.setVisible(false);
		errComune.setForeground(Color.RED);
		GridBagConstraints gbc_errComune = new GridBagConstraints();
		gbc_errComune.gridwidth = 2;
		gbc_errComune.insets = new Insets(0, 0, 5, 5);
		gbc_errComune.gridx = 1;
		gbc_errComune.gridy = 9;
		panel.add(errComune, gbc_errComune);

		JLabel errCAP = new JLabel("errore CAP");
		errCAP.setVisible(false);
		errCAP.setForeground(Color.RED);
		GridBagConstraints gbc_errCAP = new GridBagConstraints();
		gbc_errCAP.insets = new Insets(0, 0, 5, 5);
		gbc_errCAP.gridx = 4;
		gbc_errCAP.gridy = 9;
		panel.add(errCAP, gbc_errCAP);

		JComboBox<Object> tipoVia = new JComboBox<Object>(arrTipoVia);
		GridBagConstraints gbc_tipoVia = new GridBagConstraints();
		gbc_tipoVia.insets = new Insets(0, 0, 5, 5);
		gbc_tipoVia.fill = GridBagConstraints.BOTH;
		gbc_tipoVia.gridx = 1;
		gbc_tipoVia.gridy = 10;
		panel.add(tipoVia, gbc_tipoVia);

		textFieldNumVia = new JTextField("Inserire numero via");
		textFieldNumVia.setForeground(Color.GRAY);
		textFieldNumVia.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textFieldNumVia.getText().equals("Inserire numero via"))
						&& (textFieldNumVia.getForeground().equals(Color.GRAY))) {

					textFieldNumVia.setText("");
					textFieldNumVia.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldNumVia.getText().equals("")) {

					textFieldNumVia.setText("Inserire numero via");
					textFieldNumVia.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textFieldNumVia = new GridBagConstraints();
		gbc_textFieldNumVia.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumVia.fill = GridBagConstraints.BOTH;
		gbc_textFieldNumVia.gridx = 2;
		gbc_textFieldNumVia.gridy = 10;
		panel.add(textFieldNumVia, gbc_textFieldNumVia);
		textFieldNumVia.setColumns(10);

		textFieldNomeVia = new JTextField("Inserire nome via");
		textFieldNomeVia.setForeground(Color.GRAY);
		textFieldNomeVia.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textFieldNomeVia.getText().equals("Inserire nome via"))
						&& (textFieldNomeVia.getForeground().equals(Color.GRAY))) {

					textFieldNomeVia.setText("");
					textFieldNomeVia.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldNomeVia.getText().equals("")) {

					textFieldNomeVia.setText("Inserire nome via");
					textFieldNomeVia.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_nomeVia = new GridBagConstraints();
		gbc_nomeVia.insets = new Insets(0, 0, 5, 5);
		gbc_nomeVia.fill = GridBagConstraints.BOTH;
		gbc_nomeVia.gridx = 4;
		gbc_nomeVia.gridy = 10;
		panel.add(textFieldNomeVia, gbc_nomeVia);
		textFieldNomeVia.setColumns(10);

		JLabel errNumVia = new JLabel("errore numero via");
		errNumVia.setVisible(false);
		errNumVia.setForeground(Color.RED);
		GridBagConstraints gbc_errNumVia = new GridBagConstraints();
		gbc_errNumVia.insets = new Insets(0, 0, 5, 5);
		gbc_errNumVia.gridx = 2;
		gbc_errNumVia.gridy = 11;
		panel.add(errNumVia, gbc_errNumVia);

		JLabel errNomeVia = new JLabel("errore nome via");
		errNomeVia.setVisible(false);
		errNomeVia.setForeground(Color.RED);
		GridBagConstraints gbc_errNomeVia = new GridBagConstraints();
		gbc_errNomeVia.insets = new Insets(0, 0, 5, 5);
		gbc_errNomeVia.gridx = 4;
		gbc_errNomeVia.gridy = 11;
		panel.add(errNomeVia, gbc_errNomeVia);

		JLabel nomeCentro = new JLabel("Centro Vaccinale:");
		GridBagConstraints gbc_nomeCentro = new GridBagConstraints();
		gbc_nomeCentro.fill = GridBagConstraints.VERTICAL;
		gbc_nomeCentro.anchor = GridBagConstraints.EAST;
		gbc_nomeCentro.insets = new Insets(0, 0, 5, 5);
		gbc_nomeCentro.gridx = 1;
		gbc_nomeCentro.gridy = 12;
		panel.add(nomeCentro, gbc_nomeCentro);

		JComboBox<Object> selCentro = new JComboBox<Object>(arrTipologiaVacc);
		GridBagConstraints gbc_selCentro = new GridBagConstraints();
		gbc_selCentro.insets = new Insets(0, 0, 5, 5);
		gbc_selCentro.fill = GridBagConstraints.BOTH;
		gbc_selCentro.gridx = 2;
		gbc_selCentro.gridy = 12;
		panel.add(selCentro, gbc_selCentro);

		JComboBox<Object> tipoVaccino = new JComboBox<Object>(arrTipoVaccino);
		GridBagConstraints gbc_tipoVaccino = new GridBagConstraints();
		gbc_tipoVaccino.insets = new Insets(0, 0, 5, 5);
		gbc_tipoVaccino.fill = GridBagConstraints.BOTH;
		gbc_tipoVaccino.gridx = 4;
		gbc_tipoVaccino.gridy = 12;
		panel.add(tipoVaccino, gbc_tipoVaccino);

		JButton btnRegCentro = new JButton("Registra centro");
		btnRegCentro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {


				/*
				 * Assegnamento variabili prima della chiamata alla funzione per l'inserimento
				 */
				risComboQualificatore = (String) tipoVia.getSelectedItem();
				colNomeCentro = textFieldComune.getText();
				colQualificatore = (int) tipoVia.getSelectedItem();
				colNomeVia = textFieldNomeVia.getText();
				colNumeroCivico = Integer.parseInt(textFieldNumVia.getText());
				colComune = textFieldComune.getText();
				colCAP = Integer.parseInt(textFieldCap.getText());

				InserimentoDB(colNomeCentro, colQualificatore, colNomeVia, colNumeroCivico, colComune, colProvincia,
						colCAP, colTipologia);
				confermaReg pan = new confermaReg();
				removeAll();
				add(pan);
				repaint();
				revalidate();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 4;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 14;
		panel.add(btnRegCentro, gbc_btnNewButton);

	}
}