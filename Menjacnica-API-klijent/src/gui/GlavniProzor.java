package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import gui.kontroler.GuiKontroler;
import klase.Drzava;
import klase.Menjacnica;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private ArrayList<Drzava> drzave = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public GlavniProzor() throws Exception {
		
		drzave = GuiKontroler.m.ucitajDrzave();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_1_1());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getLblNewLabel_3());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Konvertuj");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int prvi=comboBox.getSelectedIndex();
					int drugi =comboBox_1.getSelectedIndex();
					String drzava1 = drzave.get(prvi).getCurrencyId();
					String drzava2 = drzave.get(drugi).getCurrencyId();
					double iznos = Double.parseDouble(textField.getText());
					
					try {
						//System.out.println(GuiKontroler.m.ucitajValute(drzava1, drzava2)+"");
						double kurs=GuiKontroler.m.ucitajValute(drzava1, drzava2);
						String rezultat=iznos*kurs+"";
						textField_1.setText(rezultat);
						JsonObject j = new JsonObject();
						
						GregorianCalendar d = new GregorianCalendar();
						
						SimpleDateFormat dt = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss"); 
						String datum2 = dt.format(d.getTime());
						j.addProperty("datumVreme", datum2);
						j.addProperty("izValute", drzava1);
						j.addProperty("uValutu", drzava2);
						j.addProperty("kurs", kurs);
						try (FileWriter writer = new FileWriter("data/log.json")) {
							Gson gson = new GsonBuilder().setPrettyPrinting().create();
							gson.toJson(j,writer);
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
				}
			});
			btnNewButton.setBounds(162, 237, 89, 23);
		}
		return btnNewButton;
	}
	private JTextField getTextField_2() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(53, 163, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(304, 163, 86, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Iz valute zemlje\r\n");
			lblNewLabel.setBounds(67, 42, 102, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("U valutu zemlje\r\n");
			lblNewLabel_1.setBounds(304, 42, 86, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Iznos\r\n");
			lblNewLabel_2.setBounds(67, 138, 46, 14);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Iznos\r\n");
			lblNewLabel_3.setBounds(328, 138, 46, 14);
		}
		return lblNewLabel_3;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox(drzave.toArray());
			
			comboBox.setBounds(24, 67, 115, 20);
		}
		return comboBox;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox(drzave.toArray());
			comboBox_1.setBounds(248, 67, 126, 20);
		}
		return comboBox_1;
	}
}
