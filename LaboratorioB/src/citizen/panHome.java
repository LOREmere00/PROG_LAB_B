package citizen;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
import java.awt.image.BufferedImage;

import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class panHome extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String username;
	private String nomecentro;
	private String comunecentro;
	
	
	public panHome(ArrayList<String> infopack) {
		costruisciPan4(infopack);
	}
	
	protected void costruisciPan4(ArrayList<String> infopack) {
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pfive = new JPanel();
		add(pfive);
		GridBagLayout gbl_pfive = new GridBagLayout();
		gbl_pfive.columnWidths = new int[]{100, 500, 100, 0};
		gbl_pfive.rowHeights = new int[]{100, 80, 40, 40, 40, 60, 40, 40, 40, 40, 40, 0};
		gbl_pfive.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pfive.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pfive.setLayout(gbl_pfive);
		
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
		gbc_btnNewButton_log.anchor = GridBagConstraints.LINE_END;
		gbc_btnNewButton_log.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_log.gridx = 1;
		gbc_btnNewButton_log.gridy = 0;
		pfive.add(btnNewButton_log, gbc_btnNewButton_log);
		
		try 
		{
			BufferedImage myPicture2 = ImageIO.read(new File("primula.png"));
			Image newImage2 = myPicture2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblNewLabelim = new JLabel(new ImageIcon(newImage2));
			lblNewLabelim.setPreferredSize(new Dimension(50,50));
			GridBagConstraints gbc_lblNewLabelim = new GridBagConstraints();
			gbc_lblNewLabelim.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabelim.gridx = 2;
			gbc_lblNewLabelim.gridy = 0;
			pfive.add(lblNewLabelim, gbc_lblNewLabelim);
 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		nome = infopack.get(0);
		nome = nome.toUpperCase();
		
		JLabel lblNewLabel_1 = new JLabel("CIAO "+nome+"!");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 27));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		pfive.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		username = infopack.get(6);
		
		JLabel lblNewLabel_2 = new JLabel("Nome utente: "+username);
		lblNewLabel_2.setForeground(new Color(0, 0, 205));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		pfive.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		nomecentro = infopack.get(5);
		
		JLabel lblNewLabel_3 = new JLabel("Vaccinato presso il centro: "+nomecentro);
		lblNewLabel_3.setForeground(new Color(0, 0, 205));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		pfive.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		comunecentro = infopack.get(4);
		
		JLabel lblNewLabel_4 = new JLabel("Nel comune: "+comunecentro);
		lblNewLabel_4.setForeground(new Color(0, 0, 205));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.LINE_START;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		pfive.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Se vuoi consultare le informazioni di un centro qualsiasi:");
		lblNewLabel_5.setForeground(new Color(0, 191, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 5;
		pfive.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JButton btnNewButton = new JButton("CERCA CENTRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panSearch ricerca = new panSearch(infopack);
				removeAll();
				add(ricerca);
				repaint();
				revalidate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		pfive.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Se vuoi consultare le informazioni del tuo centro:");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 7;
		pfive.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("CONSULTA CENTRO");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panInfo segnala = new panInfo(infopack, nomecentro, comunecentro, false);
				removeAll();
				add(segnala);
				repaint();
				revalidate();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 8;
		pfive.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Se invece hai avuto un effetto collaterale al vaccino che vuoi segnalare:");
		lblNewLabel_6.setForeground(new Color(0, 191, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 9;
		pfive.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("SEGNALA EVENTO AVVERSO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panEvent segnala = new panEvent(infopack, true, false);
				removeAll();
				add(segnala);
				repaint();
				revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 10;
		pfive.add(btnNewButton_1, gbc_btnNewButton_1);
		
	}

}
