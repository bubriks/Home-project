package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class Sum extends JFrame {

	JPanel contentPane;
	private JTextField electricityField, waterField;

	public Sum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel electricityDifferenceLabel = new JLabel("Elektrības atšķirība: ");
		GridBagConstraints gbc_electricityDifferenceLabel = new GridBagConstraints();
		gbc_electricityDifferenceLabel.insets = new Insets(0, 0, 5, 5);
		gbc_electricityDifferenceLabel.gridx = 0;
		gbc_electricityDifferenceLabel.gridy = 0;
		contentPane.add(electricityDifferenceLabel, gbc_electricityDifferenceLabel);

		electricityField = new JTextField();
		GridBagConstraints gbc_electricityField = new GridBagConstraints();
		gbc_electricityField.insets = new Insets(0, 0, 5, 0);
		gbc_electricityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_electricityField.gridx = 1;
		gbc_electricityField.gridy = 0;
		contentPane.add(electricityField, gbc_electricityField);
		electricityField.setColumns(10);
		electricityField.setEditable(false);
		
		JLabel waterDifferenceLabel = new JLabel("Ūdens atšķirība: ");
		GridBagConstraints gbc_waterDifferenceLabel = new GridBagConstraints();
		gbc_waterDifferenceLabel.insets = new Insets(0, 0, 0, 5);
		gbc_waterDifferenceLabel.gridx = 0;
		gbc_waterDifferenceLabel.gridy = 1;
		contentPane.add(waterDifferenceLabel, gbc_waterDifferenceLabel);

		waterField = new JTextField();
		GridBagConstraints gbc_waterField = new GridBagConstraints();
		gbc_waterField.fill = GridBagConstraints.HORIZONTAL;
		gbc_waterField.gridx = 1;
		gbc_waterField.gridy = 1;
		contentPane.add(waterField, gbc_waterField);
		waterField.setColumns(10);
		waterField.setEditable(false);
	}

	public void changeWater(){
		Double result= - Double.parseDouble(Report.getInstance().prices.waterEndField.getText())+
				Double.parseDouble(Report.getInstance().prices.waterStartField.getText())+
				Double.parseDouble(Report.getInstance().tenant_1.waterEndField.getText())+
				Double.parseDouble(Report.getInstance().tenant_2.waterEndField.getText())+
				Double.parseDouble(Report.getInstance().tenant_3.waterEndField.getText())+
				Double.parseDouble(Report.getInstance().tenant_4.waterEndField.getText());
		waterField.setText(""+result);
	}
	
	public void changeElectricity(){
		Double result= - Double.parseDouble(Report.getInstance().prices.electricityEndField.getText())+
				Double.parseDouble(Report.getInstance().prices.electricityStartField.getText())+
				Double.parseDouble(Report.getInstance().means.ElectricityEndField.getText())+
				Double.parseDouble(Report.getInstance().tenant_1.electricityEndField.getText())+
				Double.parseDouble(Report.getInstance().tenant_2.electricityEndField.getText())+
				Double.parseDouble(Report.getInstance().tenant_3.electricityEndField.getText())+
				Double.parseDouble(Report.getInstance().tenant_4.electricityEndField.getText());
		electricityField.setText(""+result);
	}
}
