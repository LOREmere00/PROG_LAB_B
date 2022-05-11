package centriVaccinali;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class centriMain extends JFrame {

	/*
	 * Creazione frame
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					/*
					 * Impostazioni del frame
					 */
					JFrame frame = new JFrame();
					registraVaccinato panel = new registraVaccinato();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setLocation(600, 50);
					panel.setPreferredSize(new Dimension(750, 550));
					frame.setResizable(false);
					frame.setVisible(true);
					frame.setTitle("Piattaforma centri vaccinali");
					ImageIcon icon = new ImageIcon("./src/primula.png");
					frame.setIconImage(icon.getImage());
					frame.getContentPane().add(panel);
					frame.getContentPane().requestFocusInWindow();
					frame.pack();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
	}
}
