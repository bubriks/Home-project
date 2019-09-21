package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.InfoController;

import java.awt.*;
import javax.swing.JLabel;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Prices extends JFrame {

	JPanel contentPane;
	JTextField electricityStartField, waterStartField, electricityEndField, waterEndField;

	Prices(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		KeyAdapter electricityAdapter = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if (Double.parseDouble(electricityStartField.getText()) <= Double.parseDouble(electricityEndField.getText())) {
						electricityStartField.setBackground(Color.white);
						electricityEndField.setBackground(Color.white);
					} else {
						electricityStartField.setBackground(Color.ORANGE);
						electricityEndField.setBackground(Color.ORANGE);
					}
					InfoController.info.prices.electricityStart = Double.parseDouble(electricityStartField.getText());
					InfoController.info.prices.electricityEnd = Double.parseDouble(electricityEndField.getText());
					Report.getInstance().sum.changeElectricity();
				}
				catch(Exception e1){
					electricityStartField.setBackground(Color.RED);
					electricityEndField.setBackground(Color.RED);
				}
			}
		};

		KeyAdapter waterAdapter = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if (Double.parseDouble(waterStartField.getText()) <= Double.parseDouble(waterEndField.getText())) {
						waterStartField.setBackground(Color.white);
						waterEndField.setBackground(Color.white);
					} else {
						waterStartField.setBackground(Color.ORANGE);
						waterEndField.setBackground(Color.ORANGE);
					}
					InfoController.info.prices.waterStart = Double.parseDouble(waterStartField.getText());
					InfoController.info.prices.waterEnd = Double.parseDouble(waterEndField.getText());
					Report.getInstance().sum.changeElectricity();
				}
				catch(Exception e1){
					waterStartField.setBackground(Color.RED);
					waterEndField.setBackground(Color.RED);
				}
			}
		};

		JButton btnPriceChange = new JButton("Cenu Maiņa");
		GridBagConstraints gbc_btnPriceChange = new GridBagConstraints();
		gbc_btnPriceChange.gridwidth = 3;
		gbc_btnPriceChange.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPriceChange.insets = new Insets(0, 0, 5, 5);
		gbc_btnPriceChange.gridx = 0;
		gbc_btnPriceChange.gridy = 0;
		contentPane.add(btnPriceChange, gbc_btnPriceChange);
		btnPriceChange.addActionListener(arg0 -> PricesPopUp.getInstance(InfoController.info.prices));
		
		JLabel lblElectricity = new JLabel("Elektrības patēriņš");
		GridBagConstraints gbc_lblElectricity = new GridBagConstraints();
		gbc_lblElectricity.gridwidth = 3;
		gbc_lblElectricity.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricity.gridx = 0;
		gbc_lblElectricity.gridy = 1;
		contentPane.add(lblElectricity, gbc_lblElectricity);
		
		electricityStartField = new JTextField();
		GridBagConstraints gbc_electricityStartField = new GridBagConstraints();
		gbc_electricityStartField.insets = new Insets(0, 0, 5, 5);
		gbc_electricityStartField.fill = GridBagConstraints.BOTH;
		gbc_electricityStartField.gridx = 0;
		gbc_electricityStartField.gridy = 2;
		contentPane.add(electricityStartField, gbc_electricityStartField);
		electricityStartField.setColumns(10);
		electricityStartField.setText(Double.toString(InfoController.info.prices.electricityStart));
		electricityStartField.addKeyListener(electricityAdapter);

		JLabel lblElectricityVS = new JLabel("-");
		GridBagConstraints gbc_lblElectricityVS = new GridBagConstraints();
		gbc_lblElectricityVS.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricityVS.gridx = 1;
		gbc_lblElectricityVS.gridy = 2;
		contentPane.add(lblElectricityVS, gbc_lblElectricityVS);

		electricityEndField = new JTextField();
		GridBagConstraints gbc_electricityEndField = new GridBagConstraints();
		gbc_electricityEndField.insets = new Insets(0, 0, 5, 0);
		gbc_electricityEndField.fill = GridBagConstraints.HORIZONTAL;
		gbc_electricityEndField.gridx = 2;
		gbc_electricityEndField.gridy = 2;
		contentPane.add(electricityEndField, gbc_electricityEndField);
		electricityEndField.setColumns(10);
		electricityEndField.setText(Double.toString(InfoController.info.prices.electricityEnd));
		electricityEndField.addKeyListener(electricityAdapter);
		
		JLabel lblWater = new JLabel("Ūdens patēriņš");
		GridBagConstraints gbc_lblWater = new GridBagConstraints();
		gbc_lblWater.gridwidth = 3;
		gbc_lblWater.insets = new Insets(0, 0, 5, 5);
		gbc_lblWater.gridx = 0;
		gbc_lblWater.gridy = 3;
		contentPane.add(lblWater, gbc_lblWater);
		
		waterStartField = new JTextField();
		GridBagConstraints gbc_waterStartField = new GridBagConstraints();
		gbc_waterStartField.insets = new Insets(0, 0, 0, 5);
		gbc_waterStartField.fill = GridBagConstraints.BOTH;
		gbc_waterStartField.gridx = 0;
		gbc_waterStartField.gridy = 4;
		contentPane.add(waterStartField, gbc_waterStartField);
		waterStartField.setText(Double.toString(InfoController.info.prices.waterStart));
		waterStartField.setColumns(10);
		waterStartField.addKeyListener(waterAdapter);

		JLabel lblWaterVS = new JLabel("-");
		GridBagConstraints gbc_lblWaterVS = new GridBagConstraints();
		gbc_lblWaterVS.insets = new Insets(0, 0, 0, 5);
		gbc_lblWaterVS.anchor = GridBagConstraints.EAST;
		gbc_lblWaterVS.gridx = 1;
		gbc_lblWaterVS.gridy = 4;
		contentPane.add(lblWaterVS, gbc_lblWaterVS);
		
		waterEndField = new JTextField();
		GridBagConstraints gbc_waterEndField = new GridBagConstraints();
		gbc_waterEndField.fill = GridBagConstraints.HORIZONTAL;
		gbc_waterEndField.gridx = 2;
		gbc_waterEndField.gridy = 4;
		contentPane.add(waterEndField, gbc_waterEndField);
		waterEndField.setColumns(10);
		waterEndField.setText(Double.toString(InfoController.info.prices.waterEnd));
		waterEndField.addKeyListener(waterAdapter);
	}
}
