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

import ModelLayer.Design;
import ModelLayer.Prices;
import ModelLayer.Tenant;

public class RentControler {
	
	private SimpleDateFormat fd;
	private String dateString;
	
	public RentControler(Double elstart,Double elend,Double ustart, Double uend,HSSFWorkbook workbook,Tenant tenant,Prices prices,SimpleDateFormat fd,Date date,String dateString,Design design){
		this.fd = fd;
		this.dateString=dateString;
		HSSFSheet sheet = workbook.createSheet(tenant.getName());
		ArrayList<Object[]> data=new ArrayList<Object[]>();
		data.add(new Object[]{"R��ins - Fakt�ra",dateString.substring(6, 10)+dateString.substring(3, 5)});//0
		data.add(new Object[]{"Datums",getDate()});//1
		data.add(new Object[]{"","",""});//2
		data.add(new Object[]{"Sa��m�js",tenant.getName(),"",""});//3
		data.add(new Object[]{"Pieg�des datums",getDeliveryDates(date),"",""});//4
		data.add(new Object[]{"Elektr�bas skait�t�ja r�d�jumi",elstart,elend,""});//5
		data.add(new Object[]{"�dens skait�t�ja r�d�jumi",ustart,uend,""});//6
		data.add(new Object[]{"Kanaliz�cijas skait�t�ja r�d�jumi",ustart,uend,""});//7
		data.add(new Object[]{"Nosaukums","M�rvien�ba","Pat�r�ts","Cena"});//8
		data.add(new Object[]{"Elektr�ba","Kwh",tenant.getElectricity(),prices.getElRate()});//9
		data.add(new Object[]{"�dens","m3",tenant.getWater(),prices.getUdRate()});//10
		data.add(new Object[]{"Kanaliz�cija","m3",tenant.getWater(),prices.getKaRate()});//11
		data.add(new Object[]{"Telpu �re","","",tenant.getRent()});//12
		if(date.getMonth()+1<=5 && date.getMonth()+1>=9){
			data.add(new Object[]{"Apkure","","",tenant.getHeating()});//13
		}
		else{
			data.add(new Object[]{"Apkure","","",0.0});//13
		}
		data.add(new Object[]{"Atkritumi","","",tenant.getGarbage()});//14
		data.add(new Object[]{"Internets","","",tenant.getInternet()});//15
		data.add(new Object[]{"Kop�:","","","�"});//16
		data.add(new Object[]{"","","",""});//17
		
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
	  	
	    sheet.getRow(9).getCell(2).setCellFormula("C6-B6");
	    sheet.getRow(10).getCell(2).setCellFormula("C7-B7");
	    sheet.getRow(11).getCell(2).setCellFormula("C8-B8");
	    sheet.getRow(16).getCell(1).setCellFormula("(C10*D10)+(C11*D11)+(C12*D12)+D13+D14+D15+D16");
	    
	    sheet.addMergedRegion(new CellRangeAddress(3,3,1,3));
	    sheet.addMergedRegion(new CellRangeAddress(4,4,1,3));
	    sheet.addMergedRegion(new CellRangeAddress(5,5,2,3));
	    sheet.addMergedRegion(new CellRangeAddress(6,6,2,3));
	    sheet.addMergedRegion(new CellRangeAddress(7,7,2,3));
	    sheet.addMergedRegion(new CellRangeAddress(12,12,0,2));
	    sheet.addMergedRegion(new CellRangeAddress(13,13,0,2));
	    sheet.addMergedRegion(new CellRangeAddress(14,14,0,2));
	    sheet.addMergedRegion(new CellRangeAddress(15,15,0,2));
	    sheet.addMergedRegion(new CellRangeAddress(16,16,1,2));
	    sheet.addMergedRegion(new CellRangeAddress(17,17,0,3));
	    
	    sheet.autoSizeColumn(0);
	  	sheet.setColumnWidth(1, 10000);
	  	sheet.setColumnWidth(2, 5000);
	  	sheet.setColumnWidth(3, 5000);
	  	
	  	double number=((sheet.getRow(5).getCell(2).getNumericCellValue()-sheet.getRow(5).getCell(1).getNumericCellValue())*sheet.getRow(9).getCell(3).getNumericCellValue())
	  			+((sheet.getRow(6).getCell(2).getNumericCellValue()-sheet.getRow(6).getCell(1).getNumericCellValue())*sheet.getRow(10).getCell(3).getNumericCellValue())
	  			+((sheet.getRow(7).getCell(2).getNumericCellValue()-sheet.getRow(7).getCell(1).getNumericCellValue())*sheet.getRow(11).getCell(3).getNumericCellValue())
	  			+sheet.getRow(12).getCell(3).getNumericCellValue()+sheet.getRow(13).getCell(3).getNumericCellValue()+sheet.getRow(14).getCell(3).getNumericCellValue()+sheet.getRow(15).getCell(3).getNumericCellValue();
	  	sheet.getRow(17).createCell(0).setCellValue(nameNumber(number));
	  	
	  	setStyle(workbook,sheet,design);
	}
	
	private void setStyle(HSSFWorkbook workbook,HSSFSheet sheet,Design design){
	  	sheet.getRow(0).getCell(1).setCellStyle(design.getStyle());
	  	sheet.getRow(1).getCell(1).setCellStyle(design.getStyle());
	  	
	  	for(int x=3;x<18;x++){
	  		for(int y=0;y<4;y++){
	        	if(x==3 || x==8 || x==4){
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
	        	else{ if(x==15 || x==17){
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
	
	private String nameNumber(Double number){
		String text="";
		DecimalFormat f = new DecimalFormat("##.00");
		Double cent=number-number.intValue();
		String cents=f.format(cent).substring(1)+" centi";
		if(number>0){
			switch (number.intValue()%10) {
	        case 1:  text = "viens";
	                 break;
	        case 2:  text = "divi";
	                 break;
	        case 3:  text = "tr�s";
	                 break;
	        case 4:  text = "�etri";
	                 break;
	        case 5:  text = "pieci";
	                 break;
	        case 6:  text = "se�i";
	                 break;
	        case 7:  text = "septi�i";
	                 break;
	        case 8:  text = "asto�i";
	                 break;
	        case 9:  text = "devi�i";
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
					case 13: text = "tr�spadsmit";
						break;
					case 14: text = "�etrpadsmit";
						break;
					case 15: text = "piecpadsmit";
			 			 break;
					case 16: text = "se�padsmit";
						break;
					case 17: text = "septi�padsmit";
						break;
					case 18: text = "asto�padsmit";
			 		 	 break;
					case 19: text = "devi�padsmit";
			 			 break;
					}
				}
				else {
					switch (number.intValue()%100-number.intValue()%10) {
					case 20:  text = "divdesmit "+text;
		                 break;
					case 30:  text = "tr�sdesmit "+text;
		                 break;
					case 40:  text = "�etrdesmit "+text;
		                 break;
					case 50:  text = "piecdesmit "+text;
		                 break;
					case 60:  text = "se�desmit "+text;
		                 break;
					case 70:  text = "septi�desmit "+text;
		                 break;
					case 80:  text = "asto�desmit "+text;
		                 break;
					case 90:  text = "devi�desmit "+text;
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
			        case 300:  text = "tr�s simti "+text;
			                 break;
			        case 400:  text = "�etri simti "+text;
			                 break;
			        case 500:  text = "pieci simti "+text;
			                 break;
			        case 600:  text = "se�i simti "+text;
			                 break;
			        case 700:  text = "septi�i simti "+text;
			                 break;
			        case 800:  text = "asto�i simti "+text;
			                 break;
			        case 900:  text = "devi�i simti "+text;
			                 break;
			        default: text = ""+text;
			                 break;
					}
					if(number>999){
						if(number>9999){
							 return "P�r�k liels skaitlis!";
						}
						else{
							switch (number.intValue()%10000-number.intValue()%1000) {
							case 1000:  text = "viens t�kstotis "+text;
				                 break;
							case 2000:  text = "divi t�kstotis "+text;
				                 break;
							case 3000:  text = "tr�s t�kstotis "+text;
				                 break;
							case 4000:  text = "�etri t�kstotis "+text;
				                 break;
							case 5000:  text = "pieci t�kstotis "+text;
				                 break;
							case 6000:  text = "se�i t�kstotis "+text;
				                 break;
							case 7000:  text = "septi�i t�kstotis "+text;
				                 break;
							case 8000:  text = "asto�i t�kstotis "+text;
				                 break;
							case 9000:  text = "devi�i t�kstotis "+text;
				                 break;
							default: text = "";
				                 break;
							}
						}
					}
					else{
						text=text.substring(0, 1).toUpperCase() + text.substring(1)+" � "+cents;
					}
				}
				else{
					text=text.substring(0, 1).toUpperCase() + text.substring(1)+" � "+cents;
				}
			}
			else{
				text=text.substring(0, 1).toUpperCase() + text.substring(1)+" � "+cents;
			}
		}
		else{
			return "Negat�vi m�rijumi";
		}
		return text;
	}
	
	private String getDate(){
		int day =Integer.parseInt(dateString.substring(0, 2));
		int month =Integer.parseInt(dateString.substring(3, 5));
		int year =Integer.parseInt(dateString.substring(6, 10));
        String monthString;
        switch (month) {
            case 1:  monthString = "janv�ris";
                     break;
            case 2:  monthString = "febru�ris";
                     break;
            case 3:  monthString = "marts";
                     break;
            case 4:  monthString = "apr�lis";
                     break;
            case 5:  monthString = "maijs";
                     break;
            case 6:  monthString = "j�nijs";
                     break;
            case 7:  monthString = "j�lijs";
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
}
