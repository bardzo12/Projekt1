package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import BuildingProcessManager.models.Zamestnanec;

import java.awt.*;
import javax.swing.*;

public class TableZamestnanciStavby extends JFrame {

	// constructor that will display a JTable based on elements received as arguments
	TableZamestnanciStavby(String MenoStavby, List<Zamestnanec> zamestnanci) {
		setBounds(new Rectangle(0, 0, 1200, 600));
		//setResizable(false);
		new Dimension(1200, 600);
		setMinimumSize(new Dimension(1200, 600));
		setTitle("Zamestnanci "+MenoStavby);
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
		getContentPane().add(panel);    // adding panel to frame
		// and display it
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(806,750);
		setVisible(true);
		pack();
	}
}

