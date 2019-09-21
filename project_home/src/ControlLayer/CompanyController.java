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

class CompanyController {

	CompanyController(HSSFWorkbook workbook){
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		HSSFSheet sheet = workbook.createSheet("Means");
		ArrayList<Object[]> data= new ArrayList<>();
		data.add(new Object[]{"Rēķins - Faktūra",localDate.getYear()+""+localDate.getMonthValue()});//0
		data.add(new Object[]{"Datums",DocumentController.getDate(date)});//1
		data.add(new Object[]{"","",""});//2
		data.add(new Object[]{"Preču nosūtītājs", InfoController.info.sender.name,"",""});//3
		data.add(new Object[]{"Adrese", InfoController.info.sender.address,"",""});//4
		data.add(new Object[]{"Izsniegts", InfoController.info.sender.address,"",""});//5
		data.add(new Object[]{"Norēķinu rekvizīti", InfoController.info.sender.bankName, InfoController.info.sender.code,""});//6
		data.add(new Object[]{"Norēķinu rekvizīti", InfoController.info.sender.invoice, InfoController.info.sender.info,""});//7
		data.add(new Object[]{"Preču saņēmējs", InfoController.info.receiver.name, InfoController.info.receiver.info,""});//8
		data.add(new Object[]{"Adrese", InfoController.info.receiver.address,"",""});//9
		data.add(new Object[]{"Saņemts", InfoController.info.receiver.address,"",""});//10
		data.add(new Object[]{"Piegādes datums", DocumentController.getDeliveryPeriod(date),"",""});//11
		data.add(new Object[]{"Norēķinu rekvizīti", InfoController.info.receiver.invoice,"",""});//12
		data.add(new Object[]{"Samaksas veids un kārtība:","Ar pārskaitījumu līdz "+DocumentController.getDueDate(date),"",""});//13
		data.add(new Object[]{"Mērijumi",InfoController.info.receiver.electricityStart,InfoController.info.receiver.electricityEnd,""});//14
		data.add(new Object[]{"Nosaukums","Mērvienība","Patērēts","Cena"});//15
		data.add(new Object[]{"Maksa par elektroenerģiju","Kwh",0,InfoController.info.prices.electricityRate});//16
		data.add(new Object[]{"Kopā:","","","€"});//17
		data.add(new Object[]{"","","",""});//18
		data.add(new Object[]{"","",""});//19
		data.add(new Object[]{"Izsniedza","Sintija Zaņģe","Saņēma",""});//20
		data.add(new Object[]{DocumentController.getDate(date),"",DocumentController.getDate(date).substring(0, 10),""});//21
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
	  	
	  	sheet.getRow(18).createCell(0).setCellValue(DocumentController.nameNumber((sheet.getRow(14).getCell(1).getNumericCellValue()+sheet.getRow(14).getCell(2).getNumericCellValue())*sheet.getRow(16).getCell(3).getNumericCellValue()));
	  	
	  	setStyle(sheet);
	}
	
	private void setStyle(HSSFSheet sheet){
	  	sheet.getRow(0).getCell(1).setCellStyle(DesignController.header);
	  	sheet.getRow(1).getCell(1).setCellStyle(DesignController.header);

	    sheet.getRow(20).getCell(3).setCellStyle(DesignController.underline);
	    sheet.getRow(21).getCell(3).setCellStyle(DesignController.underline);

	  	for(int x=3;x<19;x++){
	  		for(int y=0;y<4;y++){
	        	if(x==3 || x==8){
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
	        	else{ if(x==12 || x==18){
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
