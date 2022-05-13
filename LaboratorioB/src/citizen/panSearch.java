package citizen;



import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Component;
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
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class panSearch extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private String nomecentro;
	private String comunecentro;
	private JComboBox<String> comboBox;
	
	private DefaultTableModel dlm;
	
	private ArrayList<ArrayList<String>> matrixtab = new ArrayList<ArrayList<String>>();
	private ArrayList <String> riga = new ArrayList<String>();
	
	public panSearch(ArrayList<String> infopack) {
		costruisciPan5(infopack);
	}
	
	protected void costruisciPan5(ArrayList<String> infopack) {
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel pfour = new JPanel();
		add(pfour);
		GridBagLayout gbl_pfour = new GridBagLayout();
		gbl_pfour.columnWidths = new int[]{100, 250, 250, 100, 0};
		gbl_pfour.rowHeights = new int[]{100, 30, 60, 30, 30, 215, 80, 0};
		gbl_pfour.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pfour.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pfour.setLayout(gbl_pfour);
		
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
					if (infopack.isEmpty()) {
						panLogin backstart = new panLogin();
						removeAll();
						add(backstart);
						repaint();
						revalidate();
					}else {
						panHome backhome = new panHome(infopack);
						removeAll();
						add(backhome);
						repaint();
						revalidate();
					}
				}
			});
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 0;
			pfour.add(btnNewButton, gbc_btnNewButton);
 
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
		gbc_btnNewButton_log.anchor = GridBagConstraints.LINE_END;
		gbc_btnNewButton_log.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_log.gridx = 2;
		gbc_btnNewButton_log.gridy = 0;
		
		if (!(infopack.isEmpty())) {
			pfour.add(btnNewButton_log, gbc_btnNewButton_log);
		}
		
		try 
		{
			BufferedImage myPicture2 = ImageIO.read(new File("primula.png"));
			Image newImage2 = myPicture2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
				
			JLabel lblNewLabelim = new JLabel(new ImageIcon(newImage2));
			lblNewLabelim.setPreferredSize(new Dimension(50,50));
			GridBagConstraints gbc_lblNewLabelim = new GridBagConstraints();
			gbc_lblNewLabelim.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabelim.gridx = 3;
			gbc_lblNewLabelim.gridy = 0;
			pfour.add(lblNewLabelim, gbc_lblNewLabelim);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		JLabel lblNewLabel_2 = new JLabel("Clicca su seleziona per consultare le informazioni del centro che ti interessa ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		pfour.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Scegli la tipologia del centro: ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.LINE_END;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		
		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"ospedaliero", "aziendale", "hub"}));
		comboBox.setSelectedIndex(-1);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.anchor = GridBagConstraints.LINE_START;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 4;
		
		textField = new JTextField("Inserisci nome del centro");
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
		        	textField.setText("Inserisci nome del centro");
		        	textField.setForeground(Color.GRAY);
		        }
		    }
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		textField.setColumns(10);
		
		textField_2 = new JTextField("Inserisci comune del centro");
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
		        	textField_2.setText("Inserisci nome del centro");
		        	textField_2.setForeground(Color.GRAY);
		        }
		    }
		});
		textField_2.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ricerca per nome");
		rdbtnNewRadioButton.setForeground(new Color(0, 128, 128));
		rdbtnNewRadioButton.setSelected(true);
		if (rdbtnNewRadioButton.isSelected()) {
			pfour.add(textField, gbc_textField);
			pfour.remove(textField_2);
			pfour.revalidate();
			pfour.repaint();
		}
		
		
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.SOUTH;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 1;
		pfour.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Ricerca per comune e tipo");
		rdbtnNewRadioButton_1.setForeground(new Color(0, 128, 128));
		
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		pfour.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnNewRadioButton);
		btnGroup.add(rdbtnNewRadioButton_1);
		
		table = new JTable();
		dlm = new DefaultTableModel();
		TableColumnModel columnModel = table.getColumnModel();
		table.setModel(dlm);
		dlm.addColumn("CENTRO VACCINALE");
        dlm.addColumn("COMUNE");
        dlm.addColumn("INDIRIZZO");
        dlm.addColumn("TIPOLOGIA");
        columnModel.getColumn(0).setPreferredWidth(200);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(80);
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer() {
			
			private static final long serialVersionUID = 1L;
			Font font = new Font("Tahoma", Font.BOLD, 12);

		    @Override
		    public Component getTableCellRendererComponent(JTable table,
		            Object value, boolean isSelected, boolean hasFocus,
		            int row, int column) {
		        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
		                row, column);
		        setFont(font);
		        return this;
		    }

		};
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.anchor = GridBagConstraints.SOUTH;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.gridwidth = 2;
		gbc_table.gridx = 1;
		gbc_table.gridy = 5;
		table.setColumnSelectionAllowed(false);
		table.setAutoscrolls(false);
		table.setRowSelectionAllowed(true);
		table.setDefaultEditor(Object.class, null);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane();
		scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(495, 200));
		pfour.add(scroll, gbc_table);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setFocusable(false);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pfour.add(textField, gbc_textField);
				dlm.setRowCount(0);
				textField.setText("Inserisci nome del centro");
				textField.setForeground(Color.GRAY);
				table.removeAll();
				pfour.remove(textField_2);
				pfour.remove(lblNewLabel_3);
				pfour.remove(comboBox);
				pfour.revalidate();
				pfour.repaint();
			}
		});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setSelectedIndex(-1);
				pfour.add(lblNewLabel_3, gbc_lblNewLabel_3);
				pfour.add(comboBox, gbc_comboBox);
				pfour.add(textField_2, gbc_textField);
				textField_2.setText("Inserisci comune del centro");
				textField_2.setForeground(Color.GRAY);
				dlm.setRowCount(0);
				table.removeAll();
				pfour.remove(textField);
				pfour.revalidate();
				pfour.repaint();
			}
		});
		
		textField.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				cercaTesto("RicercaNome");
			}
			
			public void removeUpdate(DocumentEvent e) {
				cercaTesto("RicercaNome");
			}
			
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		
		textField_2.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				cercaTesto("RicercaComuneTipo");
			}
			
			public void removeUpdate(DocumentEvent e) {
				cercaTesto("RicercaComuneTipo");
			}
			
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cercaTesto("RicercaComuneTipo");
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("SELEZIONA CENTRO");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!table.getSelectionModel().isSelectionEmpty()) {
					int row = table.getSelectedRow();
					nomecentro = (String) dlm.getValueAt(row, 0);
					comunecentro = (String) dlm.getValueAt(row, 1);
					panInfo infocentro = new panInfo(infopack, nomecentro, comunecentro, true);
					removeAll();
					add(infocentro);
					repaint();
					revalidate();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 6;
		pfour.add(btnNewButton_1, gbc_btnNewButton_1);
	}
	
	private void cercaTesto(String selectedSearch) {
		String nome;
		String indirizzo;
		String tipologia;
		String comune;
		String testo = "";
		dataSearch ricercaData = new dataSearch();
		matrixtab.clear();
		if (selectedSearch == "RicercaNome") {
			testo = textField.getText();
		}
		if (selectedSearch == "RicercaComuneTipo") {
			testo = textField_2.getText();;
		}
		if (testo.isBlank()) {
			testo = "";
			dlm.setRowCount(0);
			table.removeAll();
		}
		else {
			dlm.setRowCount(0);
			table.removeAll();
			testo = testo.trim();
			testo = testo.replaceAll("\\s+", " ");
			char[] chars = testo.toLowerCase().toCharArray();
			boolean found = false;
			for (int i = 0; i < chars.length; i++) {
				if (!found && Character.isLetter(chars[i])) {
					chars[i] = Character.toUpperCase(chars[i]);
					found = true;
				} else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'') { 
					found = false;
				}
			}
			String sword = String.valueOf(chars);
			if (selectedSearch == "RicercaNome") {
				matrixtab = ricercaData.cercanome(sword);
			}
			if (selectedSearch == "RicercaComuneTipo") {
				if (comboBox.getSelectedIndex()!=-1) {
					matrixtab = ricercaData.cercacomunetipo(sword,comboBox.getSelectedItem().toString());
				}
			}
		  
			for(int i=0;i<matrixtab.size();i++){
				 riga.clear();
				 riga = matrixtab.get(i);
				 nome = riga.get(0);
				 comune = riga.get(1);
				 indirizzo = riga.get(2);
				 tipologia = riga.get(3);
				 dlm.addRow(new Object[]{nome, comune, indirizzo, tipologia});
			}
		}
	}
}

