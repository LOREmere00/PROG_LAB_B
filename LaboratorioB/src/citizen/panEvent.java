package citizen;



import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.File;

import java.util.ArrayList;

import javax.imageio.ImageIO;



public class panEvent extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String nomecentro;
	private String vaccinoricevuto;
	
	public panEvent(ArrayList<String> infopack, Boolean homepos, Boolean searchpos) {
		costruisciPan6(infopack, homepos, searchpos);
	}
	
	protected void costruisciPan6(ArrayList<String> infopack, Boolean homepos, Boolean searchpos) {
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pseven = new JPanel();
		add(pseven);
		GridBagLayout gbl_pseven = new GridBagLayout();
		gbl_pseven.columnWidths = new int[]{100, 100, 100, 50, 65, 80, 95, 100, 0};
		gbl_pseven.rowHeights = new int[]{100, 20, 20, 20, 30, 30, 30, 40, 40, 30, 150, 40, 40, 100, 0};
		gbl_pseven.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pseven.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pseven.setLayout(gbl_pseven);
		
		try 
		{
			BufferedImage myPicture = ImageIO.read(new File("gobackb.png"));
			Image newImage = myPicture.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JButton btnNewButton = new JButton(new ImageIcon(newImage));
			btnNewButton.setContentAreaFilled(false);
			btnNewButton.setPreferredSize(new Dimension(50,50));
			btnNewButton.setBorderPainted(false);
			btnNewButton.addMouseListener(new MouseAdapter() {
				  public void mousePressed(MouseEvent e) {
					  btnNewButton.setBorderPainted(true);
				  }

				  public void mouseReleased(MouseEvent e) {
					  btnNewButton.setBorderPainted(false);
				  }
				});
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (homepos) {
						panHome backhome = new panHome(infopack);
						removeAll();
						add(backhome);
						repaint();
						revalidate();
					}else {
						String nomeCV = infopack.get(5);
						String comuneCV = infopack.get(4);
						panInfo backinfo = new panInfo(infopack, nomeCV, comuneCV, searchpos);
						removeAll();
						add(backinfo);
						repaint();
						revalidate();
					}
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 0;
			pseven.add(btnNewButton, gbc_btnNewButton);
 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JButton btnNewButton_log = new JButton("LOG OUT");
		btnNewButton_log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panLogin ritorno = new panLogin();
				removeAll();
				add(ritorno);
				repaint();
				revalidate();
			}
		});
		btnNewButton_log.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_log = new GridBagConstraints();
		gbc_btnNewButton_log.gridwidth = 2;
		gbc_btnNewButton_log.anchor = GridBagConstraints.LINE_END;
		gbc_btnNewButton_log.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_log.gridx = 5;
		gbc_btnNewButton_log.gridy = 0;
		pseven.add(btnNewButton_log, gbc_btnNewButton_log);
		
		try 
		{
			BufferedImage myPicture2 = ImageIO.read(new File("primula.png"));
			Image newImage2 = myPicture2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblNewLabelim = new JLabel(new ImageIcon(newImage2));
			lblNewLabelim.setPreferredSize(new Dimension(50,50));
			GridBagConstraints gbc_lblNewLabelim = new GridBagConstraints();
			gbc_lblNewLabelim.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabelim.gridx = 7;
			gbc_lblNewLabelim.gridy = 0;
			pseven.add(lblNewLabelim, gbc_lblNewLabelim);
			
 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		JLabel lblNewLabel_1 = new JLabel("N.B. Nel caso in cui avessi gi\u00E0 segnalato un evento avverso, verr\u00E0 tenuto in considerazione");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 6;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		pseven.add(lblNewLabel_1, gbc_lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("anche quello che hai avuto in precedenza. Nel caso in cui l'evento avverso \u00E8 lo stesso di quello");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_2.gridwidth = 6;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		pseven.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
		JLabel lblNewLabel_3 = new JLabel("gi\u00E0 qui riportato, allora verr\u00E0 presa in considerazione solo la nuova segnalazione.");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_3.gridwidth = 6;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		pseven.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		this.username = infopack.get(6);
			
		JLabel lblNewLabel_4 = new JLabel("Nome utente: "+ this.username);
		lblNewLabel_4.setForeground(new Color(0, 0, 205));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.gridwidth = 6;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		pseven.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		this.nomecentro = infopack.get(5);
			
		JLabel lblNewLabel_5 = new JLabel("Vaccinato presso "+ this.nomecentro);
		lblNewLabel_5.setForeground(new Color(0, 0, 205));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.gridwidth = 6;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 5;
		pseven.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		this.vaccinoricevuto = infopack.get(8);
			
		JLabel lblNewLabel_6 = new JLabel("Tipo di vaccino ricevuto: " + this.vaccinoricevuto);
		lblNewLabel_6.setForeground(new Color(0, 0, 205));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridwidth = 6;
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 6;
		pseven.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Reazione avversa che vuoi segnalare:");
		lblNewLabel_7.setForeground(new Color(0, 0, 205));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.gridwidth = 3;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 7;
		pseven.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Mal di testa", "Tachicardia", "Febbre", "Linfoadenopatia", "Raffreddore", 
				"Dolori muscolari", "Spossatezza", "Dolori articolari", "Crisi ipertensiva", "Paralisi di Bell", "Piastrinopenia autoimmune", "Acufeni"}));
		comboBox.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 7;
		pseven.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("Severit\u00E0 della reazione:");
		lblNewLabel_8.setForeground(new Color(0, 0, 205));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_8.gridwidth = 2;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 8;
		pseven.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton_3bis = new JRadioButton("\u2605");
		GridBagConstraints gbc_rdbtnNewRadioButton_3bis = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3bis.anchor = GridBagConstraints.LINE_END;
		gbc_rdbtnNewRadioButton_3bis.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3bis.gridx = 2;
		gbc_rdbtnNewRadioButton_3bis.gridy = 8;
		pseven.add(rdbtnNewRadioButton_3bis, gbc_rdbtnNewRadioButton_3bis);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("\u2605\u2605");
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.anchor = GridBagConstraints.LINE_END;
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_4.gridx = 3;
		gbc_rdbtnNewRadioButton_4.gridy = 8;
		pseven.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("\u2605\u2605\u2605");
		GridBagConstraints gbc_rdbtnNewRadioButton_5 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_5.anchor = GridBagConstraints.EAST;
		gbc_rdbtnNewRadioButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_5.gridx = 4;
		gbc_rdbtnNewRadioButton_5.gridy = 8;
		pseven.add(rdbtnNewRadioButton_5, gbc_rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("\u2605\u2605\u2605\u2605");
		GridBagConstraints gbc_rdbtnNewRadioButton_6 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_6.anchor = GridBagConstraints.LINE_END;
		gbc_rdbtnNewRadioButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_6.gridx = 5;
		gbc_rdbtnNewRadioButton_6.gridy = 8;
		pseven.add(rdbtnNewRadioButton_6, gbc_rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("\u2605\u2605\u2605\u2605\u2605");
		GridBagConstraints gbc_rdbtnNewRadioButton_7 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_7.anchor = GridBagConstraints.EAST;
		gbc_rdbtnNewRadioButton_7.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_7.gridx = 6;
		gbc_rdbtnNewRadioButton_7.gridy = 8;
		pseven.add(rdbtnNewRadioButton_7, gbc_rdbtnNewRadioButton_7);
		
		ButtonGroup btnGroupstar = new ButtonGroup();
		btnGroupstar.add(rdbtnNewRadioButton_3bis);
		btnGroupstar.add(rdbtnNewRadioButton_4);
		btnGroupstar.add(rdbtnNewRadioButton_5);
		btnGroupstar.add(rdbtnNewRadioButton_6);
		btnGroupstar.add(rdbtnNewRadioButton_7);
		rdbtnNewRadioButton_3bis.setActionCommand("1");
		rdbtnNewRadioButton_4.setActionCommand("2");
		rdbtnNewRadioButton_5.setActionCommand("3");
		rdbtnNewRadioButton_6.setActionCommand("4");
		rdbtnNewRadioButton_7.setActionCommand("5");
		
		JLabel lblNewLabel_9 = new JLabel("Note opzionali:");
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 9;
		pseven.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("(Max 256 caratteri)");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 2;
		gbc_lblNewLabel_10.gridy = 9;
		pseven.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 6;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 10;
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		pseven.add(textArea, gbc_textArea);
		textArea.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (textArea.getText().length() >= 256 ) {
		        	e.consume(); 
		        }
		    }
		});
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_11.gridwidth = 6;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 12;
		pseven.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JButton btnNewButton_1 = new JButton("REGISTRA SEGNALAZIONE AVVERSA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((btnGroupstar.isSelected(null))||(comboBox.getSelectedIndex()==-1)){
					lblNewLabel_11.setText("Completa tutti i campi obbligatori prima di proseguire");
				}else {
					if (textArea.getText().length()>256) {
						lblNewLabel_11.setText("Questo commento è più lungo di 256 caratteri");
					}else {
						lblNewLabel_11.setText("");
						lblNewLabel_11.setVisible(false);
						boolean proceed = false;
						dataEvent pubeventi = new dataEvent();
						String sevstella = btnGroupstar.getSelection().getActionCommand();
						int sever = Integer.parseInt(sevstella);
						proceed = pubeventi.insertEvent(infopack,comboBox.getSelectedItem().toString(),sever, textArea.getText());
						if(proceed) {
							panEventConf finepan = new panEventConf(infopack);
							removeAll();
							add(finepan);
							repaint();
							revalidate();
						}
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton_1.gridwidth = 6;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 11;
		pseven.add(btnNewButton_1, gbc_btnNewButton_1);
	}
}
