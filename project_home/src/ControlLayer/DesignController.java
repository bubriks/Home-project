package ControlLayer;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

@SuppressWarnings("deprecation")
class DesignController {

	static CellStyle header, underline, style, styleUp, styleUpLeft, styleUpRight, styleDown, styleDownLeft, styleDownRight, styleLeft, styleRight;

	DesignController(HSSFWorkbook workbook){
		header = workbook.createCellStyle();
		header.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		header.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		header.setAlignment(CellStyle.ALIGN_CENTER);
		header.setBorderTop((short) 2);
		header.setBorderRight((short) 2);
		header.setBorderBottom((short) 2);
		header.setBorderLeft((short) 2);

		underline = workbook.createCellStyle();
		underline.setBorderBottom((short) 1);

		style = workbook.createCellStyle();
		style.setBorderTop((short) 1);
		style.setBorderRight((short) 1);
		style.setBorderBottom((short) 1);
		style.setBorderLeft((short) 1);

		styleUp = workbook.createCellStyle();
		styleUp.setBorderTop((short) 2);
		styleUp.setBorderRight((short) 1);
		styleUp.setBorderBottom((short) 1);
		styleUp.setBorderLeft((short) 1);

		styleUpLeft = workbook.createCellStyle();
		styleUpLeft.setBorderTop((short) 2);
		styleUpLeft.setBorderRight((short) 1);
		styleUpLeft.setBorderBottom((short) 1);
		styleUpLeft.setBorderLeft((short) 2);

		styleUpRight = workbook.createCellStyle();
		styleUpRight.setBorderTop((short) 2);
		styleUpRight.setBorderRight((short) 2);
		styleUpRight.setBorderBottom((short) 1);
		styleUpRight.setBorderLeft((short) 1);

		styleDown = workbook.createCellStyle();
		styleDown.setBorderTop((short) 1);
		styleDown.setBorderRight((short) 1);
		styleDown.setBorderBottom((short) 2);
		styleDown.setBorderLeft((short) 1);

		styleDownLeft = workbook.createCellStyle();
		styleDownLeft.setBorderTop((short) 1);
		styleDownLeft.setBorderRight((short) 1);
		styleDownLeft.setBorderBottom((short) 2);
		styleDownLeft.setBorderLeft((short) 2);

		styleDownRight = workbook.createCellStyle();
		styleDownRight.setBorderTop((short) 1);
		styleDownRight.setBorderRight((short) 2);
		styleDownRight.setBorderBottom((short) 2);
		styleDownRight.setBorderLeft((short) 1);

		styleLeft = workbook.createCellStyle();
		styleLeft.setBorderTop((short) 1);
		styleLeft.setBorderRight((short) 1);
		styleLeft.setBorderBottom((short) 1);
		styleLeft.setBorderLeft((short) 2);

		styleRight = workbook.createCellStyle();
		styleRight.setBorderTop((short) 1);
		styleRight.setBorderRight((short) 2);
		styleRight.setBorderBottom((short) 1);
		styleRight.setBorderLeft((short) 1);
	}
}
