package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class HangarUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Double total=0.0,means=0.0,tenant_1=0.0,tenant_2=0.0,tenant_3=0.0,tenant_4=0.0,totalw=0.0,tenant_1w=0.0,tenant_2w=0.0,tenant_3w=0.0,tenant_4w=0.0;

	public static void main(String[] args) {
		new HangarUI();
	}

	public HangarUI() {
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
		
		JLabel lblNewLabel = new JLabel("Elektribas at\u0161\u0137ir\u012Bba: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		JLabel lblNewLabel_1 = new JLabel("\u016Adens at\u0161\u0137ir\u012Bba: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
	}
	
	private void cahngeWa(){
		Double result=totalw-(tenant_1w+tenant_2w+tenant_3w+tenant_4w);
		textField_1.setText(""+result);
	}
	
	private void cahngeEl(){
		Double result=total-(means+tenant_1+tenant_2+tenant_3+tenant_4);
		textField.setText(""+result);
	}
	
	public void addTotalEl(Double x){
		total=x;
		cahngeEl();
	}
	
	public void addTotalWa(Double x){
		totalw=x;
		cahngeWa();
	}

	public void addMeansEl(Double x){
		means=x;
		cahngeEl();
	}
	
	public void addTenant_1El(Double x){
		tenant_1=x;
		cahngeEl();
	}
	
	public void addTenant_1Wa(Double x){
		tenant_1w=x;
		cahngeWa();
	}
	
	public void addTenant_2El(Double x){
		tenant_2=x;
		cahngeEl();
	}
	
	public void addTenant_2Wa(Double x){
		tenant_2w=x;
		cahngeWa();
	}
	
	public void addTenant_3El(Double x){
		tenant_3=x;
		cahngeEl();
	}
	
	public void addTenant_3Wa(Double x){
		tenant_3w=x;
		cahngeWa();
	}
	
	public void addTenant_4El(Double x){
		tenant_4=x;
		cahngeEl();
	}
	
	public void addTenant_4Wa(Double x){
		tenant_4w=x;
		cahngeWa();
	}
	
	public JPanel getHangar(){
		return contentPane;
	}
}
