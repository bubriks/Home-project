package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModelLayer.Tenant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ControlLayer.Design;
import ModelLayer.Prices;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Report extends JFrame {

	RentUI tenant_1, tenant_2, tenant_3, tenant_4;
	PricesUI prices;
	HangarUI hangar;
	MeansUI means;

	public static void main(String[] args) {
		new Report();
	}

	//todo use prev month values (dont have random file)
	//todo clean code, improve UI, notify if before is bigger then after
	//todo fix save

	private Report() {
		//info();
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

		prices = new PricesUI();
		JPanel pricePanel = prices.contentPane;
		GridBagConstraints gbc_pricePanel = new GridBagConstraints();
		gbc_pricePanel.insets = new Insets(0, 0, 5, 5);
		gbc_pricePanel.fill = GridBagConstraints.BOTH;
		gbc_pricePanel.gridx = 0;
		gbc_pricePanel.gridy = 0;
		contentPane.add(pricePanel, gbc_pricePanel);

		tenant_1 = new RentUI(1);
		JPanel tenantPanel_1 = tenant_1.contentPane;
		GridBagConstraints gbc_tenantPanel_1 = new GridBagConstraints();
		gbc_tenantPanel_1.insets = new Insets(0, 0, 5, 5);
		gbc_tenantPanel_1.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_1.gridx = 1;
		gbc_tenantPanel_1.gridy = 0;
		contentPane.add(tenantPanel_1, gbc_tenantPanel_1);

		tenant_2 = new RentUI(2);
		JPanel tenantPanel_2 = tenant_2.contentPane;
		GridBagConstraints gbc_tenantPanel_2 = new GridBagConstraints();
		gbc_tenantPanel_2.insets = new Insets(0, 0, 5, 0);
		gbc_tenantPanel_2.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_2.gridx = 2;
		gbc_tenantPanel_2.gridy = 0;
		contentPane.add(tenantPanel_2, gbc_tenantPanel_2);

		means = new MeansUI();
		JPanel meansPanel = means.contentPane;
		GridBagConstraints gbc_meansPanel = new GridBagConstraints();
		gbc_meansPanel.gridheight = 2;
		gbc_meansPanel.insets = new Insets(0, 0, 5, 5);
		gbc_meansPanel.fill = GridBagConstraints.BOTH;
		gbc_meansPanel.gridx = 0;
		gbc_meansPanel.gridy = 1;
		contentPane.add(meansPanel, gbc_meansPanel);

		tenant_3 = new RentUI(3);
		JPanel tenantPanel_3 = tenant_3.contentPane;
		GridBagConstraints gbc_tenantPanel_3 = new GridBagConstraints();
		gbc_tenantPanel_3.insets = new Insets(0, 0, 5, 5);
		gbc_tenantPanel_3.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_3.gridx = 1;
		gbc_tenantPanel_3.gridy = 1;
		contentPane.add(tenantPanel_3, gbc_tenantPanel_3);

		tenant_4 = new RentUI(4);
		JPanel tenantPanel_4 = tenant_4.contentPane;
		GridBagConstraints gbc_tenantPanel_4 = new GridBagConstraints();
		gbc_tenantPanel_4.insets = new Insets(0, 0, 5, 0);
		gbc_tenantPanel_4.fill = GridBagConstraints.BOTH;
		gbc_tenantPanel_4.gridx = 2;
		gbc_tenantPanel_4.gridy = 1;
		contentPane.add(tenantPanel_4, gbc_tenantPanel_4);

		hangar = new HangarUI();
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
						//todo fix
					} catch (Exception e) {
						saveButton.setBackground(Color.RED);
					}
				}
		);
		
        setVisible(true);
	}
}
 

