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



public class panEventConf extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public panEventConf(ArrayList<String> infopack) {
		costruisciPan7(infopack);
	}
	
	protected void costruisciPan7(ArrayList<String> infopack) {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pfin1 = new JPanel();
		add(pfin1);
		GridBagLayout gbl_pfin1 = new GridBagLayout();
		gbl_pfin1.columnWidths = new int[]{100, 500, 100, 0};
		gbl_pfin1.rowHeights = new int[]{100, 225, 75, 40, 0, 40, 0, 0};
		gbl_pfin1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pfin1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pfin1.setLayout(gbl_pfin1);
		
		try 
		{
			BufferedImage myPicture2 = ImageIO.read(new File("primula.png"));
			Image newImage2 = myPicture2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			JLabel lblNewLabelim = new JLabel(new ImageIcon(newImage2));
			lblNewLabelim.setPreferredSize(new Dimension(200,200));
			GridBagConstraints gbc_lblNewLabelim = new GridBagConstraints();
			gbc_lblNewLabelim.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabelim.gridx = 1;
			gbc_lblNewLabelim.gridy = 1;
			pfin1.add(lblNewLabelim, gbc_lblNewLabelim);
			
			JLabel lblNewLabel = new JLabel("EVENTO AVVERSO INSERITO CON SUCCESSO!");
			lblNewLabel.setForeground(new Color(0, 128, 128));
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 2;
			pfin1.add(lblNewLabel, gbc_lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Per tornare alla pagina del tuo profilo:");
			lblNewLabel_1.setForeground(new Color(0, 0, 255));
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 3;
			pfin1.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			JButton btnNewButton = new JButton("VAI ALLA PAGINA DEL TUO PROFILO");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panHome tornahome = new panHome(infopack);
					removeAll();
					add(tornahome);
					repaint();
					revalidate();
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton.setFocusable(false);
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 1;
			gbc_btnNewButton.gridy = 4;
			pfin1.add(btnNewButton, gbc_btnNewButton);
			
			JLabel lblNewLabel_2 = new JLabel("Per tornare alla pagina iniziale:");
			lblNewLabel_2.setForeground(new Color(0, 0, 255));
			lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 5;
			pfin1.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			JButton btnNewButton_1 = new JButton("EFFETTUA IL LOG OUT");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panLogin tornalog = new panLogin();
					removeAll();
					add(tornalog);
					repaint();
					revalidate();
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1.setFocusable(false);
			GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
			gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton_1.gridx = 1;
			gbc_btnNewButton_1.gridy = 6;
			pfin1.add(btnNewButton_1, gbc_btnNewButton_1);
			
 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

}
