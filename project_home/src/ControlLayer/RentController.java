package ControlLayer;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import ModelLayer.Tenant;

class RentController {

	RentController(HSSFWorkbook workbook, Tenant tenant){
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		HSSFSheet sheet = workbook.createSheet(tenant.name);
		ArrayList<Object[]> data= new ArrayList<>();
		data.add(new Object[]{"Rēķins - Faktūra",localDate.getYear()+""+localDate.getMonthValue()});//0
		data.add(new Object[]{"Datums",DocumentController.getDate(date)});//1
		data.add(new Object[]{"","",""});//2
		data.add(new Object[]{"Saņēmējs",tenant.name,"",""});//3
		data.add(new Object[]{"Piegādes datums",DocumentController.getDeliveryPeriod(date),"",""});//4
		data.add(new Object[]{"Elektrības skaitītāja rādījumi",tenant.electricityStart,tenant.electricityEnd,""});//5
		data.add(new Object[]{"Ūdens skaitītāja rādījumi",tenant.waterStart,tenant.waterEnd,""});//6
		data.add(new Object[]{"Kanalizācijas skaitītāja rādījumi",tenant.waterStart,tenant.waterEnd,""});//7
		data.add(new Object[]{"Nosaukums","Mērvienība","Patērēts","Cena"});//8
		data.add(new Object[]{"Elektrība","Kwh",tenant.electricityStart,InfoController.info.prices.electricityRate});//9
		data.add(new Object[]{"Ūdens","m3",tenant.waterStart,InfoController.info.prices.waterRate});//10
		data.add(new Object[]{"Kanalizācija","m3",tenant.waterStart,InfoController.info.prices.sewerageRate});//11
		data.add(new Object[]{"Telpu īre","","",tenant.rent});//12
		if (localDate.getMonthValue() < 5 || localDate.getMonthValue() > 9) {//todo add this as a option
			data.add(new Object[]{"Apkure","","",tenant.heating});//13
		} else {
			data.add(new Object[]{"Apkure","","",0.0});//13
		}
		data.add(new Object[]{"Atkritumi","","",tenant.garbage});//14
		data.add(new Object[]{"Internets","","",tenant.internet});//15
		data.add(new Object[]{"Kopā:","","","€"});//16
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
	  	sheet.getRow(17).createCell(0).setCellValue(DocumentController.nameNumber(number));
	  	
	  	setStyle(sheet);
	}
	
	private void setStyle(HSSFSheet sheet){
	  	sheet.getRow(0).getCell(1).setCellStyle(DesignController.header);
	  	sheet.getRow(1).getCell(1).setCellStyle(DesignController.header);
	  	
	  	for(int x=3;x<18;x++){
	  		for(int y=0;y<4;y++){
	        	if(x==3 || x==8 || x==4){
	        		 switch(y) {
	                 case 0 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleUpLeft);
	                    break;
	                 case 3 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleUpRight);
	                    break;
	                 default :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleUp);
	        		 }
	        	}
	        	else{ if(x==15 || x==17){
	        		 switch(y) {
	                 case 0 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleDownLeft);
	                    break;
	                 case 3 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleDownRight);
	                    break;
	                 default :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleDown);
	              }
	        	}
	        	else{
	        		 switch(y) {
	                 case 0 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleLeft);
	                    break;
	                 case 3 :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.styleRight);
	                    break;
	                 default :
	                	 sheet.getRow(x).getCell(y).setCellStyle(DesignController.style);
	              }
	        	}
	        }
	      }
	  }
	}
}
