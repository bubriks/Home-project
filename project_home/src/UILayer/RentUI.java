package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.InfoController;
import ControlLayer.Design;
import ModelLayer.Tenant;

import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

class RentUI extends JFrame {

	JPanel contentPane;
	JTextField electricityStartField, electricityEndField, waterStartField, waterEndField;
	private Tenant tenant;

	RentUI(int index){
		switch (index){
			case 1:
				tenant= InfoController.info.tenant_1;
				break;
			case 2:
				tenant= InfoController.info.tenant_2;
				break;
			case 3:
				tenant= InfoController.info.tenant_3;
				break;
			case 4:
				tenant= InfoController.info.tenant_4;
				break;
			default:
				break;
		}

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

		JButton nameButton = new JButton(tenant.getName());
		GridBagConstraints gbc_nameButton = new GridBagConstraints();
		gbc_nameButton.fill = GridBagConstraints.BOTH;
		gbc_nameButton.gridwidth = 3;
		gbc_nameButton.insets = new Insets(0, 0, 5, 5);
		gbc_nameButton.gridx = 0;
		gbc_nameButton.gridy = 0;
		contentPane.add(nameButton, gbc_nameButton);
		nameButton.addActionListener(arg0 -> TenantPopUp.getInstance(tenant));

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
		electricityStartField.setText(""+tenant.getElectricity());
		electricityStartField.setColumns(10);
        electricityStartField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
				Report.getInstance().hangar.changeElectricity();
            }
        });

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
		electricityEndField.setText("0.0");
		electricityEndField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Report.getInstance().hangar.changeElectricity();
			}
		});

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
		waterStartField.setText(""+tenant.getWater());
		waterStartField.setColumns(10);
        waterStartField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
				Report.getInstance().hangar.changeWater();
            }
        });

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
		waterEndField.setText("0.0");
		waterEndField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Report.getInstance().hangar.changeWater();
			}
		});
	}
	
	boolean writeWord(Design design){
		//todo fix write word
		/*
		if(Double.parseDouble(elstart.getText())<=Double.parseDouble(elend.getText()) && Double.parseDouble(ustart.getText())<=Double.parseDouble(uend.getText())){
			try{
				new RentControler(Double.parseDouble(elstart.getText()),Double.parseDouble(elend.getText()),Double.parseDouble(ustart.getText()),Double.parseDouble(uend.getText()),Report.getInstance().workbook,tenant,InfoController.info.prices,Report.getInstance().fd,Report.getInstance().date,Report.getInstance().dateString,design);}
    		catch(Exception e){
    			return false;
    		}
    		 return true;
		}
		else{
			return false;
		}

		 */
		return false;
	}
}
