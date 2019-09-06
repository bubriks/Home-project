package UILayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelLayer.Owner;
import ModelLayer.Receiver;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.JTextField;
import javax.swing.JButton;

class MeansPopUp extends JFrame {

	private JPanel contentPane;
	private static MeansPopUp instance=null;

	static MeansPopUp getInstance(boolean owner) {
		if (instance == null){
			instance = new MeansPopUp(owner);
		}
	    return instance; 
	 }

	static MeansPopUp getInstance(Receiver receiver) {
		if (instance == null){
			instance = new MeansPopUp(receiver);
		}
	    return instance;
	}

	private MeansPopUp(boolean owner) {
		setAlwaysOnTop (true);
		setTitle("Sūtītājs");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
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
		nameField.setText("owner.getName()");
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
		addressField.setText("owner.getAddress()");
		addressField.setColumns(10);

		if(owner) {
            JLabel lblBank = new JLabel("Banka");
            GridBagConstraints gbc_lblBank = new GridBagConstraints();
            gbc_lblBank.anchor = GridBagConstraints.EAST;
            gbc_lblBank.insets = new Insets(0, 0, 5, 5);
            gbc_lblBank.gridx = 0;
            gbc_lblBank.gridy = 2;
            contentPane.add(lblBank, gbc_lblBank);

            JTextField bankField = new JTextField();
            GridBagConstraints gbc_bankField = new GridBagConstraints();
            gbc_bankField.insets = new Insets(0, 0, 5, 0);
            gbc_bankField.fill = GridBagConstraints.HORIZONTAL;
            gbc_bankField.gridx = 1;
            gbc_bankField.gridy = 2;
            contentPane.add(bankField, gbc_bankField);
            bankField.setText("owner.getBankName()");
            bankField.setColumns(10);

            JLabel lblBankCode = new JLabel("Bankas kods");
            GridBagConstraints gbc_lblBankCode = new GridBagConstraints();
            gbc_lblBankCode.anchor = GridBagConstraints.EAST;
            gbc_lblBankCode.insets = new Insets(0, 0, 5, 5);
            gbc_lblBankCode.gridx = 0;
            gbc_lblBankCode.gridy = 3;
            contentPane.add(lblBankCode, gbc_lblBankCode);

            JTextField BankCodeField = new JTextField();
            GridBagConstraints gbc_BankCodeField = new GridBagConstraints();
            gbc_BankCodeField.insets = new Insets(0, 0, 5, 0);
            gbc_BankCodeField.fill = GridBagConstraints.HORIZONTAL;
            gbc_BankCodeField.gridx = 1;
            gbc_BankCodeField.gridy = 3;
            contentPane.add(BankCodeField, gbc_BankCodeField);
            BankCodeField.setText("owner.getCode()");
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
		InvoiceField.setText("owner.GetInvoice()");
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
		BankInfoField.setText("owner.getInfo()");
		BankInfoField.setColumns(10);
		
		JButton btnSave = new JButton("Saglabāt");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 8;
		contentPane.add(btnSave, gbc_btnSave);
		btnSave.addActionListener(arg0 -> {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("info.txt"), StandardCharsets.UTF_8));
				String line;
				StringBuffer inputBuffer = new StringBuffer();
				while ((line = in.readLine()) != null) {
					inputBuffer.append(line);
					inputBuffer.append('\n');
				}

				String inputStr = inputBuffer.toString();
				in.close();

				//inputStr = inputStr.replace("\nOwner- "+owner.getName()+","+owner.getAddress()+" ,"+owner.getBankName()+","+owner.getCode()+","+owner.GetInvoice()+","+owner.getInfo()+";",
				//		"\nOwner- "+nameField.getText()+","+addressField.getText()+" ,"+bankField.getText()+","+BankCodeField.getText()+","+InvoiceField.getText()+","+BankInfoField.getText()+";");

				try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("info.txt"), StandardCharsets.UTF_8)){
					writer.write(inputStr);
				}
			} catch (Exception e) {
				System.out.println("Problem reading file.");
			}
			Report.getInstance().restart();
			dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
		});
		setVisible(true);
		
		addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(WindowEvent winEvt) {
	            instance=null;
	        }
	    });
	}
	 
	 private MeansPopUp(Receiver receiver) {
			setAlwaysOnTop (true);
			setTitle("Saņēmējs");
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
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
			
			JTextField textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPane.add(textField, gbc_textField);
			textField.setText(receiver.getName());
			textField.setColumns(10);
			
			JLabel lblAddress = new JLabel("Adrese");
			GridBagConstraints gbc_lblAddress = new GridBagConstraints();
			gbc_lblAddress.anchor = GridBagConstraints.EAST;
			gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddress.gridx = 0;
			gbc_lblAddress.gridy = 1;
			contentPane.add(lblAddress, gbc_lblAddress);
			
			JTextField textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			contentPane.add(textField_1, gbc_textField_1);
			textField_1.setText(receiver.getAddress());
			textField_1.setColumns(10);
			
			JLabel lblRekviz = new JLabel("Rekvizīti");
			GridBagConstraints gbc_lblRekviz = new GridBagConstraints();
			gbc_lblRekviz.anchor = GridBagConstraints.EAST;
			gbc_lblRekviz.insets = new Insets(0, 0, 5, 5);
			gbc_lblRekviz.gridx = 0;
			gbc_lblRekviz.gridy = 4;
			contentPane.add(lblRekviz, gbc_lblRekviz);
			
			JTextField textField_4 = new JTextField();
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.insets = new Insets(0, 0, 5, 0);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 1;
			gbc_textField_4.gridy = 4;
			contentPane.add(textField_4, gbc_textField_4);
			textField_4.setText(receiver.getInvoice());
			textField_4.setColumns(10);
			
			JLabel lblInfo = new JLabel("Bankas info");
			GridBagConstraints gbc_lblInfo = new GridBagConstraints();
			gbc_lblInfo.anchor = GridBagConstraints.EAST;
			gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
			gbc_lblInfo.gridx = 0;
			gbc_lblInfo.gridy = 5;
			contentPane.add(lblInfo, gbc_lblInfo);
			
			JTextField textField_5 = new JTextField();
			GridBagConstraints gbc_textField_5 = new GridBagConstraints();
			gbc_textField_5.insets = new Insets(0, 0, 5, 0);
			gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_5.gridx = 1;
			gbc_textField_5.gridy = 5;
			contentPane.add(textField_5, gbc_textField_5);
			textField_5.setText(receiver.getInfo());
			textField_5.setColumns(10);
			
			JButton btnNewButton = new JButton("Saglabāt");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.gridwidth = 2;
			gbc_btnNewButton.gridx = 0;
			gbc_btnNewButton.gridy = 8;
			contentPane.add(btnNewButton, gbc_btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("info.txt"), StandardCharsets.UTF_8));
				        String line;
				        StringBuffer inputBuffer = new StringBuffer();
				        while ((line = in.readLine()) != null) {
				            inputBuffer.append(line);
				            inputBuffer.append('\n');
				        }
				        
				        String inputStr = inputBuffer.toString();
				        in.close();
				        
				        inputStr = inputStr.replace("\nMeans- "+ receiver.getName()+","+ receiver.getAddress()+" ,"+ receiver.getInvoice()+","+ receiver.getInfo()+","+Report.getInstance().electricity+";",
				        		"\nMeans- "+textField.getText()+","+textField_1.getText()+" ,"+textField_4.getText()+","+textField_5.getText()+","+Report.getInstance().electricity+";");
				        				        
				        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("info.txt"), StandardCharsets.UTF_8)){
				        	writer.write(inputStr);
				        }
				    } catch (Exception e) {
				        System.out.println("Problem reading file.");
				    }
					Report.getInstance().restart();
					dispatchEvent(new WindowEvent(instance, WindowEvent.WINDOW_CLOSING));
				}
			});
			setVisible(true);
			
			addWindowListener(new java.awt.event.WindowAdapter() {
		        public void windowClosing(WindowEvent winEvt) {
		            instance=null;
		        }
		    });
		}
}
