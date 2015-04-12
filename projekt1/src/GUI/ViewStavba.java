package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;

import BuildingProcessManager.models.Objednavatel;
import BuildingProcessManager.models.Objednavka;
import BuildingProcessManager.models.Stavba;
import BuildingProcessManager.models.Zamestnanec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStavba extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ViewStavba(Stavba stavba, Objednavatel objednavatel, Objednavka objednavka, Double cena, Double cenavsetko, Zamestnanec veduci, List<Zamestnanec> zamestnanci) {
		new JFrame(stavba.getNazov());
		setTitle(stavba.getNazov());
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1290, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNzovStavby = new JLabel("N\u00E1zov stavby:");
		lblNzovStavby.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNzovStavby.setBounds(30, 47, 181, 50);
		contentPane.add(lblNzovStavby);
		
		JLabel lblNewLabel = new JLabel(stavba.getNazov());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(223, 53, 688, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblZaiatokStavby = new JLabel("Za\u010Diatok stavby:");
		lblZaiatokStavby.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblZaiatokStavby.setBounds(30, 126, 194, 50);
		contentPane.add(lblZaiatokStavby);
		
		SimpleDateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
		JLabel lblNewLabel_1 = new JLabel(datum.format(stavba.getZaciatok()).toString());
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(414, 133, 165, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblKoniecStavby = new JLabel("Koniec stavby:");
		lblKoniecStavby.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblKoniecStavby.setBounds(30, 189, 194, 50);
		contentPane.add(lblKoniecStavby);
		
		JLabel lblSd = new JLabel("");
		if(stavba.getKoniec()!=null) lblSd.setText(datum.format(stavba.getKoniec()).toString());
		lblSd.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSd.setBounds(414, 196, 165, 37);
		contentPane.add(lblSd);
		
		JLabel lblPredpokladanKoniecStavby = new JLabel("Predpokladan\u00FD koniec stavby:");
		lblPredpokladanKoniecStavby.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblPredpokladanKoniecStavby.setBounds(30, 252, 372, 50);
		contentPane.add(lblPredpokladanKoniecStavby);
		
		
		JLabel lblSa = new JLabel(datum.format(stavba.getPredpokladany_koniec()).toString());
		lblSa.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSa.setBounds(414, 259, 165, 37);
		contentPane.add(lblSa);
		
		JLabel lblVedciStavby = new JLabel("Ved\u00FAci stavby:");
		lblVedciStavby.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblVedciStavby.setBounds(30, 315, 372, 50);
		contentPane.add(lblVedciStavby);
		
		JLabel label = new JLabel();
		if(veduci!=null) label.setText(veduci.getMeno() + " " + veduci.getPriezvisko());
		label.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label.setBounds(414, 322, 245, 37);
		contentPane.add(label);
		
		JLabel lblUlica = new JLabel("Ulica:");
		lblUlica.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblUlica.setBounds(30, 378, 372, 50);
		contentPane.add(lblUlica);
		
		JLabel lblMesto = new JLabel("Mesto:");
		lblMesto.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblMesto.setBounds(30, 434, 372, 50);
		contentPane.add(lblMesto);
		
		JLabel lblPs = new JLabel("PS\u010C:");
		lblPs.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblPs.setBounds(30, 491, 372, 50);
		contentPane.add(lblPs);
		
		JLabel label_1 = new JLabel(stavba.getAdresa().getUlica());
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_1.setBounds(414, 385, 165, 37);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(stavba.getAdresa().getMesto());
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_2.setBounds(414, 441, 165, 37);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(stavba.getAdresa().getPSC());
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_3.setBounds(414, 498, 165, 37);
		contentPane.add(label_3);
	
		JLabel lblObjednvate = new JLabel("Objedn\u00E1vate\u013E:");
		lblObjednvate.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblObjednvate.setBounds(671, 126, 194, 50);
		contentPane.add(lblObjednvate);
		
		JLabel lblIo = new JLabel("I\u010CO:");
		lblIo.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblIo.setBounds(671, 189, 67, 50);
		contentPane.add(lblIo);
		
		JLabel lblDi = new JLabel("DI\u010C:");
		lblDi.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblDi.setBounds(912, 189, 67, 50);
		contentPane.add(lblDi);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblEmail.setBounds(671, 252, 194, 50);
		contentPane.add(lblEmail);
		
		JLabel lblUlica_1 = new JLabel("Ulica:");
		lblUlica_1.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblUlica_1.setBounds(671, 315, 194, 50);
		contentPane.add(lblUlica_1);
		
		JLabel lblslo = new JLabel("\u010C\u00EDslo:");
		lblslo.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblslo.setBounds(671, 378, 194, 50);
		contentPane.add(lblslo);
		
		JLabel lblMesto_1 = new JLabel("Mesto:");
		lblMesto_1.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblMesto_1.setBounds(671, 434, 194, 50);
		contentPane.add(lblMesto_1);
		
		JLabel lblPs_1 = new JLabel("PS\u010C:");
		lblPs_1.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblPs_1.setBounds(671, 491, 194, 50);
		contentPane.add(lblPs_1);
		
		JLabel lblSa_1 = new JLabel(objednavatel.getMeno());
		lblSa_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSa_1.setBounds(866, 126, 165, 37);
		contentPane.add(lblSa_1);
		
		JLabel label_4 = new JLabel("");
		if(objednavatel.getICO()!=null) label_4.setText(objednavatel.getICO());
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_4.setBounds(737, 196, 165, 37);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		if(objednavatel.getDIC()!=null) label_5.setText(objednavatel.getDIC());
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_5.setBounds(981, 196, 165, 37);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel(objednavatel.getE_mail());
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_6.setBounds(866, 259, 383, 37);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(objednavatel.getAdresa().getUlica());
		label_7.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_7.setBounds(866, 322, 383, 37);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel(objednavatel.getAdresa().getNumber().toString());
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_8.setBounds(866, 385, 383, 37);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel(objednavatel.getAdresa().getMesto());
		label_9.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_9.setBounds(866, 441, 383, 37);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel(objednavatel.getAdresa().getPSC());
		label_10.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_10.setBounds(866, 498, 383, 37);
		contentPane.add(label_10);
		
		JLabel lblObjednan = new JLabel("Objednan\u00E9:");
		lblObjednan.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblObjednan.setBounds(30, 594, 143, 50);
		contentPane.add(lblObjednan);
		
		JLabel lblDs = new JLabel(datum.format(objednavka.getDatumZadania()).toString());
		lblDs.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDs.setBounds(223, 601, 165, 37);
		contentPane.add(lblDs);
		
		JButton btnNewButton = new JButton("Pozrie\u0165 pracovn\u00EDkov stavby");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TableZamestnanciStavby pracujuci = new TableZamestnanciStavby(stavba.getNazov(),zamestnanci);
			}
		});
		btnNewButton.setBounds(939, 598, 242, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblDoposiaCenaPrce = new JLabel("Doposia\u013E cena pr\u00E1ce:");
		lblDoposiaCenaPrce.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblDoposiaCenaPrce.setBounds(363, 594, 259, 50);
		contentPane.add(lblDoposiaCenaPrce);
		
		NumberFormat formatter = new DecimalFormat("#0.00"); 
		JLabel lblSss = new JLabel(formatter.format(cena).toString() + " €");
		lblSss.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSss.setBounds(746, 601, 165, 37);
		contentPane.add(lblSss);
		
		JLabel lblCenaAjBez = new JLabel("Cena aj bez dokon\u010Den\u00FDch et\u00E1p:");
		lblCenaAjBez.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblCenaAjBez.setBounds(363, 644, 372, 50);
		contentPane.add(lblCenaAjBez);
		
		JLabel label_11 = new JLabel(formatter.format(cenavsetko).toString() + " €");
		label_11.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		label_11.setBounds(746, 651, 165, 37);
		contentPane.add(label_11);
	}
}
