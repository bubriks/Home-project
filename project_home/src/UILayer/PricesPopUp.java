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

	private JPanel contentPane;
	private static PricesPopUp instance=null;
	private double validEl,validWa,validKa;

	static PricesPopUp getInstance(Prices prices) {
		if (instance == null){
			instance = new PricesPopUp(prices);
		}
	    return instance; 
	 }

	 private PricesPopUp(Prices prices) {
		validEl=prices.getElectricityRate();
		validWa=prices.getWaterRate();
		validKa=prices.getSewerageRate();
		setAlwaysOnTop (true);
		setTitle("Cenu maiņa");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{78, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Cena par vienību");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Elektrība");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JTextField textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setText(""+validEl);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validEl=Double.parseDouble(textField.getText());}
				catch(Exception e1){
						textField.setText(""+validEl);
	    		}
			}
		});
		
		JLabel lbldens = new JLabel("Ūdens");
		GridBagConstraints gbc_lbldens = new GridBagConstraints();
		gbc_lbldens.anchor = GridBagConstraints.EAST;
		gbc_lbldens.insets = new Insets(0, 0, 5, 5);
		gbc_lbldens.gridx = 0;
		gbc_lbldens.gridy = 2;
		contentPane.add(lbldens, gbc_lbldens);
		
		JTextField textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setText(""+validWa);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validWa=Double.parseDouble(textField_1.getText());}
				catch(Exception e1){
					textField_1.setText(""+validWa);
	    		}
			}
		});
		
		JLabel lblKanalizcija = new JLabel("Kanalizācija");
		GridBagConstraints gbc_lblKanalizcija = new GridBagConstraints();
		gbc_lblKanalizcija.anchor = GridBagConstraints.EAST;
		gbc_lblKanalizcija.insets = new Insets(0, 0, 5, 5);
		gbc_lblKanalizcija.gridx = 0;
		gbc_lblKanalizcija.gridy = 3;
		contentPane.add(lblKanalizcija, gbc_lblKanalizcija);
		
		JTextField textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setText(""+validKa);
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validKa=Double.parseDouble(textField_2.getText());}
				catch(Exception e1){
					textField_2.setText(""+validKa);
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
				        
				        inputStr = inputStr.replace("\nCenas- "+prices.getElectricityRate()+","+prices.getWaterRate()+","+prices.getSewerageRate()+","+prices.getElectricity()+","+prices.getWater()+";",
				        		"\nCenas- "+Double.parseDouble(textField.getText())+","+Double.parseDouble(textField_1.getText())+","+Double.parseDouble(textField_2.getText())+","+prices.getElectricity()+","+prices.getWater()+";");
				        
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