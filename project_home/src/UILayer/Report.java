package UILayer;

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

	Rent tenant_1, tenant_2, tenant_3, tenant_4;
	private GridBagConstraints gbc_tenantPanel_1, gbc_tenantPanel_2, gbc_tenantPanel_3, gbc_tenantPanel_4;
	Prices prices;
	Sum hangar;
	Company means;
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

	//todo notify if before is bigger then after
	//todo fix save

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

		tenant_1 = new Rent(1);
		gbc_tenantPanel_1 = new GridBagConstraints();
		gbc_tenantPanel_1.insets = new Insets(0, 0, 5, 5);
		gbc_tenantPanel_1.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_1.gridx = 1;
		gbc_tenantPanel_1.gridy = 0;
		contentPane.add(tenant_1.contentPane, gbc_tenantPanel_1);

		tenant_2 = new Rent(2);
		gbc_tenantPanel_2 = new GridBagConstraints();
		gbc_tenantPanel_2.insets = new Insets(0, 0, 5, 0);
		gbc_tenantPanel_2.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_2.gridx = 2;
		gbc_tenantPanel_2.gridy = 0;
		contentPane.add(tenant_2.contentPane, gbc_tenantPanel_2);

		means = new Company();
		JPanel meansPanel = means.contentPane;
		GridBagConstraints gbc_meansPanel = new GridBagConstraints();
		gbc_meansPanel.gridheight = 2;
		gbc_meansPanel.insets = new Insets(0, 0, 5, 5);
		gbc_meansPanel.fill = GridBagConstraints.BOTH;
		gbc_meansPanel.gridx = 0;
		gbc_meansPanel.gridy = 1;
		contentPane.add(meansPanel, gbc_meansPanel);

		tenant_3 = new Rent(3);
		gbc_tenantPanel_3 = new GridBagConstraints();
		gbc_tenantPanel_3.insets = new Insets(0, 0, 5, 5);
		gbc_tenantPanel_3.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_3.gridx = 1;
		gbc_tenantPanel_3.gridy = 1;
		contentPane.add(tenant_3.contentPane, gbc_tenantPanel_3);

		tenant_4 = new Rent(4);
		gbc_tenantPanel_4 = new GridBagConstraints();
		gbc_tenantPanel_4.insets = new Insets(0, 0, 5, 0);
		gbc_tenantPanel_4.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_4.gridx = 2;
		gbc_tenantPanel_4.gridy = 1;
		contentPane.add(tenant_4.contentPane, gbc_tenantPanel_4);

		hangar = new Sum();
		JPanel hangarPanel = hangar.contentPane;
		GridBagConstraints gbc_hangarPanel = new GridBagConstraints();
		gbc_hangarPanel.gridwidth = 2;
		gbc_hangarPanel.insets = new Insets(0, 0, 5, 0);
		gbc_hangarPanel.fill = GridBagConstraints.BOTH;
		gbc_hangarPanel.gridx = 1;
		gbc_hangarPanel.gridy = 2;
		contentPane.add(hangarPanel, gbc_hangarPanel);

		JButton saveButton = new JButton("Saglabāt");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.fill = GridBagConstraints.BOTH;
		gbc_saveButton.gridwidth = 3;
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 3;
		contentPane.add(saveButton, gbc_saveButton);
		saveButton.addActionListener(arg0 -> {
					try {
             		/*
                     workbook = new HSSFWorkbook();
                     String file = "Rekins"+dateString.substring(6, 10)+"."+dateString.substring(3, 5)+".xls";
                     out = new FileOutputStream(new File(file));
                    Design design=new Design(workbook);
                    if(means.writeWord(design) && tenant_1.writeWord(design) && tenant_2.writeWord(design) && tenant_3.writeWord(design) && tenant_4.writeWord(design)){
                        workbook.write(out);
                        out.close();
                        workbook.close();
                        Desktop.getDesktop().open(new File(file));

                        //restart();
                        hangar = new HangarUI();
                        saveButton.setBackground(Color.GREEN);
                    }
                    else{
                        saveButton.setBackground(Color.RED);
                    }
                    */
						//todo fix save
					} catch (Exception e) {
						saveButton.setBackground(Color.RED);
					}
				}
		);
		
        setVisible(true);
	}

	public void Refresh(){
		tenant_1.nameButton.setText(InfoController.info.tenant_1.name);
		tenant_2.nameButton.setText(InfoController.info.tenant_2.name);
		tenant_3.nameButton.setText(InfoController.info.tenant_3.name);
		tenant_4.nameButton.setText(InfoController.info.tenant_4.name);

		getContentPane().revalidate();
		getContentPane().repaint();
	}
}
 

