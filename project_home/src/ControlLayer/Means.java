package ControlLayer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import ModelLayer.Owner;
import ModelLayer.Prices;
import ModelLayer.Receiver;

public class Means {
	
	private SimpleDateFormat fd;
	private String dateString;
	
	public Means(Double start, Double end, HSSFWorkbook workbook, SimpleDateFormat fd, Date date, String dateString, Design design, Prices prices, Receiver receiver, Owner owner){
		this.fd = fd;
		this.dateString=dateString;
		HSSFSheet sheet = workbook.createSheet("Means");
		ArrayList<Object[]> data= new ArrayList<>();
		data.add(new Object[]{"Rēķins - Faktūra",dateString.substring(6, 10)+dateString.substring(3, 5)});//0
		data.add(new Object[]{"Datums",getDate()});//1
		data.add(new Object[]{"","",""});//2
		data.add(new Object[]{"Preču nosūtītājs",owner.getName(),"",""});//3
		data.add(new Object[]{"Adrese",owner.getAddress(),"",""});//4
		data.add(new Object[]{"Izsniegts",owner.getAddress(),"",""});//5
		data.add(new Object[]{"Norēķinu rekvizīti",owner.getBankName(),owner.getCode(),""});//6
		data.add(new Object[]{"Norēķinu rekvizīti",owner.getInvoice(),owner.getInfo(),""});//7
		data.add(new Object[]{"Preču saņēmējs", receiver.getName(), receiver.getInfo(),""});//8
		data.add(new Object[]{"Adrese", receiver.getAddress(),"",""});//9
		data.add(new Object[]{"Saņemts", receiver.getAddress(),"",""});//10
		data.add(new Object[]{"Piegādes datums",getDeliveryDates(date),"",""});//11
		data.add(new Object[]{"Norēķinu rekvizīti", receiver.getInvoice(),"",""});//12
		data.add(new Object[]{"Samaksas veids un kārtība:","Ar pārskaitījumu līdz "+getDueDate(date),"",""});//13
		data.add(new Object[]{"Mērijumi",start,end,""});//14
		data.add(new Object[]{"Nosaukums","Mērvienība","Patērēts","Cena"});//15
		data.add(new Object[]{"Maksa par elektroenerģiju","Kwh",0,prices.getElectricityRate()});//16
		data.add(new Object[]{"Kopā:","","","€"});//17
		data.add(new Object[]{"","","",""});//18
		data.add(new Object[]{"","",""});//19
		data.add(new Object[]{"Izsniedza","Sintija Zaņģe","Saņēma",""});//20
		data.add(new Object[]{getDate(),"",getDate().substring(0, 10),""});//21
		data.add(new Object[]{"Paraksts","","Paraksts",""});//22
		
	  	int rownum = 0;
	  	for (Object[] Row : data){
	  		Row row = sheet.createRow(rownum++);
	  		int cellnum = 0;
	  		for (Object obj : Row){
	  			Cell cell = row.createCell(cellnum++);
	  			if(obj instanceof String)
	  				cell.setCellValue((String)obj);
	  			else if(obj instanceof Double)
				  	cell.setCellValue((Double)obj);
	  			else if(obj instanceof Integer)
	  				cell.setCellValue((Integer)obj);
	  		}
	  	}
	    
	    sheet.getRow(16).getCell(2).setCellFormula("C15-B15");
	    sheet.getRow(17).getCell(1).setCellFormula("C17*D17");
	    
	    sheet.addMergedRegion(new CellRangeAddress(3,3,1,3));
	    sheet.addMergedRegion(new CellRangeAddress(4,4,1,3));
	    sheet.addMergedRegion(new CellRangeAddress(5,5,1,3));
	    sheet.addMergedRegion(new CellRangeAddress(6,6,2,3));
	    sheet.addMergedRegion(new CellRangeAddress(7,7,2,3));
	  	sheet.addMergedRegion(new CellRangeAddress(6,7,0,0));
	  	sheet.addMergedRegion(new CellRangeAddress(8,8,2,3));
	  	sheet.addMergedRegion(new CellRangeAddress(9,9,1,3));
	  	sheet.addMergedRegion(new CellRangeAddress(10,10,1,3));
	  	sheet.addMergedRegion(new CellRangeAddress(11,11,1,3));
	  	sheet.addMergedRegion(new CellRangeAddress(12,12,1,3));
	  	sheet.addMergedRegion(new CellRangeAddress(13,13,1,3));
	  	sheet.addMergedRegion(new CellRangeAddress(14,14,2,3));
	  	sheet.addMergedRegion(new CellRangeAddress(17,17,1,2));
	  	sheet.addMergedRegion(new CellRangeAddress(18,18,0,3));
	  	sheet.addMergedRegion(new CellRangeAddress(20,20,0,1));
	  	sheet.addMergedRegion(new CellRangeAddress(20,20,2,3));
	  	sheet.addMergedRegion(new CellRangeAddress(21,21,0,1));
	  	sheet.addMergedRegion(new CellRangeAddress(21,21,2,3));
	  	
	  	sheet.autoSizeColumn(0);
	  	sheet.setColumnWidth(1, 10000);
	  	sheet.setColumnWidth(2, 5000);
	  	sheet.setColumnWidth(3, 5000);
	  	
	  	sheet.getRow(18).createCell(0).setCellValue(nameNumber(sheet.getRow(14).getCell(1).getNumericCellValue(),sheet.getRow(14).getCell(2).getNumericCellValue(),sheet.getRow(16).getCell(3).getNumericCellValue()));
	  	
	  	setStyle(workbook,sheet,design);
	}
	
	private void setStyle(HSSFWorkbook workbook,HSSFSheet sheet,Design design){
	  	sheet.getRow(0).getCell(1).setCellStyle(design.getStyle());
	  	sheet.getRow(1).getCell(1).setCellStyle(design.getStyle());
	  	
	    sheet.getRow(20).getCell(3).setCellStyle(design.getStyle2());
	    sheet.getRow(21).getCell(3).setCellStyle(design.getStyle2());
	  	
	  	for(int x=3;x<19;x++){
	  		for(int y=0;y<4;y++){
	        	if(x==3 || x==8){
	        		 switch(y) {
	                 case 0 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignUpLeft());
	                    break;
	                 case 3 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignUpRight());
	                    break;
	                 default :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignUp());
	        		 }
	        	}
	        	else{ if(x==12 || x==18){
	        		 switch(y) {
	                 case 0 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignDownLeft());
	                    break;
	                 case 3 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignDownRight());
	                    break;
	                 default :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignDown());
	              }
	        	}
	        	else{
	        		 switch(y) {
	                 case 0 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignLeft());
	                    break;
	                 case 3 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesignRight());
	                    break;
	                 default :
	                	 sheet.getRow(x).getCell(y).setCellStyle(design.getDesign());
	              }
	        	}
	        }
	     }
	  }
	}
	
	private String nameNumber(Double number2,Double number1,double price){
		double number=(number1-number2)*price;
		String text;
		DecimalFormat f = new DecimalFormat("##.00");
		Double cent=number- (int) number;
		String cents=f.format(cent).substring(1)+" centi";
		if(number>=0){
			switch ((int) number %10) {
	        case 1:  text = "viens";
	                 break;
	        case 2:  text = "divi";
	                 break;
	        case 3:  text = "trīs";
	                 break;
	        case 4:  text = "četri";
	                 break;
	        case 5:  text = "pieci";
	                 break;
	        case 6:  text = "seši";
	                 break;
	        case 7:  text = "septiņi";
	                 break;
	        case 8:  text = "astoņi";
	                 break;
	        case 9:  text = "deviņi";
	                 break;
	        default: text = " ";
	                 break;
			}
			if(number>9){
				switch ((int) number %100- (int) number %10) {
		        case 10:  text = "desmit "+text;
		                 break;
		        case 20:  text = "divdesmit "+text;
		                 break;
		        case 30:  text = "trīsdesmit "+text;
		                 break;
		        case 40:  text = "četrdesmit "+text;
		                 break;
		        case 50:  text = "piecdesmit "+text;
		                 break;
		        case 60:  text = "sešdesmit "+text;
		                 break;
		        case 70:  text = "septiņdesmit "+text;
		                 break;
		        case 80:  text = "astoņdesmit "+text;
		                 break;
		        case 90:  text = "deviņdesmit "+text;
		                 break;
		        default: text = ""+text;
		                 break;
				}
				if(number>99){
					switch ((int) number %1000- (int) number %100) {
			        case 100:  text = "viens simts "+text;
			                 break;
			        case 200:  text = "divi simti "+text;
			                 break;
			        case 300:  text = "trīs simti "+text;
			                 break;
			        case 400:  text = "četri simti "+text;
			                 break;
			        case 500:  text = "pieci simti "+text;
			                 break;
			        case 600:  text = "seši simti "+text;
			                 break;
			        case 700:  text = "septiņi simti "+text;
			                 break;
			        case 800:  text = "astoņi simti "+text;
			                 break;
			        case 900:  text = "deviņi simti "+text;
			                 break;
			        default: text = ""+text;
			                 break;
					}
					if(number>999){
						if(number>9999){
							 return "Pārāk liels skaitlis!";
						}
						else{
							switch ((int) number %10000- (int) number %1000) {
							case 1000:  text = "viens tūkstotis "+text;
				                 break;
							case 2000:  text = "divi tūkstotis "+text;
				                 break;
							case 3000:  text = "trīs tūkstotis "+text;
				                 break;
							case 4000:  text = "Četri tūkstotis "+text;
				                 break;
							case 5000:  text = "pieci tūkstotis "+text;
				                 break;
							case 6000:  text = "seši tūkstotis "+text;
				                 break;
							case 7000:  text = "septiņi tūkstotis "+text;
				                 break;
							case 8000:  text = "astoņi tūkstotis "+text;
				                 break;
							case 9000:  text = "deviņi tūkstotis "+text;
				                 break;
							default: text = "";
				                 break;
							}
						}
					}
					else{
						text=text.substring(0, 1).toUpperCase() + text.substring(1)+" € "+cents;
					}
				}
				else{
					text=text.substring(0, 1).toUpperCase() + text.substring(1)+" € "+cents;
				}
			}
			else{
				if(text.equals(" ")){
					text=cents;
				}
				else{
					text=text.substring(0, 1).toUpperCase() + text.substring(1)+" € "+cents;
				}
			}
		}
		else{
			return "Negatīvi mērijumi";
		}
		return text;
	}
	
	private String getDate(){
		int day =Integer.parseInt(dateString.substring(0, 2));
		int month =Integer.parseInt(dateString.substring(3, 5));
		int year =Integer.parseInt(dateString.substring(6, 10));
        String monthString;
        switch (month) {
            case 1:  monthString = "janvāris";
                     break;
            case 2:  monthString = "februāris";
                     break;
            case 3:  monthString = "marts";
                     break;
            case 4:  monthString = "aprīlis";
                     break;
            case 5:  monthString = "maijs";
                     break;
            case 6:  monthString = "jūnijs";
                     break;
            case 7:  monthString = "jūlijs";
                     break;
            case 8:  monthString = "augusts";
                     break;
            case 9:  monthString = "septembris";
                     break;
            case 10: monthString = "oktobris";
                     break;
            case 11: monthString = "novembris";
                     break;
            case 12: monthString = "decembris";
                     break;
            default: monthString = " ";
                     break;
        }
        return year+".gada "+day+"."+monthString;
	}
	
	private String getDeliveryDates(Date date){
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date); 
        
        calendar.add(Calendar.MONTH, 0);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime(); 
        return "01"+fd.format(lastDayOfMonth).substring(2)+" - "+fd.format(lastDayOfMonth);
	}
	
	private String getDueDate(Date date){
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date); 
        
        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime(); 
        return fd.format(lastDayOfMonth);
	}
}
