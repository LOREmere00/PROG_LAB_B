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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.File;

import javax.imageio.ImageIO;


public class panRegis extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	
	private JLabel lblNewLabel_1err;
	private JLabel lblNewLabel_2err;
	private JLabel lblNewLabel_3err;
	private JLabel lblNewLabel_4err;
	private JLabel lblNewLabel_5err;
	private JLabel lblNewLabel_6err;
	private JLabel lblNewLabel_7err;
	
	private boolean checkUsern;
	private boolean checkPassw;
	private boolean checkNome;
	private boolean checkCognome;
	private boolean checkCF;
	private boolean checkEmail;
	private boolean checkLogged;
	private boolean checkProceed;
	
	private char c;
	
	public panRegis() {
		costruisciPan2();
	}
	
	protected void costruisciPan2() {
		
		setLayout(new GridLayout(1, 0, 0, 0));
		JPanel ptwo = new JPanel();
		add(ptwo);
		GridBagLayout gbl_ptwo = new GridBagLayout();
		gbl_ptwo.columnWidths = new int[]{100, 150, 50, 100, 50, 150, 100, 0};
		gbl_ptwo.rowHeights = new int[]{100, 60, 45, 10, 45, 10, 45, 10, 45, 40, 0};
		gbl_ptwo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_ptwo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		ptwo.setLayout(gbl_ptwo);
		
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
					panLogin backlog = new panLogin();
					removeAll();
					add(backlog);
					repaint();
					revalidate();
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 0;
			ptwo.add(btnNewButton, gbc_btnNewButton);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			BufferedImage myPicture2 = ImageIO.read(new File("primula.png"));
			Image newImage2 = myPicture2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblNewLabelim = new JLabel(new ImageIcon(newImage2));
			lblNewLabelim.setPreferredSize(new Dimension(50,50));
			GridBagConstraints gbc_lblNewLabelim = new GridBagConstraints();
			gbc_lblNewLabelim.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabelim.gridx = 6;
			gbc_lblNewLabelim.gridy = 0;
			ptwo.add(lblNewLabelim, gbc_lblNewLabelim);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_1 = new JLabel("INSERIRSCI QUI LE TUE CREDENZIALI");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 5;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		ptwo.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField("Inserire username");
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
		        	textField.setText("Inserire username");
		        	textField.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		ptwo.add(textField, gbc_textField);
		textField.setColumns(10);
		
		this.lblNewLabel_1err = new JLabel("");
		this.lblNewLabel_1err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_1err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_1err = new GridBagConstraints();
		gbc_lblNewLabel_1err.gridwidth = 2;
		gbc_lblNewLabel_1err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1err.gridx = 1;
		gbc_lblNewLabel_1err.gridy = 2;
		ptwo.add(this.lblNewLabel_1err, gbc_lblNewLabel_1err);
		
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
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 2;
		ptwo.add(passwordField, gbc_passwordField);
		
		this.lblNewLabel_2err = new JLabel("");
		this.lblNewLabel_2err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_2err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_2err = new GridBagConstraints();
		gbc_lblNewLabel_2err.gridwidth = 2;
		gbc_lblNewLabel_2err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2err.gridx = 4;
		gbc_lblNewLabel_2err.gridy = 2;
		ptwo.add(this.lblNewLabel_2err, gbc_lblNewLabel_2err);
		
		textField_1 = new JTextField("Inserire nome");
		textField_1.setForeground(Color.GRAY);
		textField_1.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (textField_1.getForeground().equals(Color.GRAY)){
		    		textField_1.setText("");
		    		textField_1.setForeground(Color.BLACK);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		        if (textField_1.getText().equals("")){
		        	textField_1.setText("Inserire nome");
		        	textField_1.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		ptwo.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		this.lblNewLabel_3err = new JLabel("");
		this.lblNewLabel_3err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_3err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_3err = new GridBagConstraints();
		gbc_lblNewLabel_3err.gridwidth = 2;
		gbc_lblNewLabel_3err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_3err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3err.gridx = 1;
		gbc_lblNewLabel_3err.gridy = 4;
		ptwo.add(this.lblNewLabel_3err, gbc_lblNewLabel_3err);
		
		textField_2 = new JTextField("Inserire cognome");
		textField_2.setForeground(Color.GRAY);
		textField_2.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (textField_2.getForeground().equals(Color.GRAY)){
		    		textField_2.setText("");
		    		textField_2.setForeground(Color.BLACK);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		        if (textField_2.getText().equals("")){
		        	textField_2.setText("Inserire cognome");
		        	textField_2.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 4;
		ptwo.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		this.lblNewLabel_4err = new JLabel("");
		this.lblNewLabel_4err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_4err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_4err = new GridBagConstraints();
		gbc_lblNewLabel_4err.gridwidth = 2;
		gbc_lblNewLabel_4err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_4err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4err.gridx = 4;
		gbc_lblNewLabel_4err.gridy = 4;
		ptwo.add(this.lblNewLabel_4err, gbc_lblNewLabel_4err);
		
		textField_3 = new JTextField("Inserire codice fiscale");
		textField_3.setForeground(Color.GRAY);
		textField_3.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (textField_3.getForeground().equals(Color.GRAY)){
		    		textField_3.setText("");
		    		textField_3.setForeground(Color.BLACK);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		        if (textField_3.getText().equals("")){
		        	textField_3.setText("Inserire codice fiscale");
		        	textField_3.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 6;
		ptwo.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		this.lblNewLabel_5err = new JLabel("");
		this.lblNewLabel_5err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_5err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_5err = new GridBagConstraints();
		gbc_lblNewLabel_5err.gridwidth = 2;
		gbc_lblNewLabel_5err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_5err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5err.gridx = 1;
		gbc_lblNewLabel_5err.gridy = 6;
		ptwo.add(this.lblNewLabel_5err, gbc_lblNewLabel_5err);
		
		textField_4 = new JTextField("Inserire indirizzo e-mail");
		textField_4.setForeground(Color.GRAY);
		textField_4.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if (textField_4.getForeground().equals(Color.GRAY)){
		    		textField_4.setText("");
		    		textField_4.setForeground(Color.BLACK);
		    	}
		    }
		    public void focusLost(FocusEvent e) {
		        if (textField_4.getText().equals("")){
		        	textField_4.setText("Inserire indirizzo e-mail");
		        	textField_4.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 6;
		ptwo.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		
		this.lblNewLabel_6err = new JLabel("");
		this.lblNewLabel_6err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_6err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_6err = new GridBagConstraints();
		gbc_lblNewLabel_6err.gridwidth = 2;
		gbc_lblNewLabel_6err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_6err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6err.gridx = 4;
		gbc_lblNewLabel_6err.gridy = 6;
		ptwo.add(this.lblNewLabel_6err, gbc_lblNewLabel_6err);
		
		JLabel lblNewLabel_16 = new JLabel("Ti sei gi\u00E0 registrato! Per proseguire torna alla pagina iniziale:");
		lblNewLabel_16.setVisible(false);
		lblNewLabel_16.setForeground(Color.MAGENTA);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_16.gridwidth = 5;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 1;
		gbc_lblNewLabel_16.gridy = 8;
		ptwo.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		JButton btnNewButton_1 = new JButton("Pagina iniziale");
		btnNewButton_1.setVisible(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panLogin paginainizio = new panLogin();
				removeAll();
				add(paginainizio);
				repaint();
				revalidate();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 3;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 9;
		ptwo.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrati");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_16.setVisible(false);
				btnNewButton_1.setVisible(false);
				
				if (goCheckII()) {
					if(!(checkLogged)) {
						if (checkProceed) {
							panRegConf regConfermata = new panRegConf ();
							removeAll();
							add(regConfermata);
							repaint();
							revalidate();
						}
					}else {
						lblNewLabel_16.setVisible(true);
						btnNewButton_1.setVisible(true);
					}
				}else {
					if (!(checkUsern)) {
						textField.setText("Inserire nome utente");
			        	textField.setForeground(Color.GRAY);
					}
					if (!(checkPassw)) {
						passwordField.setText("Inserire password");
			        	passwordField.setEchoChar((char)0);
			        	passwordField.setForeground(Color.GRAY);
					}
					if (!(checkNome)) {
						textField_1.setText("Inserire nome");
			        	textField_1.setForeground(Color.GRAY);
					}
					if (!(checkCognome)) {
						textField_2.setText("Inserire cognome");
			        	textField_2.setForeground(Color.GRAY);
					}
					if (!(checkCF)) {
						textField_3.setText("Inserire codice fiscale");
			        	textField_3.setForeground(Color.GRAY);
					}
					if (!(checkEmail)) {
						textField_4.setText("Inserire indirizzo e-mail");
			        	textField_4.setForeground(Color.GRAY);
					}
				}
			}
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridwidth = 3;
		gbc_btnNewButton_2.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 7;
		ptwo.add(btnNewButton_2, gbc_btnNewButton_2);
		
		this.lblNewLabel_7err = new JLabel("");
		this.lblNewLabel_7err.setFont(new Font("Gill Sans Nova", Font.ITALIC, 14));
		this.lblNewLabel_7err.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_7err = new GridBagConstraints();
		gbc_lblNewLabel_7err.gridwidth = 3;
		gbc_lblNewLabel_7err.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_7err.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7err.gridx = 2;
		gbc_lblNewLabel_7err.gridy = 8;
		ptwo.add(this.lblNewLabel_7err, gbc_lblNewLabel_7err);
		
	}
	
	public boolean goCheckII() {
		setCheckUsern(false);
		setCheckPassw(false);
		setCheckNome(false);
		setCheckCognome(false);
		setCheckCF(false);
		setCheckEmail(false);
		setLogged(false);
		setProceed(false);
		checkRegis checkReg = new checkRegis(this);
		return checkReg.checkIn();
	}
	
	public JTextField getUsernText() {
		return this.textField;
	}
	
	public JPasswordField getPasswText() {
		return this.passwordField;
	}
	
	public JTextField getNomeText() {
		return this.textField_1;
	}
	
	public JTextField getCognomeText() {
		return this.textField_2;
	}
	
	public JTextField getCFText() {
		return this.textField_3;
	}
	
	public JTextField getEmailText() {
		return this.textField_4;
	}
	
	public JLabel getUsernErr() {
	     return this.lblNewLabel_1err;
	}
	
	public JLabel getPasswErr() {
	     return this.lblNewLabel_2err;
	}
	
	public JLabel getNomeErr() {
	     return this.lblNewLabel_3err;
	}
	
	public JLabel getCognomeErr() {
	     return this.lblNewLabel_4err;
	}
	
	public JLabel getCFErr() {
	     return this.lblNewLabel_5err;
	}
	
	public JLabel getEmailErr() {
	     return this.lblNewLabel_6err;
	}
	
	public JLabel getIDErr() {
	     return this.lblNewLabel_7err;
	}
	
	public void setCheckUsern(boolean checkUsern) {
		this.checkUsern=checkUsern;
	}
	
	public void setCheckPassw(boolean checkPassw) {
		this.checkPassw=checkPassw;
	}
	
	public void setCheckNome(boolean checkNome) {
		this.checkNome=checkNome;
	}
	
	public void setCheckCognome(boolean checkCognome) {
		this.checkCognome=checkCognome;
	}
	
	public void setCheckCF(boolean checkCF) {
		this.checkCF=checkCF;
	}
	
	public void setCheckEmail(boolean checkEmail) {
		this.checkEmail=checkEmail;
	}
	
	public void setLogged(boolean checkLogged) {
		this.checkLogged= checkLogged;
	}
	
	public void setProceed(boolean checkProceed) {
		this.checkProceed = checkProceed;
	}
	
}
