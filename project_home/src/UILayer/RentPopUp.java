package UILayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelLayer.Tenant;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

class RentPopUp extends JFrame {

	private static RentPopUp instance=null;

	static RentPopUp getInstance(Tenant tenant) {
		if (instance == null){
			instance = new RentPopUp(tenant);
		}
	    return instance; 
	 }

	private RentPopUp(Tenant tenant) {
		setAlwaysOnTop (true);
		setTitle(tenant.name);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblName = new JLabel("Vārds");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		contentPane.add(lblName, gbc_lblName);

		JTextField nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		contentPane.add(nameField, gbc_nameField);
		nameField.setText(tenant.name);
		nameField.setColumns(10);

		JLabel lblRent = new JLabel("Īre");
		GridBagConstraints gbc_lblRent = new GridBagConstraints();
		gbc_lblRent.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblRent.insets = new Insets(0, 0, 5, 5);
		gbc_lblRent.gridx = 0;
		gbc_lblRent.gridy = 1;
		contentPane.add(lblRent, gbc_lblRent);

		JTextField rentField = new JTextField();
		GridBagConstraints gbc_rentField = new GridBagConstraints();
		gbc_rentField.insets = new Insets(0, 0, 5, 0);
		gbc_rentField.fill = GridBagConstraints.HORIZONTAL;
		gbc_rentField.gridx = 1;
		gbc_rentField.gridy = 1;
		contentPane.add(rentField, gbc_rentField);
		rentField.setText(Double.toString(tenant.rent));
		rentField.setColumns(10);

		JLabel lblHeating = new JLabel("Apkure");
		GridBagConstraints gbc_lblHeating = new GridBagConstraints();
		gbc_lblHeating.anchor = GridBagConstraints.EAST;
		gbc_lblHeating.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeating.gridx = 0;
		gbc_lblHeating.gridy = 2;
		contentPane.add(lblHeating, gbc_lblHeating);

		JTextField heatingField = new JTextField();
		GridBagConstraints gbc_heatingField = new GridBagConstraints();
		gbc_heatingField.insets = new Insets(0, 0, 5, 0);
		gbc_heatingField.fill = GridBagConstraints.HORIZONTAL;
		gbc_heatingField.gridx = 1;
		gbc_heatingField.gridy = 2;
		contentPane.add(heatingField, gbc_heatingField);
		heatingField.setText(Double.toString(tenant.heating));
		heatingField.setColumns(10);

		JLabel lblGarbage = new JLabel("Miskaste");
		GridBagConstraints gbc_lblGarbage = new GridBagConstraints();
		gbc_lblGarbage.anchor = GridBagConstraints.EAST;
		gbc_lblGarbage.insets = new Insets(0, 0, 5, 5);
		gbc_lblGarbage.gridx = 0;
		gbc_lblGarbage.gridy = 3;
		contentPane.add(lblGarbage, gbc_lblGarbage);

		JTextField garbageField = new JTextField();
		GridBagConstraints gbc_garbageField = new GridBagConstraints();
		gbc_garbageField.insets = new Insets(0, 0, 5, 0);
		gbc_garbageField.fill = GridBagConstraints.HORIZONTAL;
		gbc_garbageField.gridx = 1;
		gbc_garbageField.gridy = 3;
		contentPane.add(garbageField, gbc_garbageField);
		garbageField.setText(Double.toString(tenant.garbage));
		garbageField.setColumns(10);

		JLabel lblInternet = new JLabel("Internets");
		GridBagConstraints gbc_lblInternet = new GridBagConstraints();
		gbc_lblInternet.anchor = GridBagConstraints.EAST;
		gbc_lblInternet.insets = new Insets(0, 0, 5, 5);
		gbc_lblInternet.gridx = 0;
		gbc_lblInternet.gridy = 4;
		contentPane.add(lblInternet, gbc_lblInternet);

		JTextField internetField = new JTextField();
		GridBagConstraints gbc_internetField = new GridBagConstraints();
		gbc_internetField.insets = new Insets(0, 0, 5, 0);
		gbc_internetField.fill = GridBagConstraints.HORIZONTAL;
		gbc_internetField.gridx = 1;
		gbc_internetField.gridy = 4;
		contentPane.add(internetField, gbc_internetField);
		internetField.setText(Double.toString(tenant.internet));
		internetField.setColumns(10);

		JButton btnSave = new JButton("Saglabāt");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 8;
		contentPane.add(btnSave, gbc_btnSave);
		btnSave.addActionListener(arg0 -> {
			tenant.name = nameField.getText();
			tenant.rent = Double.parseDouble(rentField.getText());
			tenant.heating = Double.parseDouble(heatingField.getText());
			tenant.garbage = Double.parseDouble(garbageField.getText());
			tenant.internet = Double.parseDouble(internetField.getText());

			Report.getInstance().Refresh();
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