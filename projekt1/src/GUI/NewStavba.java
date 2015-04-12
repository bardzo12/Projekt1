package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BuildingProcessManager.Databaze.StavbaManagment;
import BuildingProcessManager.models.Adresa;
import BuildingProcessManager.models.Stavba;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class NewStavba extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the dialog.
	 */
	public NewStavba(Integer id_objednavka) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 626, 395);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(12, 13, 692, 436);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblZadajMenoStavby = new JLabel("Zadaj meno stavby:");
				lblZadajMenoStavby.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblZadajMenoStavby.setBounds(12, 38, 142, 19);
				panel.add(lblZadajMenoStavby);
			}
			{
				JLabel lblZaiatokStavby = new JLabel("Za\u010Diatok stavby:");
				lblZaiatokStavby.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblZaiatokStavby.setBounds(12, 82, 142, 19);
				panel.add(lblZaiatokStavby);
			}
			{
				JLabel lblPredpokladanKoniecStavby = new JLabel("Predpokladan\u00FD koniec stavby:");
				lblPredpokladanKoniecStavby.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblPredpokladanKoniecStavby.setBounds(12, 121, 200, 19);
				panel.add(lblPredpokladanKoniecStavby);
			}
			{
				JLabel lblUlica = new JLabel("Ulica:");
				lblUlica.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblUlica.setBounds(12, 162, 142, 19);
				panel.add(lblUlica);
			}
			{
				JLabel lblMesto = new JLabel("Mesto:");
				lblMesto.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblMesto.setBounds(12, 196, 142, 19);
				panel.add(lblMesto);
			}
			{
				JLabel lblPs = new JLabel("PS\u010C:");
				lblPs.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblPs.setBounds(12, 228, 142, 19);
				panel.add(lblPs);
			}
			
			textField = new JTextField();
			textField.setBounds(232, 37, 316, 22);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(232, 161, 316, 22);
			panel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(232, 195, 316, 22);
			panel.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(232, 227, 316, 22);
			panel.add(textField_3);
			
			JDateChooser dateChooser = new JDateChooser();
			dateChooser.setBounds(232, 79, 316, 22);
			panel.add(dateChooser);
			
			JDateChooser dateChooser_1 = new JDateChooser();
			dateChooser_1.setBounds(232, 121, 316, 22);
			panel.add(dateChooser_1);
			
			JButton btnNewButton = new JButton("Ulo\u017Ei\u0165");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Date DatumStart;
					@SuppressWarnings("unused")
					Date DatumKoniec;
					int good=0;
        			good=0;
					if(textField.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste meno stavby");
					else good++;
					if(dateChooser.getDate()==null) JOptionPane.showMessageDialog(null,"Nezadali ste dátum zaèiatku stavby");
					else good++;
					if(dateChooser_1.getDate()==null) JOptionPane.showMessageDialog(null,"Nezadali ste dátum predpokladaného konca stavby");
					else good++;
					if(textField_1.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste ulicu");
					else good++;
					if(textField_2.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste mesto");
					else good++;
					if(textField_3.getText().trim().length() == 0) JOptionPane.showMessageDialog(null,"Nezadali ste PSÈ");
					else good++;
					if(good==6){
						Stavba stavba = new Stavba();
						stavba.setId_objednavka(id_objednavka);
						DatumStart = dateChooser.getDate();
						stavba.setZaciatok(DatumStart);
						stavba.setPredpokladany_koniec(dateChooser_1.getDate());
						stavba.setNazov(textField.getText());
						stavba.setAdresa(new Adresa(textField_1.getText(),textField_2.getText(),textField_3.getText()));
						stavba.setStav(false);
						StavbaManagment spustacS = new StavbaManagment();
						try {
							spustacS.insertStavba(stavba);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						
					}
				}
			});
			btnNewButton.setBounds(451, 262, 97, 25);
			panel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
