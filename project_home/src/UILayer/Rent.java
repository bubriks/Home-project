package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.DocumentController;
import ControlLayer.InfoController;
import ModelLayer.Tenant;

import java.awt.*;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

class Rent extends JFrame {

	JPanel contentPane;
	JButton nameButton;
	JTextField electricityStartField, electricityEndField, waterStartField, waterEndField;
	private Tenant tenant;

	Rent(int index){
		tenant = InfoController.GetTenant(index);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
					tenant.electricityStart = Double.parseDouble(electricityStartField.getText());
					tenant.electricityEnd = Double.parseDouble(electricityEndField.getText());
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
					tenant.waterStart = Double.parseDouble(waterStartField.getText());
					tenant.waterEnd = Double.parseDouble(waterEndField.getText());
					Report.getInstance().sum.changeElectricity();
				}
				catch(Exception e1){
					waterStartField.setBackground(Color.RED);
					waterEndField.setBackground(Color.RED);
				}
			}
		};

		nameButton = new JButton(tenant.name);
		GridBagConstraints gbc_nameButton = new GridBagConstraints();
		gbc_nameButton.fill = GridBagConstraints.BOTH;
		gbc_nameButton.gridwidth = 3;
		gbc_nameButton.insets = new Insets(0, 0, 5, 5);
		gbc_nameButton.gridx = 0;
		gbc_nameButton.gridy = 0;
		contentPane.add(nameButton, gbc_nameButton);
		nameButton.addActionListener(arg0 -> RentPopUp.getInstance(tenant));

		JLabel lblElectricity = new JLabel("Elektrība");
		GridBagConstraints gbc_lblElectricity = new GridBagConstraints();
		gbc_lblElectricity.gridwidth = 3;
		gbc_lblElectricity.insets = new Insets(0, 0, 5, 0);
		gbc_lblElectricity.gridx = 0;
		gbc_lblElectricity.gridy = 1;
		contentPane.add(lblElectricity, gbc_lblElectricity);
		
		electricityStartField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		contentPane.add(electricityStartField, gbc_textField);
		electricityStartField.setText(Double.toString(tenant.electricityStart));
		electricityStartField.setColumns(10);
        electricityStartField.addKeyListener(electricityAdapter);

		JLabel lblElectricityVS = new JLabel("-");
		GridBagConstraints gbc_lblElectricityVS = new GridBagConstraints();
		gbc_lblElectricityVS.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricityVS.anchor = GridBagConstraints.EAST;
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
		electricityEndField.setText(Double.toString(tenant.electricityEnd));
		electricityEndField.addKeyListener(electricityAdapter);

		JLabel lblWater = new JLabel("Ūdens");
		GridBagConstraints gbc_lblWater = new GridBagConstraints();
		gbc_lblWater.gridwidth = 3;
		gbc_lblWater.insets = new Insets(0, 0, 5, 0);
		gbc_lblWater.gridx = 0;
		gbc_lblWater.gridy = 3;
		contentPane.add(lblWater, gbc_lblWater);
		
		waterStartField = new JTextField();
		GridBagConstraints gbc_waterStartField = new GridBagConstraints();
		gbc_waterStartField.insets = new Insets(0, 0, 5, 5);
		gbc_waterStartField.fill = GridBagConstraints.HORIZONTAL;
		gbc_waterStartField.gridx = 0;
		gbc_waterStartField.gridy = 4;
		contentPane.add(waterStartField, gbc_waterStartField);
		waterStartField.setText(Double.toString(tenant.waterStart));
		waterStartField.setColumns(10);
        waterStartField.addKeyListener(waterAdapter);

		JLabel lblWaterVS = new JLabel("-");
		GridBagConstraints gbc_lblWaterVS = new GridBagConstraints();
		gbc_lblWaterVS.insets = new Insets(0, 0, 5, 5);
		gbc_lblWaterVS.anchor = GridBagConstraints.EAST;
		gbc_lblWaterVS.gridx = 1;
		gbc_lblWaterVS.gridy = 4;
		contentPane.add(lblWaterVS, gbc_lblWaterVS);
		
		waterEndField = new JTextField();
		GridBagConstraints gbc_waterEndField = new GridBagConstraints();
		gbc_waterEndField.insets = new Insets(0, 0, 5, 0);
		gbc_waterEndField.fill = GridBagConstraints.HORIZONTAL;
		gbc_waterEndField.gridx = 2;
		gbc_waterEndField.gridy = 4;
		contentPane.add(waterEndField, gbc_waterEndField);
		waterEndField.setColumns(10);
		waterEndField.setText(Double.toString(tenant.waterEnd));
		waterEndField.addKeyListener(waterAdapter);
	}
}
