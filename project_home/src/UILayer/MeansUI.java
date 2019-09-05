package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ControlLayer.Means;
import ControlLayer.Design;
import ModelLayer.Owner;
import ModelLayer.Receiver;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JButton;

class MeansUI extends JFrame {

	private JPanel contentPane;
	private JTextField start,end;
	private JButton btnMakstjs;
	private JButton btnNewButton;
	private Receiver receiver;
	private Owner owner;
	private double validStart,validEnd;

	MeansUI(Owner owner, Receiver receiver, Double electricity) {
		validStart=electricity;
		validEnd=0.0;
		this.owner=owner;
		this.receiver = receiver;
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
		
		btnMakstjs = new JButton("Maksātājs");
		GridBagConstraints gbc_btnMakstjs = new GridBagConstraints();
		gbc_btnMakstjs.gridwidth = 3;
		gbc_btnMakstjs.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMakstjs.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakstjs.gridx = 0;
		gbc_btnMakstjs.gridy = 0;
		contentPane.add(btnMakstjs, gbc_btnMakstjs);
		btnMakstjs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MeansPopUp.getInstance(receiver);
			}
		});
		
		btnNewButton = new JButton("Saņēmējs");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MeansPopUp.getInstance(owner);
			}
		});
		
		JLabel startText = new JLabel("Elektrība");
		GridBagConstraints gbc_lblMneaSkumaRdtji = new GridBagConstraints();
		gbc_lblMneaSkumaRdtji.gridwidth = 3;
		gbc_lblMneaSkumaRdtji.insets = new Insets(0, 0, 5, 5);
		gbc_lblMneaSkumaRdtji.gridx = 0;
		gbc_lblMneaSkumaRdtji.gridy = 2;
		contentPane.add(startText, gbc_lblMneaSkumaRdtji);
		
		start = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		contentPane.add(start, gbc_textField);
		start.setText(""+validStart);
		start.setColumns(10);
		start.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validStart=Double.parseDouble(start.getText());}
				catch(Exception e1){
					start.setText(""+validStart);
	    		}
			}
		});
		
		JLabel endText = new JLabel("-");
		GridBagConstraints gbc_lblMneaBeigu = new GridBagConstraints();
		gbc_lblMneaBeigu.insets = new Insets(0, 0, 5, 5);
		gbc_lblMneaBeigu.gridx = 1;
		gbc_lblMneaBeigu.gridy = 3;
		contentPane.add(endText, gbc_lblMneaBeigu);
		
		end = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		contentPane.add(end, gbc_textField_1);
		end.setColumns(10);
		end.setText(""+validEnd);
		end.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validEnd=Double.parseDouble(end.getText());
					Report.getInstance().getHanger().addMeansEl(validEnd);}
				catch(Exception e1){
					end.setText(""+validEnd);
	    		}
			}
		});
	}
	
	String getElectricity(){
		return end.getText();
	}
	
	boolean writeWord(Design design){
    	if(Double.parseDouble(start.getText())<=Double.parseDouble(end.getText())){
    		try{
    			new Means(Double.parseDouble(start.getText()),Double.parseDouble(end.getText()),Report.getInstance().workbook,Report.getInstance().fd,Report.getInstance().date,Report.getInstance().dateString,design,Report.getInstance().prices, receiver,owner);}
    		catch(Exception e){
    			return false;
    		}
    	 return true;
    	}
    	else{
    		return false;
    	}
	}
	
	JPanel getMeans(){
		return contentPane;
	}
}
