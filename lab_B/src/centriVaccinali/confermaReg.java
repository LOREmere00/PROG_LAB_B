package centriVaccinali;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class confermaReg extends JPanel {

	/**
	 * Create the panel.
	 */
	public confermaReg() {

		setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 100, 150, 250, 150, 100 };
		gbl_panel.rowHeights = new int[] { 100, 100, 80, 50, 20, 100, 100 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);
		
		try {
			
			// Inserimento immagine primula
			BufferedImage prim = ImageIO.read(new File("./src/primula.png"));
			Image newPrim = prim.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			JLabel lblPrim = new JLabel(new ImageIcon(newPrim));
			lblPrim.setPreferredSize(new Dimension(50, 50));
			GridBagConstraints gbc_lblPrim = new GridBagConstraints();
			gbc_lblPrim.anchor = GridBagConstraints.SOUTH;
			gbc_lblPrim.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrim.gridx = 2;
			gbc_lblPrim.gridy = 1;
			panel.add(lblPrim, gbc_lblPrim);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		JLabel lblNewLabel = new JLabel("REGISTRAZIONE AVVENUTA CON SUCCESSO!");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JButton btnHome = new JButton("Ritorna alla home");
		btnHome.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				regCitt pan = new regCitt();
				removeAll();
				add(pan);
				repaint();
				revalidate();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		panel.add(btnHome, gbc_btnNewButton);
	}
}
