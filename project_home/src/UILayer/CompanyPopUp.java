package UILayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.InfoController;
import ModelLayer.BusinessPerson;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

class CompanyPopUp extends JFrame {

	private JTextField bankField, BankCodeField;
	private static CompanyPopUp instance=null;

	static CompanyPopUp getInstance(boolean sender) {
		if (instance == null){
			instance = new CompanyPopUp(sender);
		}
	    return instance; 
	 }

	private CompanyPopUp(boolean sender) {
		BusinessPerson person;
		if(sender){
			setTitle("Sūtītājs");
			person = InfoController.info.sender;
		}
		else{
			setTitle("Saņēmējs");
			person = InfoController.info.receiver;
		}

		setAlwaysOnTop (true);
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
		nameField.setText(person.name);
		nameField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Adrese");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 1;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		JTextField addressField = new JTextField();
		GridBagConstraints gbc_addressField = new GridBagConstraints();
		gbc_addressField.insets = new Insets(0, 0, 5, 0);
		gbc_addressField.fill = GridBagConstraints.HORIZONTAL;
		gbc_addressField.gridx = 1;
		gbc_addressField.gridy = 1;
		contentPane.add(addressField, gbc_addressField);
		addressField.setText(person.address);
		addressField.setColumns(10);

		if(sender) {
            JLabel lblBank = new JLabel("Banka");
            GridBagConstraints gbc_lblBank = new GridBagConstraints();
            gbc_lblBank.anchor = GridBagConstraints.EAST;
            gbc_lblBank.insets = new Insets(0, 0, 5, 5);
            gbc_lblBank.gridx = 0;
            gbc_lblBank.gridy = 2;
            contentPane.add(lblBank, gbc_lblBank);

            bankField = new JTextField();
            GridBagConstraints gbc_bankField = new GridBagConstraints();
            gbc_bankField.insets = new Insets(0, 0, 5, 0);
            gbc_bankField.fill = GridBagConstraints.HORIZONTAL;
            gbc_bankField.gridx = 1;
            gbc_bankField.gridy = 2;
            contentPane.add(bankField, gbc_bankField);
            bankField.setText(InfoController.info.sender.bankName);
            bankField.setColumns(10);

            JLabel lblBankCode = new JLabel("Bankas kods");
            GridBagConstraints gbc_lblBankCode = new GridBagConstraints();
            gbc_lblBankCode.anchor = GridBagConstraints.EAST;
            gbc_lblBankCode.insets = new Insets(0, 0, 5, 5);
            gbc_lblBankCode.gridx = 0;
            gbc_lblBankCode.gridy = 3;
            contentPane.add(lblBankCode, gbc_lblBankCode);

            BankCodeField = new JTextField();
            GridBagConstraints gbc_BankCodeField = new GridBagConstraints();
            gbc_BankCodeField.insets = new Insets(0, 0, 5, 0);
            gbc_BankCodeField.fill = GridBagConstraints.HORIZONTAL;
            gbc_BankCodeField.gridx = 1;
            gbc_BankCodeField.gridy = 3;
            contentPane.add(BankCodeField, gbc_BankCodeField);
            BankCodeField.setText(InfoController.info.sender.code);
            BankCodeField.setColumns(10);
        }

		JLabel lblInvoice = new JLabel("Rekvizīti");
		GridBagConstraints gbc_lblInvoice = new GridBagConstraints();
		gbc_lblInvoice.anchor = GridBagConstraints.EAST;
		gbc_lblInvoice.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvoice.gridx = 0;
		gbc_lblInvoice.gridy = 4;
		contentPane.add(lblInvoice, gbc_lblInvoice);
		
		JTextField InvoiceField = new JTextField();
		GridBagConstraints gbc_InvoiceField = new GridBagConstraints();
		gbc_InvoiceField.insets = new Insets(0, 0, 5, 0);
		gbc_InvoiceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_InvoiceField.gridx = 1;
		gbc_InvoiceField.gridy = 4;
		contentPane.add(InvoiceField, gbc_InvoiceField);
		InvoiceField.setText(person.invoice);
		InvoiceField.setColumns(10);
		
		JLabel lblBankInfo = new JLabel("Bankas info");
		GridBagConstraints gbc_lblBankInfo = new GridBagConstraints();
		gbc_lblBankInfo.anchor = GridBagConstraints.EAST;
		gbc_lblBankInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBankInfo.gridx = 0;
		gbc_lblBankInfo.gridy = 5;
		contentPane.add(lblBankInfo, gbc_lblBankInfo);
		
		JTextField BankInfoField = new JTextField();
		GridBagConstraints gbc_BankInfoField = new GridBagConstraints();
		gbc_BankInfoField.insets = new Insets(0, 0, 5, 0);
		gbc_BankInfoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_BankInfoField.gridx = 1;
		gbc_BankInfoField.gridy = 5;
		contentPane.add(BankInfoField, gbc_BankInfoField);
		BankInfoField.setText(person.info);
		BankInfoField.setColumns(10);
		
		JButton btnSave = new JButton("Saglabāt");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 8;
		contentPane.add(btnSave, gbc_btnSave);
		btnSave.addActionListener(arg0 -> {
			person.name = nameField.getText();
			person.address = addressField.getText();
			person.invoice = InvoiceField.getText();
			person.info = BankInfoField.getText();
			if(sender){
				InfoController.info.sender.bankName = bankField.getText();
				InfoController.info.sender.code = BankCodeField.getText();
			}

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
