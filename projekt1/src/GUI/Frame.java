package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import com.toedter.calendar.JDateChooser;

import BuildingProcessManager.Runner;
import BuildingProcessManager.Databaze.EtapaManagment;
import BuildingProcessManager.Databaze.ObjednavkaManagment;
import BuildingProcessManager.Databaze.StavbaManagment;
import BuildingProcessManager.Databaze.ZamestnanecManagment;
import BuildingProcessManager.models.Etapa;
import BuildingProcessManager.models.Objednavatel;
import BuildingProcessManager.models.Objednavka;
import BuildingProcessManager.models.Stavba;
import BuildingProcessManager.models.Zamestnanec;
import BuildingProcessManager.models.Adresa;
import BuildingProcessManager.models.ZamestnanecEtapy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JComboBox;

import java.awt.Component;

import javax.swing.JScrollBar;

public class Frame {


	List<TableData> data = new ArrayList<TableData>();
    private JTabbedPane tabbedPane;
    private JTable allTable;
    private AllTableModel allTableModel;
    public int program =0;
    private static Runner spustac;
    public static int podprogram = 0;
    private static JFrame frame = new JFrame();
    private static JFrame frmBuildingprocessmanager;
	private static ZamestnanecManagment spustacZ;
	private static StavbaManagment spustacS;
	
	public static void main(String[] args) throws SQLException {
		System.out.printf("Zmenil sa program");
    	spustacZ = new ZamestnanecManagment();
    	spustac = new Runner();
    	spustacZ=spustac.Start();
    	spustacS= new StavbaManagment();
    	spustac.setVsetciZamestnanci(spustacZ);
    	new Frame();
    	System.out.printf("Tu sme");
    }
	JDateChooser dateChooser = new JDateChooser();
	JDateChooser dateChooser_1 = new JDateChooser();
	JButton btnNewButton = new JButton("OK");
	JButton button = new JButton("OK");
	JScrollPane scrollPane = new JScrollPane((Component) null);
	JScrollPane scrollPane_1 = new JScrollPane((Component) null);
	List<Etapa> etapy = new LinkedList<>();
	List<Etapa> etapyu = new LinkedList<>();
	 
	public class EditFrame extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public static final int program = 0;
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		JDateChooser dateChooser = new JDateChooser();
		JDateChooser dateChooser_1 = new JDateChooser();
		JButton btnNewButton = new JButton("OK");
		JButton button = new JButton("OK");
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_2;
        Date DatumStar = new Date();
        Date DatumEnd = new Date();
        Zamestnanec Novy = new Zamestnanec();
		 
		public EditFrame(Integer Id,String Meno, String Priezvisko, Boolean Zdravotny_stav, String Telefon, String Ulica, String Cislo,String Mesto, String PSC, Boolean Maliar, Boolean Murar, Boolean Obkladac, Boolean Betonar, Boolean Klampiar, Boolean Vodic_bager, Boolean Vodic_nakladne, Boolean Architekt, Date ZaciatokPN, Date KoniecPN) throws InterruptedException {
			//setVisible(true);
			ButtonGroup group = new ButtonGroup();
			JLabel lblNewLabel = new JLabel("OD:");
			JLabel lblNewLabel_1 = new JLabel("DO:");
			setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
			setBounds(100, 100, 730, 515);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(129, 29, 116, 22);
			textField.setText(Meno);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblMeno = new JLabel("Meno:");
			lblMeno.setBounds(12, 32, 56, 16);
			//lblMeno.setText(Meno);
			contentPane.add(lblMeno);
			
			JLabel lblPriezvisko = new JLabel("Priezvisko:");
			lblPriezvisko.setBounds(12, 81, 69, 16);
			
			contentPane.add(lblPriezvisko);
			
			textField_1 = new JTextField();
			textField_1.setBounds(129, 78, 116, 22);
			textField_1.setText(Priezvisko);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblZdravotnStav = new JLabel("Zdravotn\u00FD stav:");
			lblZdravotnStav.setBounds(12, 137, 97, 16);
			contentPane.add(lblZdravotnStav);
			
			JRadioButton rdbtnZdrav = new JRadioButton("Zdrav\u00FD");
			rdbtnZdrav.setBounds(129, 133, 69, 25);
			contentPane.add(rdbtnZdrav);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("PN");
			rdbtnNewRadioButton.setBounds(199, 133, 46, 25);
			contentPane.add(rdbtnNewRadioButton);
			
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				dateChooser.setVisible(true);
				dateChooser_1.setVisible(true);
				button.setVisible(false);
				btnNewButton.setVisible(true);
				}
			});
			rdbtnZdrav.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				dateChooser.setVisible(false);
				dateChooser_1.setVisible(false);
				button.setVisible(true);
				btnNewButton.setVisible(false);
				}
			});
			group.add(rdbtnNewRadioButton);
			group.add(rdbtnZdrav);
			lblNewLabel.setVisible(false);
			lblNewLabel_1.setVisible(false);
			dateChooser_1.setVisible(false);
			btnNewButton.setVisible(false);
			button.setVisible(true);
			lblNewLabel.setBounds(266, 137, 31, 16);
			contentPane.add(lblNewLabel);
			
			lblNewLabel_1.setBounds(454, 137, 22, 16);
			contentPane.add(lblNewLabel_1);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultComboBoxModel model = new DefaultComboBoxModel();
			Calendar cal = Calendar.getInstance();
	        for (int index = 0; index < 100; index++) {
	            model.addElement(cal.getTime());
	            cal.add(Calendar.DATE, 1);
	        }
	        if(Zdravotny_stav==false){
	        	
	        	dateChooser.setDate(ZaciatokPN);
	        	dateChooser_1.setDate(KoniecPN);
	        }
	        
	        if(Zdravotny_stav==false) {
				rdbtnNewRadioButton.setSelected(true);
				lblNewLabel.setVisible(true);
				lblNewLabel_1.setVisible(true);
				dateChooser.setVisible(true);
				dateChooser_1.setVisible(true);
				button.setVisible(false);
				btnNewButton.setVisible(true);
				
			}
    		else rdbtnZdrav.setSelected(true);
	        dateChooser.setVisible(false);
	        dateChooser.setBounds(298, 131, 122, 22);
	        contentPane.add(dateChooser);
	      
	        dateChooser_1.setBounds(499, 133, 122, 22);
	        contentPane.add(dateChooser_1);
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		DatumStar = dateChooser.getDate();
	        		DatumEnd = dateChooser_1.getDate();
	        		if(DatumStar==null|| DatumEnd==null) Novy.setZdravotny_stav(true);
	        		else{
	        			Novy.setZaciatokPN(DatumStar);
	        			Novy.setKoniecPN(DatumEnd);
	        			Novy.setZdravotny_stav(false);
	        		}
	        		SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
	        		System.out.printf("Zaciatok PN: %s Koniec PN: %s\n", ft.format(DatumStar), DatumEnd);
	        	}
	        });
	        btnNewButton.setBounds(633, 135, 56, 20);
	        contentPane.add(btnNewButton);
	        
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Novy.setZaciatokPN(null);
        			Novy.setKoniecPN(null);
        			Novy.setZdravotny_stav(true);
	        	}
	        });
	        button.setBounds(248, 134, 69, 22);
	        contentPane.add(button);
	        
	        JLabel lblTelefn = new JLabel("Telef\u00F3n:");
	        lblTelefn.setBounds(12, 199, 56, 16);
	        contentPane.add(lblTelefn);
	        
	        JLabel lblAdresa = new JLabel("Adresa:");
	        lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblAdresa.setBounds(12, 256, 56, 16);
	        contentPane.add(lblAdresa);
	        
	        JLabel lblUlica = new JLabel("Ulica:");
	        lblUlica.setBounds(12, 301, 56, 16);
	        contentPane.add(lblUlica);
	        
	        textField_3 = new JTextField();
	        textField_3.setText(Ulica);
	        textField_3.setBounds(129, 298, 116, 22);
	        contentPane.add(textField_3);
	        textField_3.setColumns(10);
	        
	        JLabel lblslo = new JLabel("\u010C\u00EDslo:");
	        lblslo.setBounds(12, 346, 56, 16);
	        contentPane.add(lblslo);
	        
	        textField_4 = new JTextField();
	        textField_4.setBounds(129, 343, 116, 22);
	        textField_4.setText(Cislo);
	        contentPane.add(textField_4);
	        textField_4.setColumns(10);
	        
	        JLabel lblMesto = new JLabel("Mesto:");
	        lblMesto.setBounds(12, 388, 56, 16);
	        contentPane.add(lblMesto);
	        
	        textField_5 = new JTextField();
	        textField_5.setBounds(129, 382, 116, 22);
	        textField_5.setText(Mesto);
	        contentPane.add(textField_5);
	        textField_5.setColumns(10);
	        
	        JLabel lblPs = new JLabel("PS\u010C:");
	        lblPs.setBounds(12, 428, 56, 16);
	        contentPane.add(lblPs);
	        
	        textField_6 = new JTextField();
	        textField_6.setText(PSC);
	        textField_6.setBounds(129, 425, 116, 22);
	        contentPane.add(textField_6);
	        textField_6.setColumns(10);
	        
	        JLabel lbloVieUrobi = new JLabel("Zru\u010Dnosti:");
	        lbloVieUrobi.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lbloVieUrobi.setBounds(346, 256, 107, 16);
	        contentPane.add(lbloVieUrobi);
	        
	        JCheckBox chckbxMaliar = new JCheckBox("Maliar");
	        if(Maliar==true) chckbxMaliar.setSelected(true);
	        chckbxMaliar.setBounds(363, 297, 113, 25);
	        contentPane.add(chckbxMaliar); 
	        
	        JCheckBox chckbxNewCheckBox = new JCheckBox("Mur\u00E1r");
	        if(Murar==true) chckbxNewCheckBox.setSelected(true);
	        chckbxNewCheckBox.setBounds(363, 327, 113, 25);
	        contentPane.add(chckbxNewCheckBox);
	        
	        JCheckBox chckbxObklada = new JCheckBox("Obklada\u010D");
	        if(Obkladac==true) chckbxObklada.setSelected(true);
	        chckbxObklada.setBounds(363, 359, 113, 25);
	        contentPane.add(chckbxObklada);
	        
	        JCheckBox chckbxBetonr = new JCheckBox("Beton\u00E1r");
	        if(Betonar==true) chckbxBetonr.setSelected(true);
	        chckbxBetonr.setBounds(363, 384, 113, 25);
	        contentPane.add(chckbxBetonr);
	        
	        JCheckBox chckbxKlampiar = new JCheckBox("Klampiar");
	        if(Klampiar==true) chckbxKlampiar.setSelected(true);
	        chckbxKlampiar.setBounds(363, 414, 113, 25);
	        contentPane.add(chckbxKlampiar);
	        
	        JCheckBox chckbxVodibager = new JCheckBox("Vodi\u010D(bager)");
	        if(Vodic_bager==true) chckbxVodibager.setSelected(true);
	        chckbxVodibager.setBounds(483, 297, 113, 25);
	        contentPane.add(chckbxVodibager);
	        
	        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Vodi\u010D(N\u00E1kladn\u00E9 auto)");
	        if(Vodic_nakladne==true) chckbxNewCheckBox_1.setSelected(true);
	        chckbxNewCheckBox_1.setBounds(481, 327, 187, 25);
	        contentPane.add(chckbxNewCheckBox_1);
	        
	        JCheckBox chckbxArchitekt = new JCheckBox("Architekt");
	        if(Architekt==true) chckbxArchitekt.setSelected(true);
	        chckbxArchitekt.setBounds(483, 359, 113, 25);
	        contentPane.add(chckbxArchitekt);
	        
	        JButton btnUloi = new JButton("ULO\u017DI\u0164");
	        btnUloi.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		Zamestnanec Stary = new Zamestnanec();
	        		Stary.setMeno(Meno);
	        		Stary.setPriezvisko(Priezvisko);
	        		Stary.setId(Id);
	        		Novy.setId(Id);
	        		int good=0;
	        			good=0;
	        			if(textField.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste meno");
	        			else good++;
	        			if(textField_1.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste priezvisko");
	        			else good++;
	        			if(textField_2.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste telefónne èíslo");
	        			else good++;
	        			if(textField_3.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste názov ulice");
	        			else good++;
	        			if(textField_4.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste èíslo domu");
	        			else good++;
	        			if(textField_5.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste mesto");
	        			else good++;
	        			if(textField_6.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste PSÈ");
	        			else good++;
	        		if(good==7){
	        		Adresa Nova = new Adresa(Integer.parseInt(textField_4.getText()),textField_3.getText(),textField_5.getText(),textField_6.getText());
	        		if(chckbxMaliar.isSelected()==true) Novy.setMaliar(true);
	        		else Novy.setMaliar(false);
	        		if(chckbxNewCheckBox.isSelected()==true) Novy.setMurar(true);
	        		else Novy.setMurar(false);
	        		if(chckbxObklada.isSelected()==true) Novy.setObkladac(true);
	        		else Novy.setObkladac(false);
	        		if(chckbxBetonr.isSelected()==true) Novy.setBetonar(true);
	        		else Novy.setBetonar(false);
	        		if(chckbxKlampiar.isSelected()==true) Novy.setKlampiar(true);
	        		else Novy.setKlampiar(false);
	        		if(chckbxVodibager.isSelected()==true) Novy.setVodic_bager(true);
	        		else Novy.setVodic_bager(false);
	        		if(chckbxNewCheckBox_1.isSelected()==true) Novy.setVodic_nakladne(true);
	        		else Novy.setVodic_nakladne(false);
	        		if(chckbxArchitekt.isSelected()==true) Novy.setArchitekt(true);
	        		else Novy.setArchitekt(false);
	        		Novy.setAdresa(Nova);
	        		Novy.setMeno(textField.getText());
	        		Novy.setPriezvisko(textField_1.getText());
	        		Novy.setTelefon(textField_2.getText());
	        		//Post Post = new Post();
	        		
	        		dispose();
	        		try {
						spustacZ.updateZamestnanec(Stary,Novy);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		try {
						for (Zamestnanec zamestnanec : spustacZ.getAllZamestnanec()) {
							System.out.println(zamestnanec.getMeno() + ":" + zamestnanec.getPriezvisko()+"-"+zamestnanec.getPost().getNazov());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		frame.dispose();
	        		frame=null;
	        		try {
						spustac.setVsetciZamestnanci(spustacZ);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		new Frame();
	        		try {
						for (Zamestnanec zamestnanec : spustacZ.getAllZamestnanec()) {
							System.out.println(zamestnanec.getMeno() + ":" + zamestnanec.getPriezvisko()+"-"+zamestnanec.getPost().getNazov());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		//frame = new Frame1();
	        		//updateZamestnanec(Stary, Novy);
	        	}
	        	}
	        });
	        btnUloi.setBounds(476, 390, 97, 41);
	        contentPane.add(btnUloi);
	        
	        textField_2 = new JTextField();
	        textField_2.setText(Telefon);
	        textField_2.setBounds(129, 196, 116, 22);
	        contentPane.add(textField_2);
	        textField_2.setColumns(10);
	        
	        JButton btnNewButton_1 = new JButton("STORNO");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        	}
	        });
	        btnNewButton_1.setBounds(585, 388, 104, 41);
	        contentPane.add(btnNewButton_1);
	        
	}	
	}
	
	@SuppressWarnings("serial")
	public class InsertFrame extends JFrame {

		public static final int program = 0;
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		JDateChooser dateChooser = new JDateChooser();
		JDateChooser dateChooser_1 = new JDateChooser();
		JButton btnNewButton = new JButton("OK");
		JButton button = new JButton("OK");
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_2;
		//private static Object lock = new Object();
		//private static JFrame frame = new JFrame();
		 
		public InsertFrame() throws InterruptedException {
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 730, 515);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(129, 29, 116, 22);
			textField.setText("");
			contentPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblMeno = new JLabel("Meno:");
			lblMeno.setBounds(12, 32, 56, 16);
			//lblMeno.setText(Meno);
			contentPane.add(lblMeno);
			
			JLabel lblPriezvisko = new JLabel("Priezvisko:");
			lblPriezvisko.setBounds(12, 81, 69, 16);
			
			contentPane.add(lblPriezvisko);
			
			textField_1 = new JTextField();
			textField_1.setBounds(129, 78, 116, 22);
			textField_1.setText("");
			contentPane.add(textField_1);
			textField_1.setColumns(10);
	    
	        
	        JLabel lblTelefn = new JLabel("Telef\u00F3n:");
	        lblTelefn.setBounds(12, 199, 56, 16);
	        contentPane.add(lblTelefn);
	        
	        JLabel lblAdresa = new JLabel("Adresa:");
	        lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblAdresa.setBounds(12, 256, 56, 16);
	        contentPane.add(lblAdresa);
	        
	        JLabel lblUlica = new JLabel("Ulica:");
	        lblUlica.setBounds(12, 301, 56, 16);
	        contentPane.add(lblUlica);
	        
	        textField_3 = new JTextField();
	        textField_3.setText("");
	        textField_3.setBounds(129, 298, 116, 22);
	        contentPane.add(textField_3);
	        textField_3.setColumns(10);
	        
	        JLabel lblslo = new JLabel("\u010C\u00EDslo:");
	        lblslo.setBounds(12, 346, 56, 16);
	        contentPane.add(lblslo);
	        
	        textField_4 = new JTextField();
	        textField_4.setBounds(129, 343, 116, 22);
	        textField_4.setText("");
	        contentPane.add(textField_4);
	        textField_4.setColumns(10);
	        
	        JLabel lblMesto = new JLabel("Mesto:");
	        lblMesto.setBounds(12, 388, 56, 16);
	        contentPane.add(lblMesto);
	        
	        textField_5 = new JTextField();
	        textField_5.setBounds(129, 382, 116, 22);
	        textField_5.setText("");
	        contentPane.add(textField_5);
	        textField_5.setColumns(10);
	        
	        JLabel lblPs = new JLabel("PS\u010C:");
	        lblPs.setBounds(12, 428, 56, 16);
	        contentPane.add(lblPs);
	        
	        textField_6 = new JTextField();
	        textField_6.setText("");
	        textField_6.setBounds(129, 425, 116, 22);
	        contentPane.add(textField_6);
	        textField_6.setColumns(10);
	        
	        JLabel lbloVieUrobi = new JLabel("Zru\u010Dnosti:");
	        lbloVieUrobi.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lbloVieUrobi.setBounds(346, 256, 107, 16);
	        contentPane.add(lbloVieUrobi);
	        
	        JCheckBox chckbxMaliar = new JCheckBox("Maliar");
	        chckbxMaliar.setBounds(363, 297, 113, 25);
	        contentPane.add(chckbxMaliar);
	        
	        JCheckBox chckbxNewCheckBox = new JCheckBox("Mur\u00E1r");
	        chckbxNewCheckBox.setBounds(363, 327, 113, 25);
	        contentPane.add(chckbxNewCheckBox);
	        
	        JCheckBox chckbxObklada = new JCheckBox("Obklada\u010D");
	        chckbxObklada.setBounds(363, 359, 113, 25);
	        contentPane.add(chckbxObklada);
	        
	        JCheckBox chckbxBetonr = new JCheckBox("Beton\u00E1r");
	        chckbxBetonr.setBounds(363, 384, 113, 25);
	        contentPane.add(chckbxBetonr);
	        
	        JCheckBox chckbxKlampiar = new JCheckBox("Klampiar");
	        chckbxKlampiar.setBounds(363, 414, 113, 25);
	        contentPane.add(chckbxKlampiar);
	        
	        JCheckBox chckbxVodibager = new JCheckBox("Vodi\u010D(bager)");
	        chckbxVodibager.setBounds(483, 297, 113, 25);
	        contentPane.add(chckbxVodibager);
	        
	        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Vodi\u010D(N\u00E1kladn\u00E9 auto)");
	        chckbxNewCheckBox_1.setBounds(481, 327, 187, 25);
	        contentPane.add(chckbxNewCheckBox_1);
	        
	        JCheckBox chckbxArchitekt = new JCheckBox("Architekt");
	        chckbxArchitekt.setBounds(483, 359, 113, 25);
	        contentPane.add(chckbxArchitekt);
	        
	        JButton btnUloi = new JButton("ULO\u017DI\u0164");
	        btnUloi.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Zamestnanec Novy = new Zamestnanec();
	        		int good=0;
	        			good=0;
	        			if(textField.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste meno");
	        			else good++;
	        			if(textField_1.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste priezvisko");
	        			else good++;
	        			if(textField_2.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste telefónne èíslo");
	        			else good++;
	        			if(textField_3.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste názov ulice");
	        			else good++;
	        			if(textField_4.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste èíslo domu");
	        			else good++;
	        			if(textField_5.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste mesto");
	        			else good++;
	        			if(textField_6.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste PSÈ");
	        			else good++;
	        		if(good==7){
	        		Adresa Nova = new Adresa(Integer.parseInt(textField_4.getText()),textField_3.getText(),textField_5.getText(),textField_6.getText());
	        		if(chckbxMaliar.isSelected()==true) Novy.setMaliar(true);
	        		else Novy.setMaliar(false);
	        		if(chckbxNewCheckBox.isSelected()==true) Novy.setMurar(true);
	        		else Novy.setMurar(false);
	        		if(chckbxObklada.isSelected()==true) Novy.setObkladac(true);
	        		else Novy.setObkladac(false);
	        		if(chckbxBetonr.isSelected()==true) Novy.setBetonar(true);
	        		else Novy.setBetonar(false);
	        		if(chckbxKlampiar.isSelected()==true) Novy.setKlampiar(true);
	        		else Novy.setKlampiar(false);
	        		if(chckbxVodibager.isSelected()==true) Novy.setVodic_bager(true);
	        		else Novy.setVodic_bager(false);
	        		if(chckbxNewCheckBox_1.isSelected()==true) Novy.setVodic_nakladne(true);
	        		else Novy.setVodic_nakladne(false);
	        		if(chckbxArchitekt.isSelected()==true) Novy.setArchitekt(true);
	        		else Novy.setArchitekt(false);
	        		Novy.setAdresa(Nova);
	        		Novy.setMeno(textField.getText());
	        		Novy.setPriezvisko(textField_1.getText());
	        		Novy.setTelefon(textField_2.getText());
	        		
	        		//Post Post = new Post();
	        		//Novy.setPost();
	        		
	        		dispose();
	        		try {
						spustacZ.insertZamestnanec(Novy);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		try {
						for (Zamestnanec zamestnanec : spustacZ.getAllZamestnanec()) {
							System.out.println(zamestnanec.getMeno() + ":" + zamestnanec.getPriezvisko()+"-"+zamestnanec.getPost().getNazov());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		frame.dispose();
	        		frame=null;
	        		try {
						spustac.setVsetciZamestnanci(spustacZ);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		//new Frame();
	        		try {
						for (Zamestnanec zamestnanec : spustacZ.getAllZamestnanec()) {
							System.out.println(zamestnanec.getMeno() + ":" + zamestnanec.getPriezvisko()+"-"+zamestnanec.getPost().getNazov());
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		}
	        	}
	        		//frame = new Frame1();
	        		//updateZamestnanec(Stary, Novy);
	        });
	        btnUloi.setBounds(476, 390, 97, 41);
	        contentPane.add(btnUloi);
	        
	        textField_2 = new JTextField();
	        textField_2.setText("");
	        textField_2.setBounds(129, 196, 116, 22);
	        contentPane.add(textField_2);
	        textField_2.setColumns(10);
	        
	        JButton btnNewButton_1 = new JButton("STORNO");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        	}
	        });
	        btnNewButton_1.setBounds(585, 388, 104, 41);
	        contentPane.add(btnNewButton_1);
	        
	}	
	}
	
	public class DeleteFrame extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public DeleteFrame() throws InterruptedException {
			
	
		}
	}
	
	
    /**
     * @wbp.parser.entryPoint
     */
    public Frame() {
        for(int i=0;i<spustac.getVsetciZamestnanci().size();i++){
            data.add(new TableData(spustac.getVsetciZamestnanci().get(i).getId(),spustac.getVsetciZamestnanci().get(i).getMeno(), spustac.getVsetciZamestnanci().get(i).getPriezvisko(), spustac.getVsetciZamestnanci().get(i).getZdravotny_stav(),spustac.getVsetciZamestnanci().get(i).getPost().getNazov(),spustac.getVsetciZamestnanci().get(i).getTelefon(),
            		spustac.getVsetciZamestnanci().get(i).getAdresa().getUlica(),Integer.toString(spustac.getVsetciZamestnanci().get(i).getAdresa().getNumber()),spustac.getVsetciZamestnanci().get(i).getAdresa().getMesto(),spustac.getVsetciZamestnanci().get(i).getAdresa().getPSC(), 
            		spustac.getVsetciZamestnanci().get(i).getMaliar(),spustac.getVsetciZamestnanci().get(i).getMurar(),spustac.getVsetciZamestnanci().get(i).getObkladac(),spustac.getVsetciZamestnanci().get(i).getBetonar(),spustac.getVsetciZamestnanci().get(i).getKlampiar(),
            		spustac.getVsetciZamestnanci().get(i).getVodic_bager(),spustac.getVsetciZamestnanci().get(i).getVodic_nakladne(),spustac.getVsetciZamestnanci().get(i).getArchitekt(), spustac.getVsetciZamestnanci().get(i).getZaciatokPN(),spustac.getVsetciZamestnanci().get(i).getKoniecPN()));
        }

        allTableModel = new AllTableModel(data);
        createUI();
    }

    public void vymaz(){
    	frmBuildingprocessmanager.dispose();
    }
    public void createUI() {
       // frame.getContentPane().setSize(new Dimension(100, 100));
        //frame.setMinimumSize(new Dimension(500, 500));
    	frmBuildingprocessmanager = new JFrame();
        frmBuildingprocessmanager.setSize(1215,697);
        frmBuildingprocessmanager.getContentPane().setLayout (null);
        tabbedPane = new JTabbedPane();
        tabbedPane.setLocation(0, 0);
        tabbedPane.setSize(925,617);
        //tabbedPane.setLayout(null);

        tabbedPane.add("Zamestnanci", getAllTablePanel());
        frmBuildingprocessmanager.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Odborníci", null, panel_1, null);
        panel_1.setLayout(null);
        
        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Maliar");
        chckbxNewCheckBox_2.setBounds(29, 25, 113, 25);
        panel_1.add(chckbxNewCheckBox_2);
        
        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Mur\u00E1r");
        chckbxNewCheckBox_3.setBounds(146, 25, 113, 25);
        panel_1.add(chckbxNewCheckBox_3);
        
        JCheckBox chckbxObklada_1 = new JCheckBox("Obklada\u010D");
        chckbxObklada_1.setBounds(263, 25, 113, 25);
        panel_1.add(chckbxObklada_1);
        
        JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Beton\u00E1r");
        chckbxNewCheckBox_4.setBounds(380, 25, 113, 25);
        panel_1.add(chckbxNewCheckBox_4);
        
        JCheckBox chckbxKlampiar_1 = new JCheckBox("Klampiar");
        chckbxKlampiar_1.setBounds(497, 25, 113, 25);
        panel_1.add(chckbxKlampiar_1);
        
        JCheckBox chckbxVodibager_1 = new JCheckBox("Vodi\u010D(bager)");
        chckbxVodibager_1.setBounds(614, 25, 113, 25);
        panel_1.add(chckbxVodibager_1);
        
        JCheckBox chckbxVodinkladnAuto = new JCheckBox("Vodi\u010D(n\u00E1kladn\u00E9 auto)");
        chckbxVodinkladnAuto.setBounds(726, 25, 183, 25);
        panel_1.add(chckbxVodinkladnAuto);
        
        JCheckBox chckbxArchitekt_1 = new JCheckBox("Architekt");
        chckbxArchitekt_1.setBounds(29, 80, 113, 25);
        panel_1.add(chckbxArchitekt_1);
        
        JPanel panel_2 = new JPanel();
        
        JButton btnVyhada = new JButton("Vyh\u013Eada\u0165");
        btnVyhada.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int prvy=1;
        		String prikaz = new String();
        		if(chckbxNewCheckBox_2.isSelected()==true){
        			if(prvy==1)prikaz = "o.maliar = true";
        			else prikaz=prikaz+" OR o.maliar = true";
        			prvy++;
        		}
        		if(chckbxNewCheckBox_3.isSelected()==true){
        			if(prvy==1)prikaz = "o.murar = true";
        			else prikaz=prikaz+" OR o.murar = true";
        			prvy++;
        		}
        		if(chckbxObklada_1.isSelected()==true){
        			if(prvy==1)prikaz = "o.obkladac = true";
        			else prikaz=prikaz+" OR o.obkladac = true";
        			prvy++;
        		}
        		
        		if(chckbxNewCheckBox_4.isSelected()==true){
        			if(prvy==1)prikaz = "o.betonar = true ";
        			else prikaz=prikaz+" OR o.betonar = true ";
        			prvy++;
        		}
        		if(chckbxKlampiar_1.isSelected()==true){
        			if(prvy==1)prikaz = "o.klampiar = true ";
        			else prikaz=prikaz+" OR o.klampiar = true ";
        			prvy++;
        		}
        		if(chckbxVodibager_1.isSelected()==true){
        			if(prvy==1)prikaz = "o.vodic_bager = true ";
        			else prikaz=prikaz+" OR o.vodic_bager = true ";
        			prvy++;
        		}
        		if(chckbxVodinkladnAuto.isSelected()==true){
        			if(prvy==1)prikaz = "o.vodic_nakladne = true ";
        			else prikaz=prikaz+" OR o.vodic_nakladne = true ";
        			prvy++;
        		}
        		if(chckbxArchitekt_1.isSelected()==true){
        			if(prvy==1)prikaz = "o.architekt = true ";
        			else prikaz=prikaz+" OR o.architekt = true ";
        			prvy++;
        		}
        		prikaz = "SELECT * FROM zamestnanci o JOIN Post p ON o.Post_id=p.id where "+prikaz;
        		List<Zamestnanec> Odbornici = new LinkedList<Zamestnanec>();
        		try {
					Odbornici = spustacZ.getOdbornici(prikaz);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		try {
        			System.out.printf("\n\n\n\n Vypis odbotnikov");
					for (Zamestnanec zamestnanec : spustacZ.getOdbornici(prikaz)) {
						System.out.println(zamestnanec.getMeno() + ":" + zamestnanec.getPriezvisko());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		String[] header = {"Osobné ID","Meno","Priezvisko","Maliar","Murár","Obkladaè","Betonár","Klampiar","Vodiè(bager)","Vodiè(nakladiak)","Architekt"
        		};
        		String[][] obj;
        		obj = new String [Odbornici.size()][];
        		for(int i=0;i<Odbornici.size();i++){
        			obj[i]= new String[11];
        			System.out.printf("Toto je èíslo ktoré chcem vytlaèi: %d", Odbornici.get(i).getId());
        			String j = Odbornici.get(i).getId().toString();
        			obj[i][0]=j;
        			obj[i][1]=Odbornici.get(i).getMeno();
        			obj[i][2]=Odbornici.get(i).getPriezvisko();
        			if(Odbornici.get(i).getMaliar()==true) obj[i][3]="Áno";
        			else obj[i][3]="Nie";
        			if(Odbornici.get(i).getMurar()==true) obj[i][4]="Áno";
        			else obj[i][4]="Nie";
        			if(Odbornici.get(i).getObkladac()==true) obj[i][5]="Áno";
        			else obj[i][5]="Nie";
        			if(Odbornici.get(i).getBetonar()==true) obj[i][6]="Áno";
        			else obj[i][6]="Nie";
        			if(Odbornici.get(i).getKlampiar()==true) obj[i][7]="Áno";
        			else obj[i][7]="Nie";
        			if(Odbornici.get(i).getVodic_bager()==true) obj[i][8]="Áno";
        			else obj[i][8]="Nie";
        			if(Odbornici.get(i).getVodic_nakladne()==true) obj[i][9]="Áno";
        			else obj[i][9]="Nie";
        			if(Odbornici.get(i).getArchitekt()==true) obj[i][10]="Áno";
        			else obj[i][10]="Nie";
        			
        		}
        		
        		JPanel panel = new JPanel();
        		panel_1.setLayout(null);
        		// constructor of JTable with a fix number of objects
        		JTable table = new JTable(obj, header);
        		//panel.add(new JScrollPane(table));
        		JScrollPane scroll = 
                		new JScrollPane(table);
                scroll.setBounds(12, 13, 750, 750);
                panel_2.add(scroll);
                panel_2.setVisible(true);
                panel_2.add(panel);
                panel_2.setVisible(true);
        		
        	}
        });
        btnVyhada.setBounds(162, 80, 97, 25);
        panel_1.add(btnVyhada);
        
        panel_2.setBounds(29, 141, 837, 420);
        panel_1.add(panel_2);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Stavby", null, panel, null);
        panel.setLayout(null);
        JComboBox<String> comboBox_1 = new JComboBox<>();
        
        ObjednavkaManagment spustacO = new ObjednavkaManagment();
		List<Objednavka> objednavkyNevybavene = new LinkedList<Objednavka> ();
		try {
			for (Objednavka objednavka : spustacO.getObjednavkyNevybavene()) {
				comboBox_1.addItem("("+objednavka.getId()+")" + " "+spustacO.getObjednavatelObjednavka(objednavka.getObjednavatel_id().toString()).getMeno()+" "+objednavka.getDatumZadania());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        JButton btnNewButton_3 = new JButton("Pridaj stavbu");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Object vybraty = comboBox_1.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		NewStavba okno = new NewStavba(Integer.parseInt(pomocna));
        		
        	}
        });
        btnNewButton_3.setBounds(618, 75, 213, 42);
        panel.add(btnNewButton_3);
        
        JComboBox<String> comboBox = new JComboBox<>();
        
        
        JButton btnNewButton_4 = new JButton("Preh\u013Ead stavby");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Object vybraty = comboBox.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		try {
					for (Stavba stavba : spustacS.getAllStavby())
						if(stavba.getId()==Integer.parseInt(pomocna)){
							List<Zamestnanec> zamestnanci = new LinkedList<Zamestnanec> ();
							zamestnanci = spustacS.getZamestnanciStavby(pomocna);
							Objednavatel objednavatel = new Objednavatel();
							objednavatel = spustacS.getObjednavatel(pomocna);
							Objednavka objednavka = new Objednavka();
							objednavka = spustacS.getObjednavka(pomocna);
							Double cena = spustacS.StavbaAktualnaCena(pomocna);
							Zamestnanec veduci = spustacS.VedúciStavby(pomocna);
							Double cenavsetko = spustacS.StavbaCena(pomocna);
							new ViewStavba(stavba,objednavatel,objednavka,cena,cenavsetko,veduci,zamestnanci);
						}
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        		//String Vybrane = comboBox.
        	}
        });
        btnNewButton_4.setBounds(618, 143, 213, 42);
        panel.add(btnNewButton_4);
        
        
        try {
			for (Stavba stavba : spustacS.getAllStavby()) {
				comboBox.addItem("("+stavba.getId()+") "+stavba.getNazov());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        comboBox.setBounds(230, 143, 367, 42);
        panel.add(comboBox);
        
        comboBox_1.setBounds(230, 69, 367, 46);
        panel.add(comboBox_1);
        
        JLabel lblVyberObjednvku = new JLabel("Vyber objedn\u00E1vku:");
        lblVyberObjednvku.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVyberObjednvku.setBounds(12, 77, 193, 46);
        panel.add(lblVyberObjednvku);
        
        JLabel lblVyberStavbu = new JLabel("Vyber stavbu:");
        lblVyberStavbu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVyberStavbu.setBounds(12, 139, 193, 46);
        panel.add(lblVyberStavbu);
        
        try {
			for (Stavba stavba : spustacS.getAllStavby()) {
				comboBox.addItem("("+stavba.getId()+") "+stavba.getNazov());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("Etapy", null, panel_3, null);
        panel_3.setLayout(null);
        
        JComboBox<String> comboBox_3 = new JComboBox<>();
        try {
			for (Stavba stavba : spustacS.getAllStavby()) {
				comboBox_3.addItem("("+stavba.getId()+") "+stavba.getNazov());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        comboBox_3.setBounds(182, 54, 346, 29);
        panel_3.add(comboBox_3);
        
        JLabel lblVyberStavbu_1 = new JLabel("Vyber stavbu");
        lblVyberStavbu_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblVyberStavbu_1.setBounds(40, 54, 130, 30);
        panel_3.add(lblVyberStavbu_1);
        
        JLabel lblAktulnaEtapa = new JLabel("Aktu\u00E1lna etapa");
        lblAktulnaEtapa.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAktulnaEtapa.setBounds(40, 96, 153, 30);
        panel_3.add(lblAktulnaEtapa);
        
        JLabel lblCena = new JLabel("Cena:");
        lblCena.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCena.setBounds(40, 164, 130, 30);
        panel_3.add(lblCena);
        
        JLabel lblDtumZaatia = new JLabel("D\u00E1tum za\u010Datia:");
        lblDtumZaatia.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDtumZaatia.setBounds(40, 203, 130, 30);
        panel_3.add(lblDtumZaatia);
        
        JLabel lblPracovnci = new JLabel("Pracovn\u00EDci:");
        lblPracovnci.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPracovnci.setBounds(40, 241, 130, 30);
        panel_3.add(lblPracovnci);
        
        
        
        JLabel lblUkonenEtapy = new JLabel("Ukon\u010Den\u00E9 etapy");
        lblUkonenEtapy.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUkonenEtapy.setBounds(449, 96, 153, 30);
        panel_3.add(lblUkonenEtapy);
        
        JLabel lblCelkovCena = new JLabel("Celkov\u00E1 cena:");
        lblCelkovCena.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCelkovCena.setBounds(642, 97, 130, 30);
        panel_3.add(lblCelkovCena);
        
        JLabel label = new JLabel("Cena:");
        label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label.setBounds(449, 164, 130, 30);
        panel_3.add(label);
        
        JComboBox<String> comboBox_2 = new JComboBox<>();
        comboBox_2.setBounds(449, 139, 153, 22);
        panel_3.add(comboBox_2);
        
        JLabel label_1 = new JLabel("D\u00E1tum za\u010Datia:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_1.setBounds(449, 203, 130, 30);
        panel_3.add(label_1);
        
        JLabel label_2 = new JLabel("Pracovn\u00EDci:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_2.setBounds(449, 241, 130, 30);
        panel_3.add(label_2);
        
        
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(182, 167, 153, 24);
        panel_3.add(lblNewLabel_2);
        
        JLabel label_3 = new JLabel();
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_3.setBounds(182, 206, 153, 24);
        panel_3.add(label_3);
        
        JLabel label_4 = new JLabel();
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_4.setBounds(182, 244, 153, 24);
        panel_3.add(label_4);
        
        JLabel label_5 = new JLabel();
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_5.setBounds(619, 167, 153, 24);
        panel_3.add(label_5);
        
        JLabel label_6 = new JLabel();
        label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_6.setBounds(619, 206, 153, 24);
        panel_3.add(label_6);
        
        JLabel label_7 = new JLabel();
        label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label_7.setBounds(619, 244, 153, 24);
        panel_3.add(label_7);
        
        JButton btnNewButton_5 = new JButton("Vybra\u0165");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		label.setVisible(true);
        		label_1.setVisible(true);
        		label_2.setVisible(true);
        		scrollPane_1.setVisible(true);
        		label_5.setVisible(true);
        		label_6.setVisible(true);
        		label_7.setVisible(true);
        		
        		
        		Object vybraty = comboBox_2.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		EtapaManagment spustacE = new EtapaManagment();
        		List<ZamestnanecEtapy> zamestnanci = new LinkedList<>();
        		try {
        			zamestnanci=spustacE.getZamestnanciEtapy(etapyu.get(Integer.parseInt(pomocna)-1).getId().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

        		String[] header = {"Meno","Priezvisko","Zárobok"};
        		String[][] obj;
        		obj = new String [zamestnanci.size()][];
        		for(int k=0;k<zamestnanci.size();k++){
        			obj[k]= new String[3];
        			obj[k][0]=zamestnanci.get(k).getZamestnanec().getMeno();
        			obj[k][1]=zamestnanci.get(k).getZamestnanec().getPriezvisko();
        			obj[k][2]=zamestnanci.get(k).getCena().toString();
        			
        		}
        		
        		JTable table = new JTable(obj, header);
        		//panel.add(new JScrollPane(table));
        		JScrollPane scrollPanep = new JScrollPane(table);
        		scrollPane_1 = scrollPanep;
                scrollPane_1.setBounds(449, 273, 370, 301);
                panel_3.add(scrollPane_1);
        		
        		/*
        		String[] header = {"Osobné ID","Meno","Priezvisko","Maliar","Murár","Obkladaè","Betonár","Klampiar","Vodiè(bager)","Vodiè(nakladiak)","Architekt"
        		};
        		String[][] obj;
        		obj = new String [zamestnanci.size()][];
        		for(int i=0;i<zamestnanci.size();i++){
        			obj[i]= new String[11];
        			System.out.printf("Toto je èíslo ktoré chcem vytlaèi: %d", zamestnanci.get(i).getId());
        			String j = zamestnanci.get(i).getId().toString();
        			obj[i][0]=j;
        			obj[i][1]=zamestnanci.get(i).getMeno();
        			obj[i][2]=zamestnanci.get(i).getPriezvisko();
        			if(zamestnanci.get(i).getMaliar()==true) obj[i][3]="Áno";
        			else obj[i][3]="Nie";
        			if(zamestnanci.get(i).getMurar()==true) obj[i][4]="Áno";
        			else obj[i][4]="Nie";
        			if(zamestnanci.get(i).getObkladac()==true) obj[i][5]="Áno";
        			else obj[i][5]="Nie";
        			if(zamestnanci.get(i).getBetonar()==true) obj[i][6]="Áno";
        			else obj[i][6]="Nie";
        			if(zamestnanci.get(i).getKlampiar()==true) obj[i][7]="Áno";
        			else obj[i][7]="Nie";
        			if(zamestnanci.get(i).getVodic_bager()==true) obj[i][8]="Áno";
        			else obj[i][8]="Nie";
        			if(zamestnanci.get(i).getVodic_nakladne()==true) obj[i][9]="Áno";
        			else obj[i][9]="Nie";
        			if(zamestnanci.get(i).getArchitekt()==true) obj[i][10]="Áno";
        			else obj[i][10]="Nie";
        			
        		}
        		
        		JPanel panel = new JPanel();
                panel.setLayout(null);
        		// constructor of JTable with a fix number of objects
        		JTable table = new JTable(obj, header);
        		//panel.add(new JScrollPane(table));
        		JScrollPane scroll = 
                		new JScrollPane(table);
                scroll.setBounds(12, 13, 1000, 1000);
                panel.add(scroll);
        		getContentPane().add(panel);*/
        		
        	}
        });
        btnNewButton_5.setBounds(634, 138, 97, 25);
        panel_3.add(btnNewButton_5);
        
        
        JButton btnPridajEtapu = new JButton("Pridaj etapu");
        btnPridajEtapu.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		NewEtapa okno = new NewEtapa();
        	}
        });
        btnPridajEtapu.setBounds(734, 56, 130, 25);
        panel_3.add(btnPridajEtapu);
        lblAktulnaEtapa.setVisible(false);
		lblCena.setVisible(false);
		lblDtumZaatia.setVisible(false);
		lblPracovnci.setVisible(false);
		scrollPane.setVisible(false);
		scrollPane_1.setVisible(false);
		lblUkonenEtapy.setVisible(false);
		label.setVisible(false);
		label_1.setVisible(false);
		label_2.setVisible(false);
		lblUkonenEtapy.setVisible(false);
		lblCelkovCena.setVisible(false);
		comboBox_2.setVisible(false);
		btnNewButton_5.setVisible(false);
		lblNewLabel_2.setVisible(false);
		label_3.setVisible(false);
		label_4.setVisible(false);
		label_5.setVisible(false);
		label_6.setVisible(false);
		label_7.setVisible(false);
		
		
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		lblAktulnaEtapa.setVisible(true);
        		lblCena.setVisible(true);
        		lblDtumZaatia.setVisible(true);
        		lblPracovnci.setVisible(true);
        		scrollPane.setVisible(true);
        		lblUkonenEtapy.setVisible(true);
        		lblUkonenEtapy.setVisible(true);
        		lblCelkovCena.setVisible(true);
        		comboBox_2.setVisible(true);
        		btnNewButton_5.setVisible(true);
        		lblNewLabel_2.setVisible(true);
        		label_3.setVisible(true);
        		label_4.setVisible(true);
        		
        		Object vybraty = comboBox_3.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		EtapaManagment spustacE = new EtapaManagment();
        		
        		
        		
        		try {
					etapyu = spustacE.getAllEtapyEnd(pomocna);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		
        		//label_6.setText(etapy.get(0).getDatum().toString());
        		
        		comboBox_2.removeAllItems();
        			for (int j = 0; j< etapyu.size();j++){ 
        				comboBox_2.addItem("("+(j+1)+") "+etapyu.get(j).getDatum());
        				//System.out.println();
        			}
        		
        		
            	etapy = new LinkedList<>();	
            	try {
					etapy = spustacE.getAktualEtapa(pomocna);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	if(etapy.size()>0){
            	label_3.setText(etapy.get(0).getId().toString()+" - "+etapy.get(0).getDatum().toString());
            	try {
					lblNewLabel_2.setText(spustacE.getCenaEtapy(etapy.get(0).getId().toString()).toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            	List<ZamestnanecEtapy> zamestnanci = new LinkedList<>();
        		try {
        			zamestnanci=spustacE.getZamestnanciEtapy(etapy.get(0).getId().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		String[] header = {"Meno","Priezvisko","Zárobok"};
        		String[][] obj;
        		obj = new String [zamestnanci.size()][];
        		for(int k=0;k<zamestnanci.size();k++){
        			obj[k]= new String[3];
        			obj[k][0]=zamestnanci.get(k).getZamestnanec().getMeno();
        			obj[k][1]=zamestnanci.get(k).getZamestnanec().getPriezvisko();
        			obj[k][2]=zamestnanci.get(k).getCena().toString();
        			
        		}
        		
        		JTable table = new JTable(obj, header);
        		//panel.add(new JScrollPane(table));
        		JScrollPane scrollPanep = new JScrollPane(table);
        		scrollPane = scrollPanep;
                scrollPane.setBounds(40, 273, 370, 301);
                panel_3.add(scrollPane);
          
        		
        		for(int k = 0;k<zamestnanci.size();k++)
        			System.out.println(zamestnanci.get(k).getZamestnanec().getMeno() +" "+zamestnanci.get(k).getZamestnanec().getPriezvisko()+" "+zamestnanci.get(k).getCena()+"\n");
        	}
            	}
        });
        btnOk.setBounds(588, 56, 97, 25);
        panel_3.add(btnOk);
        
        
        
        JButton btnAktualizuj = new JButton("Aktualizuj");
        btnAktualizuj.setBounds(982, 40, 97, 25);
        frmBuildingprocessmanager.getContentPane().add(btnAktualizuj);
        btnAktualizuj.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		vymaz();
        		new Frame();
        	}
        });
        frmBuildingprocessmanager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBuildingprocessmanager.setTitle("BuildingProcessManager");
        //frame.pack();
        frmBuildingprocessmanager.setVisible(true);
      //while(program!=1)
    }
    

    private JPanel getAllTablePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        allTable = new JTable(allTableModel);
        JScrollPane scroll = 
        		new JScrollPane(allTable);
        scroll.setBounds(12, 13, 568, 550);
        panel.add(scroll);
        
        JButton btnNewButton_2 = new JButton("Pridaj zamestnanca");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			InsertFrame InsertFrame = new InsertFrame();
					InsertFrame.setVisible(true);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        btnNewButton_2.setBounds(649, 65, 190, 47);
        panel.add(btnNewButton_2);
        
        JComboBox<String> comboBox = new JComboBox<>();
        JButton btnZmaZamestnanca = new JButton("Zma\u017E zamestnanca");
        btnZmaZamestnanca.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Object vybraty = comboBox.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		try {
					spustacZ.deleteZamestnanec(Integer.parseInt(pomocna));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		frame.dispose();
        		frame=null;
        		try {
					spustac.setVsetciZamestnanci(spustacZ);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		new Frame();
        		System.out.printf("\n\n\n\n Tento som si vybral: %d",Integer.parseInt(pomocna));
        	}
        });
        btnZmaZamestnanca.setBounds(649, 291, 190, 47);
        panel.add(btnZmaZamestnanca);
    	//private JComboBox<Ziak> ziaci = new JComboBox<>(ziaciz);
       // public  Zamestnanec[] DataCombo;
        for(int i=0;i<data.size();i++)
        	comboBox.addItem("("+data.get(i).getId()+") "+data.get(i).getMeno()+" "+data.get(i).getPriezvisko());
        
        
        
        comboBox.setBounds(649, 220, 190, 47);
        panel.add(comboBox);

        allTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = allTable.rowAtPoint(e.getPoint());
                if (r >= 0 && r < allTable.getRowCount()) {
                    allTable.setRowSelectionInterval(r, r);
                } else {
                    allTable.clearSelection();
                }

                int rowindex = allTable.getSelectedRow();
                if (rowindex < 0)
                    return;
                if (e.getComponent() instanceof JTable) {
                    int selectedRow = allTable.getSelectedRow();
                    
                    EditFrame dialog = null;
					try {
						dialog = new EditFrame(data.get(selectedRow).getId(),data.get(selectedRow).getMeno(),data.get(selectedRow).getPriezvisko(),data.get(selectedRow).getZdravotny_stav(),data.get(selectedRow).getTelefon(),data.get(selectedRow).getUlica(),data.get(selectedRow).getHouse_number(),data.get(selectedRow).getMesto(),data.get(selectedRow).getPSC(),data.get(selectedRow).getMaliar(),data.get(selectedRow).getMurar(),data.get(selectedRow).getObkladac(),data.get(selectedRow).getBetonar(),data.get(selectedRow).getKlampiar(),data.get(selectedRow).getVodic_bager(),data.get(selectedRow).getVodic_nakladne(),data.get(selectedRow).getArchitekt(), data.get(selectedRow).getZaciatokPN(),data.get(selectedRow).getKoniecPN());
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
                    
                    dialog.setTitle("Edit " + data.get(selectedRow).getMeno()+" "+data.get(selectedRow).getPriezvisko()+" "+ data.get(selectedRow).getMaliar()+" "+data.get(selectedRow).getMurar());
                    
                    System.out.printf("AHOJKAJ \n\n\n");
                    TableData data = ((AllTableModel) allTable.getModel()).getTableData().get(selectedRow);
                    List<TableData> tempData = new ArrayList<TableData>();
                    tempData.add(data);
                    AllTableModel tempModel = new AllTableModel(tempData);

                    JTable table = new JTable(tempModel);
                    dialog.getContentPane().add(new JScrollPane(table));
                    dialog.setVisible(true);
                    dialog.addWindowListener(new WindowAdapter()
                    {
                    	@Override
                    	public void windowClosing(WindowEvent e)
                    	{
                    		System.out.println("Closed");
                    		//e.getWindow().dispose();
                    	}
                    });
                }
            }
            
            });
        return panel;
    }
}


class AllTableModel extends AbstractTableModel {

    List<TableData> tableData = new ArrayList<TableData>();

    Object[] columnNames = {"Osobné ID zamestnanca","Meno", "Priezvisko", "Post", "Telefón"};

    public AllTableModel(List<TableData> data) {

        tableData = data;
    }

    public List<TableData> getTableData() {
        return tableData;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column].toString();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TableData data = tableData.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return data.getId().toString();
        case 1:
            return data.getMeno();
        case 2:
            return data.getPriezvisko();
        case 3:
            return data.getPost();
        case 4:
            return data.getTelefon();
        case 5:
            return data.getUlica();
        default:
            return null;
        }
    }

}

class TableData {
	
	//"Meno", "Priezvisko", "Post", "Telefón","House_number","Ulica","Mesto","PSC"
	private Integer Id;
    private String meno;
    private String priezvisko;
    private String post;
    private String telefon;
    private String House_number;
    private String Ulica;
    private String Mesto;
    private String PSC;
    private Boolean Maliar=false;
    private Boolean Murar=false;
    private Boolean Obkladac=false;
    private Boolean Betonar=false;
    private Boolean Klampiar=false;
    private Boolean Vodic_bager=false;
    private Boolean Vodic_nakladne=false;
    private Boolean Architekt=false;
    private Boolean Zdravotny_stav;
    private Date ZaciatokPN;
    private Date KoniecPN;

    public String getHouse_number() {
		return House_number;
	}

	public void setHouse_number(String house_number) {
		House_number = house_number;
	}

	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		Ulica = ulica;
	}

	public String getMesto() {
		return Mesto;
	}

	public void setMesto(String mesto) {
		Mesto = mesto;
	}

	public String getPSC() {
		return PSC;
	}

	public void setPSC(String pSC) {
		PSC = pSC;
	}
	
	public String getMeno() {
		return meno;
	}

	public void setMeno(String meno) {
		this.meno = meno;
	}

	public String getPriezvisko() {
		return priezvisko;
	}

	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public Boolean getMaliar() {
		return Maliar;
	}

	public void setMaliar(Boolean maliar) {
		Maliar = maliar;
	}

	public Boolean getMurar() {
		return Murar;
	}

	public void setMurar(Boolean murar) {
		Murar = murar;
	}

	public Boolean getObkladac() {
		return Obkladac;
	}

	public void setObkladac(Boolean obkladac) {
		Obkladac = obkladac;
	}

	public Boolean getBetonar() {
		return Betonar;
	}

	public void setBetonar(Boolean betonar) {
		Betonar = betonar;
	}

	public Boolean getKlampiar() {
		return Klampiar;
	}

	public void setKlampiar(Boolean klampiar) {
		Klampiar = klampiar;
	}

	public Boolean getVodic_bager() {
		return Vodic_bager;
	}

	public void setVodic_bager(Boolean vodic_bager) {
		Vodic_bager = vodic_bager;
	}

	public Boolean getVodic_nakladne() {
		return Vodic_nakladne;
	}

	public void setVodic_nakladne(Boolean vodic_nakladne) {
		Vodic_nakladne = vodic_nakladne;
	}

	public Boolean getArchitekt() {
		return Architekt;
	}

	public void setArchitekt(Boolean architekt) {
		Architekt = architekt;
	}

	public Date getZaciatokPN() {
		return ZaciatokPN;
	}

	public void setZaciatokPN(Date zaciatokPN) {
		ZaciatokPN = zaciatokPN;
		
	}
	
	public Date getKoniecPN() {
		return KoniecPN;
	}

	public void setKoniecPN(Date koniecPN) {
		KoniecPN = koniecPN;
	}

	public Boolean getZdravotny_stav() {
		return Zdravotny_stav;
	}

	public void setZdravotny_stav(Boolean zdravotny_stav) {
		Zdravotny_stav = zdravotny_stav;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public TableData(Integer id, String meno, String priezvisko, Boolean zdravotny_stav, String post, String telefon, String ulica, String cislo, String mesto, String psc, Boolean maliar, Boolean murar, Boolean obkladac, Boolean betonar, Boolean klampiar, Boolean vodic_bager, Boolean vodic_nakladne, Boolean architekt, Date zaciatokPN, Date koniecPN) {
        super();
        this.Id=id;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.post = post;
        this.telefon = telefon;
        this.Ulica=ulica;
        this.House_number=cislo;
        this.Mesto=mesto;
        this.PSC=psc;
        this.Maliar=maliar;
        this.Murar=murar;
        this.Obkladac=obkladac;
        this.Betonar=betonar;
        this.Klampiar=klampiar;
        this.Vodic_bager=vodic_bager;
        this.Vodic_nakladne=vodic_nakladne;
        this.Architekt=architekt;
        this.ZaciatokPN=zaciatokPN;
        this.KoniecPN=koniecPN;
        this.Zdravotny_stav=zdravotny_stav;
        
    }

  
}