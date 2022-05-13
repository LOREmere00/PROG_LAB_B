package citizen;

import java.awt.Dimension;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/* Questa interfaccia consiste in un singolo frame in cui vengono aggiornati i pannelli ogni volta in cui
 * si avrà a che fare con un nuovo layout.
 * Ciascun pannello corrisponde a una classe che inizia per pan.
 * In questa classe viene solo creato il frame iniziale.
 * 
 * 
 */
public class mainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{
			
			EventQueue.invokeLater(new Runnable() 
			{
				public void run() 
				{
					try 
					{
						/*
						 * Creo l'istanza frame di tipo JFrame. Frame ha una dimensione fissa di 700x700 e la sua grandezza non è
						 * modificabile. Inoltre, il focus del frame è settato a false, in modo tale che non verrà focalizzata alcuna
						 * casella di testo per ciascun pannello prima che l'utente non possa cliccarci su col mouse.
						 * Incastro dentro il pannello panel1,, istanza di panLogin. 
						 */
						JFrame frame = new JFrame();
						panLogin panel1 = new panLogin();
		                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                frame.setLocation(500, 150);
		                panel1.setPreferredSize(new Dimension(700, 700));
		                frame.setResizable(false);
		                frame.setVisible(true);
		                frame.setTitle("Piattaforma vaccinale");
		                ImageIcon icon = new ImageIcon("primula.png");
		                frame.setIconImage(icon.getImage());
		                frame.getContentPane().add(panel1);
		                frame.getContentPane().requestFocusInWindow();
		                frame.pack();
		     
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
	
	}

}
