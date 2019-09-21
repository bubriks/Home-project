package UILayer;

import ControlLayer.DocumentController;
import ControlLayer.InfoController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

public class Report extends JFrame {

	Rent rent_1, rent_2, rent_3, rent_4;
	Prices prices;
	Sum sum;
	Company company;
	private static Report instance=null;

	public static void main(String[] args) {
		getInstance();
	}

	static Report getInstance() {
		if (instance == null){
			instance = new Report();
		}
		return instance;
	}

	private Report() {
		new InfoController();
		setMinimumSize(new Dimension(800, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		prices = new Prices();
		JPanel pricePanel = prices.contentPane;
		GridBagConstraints gbc_pricePanel = new GridBagConstraints();
		gbc_pricePanel.insets = new Insets(0, 0, 5, 5);
		gbc_pricePanel.fill = GridBagConstraints.BOTH;
		gbc_pricePanel.gridx = 0;
		gbc_pricePanel.gridy = 0;
		contentPane.add(pricePanel, gbc_pricePanel);

		rent_1 = new Rent(1);
        GridBagConstraints gbc_rentPanel_1 = new GridBagConstraints();
		gbc_rentPanel_1.insets = new Insets(0, 0, 5, 5);
		gbc_rentPanel_1.fill = GridBagConstraints.BOTH;
		gbc_rentPanel_1.gridx = 1;
		gbc_rentPanel_1.gridy = 0;
		contentPane.add(rent_1.contentPane, gbc_rentPanel_1);

		rent_2 = new Rent(2);
        GridBagConstraints gbc_rentPanel_2 = new GridBagConstraints();
		gbc_rentPanel_2.insets = new Insets(0, 0, 5, 0);
		gbc_rentPanel_2.fill = GridBagConstraints.BOTH;
		gbc_rentPanel_2.gridx = 2;
		gbc_rentPanel_2.gridy = 0;
		contentPane.add(rent_2.contentPane, gbc_rentPanel_2);

		company = new Company();
		JPanel companyPanel = company.contentPane;
		GridBagConstraints gbc_companyPanel = new GridBagConstraints();
		gbc_companyPanel.gridheight = 2;
		gbc_companyPanel.insets = new Insets(0, 0, 5, 5);
		gbc_companyPanel.fill = GridBagConstraints.BOTH;
		gbc_companyPanel.gridx = 0;
		gbc_companyPanel.gridy = 1;
		contentPane.add(companyPanel, gbc_companyPanel);

		rent_3 = new Rent(3);
        GridBagConstraints gbc_rentPanel_3 = new GridBagConstraints();
		gbc_rentPanel_3.insets = new Insets(0, 0, 5, 5);
		gbc_rentPanel_3.fill = GridBagConstraints.BOTH;
		gbc_rentPanel_3.gridx = 1;
		gbc_rentPanel_3.gridy = 1;
		contentPane.add(rent_3.contentPane, gbc_rentPanel_3);

		rent_4 = new Rent(4);
        GridBagConstraints gbc_rentPanel_4 = new GridBagConstraints();
		gbc_rentPanel_4.insets = new Insets(0, 0, 5, 0);
		gbc_rentPanel_4.fill = GridBagConstraints.BOTH;
		gbc_rentPanel_4.gridx = 2;
		gbc_rentPanel_4.gridy = 1;
		contentPane.add(rent_4.contentPane, gbc_rentPanel_4);

		sum = new Sum();
		JPanel sumPanel = sum.contentPane;
		GridBagConstraints gbc_sumPanel = new GridBagConstraints();
		gbc_sumPanel.gridwidth = 2;
		gbc_sumPanel.insets = new Insets(0, 0, 5, 0);
		gbc_sumPanel.fill = GridBagConstraints.BOTH;
		gbc_sumPanel.gridx = 1;
		gbc_sumPanel.gridy = 2;
		contentPane.add(sumPanel, gbc_sumPanel);

		JButton saveButton = new JButton("Saglabāt");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.fill = GridBagConstraints.BOTH;
		gbc_saveButton.gridwidth = 3;
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 3;
		contentPane.add(saveButton, gbc_saveButton);
		saveButton.addActionListener(arg0 -> {
					if(new DocumentController().CreateDocument())
					{
						saveButton.setBackground(Color.GREEN);
					}
					else{
						saveButton.setBackground(Color.RED);
					}
				}
		);

		setVisible(true);
	}

	void Refresh(){
		rent_1.nameButton.setText(InfoController.info.tenant_1.name);
		rent_2.nameButton.setText(InfoController.info.tenant_2.name);
		rent_3.nameButton.setText(InfoController.info.tenant_3.name);
		rent_4.nameButton.setText(InfoController.info.tenant_4.name);

		getContentPane().revalidate();
		getContentPane().repaint();
	}
}
 

