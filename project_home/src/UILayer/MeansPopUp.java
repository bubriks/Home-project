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

	static MeansPopUp getInstance(Owner owner) {
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

	 private MeansPopUp(Owner owner) {
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
		textField.setText(owner.getName());
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
		textField_1.setText(owner.getAddress());
		textField_1.setColumns(10);
		
		JLabel lblBank = new JLabel("Banka");
		GridBagConstraints gbc_lblBank = new GridBagConstraints();
		gbc_lblBank.anchor = GridBagConstraints.EAST;
		gbc_lblBank.insets = new Insets(0, 0, 5, 5);
		gbc_lblBank.gridx = 0;
		gbc_lblBank.gridy = 2;
		contentPane.add(lblBank, gbc_lblBank);
		
		JTextField textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setText(owner.getBankName());
		textField_2.setColumns(10);
		
		JLabel lblCod = new JLabel("Bankas kods");
		GridBagConstraints gbc_lblCod = new GridBagConstraints();
		gbc_lblCod.anchor = GridBagConstraints.EAST;
		gbc_lblCod.insets = new Insets(0, 0, 5, 5);
		gbc_lblCod.gridx = 0;
		gbc_lblCod.gridy = 3;
		contentPane.add(lblCod, gbc_lblCod);
		
		JTextField textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setText(owner.getCode());
		textField_3.setColumns(10);
		
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
		textField_4.setText(owner.GetInvoice());
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
		textField_5.setText(owner.getInfo());
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
			        
			        inputStr = inputStr.replace("\nOwner- "+owner.getName()+","+owner.getAddress()+" ,"+owner.getBankName()+","+owner.getCode()+","+owner.GetInvoice()+","+owner.getInfo()+";",
			        		"\nOwner- "+textField.getText()+","+textField_1.getText()+" ,"+textField_2.getText()+","+textField_3.getText()+","+textField_4.getText()+","+textField_5.getText()+";");
			        
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
	 
	 private MeansPopUp(Receiver receiver) {
			setAlwaysOnTop (true);
			setTitle("Maksātājs");
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
