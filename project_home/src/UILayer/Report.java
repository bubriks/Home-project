package UILayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ModelLayer.Design;
import ModelLayer.Owner;
import ModelLayer.Prices;
import ModelLayer.Reciever;
import ModelLayer.Tenant;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Report extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat fd = new SimpleDateFormat("dd.MM.yyyy");
	private Date date=new Date();
	private String dateString=fd.format(date);
	private Prices prices;
	private double electricity;
	private Owner owner;
	private Reciever reciever;
	private Queue<Tenant> tenants = new LinkedList<Tenant>();
	private JPanel panel,panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7;
	private GridBagConstraints gbc_panel,gbc_panel_1,gbc_panel_2,gbc_panel_3,gbc_panel_4,gbc_panel_5,gbc_panel_6,gbc_panel_7;
	private HSSFWorkbook workbook;
	private static Report instance=null;
	private MeansUI means;
	private RentUI rent_1,rent_2,rent_3,rent_4;
	private FileOutputStream out;
	private PricesUI price;
	private HangarUI hangar=new HangarUI();

	public static void main(String[] args) {
		getInstance();
	}
	
	protected static Report getInstance() {
		if (instance == null){
			instance = new Report();
		}
	    return instance; 
	 }

	public Report() {
		workbook = new HSSFWorkbook();
		try {
			out = new FileOutputStream(new File("Rekins"+dateString.substring(6, 10)+"."+dateString.substring(3, 5)+".xls"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		info();
		
		setMinimumSize(new Dimension(800, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel =price.getPrices();
		gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		panel_2 = rent_1.getRent();
		gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		contentPane.add(panel_2, gbc_panel_2);
		
		panel_3 = rent_2.getRent();
		gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 0;
		contentPane.add(panel_3, gbc_panel_3);
		
		panel_1 = means.getMeans();
		gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		
		panel_4 =rent_3.getRent();
		gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		contentPane.add(panel_4, gbc_panel_4);
		
		panel_5 =rent_4.getRent();
		gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 1;
		contentPane.add(panel_5, gbc_panel_5);
		
		panel_6 = new JPanel();
		gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 2;
		contentPane.add(panel_6, gbc_panel_6);
		
		panel_7 = hangar.getHangar();
		gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 2;
		contentPane.add(panel_7, gbc_panel_7);
		
		JButton btnNewButton = new JButton("Radît");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
				        Design design=new Design(workbook);
						if(means.writeWord(design)==true && rent_1.writeWord(design)==true && rent_2.writeWord(design)==true && rent_3.writeWord(design)==true && rent_4.writeWord(design)==true){
							workbook.write(out);
							out.close();
							workbook.close();
							Desktop.getDesktop().open(new File("Rekins"+dateString.substring(6, 10)+"."+dateString.substring(3, 5)+".xls"));
							
							BufferedReader file = new BufferedReader(new FileReader("info.txt"));
					        String line;
					        StringBuffer inputBuffer = new StringBuffer();
					        while ((line = file.readLine()) != null) {
					            inputBuffer.append(line);
					            inputBuffer.append('\n');
					        }
					        String inputStr = inputBuffer.toString();
					        file.close();
					        inputStr = inputStr.replace("\nMeans- "+electricity+".",
					        		"\nMeans- "+Double.parseDouble(means.getElectricity())+".");
					        inputStr = inputStr.replace("\nCenas- "+prices.getElRate()+","+prices.getUdRate()+","+prices.getKaRate()+","+prices.getElLast()+","+prices.getUdLast()+".",
					        		"\nCenas- "+prices.getElRate()+","+prices.getUdRate()+","+prices.getKaRate()+","+Double.parseDouble(price.getElectricity())+","+Double.parseDouble(price.getWater())+"."); 
					        inputStr = inputStr.replace("\n"+rent_1.getTenant().getName()+","+rent_1.getTenant().getElectricity()+","+rent_1.getTenant().getWater()+","+rent_1.getTenant().getRent()+","+rent_1.getTenant().getHeating()+","+rent_1.getTenant().getGarbage()+","+rent_1.getTenant().getInternet()+".",
					        		"\n"+rent_1.getTenant().getName()+","+Double.parseDouble(rent_1.getElectricity())+","+Double.parseDouble(rent_1.getWater())+","+rent_1.getTenant().getRent()+","+rent_1.getTenant().getHeating()+","+rent_1.getTenant().getGarbage()+","+rent_1.getTenant().getInternet()+".");
					        inputStr = inputStr.replace("\n"+rent_2.getTenant().getName()+","+rent_2.getTenant().getElectricity()+","+rent_2.getTenant().getWater()+","+rent_2.getTenant().getRent()+","+rent_2.getTenant().getHeating()+","+rent_2.getTenant().getGarbage()+","+rent_2.getTenant().getInternet()+".",
					        		"\n"+rent_2.getTenant().getName()+","+Double.parseDouble(rent_2.getElectricity())+","+Double.parseDouble(rent_2.getWater())+","+rent_2.getTenant().getRent()+","+rent_2.getTenant().getHeating()+","+rent_2.getTenant().getGarbage()+","+rent_2.getTenant().getInternet()+".");
					        inputStr = inputStr.replace("\n"+rent_3.getTenant().getName()+","+rent_3.getTenant().getElectricity()+","+rent_3.getTenant().getWater()+","+rent_3.getTenant().getRent()+","+rent_3.getTenant().getHeating()+","+rent_3.getTenant().getGarbage()+","+rent_3.getTenant().getInternet()+".",
					        		"\n"+rent_3.getTenant().getName()+","+Double.parseDouble(rent_3.getElectricity())+","+Double.parseDouble(rent_3.getWater())+","+rent_3.getTenant().getRent()+","+rent_3.getTenant().getHeating()+","+rent_3.getTenant().getGarbage()+","+rent_3.getTenant().getInternet()+".");
					        inputStr = inputStr.replace("\n"+rent_4.getTenant().getName()+","+rent_4.getTenant().getElectricity()+","+rent_4.getTenant().getWater()+","+rent_4.getTenant().getRent()+","+rent_4.getTenant().getHeating()+","+rent_4.getTenant().getGarbage()+","+rent_4.getTenant().getInternet()+".",
					        		"\n"+rent_4.getTenant().getName()+","+Double.parseDouble(rent_4.getElectricity())+","+Double.parseDouble(rent_4.getWater())+","+rent_4.getTenant().getRent()+","+rent_4.getTenant().getHeating()+","+rent_4.getTenant().getGarbage()+","+rent_4.getTenant().getInternet()+".");
					        FileOutputStream fileOut = new FileOutputStream("info.txt");
					        fileOut.write(inputStr.getBytes());
					        fileOut.close();
					        restart();
					        hangar=new HangarUI();
					        btnNewButton.setBackground(Color.GREEN);
						}
						else{
							btnNewButton.setBackground(Color.RED);
						}
				    } catch (Exception e) {
				    	btnNewButton.setBackground(Color.RED);
				    }
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
        setVisible(true);
	}
	
	protected HangarUI getHanger(){
		return hangar;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void info(){
		File newTextFile = new File("info.txt");
		try {//try's opening file
			read(newTextFile);
		} catch (Exception e) {//creates new doc if doens't exist
			try {
				Write(newTextFile);
				read(newTextFile);
			} catch (Exception e1) {
				System.out.println("unexpected error!");
			}
		}
	}
	
	private void Write(File newTextFile) throws Exception{
			FileWriter fw = new FileWriter(newTextFile);
			fw.write(""+dateString.substring(6, 10)+"."+dateString.substring(3, 5));//0
			fw.write("\nCenas- 0.1727,1.2584,1.3431,0.0,0.0.");//1
			fw.write("\nOwner- Sintija Zaòìe 040972-11072,Kurzemes iela 29, Tukums ,AS SEB Unibanka,UNLALV2X,LV95UNLA0050009677801,40003151743.");//2
			fw.write("\nReciever- SIA 'MEANS',Kurzemes iela 29, Tukums ,LV40UNLA0050000136610,LV40003532375.");//3
			fw.write("\nMeans- 0.0.");//4
			fw.write("\nTenants");//5
			fw.write("\nEgils,0.0,0.0,28.5,28.5,0.0,0.0.");//6
			fw.write("\nGatis,0.0,0.0,71.0,57.0,5.0,4.0.");//7
			fw.write("\nZigrîda,0.0,0.0,71.0,57.0,4.0,0.0.");//8
			fw.write("\nEgnârs,0.0,0.0,42.68,28.5,0.0,7.0.");//9
	        fw.close();
	}
	
	private void read(File newTextFile) throws Exception{
	    Scanner scanner = new Scanner(newTextFile);
	    scanner.nextLine();
	    int lineNr=0;
	    while (scanner.hasNextLine()){
	        String line=scanner.nextLine();
	        if(line!=null && line.substring(0, 5).equals("Cenas") && lineNr==0){
	        	double elRate = Double.parseDouble(line.substring(line.lastIndexOf("-")+2 , line.indexOf(",")));
	        	line=line.substring(line.indexOf(",")+1);
	        	double udRate = Double.parseDouble(line.substring(0, line.indexOf(",")));
	        	line=line.substring(line.indexOf(",")+1);
	        	double kaRate = Double.parseDouble(line.substring(0, line.indexOf(",")));
	        	line=line.substring(line.indexOf(",")+1);
	        	double elLast = Double.parseDouble(line.substring(0, line.indexOf(",")));
	        	line=line.substring(line.indexOf(",")+1);
	        	double udLast = Double.parseDouble(line.substring(0, line.indexOf(".")));
	        	line=null;
	        	prices=new Prices(elRate,elLast,udRate,kaRate,udLast);
	        }
	        if(line!=null && line.substring(0, 5).equals("Owner") && lineNr==1){
	        	String name=line.substring(line.indexOf("-")+2 , line.indexOf(","));
	        	line=line.substring(line.indexOf(",")+1);
	        	String street=line.substring(0, line.indexOf(" ,"));
	        	line=line.substring(line.indexOf(" ,")+2);
	        	String bank=line.substring(0, line.indexOf(","));
	        	line=line.substring(line.indexOf(",")+1);
	        	String code=line.substring(0, line.indexOf(","));
	        	line=line.substring(line.indexOf(",")+1);
	        	String rekvizit=line.substring(0, line.indexOf(","));
	        	line=line.substring(line.indexOf(",")+1);
	        	String info=line.substring(0, line.indexOf("."));
	        	line=null;
	        	owner=new Owner(name, street, bank, code, rekvizit, info);
	        }
	        if(line!=null && line.substring(0, 7).equals("Tenants") && lineNr==4){
	        	while(scanner.hasNextLine()){
	        		line=scanner.nextLine();
	        		String name=line.substring(0, line.indexOf(","));
		        	line=line.substring(line.indexOf(",")+1);
		        	double elLast = Double.parseDouble(line.substring(0, line.indexOf(",")));
		        	line=line.substring(line.indexOf(",")+1);
		        	double udLast = Double.parseDouble(line.substring(0, line.indexOf(",")));
		        	line=line.substring(line.indexOf(",")+1);
		        	double rent = Double.parseDouble(line.substring(0, line.indexOf(",")));
		        	line=line.substring(line.indexOf(",")+1);
		        	double heating = Double.parseDouble(line.substring(0, line.indexOf(",")));
		        	line=line.substring(line.indexOf(",")+1);
		        	double garbage = Double.parseDouble(line.substring(0, line.indexOf(",")));
		        	line=line.substring(line.indexOf(",")+1);
		        	double internet = Double.parseDouble(line.substring(0, line.indexOf(".")));
		        	tenants.add(new Tenant(name, elLast, udLast, rent, heating, garbage, internet));
	        		line=null;
	        	}
	        }
	        if(line!=null && line.substring(0, 8).equals("Reciever") && lineNr==2){
	        	String name=line.substring(line.lastIndexOf("-")+2 , line.indexOf(","));
	        	line=line.substring(line.indexOf(",")+1);
	        	String street=line.substring(0, line.indexOf(" ,"));
	        	line=line.substring(line.indexOf(" ,")+2);
	        	String rekvizit=line.substring(0, line.indexOf(","));
	        	line=line.substring(line.indexOf(",")+1);
	        	String info=line.substring(0, line.indexOf("."));
	        	line=null;
	        	reciever=new Reciever(name, street, rekvizit, info);
	        }
	        if(line!=null && line.substring(0, 5).equals("Means") && lineNr==3){
	        	electricity = Double.parseDouble(line.substring(line.lastIndexOf("-")+2 , line.indexOf(".")));
	        	line=null;
	        }
	        lineNr++;
	    }
	    scanner.close();
	    price=new PricesUI(prices);
	    means=new MeansUI(workbook,fd,date,dateString,owner,reciever,prices,electricity);
		rent_1=new RentUI(workbook,tenants.poll(),prices,fd,date,dateString,1);
		rent_2=new RentUI(workbook,tenants.poll(),prices,fd,date,dateString,2);
		rent_3=new RentUI(workbook,tenants.poll(),prices,fd,date,dateString,3);
		rent_4=new RentUI(workbook,tenants.poll(),prices,fd,date,dateString,4);
	}
	
	public void restart(){
		info();
		getContentPane().remove(panel);
		getContentPane().remove(panel_1);  
		getContentPane().remove(panel_2); 
		getContentPane().remove(panel_3); 
		getContentPane().remove(panel_4); 
		getContentPane().remove(panel_5); 
		
		panel=price.getPrices();
		getContentPane().add(panel,gbc_panel);
		panel_1=means.getMeans();
		getContentPane().add(panel_1,gbc_panel_1);
		panel_2=rent_1.getRent();
		getContentPane().add(panel_2,gbc_panel_2);
		panel_3=rent_2.getRent();
		getContentPane().add(panel_3,gbc_panel_3);
		panel_4=rent_3.getRent();
		getContentPane().add(panel_4,gbc_panel_4);
		panel_5=rent_4.getRent();
		getContentPane().add(panel_5,gbc_panel_5);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
}
 

