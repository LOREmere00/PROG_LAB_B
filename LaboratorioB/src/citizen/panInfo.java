package citizen;



import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultCaret;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.GridArrangement;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;



public class panInfo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	String nome_centro = "Lario Fiere";
	private JTable table;
	private static Color sfondo;
	
	private String nomecentroTitle;
	
	private ArrayList <String> nomevax = new ArrayList <String>();
	private ArrayList <Integer> contavax = new ArrayList <Integer>();
	private ArrayList <String> eventi = new ArrayList <String>();
	private ArrayList <Integer> contaevent = new ArrayList <Integer>();
	private ArrayList <Integer> scalatot = new ArrayList <Integer>();
	private boolean controlsev = false;
	private ArrayList <Integer> sev= new ArrayList <Integer>();
	private ArrayList <Integer> contasev = new ArrayList <Integer>();
	private ArrayList <String> sevstar = new ArrayList <String>();
	private JFreeChart diagram;
	private ChartPanel C;
	private JFreeChart diagramma;
	private ChartPanel CP;
	private JFreeChart diagrammas;
	private ChartPanel CPs;
	private dataInfo callData = new dataInfo(this);
	
	private boolean viewnotes;
	private Map<String,ArrayList<String[]>> mapnote = new HashMap<String,ArrayList<String[]>>();
	
	public panInfo(ArrayList<String> infopack, String CVname, String CVtown, Boolean searchpos) {
		costruisciPan5(infopack, CVname, CVtown, searchpos);
	}
	
	protected void costruisciPan5 (ArrayList<String> infopack, String CVname, String CVtown, Boolean searchpos) {
		setLayout(new GridLayout(1, 0, 0, 0));
		JPanel psix = new JPanel();
		add(psix);
		GridBagLayout gbl_psix = new GridBagLayout();
		gbl_psix.columnWidths = new int[]{100, 125, 125, 125, 125, 100, 0};
		gbl_psix.rowHeights = new int[]{100, 30, 30, 30, 30, 30, 105, 30, 180, 50, 40};
		gbl_psix.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_psix.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		psix.setLayout(gbl_psix);
		sfondo = psix.getBackground();
		
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
					if (infopack.isEmpty() || (searchpos)) {
						panSearch backsearch = new panSearch(infopack);
						removeAll();
						add(backsearch);
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
			psix.add(btnNewButton, gbc_btnNewButton);
 
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
		gbc_btnNewButton_log.gridx = 4;
		gbc_btnNewButton_log.gridy = 0;
		
		if (!(infopack.isEmpty())) {
			psix.add(btnNewButton_log, gbc_btnNewButton_log);
		}
		
		try 
		{
			BufferedImage myPicture2 = ImageIO.read(new File("primula.png"));
			Image newImage2 = myPicture2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
			JLabel lblNewLabelim = new JLabel(new ImageIcon(newImage2));
			lblNewLabelim.setPreferredSize(new Dimension(50,50));
			GridBagConstraints gbc_lblNewLabelim = new GridBagConstraints();
			gbc_lblNewLabelim.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabelim.gridx = 5;
			gbc_lblNewLabelim.gridy = 0;
			psix.add(lblNewLabelim, gbc_lblNewLabelim);
 
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		JLabel lblNewLabel_1 = new JLabel("CENTRO VACCINALE");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		psix.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		nomecentroTitle = CVname;
		nomecentroTitle = nomecentroTitle.toUpperCase();
		
		JLabel lblNewLabel_2 = new JLabel(nomecentroTitle);
		lblNewLabel_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		psix.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		int numEvent = callData.vaccinesData(CVname, CVtown);
		
		JLabel lblNewLabel_3 = new JLabel("Numero di eventi avversi segnalati: "+numEvent);
		lblNewLabel_3.setForeground(new Color(0, 0, 205));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 4;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		psix.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Visualizza gli eventi avversi associati al tipo di vaccino:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 4;
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		psix.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pfizer");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 5;
		psix.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Moderna");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 5;
		psix.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Astrazeneca");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 3;
		gbc_rdbtnNewRadioButton_2.gridy = 5;
		psix.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("JnJ");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_rdbtnNewRadioButton_3 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_3.gridx = 4;
		gbc_rdbtnNewRadioButton_3.gridy = 5;
		psix.add(rdbtnNewRadioButton_3, gbc_rdbtnNewRadioButton_3);
		
		ButtonGroup btnGrouptwo = new ButtonGroup();
		btnGrouptwo.add(rdbtnNewRadioButton);
		btnGrouptwo.add(rdbtnNewRadioButton_1);
		btnGrouptwo.add(rdbtnNewRadioButton_2);
		btnGrouptwo.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton.setActionCommand("Pfizer");
		rdbtnNewRadioButton_1.setActionCommand("Moderna");
		rdbtnNewRadioButton_2.setActionCommand("Astrazeneca");
		rdbtnNewRadioButton_3.setActionCommand("JnJ");

		table = new JTable();
		DefaultTableModel dlm = new DefaultTableModel();
		TableColumnModel columnModel = table.getColumnModel();
		table.setModel(dlm);
		dlm.addColumn("EVENTO AVVERSO");
        dlm.addColumn("SEVERITÁ MEDIA");
        dlm.addColumn("SEGNALAZIONI");
        columnModel.getColumn(0).setPreferredWidth(250);
		columnModel.getColumn(1).setPreferredWidth(125);
		columnModel.getColumn(2).setPreferredWidth(125);
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
		table.setColumnSelectionAllowed(false);
		table.setAutoscrolls(false);
		table.setRowSelectionAllowed(true);
		table.setDefaultEditor(Object.class, null);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFillsViewportHeight(true);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.gridx = 1;
		gbc_table.gridy = 6;
		JScrollPane scroll = new JScrollPane();
		scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(500,100));
		psix.add(scroll, gbc_table);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setFocusable(false);
		
		viewnotes = false;
		
		JTextArea noteventi = new JTextArea();
		noteventi.setLineWrap(true);
		noteventi.setWrapStyleWord(true);
		noteventi.setFont(new Font("FreeMono", Font.PLAIN, 14));
		DefaultCaret caret = (DefaultCaret)noteventi.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		GridBagConstraints gbc_noteventi = new GridBagConstraints();
		gbc_noteventi.gridx = 1;
		gbc_noteventi.gridy = 8;
		gbc_noteventi.gridwidth = 4;
		gbc_noteventi.insets = new Insets(0,0,0,5);
		gbc_noteventi.anchor = GridBagConstraints.LINE_START;
		noteventi.setEditable(false);
		JScrollPane scrollnote = new JScrollPane(noteventi, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollnote.setPreferredSize(new Dimension (495, 150));
		
		diagram = createChart(sevstar, contasev, controlsev, "");
		C = new ChartPanel(diagram);
		C.setVisible(false);
		diagramma = createChart(sevstar, contasev, controlsev, "");
		CP = new ChartPanel(diagramma);
		CP.setVisible(false);
		diagrammas = createChart(sevstar, contasev, controlsev, "");
		CPs = new ChartPanel(diagrammas);
		CPs.setVisible(false);
	
		diagram = createChart(getNomeVax(), getContaVax(), controlsev, "EVENTI AVVERSI PER TIPOLOGIA");
		
		GridBagConstraints gbc_chart = new GridBagConstraints();
		gbc_chart.anchor = GridBagConstraints.NORTH;
		gbc_chart.insets = new Insets(0, 0, 0, 5);
		gbc_chart.gridwidth = 2;
		gbc_chart.gridheight = 3;
		gbc_chart.gridx = 0;
		gbc_chart.gridy = 7;
		
		GridBagConstraints gbc_chart_1 = new GridBagConstraints();
		gbc_chart_1.insets = new Insets(0, 0, 0, 5);
		gbc_chart_1.anchor = GridBagConstraints.NORTH;
		gbc_chart_1.gridwidth = 2;
		gbc_chart_1.gridheight = 3;
		gbc_chart_1.gridx = 2;
		gbc_chart_1.gridy = 7;
		
		GridBagConstraints gbc_chart_2 = new GridBagConstraints();
		gbc_chart_2.insets = new Insets(0, 0, 0, 5);
		gbc_chart_2.anchor = GridBagConstraints.NORTH;
		gbc_chart_2.gridwidth = 2;
		gbc_chart_2.gridheight = 3;
		gbc_chart_2.gridx = 4;
		gbc_chart_2.gridy = 7;
		
		if (!(getNomeVax().isEmpty())) {
				C = new ChartPanel(diagram);
				C.setPreferredSize(new Dimension (220,240));
				psix.add(C, gbc_chart);
		}
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.setRowCount(0);
				table.removeAll();
				noteventi.setText("");
				mapnote.clear();
				ArrayList <Double> scalamedia = new ArrayList <Double>();
				
				mapnote = callData.eventsData(CVname, CVtown, btnGrouptwo.getSelection().getActionCommand());
				scalamedia = eventiSort(btnGrouptwo.getSelection().getActionCommand());
				
				for (int j = 0; j<scalatot.size(); j++) {
					dlm.addRow(new Object[]{getEventi().get(j), scalamedia.get(j),  getContaEvent().get(j)});
				}
				controlsev = false;
				psix.remove(CP);
				psix.remove(CPs);
				psix.revalidate();
				psix.repaint();
				
				if((!(mapnote.isEmpty()))) {
					for (int h=0;h<getEventi().size();h++) {
						for (Map.Entry<String, ArrayList<String[]>> mappacheck : mapnote.entrySet()) {
							if (getEventi().get(h).contentEquals(mappacheck.getKey())){
								String eventomatch = mappacheck.getKey();
								ArrayList<String[]> notevento = new ArrayList<String[]>();
								notevento = mapnote.get(eventomatch);
								for (int k=0; k<notevento.size();k++) {
									String [] noteutente = notevento.get(k);
									if (!(noteutente[2].isEmpty())) {
										String starcomment = starMaker(Integer.parseInt(noteutente[1]));
										String notatext = "Utente: " +noteutente[0]+ ".\nEvento avverso segnalato: " +eventomatch+ ". Severità: "+starcomment+"\n~"+noteutente[2]+"~\n\n";
										noteventi.append(notatext);
									}
								}
							}
				        }
					}
				}
				
				if (!(getEventi().isEmpty())) {
					diagramma = createChart(getEventi(), getContaEvent(), controlsev, "EVENTI AVVERSI PER PFIZER");
					CP = new ChartPanel(diagramma);
					CP.setPreferredSize(new Dimension (220,240));
					
					if (viewnotes ==false) {
						psix.add(CP, gbc_chart_1);
					}else {
						psix.add(scrollnote,gbc_noteventi);
					}
				}else {
					CP.setVisible(false);
				}
			}
		});
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.setRowCount(0);
				table.removeAll();
				noteventi.setText("");
				mapnote.clear();
				ArrayList <Double> scalamedia = new ArrayList <Double>();
				
				mapnote = callData.eventsData(CVname, CVtown, btnGrouptwo.getSelection().getActionCommand());
				scalamedia = eventiSort(btnGrouptwo.getSelection().getActionCommand());
				
				for (int j = 0; j<scalatot.size(); j++) {
					dlm.addRow(new Object[]{getEventi().get(j), scalamedia.get(j),  getContaEvent().get(j)});
				}
				controlsev = false;
				psix.remove(CP);
				psix.remove(CPs);
				psix.revalidate();
				psix.repaint();
				
				if((!(mapnote.isEmpty()))) {
					for (int h=0;h<getEventi().size();h++) {
						for (Map.Entry<String, ArrayList<String[]>> mappacheck : mapnote.entrySet()) {
							if (getEventi().get(h).contentEquals(mappacheck.getKey())){
								String eventomatch = mappacheck.getKey();
								ArrayList<String[]> notevento = new ArrayList<String[]>();
								notevento = mapnote.get(eventomatch);
								for (int k=0; k<notevento.size();k++) {
									String [] noteutente = notevento.get(k);
									if (!(noteutente[2].isEmpty())) {
										String starcomment = starMaker(Integer.parseInt(noteutente[1]));
										String notatext = "Utente: " +noteutente[0]+ ".\nEvento avverso segnalato: " +eventomatch+ ". Severità: "+starcomment+"\n~"+noteutente[2]+"~\n\n";
										noteventi.append(notatext);
									}
								}
							}
				        }
					}
				}
				
				if (!(getEventi().isEmpty())) {
					diagramma = createChart(getEventi(), getContaEvent(), controlsev, "EVENTI AVVERSI PER MODERNA");
					CP = new ChartPanel(diagramma);
					CP.setPreferredSize(new Dimension (220,240));
					
					
					if (viewnotes ==false) {
						psix.add(CP, gbc_chart_1);
					}else {
						psix.add(scrollnote,gbc_noteventi);
					}
					
				}else {
					CP.setVisible(false);
				}
			}
		});
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.setRowCount(0);
				table.removeAll();
				noteventi.setText("");
				mapnote.clear();
				ArrayList <Double> scalamedia = new ArrayList <Double>();
				
				mapnote = callData.eventsData(CVname, CVtown, btnGrouptwo.getSelection().getActionCommand());
				scalamedia = eventiSort(btnGrouptwo.getSelection().getActionCommand());
				
				for (int j = 0; j<scalatot.size(); j++) {
					dlm.addRow(new Object[]{getEventi().get(j), scalamedia.get(j),  getContaEvent().get(j)});
				}
				controlsev = false;
				psix.remove(CP);
				psix.remove(CPs);
				psix.revalidate();
				psix.repaint();
				
				if((!(mapnote.isEmpty()))) {
					for (int h=0;h<getEventi().size();h++) {
						for (Map.Entry<String, ArrayList<String[]>> mappacheck : mapnote.entrySet()) {
							if (getEventi().get(h).contentEquals(mappacheck.getKey())){
								String eventomatch = mappacheck.getKey();
								ArrayList<String[]> notevento = new ArrayList<String[]>();
								notevento = mapnote.get(eventomatch);
								for (int k=0; k<notevento.size();k++) {
									String [] noteutente = notevento.get(k);
									if (!(noteutente[2].isEmpty())) {
										String starcomment = starMaker(Integer.parseInt(noteutente[1]));
										String notatext = "Utente: " +noteutente[0]+ ".\nEvento avverso segnalato: " +eventomatch+ ". Severità: "+starcomment+"\n~"+noteutente[2]+"~\n\n";
										noteventi.append(notatext);
									}
								}
							}
				        }
					}
				}
				
				if (!(getEventi().isEmpty())) {
					diagramma = createChart(getEventi(), getContaEvent(), controlsev, "EVENTI PER ASTRAZENECA");
					CP = new ChartPanel(diagramma);
					CP.setPreferredSize(new Dimension (220,240));
					
					if (viewnotes ==false) {
						psix.add(CP, gbc_chart_1);
					}else {
						psix.add(scrollnote,gbc_noteventi);
					}
					
				}else {
					CP.setVisible(false);
				}
			}
		});
		
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.setRowCount(0);
				table.removeAll();
				noteventi.setText("");
				mapnote.clear();
				ArrayList <Double> scalamedia = new ArrayList <Double>();
				
				mapnote = callData.eventsData(CVname, CVtown, btnGrouptwo.getSelection().getActionCommand());
				scalamedia = eventiSort(btnGrouptwo.getSelection().getActionCommand());
				
				for (int j = 0; j<scalatot.size(); j++) {
					dlm.addRow(new Object[]{getEventi().get(j), scalamedia.get(j),  getContaEvent().get(j)});
				}
				controlsev = false;
				psix.remove(CP);
				psix.remove(CPs);
				psix.revalidate();
				psix.repaint();
				
				if((!(mapnote.isEmpty()))) {
					for (int h=0;h<getEventi().size();h++) {
						for (Map.Entry<String, ArrayList<String[]>> mappacheck : mapnote.entrySet()) {
							if (getEventi().get(h).contentEquals(mappacheck.getKey())){
								String eventomatch = mappacheck.getKey();
								ArrayList<String[]> notevento = new ArrayList<String[]>();
								notevento = mapnote.get(eventomatch);
								for (int k=0; k<notevento.size();k++) {
									String [] noteutente = notevento.get(k);
									if (!(noteutente[2].isEmpty())) {
										String starcomment = starMaker(Integer.parseInt(noteutente[1]));
										String notatext = "Utente: " +noteutente[0]+ ".\nEvento avverso segnalato: " +eventomatch+ ". Severità: "+starcomment+"\n~"+noteutente[2]+"~\n\n";
										noteventi.append(notatext);
									}
								}
							}
				        }
					}
				}
				
				if (!(getEventi().isEmpty())) {
					diagramma = createChart(getEventi(), getContaEvent(), controlsev, "EVENTI AVVERSI PER JnJ");
					CP = new ChartPanel(diagramma);
					CP.setPreferredSize(new Dimension (220,240));
					
					if (viewnotes ==false) {
						psix.add(CP, gbc_chart_1);
					}else {
						psix.add(scrollnote,gbc_noteventi);
					}
					
				}else {
					CP.setVisible(false);
				}
			}
		});
		
		for (int c=1; c<=5; c++) {
			sev.add(c);
			sevstar.add(starMaker(c));
		}
		
		table.addMouseListener(new MouseAdapter() {
		    public void mouseReleased(MouseEvent e) {
		    	if (!table.getSelectionModel().isSelectionEmpty()) {
		    		if (e.getClickCount() == 1) {
		    			
		    			noteventi.setText("");
		    			
		    			int row = table.getSelectedRow();
		    			contasev.clear();
		    			String eventocheck =(String)dlm.getValueAt(row, 0);
		    			
		    			ArrayList <Integer> countsev = new ArrayList <Integer>();
		    			for (int k=1; k<=5; k++) {
		    				countsev.add(0);
		    			}
		    			int markc;
		    			
						for (Map.Entry<String, ArrayList<String[]>> mappacheck : mapnote.entrySet()) {
							if (eventocheck.contentEquals(mappacheck.getKey())){
								String eventomatch = mappacheck.getKey();
								ArrayList<String[]> notevento = new ArrayList<String[]>();
								notevento = mapnote.get(eventomatch);
								for (int k=0; k<notevento.size();k++) {
									String [] noteutente = notevento.get(k);
									for (int f=0; f<sev.size();f++) {
										if (sev.get(f) == Integer.parseInt(noteutente[1])){
											markc = countsev.get(f);
											markc++;
											countsev.set(f, markc);
										}
									}
								}
							}
						 }
						
						if((!(mapnote.isEmpty()))) {
							for (Map.Entry<String, ArrayList<String[]>> mappacheck : mapnote.entrySet()) {
								if (eventocheck.contentEquals(mappacheck.getKey())){
									String eventomatch = mappacheck.getKey();
									ArrayList<String[]> notevento = new ArrayList<String[]>();
									notevento = mapnote.get(eventomatch);
									for (int k=0; k<notevento.size();k++) {
										String [] noteutente = notevento.get(k);
										if (!(noteutente[2].isEmpty())) {
											String starcomment = starMaker(Integer.parseInt(noteutente[1]));
											String notatext = "Utente: " +noteutente[0]+ ".\nEvento avverso segnalato: " +eventomatch+ ". Severità: "+starcomment+"\n~"+noteutente[2]+"~\n\n";
											noteventi.append(notatext);
										}
									}
								}
						    }
						}
						
		    			psix.remove(CPs);
		    			psix.revalidate();
		    			psix.repaint();
		    			controlsev = true;
		    			diagrammas = createChart(sevstar, countsev, controlsev, "SEVERITÁ");
		    			CPs = new ChartPanel(diagrammas);
		    			CPs.setPreferredSize(new Dimension (220,240));
		    			if (viewnotes == false) {
		    				psix.add(CPs, gbc_chart_2);
						}
		    			
		    			
		    		}
		    		
		    	}
		    }
		});
		
		JButton btnNewButton_1 = new JButton("VISUALIZZA COMMENTI");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 10;
		psix.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VISUALIZZA GRAFICI");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_2.gridwidth = 2;
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 10;
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewnotes = true;
				psix.remove(C);
				psix.remove(CP);
				psix.remove(CPs);
				psix.remove(btnNewButton_1);
				psix.revalidate();
    			psix.repaint();
				psix.add(scrollnote, gbc_noteventi);
				psix.add(btnNewButton_2, gbc_btnNewButton_2);
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewnotes = false;
				psix.remove(btnNewButton_2);
				psix.remove(scrollnote);
				psix.revalidate();
    			psix.repaint();
    			psix.add(btnNewButton_1, gbc_btnNewButton_1);
				psix.add(C, gbc_chart);
				psix.add(CP, gbc_chart_1);
				if (!table.getSelectionModel().isSelectionEmpty()) {
					psix.add(CPs, gbc_chart_2);
				}
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("INSERISCI EVENTO AVVERSO");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panEvent insertevent = new panEvent(infopack, false, searchpos);
				removeAll();
				add(insertevent);
				repaint();
				revalidate();
			}
		});
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_3.gridwidth = 3;
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 10;
		
		if (!(infopack.isEmpty())) {
			String comuneCVmatch = infopack.get(4);
			String nomeCVmatch = infopack.get(5);
			if ((nomeCVmatch.contentEquals(CVname)) && (comuneCVmatch.contentEquals(CVtown))){
				psix.add(btnNewButton_3, gbc_btnNewButton_3);
			}
		}
		
	}
	
	
	
	private static PieDataset createDataset(List <String> nome_evento, List <Integer>conta_evento) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int sommaeventi=0;
        for (int i=0; i<nome_evento.size() && i<5; i++) {
        	String nomecut = nome_evento.get(i);
        	if(nomecut.length()>18) {
        		nomecut = nomecut.substring(0,18) + ".";
        		dataset.setValue(nomecut, conta_evento.get(i));
        	}else {
        		dataset.setValue(nome_evento.get(i), conta_evento.get(i));
        	}
        }
        if (nome_evento.size()>5) {
        	for (int i=5; i<nome_evento.size(); i++) {
            	sommaeventi = sommaeventi + conta_evento.get(i);
            }
        	dataset.setValue("Altri", sommaeventi);
        }
        return dataset;  
    }
	
	private static JFreeChart createChart(List <String> nome_evento, List <Integer>conta_evento, Boolean control_sev, String titolo) {
		PieDataset dataset = createDataset(nome_evento, conta_evento);
        JFreeChart chart = ChartFactory.createPieChart(
            titolo,  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );
        chart.setBackgroundPaint(sfondo);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(null);
        plot.setCircular(false);
        plot.setNoDataMessage("No data available");
        plot.setBackgroundPaint(sfondo);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setInsets(RectangleInsets.ZERO_INSETS);
        
        if (control_sev==true) {
        	plot.setSectionPaint(dataset.getKey(0), Color.WHITE);
            plot.setSectionPaint(dataset.getKey(1), Color.GREEN);
            plot.setSectionPaint(dataset.getKey(2), Color.YELLOW);
            plot.setSectionPaint(dataset.getKey(3), Color.ORANGE);
            plot.setSectionPaint(dataset.getKey(4), Color.RED);
        }
        
        chart.getLegend().setBackgroundPaint(sfondo);
        chart.removeLegend();
        LegendTitle legend;
        if (control_sev==true) {
        	legend = new LegendTitle(plot, new GridArrangement(3, 3), new GridArrangement(1, 1));
        }else {
        	legend = new LegendTitle(plot, new GridArrangement(3, 2), new GridArrangement(1, 1));
        }
     	legend.setPosition(RectangleEdge.BOTTOM);
     	legend.setItemFont(new Font("FreeMono", Font.BOLD, 14));
     	chart.addLegend(legend);
        if (control_sev == true) {
        }
        
        chart.getTitle().setBackgroundPaint(sfondo);
        chart.getTitle().setMargin(RectangleInsets.ZERO_INSETS);
        chart.getTitle().setFont(new Font("Tahoma", Font.BOLD, 16));
        return chart;
	}
	
	
	
	
	private ArrayList <Double> eventiSort(String tipoVax) {
		ArrayList <Double> mediascala = new ArrayList <Double>();
		ArrayList <String> eventiVax = new ArrayList <String>();
		ArrayList <Integer> contaVax = new ArrayList <Integer>();
		ArrayList <Integer> scalaVax = new ArrayList <Integer>();
		eventiVax = getEventi();
		contaVax = getContaEvent();
		scalaVax = getScalaTot();
		int markc = 0;
		int marks = 0;
		float markm = 0;
		double scalaround = 0;
		
		quicksort(eventiVax, contaVax, scalaVax, 0, contaevent.size() - 1);
		
		for (int f = 0; f<scalaVax.size(); f++) {
			marks = scalaVax.get(f);
			markc = contaVax.get(f);
			markm = (float) marks/markc;
			scalaround = Math.round(markm * 10.0) / 10.0;
			mediascala.add(scalaround);
		}
		
		setEventi(eventiVax);
		setContaVax(contaVax);
		setScalaTot(scalaVax);
		return mediascala;
	}
	
	
	
	
	private static void quicksort(List <String> S, List <Integer> A, List <Integer> B, int p, int r) {
	    if (p < r) {
	        int q = partition(S, A, B, p, r);
	        quicksort(S, A, B, p, q);
	        quicksort(S, A, B, q + 1, r);
	    }
	}

	private static int partition(List <String> S, List <Integer> A, List <Integer> B, int p, int r) {
	    int x = A.get(p); // pivot
	    int y = B.get(p); // pivot 2
	    int i = p;
	    int j = r;
	    while(true) {
	    	 //ignora tutti i numeri più grandi di X a sinistra
	    	 while ((A.get(i) > x) || ((A.get(i) == x) && (B.get(i)>y))) {
	    	        i++;
	    	    }
	    	 //ignora tutti i numeri più piccoli di X a destra
	    	 while ((A.get(j) < x) || ((A.get(j) == x) && (B.get(j)<y))) {
	    	        j--;
	    	 }

	    	 //scambia tutti i numeri più piccoli di X a sinistra con quelli più grandi di X a destra
	    	    if (i < j) {
	    	        int temp = A.get(i);
	    	        String tempS = S.get(i);
	    	        int tempB = B.get(i);
	    	        A.set(i, A.get(j));
	    	        S.set(i, S.get(j));
	    	        B.set(i, B.get(j));
	    	        A.set(j, temp);
	    	        S.set(j, tempS);
	    	        B.set(j, tempB);
	    	        i++;
	    	        j--;
	    	    } else {
	    	        return j;
	    	    }
	    }
	}
	
	
	public String starMaker (int severity) {
		String starSeverity ="";
		switch (severity) {
		case 1:
			starSeverity ="\u2605";
		break;
		case 2:
			starSeverity ="\u2605\u2605";
		break;
		case 3:
			starSeverity ="\u2605\u2605\u2605";
		break;
		case 4:
			starSeverity ="\u2605\u2605\u2605\u2605";
		break;
		case 5:
			starSeverity ="\u2605\u2605\u2605\u2605\u2605";
		break;
		}
		return starSeverity;
	}
	
	
	
	public void setNomeVax(ArrayList<String> nomevax) {
		this.nomevax=nomevax;
	}
	
	public ArrayList<String> getNomeVax() {
		return this.nomevax;
	}

	public void setContaVax(ArrayList<Integer> contavax){
		this.contavax=contavax;
	}
	
	public ArrayList<Integer> getContaVax() {
		return this.contavax;
	}
	
	public void setEventi(ArrayList<String> eventi) {
		this.eventi=eventi;
	}
	
	public ArrayList<String> getEventi() {
		return this.eventi;
	}
	
	public void setContaEvent(ArrayList<Integer> contaevent){
		this.contaevent=contaevent;
	}
	
	public ArrayList<Integer> getContaEvent() {
		return this.contaevent;
	}
	
	public void setScalaTot(ArrayList<Integer> scalatot){
		this.scalatot=scalatot;
	}
	
	public ArrayList<Integer> getScalaTot() {
		return this.scalatot;
	}
	
	public void setSev(ArrayList<Integer> sev){
		this.sev=sev;
	}
	
	public ArrayList<Integer> getSev() {
		return this.sev;
	}
	
	public void setContaSev(ArrayList<Integer> contasev){
		this.contasev=contasev;
	}
	
	public ArrayList<Integer> getContaSev() {
		return this.contasev;
	}
}
