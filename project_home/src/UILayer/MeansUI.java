package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.InfoController;
import ControlLayer.Means;
import ControlLayer.Design;
import ModelLayer.Owner;
import ModelLayer.Receiver;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JButton;

class MeansUI extends JFrame {

	JPanel contentPane;
	JTextField electricityBeginningField, ElectricityEndField;

	MeansUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JButton btnReceiver = new JButton("Saņēmējs");
		GridBagConstraints gbc_btnReceiver = new GridBagConstraints();
		gbc_btnReceiver.gridwidth = 3;
		gbc_btnReceiver.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReceiver.insets = new Insets(0, 0, 5, 5);
		gbc_btnReceiver.gridx = 0;
		gbc_btnReceiver.gridy = 0;
		contentPane.add(btnReceiver, gbc_btnReceiver);
		btnReceiver.addActionListener(arg0 -> MeansPopUp.getInstance(null));

		JButton btnSender = new JButton("Sūtītājs");
		GridBagConstraints gbc_btnSender = new GridBagConstraints();
		gbc_btnSender.gridwidth = 3;
		gbc_btnSender.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSender.insets = new Insets(0, 0, 5, 5);
		gbc_btnSender.gridx = 0;
		gbc_btnSender.gridy = 1;
		contentPane.add(btnSender, gbc_btnSender);
		btnSender.addActionListener(arg0 -> MeansPopUp.getInstance(true));
		
		JLabel lblElectricityBeginning = new JLabel("Elektrība");
		GridBagConstraints gbc_lblElectricityBeginning = new GridBagConstraints();
		gbc_lblElectricityBeginning.gridwidth = 3;
		gbc_lblElectricityBeginning.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricityBeginning.gridx = 0;
		gbc_lblElectricityBeginning.gridy = 2;
		contentPane.add(lblElectricityBeginning, gbc_lblElectricityBeginning);

		electricityBeginningField = new JTextField();
		GridBagConstraints gbc_electricityBeginningField = new GridBagConstraints();
		gbc_electricityBeginningField.insets = new Insets(0, 0, 5, 5);
		gbc_electricityBeginningField.fill = GridBagConstraints.HORIZONTAL;
		gbc_electricityBeginningField.gridx = 0;
		gbc_electricityBeginningField.gridy = 3;
		contentPane.add(electricityBeginningField, gbc_electricityBeginningField);
		electricityBeginningField.setText(""+InfoController.info.prices.getElectricity());
		electricityBeginningField.setColumns(10);
		electricityBeginningField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Report.getInstance().hangar.changeElectricity();
			}
		});
		
		JLabel lblElectricityEnd = new JLabel("-");
		GridBagConstraints gbc_lblElectricityEnd = new GridBagConstraints();
		gbc_lblElectricityEnd.insets = new Insets(0, 0, 5, 5);
		gbc_lblElectricityEnd.gridx = 1;
		gbc_lblElectricityEnd.gridy = 3;
		contentPane.add(lblElectricityEnd, gbc_lblElectricityEnd);

		ElectricityEndField = new JTextField();
		GridBagConstraints gbc_ElectricityEndField = new GridBagConstraints();
		gbc_ElectricityEndField.insets = new Insets(0, 0, 5, 0);
		gbc_ElectricityEndField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ElectricityEndField.gridx = 2;
		gbc_ElectricityEndField.gridy = 3;
		contentPane.add(ElectricityEndField, gbc_ElectricityEndField);
		ElectricityEndField.setColumns(10);
		ElectricityEndField.setText("0.0");
		ElectricityEndField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Report.getInstance().hangar.changeElectricity();
			}
		});
	}
	
	boolean writeWord(Design design){
		//todo fix write word
    	/*if(Double.parseDouble(electricityBeginningField.getText())<=Double.parseDouble(ElectricityEndField.getText())){
    		try{
    			new Means(Double.parseDouble(electricityBeginningField.getText()),Double.parseDouble(ElectricityEndField.getText()),Report.getInstance().workbook,Report.getInstance().fd,Report.getInstance().date,Report.getInstance().dateString,design,InfoController.info.prices, null, null);}
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
