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

public class regCitt extends JPanel {
	private JTextField textFieldNomeUtente;
	private JPasswordField passwordField;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldCF;
	private JTextField textFieldData;
	private JTextField textFieldIDVaccinazione;
	private char c;

	public regCitt() {

		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 100, 225, 100, 225, 100, 0 };
		gbl_panel.rowHeights = new int[] { 100, 40, 25, 25, 25, 25, 10, 25, 25, 25, 25, 0, 25, 25, 100, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		try {
			
			// Inserimento immagine primula
			BufferedImage prim = ImageIO.read(new File("./src/primula.png"));
			Image newImage = prim.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblPrimula = new JLabel(new ImageIcon(newImage));
			lblPrimula.setPreferredSize(new Dimension(50, 50));
			GridBagConstraints gbc_lblPrimula = new GridBagConstraints();
			gbc_lblPrimula.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrimula.gridx = 4;
			gbc_lblPrimula.gridy = 0;
			panel.add(lblPrimula, gbc_lblPrimula);
		} catch (Exception e) {

			e.printStackTrace();
		}

		JLabel lbl_credentials = new JLabel("INSERIRE LE CREDENZIALI");
		lbl_credentials.setForeground(Color.BLUE);
		lbl_credentials.setFont(new Font("Gill Sans Nova", Font.BOLD, 15));
		GridBagConstraints gbc_lbl_credentials = new GridBagConstraints();
		gbc_lbl_credentials.gridwidth = 3;
		gbc_lbl_credentials.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_credentials.gridx = 1;
		gbc_lbl_credentials.gridy = 1;
		panel.add(lbl_credentials, gbc_lbl_credentials);

		textFieldNomeUtente = new JTextField("Inserire nome utente");
		textFieldNomeUtente.setForeground(Color.GRAY);
		textFieldNomeUtente.addFocusListener(new FocusListener() {
			
			public void focusGained(FocusEvent e) {
				
				if ((textFieldNomeUtente.getText().equals("Inserire nome utente"))
						&& (textFieldNomeUtente.getForeground().equals(Color.GRAY))) {
					
					textFieldNomeUtente.setText("");
					textFieldNomeUtente.setForeground(Color.BLACK);
				}
			}
			
			public void focusLost(FocusEvent e) {
				
				if (textFieldNomeUtente.getText().equals("")) {
					
					textFieldNomeUtente.setText("Inserire nome utente");
					textFieldNomeUtente.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_textFieldNomeUtente = new GridBagConstraints();
		gbc_textFieldNomeUtente.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomeUtente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomeUtente.gridx = 1;
		gbc_textFieldNomeUtente.gridy = 2;
		panel.add(textFieldNomeUtente, gbc_textFieldNomeUtente);
		textFieldNomeUtente.setColumns(10);

		passwordField = new JPasswordField("Inserire password");
		c = passwordField.getEchoChar();
		passwordField.setEchoChar((char) 0);
		passwordField.setForeground(Color.GRAY);
		passwordField.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if ((String.valueOf(passwordField.getPassword()).equals("Inserire password"))
						&& (passwordField.getForeground().equals(Color.GRAY))) {

					passwordField.setEchoChar(c);
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
				}
			}

			public void focusLost(FocusEvent e) {

				if (String.valueOf(passwordField.getPassword()).equals("")) {

					passwordField.setText("Inserire password");
					passwordField.setEchoChar((char) 0);
					passwordField.setForeground(Color.GRAY);
				}
			}
		});
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 2;
		panel.add(passwordField, gbc_passwordField);

		JLabel errNomeUtente = new JLabel("errore nome utente");
		errNomeUtente.setVisible(false);
		errNomeUtente.setForeground(Color.RED);
		GridBagConstraints gbc_errNomeUtente = new GridBagConstraints();
		gbc_errNomeUtente.insets = new Insets(0, 0, 5, 5);
		gbc_errNomeUtente.gridx = 1;
		gbc_errNomeUtente.gridy = 3;
		panel.add(errNomeUtente, gbc_errNomeUtente);

		JLabel errPsw = new JLabel("errore password");
		errPsw.setVisible(false);
		errPsw.setForeground(Color.RED);
		GridBagConstraints gbc_errPsw = new GridBagConstraints();
		gbc_errPsw.insets = new Insets(0, 0, 5, 5);
		gbc_errPsw.gridx = 3;
		gbc_errPsw.gridy = 3;
		panel.add(errPsw, gbc_errPsw);

		JLabel lblNewLabel_2 = new JLabel(
				"------------------------------------- Dati cittadino -------------------------------------");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Gill Sans Nova", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JComboBox comboBox_nomeCentro = new JComboBox();
		GridBagConstraints gbc_comboBox_nomeCentro = new GridBagConstraints();
		gbc_comboBox_nomeCentro.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_nomeCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_nomeCentro.gridx = 1;
		gbc_comboBox_nomeCentro.gridy = 5;
		panel.add(comboBox_nomeCentro, gbc_comboBox_nomeCentro);

		JComboBox comboBox_tipoVaccino = new JComboBox();
		GridBagConstraints gbc_comboBox_tipoVaccino = new GridBagConstraints();
		gbc_comboBox_tipoVaccino.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_tipoVaccino.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_tipoVaccino.gridx = 3;
		gbc_comboBox_tipoVaccino.gridy = 5;
		panel.add(comboBox_tipoVaccino, gbc_comboBox_tipoVaccino);

		textFieldNome = new JTextField("Inserire nome");
		textFieldNome.setForeground(Color.GRAY);
		textFieldNome.addFocusListener(new FocusListener() {
			
			public void focusGained(FocusEvent e) {
				
				if (textFieldNome.getText().equals("Inserire nome")) {
					
					textFieldNome.setText("");
				}
			}
			
			public void focusLost(FocusEvent e) {
				
				if (textFieldNome.getText().equals(""))
					;
				
				textFieldNome.setText("Inserire nome");
			}
		});
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 7;
		panel.add(textFieldNome, gbc_textField_1);
		textFieldNome.setColumns(10);

		textFieldCognome = new JTextField("Inserire cognome");
		textFieldCognome.setForeground(Color.GRAY);
		textFieldCognome.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textFieldCognome.getText().equals("Inserire cognome")) {

					textFieldCognome.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldCognome.getText().equals(""))
					;

				textFieldCognome.setText("Inserire cognome");
			}
		});
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 7;
		panel.add(textFieldCognome, gbc_textField_2);
		textFieldCognome.setColumns(10);

		JLabel errNome = new JLabel("errore nome");
		errNome.setVisible(false);
		errNome.setForeground(Color.RED);
		GridBagConstraints gbc_errNome = new GridBagConstraints();
		gbc_errNome.insets = new Insets(0, 0, 5, 5);
		gbc_errNome.gridx = 1;
		gbc_errNome.gridy = 8;
		panel.add(errNome, gbc_errNome);

		JLabel errCognome = new JLabel("errore cognome");
		errCognome.setVisible(false);
		errCognome.setForeground(Color.RED);
		GridBagConstraints gbc_errCognome = new GridBagConstraints();
		gbc_errCognome.insets = new Insets(0, 0, 5, 5);
		gbc_errCognome.gridx = 3;
		gbc_errCognome.gridy = 8;
		panel.add(errCognome, gbc_errCognome);

		textFieldCF = new JTextField("Inserire codice fiscale");
		textFieldCF.setForeground(Color.GRAY);
		textFieldCF.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textFieldCF.getText().equals("Inserire codice fiscale")) {

					textFieldCF.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldCF.getText().equals(""))
					;

				textFieldCF.setText("Inserire codice fiscale");
			}
		});
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 9;
		panel.add(textFieldCF, gbc_textField_3);
		textFieldCF.setColumns(10);

		textFieldData = new JTextField("Inserire data somministrazione");
		textFieldData.setForeground(Color.GRAY);
		textFieldData.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textFieldData.getText().equals("Inserire data somministrazione")) {

					textFieldData.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldData.getText().equals(""))
					;

				textFieldData.setText("Inserire data somministrazione");
			}
		});
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 9;
		panel.add(textFieldData, gbc_textField_4);
		textFieldData.setColumns(10);

		JLabel errCF = new JLabel("errore CF");
		errCF.setVisible(false);
		errCF.setForeground(Color.RED);
		GridBagConstraints gbc_errCF = new GridBagConstraints();
		gbc_errCF.insets = new Insets(0, 0, 5, 5);
		gbc_errCF.gridx = 1;
		gbc_errCF.gridy = 10;
		panel.add(errCF, gbc_errCF);

		JLabel errDataSomm = new JLabel("errore data somministrazione");
		errDataSomm.setVisible(false);
		errDataSomm.setForeground(Color.RED);
		GridBagConstraints gbc_errDataSomm = new GridBagConstraints();
		gbc_errDataSomm.insets = new Insets(0, 0, 5, 5);
		gbc_errDataSomm.gridx = 3;
		gbc_errDataSomm.gridy = 10;
		panel.add(errDataSomm, gbc_errDataSomm);

		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 11;
		panel.add(comboBox, gbc_comboBox);

		textFieldIDVaccinazione = new JTextField("Inserire ID vaccinazione");
		textFieldIDVaccinazione.setForeground(Color.GRAY);
		textFieldIDVaccinazione.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {

				if (textFieldIDVaccinazione.getText().equals("Inserire ID vaccinazione")) {

					textFieldIDVaccinazione.setText("");
				}
			}

			public void focusLost(FocusEvent e) {

				if (textFieldIDVaccinazione.getText().equals(""))
					;

				textFieldIDVaccinazione.setText("Inserire ID vaccinazione");
			}
		});
		GridBagConstraints gbc_textFieldIDVaccinazione = new GridBagConstraints();
		gbc_textFieldIDVaccinazione.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIDVaccinazione.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIDVaccinazione.gridx = 3;
		gbc_textFieldIDVaccinazione.gridy = 11;
		panel.add(textFieldIDVaccinazione, gbc_textFieldIDVaccinazione);
		textFieldIDVaccinazione.setColumns(10);

		JLabel errIDUnivoco = new JLabel("errore ID univoco");
		errIDUnivoco.setVisible(false);
		errIDUnivoco.setForeground(Color.RED);
		GridBagConstraints gbc_errIDUnivoco = new GridBagConstraints();
		gbc_errIDUnivoco.insets = new Insets(0, 0, 5, 5);
		gbc_errIDUnivoco.gridx = 3;
		gbc_errIDUnivoco.gridy = 12;
		panel.add(errIDUnivoco, gbc_errIDUnivoco);

		JButton btnRegCitt = new JButton("Registra cittadino");
		btnRegCitt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				confermaReg pan = new confermaReg();
				removeAll();
				add(pan);
				repaint();
				revalidate();
			}
		});
		btnRegCitt.setFont(new Font("Gill Sans Nova", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 13;
		panel.add(btnRegCitt, gbc_btnNewButton);

		JLabel lblNewLabel_7 = new JLabel(" oppure ");
		lblNewLabel_7.setFont(new Font("Gill Sans Nova", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 13;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		JButton btn_regCentro = new JButton("Registra centro");
		btn_regCentro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				regCentro regPan = new regCentro();
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
		gbc_btn_regCentro.gridy = 13;
		panel.add(btn_regCentro, gbc_btn_regCentro);


	}
}
