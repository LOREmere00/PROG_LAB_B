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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registraVaccinato extends JPanel {

	JPanel panel;
	private JTextField textField_ID;
	private JPasswordField passwordField_psw;
	private JTextField textField_nomeVaccinato;
	private JTextField textField_cognomeVaccinato;
	private JTextField textField_codiceFiscale;
	private JTextField textField_dataSom;
	private JTextField textField_IDUinvocoVaccinazione;
	private char c;

	String[] arrTipoVaccino = { "Astrazeneca", "Pfizer", "Jonson&Jonson", "Moderna" };

	public registraVaccinato() {

		setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 100, 225, 100, 225, 100 };
		gbl_panel.rowHeights = new int[] { 75, 40, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 75 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0 };
		panel.setLayout(gbl_panel);
		gestioneLayout();
	}

	private void gestioneLayout() {

		try {

			/*
			 * Inserimento immagine primula
			 */
			BufferedImage prim = ImageIO.read(new File("./src/primula.png"));
			Image newImage = prim.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblPrimula = new JLabel(new ImageIcon(newImage));
			lblPrimula.setPreferredSize(new Dimension(50, 50));
			GridBagConstraints gbc_lblPrimula = new GridBagConstraints();
			gbc_lblPrimula.insets = new Insets(0, 0, 5, 0);
			gbc_lblPrimula.gridx = 4;
			gbc_lblPrimula.gridy = 0;
			panel.add(lblPrimula, gbc_lblPrimula);
		} catch (Exception e) {

			e.printStackTrace();
		}

		/*
		 * Label titolo 1
		 */
		JLabel lbl_title1 = new JLabel("INSERIRE LE CREDENZIALI");
		lbl_title1.setForeground(Color.BLUE);
		lbl_title1.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_title1 = new GridBagConstraints();
		gbc_lbl_title1.anchor = GridBagConstraints.NORTH;
		gbc_lbl_title1.gridwidth = 3;
		gbc_lbl_title1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_title1.gridx = 1;
		gbc_lbl_title1.gridy = 1;
		panel.add(lbl_title1, gbc_lbl_title1);

		/*
		 * TextField nome utente
		 */
		textField_ID = new JTextField("Inserire ID");
		textField_ID.setForeground(Color.GRAY);
		textField_ID.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((textField_ID.getText().equals("Inserire nome utente"))
						&& (textField_ID.getForeground().equals(Color.GRAY))) {

					textField_ID.setText("");
					textField_ID.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_ID.getText().equals("")) {

					textField_ID.setText("Inserire nome utente");
					textField_ID.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textField_ID = new GridBagConstraints();
		gbc_textField_ID.insets = new Insets(0, 0, 5, 5);
		gbc_textField_ID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_ID.gridx = 1;
		gbc_textField_ID.gridy = 2;
		panel.add(textField_ID, gbc_textField_ID);
		textField_ID.setColumns(10);

		/*
		 * PaswordField password
		 */
		passwordField_psw = new JPasswordField("Inserire password");
		c = passwordField_psw.getEchoChar();
		passwordField_psw.setEchoChar((char) 0);
		passwordField_psw.setForeground(Color.GRAY);
		passwordField_psw.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((String.valueOf(passwordField_psw.getPassword()).equals("Inserire password"))
						&& (passwordField_psw.getForeground().equals(Color.GRAY))) {

					passwordField_psw.setEchoChar(c);
					passwordField_psw.setText("");
					passwordField_psw.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (String.valueOf(passwordField_psw.getPassword()).equals("")) {

					passwordField_psw.setText("Inserire password");
					passwordField_psw.setEchoChar((char) 0);
					passwordField_psw.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_passwordField_psw = new GridBagConstraints();
		gbc_passwordField_psw.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_psw.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_psw.gridx = 3;
		gbc_passwordField_psw.gridy = 2;
		panel.add(passwordField_psw, gbc_passwordField_psw);

		/*
		 * Label errore nome utente
		 */
		JLabel lbl_errNomeUtente = new JLabel("errore ID");
		lbl_errNomeUtente.setVisible(false);
		lbl_errNomeUtente.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errNomeUtente = new GridBagConstraints();
		gbc_lbl_errNomeUtente.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errNomeUtente.gridx = 1;
		gbc_lbl_errNomeUtente.gridy = 3;
		panel.add(lbl_errNomeUtente, gbc_lbl_errNomeUtente);

		/*
		 * Label errore password
		 */
		JLabel lbl_errPsw = new JLabel("errore password");
		lbl_errPsw.setVisible(false);
		lbl_errPsw.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errPsw = new GridBagConstraints();
		gbc_lbl_errPsw.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errPsw.gridx = 3;
		gbc_lbl_errPsw.gridy = 3;
		panel.add(lbl_errPsw, gbc_lbl_errPsw);

		/*
		 * Label titolo 2
		 */
		JLabel lbl_title2 = new JLabel(
				"------------------------------------- Dati cittadino -------------------------------------");
		lbl_title2.setForeground(Color.BLACK);
		lbl_title2.setFont(new Font("Gill Sans Nova", Font.BOLD, 13));
		GridBagConstraints gbc_lbl_title2 = new GridBagConstraints();
		gbc_lbl_title2.gridwidth = 3;
		gbc_lbl_title2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_title2.gridx = 1;
		gbc_lbl_title2.gridy = 4;
		panel.add(lbl_title2, gbc_lbl_title2);

		/*
		 * ComboBox nome centro
		 */
		JComboBox<Object> comboBox_nomeCentro = new JComboBox<Object>();
		GridBagConstraints gbc_comboBox_nomeCentro = new GridBagConstraints();
		gbc_comboBox_nomeCentro.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_nomeCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_nomeCentro.gridx = 1;
		gbc_comboBox_nomeCentro.gridy = 6;
		panel.add(comboBox_nomeCentro, gbc_comboBox_nomeCentro);

		/*
		 * ComboBox tipo vaccino
		 */
		JComboBox<Object> comboBox_tipoVaccino = new JComboBox<Object>(arrTipoVaccino);
		GridBagConstraints gbc_comboBox_tipoVaccino = new GridBagConstraints();
		gbc_comboBox_tipoVaccino.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_tipoVaccino.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_tipoVaccino.gridx = 3;
		gbc_comboBox_tipoVaccino.gridy = 6;
		panel.add(comboBox_tipoVaccino, gbc_comboBox_tipoVaccino);

		/*
		 * TextField nome vaccinato
		 */
		textField_nomeVaccinato = new JTextField("Inserire nome vaccinato");
		textField_nomeVaccinato.setForeground(Color.GRAY);
		textField_nomeVaccinato.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textField_nomeVaccinato.getText().equals("Inserire nome")) {

					textField_nomeVaccinato.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_nomeVaccinato.getText().equals(""))
					;

				textField_nomeVaccinato.setText("Inserire nome");
			}
		});
		GridBagConstraints gbc_textField_nomeVaccinato = new GridBagConstraints();
		gbc_textField_nomeVaccinato.insets = new Insets(0, 0, 5, 5);
		gbc_textField_nomeVaccinato.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_nomeVaccinato.gridx = 1;
		gbc_textField_nomeVaccinato.gridy = 8;
		panel.add(textField_nomeVaccinato, gbc_textField_nomeVaccinato);
		textField_nomeVaccinato.setColumns(10);

		/*
		 * TextField cognome vaccinato
		 */
		textField_cognomeVaccinato = new JTextField("Inserire cognome vaccinato");
		textField_cognomeVaccinato.setForeground(Color.GRAY);
		textField_cognomeVaccinato.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textField_cognomeVaccinato.getText().equals("Inserire cognome")) {

					textField_cognomeVaccinato.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_cognomeVaccinato.getText().equals(""))
					;

				textField_cognomeVaccinato.setText("Inserire cognome");
			}
		});
		GridBagConstraints gbc_textField_cognomeVaccinato = new GridBagConstraints();
		gbc_textField_cognomeVaccinato.insets = new Insets(0, 0, 5, 5);
		gbc_textField_cognomeVaccinato.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_cognomeVaccinato.gridx = 3;
		gbc_textField_cognomeVaccinato.gridy = 8;
		panel.add(textField_cognomeVaccinato, gbc_textField_cognomeVaccinato);
		textField_cognomeVaccinato.setColumns(10);

		/*
		 * Label errore nome vaccinato
		 */
		JLabel lbl_errNome = new JLabel("errore nome vaccinato");
		lbl_errNome.setVisible(false);
		lbl_errNome.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errNome = new GridBagConstraints();
		gbc_lbl_errNome.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errNome.gridx = 1;
		gbc_lbl_errNome.gridy = 9;
		panel.add(lbl_errNome, gbc_lbl_errNome);

		/*
		 * Label errore cognome vaccinato
		 */
		JLabel lbl_errCognome = new JLabel("errore cognome vaccinato");
		lbl_errCognome.setVisible(false);
		lbl_errCognome.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errCognome = new GridBagConstraints();
		gbc_lbl_errCognome.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errCognome.gridx = 3;
		gbc_lbl_errCognome.gridy = 9;
		panel.add(lbl_errCognome, gbc_lbl_errCognome);

		/*
		 * TextField codice fiscale vaccinato
		 */
		textField_codiceFiscale = new JTextField("Inserire codice fiscale vaccinato");
		textField_codiceFiscale.setForeground(Color.GRAY);
		textField_codiceFiscale.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textField_codiceFiscale.getText().equals("Inserire codice fiscale")) {

					textField_codiceFiscale.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_codiceFiscale.getText().equals(""))
					;

				textField_codiceFiscale.setText("Inserire codice fiscale");
			}
		});
		GridBagConstraints gbc_textField_codiceFiscale = new GridBagConstraints();
		gbc_textField_codiceFiscale.insets = new Insets(0, 0, 5, 5);
		gbc_textField_codiceFiscale.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_codiceFiscale.gridx = 1;
		gbc_textField_codiceFiscale.gridy = 10;
		panel.add(textField_codiceFiscale, gbc_textField_codiceFiscale);
		textField_codiceFiscale.setColumns(10);

		/*
		 * TextField data somministrazione
		 */
		textField_dataSom = new JTextField("Inserire data somministrazione");
		textField_dataSom.setForeground(Color.GRAY);
		textField_dataSom.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textField_dataSom.getText().equals("Inserire data somministrazione")) {

					textField_dataSom.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_dataSom.getText().equals(""))
					;

				textField_dataSom.setText("Inserire data somministrazione");
			}
		});
		GridBagConstraints gbc_textField_dataSom = new GridBagConstraints();
		gbc_textField_dataSom.insets = new Insets(0, 0, 5, 5);
		gbc_textField_dataSom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dataSom.gridx = 3;
		gbc_textField_dataSom.gridy = 10;
		panel.add(textField_dataSom, gbc_textField_dataSom);
		textField_dataSom.setColumns(10);

		/*
		 * Label errore codice fiscale
		 */
		JLabel lbl_errCF = new JLabel("errore CF vaccinato");
		lbl_errCF.setVisible(false);
		lbl_errCF.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errCF = new GridBagConstraints();
		gbc_lbl_errCF.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errCF.gridx = 1;
		gbc_lbl_errCF.gridy = 11;
		panel.add(lbl_errCF, gbc_lbl_errCF);

		/*
		 * Label errore data somministrazione
		 */
		JLabel lbl_errDataSomm = new JLabel("errore data somministrazione");
		lbl_errDataSomm.setVisible(false);
		lbl_errDataSomm.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errDataSomm = new GridBagConstraints();
		gbc_lbl_errDataSomm.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errDataSomm.gridx = 3;
		gbc_lbl_errDataSomm.gridy = 11;
		panel.add(lbl_errDataSomm, gbc_lbl_errDataSomm);

		/*
		 * TextField ID vaccinazione
		 */
		textField_IDUinvocoVaccinazione = new JTextField("Inserire ID univoco vaccinazione");
		textField_IDUinvocoVaccinazione.setForeground(Color.GRAY);
		textField_IDUinvocoVaccinazione.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textField_IDUinvocoVaccinazione.getText().equals("Inserire ID vaccinazione")) {

					textField_IDUinvocoVaccinazione.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textField_IDUinvocoVaccinazione.getText().equals(""))
					;

				textField_IDUinvocoVaccinazione.setText("Inserire ID vaccinazione");
			}
		});
		GridBagConstraints gbc_textField_IDUinvocoVaccinazione = new GridBagConstraints();
		gbc_textField_IDUinvocoVaccinazione.insets = new Insets(0, 0, 5, 5);
		gbc_textField_IDUinvocoVaccinazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_IDUinvocoVaccinazione.gridx = 1;
		gbc_textField_IDUinvocoVaccinazione.gridy = 12;
		panel.add(textField_IDUinvocoVaccinazione, gbc_textField_IDUinvocoVaccinazione);
		textField_IDUinvocoVaccinazione.setColumns(10);

		/*
		 * Label errore ID vaccinazione
		 */
		JLabel lbl_errIDVaccinazione = new JLabel("errore ID univoco vaccinazione");
		lbl_errIDVaccinazione.setVisible(false);
		lbl_errIDVaccinazione.setForeground(Color.RED);
		GridBagConstraints gbc_lbl_errIDVaccinazione = new GridBagConstraints();
		gbc_lbl_errIDVaccinazione.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_errIDVaccinazione.gridx = 1;
		gbc_lbl_errIDVaccinazione.gridy = 13;
		panel.add(lbl_errIDVaccinazione, gbc_lbl_errIDVaccinazione);

		/*
		 * Button registra cittadino
		 */
		JButton btn_regCitt = new JButton("Registra cittadino");
		btn_regCitt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				confermaReg pan = new confermaReg();
				removeAll();
				add(pan);
				repaint();
				revalidate();
			}
		});
		btn_regCitt.setFont(new Font("Gill Sans Nova", Font.BOLD, 12));
		GridBagConstraints gbc_btn_regCitt = new GridBagConstraints();
		gbc_btn_regCitt.anchor = GridBagConstraints.EAST;
		gbc_btn_regCitt.insets = new Insets(0, 0, 5, 5);
		gbc_btn_regCitt.gridx = 1;
		gbc_btn_regCitt.gridy = 14;
		panel.add(btn_regCitt, gbc_btn_regCitt);

		/*
		 * Label oppure
		 */
		JLabel lbl_oppure = new JLabel(" oppure ");
		lbl_oppure.setFont(new Font("Gill Sans Nova", Font.BOLD, 13));
		GridBagConstraints gbc_lbl_oppure = new GridBagConstraints();
		gbc_lbl_oppure.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_oppure.gridx = 2;
		gbc_lbl_oppure.gridy = 14;
		panel.add(lbl_oppure, gbc_lbl_oppure);

		/*
		 * Button registra centro
		 */
		JButton btn_regCentro = new JButton("Registra centro");
		btn_regCentro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				registraCentroVaccinale regPan = new registraCentroVaccinale();
				removeAll();
				add(regPan);
				repaint();
				revalidate();
			}
		});
		btn_regCentro.setFont(new Font("Gill Sans Nova", Font.BOLD, 12));
		GridBagConstraints gbc_btn_regCentro = new GridBagConstraints();
		gbc_btn_regCentro.anchor = GridBagConstraints.WEST;
		gbc_btn_regCentro.insets = new Insets(0, 0, 5, 5);
		gbc_btn_regCentro.gridx = 3;
		gbc_btn_regCentro.gridy = 14;
		panel.add(btn_regCentro, gbc_btn_regCentro);

	}
}
