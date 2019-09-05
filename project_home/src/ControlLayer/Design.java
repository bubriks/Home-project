package ControlLayer;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

@SuppressWarnings("deprecation")
public class Design {

	private HSSFWorkbook workbook;

	public Design(HSSFWorkbook workbook){
		this.workbook = workbook;
	}

	CellStyle getStyle(){
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setBorderTop((short) 2);
		style.setBorderRight((short) 2);
		style.setBorderBottom((short) 2);
		style.setBorderLeft((short) 2);
		return style;
	}

	CellStyle getStyle2(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom((short) 1);
		return style;
	}

	CellStyle getDesign(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 1);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 1);
		return style;
	}

	CellStyle getDesignUp(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 2);
		style.setBorderRight((short) 1);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 1);
		return style;
	}

	CellStyle getDesignUpLeft(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 2);
		style.setBorderRight((short) 1);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 2);
		return style;
	}

	CellStyle getDesignUpRight(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 2);
		style.setBorderRight((short) 2);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 1);
		return style;
	}

	CellStyle getDesignDown(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 1);
		style.setBorderBottom((short) 2);
		style.setBorderLeft((short) 1);
		return style;
	}

	CellStyle getDesignDownLeft(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 1);
		style.setBorderBottom((short) 2);
		style.setBorderLeft((short) 2);
		return style;
	}

	CellStyle getDesignDownRight(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 2);
		style.setBorderBottom((short) 2);
		style.setBorderLeft((short) 1);
		return style;
	}

	CellStyle getDesignLeft(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 1);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 2);
		return style;
	}

	CellStyle getDesignRight(){
		CellStyle style = workbook.createCellStyle();
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 2);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 1);
		return style;
	}
}
