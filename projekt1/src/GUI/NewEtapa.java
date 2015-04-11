package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextField;

import BuildingProcessManager.Databaze.CenaManagment;
import BuildingProcessManager.Databaze.EtapaManagment;
import BuildingProcessManager.Databaze.StavbaManagment;
import BuildingProcessManager.Databaze.ZamestnanecManagment;
import BuildingProcessManager.models.Cena;
import BuildingProcessManager.models.Etapa;
import BuildingProcessManager.models.Stavba;
import BuildingProcessManager.models.Zamestnanec;

public class NewEtapa extends JDialog {

	Integer etapa_id=-5;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	public NewEtapa() {
		new JDialog();
		setTitle("INSERT ETAPA");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 948, 569);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			JLabel lblVyberteStavbu = new JLabel("Vyberte stavbu:");
			lblVyberteStavbu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblVyberteStavbu.setBounds(35, 50, 193, 35);
			contentPanel.add(lblVyberteStavbu);
		
		StavbaManagment spustacS = new StavbaManagment();
		List<Stavba> stavby = new LinkedList<>();
		try {
			stavby=spustacS.getAllStavby();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JComboBox<String> comboBox = new JComboBox <>();
		comboBox.setBounds(240, 59, 230, 22);
		contentPanel.add(comboBox);
		
		for(int i = 0;i<stavby.size();i++)
			comboBox.addItem("("+stavby.get(i).getId().toString()+")"+" " + stavby.get(i).getNazov());
		JButton btnNewButton = new JButton("Vybra\u0165");
		btnNewButton.setBounds(590, 58, 97, 25);
		contentPanel.add(btnNewButton);
		
		JLabel lblVyberteVedceho = new JLabel("Vyberte ved\u00FAceho:");
		lblVyberteVedceho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVyberteVedceho.setBounds(35, 134, 193, 35);
		contentPanel.add(lblVyberteVedceho);
		lblVyberteVedceho.setVisible(false);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(240, 143, 171, 22);
		contentPanel.add(comboBox_1);
		comboBox_1.setVisible(false);
		
		ZamestnanecManagment spustacM = new ZamestnanecManagment();
		List<Zamestnanec> zamestnancifree = new LinkedList<>();
		try {
			zamestnancifree=spustacM.getAllFree();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for(int i = 0;i<zamestnancifree.size();i++){
			comboBox_1.addItem("("+zamestnancifree.get(i).getId().toString()+")"+" " + zamestnancifree.get(i).getMeno()+" " + zamestnancifree.get(i).getPriezvisko());
		}
		JButton button = new JButton("Vybra\u0165");
		
		button.setBounds(590, 142, 97, 25);
		contentPanel.add(button);
		button.setVisible(false);
		
		JLabel lblVyberteRobotnkov = new JLabel("Vyberte robotn\u00EDkov:");
		lblVyberteRobotnkov.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVyberteRobotnkov.setBounds(35, 212, 193, 35);
		contentPanel.add(lblVyberteRobotnkov);
		lblVyberteRobotnkov.setVisible(false);
		
		JLabel lblVybertePomocnkov = new JLabel("Vyberte pomocn\u00EDkov:");
		lblVybertePomocnkov.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVybertePomocnkov.setBounds(35, 287, 193, 35);
		contentPanel.add(lblVybertePomocnkov);
		lblVybertePomocnkov.setVisible(false);
		
		JComboBox<String> comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(240, 221, 171, 22);
		contentPanel.add(comboBox_2);
		comboBox_2.setVisible(false);
		
		JComboBox<String> comboBox_3 = new JComboBox<>();
		comboBox_3.setBounds(240, 296, 171, 22);
		contentPanel.add(comboBox_3);
		comboBox_3.setVisible(false);
		
		JButton button_1 = new JButton("Vybra\u0165");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ZamestnanecManagment spustacZ = new ZamestnanecManagment();
				Object vybraty = comboBox_2.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		Double hodinovka = Double.parseDouble(textField.getText());
        		Double pocethodin =  Double.parseDouble(textField_1.getText());
        		Integer id_zamestnanec = Integer.parseInt(pomocna);
        		Cena cena = new Cena(hodinovka,pocethodin,etapa_id,id_zamestnanec);
        		CenaManagment spustacC= new CenaManagment();
        		try {
        			spustacC.insertCena(cena);
					spustacZ.updateZamestnanec(pomocna, "2");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List<Zamestnanec> zamestnancifree = new LinkedList<>();
				try {
					zamestnancifree=spustacZ.getAllFree();
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				for(int j = 0;j<zamestnancifree.size();j++){
					comboBox_2.addItem("("+zamestnancifree.get(j).getId().toString()+")"+" " + zamestnancifree.get(j).getMeno()+" " + zamestnancifree.get(j).getPriezvisko());
					comboBox_3.addItem("("+zamestnancifree.get(j).getId().toString()+")"+" " + zamestnancifree.get(j).getMeno()+" " + zamestnancifree.get(j).getPriezvisko());
					
				}
				comboBox_2.setVisible(false);
				comboBox_2.setVisible(true);
				comboBox_3.setVisible(false);
				comboBox_3.setVisible(true);
			}
		});
		button_1.setBounds(590, 222, 97, 25);
		contentPanel.add(button_1);
		button_1.setVisible(false);
		
		JButton button_2 = new JButton("Vybra\u0165");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZamestnanecManagment spustacZ = new ZamestnanecManagment();
				Object vybraty = comboBox_3.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		Double hodinovka = Double.parseDouble(textField.getText());
        		Double pocethodin = Double.parseDouble(textField_1.getText());
        		Integer id_zamestnanec = Integer.parseInt(pomocna);
        		Cena cena = new Cena(hodinovka,pocethodin,etapa_id,id_zamestnanec);
        		CenaManagment spustacC = new CenaManagment();
        		try {
        			spustacC.insertCena(cena);
					spustacZ.updateZamestnanec(pomocna, "3");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		List<Zamestnanec> zamestnancifree = new LinkedList<>();
				try {
					zamestnancifree=spustacZ.getAllFree();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				for(int j = 0;j<zamestnancifree.size();j++){
					comboBox_2.addItem("("+zamestnancifree.get(j).getId().toString()+")"+" " + zamestnancifree.get(j).getMeno()+" " + zamestnancifree.get(j).getPriezvisko());
					comboBox_3.addItem("("+zamestnancifree.get(j).getId().toString()+")"+" " + zamestnancifree.get(j).getMeno()+" " + zamestnancifree.get(j).getPriezvisko());
					
				}
			}
		});
		button_2.setBounds(590, 295, 97, 25);
		contentPanel.add(button_2);
		
		JLabel lblNewLabel = new JLabel("Hodinov\u00E1 MZDA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(443, 367, 164, 16);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(590, 363, 55, 26);
		contentPanel.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblPoetHodn = new JLabel("Po\u010Det hod\u00EDn:");
		lblPoetHodn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPoetHodn.setBounds(443, 403, 164, 16);
		contentPanel.add(lblPoetHodn);
		lblPoetHodn.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(590, 399, 55, 26);
		contentPanel.add(textField_1);
		textField_1.setVisible(false);
		
		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(657, 367, 164, 16);
		contentPanel.add(label);
		label.setVisible(false);
		
		JLabel lblHodn = new JLabel("HOD\u00CDN");
		lblHodn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHodn.setBounds(657, 403, 164, 16);
		contentPanel.add(lblHodn);
		lblHodn.setVisible(false);
		
		button_2.setVisible(false);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setVisible(false);
				comboBox.setVisible(false);
				lblVyberteStavbu.setVisible(false);
				lblVyberteVedceho.setVisible(true);
				comboBox_1.setVisible(true);
				button.setVisible(true);
				button_2.setVisible(false);
				button_1.setVisible(false);
				comboBox_3.setVisible(false);
				comboBox_2.setVisible(false);
				lblVybertePomocnkov.setVisible(false);
				lblVyberteRobotnkov.setVisible(false);
				textField_1.setVisible(true);
				textField.setVisible(true);
				lblPoetHodn.setVisible(true);
				lblNewLabel.setVisible(true);
				label.setVisible(true);
				lblHodn.setVisible(true);
				Etapa etapa = new Etapa();
				etapa.setDatum(new Date());
				Object vybraty = comboBox.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
				etapa.setId_stavba(Integer.parseInt(pomocna));
				System.out.printf("Toto je èíslo stavby : %d", etapa.getId_stavba());
				etapa.setStav(false);
				//etapa.setId_stavba(id_stavba);
				EtapaManagment okno = new EtapaManagment();
				Etapa etapaA = new Etapa();
				List<Etapa> etapyA = new LinkedList<>();
				try {
					okno.insertEtapa(etapa);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					etapyA = okno.getAktualEtapa(pomocna);
					etapaA = etapyA.get(0);
					etapa_id = etapaA.getId();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ZamestnanecManagment spustacZ = new ZamestnanecManagment();
				int ok=0;
				if(textField.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali hodinovú MZDU");
				else ok++;
				if(textField_1.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali poèet hodín");
				else ok++;
				if(ok==2){
					lblVyberteVedceho.setVisible(false);
					comboBox_1.setVisible(false);
					button.setVisible(false);
					lblVyberteRobotnkov.setVisible(true);
					comboBox_2.setVisible(true);
					button_1.setVisible(true);
					lblVybertePomocnkov.setVisible(true);
					comboBox_3.setVisible(true);
					button_2.setVisible(true);
				Object vybraty = comboBox_1.getSelectedItem();
        		String pomocna = vybraty.toString();
        		int i = pomocna.indexOf(')');
        		pomocna=pomocna.substring(1, i);
        		Double hodinovka = Double.parseDouble(textField.getText());
        		Double pocethodin = Double.parseDouble(textField_1.getText());
        		Integer id_zamestnanec = Integer.parseInt(pomocna);
        		Cena cena = new Cena(hodinovka,pocethodin,etapa_id,id_zamestnanec);
        		
        		CenaManagment spustacC = new CenaManagment();
        		try {
        			spustacC.insertCena(cena);
					spustacZ.updateZamestnanec(pomocna,"1");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				spustacZ = new ZamestnanecManagment();
				List<Zamestnanec> zamestnancifree = new LinkedList<>();
				try {
					zamestnancifree=spustacZ.getAllFree();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				for(int i = 0;i<zamestnancifree.size();i++){
					comboBox_2.addItem("("+zamestnancifree.get(i).getId().toString()+")"+" " + zamestnancifree.get(i).getMeno()+" " + zamestnancifree.get(i).getPriezvisko());
					comboBox_3.addItem("("+zamestnancifree.get(i).getId().toString()+")"+" " + zamestnancifree.get(i).getMeno()+" " + zamestnancifree.get(i).getPriezvisko());
					
				}
			}
		});
	}
}
