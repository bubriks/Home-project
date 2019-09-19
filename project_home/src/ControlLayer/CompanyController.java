package ControlLayer;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

public class CompanyController {

	public CompanyController(HSSFWorkbook workbook, Design design){
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		HSSFSheet sheet = workbook.createSheet("Means");
		ArrayList<Object[]> data= new ArrayList<>();
		data.add(new Object[]{"Rēķins - Faktūra",localDate.getYear()+localDate.getMonthValue()});//0
		data.add(new Object[]{"Datums",getDate(date)});//1
		data.add(new Object[]{"","",""});//2
		data.add(new Object[]{"Preču nosūtītājs", InfoController.info.sender.name,"",""});//3
		data.add(new Object[]{"Adrese", InfoController.info.sender.address,"",""});//4
		data.add(new Object[]{"Izsniegts", InfoController.info.sender.address,"",""});//5
		data.add(new Object[]{"Norēķinu rekvizīti", InfoController.info.sender.bankName, InfoController.info.sender.code,""});//6
		data.add(new Object[]{"Norēķinu rekvizīti", InfoController.info.sender.invoice, InfoController.info.sender.info,""});//7
		data.add(new Object[]{"Preču saņēmējs", InfoController.info.receiver.name, InfoController.info.receiver.info,""});//8
		data.add(new Object[]{"Adrese", InfoController.info.receiver.address,"",""});//9
		data.add(new Object[]{"Saņemts", InfoController.info.receiver.address,"",""});//10
		data.add(new Object[]{"Piegādes datums", getDeliveryPeriod(date),"",""});//11
		data.add(new Object[]{"Norēķinu rekvizīti", InfoController.info.receiver.invoice,"",""});//12
		data.add(new Object[]{"Samaksas veids un kārtība:","Ar pārskaitījumu līdz "+getDueDate(date),"",""});//13
		data.add(new Object[]{"Mērijumi",InfoController.info.receiver.electricityStart,InfoController.info.receiver.electricityEnd,""});//14
		data.add(new Object[]{"Nosaukums","Mērvienība","Patērēts","Cena"});//15
		data.add(new Object[]{"Maksa par elektroenerģiju","Kwh",0,InfoController.info.prices.electricityRate});//16
		data.add(new Object[]{"Kopā:","","","€"});//17
		data.add(new Object[]{"","","",""});//18
		data.add(new Object[]{"","",""});//19
		data.add(new Object[]{"Izsniedza","Sintija Zaņģe","Saņēma",""});//20
		data.add(new Object[]{getDate(date),"",getDate(date).substring(0, 10),""});//21
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
	  	
	  	sheet.getRow(18).createCell(0).setCellValue(nameNumber((sheet.getRow(14).getCell(1).getNumericCellValue()+sheet.getRow(14).getCell(2).getNumericCellValue())*sheet.getRow(16).getCell(3).getNumericCellValue()));
	  	
	  	setStyle(sheet,design);
	}
	
	private void setStyle(HSSFSheet sheet,Design design){
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

	public static String nameNumber(Double number){
		String text;
		DecimalFormat f = new DecimalFormat("##.00");
		Double cent=number-number.intValue();
		String cents=f.format(cent).substring(1)+" centi";
		if(number>0){
			switch (number.intValue()%10) {
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
				default: text = "";
					break;
			}
			if(number>9){
				if(number<20) {
					switch (number.intValue()%100) {
						case 10: text = "desmit";
							break;
						case 11: text = "vienpadsmit";
							break;
						case 12: text = "divpadsmit";
							break;
						case 13: text = "trīspadsmit";
							break;
						case 14: text = "četrpadsmit";
							break;
						case 15: text = "piecpadsmit";
							break;
						case 16: text = "sešpadsmit";
							break;
						case 17: text = "septiņpadsmit";
							break;
						case 18: text = "astoņpadsmit";
							break;
						case 19: text = "deviņpadsmit";
							break;
					}
				}
				else {
					switch (number.intValue()%100-number.intValue()%10) {
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
				}
				if(number>99){
					switch (number.intValue()%1000-number.intValue()%100) {
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
							switch (number.intValue()%10000-number.intValue()%1000) {
								case 1000:  text = "viens tūkstotis "+text;
									break;
								case 2000:  text = "divi tūkstotis "+text;
									break;
								case 3000:  text = "trīs tūkstotis "+text;
									break;
								case 4000:  text = "četri tūkstotis "+text;
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
				text=text.substring(0, 1).toUpperCase() + text.substring(1)+" € "+cents;
			}
		}
		else{
			return "Negatīvi mērijumi";
		}
		return text;
	}

	public static String getDate(Date date){
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String monthString;
        switch (localDate.getMonthValue()) {
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
        return localDate.getYear()+".gada "+localDate.getDayOfMonth()+"."+monthString;
	}

	public static String getDeliveryPeriod(Date date){
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date); 

        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime();
		LocalDate localDate = lastDayOfMonth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return "01."+localDate.getMonth()+"."+localDate.getYear()+" - "+localDate.getDayOfMonth()+"."+localDate.getMonth()+"."+localDate.getYear();
	}

	public static String getDueDate(Date date){
		Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date); 
        
        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime();
		LocalDate localDate = lastDayOfMonth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.getDayOfMonth()+"."+localDate.getMonth()+"."+localDate.getYear();
	}
}
