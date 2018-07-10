package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelLayer.Prices;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PricesUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField,textField_1,textField_2,textField_3;
	private JButton btnCenuMaia;
	private JLabel label;
	private JLabel lblNewLabel;
	private double validElStart,validElEnd,validUdStart,validUdEnd;

	public PricesUI(Prices prices){
		validElStart=prices.getElLast();
		validElEnd=0.0;
		validUdStart=prices.getUdLast();
		validUdEnd=0.0;
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
		
		btnCenuMaia = new JButton("Cenu Maiņa");
		GridBagConstraints gbc_btnCenuMaia = new GridBagConstraints();
		gbc_btnCenuMaia.gridwidth = 3;
		gbc_btnCenuMaia.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCenuMaia.insets = new Insets(0, 0, 5, 5);
		gbc_btnCenuMaia.gridx = 0;
		gbc_btnCenuMaia.gridy = 0;
		contentPane.add(btnCenuMaia, gbc_btnCenuMaia);
		btnCenuMaia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PricesPopUp.getInstance(prices);
			}
		});
		
		JLabel lblElektrba = new JLabel("Elektrības patēriņš");
		GridBagConstraints gbc_lblElektrba = new GridBagConstraints();
		gbc_lblElektrba.gridwidth = 3;
		gbc_lblElektrba.insets = new Insets(0, 0, 5, 5);
		gbc_lblElektrba.gridx = 0;
		gbc_lblElektrba.gridy = 1;
		contentPane.add(lblElektrba, gbc_lblElektrba);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setText(""+validElStart);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validElStart=Double.parseDouble(textField.getText());}
				catch(Exception e1){
						textField.setText(""+validElStart);
	    		}
			}
		});
		
		lblNewLabel = new JLabel("-");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 2;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		textField_2.setText(""+validElEnd);
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validElEnd=Double.parseDouble(textField_2.getText());
					Report.getInstance().getHanger().addTotalEl(validElEnd);}
				catch(Exception e1){
						textField_2.setText(""+validElEnd);
	    		}
			}
		});
		
		JLabel lbldensPatri = new JLabel("Ūdens patēriņš");
		GridBagConstraints gbc_lbldensPatri = new GridBagConstraints();
		gbc_lbldensPatri.gridwidth = 3;
		gbc_lbldensPatri.insets = new Insets(0, 0, 5, 5);
		gbc_lbldensPatri.gridx = 0;
		gbc_lbldensPatri.gridy = 3;
		contentPane.add(lbldensPatri, gbc_lbldensPatri);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setText(""+validUdStart);
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validUdStart=Double.parseDouble(textField_1.getText());}
				catch(Exception e1){
						textField_1.setText(""+validUdStart);
	    		}
			}
		});
		
		label = new JLabel("-");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		contentPane.add(label, gbc_label);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		textField_3.setText(""+validUdEnd);
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validUdEnd=Double.parseDouble(textField_3.getText());
					Report.getInstance().getHanger().addTotalWa(validUdEnd);}
				catch(Exception e1){
						textField_3.setText(""+validUdEnd);
	    		}
			}
		});
	}
	
	public String getElectricity(){
		return textField_2.getText();
	}
	
	public String getWater(){
		return textField_3.getText();
	}
	
	public JPanel getPrices(){
		return contentPane;
	}
}
