package UILayer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelLayer.Tenant;

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
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TenantPopUp extends JFrame {

	private JPanel contentPane;
	private static TenantPopUp instance=null;
	private double validRent,validHaet,validGarbage,validInternet;;

	protected static TenantPopUp getInstance(Tenant tenant) {
		if (instance == null){
			instance = new TenantPopUp(tenant);
		}
	    return instance; 
	 }

	 protected TenantPopUp(Tenant tenant) {
		validRent=tenant.getRent();
		validHaet=tenant.getHeating();
		validGarbage=tenant.getGarbage();
		validInternet=tenant.getInternet();
		setAlwaysOnTop (true);
		setTitle(tenant.getName());
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
		textField.setText(tenant.getName());
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Īre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JTextField textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setText(""+validRent);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validRent=Double.parseDouble(textField_1.getText());}
				catch(Exception e1){
						textField_1.setText(""+validRent);
	    		}
			}
		});

		JLabel lblHeating = new JLabel("Apkure");
		GridBagConstraints gbc_lblHeating = new GridBagConstraints();
		gbc_lblHeating.anchor = GridBagConstraints.EAST;
		gbc_lblHeating.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeating.gridx = 0;
		gbc_lblHeating.gridy = 2;
		contentPane.add(lblHeating, gbc_lblHeating);
		

		JTextField textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setText(""+validHaet);
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validHaet=Double.parseDouble(textField_2.getText());}
				catch(Exception e1){
						textField_2.setText(""+validHaet);
	    		}
			}
		});

		JLabel lblNewLabel_1 = new JLabel("Miskaste");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JTextField textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setText(""+validGarbage);
		textField_3.setColumns(10);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validGarbage=Double.parseDouble(textField_3.getText());}
				catch(Exception e1){
						textField_3.setText(""+validGarbage);
	    		}
			}
		});

		JLabel lblNewLabel_2 = new JLabel("Internets");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JTextField textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setText(""+validInternet);
		textField_4.setColumns(10);
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validInternet=Double.parseDouble(textField_4.getText());}
				catch(Exception e1){
						textField_4.setText(""+validInternet);
	    		}
			}
		});

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
			        
			        inputStr = inputStr.replace("\n"+tenant.getName()+"- "+tenant.getElectricity()+","+tenant.getWater()+","+tenant.getRent()+","+tenant.getHeating()+","+tenant.getGarbage()+","+tenant.getInternet()+";",
			        		"\n"+textField.getText()+"- "+tenant.getElectricity()+","+tenant.getWater()+","+Double.parseDouble(textField_1.getText())+","+Double.parseDouble(textField_2.getText())+","+Double.parseDouble(textField_3.getText())+","+Double.parseDouble(textField_4.getText())+";"); 
			        
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