package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ControlLayer.RentControler;
import ModelLayer.Design;
import ModelLayer.Prices;
import ModelLayer.Tenant;

import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;

public class RentUI extends JFrame {

	private JPanel contentPane;
	private JTextField elstart,elend,ustart,uend;
	private JLabel lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3;
	private JButton btnVrds;
	private Tenant tenant;
	private double validElStart,validElEnd,validUdStart,validUdEnd;
	
	public RentUI(Tenant tenant,int index){
		validElStart=tenant.getElectricity();
		validElEnd=0.0;
		validUdStart=tenant.getWater();
		validUdEnd=0.0;
		this.tenant=tenant;
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
		
		btnVrds = new JButton(tenant.getName());
		GridBagConstraints gbc_btnVrds = new GridBagConstraints();
		gbc_btnVrds.fill = GridBagConstraints.BOTH;
		gbc_btnVrds.gridwidth = 3;
		gbc_btnVrds.insets = new Insets(0, 0, 5, 5);
		gbc_btnVrds.gridx = 0;
		gbc_btnVrds.gridy = 0;
		contentPane.add(btnVrds, gbc_btnVrds);
		btnVrds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 TenantPopUp.getInstance(tenant);
			}
		});
		
		lblNewLabel_3 = new JLabel("Elektrība");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 3;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		elstart = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		contentPane.add(elstart, gbc_textField);
		elstart.setText(""+validElStart);
		elstart.setColumns(10);
		elstart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validElStart=Double.parseDouble(elstart.getText());}
				catch(Exception e1){
					elstart.setText(""+validElStart);
	    		}
			}
		});
		
		lblNewLabel = new JLabel("-");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		elend = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		contentPane.add(elend, gbc_textField_1);
		elend.setColumns(10);
		elend.setText(""+validElEnd);
		elend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validElEnd=Double.parseDouble(elend.getText());
					if(index==1){Report.getInstance().getHanger().addTenant_1El(validElEnd);}
					if(index==2){Report.getInstance().getHanger().addTenant_2El(validElEnd);}
					if(index==3){Report.getInstance().getHanger().addTenant_3El(validElEnd);}
					if(index==4){Report.getInstance().getHanger().addTenant_4El(validElEnd);}}
				catch(Exception e1){
						elend.setText(""+validElEnd);
	    		}
			}
		});
		
		lblNewLabel_2 = new JLabel("Ūdens");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		ustart = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 4;
		contentPane.add(ustart, gbc_textField_2);
		ustart.setText(""+validUdStart);
		ustart.setColumns(10);
		ustart.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validUdStart=Double.parseDouble(ustart.getText());}
				catch(Exception e1){
					ustart.setText(""+validUdStart);
	    		}
			}
		});
		
		lblNewLabel_1 = new JLabel("-");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		uend = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		contentPane.add(uend, gbc_textField_3);
		uend.setColumns(10);
		uend.setText(""+validUdEnd);
		uend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try{
					validUdEnd=Double.parseDouble(uend.getText());
					if(index==1){Report.getInstance().getHanger().addTenant_1Wa(validUdEnd);}
					if(index==2){Report.getInstance().getHanger().addTenant_2Wa(validUdEnd);}
					if(index==3){Report.getInstance().getHanger().addTenant_3Wa(validUdEnd);}
					if(index==4){Report.getInstance().getHanger().addTenant_4Wa(validUdEnd);}}
				catch(Exception e1){
						uend.setText(""+validUdEnd);
	    		}
			}
		});
	}
	
	public Tenant getTenant(){
		return tenant;
	}
	
	public String getElectricity(){
		return elend.getText();
	}
	
	public String getWater(){
		return uend.getText();
	}
	
	public boolean writeWord(Design design){
		if(Double.parseDouble(elstart.getText())<=Double.parseDouble(elend.getText()) && Double.parseDouble(ustart.getText())<=Double.parseDouble(uend.getText())){
			try{
				new RentControler(Double.parseDouble(elstart.getText()),Double.parseDouble(elend.getText()),Double.parseDouble(ustart.getText()),Double.parseDouble(uend.getText()),Report.getInstance().workbook,tenant,Report.getInstance().prices,Report.getInstance().fd,Report.getInstance().date,Report.getInstance().dateString,design);}
    		catch(Exception e){
    			return false;
    		}
    		 return true;
		}
		else{
			return false;
		}
	}
	
	public JPanel getRent(){
		return contentPane;
	}
}
