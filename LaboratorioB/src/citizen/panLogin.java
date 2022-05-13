package citizen;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
import java.util.ArrayList;

import javax.imageio.ImageIO;



/*
 * Questo primo pannello è relativo alla prima pagina in cui è possibile effettuare il login
 */

public class panLogin extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JPasswordField passwordField;
	private char c;
	
	private JLabel lblNewLabel_1err;
	private JLabel lblNewLabel_2err;
	
	private boolean checkUser;
	private boolean checkPass;
	
	private ArrayList <String> infopack = new ArrayList<String>();
	
	Graphics g;
	
	/*
	 * Viene chiamato il metodo costruttore del pannello costruisciPan1
	 */

	public panLogin() {
		costruisciPan1();
	}
	
	/*
	 * Ciascun pannello ha un layout di tipo GridbagLayout, questo viene a sua volta inserito in un pannello base di tipo gridLayout. 
	 * Questo procedimento fa sì che ogni volta che il pannello verrà cambiato, ne verrà inserito uno completamente nuovo e "pulito"
	 * che non lascia alcun contenitore e alcuna traccia del pannello precedente
	 */

	protected void costruisciPan1()
	{
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel p = new JPanel();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 200, 100, 200, 100, 0};
		gridBagLayout.rowHeights = new int[]{100, 80, 60, 45, 30, 20, 50, 30, 50, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		p.setLayout(gridBagLayout);
		add(p);
		
		
		
		try 
		{
			BufferedImage myPicture2 = ImageIO.read(new File("primula.png"));
			Image newImage2 = myPicture2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblNewLabelim = new JLabel(new ImageIcon(newImage2));
			lblNewLabelim.setPreferredSize(new Dimension(50,50));
			GridBagConstraints gbc_lblNewLabelim = new GridBagConstraints();
			gbc_lblNewLabelim.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabelim.gridx = 4;
			gbc_lblNewLabelim.gridy = 0;
			p.add(lblNewLabelim, gbc_lblNewLabelim);
 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		

		JLabel lblNewLabelx = new JLabel("SERVIZIO VACCINAZIONI \r\nPER CITTADINI");
		lblNewLabelx.setForeground(Color.MAGENTA);
		lblNewLabelx.setFont(new Font("Times New Roman", Font.BOLD, 23));
		GridBagConstraints gbc_lblNewLabelx = new GridBagConstraints();
		gbc_lblNewLabelx.gridwidth = 3;
		gbc_lblNewLabelx.anchor = GridBagConstraints.CENTER;
		gbc_lblNewLabelx.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelx.gridx = 1;
		gbc_lblNewLabelx.gridy = 1;
		p.add(lblNewLabelx, gbc_lblNewLabelx);
		
		/*
		 * La prima funzionalità garantita da questo pannello è il log in. All'utente sarà chiesto di inserire il suo username e la sua password e
		 * dovranno corrispondere anche le maiuscole e le minuscole.
		 */
		
		JLabel lblNewLabel = new JLabel("EFFETTUA QUI IL LOG IN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		p.add(lblNewLabel, gbc_lblNewLabel);
		
		/*
		 * I campi di testo di nome utente e password avranno dei testi di default. Questi due testi scompaiono non appena ci si cliccherà su con il mouse.
		 * Ciò è garantito dal controllo equals(Color.GRAY), che consente di cancellare il testo nel caso in cui il colore del testo presente è corrispondente
		 * a quello preinserito (cioè il grigio). Nel caso in cui il colore fosse nero, allora viene riconosciuto come testo inserito dall'utente, e nel caso 
		 * di focus del mouse, questo testo non verrà cancellato.
		 * Nel caso in cui il campo rimanesse vuoto, e il focus del mouse sarà altrove, questi testi ricompariranno.
		 */
		
		textField = new JTextField("Inserire nome utente");
		textField.setForeground(Color.GRAY);
		textField.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (textField.getForeground().equals(Color.GRAY)){
		    		textField.setText("");
		    		textField.setForeground(Color.BLACK);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		        if (textField.getText().equals("")){
		        	textField.setText("Inserire nome utente");
		        	textField.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		p.add(textField, gbc_textField);
		
		/*
		 * Per il campo password, essendo di tipo passwordField, il testo di default dovrà essere settato con setEchoChar(c) per
		 * essere reso visibile
		 */
		
		passwordField = new JPasswordField("Inserire password");
		c = passwordField.getEchoChar();
		passwordField.setEchoChar((char)0);
		passwordField.setForeground(Color.GRAY);
		passwordField.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (passwordField.getForeground().equals(Color.GRAY)){
		    		passwordField.setEchoChar(c);
		    		passwordField.setText("");
		    		passwordField.setForeground(Color.BLACK);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		        if (String.valueOf(passwordField.getPassword()).equals("")){
		        	passwordField.setText("Inserire password");
		        	passwordField.setEchoChar((char)0);
		        	passwordField.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 3;
		p.add(passwordField, gbc_passwordField);
		
		/*
		 * Vengono dunque dichiarate le label degli errori, che diventeranno visibili qualora l'errore dovesse occorrere.
		 */
		
		this.lblNewLabel_1err = new JLabel("");
		this.lblNewLabel_1err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_1err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_1err = new GridBagConstraints();
		gbc_lblNewLabel_1err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1err.gridx = 1;
		gbc_lblNewLabel_1err.gridy = 3;
		p.add(this.lblNewLabel_1err, gbc_lblNewLabel_1err);
		
		this.lblNewLabel_2err = new JLabel("");
		this.lblNewLabel_2err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_2err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_2err = new GridBagConstraints();
		gbc_lblNewLabel_2err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2err.gridx = 3;
		gbc_lblNewLabel_2err.gridy = 3;
		p.add(this.lblNewLabel_2err, gbc_lblNewLabel_2err);
		
		/*
		 * Il bottone di Log in chiamerà il metodo goCheck, che restituisce un valore booleano che sarà true nel caso in cui tutti i controlli effettuati
		 * siano superati. Allora in quel caso si procederà con l'apertura di un nuovo pannello e la chiusura del pannello corrente. La classe panHome invocata
		 * chiede come variabile di ingresso un arraylist contenente tutte quante le informazioni dell'utente, ottenute a sua volta con il metodo goCheck.
		 * Nel caso in cui goCheck fosse false, allora si va ad individuare il tipo di errore, se è un errore dovuto alla password, verrà resettato il campo
		 * contenente la stessa, se invece riguarda un errore dell'utente, verranno resettati entrambi
		 * 
		 */
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (goCheck()) {
					if(!(infopack.isEmpty())){
						panHome logged = new panHome(infopack);
						removeAll();
						add(logged);
						repaint();
						revalidate();
					}else {
						System.out.print("Informazioni sul database irraggiungibili");
					}
				}else {
					if(checkUser==false) {
						textField.setText("Inserire nome utente");
			        	textField.setForeground(Color.GRAY);
			        	passwordField.setText("Inserire password");
			        	passwordField.setEchoChar((char)0);
			        	passwordField.setForeground(Color.GRAY);
					}else {
						if(checkPass==false) {
							passwordField.setText("Inserire password");
				        	passwordField.setEchoChar((char)0);
				        	passwordField.setForeground(Color.GRAY);
						}
					}
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		p.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("______________________________________________________________________");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 5;
		p.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_4x = new JLabel("SE NON HAI FATTO LA REGISTRAZIONE:");
		lblNewLabel_4x.setForeground(Color.BLUE);
		lblNewLabel_4x.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4x = new GridBagConstraints();
		gbc_lblNewLabel_4x.gridwidth = 3;
		gbc_lblNewLabel_4x.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4x.gridx = 1;
		gbc_lblNewLabel_4x.gridy = 6;
		p.add(lblNewLabel_4x, gbc_lblNewLabel_4x);
		
		/*
		 * Il bottone di Registrati consentirà all'utente di registrarsi nel caso le sue informazioni non fossero presenti sul database
		 * 
		 */
		
		JButton btnNewButton_3 = new JButton("REGISTRATI");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panRegis registrati = new panRegis();
				removeAll();
				add(registrati);
				repaint();
				revalidate();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 3;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 7;
		p.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JLabel lblNewLabel_5x = new JLabel("PER CERCARE UN CENTRO VACCINALE SENZA REGISTRAZIONE:");
		lblNewLabel_5x.setForeground(Color.BLUE);
		lblNewLabel_5x.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5x = new GridBagConstraints();
		gbc_lblNewLabel_5x.gridwidth = 3;
		gbc_lblNewLabel_5x.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5x.gridx = 1;
		gbc_lblNewLabel_5x.gridy = 8;
		p.add(lblNewLabel_5x, gbc_lblNewLabel_5x);
		
		/*
		 * Cerca centro consentirà di cercare il centro di interesse senza bisogno di informazioni
		 * 
		 */
		
		JButton btnNewButton_4 = new JButton("CERCA CENTRO");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panSearch ricerca = new panSearch(infopack);
				removeAll();
				add(ricerca);
				repaint();
				revalidate();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridwidth = 3;
		gbc_btnNewButton_4.gridx = 1;
		gbc_btnNewButton_4.gridy = 9;
		p.add(btnNewButton_4, gbc_btnNewButton_4);
	}
	
	/*
	 * Il metodo goCheck consiste nel rendere false i metodi che controllano l'errore di utente e password, questi verranno settati a true 
	 * nel caso di un nuovo controllo. Questo metodo evocherà un'istanza della classe checkLogin e ritornerà un booleano ottenuto dal metodo 
	 * checkInputs() nella classe checkLogin
	 */
	
	public boolean goCheck() {
		setCheckPass(false);
		setCheckUser(false);
		checkLogin checkLog = new checkLogin(this);
		return checkLog.checkInputs();
	}
	
	public JTextField getUserText() {
		return this.textField;
	}
	
	public JPasswordField getPassText() {
		return this.passwordField;
	}
	
	public JLabel getUserErr() {
	     return this.lblNewLabel_1err;
	}
	
	public JLabel getPassErr() {
	     return this.lblNewLabel_2err;
	}
	
	public void setCheckUser(boolean checkUser) {
		this.checkUser=checkUser;
	}
	
	public void setCheckPass(boolean checkPass) {
		this.checkPass=checkPass;
	}
	
	public void setInfoPack(ArrayList<String> infopack) {
		this.infopack=infopack;
	}
	
}
