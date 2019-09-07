package UILayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelLayer.Prices;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.JTextField;
import javax.swing.JButton;

class PricesPopUp extends JFrame {

	private static PricesPopUp instance=null;

	static PricesPopUp getInstance(Prices prices) {
		if (instance == null){
			instance = new PricesPopUp(prices);
		}
	    return instance; 
	 }

	 private PricesPopUp(Prices prices) {
		setAlwaysOnTop(true);
		setTitle("Cenu maiņa");
		setBounds(100, 100, 450, 300);
		 JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{78, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblUnitPrice = new JLabel("Cena par vienību");
		GridBagConstraints gbc_lblUnitPrice = new GridBagConstraints();
		gbc_lblUnitPrice.gridwidth = 2;
		gbc_lblUnitPrice.insets = new Insets(0, 0, 5, 0);
		gbc_lblUnitPrice.gridx = 0;
		gbc_lblUnitPrice.gridy = 0;
		contentPane.add(lblUnitPrice, gbc_lblUnitPrice);
		
		JLabel lblElectricity = new JLabel("Elektrība");
		GridBagConstraints gbc_lblElectricity = new GridBagConstraints();
		gbc_lblElectricity.anchor = GridBagConstraints.EAST;
		gbc_lblElectricity.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricity.gridx = 0;
		gbc_lblElectricity.gridy = 1;
		contentPane.add(lblElectricity, gbc_lblElectricity);
		
		JTextField electricityField = new JTextField();
		GridBagConstraints gbc_electricityField = new GridBagConstraints();
		gbc_electricityField.insets = new Insets(0, 0, 5, 0);
		gbc_electricityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_electricityField.gridx = 1;
		gbc_electricityField.gridy = 1;
		contentPane.add(electricityField, gbc_electricityField);
		electricityField.setText(""+prices.getElectricityRate());
		electricityField.setColumns(10);
		
		JLabel lblWater = new JLabel("Ūdens");
		GridBagConstraints gbc_lblWater = new GridBagConstraints();
		gbc_lblWater.anchor = GridBagConstraints.EAST;
		gbc_lblWater.insets = new Insets(0, 0, 5, 5);
		gbc_lblWater.gridx = 0;
		gbc_lblWater.gridy = 2;
		contentPane.add(lblWater, gbc_lblWater);
		
		JTextField waterField = new JTextField();
		GridBagConstraints gbc_waterField = new GridBagConstraints();
		gbc_waterField.insets = new Insets(0, 0, 5, 0);
		gbc_waterField.fill = GridBagConstraints.HORIZONTAL;
		gbc_waterField.gridx = 1;
		gbc_waterField.gridy = 2;
		contentPane.add(waterField, gbc_waterField);
		waterField.setText(""+prices.getWaterRate());
		waterField.setColumns(10);
		
		JLabel lblSewerage = new JLabel("Kanalizācija");
		GridBagConstraints gbc_lblSewerage = new GridBagConstraints();
		gbc_lblSewerage.anchor = GridBagConstraints.EAST;
		gbc_lblSewerage.insets = new Insets(0, 0, 5, 5);
		gbc_lblSewerage.gridx = 0;
		gbc_lblSewerage.gridy = 3;
		contentPane.add(lblSewerage, gbc_lblSewerage);
		
		JTextField sewerageField = new JTextField();
		GridBagConstraints gbc_sewerageField = new GridBagConstraints();
		gbc_sewerageField.insets = new Insets(0, 0, 5, 0);
		gbc_sewerageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_sewerageField.gridx = 1;
		gbc_sewerageField.gridy = 3;
		contentPane.add(sewerageField, gbc_sewerageField);
		sewerageField.setText(""+prices.getSewerageRate());
		sewerageField.setColumns(10);
		
		JButton saveButton = new JButton("Saglabāt");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.gridwidth = 2;
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 8;
		contentPane.add(saveButton, gbc_saveButton);
		saveButton.addActionListener(arg0 -> {
			 //todo save new price rates so they can be used
			 //Report.getInstance().restart();
			 dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
		});
		setVisible(true);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(WindowEvent winEvt) {
	            instance=null;
	        }
	    });
	}
}